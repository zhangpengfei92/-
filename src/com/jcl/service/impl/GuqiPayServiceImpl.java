/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @GuqiPayServiceImpl.java
 * 功能概要  : 
 * 做成日期  : @2018年12月20日
 * 修改日期  :
 */
package com.jcl.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jcl.dao.AgentzhMapper;
import com.jcl.dao.AgentzhfundLogMapper;
import com.jcl.dao.FundPzlogMapper;
import com.jcl.dao.SubzhMapper;
import com.jcl.pojo.AgentzhfundLog;
import com.jcl.pojo.FundPzlog;
import com.jcl.pojo.Subzh;
import com.jcl.service.FundPzLogService;
import com.jcl.service.GuqiPayService;
import com.jcl.stock.entity.CONST;
import com.jcl.stock.simulate.DefineNumber;
import com.jcl.stock.simulate.service.SimulateStockService;
import com.jcl.util.DeployProperties;
import com.jcl.util.MapRemoveNullUtil;
import com.jcl.util.StringUtil;
import com.jcl.util.pay.HttpClient;
import com.jcl.util.pay.MD5;
import com.jcl.util.pay.SignUtils;

/** 
 * @author zpf
 * @version 1.0
 * 股期策略支付实现层
 */
@Service
public class GuqiPayServiceImpl implements GuqiPayService{
	
	public static Logger log = Logger.getLogger(GuqiPayServiceImpl.class);
	
	@Autowired
	private AgentzhfundLogMapper agentzhfundLogMapper;
	
	@Autowired
	private SubzhMapper subzhMapper;
	
	@Autowired
	private FundPzLogService fundPzLogService;
	
	@Autowired
	public SimulateStockService simulateStockService;
	
	@Autowired
	private FundPzlogMapper fundPzlogMapper;
	
	private static final String agentNo=DeployProperties.getInstance().getProperty("public.gpay.agentNo");//渠道号
	private static final String merchantNo=DeployProperties.getInstance().getProperty("public.gpay.merchantNo");//商务号
	private static final String key=DeployProperties.getInstance().getProperty("public.gpay.key");//key
	private static final String URL=DeployProperties.getInstance().getProperty("public.gpay.URL");//接口地址
	private static final String notifyUrl=DeployProperties.getInstance().getProperty("public.gpay.notifyUrl");//异步回调地址
	private static final String callbackUrl=DeployProperties.getInstance().getProperty("public.gpay.callbackUrl");//同步响应URL
	private static final String acqCode=DeployProperties.getInstance().getProperty("public.gpay.acqCode");//充值方式
	

	@Override
	public Map<String, Object> doPay(AgentzhfundLog entity){
			Map<String, Object> resmap= new HashMap<String, Object>();
			Map<String, String> map = new HashMap<String, String>();
			try {
				if(!StringUtil.isAllNullOrEmpty(entity.getOrderno())) {
					List<AgentzhfundLog> alist = agentzhfundLogMapper.selectByorderno(entity.getOrderno());				
						if (alist != null && alist.size() > 0) {
							log.info("订单重复：" + entity.getOrderno());
							 resmap.put("status",false);
		        			 resmap.put("msg","订单重复"+ entity.getOrderno());
		        			 return resmap;
						}	
				}else {
					 resmap.put("status",false);
        			 resmap.put("msg","订单号不存在");
        			 return resmap;
				}
				
				map.put("agentNo", agentNo);
		        map.put("merchantNo", merchantNo);
		        String  amount =entity.getFund().multiply(new BigDecimal(100)).setScale(0).toString();
		        map.put("orderAmount",amount);
		        map.put("outOrderNo",entity.getOrderno());
		        map.put("notifyUrl",notifyUrl);
		        map.put("callbackUrl",callbackUrl);
		        map.put("productName","guqichongzhi");
		        map.put("acqCode", entity.getBankcode());		
		        String signStr = SignUtils.payParamsToString(map);
		        signStr = signStr + key;
		        log.info("充值加密前参数-"+signStr);
		
		        String sign = MD5.md5Str(signStr);
		        log.info("MD5加密后的结果=" + sign);
		        map.put("sign", sign);
		        log.info("充值发起请求参数-"+map.toString());
		        entity.setStatus(0);
		        entity.setType("1");
		        entity.setBz((byte)1);
		        entity = saveAgentzhfundLog(entity);//保存充值信息
		        log.info("-----"+entity.getId());
		        if(entity.getId()>0) {
		        	 String response = HttpClient.post(URL, map);
		        	 log.info("充值接口返回参数 ："+response);
		        	 if(!StringUtil.isAllNullOrEmpty(response)){		        		 
		        		 Map <String, Object> responsemap= JSON.parseObject(response, Map.class);
		        		 if("T".equals(responsemap.get("status"))) {
		        			 resmap.put("status",true);
						     resmap.put("payUrl",responsemap.get("payUrl"));
		        		 }else if("F".equals(responsemap.get("status"))){
		        			 resmap.put("status",false);
						     resmap.put("msg",responsemap.get("errMsg")+"错误代码："+responsemap.get("errCode"));
		        		 }else {
		        			 resmap.put("status",false);
		        			 resmap.put("msg","充值接口，请联系管理员");  
		        		 }
		        	 }else {
		        		resmap.put("status",false);
				        resmap.put("msg","充值接口状态不明，请联系管理员"); 
		        	 }
		        }else {
		        	resmap.put("status",false);
		        	resmap.put("msg","保存充值信息失败");
		        }	
			} catch (Exception e) {
				e.printStackTrace();
				log.error("充值异常",e);
				resmap.put("status",false);
				resmap.put("msg","充值异常");	
			}	        
		return resmap;
	}
	
