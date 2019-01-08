/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @FundController.java
 * 功能概要  : 
 * 做成日期  : @2018年6月13日
 * 修改日期  :
 */
package com.jcl.controller;
/** 
 * @author zpf
 * @version 1.0
 */

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jcl.pojo.AgentzhfundLog;
import com.jcl.pojo.FundPzlog;
import com.jcl.pojo.Subzh;
import com.jcl.service.AgentzhfundLogService;
import com.jcl.service.FundPzLogService;
import com.jcl.service.SubzhService;
import com.jcl.stock.entity.CONST;
import com.jcl.stock.simulate.BussinessException;
import com.jcl.stock.simulate.DefineNumber;
import com.jcl.stock.simulate.service.SimulateStockService;
import com.jcl.util.Constant;
import com.jcl.util.DateUtil;
import com.jcl.util.DeployProperties;
import com.jcl.util.StringUtil;
import com.jcl.util.spt.HttpRequest;
import com.jcl.util.spt.SignMd5Utils;

/**
 * 资金充值提现的控制层
 */

@Controller
@RequestMapping("/subzhfundssss")
public class FundController1 {
	public static Logger log = Logger.getLogger(FundController1.class);
	
	private static final String project_path = DeployProperties.getInstance().getSptReturn();
	
	@Autowired
	private SubzhService subzhService;
	
	//注入配置服务
	@Autowired
	private FundPzLogService fundPzLogService;

	@Autowired
	private AgentzhfundLogService agentzhfundLogService;
	
	@Autowired
	private SimulateStockService simulateStockService;
	
	
	
	
	
	//h5充值
	@RequestMapping("/toPayH5")
	public String toPayH5(String subzh,HttpSession session,Model model) {
		session.setAttribute(Constant.SESSION_LOGINNAME, subzh);
		Subzh sub=subzhService.selectBySubzh(subzh);
		if(sub!=null && sub.getIsadmin()==6){
			if(sub.getAuthState()==null || sub.getAuthState()!=2){//交易用户没有实名认证没有通过
				model.addAttribute("flag", 0);
				return "register_h5/noneed";
			}
		}else {//当用户非普通用户时无法充值
			model.addAttribute("flag", 6);
			return "register_h5/noneed";
		}
		model.addAttribute("subzh", sub);
		return "register_h5/fundChartHFive";	
	}
	
	//h5提现
	@SuppressWarnings("unchecked")
	@RequestMapping("/drawMoneyH5")
	public String drawMoneyH5(String subzh,HttpSession session,Model model) {
		session.setAttribute(Constant.SESSION_LOGINNAME, subzh);
		log.info("提现用户为===》"+subzh);
		Subzh sub=null;
		boolean isavild=false;
		String result="register_h5/fundRaising";
		if(subzh!=null) {
		try {
			sub=subzhService.loginBySubzh(subzh);
			if(sub!=null){
				Integer isadmin=sub.getIsadmin();
				if(isadmin==6){
					try{
						log.info("调协议查询可用资金");
						String con="{\"client_id\":\""+subzh+"\"}";
						log.info("log——con===》"+con);
						String rbStr = simulateStockService.commonFunction(con, 11103);//持仓记录
						log.info("log——rbStr===》"+rbStr);
						if(rbStr==null||rbStr=="null" || rbStr.equals("")){
							rbStr="{\"status\":10,\"describe\":\"地址错误或网络错误\"}";
							JSONObject obj = JSONObject.parseObject(rbStr);
							log.info("log1——obj===》"+obj);
						}else if(rbStr.indexOf("{")<0){
							rbStr="{\"status\":11,\"describe\":\"返回信息出错\"}";
							JSONObject obj = JSONObject.parseObject(rbStr);
							log.info("log2——obj===》"+obj);
						}else{//正常情况下
							Map<String, Object> map=JSONObject.parseObject(rbStr);
							JSONObject data=(JSONObject) JSONObject.toJSON(map.get("data"));
							if(data==null) {
								
								return "register_h5/noneed";
							}
							log.info("log3——obj===》"+data+"enable_balance===》"+data.get("enable_balance"));
							if(map.containsKey("status") &&Integer.parseInt(map.get("status").toString())==0){
								sub.setFundbalance(new BigDecimal(String.valueOf(data.get("enable_balance"))));
							}
						}
					}catch(Exception e){
						e.printStackTrace();
					}
					
					if(sub.getAuthState()!=null && sub.getAuthState()==2){//交易用户必须要实名认证后才能提现
						boolean b=isHaveHold(subzh);
						if(b){
							isavild=true;
						}else{
							model.addAttribute("flag", 4);//有持仓数据
						}
					}else{
						model.addAttribute("flag", 1);
					}
				}else{//非交易用户，不用实名认证也可以提现
					if(sub.getFundbalance()==null){
						model.addAttribute("flag", 5);
					}else{
						isavild=true;
					}
					
				}
				try {
					subzhService.updateByPrimaryKey(sub);
				} catch (Exception e) {
					log.error("查询柜台后修改客户可用资金", e);
				}
				log.info("客户资金为===》"+sub.getFundbalance());
				model.addAttribute("money",sub.getFundbalance());
			}else{
				model.addAttribute("flag", 2);
			}
			model.addAttribute("subzh", sub);
		} catch (Exception e) {
			model.addAttribute("flag", 3);
			log.error("查询用户可用资金异常", e);
			}
		}
		if(!isavild){
			result="register_h5/noneed";
		}
		model.addAttribute("subzh", sub);
		return result;	
	}
	
