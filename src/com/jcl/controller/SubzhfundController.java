package com.jcl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jcl.dao.SptMapper;
import com.jcl.dao.SubzhMapper;
import com.jcl.pojo.FundOrder;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhFundLog;
import com.jcl.service.PayService;
import com.jcl.service.SubzhFundLogService;
import com.jcl.service.UserInfoDataService;
import com.jcl.util.Constant;
import com.jcl.util.DateUtil;
import com.jcl.util.DeployProperties;
import com.jcl.util.StringUtil;
import com.jcl.util.spt.HttpRequest;
import com.jcl.util.spt.SignMd5Utils;
import com.jcl.vo.Payroll;

@Controller
@RequestMapping("/subzhfund")
public class SubzhfundController {

	public static Logger log = Logger.getLogger(SubzhfundController.class);

	@Autowired
	private SubzhFundLogService subzhFundLogService;
	@Autowired
	private UserInfoDataService userInfoDataService;
	
	@Autowired
	private SubzhMapper subzhmapper;
	@Autowired
	private SptMapper sptmapper;
	@Autowired
	private PayService payservice;

	private static final String project_path = DeployProperties.getInstance().getPublicProjectePath();

	/**
	 * 
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/recharge")
	@ResponseBody
	public Map<String, Object> recharge(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		String username = request.getParameter("username");
		if (StringUtil.isAnyNullOrEmpty(username)) {
			resultMap.put("code", "1");
			resultMap.put("message", "用户参数为空");
			return resultMap;
		}
		String bankaccname = request.getParameter("bankaccname");
		String bankcardNum = request.getParameter("bankcardNum");
		String bankflownum = request.getParameter("bankflownum");
		String txmoney = request.getParameter("txmoney");
		BigDecimal btxmoney = new BigDecimal(txmoney);
		SubzhFundLog sfl = new SubzhFundLog();
		sfl.setStatus(new Byte("0"));// 0 未审核 1成功 2 失败

		Date date = new Date();
		sfl.setModifytime(date);
		sfl.setSubzh(username);
		sfl.setBz(new Byte("2"));
		sfl.setType("6");
		sfl.setBankaccname(bankaccname);
		sfl.setBankcardnum(bankcardNum);
		sfl.setBankflownum(bankflownum);
		sfl.setAfterfund(btxmoney);

		FundOrder fo = new FundOrder();
		fo.setSubzh(username);
		fo.setZjUse("1");
		fo.setZjType("1");
		fo.setPaymentzh(bankcardNum);
		fo.setKhName(bankaccname);
		fo.setFund(btxmoney);
		fo.setOverTime(date);
		fo.setStatus("0");
		fo.setCreateTime(date);
		fo.setModifiedTime(date);

		Map<String, Object> channelmap = new HashMap<String, Object>();
		channelmap.put("subzh", username);
		channelmap.put("isadmin", 4);
		List<Subzh> subzhList = userInfoDataService.userLogin(channelmap);// 得到经纪人编号
		if (subzhList == null || subzhList.size() == 0) {
			resultMap.put("code", "1");
			resultMap.put("message", "用户不存在");
			return resultMap;
		}
		if (subzhList != null && subzhList.size() > 0) {
			channelmap.put("subzh", subzhList.get(0).getPagentzh());
			channelmap.put("isadmin", 2);// 经纪人
			fo.setPhone(subzhList.get(0).getPhone());
			fo.setRemarkName(subzhList.get(0).getName());
			fo.setRemarkPhone(subzhList.get(0).getPhone());
			sfl.setName(subzhList.get(0).getPhone());
			List<Subzh> agentList = userInfoDataService.userLogin(channelmap);// 得到经纪人数据
			if (agentList != null && agentList.size() > 0) {
				sfl.setAgentzh(agentList.get(0).getName());

				channelmap.put("subzh", agentList.get(0).getPagentzh());
				channelmap.put("isadmin", 3);// 渠道
				List<Subzh> channelList = userInfoDataService.userLogin(channelmap);// 得到渠道数据
				if (channelList != null && channelList.size() > 0) {
					sfl.setReason(channelList.get(0).getName());
				}
			}
		} else {
			resultMap.put("code", "1");
			resultMap.put("message", "用户不存在");
			return resultMap;
		}
		StringBuffer strBuffer = new StringBuffer("充值，充值金额:");
		strBuffer.append("费用-可用资金:").append(btxmoney);
		sfl.setDescription(strBuffer.toString());

		int i = subzhFundLogService.saveFundOrder(fo);
		if (i > 0) {
			resultMap.put("code", 0);
			resultMap.put("message", "提交成功,请等待审核!");
		} else {
			resultMap.put("code", 1);
			resultMap.put("message", "提交失败");
		}
		return resultMap;
	}

	@RequestMapping(value = "/isPay")
	@ResponseBody
	public String isPay(HttpServletRequest request, Model model, @RequestBody String requestBody) {
		try {
			log.info("出金回调");
			log.info("requestBody   ： " + requestBody);
			JSONObject allStr = JSONObject.parseObject(requestBody);
			String msg=	payservice.isPay(request,model,allStr);
			
		} catch (Exception e) {
			log.info("提现异步异常:"+e);
		}
		
		return null;
	}

	@RequestMapping(value = "/query")
	@ResponseBody
	public String query() {
		String url = "http://gw.spt-pay.cn/settle/query";
		String testKey = Constant.SPT_SECRTKEY;// 秘钥
		TreeMap<String, String> sortedMap = new TreeMap();
		sortedMap.put("merch", Constant.SPT_MERCHART);
		sortedMap.put("orderno", "baedadfc70e84a20aff8057d7c27fa33");
		String key_sign_zn = SignMd5Utils.createSign(sortedMap, testKey);// 签名
		sortedMap.put("signtype", "MD5");
		sortedMap.put("sign", key_sign_zn);

		String result = HttpRequest.sendPost(url, sortedMap);
		System.out.println("返回查询结果==============" + result);
		return "";
	}
	
	//提现--黑马策略
	@RequestMapping(value = "/paya",produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String paya(Payroll payroll, HttpSession session) {
		String subzh = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
		try {
			String dates = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
			String orderno=dates + StringUtil.getRandomString(4)+subzh;
			payroll.setOrderno(orderno);
			SubzhFundLog agentzhfundLog=new SubzhFundLog();
			agentzhfundLog.setName(payroll.getCardname());//开户人姓名
			agentzhfundLog.setBankaccname(payroll.getBankname());//开户银行
			agentzhfundLog.setBankcardnum(payroll.getCardno());//银行卡号
			agentzhfundLog.setBankcode(payroll.getBankcode());//银行编号
			agentzhfundLog.setCity(payroll.getCity());//开户市
			agentzhfundLog.setProvince(payroll.getProvince());//开户省
			agentzhfundLog.setOpenbankname(payroll.getBankbranch());//开户所在分行
			agentzhfundLog.setIdcard(payroll.getCertid());//身份证号
			agentzhfundLog.setPhoneNum(payroll.getCardmobile());
			saveAgentzhfundLog(agentzhfundLog, subzh, orderno, new Date(), new BigDecimal(payroll.getAmount()), 0, 2);
			
			//根据提现的用户账号和当前时间去判断用户今天的提现次数是否大于五个
			List<SubzhFundLog> slist=subzhFundLogService.selectBySubzh(subzh);
			
			
			
			if(slist!=null&&slist.size()>4){
				return "result每日提现次数最多五次，您已超过次数";
			}
			log.info("账户"+subzh+"今天已提现"+slist.size());
			List<FundOrder> list =subzhFundLogService.selectfundorderBysubzhor(subzh);
			if(list!=null&&list.size()>0) {
				log.info("账户"+subzh+"提现处理中的条数："+list.size());
				return "result您上一笔提现订单正在处理中，请在上一笔提现到账后再操作";
			}
			
			
			 List<SubzhFundLog> flist = subzhFundLogService.selectByOrder(orderno);
			 String msg="";
			 if(flist!=null&&flist.size()==1) {
				 msg=payservice.paya(payroll,session); 
			 }else{
				 msg="订单信息不存在或订单号重复"; 
			 }
			 
			log.info("提现记录=>"+msg);
			return msg;
		} catch (Exception e) {
			log.info("提现记录异常=>"+e.getMessage());
			return "result提现失败";
		}	
	}

	/**
	 * 提现
	 * 
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/incarnate")
	@ResponseBody
	public Map<String, Object> incarnate(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		String username = request.getParameter("username");
		if (StringUtil.isAnyNullOrEmpty(username)) {
			resultMap.put("code", "1");
			resultMap.put("message", "用户参数为空");
			return resultMap;
		}
		String bankaccname = request.getParameter("bankaccname");
		String bankcardNum = request.getParameter("bankcardNum");
		String openbankname = request.getParameter("openbankname");
		String txmoney = request.getParameter("txmoney");
		BigDecimal btxmoney = new BigDecimal(txmoney);
		// SubzhFundLog sfl = new SubzhFundLog();
		// sfl.setStatus(new Byte("0"));//0 未审核 1成功 2 失败
		Date date = new Date();

		FundOrder fo = new FundOrder();
		fo.setSubzh(username);
		fo.setZjUse("2");
		fo.setZjType("1");
		fo.setPaymentzh(bankcardNum);
		fo.setKhName(bankaccname);
		fo.setFund(btxmoney);
		fo.setOverTime(date);
		fo.setStatus("0");
		fo.setCreateTime(date);
		fo.setModifiedTime(date);

		Map<String, Object> channelmap = new HashMap<String, Object>();
		channelmap.put("subzh", username);
		channelmap.put("isadmin", 4);
		List<Subzh> subzhList = userInfoDataService.userLogin(channelmap);// 得到经纪人编号
		if (subzhList == null || subzhList.size() == 0) {
			resultMap.put("code", "1");
			resultMap.put("message", "用户不存在");
			return resultMap;
		}
		if (subzhList != null && subzhList.size() > 0) {
			if (subzhList.get(0).getXzj() == null) {
				resultMap.put("code", "1");
				resultMap.put("message", "提现金额超过可用余额");
				return resultMap;
			}
			BigDecimal bj = subzhList.get(0).getXzj();
			if (btxmoney.compareTo(bj) == 1) {
				resultMap.put("code", "1");
				resultMap.put("message", "提现金额超过可用余额");
				return resultMap;
			}
			channelmap.put("subzh", subzhList.get(0).getPagentzh());
			channelmap.put("isadmin", 2);// 经纪人
			// sfl.setName(subzhList.get(0).getPhone());
			fo.setPhone(subzhList.get(0).getPhone());
			fo.setRemarkName(subzhList.get(0).getName());
			fo.setRemarkPhone(subzhList.get(0).getPhone());
			List<Subzh> agentList = userInfoDataService.userLogin(channelmap);// 得到经纪人数据
			if (agentList != null && agentList.size() > 0) {
				// sfl.setAgentzh(agentList.get(0).getName());

				channelmap.put("subzh", agentList.get(0).getPagentzh());
				channelmap.put("isadmin", 3);// 渠道
				List<Subzh> channelList = userInfoDataService.userLogin(channelmap);// 得到渠道数据
				if (channelList != null && channelList.size() > 0) {
					// sfl.setReason(channelList.get(0).getName());
				}
			}
		} else {
			resultMap.put("code", "1");
			resultMap.put("message", "用户不存在");
			return resultMap;
		}
		StringBuffer strBuffer = new StringBuffer("提现，提现金额:");
		strBuffer.append("费用-可用资金:").append(btxmoney);
		// sfl.setDescription(strBuffer.toString());

		int i = subzhFundLogService.saveFundOrder(fo);
		if (i > 0) {
			resultMap.put("code", 0);
			resultMap.put("message", "提交成功,请等待审核!");
		} else {
			resultMap.put("code", 1);
			resultMap.put("message", "提交失败");
		}
		return resultMap;
	}

	/**
	 * 查询资金明细
	 * 
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/getFundInfoList")
	@ResponseBody
	public Map<String, Object> getFundInfoList(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String username = request.getParameter("username");
		String zjuse = request.getParameter("zjuse");
		FundOrder fo = new FundOrder();
		fo.setSubzh(username);
		fo.setZjUse(zjuse);
		List<FundOrder> list = subzhFundLogService.getFundInfoList(fo);
		resultMap.put("fundorderlist", list);
		resultMap.put("code", "0");
		resultMap.put("message", "查询成功");
		return resultMap;
	}

	/**
	 * 快捷支付收银台
	 * 
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/payMent")
	public String payMent(HttpServletRequest request, Model model) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String dates = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		String username = request.getParameter("username");// 用户编号
		String Amonut = request.getParameter("txmoney"); // 元
		BigDecimal money = new BigDecimal(Amonut);
		money = money.multiply(new BigDecimal("100")).setScale(0);

		String url = Constant.SPT_UNION_PAY_URL;
		String testKey = Constant.SPT_SECRTKEY;// 秘钥

		Map<String, String> payMap = new HashMap<String, String>();
		// 必填参数
		payMap.put("merch", Constant.SPT_MERCHART);// 商户号
		payMap.put("userid", username);// 用户标识
		payMap.put("orderno", username + dates + StringUtil.getRandomString(4)); // 商户订单号，查询时需要

		payMap.put("amount", money.toString()); // 金额，单位分
		payMap.put("body", "充值");// 商品描述


		payMap.put("certid", "");// 身份证号
		payMap.put("cardno", "");// 银行卡号
		payMap.put("cardname", "");// 银行卡账户名称
		payMap.put("cardmobile", "");// 银行预留手机号

		payMap.put("notifyurl", project_path + "/subzhfund/returnSptPayMent");// 异步回调通知地址
		payMap.put("backurl", project_path + "/stockoption/stockoptionJump?str=fundpc");// 异步回调通知地址

		payMap.put("comment", username);// 附加信息
		String sign = SignMd5Utils.createSign(payMap, testKey);// 签名
		payMap.put("sign", sign);// 签名串
		payMap.put("signtype", "MD5");

		model.addAttribute("payMap", payMap);
		model.addAttribute("url", url);
		return "stock/payMent";
	}

	/**
	 * spt银联h5---黑马策略
	 * 
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/payMentFive")
	public String payMentFive(HttpServletRequest request, Model model) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String username = request.getParameter("username");// 用户编号
		String Amonut = request.getParameter("txmoney"); // 元
		String channel = request.getParameter("channel"); // 元
		BigDecimal money = new BigDecimal(Amonut);
		money = money.multiply(new BigDecimal("100")).setScale(0);

		String url = Constant.SPT_H5_PAY_URL;

		String dates = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		
		
		String testKey = Constant.SPT_SECRTKEY;// 秘钥

		Map<String, String> payMap = new HashMap<String, String>();
		// 必填参数
		payMap.put("merch", Constant.SPT_MERCHART);// 商户号
		String orderno=dates + StringUtil.getRandomString(4)+username;
		payMap.put("orderno",orderno); // 商户订单号，查询时需要

		payMap.put("amount", money.toString()); // 金额，单位分
		payMap.put("body", "充值");// 商品描述

		payMap.put("notifyurl",project_path+ "/subzhfund/returnSptPayMent");// 异步回调通知地址
		payMap.put("pageurl", project_path+ "/subzhfund/stockoptionJump");// 异步回调通知地址
		payMap.put("biztype", channel);// 通道类型
		payMap.put("createip", "");// 通道类型为wx时 填写客户端ip
		
		payMap.put("comment", username);// 附加信息
		String sign = SignMd5Utils.createSign(payMap, testKey);// 签名
		payMap.put("sign", sign);// 签名串
		payMap.put("signtype", "MD5");
		
		SubzhFundLog agentzhfundLog = new SubzhFundLog();
		saveAgentzhfundLog(agentzhfundLog, username, orderno, new Date(),money, 1, 1);
		

		model.addAttribute("payMap", payMap);
		model.addAttribute("url", url);
		return "stock/payMentFive";
	}
	
	//成功页面
	@RequestMapping("/stockoptionJump")
	public String stockoptionJump() {
		
		return "stock/callback";	
	}
	
	/**
	 * spt银联网关充值
	 * 
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/payMentWG")
	public String payMentWG(HttpServletRequest request, Model model) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String dates = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		String username = request.getParameter("username");// 用户编号
		String Amonut = request.getParameter("txmoney"); // 元
		BigDecimal money = new BigDecimal(Amonut);
		money = money.multiply(new BigDecimal("100")).setScale(0);

		String url = Constant.SPT_WG_PAY_URL;
		String testKey = Constant.SPT_SECRTKEY;// 秘钥

		Map<String, String> payMap = new HashMap<String, String>();
		// 必填参数
		payMap.put("merch", Constant.SPT_MERCHART);// 商户号
		payMap.put("orderno", username + dates + StringUtil.getRandomString(4)); // 商户订单号，查询时需要

		payMap.put("amount", money.toString()); // 金额，单位分
		payMap.put("tranchannel", "CMB"); // 银行渠道编码
		payMap.put("body", "充值");// 商品描述

		payMap.put("pageurl", project_path + "/stockoption/stockoptionJump?str=fundpc");// 异步回调通知地址
		payMap.put("notifyurl", project_path + "/subzhfund/returnSptPayMent");// 异步回调通知地址
		
		payMap.put("comment", username);// 附加信息
		String sign = SignMd5Utils.createSign(payMap, testKey);// 签名
		payMap.put("sign", sign);// 签名串
		payMap.put("signtype", "MD5");

		model.addAttribute("payMap", payMap);
		model.addAttribute("url", url);
		return "stock/payMentWG";
	}
	
	/**
	 * spt入金回调---黑马策略
	 * 
	 * @param id
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/returnSptPayMent")
	public String returnSptPayMent(HttpServletRequest request, HttpSession session, @RequestBody String requestBody) {
		log.info("入金回调开始   ： " +System.currentTimeMillis());
		log.info("requestBody:" + JSONObject.parseObject(requestBody));
		JSONObject allStr =  JSONObject.parseObject(requestBody);
		String return_code = allStr.getString("return_code");
		String return_msg = allStr.getString("return_msg");
		String merch_id = allStr.getString("merch_id");
		String trade_no = allStr.getString("trade_no");
		String order_no = allStr.getString("order_no");
		Integer total_fee = allStr.getInteger("total_fee");
		String pay_time = allStr.getString("pay_time");
		if (!"SUCCESS".equals(return_code)) {
			log.info("支付失败信息return_msg：" + return_msg);
			return null;
		}
		log.info("order_no：" + order_no);
		BigDecimal btxmoney = new BigDecimal(total_fee);
		btxmoney = btxmoney.divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP);
		log.info("btxmoney：" + btxmoney);
		String username="";
		List<SubzhFundLog> flist = subzhFundLogService.selectByOrder(order_no);
		SubzhFundLog sfl=new SubzhFundLog();
		if(flist!=null&&flist.size()>0) {
			sfl = flist.get(0);
			if(sfl!=null&&!StringUtil.isAllNullOrEmpty(sfl.getSubzh())) {
				username = sfl.getSubzh();
			}
		}
	
		log.info("username：" + username);
		try {
			sfl.setStatus(new Byte("1"));// 0 未审核 1成功 2 失败
			Date date = new Date();
			sfl.setModifytime(date);
			sfl.setSubzh(username);
			sfl.setBz(new Byte("2"));
			sfl.setType("6");
			sfl.setBankaccname("");
			sfl.setBankflownum(order_no);
			sfl.setAfterfund(btxmoney);

			FundOrder fo = new FundOrder();
			fo.setSubzh(username);
			fo.setZjUse("1");
			fo.setZjType("1");
			fo.setPaymentzh(order_no);
			fo.setKhName("");
			fo.setFund(btxmoney);
			fo.setOverTime(date);
			fo.setStatus("1");
			fo.setCreateTime(date);
			fo.setModifiedTime(date);

			List<FundOrder> foList = subzhFundLogService.getFundInfoList(fo);
			if (foList != null && foList.size() > 0) {
				return null;
			}

			Map<String, Object> channelmap = new HashMap<String, Object>();
			channelmap.put("subzh", username);
			//channelmap.put("isadmin", 4);
			List<Subzh> subzhList = userInfoDataService.userLogin(channelmap);// 得到经纪人编号
			if (subzhList == null || subzhList.size() == 0) {
				log.info("查询用户失败");
				return null;
			}
			if (subzhList != null && subzhList.size() > 0) {
				BigDecimal xzj = subzhList.get(0).getXzj();
				BigDecimal rzj = subzhList.get(0).getRzj();
				log.info("xzj金额：" + xzj);
				log.info("rzj金额：" + rzj);
				if (xzj != null) {
					xzj = xzj.add(btxmoney);
				} else {
					xzj = btxmoney;
				}
				if (rzj != null) {
					rzj = rzj.add(btxmoney);
				} else {
					rzj = btxmoney;
				}
				subzhList.get(0).setXzj(xzj);
				subzhList.get(0).setRzj(rzj);
				log.info("充值后xzj金额：" + xzj);
				log.info("充值后rzj金额：" + rzj);
				try {
					userInfoDataService.updateUserInfoData(subzhList.get(0));
				} catch (Exception e) {
					log.info("更新账户资金失败", e);
				}
				channelmap.put("subzh", subzhList.get(0).getPagentzh());
				channelmap.put("isadmin", 2);// 经纪人
				fo.setPhone(subzhList.get(0).getPhone());
				fo.setRemarkName(subzhList.get(0).getName());
				fo.setRemarkPhone(subzhList.get(0).getPhone());
				sfl.setName(subzhList.get(0).getPhone());
				List<Subzh> agentList = userInfoDataService.userLogin(channelmap);// 得到经纪人数据
				if (agentList != null && agentList.size() > 0) {
					sfl.setAgentzh(agentList.get(0).getName());

					channelmap.put("subzh", agentList.get(0).getPagentzh());
					channelmap.put("isadmin", 3);// 渠道
					List<Subzh> channelList = userInfoDataService.userLogin(channelmap);// 得到渠道数据
					if (channelList != null && channelList.size() > 0) {
						sfl.setReason(channelList.get(0).getName());
					}
				}
			} else {
				log.info("用户不存在");
			}
			StringBuffer strBuffer = new StringBuffer("充值，充值金额:");
			strBuffer.append("费用-可用资金:").append(btxmoney);
			sfl.setDescription(strBuffer.toString());

			log.info("插入资金流水笔" + subzhFundLogService.saveFundOrder(fo));
			log.info("修改资金流信息" + subzhFundLogService.updateFundlog(sfl));

		} catch (Exception e) {
			log.error("异步返回支付信息失败", e);
		}
		return null;
	}

	/**
	 * 第三方入金返回
	 * 
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/returnPayMent")
	@ResponseBody
	public Map<String, Object> returnPayMent(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			// 获取xml
			String resultXml = request.getParameter("paymentResult");
			log.info("resultXml========================>>:" + resultXml);
			// 获取请求uri
			String httpInfo = request.getRequestURI();
			log.info("httpInfo========================>>:" + httpInfo);

			if (StringUtil.isAnyNullOrEmpty(resultXml)) {
				resultMap.put("code", "1");
				resultMap.put("message", "异步支付无返回");
				return resultMap;
			}
			String rspCode = getRspCode(resultXml);// 订单状态
			if (!"000000".equals(rspCode)) {
				log.info("支付失败信息RspMsg：" + getRspMsg(resultXml));
				return null;
			}
			String merNo = getMerBillNo(resultXml);// 订单编号

			String username = getAttach(resultXml);// 用户编号
			username = username.replaceAll("[^0-9]", "");
			String txmoney = getAmount(resultXml);// 充值金额
			log.info("充值金额：" + txmoney);
			String payDate = getReqDate(resultXml);// 充值时间
			// Date date = DateUtil.stringToDate(payDate.substring(0,
			// payDate.length()-3),"yyyy-MM-dd HH:mm:ss");
			String bankaccname = request.getParameter("bankaccname");
			String bankcardNum = request.getParameter("bankcardNum");
			String bankflownum = merNo;
			BigDecimal btxmoney = new BigDecimal(txmoney);
			SubzhFundLog sfl = new SubzhFundLog();
			sfl.setStatus(new Byte("0"));// 0 未审核 1成功 2 失败

			Date date = new Date();
			sfl.setModifytime(date);
			sfl.setSubzh(username);
			sfl.setBz(new Byte("2"));
			sfl.setType("6");
			sfl.setBankaccname(bankaccname);
			sfl.setBankcardnum(bankcardNum);
			sfl.setBankflownum(getBankBillNo(resultXml));
			sfl.setAfterfund(btxmoney);

			FundOrder fo = new FundOrder();
			fo.setSubzh(username);
			fo.setZjUse("1");
			fo.setZjType("1");
			fo.setPaymentzh(bankflownum);
			fo.setKhName(bankaccname);
			fo.setFund(btxmoney);
			fo.setOverTime(date);
			fo.setStatus("1");
			fo.setCreateTime(date);
			fo.setModifiedTime(date);

			List<FundOrder> foList = subzhFundLogService.getFundInfoList(fo);
			if (foList != null && foList.size() > 0) {
				return null;
			}

			Map<String, Object> channelmap = new HashMap<String, Object>();
			channelmap.put("subzh", username);
			channelmap.put("isadmin", 4);
			List<Subzh> subzhList = userInfoDataService.userLogin(channelmap);// 得到经纪人编号
			if (subzhList == null || subzhList.size() == 0) {
				log.info("查询用户失败");
				return null;
			}
			if (subzhList != null && subzhList.size() > 0) {
				BigDecimal xzj = subzhList.get(0).getXzj();
				BigDecimal rzj = subzhList.get(0).getRzj();
				log.info("xzj金额：" + xzj);
				log.info("rzj金额：" + rzj);
				if (xzj != null) {
					xzj = xzj.add(btxmoney);
				} else {
					xzj = btxmoney;
				}
				if (rzj != null) {
					rzj = rzj.add(btxmoney);
				} else {
					rzj = btxmoney;
				}
				subzhList.get(0).setXzj(xzj);
				subzhList.get(0).setRzj(rzj);
				log.info("充值后xzj金额：" + xzj);
				log.info("充值后rzj金额：" + rzj);
				try {
					userInfoDataService.updateUserInfoData(subzhList.get(0));
				} catch (Exception e) {
					log.info("更新账户资金失败", e);
				}
				channelmap.put("subzh", subzhList.get(0).getPagentzh());
				channelmap.put("isadmin", 2);// 经纪人
				fo.setPhone(subzhList.get(0).getPhone());
				fo.setRemarkName(subzhList.get(0).getName());
				fo.setRemarkPhone(subzhList.get(0).getPhone());
				sfl.setName(subzhList.get(0).getPhone());
				List<Subzh> agentList = userInfoDataService.userLogin(channelmap);// 得到经纪人数据
				if (agentList != null && agentList.size() > 0) {
					sfl.setAgentzh(agentList.get(0).getName());

					channelmap.put("subzh", agentList.get(0).getPagentzh());
					channelmap.put("isadmin", 3);// 渠道
					List<Subzh> channelList = userInfoDataService.userLogin(channelmap);// 得到渠道数据
					if (channelList != null && channelList.size() > 0) {
						sfl.setReason(channelList.get(0).getName());
					}
				}
			} else {
				resultMap.put("code", "1");
				resultMap.put("message", "用户不存在");
				return resultMap;
			}
			StringBuffer strBuffer = new StringBuffer("充值，充值金额:");
			strBuffer.append("费用-可用资金:").append(btxmoney);
			sfl.setDescription(strBuffer.toString());

			int i = subzhFundLogService.save(sfl, fo);
			if (i > 0) {
				resultMap.put("code", 0);
				resultMap.put("message", "提交成功,请等待审核!");
			} else {
				resultMap.put("code", 1);
				resultMap.put("message", "提交失败");
			}

		} catch (Exception e) {
			log.error("异步返回支付信息失败", e);
		}

		return resultMap;
	}

	/**
	 * 获取报文中<RspCode></RspCode>部分
	 * 
	 * @param xml
	 * @return
	 */
	public String getRspCode(String xml) {
		int s_index = xml.indexOf("<RspCode>");
		int e_index = xml.indexOf("</RspCode>");
		String sign = null;
		if (s_index > 0) {
			sign = xml.substring(s_index + 9, e_index);
		}
		return sign;
	}

