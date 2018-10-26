package com.jcl.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jcl.controller.SubzhfundController;
import com.jcl.dao.FundOrderMapper;
import com.jcl.dao.SptMapper;
import com.jcl.dao.SubzhMapper;
import com.jcl.pojo.FundOrder;
import com.jcl.pojo.FundOrderExample;
import com.jcl.pojo.Spt;
import com.jcl.pojo.SptExample;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhExample;
import com.jcl.pojo.SubzhExample.Criteria;
import com.jcl.pojo.SubzhFundLog;
import com.jcl.service.PayService;
import com.jcl.service.SubzhFundLogService;
import com.jcl.service.UserInfoDataService;
import com.jcl.util.Constant;
import com.jcl.util.DateUtil;
import com.jcl.util.DeployProperties;
import com.jcl.util.spt.HttpRequest;
import com.jcl.util.spt.SignMd5Utils;
import com.jcl.vo.Payroll;

@Service
public class PayServiceImpl implements PayService {
	public static Logger log = Logger.getLogger(PayServiceImpl.class);

	@Autowired
	private SubzhMapper subzhmapper;
	@Autowired
	private SptMapper sptmapper;
	@Autowired
	private SubzhFundLogService subzhFundLogService;
	
	@Autowired
	private FundOrderMapper orderMapper;
	
	@Autowired
	private UserInfoDataService userInfoDataService;
	
	private static final String project_path = DeployProperties.getInstance().getPublicProjectePath();
	
	//提现接口
	@Override
	public String paya(Payroll payroll, HttpSession session) {
		String subzh = (String) session.getAttribute(Constant.SESSION_LOGINNAME);


		if (subzh == null)
			return "用户不存在";

		SubzhExample ex = new SubzhExample();
		Criteria cca = ex.createCriteria();
		cca.andSubzhEqualTo(subzh);
		List<Subzh> sublist = subzhmapper.selectByExample(ex);
		if (sublist == null && sublist.size() != 1) {
			return "查询出多个用户信息";
		}
		Subzh sub = sublist.get(0);
		if (sub == null)
			return "用户不存在";
		if (sub.getXzj() == null)
			return "余额不足";
		if (sub.getXzj().doubleValue() - Double.valueOf(payroll.getAmount()) < 0) {
			return "余额不足";
		}
		
		subzhFundLogService.selectByOrder(payroll.getOrderno());

		SubzhExample subex = new SubzhExample();
		Criteria ccas = subex.createCriteria();
		ccas.andSubzhEqualTo(subzh);
		List<Subzh> sublist0 = subzhmapper.selectByExample(subex);
		if (sublist0 != null && sublist0.size() == 1) {
			Subzh subzh0 = sublist0.get(0);
			if (subzh0.getXzj() != null) {
				subzh0.setXzj(subzh0.getXzj().subtract(BigDecimal.valueOf(Double.valueOf(payroll.getAmount()))));
			} else {
				subzh0.setXzj(BigDecimal.valueOf(Double.valueOf(payroll.getAmount())));
			}
			if (subzh0.getRzj() != null) {
				subzh0.setRzj(subzh0.getRzj().subtract(BigDecimal.valueOf(Double.valueOf(payroll.getAmount()))));
			} else {
				subzh0.setRzj(BigDecimal.valueOf(Double.valueOf(payroll.getAmount())));
			}

			int st = subzhmapper.updateByPrimaryKeySelective(subzh0);
			if(st>0){
				log.info("提现扣除客户账上可用资金成功");
				int num=saveFundOrder(payroll,subzh);
				if(num<1) {
					return "提现扣除用户可用资金失败";
				}
			}
		}
		return "ok";
	}
	
	
	private int saveFundOrder(Payroll payroll,String subzh) {
		FundOrder fo = new FundOrder();
		int num =0;
		try {
			Map<String, Object> channelmap = new HashMap<String, Object>();
			channelmap.put("subzh", subzh);	
			List<Subzh> subzhList = userInfoDataService.userLogin(channelmap);// 得到经纪人编号
			if (subzhList == null || subzhList.size() == 0) {
				log.info("查询用户失败");
				return 0;
			}

			fo.setSubzh(subzh);
			fo.setZjUse("2");//提现
			fo.setZjType("1");
			fo.setPaymentzh(payroll.getOrderno());
			fo.setKhName(subzhList.get(0).getName());
			fo.setCkBank(payroll.getCardno());
			fo.setSkName(payroll.getCardname());
			fo.setSkBank(payroll.getBankname());
			fo.setFund(new BigDecimal(payroll.getAmount()));
			fo.setOverTime(DateUtil.getSystemDate());
			fo.setStatus("0");// 0 提现申请 1通过 2 拒绝 3 成功 4 失败 
			fo.setCreateTime(DateUtil.getSystemDate());
			fo.setPhone(subzhList.get(0).getPhone());
			fo.setRemarkName(subzhList.get(0).getName());
			fo.setRemarkPhone(subzhList.get(0).getPhone());
			num = subzhFundLogService.saveFundOrder(fo);
		} catch (Exception e) {
			log.error("保存提现订单信息异常", e);
		}
		return num;
	}