	//判断某个用户是否有持仓
	private boolean isHaveHold(String user){
		boolean b=true;
		try{
			String con="{\"start\":0,\"limit\":10,\"client_id\":\""+user+"\"}";
			String rbStr = simulateStockService.commonFunction(con, 11123);//持仓记录
			if(rbStr==null||rbStr=="null" || rbStr.equals("")){
				rbStr="{\"status\":10,\"describe\":\"地址错误或网络错误\"}";
				JSONObject obj = JSONObject.parseObject(rbStr);
			}else if(rbStr.indexOf("{")<0){
				rbStr="{\"status\":11,\"describe\":\"返回信息出错\"}";
				JSONObject obj = JSONObject.parseObject(rbStr);
			}else{//正常情况下
				JSONObject obj = JSONObject.parseObject(rbStr);
				if(obj.containsKey("status") && obj.getIntValue("status")==0){
					JSONArray arr=obj.getJSONArray("holders");
					if(arr.size()>0){
						b=false;
					}
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	//提现成功后的页面
	@RequestMapping("/stockoptionJump")
	public String stockoptionJump() {
		
		return "register_h5/callback";	
	}
	
	/**
	 * spt银联h5--生成充值信息
	 * 
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/payMentFive",produces="text/html;charset=UTF-8;")
	public String payMentFive(HttpServletRequest request, Model model,String username,String txmoney,String channel) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String dates = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		BigDecimal money = new BigDecimal(txmoney);
		money = money.multiply(new BigDecimal("100")).setScale(0);

		String url = Constant.SPT_H5_PAY_URL;
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
		
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String pay_time=df.format(new Date());
		
		saveAgentzhfundLog(username,orderno,pay_time,money.intValue(),0,null,0.985);
		model.addAttribute("payMap", payMap);
		model.addAttribute("url", url);
		return "register_h5/payMentFive";
	}
	
	
	/**
	 * spt充值返回
	 * 
	 * @param id
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/returnSptPayMent",produces="text/html;charset=UTF-8;")
	public Map<String,Object> returnSptPayMent(HttpServletRequest request, HttpSession session, @RequestBody String requestBody) {
		AgentzhfundLog agentzhfundLog=new AgentzhfundLog();
		log.info("requestBody:" + JSONObject.parseObject(requestBody));
		JSONObject allStr =  JSONObject.parseObject(requestBody);
		String return_code = allStr.getString("return_code");//SUCCESS 代表成功，其它请参考错误代码
		String return_msg = allStr.getString("return_msg");//提示
		String merch_id = allStr.getString("merch_id");//商户号
		String trade_no = allStr.getString("trade_no");//平台交易号
		String order_no = allStr.getString("order_no");//商户订单号
		Integer total_fee = allStr.getInteger("total_fee");//总金额
		String pay_time = allStr.getString("pay_time");//支付完成时间，
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		if (!"SUCCESS".equals(return_code)) {
			if(allStr.containsKey("order_no")){
				order_no = allStr.getString("order_no");//商户订单号
			}
			log.info("支付失败信息return_msg：" + return_msg+",order_no:"+order_no);
			map.put("return_code", return_code);
			map.put("return_msg", return_msg);
			return map;
		}
		
		log.info("pay_time:"+pay_time);
		log.info("order_no1:"+order_no);
		List<AgentzhfundLog> alist= null;
		try {
			alist = agentzhfundLogService.selectByorderno(order_no);
		} catch (Exception e) {
			log.info("查询失败",e);
		}
		
		log.info("alist ====>"+alist.size());
		if(alist!=null&&alist.size()>0) {
			agentzhfundLog=alist.get(0);
			if(agentzhfundLog.getStatus()==1){//已经充值成功了。
				int count=0;
				count++;
				log.info("该单号充值已完成"+new Date().toString()+"---"+count);
				map.put("return_code", return_code);
				
				return map;
			}
			
		}
		
		
		log.info("order_no：" + order_no);
		BigDecimal btxmoney = new BigDecimal(total_fee);
		btxmoney = btxmoney.divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP);
		log.info("btxmoney：" + btxmoney);
		String username = order_no.substring(21);
		log.info("username：" + username);
		Subzh subzh=null;
		try {
			 subzh = subzhService.selectBySubzh(username);
		} catch (Exception e1) {
			log.info("根据subzh查询账户信息失败", e1);
		}
		
		if(subzh!=null) {
		try {				
			agentzhfundLog.setStatus(1);
			agentzhfundLog.setAccNo(trade_no);
			agentzhfundLogService.updateByPrimaryKey(agentzhfundLog);
			if(null!=subzh) {
				log.info("log8:subzh"+subzh);
				subzh.setZhstate(1);
				int count=subzhService.updateByPrimaryKey(subzh);
				log.info("log11:subzhService"+count);
			}
			
			FundPzlog fundPzlog = new FundPzlog();
			log.info("log:开始记录配资"+username+
						"---6--充值"+"--"+agentzhfundLog.getFund()+
						"--"+agentzhfundLog.getModifytime());
					fundPzlog.setSubzh(username);
					fundPzlog.setFundtype(6);//充值
					fundPzlog.setSetpro(0);
					fundPzlog.setFundbalance(agentzhfundLog.getFund());
					fundPzlog.setCreatetime(agentzhfundLog.getModifytime());
					
					int n=fundPzLogService.insertFundPzlog(fundPzlog);
					log.info("insertFundPzlog:"+n);
					
					try {
						log.info("开始调协议");
						Double fundValue = fundPzlog.getFundbalance().doubleValue();
						log.info("fundValue===》"+fundValue);
						log.info("fundPzlog.getId()===》"+fundPzlog.getId());
						String rbStr = simulateStockService.commonFunction("{\"seq_no\":"+fundPzlog.getId()+",\"client_id\":\""+username+"\",\"fund_type\":5,\"prev_fund\":0.00,\"after_fund\":"+fundValue+
								",\"warning_line\":0.00,\"open_line\":0.00}",DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
						if(!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1){
							JsonParser parser = new JsonParser();
							JsonElement element = parser.parse(rbStr);
							JsonObject jsonObj = element.getAsJsonObject();
							log.info("添加账户资金状态1：" + rbStr+"---"+DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
				    		if(CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()){
				    		//掉协议成功，入金成功
				    			log.info("添加账户资金状态2：" + rbStr);
				    		} else {
				    			//入金失败
				    			log.info("添加账户资金状态3====>调协议失败：" + rbStr);
				    			try {
				    				//当用户入金失败，判断用户是否是第一次入金，如果是则还是把用户状态改为未激活
				    				List<FundPzlog> sfplist = fundPzLogService.selectBySubzh(subzh.getSubzh());
				    				if(sfplist==null&&sfplist.size()<=1) {
				    					subzh.setZhstate(0);
				    				}
				    			
				    			} catch (Exception e) {
				    				log.error("查询该用户资金流水失败", e);
								}
				    			
				    		}
						}else {
							log.info("添加账户资金状态4====>调协议失败：" + rbStr);
							try {
								//当用户入金失败，判断用户是否是第一次入金，如果是则还是把用户状态改为未激活
			    				List<FundPzlog> sfplist = fundPzLogService.selectBySubzh(subzh.getSubzh());
			    				if(sfplist==null&&sfplist.size()<=1) {
			    					subzh.setZhstate(0);
			    				}
			    			
			    			} catch (Exception e) {
			    				log.error("查询该用户资金流水失败", e);
							}
							
						}
						//修改用户状态
						try {
							int count=subzhService.updateByPrimaryKey(subzh);
							log.info("log11:subzhService"+count);
						} catch (Exception e) {
							log.error("更改用户状态异常", e);
						}
						
						map.put("return_code", return_code);
						
					} catch (Exception e) {
						if(null!=subzh) {
							
							try {
								//当用户入金出现异常，判断用户是否是第一次入金，如果是则还是把用户状态改为未激活
								log.info("log_e:subzh===>"+subzh);	
			    				List<FundPzlog> sfplist = fundPzLogService.selectBySubzh(subzh.getSubzh());
			    				if(sfplist==null&&sfplist.size()<=1) {
			    					subzh.setZhstate(0);
			    				}
			    			
			    			} catch (Exception e1) {
			    				log.error("查询该用户资金流水失败", e1);
							}
							//修改用户状态
							try {
								int count=subzhService.updateByPrimaryKey(subzh);
								log.info("log11:subzhService"+count);
							} catch (Exception e1) {
								log.error("更改用户状态异常", e1);
							}
						}						
						log.error("追加保证金异常：" + e);					
					}
					map.put("return_code", "FAIL");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("异步返回支付信息失败", e);
			map.put("return_code", "FAIL");
		}
	}
		
		return map;
	}
	
	

	//保存提现信息
	@SuppressWarnings("unused")
	@RequestMapping(value = "/paya",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String  paya(AgentzhfundLog afl, HttpSession session,Model model) {
		
		log.info("保存提现信息");
		String subzh = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
		log.info("subzh===》"+subzh);
		if (subzh == null) {
			log.info("subzh:账户为null");	
			return "用户不存在";
		}
		
		Subzh sub = subzhService.selectBySubzh(subzh);
		if(null==sub) {
			log.info("sub==null:用户信息为null");	
			return "用户信息为null";
		}
		
		log.info("sub===》"+sub);
		if (sub.getFundbalance() == null) {
			log.info("result1:余额不足");		
			return "余额不足1";
		}
		log.info("sub.getFundbalance===》"+sub.getFundbalance());
		//sub.getFundbalance获取限制可用资金
		
		if (sub.getFundbalance().doubleValue() - Double.valueOf(afl.getAmount()) < 0) {
			log.info("result2:余额不足");
			return "余额不足2";
		} 
		sub.setFundbalance(sub.getFundbalance().subtract(new BigDecimal(afl.getAmount())));
		try {
			subzhService.updateByPrimaryKey(sub);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		TreeMap<String, Object> tmap =new TreeMap<String, Object>();
		tmap.put("amount",afl.getAmount() );
		tmap.put("bankCardNumber",afl.getBankCardNumber());
		tmap.put("phoneNum", afl.getPhoneNum());
		tmap.put("idcard", afl.getIdcard());
		tmap.put("bankcode", afl.getBankcode());
		JSONObject description = JSONObject.parseObject(JSON.toJSONString(tmap));
		
		afl.setDescription(description.toJSONString());
		log.info("setDescription:==》"+afl.getDescription());
		
		afl.setSubzh(subzh);
		log.info("setSubzh:==》"+afl.getBanchname());
		
		afl.setBz((byte)2);
		
		String dates = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		String orderno =  dates + StringUtil.getRandomString(4)+subzh;
		
		afl.setOrderno(orderno);
		afl.setFund(new BigDecimal(afl.getAmount()));
		afl.setStatus(4);
		afl.setType("1");
		afl.setModifytime(DateUtil.getSystemDate());
		log.info("订单号是==》"+afl.getOrderno());
		
		try {
			
			int num=agentzhfundLogService.insertagentzhfundLog(afl);
			log.info("agentzhfundLogService:==》"+afl.getId());
			if(sub.getIsadmin()==6) {
			//现在需要做一些冻结数量的计算逻辑
			//对于原油项目，1:出金 2:入金 3:增加不可取资金 4:减少不可取资金 5:追加保证金
				try {
					log.info("提现调柜台协议开始");
					String rbStr = simulateStockService.commonFunction("{\"seq_no\":"+afl.getId()+",\"client_id\":\""+subzh+"\",\"fund_type\":1,"
							+ "\"prev_fund\":0.00,\"after_fund\":"+afl.getFund()+",\"warning_line\":0.00,\"open_line\":0.00}", DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
					log.info("传到柜台的参数"+rbStr);
					if(!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1){
						JsonParser parser = new JsonParser();
						JsonElement element = parser.parse(rbStr);
						JsonObject jsonObj = element.getAsJsonObject();
			    		if(CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()){
			    			log.error("提现成功调柜台协议成功");
			    		} else{
			    			//调柜台协议失败删除该条记录
			    			afl.setStatus(7);
			    			
			    			log.info(jsonObj.get("describe"));
			    			return jsonObj.get("describe").toString();
			    		}
					}
				} catch (Exception efund) {
					//调柜台协议失败删除该条记录
					afl.setStatus(7);
					
					log.error("柜台调协议异常：" + efund.getMessage());
					
					return "提现失败";
				}
				int i=agentzhfundLogService.updateStateBysubzh(afl);
				log.info("修改这条提现申请状态为提交申请失败"+i);
			}
		} catch (Exception e){	
			log.error("保存提现信息失败", e);
			return "提现申请提交失败，请再次提交";
		}
		
		return "ok";	
	}
	
	//审核并且提现
	@RequestMapping(value = "/gopay",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String gopay(Integer id, Integer status) {
		log.info("提现审核开始");
		AgentzhfundLog afl=null;
		try {
			
			afl = agentzhfundLogService.selectByPrimaryKey(id);
			

		} catch (Exception e) {
			log.info("查询待提现信息异常"+e);
		}
		
		log.info("查询待提现信息异常"+afl.getStatus());
		if(afl!=null&&afl.getStatus()==4){
			if(status!=5) {
				return "审核未通过";
			}
		}else {
			return "提现信息不存在";
		}
		
		String description= afl.getDescription();
		JSONObject jsonobj = JSONObject.parseObject(description);
		
		afl.setAmount(jsonobj.getString("amount"));
		afl.setBankCardNumber(jsonobj.getString("bankCardNumber"));	
		afl.setPhoneNum(jsonobj.getString("phoneNum"));
		afl.setIdcard(jsonobj.getString("idcard"));
		afl.setBankcode(jsonobj.getString("bankcode"));
		
		try {
			String subzh = afl.getSubzh();
		if (subzh == null)
			
				return "result用户不存在";
		
			Subzh sub = subzhService.selectBySubzh(subzh);
			
			String url = "http://gw.spt-pay.cn/settle";
			String testKey = Constant.SPT_SECRTKEY;// 秘钥

			TreeMap<String, String> sortedMap = new TreeMap();
			sortedMap.put("merch", Constant.SPT_MERCHART);//商户号
			sortedMap.put("orderno", afl.getOrderno());//商户订单号
			DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
			sortedMap.put("amount", decimalFormat.format((Double.valueOf(afl.getAmount())) * 100));//提现金额
			sortedMap.put("notifyurl", project_path+"/subzhfund/isPay");//异步回调通知地址
			sortedMap.put("cardtype", "1");//提现--对公对私
			sortedMap.put("bankcode", afl.getBankcode());//银行卡编码：例如工商银行：ICBC
			sortedMap.put("bankname", afl.getBankname());//银行卡开户行名称
			sortedMap.put("bankbranch", afl.getBanchname());//银行卡开户支行名称
			sortedMap.put("cardname", afl.getName());//收款人姓名
			sortedMap.put("cardno", afl.getBankCardNumber());//收款人银行账号
			sortedMap.put("cardmobile", afl.getPhoneNum());//银行预留手机号
			sortedMap.put("certid", afl.getIdcard());//身份证号
			sortedMap.put("province", afl.getProvince());//开户所在省
			sortedMap.put("city", afl.getCity());//开户所在市

			System.out.println(sortedMap.toString());
			String key_sign_zn = SignMd5Utils.createSign(sortedMap, testKey);// 签名
			sortedMap.put("sign", key_sign_zn);
			sortedMap.put("signtype", "MD5");

			String result = HttpRequest.sendPost(url, sortedMap);
			
			Map<String, String> resmap = JSON.parseObject(result, Map.class);
			String recode = resmap.get("return_code");
			String msg = resmap.get("return_msg");
			log.info("pay_time1:"+resmap.get("pay_time"));
			
			log.info("log1"+recode+"----"+msg);
			
			if ("SETTLE_NOT_WALLET".equals(recode)) {
				return "result"+recode+":"+msg;
			}
			if ("SETTLE_OUT_UPPER".equals(recode)) {
				return "result"+recode+":"+msg;
			}
			System.out.println(recode+"-----"+msg);
			//配置状态为4，表示提出提现申请
			
			if ("SUCCESS".equals(recode)) {
				afl.setStatus(5);//审核通过
				int num=agentzhfundLogService.updateStateBysubzh(afl);
				log.info("log2"+num);
					
			}else {
				return "false";
			}
		} catch (Exception e) {
			log.info("提现记录异常=>"+e);
			return "result提现失败";
		}
		return "true";	
	}
	
	@RequestMapping(value = "/isPay",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public  String  isPay(HttpServletRequest request, Model model, @RequestBody String requestBody) {
		
		log.info("提现回调开始");	
		try {
			log.info("requestBody"+requestBody);	
			JSONObject allStr = JSONObject.parseObject(requestBody);
			TreeMap<String, String> sortedMap = new TreeMap();
			sortedMap.put("order_no", allStr.getString("order_no"));
			sortedMap.put("total_fee", allStr.getString("total_fee"));
			sortedMap.put("merch_id", allStr.getString("merch_id"));
			sortedMap.put("settle_status", allStr.getString("settle_status"));
			sortedMap.put("return_code", allStr.getString("return_code"));
			sortedMap.put("settle_no", allStr.getString("settle_no"));
			String camparesign = SignMd5Utils.createSign(sortedMap, Constant.SPT_SECRTKEY);
			
			//获取提现的账号
			String username = allStr.getString("order_no").substring(21);
			
			Subzh subzh = subzhService.selectBySubzh(username);
			log.info("username:"+username+"-----subzh:"+subzh);
			
			log.info("签名号"+allStr.getString("sign")+"-----"+camparesign);
			
			log.info("判断签名号"+allStr.getString("sign").equals(camparesign));
			
			if (allStr.getString("sign").equals(camparesign)) {

				log.info("ok");
				List<AgentzhfundLog> alist = agentzhfundLogService.selectByorderno(allStr.getString("order_no"));
				log.info("alist"+alist.size()+"---"+alist);
				
				//判断是否是通过了审核的回调
				AgentzhfundLog agentzhfundLog=null;
				
				if(alist!=null) {
					agentzhfundLog=alist.get(0);
				}
				log.info("提现审核状态：===》"+agentzhfundLog.getStatus());
				
				//操作资金明细表
				FundPzlog fundPzlog = new FundPzlog();
				
				if(agentzhfundLog!=null && agentzhfundLog.getStatus()==5) {
					
					String description= agentzhfundLog.getDescription();
					JSONObject jsonobj = JSONObject.parseObject(description);
					log.info("jsonobj===>"+jsonobj);
					agentzhfundLog.setAmount(jsonobj.getString("amount"));
					agentzhfundLog.setBankCardNumber(jsonobj.getString("bankCardNumber"));	
					agentzhfundLog.setPhoneNum(jsonobj.getString("phoneNum"));
					agentzhfundLog.setIdcard(jsonobj.getString("idcard"));
					agentzhfundLog.setBankcode(jsonobj.getString("bankcode"));	

				log.info("log:开始记录配资"+username+
						"---6--提现"+"--"+allStr.getString("total_fee")+"--");
					fundPzlog.setSubzh(username);
					fundPzlog.setFundtype(7);//提现值
					fundPzlog.setSetpro(0);
					fundPzlog.setFundbalance(new BigDecimal(agentzhfundLog.getAmount()));
					fundPzlog.setCreatetime(DateUtil.getSystemDate());
					
					TreeMap<String, Object> tmap =new TreeMap<String, Object>();
					tmap.put("提现人", fundPzlog.getSubzh());
					tmap.put("提现单号", allStr.getString("order_no"));
					tmap.put("提现金额",allStr.getString("total_fee"));
					tmap.put("提现时间", agentzhfundLog.getModifytime());
					tmap.put("提现银行卡编号", agentzhfundLog.getBankCardNumber());
					tmap.put("提现银行卡", agentzhfundLog.getBankCardNumber());
					JSONObject descriptions = JSONObject.parseObject(JSON.toJSONString(tmap));
					fundPzlog.setSetdesc(descriptions.toJSONString());
					try {
						int n=fundPzLogService.insertFundPzlog(fundPzlog);
						log.info("log提现"+n+fundPzlog.getSetdesc());
					} catch (Exception e) {
						log.info("添加用户提现流水异常", e);
					}
					if(fundPzlog.getId()==null){
						log.info("调用提现时配置对象id为空");
					}
			  }else {//当回调成功，且提现状态不是5的时候，调柜台协议把用户的钱还原到用户账户账户中
					if(null!=subzh&&subzh.getIsadmin()==6) {
						String rbStr = simulateStockService.commonFunction("{\"seq_no\":"+fundPzlog.getId()+",\"client_id\":\""+username+"\",\"fund_type\":5,\"prev_fund\":0.00,\"after_fund\":"+fundPzlog.getFundbalance()+
								",\"warning_line\":0.00,\"open_line\":0.00}",DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
						if(!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1){
							JsonParser parser = new JsonParser();
							JsonElement element = parser.parse(rbStr);
							JsonObject jsonObj = element.getAsJsonObject();
							log.info("提现失败后调协入金协议1：" + rbStr+"---"+DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
				    		if(CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()){
				    		//掉协议成功，入金成功
				    			log.info("提现失败后调协入金协议2：" + rbStr);
				    		} else {
				    		//入金失败
				    			log.info("提现失败后调协入金协议失败：" + rbStr);
				    		}
						}
					}else {
						
					}
			  }
			}
		} catch (Exception e) {
			log.info("提现异步异常:"+e);
		}
		log.info("SUCCESS--提现成功");
		return "SUCCESS";
	}
	
	
	//拒绝通过审核
	@RequestMapping("/checkWithdraw")
	@ResponseBody
	public String checkWithdraw(Integer id, Integer status) {

		try {
				AgentzhfundLog fundLog = agentzhfundLogService.selectByPrimaryKey(id); 
				
				Subzh subzhEntity=subzhService.selectBySubzh(fundLog.getSubzh());
				if(fundLog != null){
					if(status!=null && status==6){
						try {
			 				fundLog.setStatus(6);/*状态   0是申请姿态。1是成功 5：审核通过  6：拒绝*/
			 				fundLog.setModifytime(Calendar.getInstance().getTime());
			 				log.info("审核通过保存状态：" + agentzhfundLogService.updateByPrimaryKey(fundLog));
			 			} catch (Exception efundlog) {
			 				log.error("保存预提现信息异常：" + efundlog.getMessage());
			 				return "false";
			 			}
						
						if(subzhEntity!=null&&subzhEntity.getIsadmin()==6) {
							String rbStr = simulateStockService.commonFunction("{\"seq_no\":"+fundLog.getId()+",\"client_id\":\""+fundLog.getSubzh()+"\",\"fund_type\":5,\"prev_fund\":0.00,\"after_fund\":"+fundLog.getFund()+
									",\"warning_line\":0.00,\"open_line\":0.00}",DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
							if(!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1){
								JsonParser parser = new JsonParser();
								JsonElement element = parser.parse(rbStr);
								JsonObject jsonObj = element.getAsJsonObject();
								log.info("提现失败后调协入金协议1：" + rbStr+"---"+DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
					    		if(CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()){
					    		//掉协议成功，入金成功
					    			log.info("提现失败后调协入金协议：" + rbStr);
					    		} else {
					    			//入金失败
					    			log.info("提现失败后调协入金协议失败：" + rbStr);
					    		}
							}
						}else {
							if(subzhEntity.getFundbalance()!=null) {
								subzhEntity.setFundbalance(subzhEntity.getFundbalance().add((fundLog.getFund())));
						}
						subzhService.updateByPrimaryKey(subzhEntity);
						}		
						return "true";
					}
				}
			}catch(Exception e) {
				log.error("fundLog--拒绝提现异常",e);
				return "false";
			}
		return "true";
		}
	
	
	////////////////////////////////////////////网官充值提现////////////////////////////////////////////////////////////////////
	//网关充值
		@RequestMapping("/toPay")
		public String toPay(String subzh,HttpSession session,Model model) {
			session.setAttribute(Constant.SESSION_LOGINNAME, subzh);
			Subzh sub=subzhService.selectBySubzh(subzh);
			if(sub!=null && sub.getIsadmin()==6){
				if(sub.getAuthState()==null || sub.getAuthState()!=2){//交易用户没有实名认证没有通过
					model.addAttribute("flag", 0);
					return "register_h5/noneed";
				}
			}else {//当用户非普通用户时无法充值
				model.addAttribute("flag", 6);
				return "register_h5/noneed";
			}
			model.addAttribute("subzh", sub);
			return "register_h5/fundChart";	
		}
		
		//网关提现
		@SuppressWarnings("unchecked")
		@RequestMapping("/drawMoney")
		public String drawMoney(String subzh,HttpSession session,Model model) {
			session.setAttribute(Constant.SESSION_LOGINNAME, subzh);
			log.info("提现用户为===》"+subzh);
			Subzh sub=null;
			boolean isavild=false;
			String result="register_h5/fundRaising";//这个提现页面和h5提现页面相同了。可能以后提现页面要改为不同。
			if(subzh!=null) {
			try {
				sub=subzhService.loginBySubzh(subzh);
				if(sub!=null){
					Integer isadmin=sub.getIsadmin();
					if(isadmin==6){
						if(sub.getAuthState()!=null && sub.getAuthState()==2){//交易用户必须要实名认证后才能提现
							boolean b=isHaveHold(subzh);
							if(b){//没有持仓
								isavild=true;
								try{
									log.info("调协议查询可用资金");
									String con="{\"client_id\":\""+subzh+"\"}";
									log.info("log——con===》"+con);
									String rbStr = simulateStockService.commonFunction(con, 11103);//持仓记录
									log.info("log——rbStr===》"+rbStr);
									if(rbStr==null||rbStr=="null" || rbStr.equals("")){
										rbStr="{\"status\":10,\"describe\":\"地址错误或网络错误\"}";
										JSONObject obj = JSONObject.parseObject(rbStr);
										log.info("log1——obj===》"+obj);
									}else if(rbStr.indexOf("{")<0){
										rbStr="{\"status\":11,\"describe\":\"返回信息出错\"}";
										JSONObject obj = JSONObject.parseObject(rbStr);
										log.info("log2——obj===》"+obj);
									}else{//正常情况下
										Map<String, Object> map=JSONObject.parseObject(rbStr);
										JSONObject data=(JSONObject) JSONObject.toJSON(map.get("data"));
										
										if(data==null) {
											model.addAttribute("flag", 7);
											return "register_h5/noneed";
										}
				
										
										log.info("log3——obj===》"+data+"enable_balance===》"+data.get("enable_balance"));
										if(map.containsKey("status") &&Integer.parseInt(map.get("status").toString())==0){
											sub.setFundbalance(new BigDecimal(String.valueOf(data.get("enable_balance"))));
											try {
												subzhService.updateByPrimaryKey(sub);
											} catch (Exception e) {
												log.error("查询柜台后修改客户可用资金", e);
											}
										}
									}
								}catch(Exception e){
									e.printStackTrace();
								}
								
							}else{
								model.addAttribute("flag", 4);//有持仓数据
							}
							
						}else{//交易用户没有实名认证
							model.addAttribute("flag", 1);
						}
					}else{//非交易用户，不用实名认证也可以提现
						if(sub.getFundbalance()==null){
							model.addAttribute("flag", 5);
						}else{
							isavild=true;
						}
					}
					
					log.info("客户资金为===》"+sub.getFundbalance());
					model.addAttribute("money",sub.getFundbalance());
				}else{
					model.addAttribute("flag", 2);
				}
				model.addAttribute("subzh", sub);
			} catch (Exception e) {
				model.addAttribute("flag", 3);
				log.error("查询用户可用资金异常", e);;
				}
			}
			if(!isavild){
				result="register_h5/noneed";
			}
			model.addAttribute("subzh", sub);
			return result;	
		}
	
		/**
		 * spt银联网关--生成充值信息
		 * 
		 * @param id
		 * @param session
		 * @return
		 */
		@RequestMapping(value = "/payMent",produces="text/html;charset=UTF-8;")
		public String payMent(HttpServletRequest request, Model model,String username,String txmoney,String channel) {
			String dates = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
			BigDecimal money = new BigDecimal(txmoney);
			money = money.multiply(new BigDecimal("100")).setScale(0);

			String url = Constant.SPT_WG_PAY_URL;//网关支付地址
			String testKey = Constant.SPT_SECRTKEY;// 秘钥

			Map<String, String> payMap = new HashMap<String, String>();
			// 必填参数
			payMap.put("merch", Constant.SPT_MERCHART);// 商户号
//			payMap.put("userid", username);// 用户标识
			String orderno=dates + StringUtil.getRandomString(4)+username;
			payMap.put("orderno", orderno); // 商户订单号，查询时需要

			payMap.put("amount", money.toString()); // 金额，单位分
			payMap.put("tranchannel", "CMB"); // 银行渠道编码
			payMap.put("body", "充值");// 商品描述

			payMap.put("notifyurl",project_path+ "/subzhfund/notifySptPayMent");// 异步回调通知地址
			payMap.put("pageurl", project_path+ "/subzhfund/stockoptionJump?flag=1");// 同步回调通知地址
			payMap.put("comment", username);// 附加信息
			String sign = SignMd5Utils.createSign(payMap, testKey);// 签名
			payMap.put("sign", sign);// 签名串
			payMap.put("signtype", "MD5");
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String pay_time=df.format(new Date());
			saveAgentzhfundLog(username,orderno,pay_time,money.intValue(),0,null,0.994);
			model.addAttribute("payMap", payMap);
			model.addAttribute("url", url);
			return "register_h5/payMent";
		}
	
		
		/**
		 * spt网官充值返回
		 * 
		 * @param id
		 * @param session
		 * @return
		 */
		@ResponseBody
		@RequestMapping(value = "/notifySptPayMent",produces="text/html;charset=UTF-8;")
		public Map<String,Object> notifySptPayMent(HttpServletRequest request, HttpSession session, @RequestBody String requestBody) {
			AgentzhfundLog agentzhfundLog=new AgentzhfundLog();
			Map<String,Object> map = new HashMap<String,Object>();
			log.info("requestBody:" + JSONObject.parseObject(requestBody));
			JSONObject allStr =  JSONObject.parseObject(requestBody);
			String return_code = allStr.getString("return_code");//SUCCESS 代表成功，其它请参考错误代码
			String return_msg = allStr.getString("return_msg");//提示
			String order_no = "";//商户订单号
			if (!"SUCCESS".equals(return_code)) {
				if(allStr.containsKey("order_no")){
					order_no = allStr.getString("order_no");//商户订单号
				}
				log.info("支付失败信息return_msg：" + return_msg+",order_no:"+order_no);
				map.put("return_code", return_code);
				map.put("return_msg", return_msg);
				return map;
			}
			order_no = allStr.getString("order_no");//商户订单号
			String merch_id = allStr.getString("merch_id");//商户号
			String trade_no = allStr.getString("trade_no");//平台交易号
			Integer total_fee = allStr.getInteger("total_fee");//总金额
			String pay_time = allStr.getString("pay_time");//支付完成时间，
			
			log.info("pay_time:"+pay_time);
			log.info("order_no1:"+order_no);
			List<AgentzhfundLog> alist= null;
			try {
				alist = agentzhfundLogService.selectByorderno(order_no);
			} catch (Exception e) {
				log.info("查询失败",e);
			}
			
			log.info("alist ====>"+alist.size());
			if(alist!=null&&alist.size()>0) {
				agentzhfundLog=alist.get(0);
				if(agentzhfundLog.getStatus()==1){//已经充值成功了。
					int count=0;
					count++;
					log.info("该单号充值已完成"+new Date().toString()+"---"+count);
					map.put("return_code", return_code);
					
					return map;
				}
				
			}
			
			
			log.info("order_no：" + order_no);
			BigDecimal btxmoney = new BigDecimal(total_fee);
			btxmoney = btxmoney.divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP);
			log.info("btxmoney：" + btxmoney);
			String username = order_no.substring(21);
			log.info("username：" + username);
			Subzh subzh=null;
			try {
				 subzh = subzhService.selectBySubzh(username);
			} catch (Exception e1) {
				log.info("根据subzh查询账户信息失败", e1);
			}
			
			if(subzh!=null) {
			try {				
				agentzhfundLog.setStatus(1);
				agentzhfundLog.setAccNo(trade_no);
				agentzhfundLogService.updateByPrimaryKey(agentzhfundLog);
				if(null!=subzh) {
					log.info("log8:subzh"+subzh);
					subzh.setZhstate(1);
					int count=subzhService.updateByPrimaryKey(subzh);
					log.info("log11:subzhService"+count);
				}
				
				FundPzlog fundPzlog = new FundPzlog();
				log.info("log:开始记录配资"+username+
							"---6--充值"+"--"+agentzhfundLog.getFund()+
							"--"+agentzhfundLog.getModifytime());
						fundPzlog.setSubzh(username);
						fundPzlog.setFundtype(6);//充值
						fundPzlog.setSetpro(0);
						fundPzlog.setFundbalance(agentzhfundLog.getFund());
						fundPzlog.setCreatetime(agentzhfundLog.getModifytime());
						
						int n=fundPzLogService.insertFundPzlog(fundPzlog);
						log.info("insertFundPzlog:"+n);
						
						try {
							log.info("开始调协议");
							Double fundValue = fundPzlog.getFundbalance().doubleValue();
							log.info("fundValue===》"+fundValue);
							log.info("fundPzlog.getId()===》"+fundPzlog.getId());
							String rbStr = simulateStockService.commonFunction("{\"seq_no\":"+fundPzlog.getId()+",\"client_id\":\""+username+"\",\"fund_type\":5,\"prev_fund\":0.00,\"after_fund\":"+fundValue+
									",\"warning_line\":0.00,\"open_line\":0.00}",DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
							if(!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1){
								JsonParser parser = new JsonParser();
								JsonElement element = parser.parse(rbStr);
								JsonObject jsonObj = element.getAsJsonObject();
								log.info("添加账户资金状态1：" + rbStr+"---"+DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
					    		if(CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()){
					    		//掉协议成功，入金成功
					    			log.info("添加账户资金状态2：" + rbStr);
					    		} else {
					    			//入金失败
					    			log.info("添加账户资金状态3====>调协议失败：" + rbStr);
					    			try {
					    				//当用户入金失败，判断用户是否是第一次入金，如果是则还是把用户状态改为未激活
					    				List<FundPzlog> sfplist = fundPzLogService.selectBySubzh(subzh.getSubzh());
					    				if(sfplist==null&&sfplist.size()<=1) {
					    					subzh.setZhstate(0);
					    				}
					    			
					    			} catch (Exception e) {
					    				log.error("查询该用户资金流水失败", e);
									}
					    			
					    		}
							}else {
								log.info("添加账户资金状态4====>调协议失败：" + rbStr);
								try {
									//当用户入金失败，判断用户是否是第一次入金，如果是则还是把用户状态改为未激活
				    				List<FundPzlog> sfplist = fundPzLogService.selectBySubzh(subzh.getSubzh());
				    				if(sfplist==null&&sfplist.size()<=1) {
				    					subzh.setZhstate(0);
				    				}
				    			
				    			} catch (Exception e) {
				    				log.error("查询该用户资金流水失败", e);
								}
								
							}
							//修改用户状态
							try {
								int count=subzhService.updateByPrimaryKey(subzh);
								log.info("log11:subzhService"+count);
							} catch (Exception e) {
								log.error("更改用户状态异常", e);
							}
							
							map.put("return_code", return_code);
							
						} catch (Exception e) {
							if(null!=subzh) {
								
								try {
									//当用户入金出现异常，判断用户是否是第一次入金，如果是则还是把用户状态改为未激活
									log.info("log_e:subzh===>"+subzh);	
				    				List<FundPzlog> sfplist = fundPzLogService.selectBySubzh(subzh.getSubzh());
				    				if(sfplist==null&&sfplist.size()<=1) {
				    					subzh.setZhstate(0);
				    				}
				    			
				    			} catch (Exception e1) {
				    				log.error("查询该用户资金流水失败", e1);
								}
								//修改用户状态
								try {
									int count=subzhService.updateByPrimaryKey(subzh);
									log.info("log11:subzhService"+count);
								} catch (Exception e1) {
									log.error("更改用户状态异常", e1);
								}
							}						
							log.error("追加保证金异常：" + e);					
						}
						map.put("return_code", "FAIL");
			} catch (Exception e) {
				e.printStackTrace();
				log.error("异步返回支付信息失败", e);
				map.put("return_code", "FAIL");
			}
		}
			
			return map;
		}
		
		//保存资金记录。
		private AgentzhfundLog saveAgentzhfundLog(String username,String order_no,String pay_time,Integer total_fee,int paystate,String trade_no,Double fee){
			AgentzhfundLog agentzhfundLog=new AgentzhfundLog();
			try{
				agentzhfundLog.setSubzh(username);
				agentzhfundLog.setOrderno(order_no);
				agentzhfundLog.setType("wg");
				agentzhfundLog.setBz((byte)1);//充值
				agentzhfundLog.setModifytime(DateUtil.strToDateLong(pay_time));
				agentzhfundLog.setFund(((new BigDecimal(total_fee).multiply(new BigDecimal(fee)))).divide(new BigDecimal("100"),2,BigDecimal.ROUND_HALF_UP));
				
				agentzhfundLog.setModifytime(DateUtil.strToDateLong(pay_time));
				
				agentzhfundLog.setStatus(paystate);//支付成功
				agentzhfundLog.setName(username);
				
				TreeMap<String, Object> tmap =new TreeMap<String, Object>();
				tmap.put("充值人", agentzhfundLog.getName());
				tmap.put("充值单号", order_no);
				tmap.put("充值金额", agentzhfundLog.getFund());
				tmap.put("充值时间", agentzhfundLog.getModifytime());
				JSONObject description = JSONObject.parseObject(JSON.toJSONString(tmap));
				agentzhfundLog.setDescription(description.toJSONString());
				log.info("log6:"+agentzhfundLog.getDescription());
				agentzhfundLog.setAccNo(trade_no);
				int num=agentzhfundLogService.saveAgentzhFundLog(agentzhfundLog);
			}catch(Exception e){
				e.printStackTrace();
			}
			return agentzhfundLog;
		}
		
		//////////////////////////////////下面的提现逻辑暂时没调用，因为我跳到之前的提现页面了，走之前的提现H5逻辑了。//////////////////////////////////////////////////////////
		//保存提现信息，并减少了fundbalance
		@SuppressWarnings("unused")
		@RequestMapping(value = "/topay",produces="text/html;charset=UTF-8;")
		@ResponseBody
		public String  topay(AgentzhfundLog afl, HttpSession session,Model model) {
			
			log.info("保存提现信息");
			String subzh = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			log.info("subzh===》"+subzh);
			if (subzh == null) {
				log.info("subzh:账户为null");	
				return "用户不存在";
			}
			
			Subzh sub = subzhService.selectBySubzh(subzh);
			if(null==sub) {
				log.info("sub==null:用户信息为null");	
				return "用户信息为null";
			}
			
			log.info("sub===》"+sub);
			if (sub.getFundbalance() == null) {
				log.info("result1:余额不足");		
				return "余额不足1";
			}
			log.info("sub.getFundbalance===》"+sub.getFundbalance());
			//sub.getFundbalance获取限制可用资金
			
			if (sub.getFundbalance().doubleValue() - Double.valueOf(afl.getAmount()) < 0) {
				log.info("result2:余额不足");
				return "余额不足2";
			}
			sub.setFundbalance(sub.getFundbalance().subtract(new BigDecimal(afl.getAmount())));
			try {
				subzhService.updateByPrimaryKey(sub);//提现时，减少了fundbalance
			} catch (Exception e) {
				e.printStackTrace();
			}
			log.info("getSubzh:==》"+afl.getSubzh());
			TreeMap<String, Object> tmap =new TreeMap<String, Object>();
			tmap.put("amount",afl.getAmount());
			tmap.put("bankCardNumber",afl.getBankCardNumber());
			tmap.put("phoneNum", afl.getPhoneNum());
			tmap.put("idcard", afl.getIdcard());
			tmap.put("bankcode", afl.getBankcode());
			JSONObject description = JSONObject.parseObject(JSON.toJSONString(tmap));
			
			afl.setDescription(description.toJSONString());
			log.info("setDescription:==》"+afl.getDescription());
			
			afl.setSubzh(subzh);
			log.info("setSubzh:==》"+afl.getBanchname());
			
			afl.setBz((byte)2);
			
			afl.setFund(new BigDecimal(afl.getAmount()));
			afl.setStatus(0);
			afl.setType("1");
			afl.setModifytime(DateUtil.getSystemDate());
			log.info("setBz:==》"+afl.getBz());
			
			try {
				int num=agentzhfundLogService.insertagentzhfundLog(afl);
				log.info("agentzhfundLogService:==》"+num);
			} catch (Exception e) {	
				log.error("保存提现信息失败", e);
				return "提现申请提交失败，请再次提交";
			}
			
			return "ok";	
		}
		
		//审核并且提现，调用提现接口，设置AgentzhfundLog的状态
		@RequestMapping(value = "/gopaywg",produces="text/html;charset=UTF-8;")
		@ResponseBody
		public String gopaywg(Integer id, Integer status) {
			log.info("提现审核开始");
			AgentzhfundLog afl=null;
			try {
				afl = agentzhfundLogService.selectByPrimaryKey(id);
			} catch (Exception e) {
				log.info("查询待提现信息异常"+e);
			}
			
			if(afl!=null){
				if(status!=5) {
					afl.setStatus(6);
					int num=agentzhfundLogService.updateStateBysubzh(afl);
					return "审核未通过";
				}
			}else {
				return "提现信息不存在";
			}
			afl.setStatus(5);//审核通过
			String description= afl.getDescription();
			JSONObject jsonobj = JSONObject.parseObject(description);
			
			afl.setAmount(jsonobj.getString("amount"));
			afl.setBankCardNumber(jsonobj.getString("bankCardNumber"));	
			afl.setPhoneNum(jsonobj.getString("phoneNum"));
			afl.setIdcard(jsonobj.getString("idcard"));
			afl.setBankcode(jsonobj.getString("bankcode"));
			
			try {
				String subzh = afl.getSubzh();
				String dates = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
				String uuid =  dates + StringUtil.getRandomString(4)+subzh;
				if (subzh == null)
					return "result用户不存在";
			
				Subzh sub = subzhService.selectBySubzh(subzh);

				if (sub.getFundbalance() == null)
					return "result余额不足";
				//sub.getFundbalance获取限制可用资金
				if (sub.getFundbalance().doubleValue() - Double.valueOf(afl.getAmount()) < 0) {
					return "result余额不足";
				}
				
				
				String url = "http://gw.spt-pay.cn/settle";
				String testKey = Constant.SPT_SECRTKEY;// 秘钥

				TreeMap<String, String> sortedMap = new TreeMap<String, String>();
				sortedMap.put("merch", Constant.SPT_MERCHART);//商户号
				sortedMap.put("orderno", uuid);//商户订单号
				DecimalFormat decimalFormat = new DecimalFormat("###################.###########");
				sortedMap.put("amount", decimalFormat.format((Double.valueOf(afl.getAmount())) * 100));//提现金额
				sortedMap.put("notifyurl", project_path+"/subzhfund/noticePay");//异步回调通知地址
				sortedMap.put("cardtype", "1");//提现--对公对私
				sortedMap.put("bankcode", afl.getBankcode());//银行卡编码：例如工商银行：ICBC
				sortedMap.put("bankname", afl.getBankname());//银行卡开户行名称
				sortedMap.put("bankbranch", afl.getBanchname());//银行卡开户支行名称
				sortedMap.put("cardname", afl.getName());//收款人姓名
				sortedMap.put("cardno", afl.getBankCardNumber());//收款人银行账号
				sortedMap.put("cardmobile", afl.getPhoneNum());//银行预留手机号
				sortedMap.put("certid", afl.getIdcard());//身份证号
				sortedMap.put("province", afl.getProvince());//开户所在省
				sortedMap.put("city", afl.getCity());//开户所在市

				System.out.println(sortedMap.toString());
				String key_sign_zn = SignMd5Utils.createSign(sortedMap, testKey);// 签名
				sortedMap.put("sign", key_sign_zn);
				sortedMap.put("signtype", "MD5");

				String result = HttpRequest.sendPost(url, sortedMap);
				
				Map<String, String> resmap = JSON.parseObject(result, Map.class);
				String recode = resmap.get("return_code");
				String msg = resmap.get("return_msg");
				//log.info("pay_time1:"+resmap.get("pay_time"));
				log.info("log1"+recode+"----"+msg);
				if ("SETTLE_NOT_WALLET".equals(recode)) {
					return "result"+recode+":"+msg;
				}
				if ("SETTLE_OUT_UPPER".equals(recode)) {
					return "result"+recode+":"+msg;
				}
				System.out.println(recode+"-----"+msg);
				//配置状态为0,4，表示提出提现申请
				
				if ("SUCCESS".equals(recode)) {
					afl.setStatus(5);//提现成功
					afl.setOrderno(uuid);
					int num=agentzhfundLogService.updateStateBysubzh(afl);
					log.info("log2"+num);
				}else {
					int num=agentzhfundLogService.updateStateBysubzh(afl);
					return "false";
				}
			} catch (Exception e) {
				log.info("提现记录异常=>"+e);
				return "result提现失败";
			}
			return "true";	
		}
		
		@RequestMapping(value = "/noticePay",produces="text/html;charset=UTF-8;")
		@ResponseBody
		public  String  noticePay(HttpServletRequest request, Model model, @RequestBody String requestBody) {
			
			log.info("提现回调开始");	
			try {
				log.info("requestBody"+requestBody);	
				JSONObject allStr = JSONObject.parseObject(requestBody);
				TreeMap<String, String> sortedMap = new TreeMap<String, String>();
				
				sortedMap.put("order_no", allStr.getString("order_no"));
				sortedMap.put("total_fee", allStr.getString("total_fee"));
				sortedMap.put("merch_id", allStr.getString("merch_id"));
				sortedMap.put("settle_status", allStr.getString("settle_status"));
				sortedMap.put("return_code", allStr.getString("return_code"));
				sortedMap.put("settle_no", allStr.getString("settle_no"));
				String camparesign = SignMd5Utils.createSign(sortedMap, Constant.SPT_SECRTKEY);
				log.info("检查是提现回调否会执行到这里");
				String code=allStr.getString("return_code");
				String orderno=allStr.getString("order_no");
				//获取提现的账号
				String username = allStr.getString("order_no").substring(21);
				
				Subzh subzh = subzhService.selectBySubzh(username);
				log.info("username:"+username+"-----subzh:"+subzh);
				
				log.info("签名号"+allStr.getString("sign")+"-----"+camparesign);
				
				log.info("判断签名号"+allStr.getString("sign").equals(camparesign));
				
				if (allStr.getString("sign").equals(camparesign)) {
					log.info("ok");
					List<AgentzhfundLog> alist = agentzhfundLogService.selectByorderno(allStr.getString("order_no"));
					log.info("alist"+alist.size()+"---"+alist);
					
					//判断是否是通过了审核的回调
					AgentzhfundLog agentzhfundLog=null;
					
					if(alist!=null) {
						agentzhfundLog=alist.get(0);
					}
					log.info("提现审核状态：===》"+agentzhfundLog.getStatus());
					
					//操作资金明细表
					FundPzlog fundPzlog = new FundPzlog();
					
					if(code.equals("00000")){//代付成功
						if(agentzhfundLog!=null && agentzhfundLog.getStatus()!=1) {
							String description= agentzhfundLog.getDescription();
							JSONObject jsonobj = JSONObject.parseObject(description);
							log.info("jsonobj===>"+jsonobj);
							agentzhfundLog.setAmount(jsonobj.getString("amount"));
							agentzhfundLog.setBankCardNumber(jsonobj.getString("bankCardNumber"));	
							agentzhfundLog.setPhoneNum(jsonobj.getString("phoneNum"));
							agentzhfundLog.setIdcard(jsonobj.getString("idcard"));
							agentzhfundLog.setBankcode(jsonobj.getString("bankcode"));	

							log.info("log:开始记录配资"+username+
								"---6--提现"+"--"+allStr.getString("total_fee")+"--");
							fundPzlog.setSubzh(username);
							fundPzlog.setFundtype(7);//提现值
							fundPzlog.setSetpro(0);
							fundPzlog.setFundbalance(new BigDecimal(agentzhfundLog.getAmount()));
							fundPzlog.setCreatetime(DateUtil.getSystemDate());
							
							TreeMap<String, Object> tmap =new TreeMap<String, Object>();
							tmap.put("提现人", fundPzlog.getSubzh());
							tmap.put("提现单号", allStr.getString("order_no"));
							tmap.put("提现金额",allStr.getString("total_fee"));
							tmap.put("提现时间", agentzhfundLog.getModifytime());
							tmap.put("提现银行卡编号", agentzhfundLog.getBankCardNumber());
							tmap.put("提现银行卡", agentzhfundLog.getBankCardNumber());
							JSONObject descriptions = JSONObject.parseObject(JSON.toJSONString(tmap));
							fundPzlog.setSetdesc(descriptions.toJSONString());
							if(null!=subzh) {
								try {
									String rbStr = simulateStockService.commonFunction("{\"seq_no\":"+fundPzlog.getId()+",\"client_id\":\""+subzh+"\",\"fund_type\":1,"
											+ "\"prev_fund\":0.00,\"after_fund\":"+fundPzlog.getFundbalance()+",\"warning_line\":0.00,\"open_line\":0.00}", DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
									if(!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1){
										JsonParser parser = new JsonParser();
										JsonElement element = parser.parse(rbStr);
										JsonObject jsonObj = element.getAsJsonObject();
							    		if(CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()){
							    			log.error("提现成功：");
							    		}else{
											log.error("调提现接口成功提现了，但在调减少柜台资金时，出错。");
										} 
									}else{
										log.error("调提现接口成功提现了，但在调减少柜台资金时，出错。");
									}
								} catch (Exception efund) {
									log.error("调提现接口成功提现了，但在调减少柜台资金时，出错。");
									log.error("追加保证金异常：" + efund.getMessage());
								}
							}
							
							try {
								int n=fundPzLogService.insertFundPzlog(fundPzlog);
								log.info("log提现"+n+fundPzlog.getSetdesc());
							} catch (Exception e) {
								log.info("添加用户提现流水异常", e);
							}
							agentzhfundLog.setStatus(1);//代付成功
							agentzhfundLogService.updateStateBysubzh(agentzhfundLog);
					
					  }/*else {//当回调成功，且提现状态不是5的时候，把用户的钱还原到用户账户账户中
							if(null!=subzh) {
								if(subzh.getFundbalance()!=null) {
									subzh.setFundbalance(subzh.getFundbalance().add((fundPzlog.getFundbalance())));
								}
								subzhService.updateByPrimaryKey(subzh);
							}
					  }*/
					}else if(code.equals("10000")){//代付失败
						log.error("调用提现接口，返回代付失败");
						agentzhfundLog.setStatus(3);//代付失败
						agentzhfundLogService.updateStateBysubzh(agentzhfundLog);
					}else if(code.equals("20000")){//正在代付
						log.error("调用提现接口，返回正在代付");
						agentzhfundLog.setStatus(2);//代付处理中
						agentzhfundLogService.updateStateBysubzh(agentzhfundLog);
					}else if(code.equals("30000")){//提交失败
						log.error("调用提现接口，提交失败");
						agentzhfundLog.setStatus(3);//代付失败
						agentzhfundLogService.updateStateBysubzh(agentzhfundLog);
					}else if(code.equals("40000")){//未知状态
						log.error("调用提现接口，返回未知状态");
						agentzhfundLog.setStatus(3);//代付失败
						agentzhfundLogService.updateStateBysubzh(agentzhfundLog);
					}else if(code.equals("50000")){//订单不存在
						log.error("调用提现接口，返回订单不存在");
						agentzhfundLog.setStatus(3);//代付失败
						agentzhfundLog.setDescription("订单不存在，orderno:"+orderno);
						agentzhfundLogService.updateStateBysubzh(agentzhfundLog);
					}
					
					
				}
			} catch (Exception e) {
				log.info("提现异步异常:"+e);
			}
			log.info("SUCCESS--提现成功");
			return "SUCCESS";
		}
		

}