	@Override
	public Map<String, Object> payNotify(HttpServletRequest request) {
		Map<String, Object> resmap= new HashMap<String, Object>();
		try {
			Map<String, String> notifyParams = new HashMap<String, String>();
	        Enumeration enu = request.getParameterNames();
	        while(enu.hasMoreElements()){
	            String paraName=(String)enu.nextElement();
	            notifyParams.put(paraName, request.getParameter(paraName));
	        }
	        log.info("充值回调结果 ："+notifyParams.toString());
	        if(notifyParams!=null) {
	        	if("SUCCESS".equals(notifyParams.get("orderStatus"))){
	        		List<AgentzhfundLog> alist = agentzhfundLogMapper.selectByorderno(notifyParams.get("outOrderNo"));
	    			if (alist == null) {
	    				log.info("订单号不存在");
	    				resmap.put("status", false);
						resmap.put("msg", "订单号"+notifyParams.get("outOrderNo")+"不存在");
						return resmap;
	    			}
	    			if (alist.size() != 1) {
	    				log.info("订单号重复");
	    				resmap.put("status", false);
						resmap.put("msg", "订单号"+notifyParams.get("outOrderNo")+"重复");
						return resmap;
	    			}
	    		String ressign=notifyParams.get("sign");
	    		MapRemoveNullUtil.removeNullEntry(notifyParams);
	    		notifyParams.remove("sign");
	    		String signstr = SignUtils.payParamsToString(notifyParams);
	    		String sign = MD5.md5Str(signstr+key);
	    		log.info("充值回调参加验签参数 ： "+signstr+key+"-加密验签结果 ："+sign+"-返回验签串"+ressign);
	    		
	    		if(!sign.equals(ressign)) {
	    			log.info("验签失败");
    				resmap.put("status", false);
					resmap.put("msg","验签失败");
					return resmap;
	    		}
	    		
	    		AgentzhfundLog agentzhfundLog = alist.get(0);
				agentzhfundLog.setDescription("充值回调 :" + notifyParams.toString());
				agentzhfundLog.setAccNo(notifyParams.get("orderNo"));
				Subzh subzh = subzhMapper.selectByPrimaryKeySubzh(agentzhfundLog.getSubzh());
				if (subzh == null) {
					log.info("用户信息不存在");
					resmap.put("status", false);
					resmap.put("msg","用户信息不存在");
					return resmap;
				}
				if (agentzhfundLog.getStatus() == 0){
					// 修改交易状态
					subzh.setZhstate(1);
					int count = subzhMapper.updateByPrimaryKeySelective(subzh);
					// 写资金流水表
					FundPzlog pzlog = new FundPzlog();
					pzlog.setSubzh(subzh.getSubzh());
					int key = fundInto(agentzhfundLog);
					if (key > 0) {
						log.info("资金流水入库成功!" + agentzhfundLog.getOrderno());
						subzh.setId(key);
						// 调协议给账户添加充值金额
						if (count > 0 && subzh.getZhstate() == 1) {// 状态为1，表示账户激活，激活账户才能调柜台入金协议
							//调用协议增加资金
							Map<String, Object> addmap = addMoney(subzh, agentzhfundLog);
							log.info("调柜台返回结果 ："+addmap.toString());
							resmap.put("status", true);
							resmap.put("msg","充值成功");
						}
					}else{
						resmap.put("status", false);
						resmap.put("msg","保存资金流水失败");

					}
				} else {
					log.info(notifyParams.get("outOrderNo")+ "未查到订单，或者订单已处理");
					resmap.put("status", false);
					resmap.put("msg",notifyParams.get("outOrderNo")+ "未查到订单，或者订单已处理");
				}
	    		
	        	}else {
	        		resmap.put("status", false);
					resmap.put("msg", "充值失败");
	        	}
	        }else {
	        	resmap.put("status", false);
				resmap.put("msg", "充值回调未返回参数");
	        }
		} catch (Exception e) {
			resmap.put("status", false);
			resmap.put("msg", "充值回调异常");
			log.error("充值回调异常", e);
		}

		return resmap;
	}
	