	/**
	 * 获取报文中<Amount></Amount>部分
	 * 
	 * @param xml
	 * @return
	 */
	public String getAmount(String xml) {
		int s_index = xml.indexOf("<Amount>");
		int e_index = xml.indexOf("</Amount>");
		String sign = null;
		if (s_index > 0) {
			sign = xml.substring(s_index + 8, e_index);
		}
		return sign;
	}

	/**
	 * 获取报文中<ReqDate></ReqDate>部分
	 * 
	 * @param xml
	 * @return
	 */
	public String getReqDate(String xml) {
		int s_index = xml.indexOf("<ReqDate>");
		int e_index = xml.indexOf("</ReqDate>");
		String sign = null;
		if (s_index > 0) {
			sign = xml.substring(s_index + 9, e_index);
		}
		return sign;
	}

	/**
	 * 获取报文中<Attach></Attach>部分
	 * 
	 * @param xml
	 * @return
	 */
	public String getAttach(String xml) {
		int s_index = xml.indexOf("<Attach>");
		int e_index = xml.indexOf("</Attach>");
		String sign = null;
		if (s_index > 0) {
			sign = xml.substring(s_index + 8, e_index);
		}
		return sign;
	}

	/**
	 * 获取报文中<MerBillNo></MerBillNo>部分
	 * 
	 * @param xml
	 * @return
	 */
	public String getMerBillNo(String xml) {
		int s_index = xml.indexOf("<MerBillNo>");
		int e_index = xml.indexOf("</MerBillNo>");
		String sign = null;
		if (s_index > 0) {
			sign = xml.substring(s_index + 11, e_index);
		}
		return sign;
	}