	//提现回调
	@Override
	public String isPay(HttpServletRequest request, Model model, JSONObject allStr) {
	
		TreeMap<String, String> sortedMap = new TreeMap();
		sortedMap.put("order_no", allStr.getString("order_no"));
		sortedMap.put("total_fee", allStr.getString("total_fee"));
		sortedMap.put("merch_id", allStr.getString("merch_id"));
		sortedMap.put("settle_status", allStr.getString("settle_status"));
		sortedMap.put("return_code", allStr.getString("return_code"));
		sortedMap.put("settle_no", allStr.getString("settle_no"));
		String camparesign = SignMd5Utils.createSign(sortedMap, Constant.SPT_SECRTKEY);
		if (allStr.getString("sign").equals(camparesign)){
			
			List<SubzhFundLog> flist=subzhFundLogService.selectByOrder(allStr.getString("order_no"));
			SubzhFundLog fu=new SubzhFundLog();
			if(flist!=null&&flist.size()>0) {
				fu = flist.get(0);
			}
						
			FundOrderExample fundOrderExample=new FundOrderExample();
			com.jcl.pojo.FundOrderExample.Criteria createCriteria = fundOrderExample.createCriteria();
			createCriteria.andPaymentzhEqualTo(allStr.getString("order_no"));
			List<FundOrder> folist = orderMapper.selectByExample(fundOrderExample);
			if (folist != null && folist.size() == 1) {
				FundOrder fundOrder=folist.get(0);
				orderMapper.updateByPrimaryKeySelective(fundOrder); 
				if("3".equals(fundOrder.getStatus())) {
					if ("SUCCESS".equals(allStr.getString("return_code"))) {
						if("00000".equals(allStr.getString("settle_status"))) {
							fundOrder.setStatus("4");
							fu.setStatus(new Byte("1"));
							orderMapper.updateByPrimaryKeySelective(fundOrder);
						}else {
							int num=0;
							if("10000".equals(allStr.getString("settle_status"))) {
								log.info("提现失败");
								fundOrder.setStatus("5");
								orderMapper.updateByPrimaryKeySelective(fundOrder);
							}else if("20000".equals(allStr.getString("settle_status"))){
								log.info("正在提现");
							}else if("30000".equals(allStr.getString("settle_status"))){
								log.info("提交失败");
								fundOrder.setStatus("5");
								orderMapper.updateByPrimaryKeySelective(fundOrder);
							}else if("40000".equals(allStr.getString("settle_status"))){
								log.info("状态未知");
								fundOrder.setStatus("5");
								orderMapper.updateByPrimaryKeySelective(fundOrder);
							}else if("50000".equals(allStr.getString("settle_status"))){
								log.info("订单不存在");
								fundOrder.setStatus("5");
								orderMapper.updateByPrimaryKeySelective(fundOrder);
							}
							log.info("updateByPrimaryKeySelective   :"+num);
						}
					} else if ("FAIL".equals(allStr.getString("return_code"))) {
						fundOrder.setStatus("5");
						orderMapper.updateByPrimaryKeySelective(fundOrder);						
					}
					//当订单表为5说明提现失败，把提现金额加到客户账户上	
					if("5".equals(fundOrder.getStatus())){
						log.info("提现失败—将提现金额返回到客户账上--"+  fundOrder.getStatus());
						SubzhExample subex = new SubzhExample();
						Criteria ccas = subex.createCriteria();
						ccas.andSubzhEqualTo(fundOrder.getSubzh());
						List<Subzh> sublist = subzhmapper.selectByExample(subex);
					
						if (sublist != null && sublist.size() == 1) {
							
							Subzh subzh = sublist.get(0);
							if (subzh.getXzj() != null) {
								subzh.setXzj(subzh.getXzj()
										.add(fundOrder.getFund()));
							} else {
								subzh.setXzj(fundOrder.getFund());
							}
							
							if (subzh.getRzj() != null) {
								subzh.setRzj(subzh.getRzj()
										.add(fundOrder.getFund()));
							} else {
								subzh.setRzj(fundOrder.getFund());
							}
							int i = subzhmapper.updateByPrimaryKeySelective(subzh);
							log.info("修改subzh  :" + i);
						}
					}
				}
			}
			int j = subzhFundLogService.updateFundlog(fu);
			
			log.info("   修改subzhfundlog   : "+ j);
		}
		return null;
	}