	@Override
	public Map<String, Object> payCallback(HttpServletRequest request) {
		Map<String, Object> resmap= new HashMap<String, Object>();
		try {
			Map<String, String> notifyParams = new HashMap<String, String>();
	        Enumeration enu = request.getParameterNames();
	        while(enu.hasMoreElements()){
	            String paraName=(String)enu.nextElement();
	            notifyParams.put(paraName, request.getParameter(paraName));
	        }
	        log.info("充值回调结果 ："+notifyParams.toString());
	        if(notifyParams!=null) {
	        	if("SUCCESS".equals(notifyParams.get("orderStatus"))){
	        		List<AgentzhfundLog> alist = agentzhfundLogMapper.selectByorderno(notifyParams.get("outOrderNo"));
	    			if (alist == null) {
	    				log.info("订单号不存在");
	    				resmap.put("status", false);
						resmap.put("msg", "订单号"+notifyParams.get("outOrderNo")+"不存在");
						return resmap;
	    			}
	    			if (alist.size() != 1) {
	    				log.info("订单号重复");
	    				resmap.put("status", false);
						resmap.put("msg", "订单号"+notifyParams.get("outOrderNo")+"重复");
						return resmap;
	    			}
	    		String ressign=notifyParams.get("sign");
	    		MapRemoveNullUtil.removeNullEntry(notifyParams);
	    		notifyParams.remove("sign");
	    		String signstr = SignUtils.payParamsToString(notifyParams);
	    		String sign = MD5.md5Str(signstr+key);
	    		log.info("充值回调参加验签参数 ： "+signstr+key+"-加密验签结果 ："+sign+"-返回验签串"+ressign);
	    		
	    		if(!sign.equals(ressign)) {
	    			log.info("验签失败");
    				resmap.put("status", false);
					resmap.put("msg","验签失败");
					return resmap;
	    		}
	    		
	    		AgentzhfundLog agentzhfundLog = alist.get(0);
				agentzhfundLog.setDescription("充值回调 :" + notifyParams.toString());
				Subzh subzh = subzhMapper.selectByPrimaryKeySubzh(agentzhfundLog.getSubzh());
				if (subzh == null) {
					log.info("用户信息不存在");
					resmap.put("status", false);
					resmap.put("msg","用户信息不存在");
					return resmap;
				}
				if (agentzhfundLog.getStatus() == 0) {
					Map<String, Object> addmap = addMoney(subzh, agentzhfundLog);
					log.info("调柜台返回结果 ："+addmap.toString());
					resmap.put("status", true);
					resmap.put("msg","充值订单提交成功");
				
				} else {
					log.info(notifyParams.get("outOrderNo")+ "未查到订单，或者订单已处理");
					resmap.put("status", false);
					resmap.put("msg",notifyParams.get("outOrderNo")+ "未查到订单，或者订单已处理");
				}
	    		
	        	}else {
	        		resmap.put("status", false);
					resmap.put("msg", "充值失败");
	        	}
	        }else {
	        	resmap.put("status", false);
				resmap.put("msg", "充值回调未返回参数");
	        }
		} catch (Exception e) {
			resmap.put("status", false);
			resmap.put("msg", "充值回调异常");
			log.error("充值回调异常", e);
		}

		return resmap;
	}
	