	/**
	 * 获取报文中<RspMsg></RspMsg>部分
	 * 
	 * @param xml
	 * @return
	 */
	public String getRspMsg(String xml) {
		int s_index = xml.indexOf("<RspMsg>");
		int e_index = xml.indexOf("</RspMsg>");
		String sign = null;
		if (s_index > 0) {
			sign = xml.substring(s_index + 8, e_index);
		}
		return sign;
	}

	/**
	 * 获取报文中<BankBillNo></BankBillNo>部分
	 * 
	 * @param xml
	 * @return
	 */
	public String getBankBillNo(String xml) {
		int s_index = xml.indexOf("<BankBillNo>");
		int e_index = xml.indexOf("</BankBillNo>");
		String sign = null;
		if (s_index > 0) {
			sign = xml.substring(s_index + 12, e_index);
		}
		return sign;
	}
	
	/**
	 * 
	 * @param agentzhfundLog 
	 * @param username 用户id--subzh
	 * @param order_no  交易订单号
	 * @param pay_time	交易时间
	 * @param total_fee 交易金额
	 * @param paystate  操作状态
	 * @param bz 操作类型  
	 * @return
	 */
	private SubzhFundLog saveAgentzhfundLog(SubzhFundLog agentzhfundLog,String username,String order_no,Date pay_time,BigDecimal total_fee,int paystate,int bz){
		try{
			String type=bz==1?"6":bz==2?"7":"";
			
			agentzhfundLog.setSubzh(username);
			agentzhfundLog.setBankflownum(order_no);
			agentzhfundLog.setType(type);
			agentzhfundLog.setBz((byte)bz);//充值
			agentzhfundLog.setAfterfund(total_fee);
			agentzhfundLog.setModifytime(pay_time);
			agentzhfundLog.setFund(total_fee);
			//agentzhfundLog.setStatus((byte)paystate);//支付成功
			agentzhfundLog.setName(agentzhfundLog.getName());		
			Map<String, Object> channelmap = new HashMap<String, Object>();
			channelmap.put("subzh", username);	
			List<Subzh> subzhList = userInfoDataService.userLogin(channelmap);// 得到经纪人编号
			if (subzhList == null || subzhList.size() == 0) {
				log.info("查询用户失败");
				return null;
			}
			channelmap.put("subzh", subzhList.get(0).getPagentzh());
			channelmap.put("isadmin", 2);// 经纪人

			List<Subzh> agentList = userInfoDataService.userLogin(channelmap);// 得到经纪人数据
			if (agentList != null && agentList.size() > 0) {
				agentzhfundLog.setAgentzh(agentList.get(0).getName());

				channelmap.put("subzh", agentList.get(0).getPagentzh());
				channelmap.put("isadmin", 3);// 渠道
				List<Subzh> channelList = userInfoDataService.userLogin(channelmap);// 得到渠道数据
				if (channelList != null && channelList.size() > 0) {
					agentzhfundLog.setReason(channelList.get(0).getName());
				}
			}
			
			TreeMap<String, Object> tmap =new TreeMap<String, Object>();
			if(bz==2) {//提现
				tmap.put("amount",total_fee);
				tmap.put("bankcardnum",agentzhfundLog.getBankcardnum());//卡号
				tmap.put("phoneNum", agentzhfundLog.getPhoneNum());//手机号
				tmap.put("idcard", agentzhfundLog.getIdcard());//身份证号
				tmap.put("bankcode", agentzhfundLog.getBankcode());//银行编号
				tmap.put("openbankname", agentzhfundLog.getOpenbankname());//开户支行名称
				tmap.put("name", agentzhfundLog.getName());//开户人姓名
				tmap.put("bankaccname", agentzhfundLog.getBankaccname());//开户银行名称
				tmap.put("city", agentzhfundLog.getCity());//开户所在市
				tmap.put("province", agentzhfundLog.getProvince());//开户所在省
				JSONObject description = JSONObject.parseObject(JSON.toJSONString(tmap));
				agentzhfundLog.setDescription(description.toJSONString());
			}else {
				tmap.put("充值方式",type);
				tmap.put("充值人", agentzhfundLog.getName());
				tmap.put("充值单号", order_no);
				tmap.put("充值金额", agentzhfundLog.getFund());
				tmap.put("充值时间", agentzhfundLog.getModifytime());
				JSONObject description = JSONObject.parseObject(JSON.toJSONString(tmap));
				agentzhfundLog.setDescription(description.toJSONString());
			}
				log.info("log6:"+agentzhfundLog.getDescription());
				log.info("保存资金信息状态:"+subzhFundLogService.saveSubzhFundLog(agentzhfundLog));
		}catch(Exception e){
			e.printStackTrace();
		}
		return agentzhfundLog;
	}
	
/*	public static void main(String[] args) {
		System.out.println(DateUtil.getToday00()+"      " +DateUtil.getToday23());
		
	}*/
}