	@Override
	public void isCheckPaySpt(String username) {
		String url = "http://gw.spt-pay.cn/settle/query";
		String testKey = Constant.SPT_SECRTKEY;// 秘钥
		
		if(username!=null&&username!="") {
			SubzhExample subex = new SubzhExample();
			Criteria cca = subex.createCriteria();
			cca.andSubzhEqualTo(username);
			List<Subzh> list = subzhmapper.selectByExample(subex);
			if(list!=null&&list.size()==1) {
				Subzh subzh = list.get(0);
				
				SptExample sptex = new SptExample();
				com.jcl.pojo.SptExample.Criteria ca = sptex.createCriteria();
				ca.andSubzhEqualTo(username);
				ca.andStateEqualTo("0");
				List<Spt> sptlist = sptmapper.selectByExample(sptex);
				if(sptlist!=null&&sptlist.size()>0) {
					for (Spt spt : sptlist) {
						TreeMap<String, String> sortedMap = new TreeMap();
						sortedMap.put("merch", Constant.SPT_MERCHART);
						sortedMap.put("orderno", spt.getMerch());
						String key_sign_zn = SignMd5Utils.createSign(sortedMap, testKey);// 签名
						sortedMap.put("sign", key_sign_zn);
						sortedMap.put("signtype", "MD5");
						String result = HttpRequest.sendPost(url, sortedMap);
						if(result!=null&&result!="") 
						{
							JSONObject allStr = JSONObject.parseObject(result);
										
								if("SUCCESS".equals(allStr.getString("return_code"))) {
									if("00000".equals(allStr.getString("settle_status"))) {
										//成功
										spt.setState("1");
										sptmapper.updateByPrimaryKey(spt);
									}
									if("10000".equals(allStr.getString("settle_status"))) {
										//失败
										spt.setState("2");
										sptmapper.updateByPrimaryKey(spt);
										
										if (subzh.getXzj() != null) {
											subzh.setXzj(subzh.getXzj()
													.add(spt.getCoin()));
										} else {
											subzh.setXzj(spt.getCoin());
										}
										
										if (subzh.getRzj() != null) {
											subzh.setRzj(subzh.getRzj()
													.add(spt.getCoin()));
										} else {
											subzh.setRzj(spt.getCoin());
										}
									}
								}
						}
					}
					subzhmapper.updateByPrimaryKeySelective(subzh);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		List<Subzh> list = null ;
		List<Subzh> list1 = new ArrayList<Subzh>() ;
		System.out.println(list);
		System.out.println(list1.size());
		Map<String,Object> map = new HashMap<String,Object>();
		CollectionUtils.isEmpty(map);
		if(CollectionUtils.isEmpty(list1)){
			
			System.out.println(list1.isEmpty());
		}
	}
}