	/**
	 * 
	 * @param agentzhfundLog 
	 * @return
	 */
	private AgentzhfundLog saveAgentzhfundLog(AgentzhfundLog agentzhfundLog){
		
		try{
			agentzhfundLog.setCreatetime(new Date());
			int num=agentzhfundLogMapper.insertSelective(agentzhfundLog);		
		}catch(Exception e){
			e.printStackTrace();
		}
		return agentzhfundLog;
	}

	/**
	 * 调柜台入金协议
	 * 
	 * @param subzh
	 *            账户信息
	 * @param agentzhfundLog
	 *            提现信息
	 * @return
	 */

	public Map<String, Object> addMoney(Subzh subzh, AgentzhfundLog agentzhfundLog){
		Map<String, Object> map = new HashMap<String, Object>();
		log.info("调柜台的入金金额" + agentzhfundLog.getFund());
		// 计算汇率，调柜台协议，把钱加到柜台账户
		BigDecimal fundbalance = agentzhfundLog.getFund();
		try {
			if (subzh != null && subzh.getIsadmin() == 6) {
				log.info("{\"seq_no\":" + subzh.getId() + ",\"client_id\":\"" + subzh.getSubzh()
						+ "\",\"fund_type\":5,\"prev_fund\":0.00,\"after_fund\":" + fundbalance
						+ ",\"warning_line\":0.00,\"open_line\":0.00}" + "-------"
						+ DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
				String rbStr = simulateStockService.commonFunction(
						"{\"seq_no\":" + subzh.getId() + ",\"client_id\":\"" + subzh.getSubzh()
								+ "\",\"fund_type\":5,\"prev_fund\":0.00,\"after_fund\":" + fundbalance
								+ ",\"warning_line\":0.00,\"open_line\":0.00}",
						DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
				if (!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1) {
					JsonParser parser = new JsonParser();
					JsonElement element = parser.parse(rbStr);
					JsonObject jsonObj = element.getAsJsonObject();
					log.info("调入金协议成功1：" + rbStr + "---" + DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
					if (CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()) {
						// 掉协议成功，入金成功
						log.info("调入金协议成功2：" + rbStr);
						map.put("status", true);
						map.put("msg", "调入金协议成功");
					} else {
						// 入金失败
						log.info("调入金协议失败：" + rbStr);
						map.put("status", false);
						map.put("msg", "调入金协议失败");
					}
				} else {
					log.info("调入金协议失败：" + rbStr);
					map.put("status", false);
					map.put("msg", "调入金协议失败");
				}
			} else {
				if (subzh.getFundbalance() != null) {
					subzh.setFundbalance(subzh.getFundbalance().add((agentzhfundLog.getFund())));
				}
				subzhMapper.updateByPrimaryKeySelective(subzh);
			}
		} catch (Exception e) {
			log.error("调入金协议出现异常", e);
		}
		return map;
	}
	
	public int fundInto(AgentzhfundLog agentzhfundLog) {
		agentzhfundLog.setStatus(1);
		agentzhfundLog.setModifytime(new Date());
		agentzhfundLogMapper.updateByPrimaryKeySelective(agentzhfundLog);
		FundPzlog fundPzlog = new FundPzlog();
		fundPzlog.setSubzh(agentzhfundLog.getSubzh());
		fundPzlog.setFundtype(6);
		fundPzlog.setSetpro(1);
		fundPzlog.setFundbalance(agentzhfundLog.getFund());
		fundPzlog.setSetdesc(agentzhfundLog.getOrderno());
		fundPzlog.setCreatetime(new Date());
		int i = fundPzlogMapper.insertSelective(fundPzlog);
		if(i>0){
			return fundPzlog.getId();
		}
		
		return 0;
	}

}
