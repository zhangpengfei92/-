/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @CxpayServiceImpl.java
 * 功能概要  : 
 * 做成日期  : @2018年11月16日
 * 修改日期  :
 */
package com.jcl.service.impl;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.jcl.dao.AgentzhfundLogMapper;
import com.jcl.dao.FundPzlogMapper;
import com.jcl.dao.SubzhMapper;
import com.jcl.pojo.AgentzhfundLog;
import com.jcl.pojo.FundPzlog;
import com.jcl.pojo.FundPzlogExample;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.FundPzlogExample.Criteria;
import com.jcl.service.CxpayService;
import com.jcl.stock.entity.CONST;
import com.jcl.stock.simulate.DefineNumber;
import com.jcl.stock.simulate.service.SimulateStockService;
import com.jcl.util.DateUtil;
import com.jcl.util.DeployProperties;
import com.jcl.util.MapRemoveNullUtil;
import com.jcl.util.PayUtils;
import com.jcl.util.StringUtil;
import com.jcl.util.Tools;
import com.jcl.util.spt.HttpRequest;

/** 
 * @author zpf
 * @version 1.0
 */
@Service
public class CxpayServiceImpl implements CxpayService{
	
	//资金明细的mapper
	@Autowired
	private AgentzhfundLogMapper agentzhfundLogMapper;
		
	//用户的mapper
	@Autowired
	private SubzhMapper subzhMapper;
		
	//用户配资的mapper
	@Autowired
	private FundPzlogMapper pzlogMapper;
		
	//调协议的服务
	@Autowired
	private  SimulateStockService simulateStockService;
	
	public static Logger log = Logger.getLogger(CxpayServiceImpl.class);
	
	private static final String url=DeployProperties.getInstance().getProperty("public.pay.url");//接口URL
	
	private static final String apiKey=DeployProperties.getInstance().getProperty("public.pay.apiKey");//秘钥
	
	private static final String customerid=DeployProperties.getInstance().getProperty("public.pay.customerid");//商务号
	
	private static final String version =DeployProperties.getInstance().getProperty("public.pay.version");//版本
	
	private static final String returnurl =DeployProperties.getInstance().getProperty("public.pay.returnurl");//同步返回地址
	
	private static final String notifyurl = DeployProperties.getInstance().getProperty("public.pay.notifyurl");//回调地址
	
	private static final String paytype = DeployProperties.getInstance().getProperty("public.pay.paytype");//支付方式
	
	private static final String remark = DeployProperties.getInstance().getProperty("public.pay.remark");//备注

	private static final  String APP_ID=DeployProperties.getInstance().getProperty("public.pay.APP_ID");
	
	private static final  String PAY_KEY=DeployProperties.getInstance().getProperty("public.pay.PAY_KEY");
	
	private static final String second_returnurl =DeployProperties.getInstance().getProperty("public.pay.second_returnurl");//同步返回地址
	
	private static final String second_notifyurl = DeployProperties.getInstance().getProperty("public.pay.second_notifyurl");//回调地址
	
	private static final String spbill_create_ip = DeployProperties.getInstance().getProperty("public.pay.spbill_create_ip");//本地IP
	
	private static final String bankcode=DeployProperties.getInstance().getProperty("public.pay.bankcode");//支付方式

	private static final String second_url=DeployProperties.getInstance().getProperty("public.pay.second_url");//接口URL
	
	private static final String order_name=DeployProperties.getInstance().getProperty("public.pay.order_name");//接口URL
	
	//重信支付网关充值接口
	@Override
	public Map<String, Object> pay(String subzh, String total_fee, String bankcode, String sdorderno) {
		  Map<String, Object>resmap = new  HashMap<String, Object>();
		try {
		   DecimalFormat df=new DecimalFormat("######.00");
		   total_fee=df.format(Double.valueOf(total_fee)).toString();
		   String noSignstr = "version="+version+"&customerid="+customerid+"&total_fee="+total_fee
			        +"&sdorderno="+sdorderno+"&notifyurl="+notifyurl+"&returnurl="+returnurl+"&"+apiKey;		
		   String sign = getMD5(noSignstr);		   
		   Map<String, String>map = new  HashMap<String, String>();
		   map.put("version", version);//版本
		   map.put("customerid", customerid);//商户号
		   map.put("sdorderno", sdorderno);//订单号
		   map.put("total_fee", total_fee);//金额
		   map.put("paytype", paytype);//支付方式
		   map.put("bankcode", bankcode);//银行编号
		   map.put("remark", remark);//备注
		   map.put("returnurl", returnurl);//同步返回的url
		   map.put("notifyurl", notifyurl);//异步回调的url
		   map.put("sign", sign);//加密串
		   AgentzhfundLog agentzhfundLog = new AgentzhfundLog();	
		   agentzhfundLog= saveAgentzhfundLog(agentzhfundLog, subzh, sdorderno, new Date(),  new BigDecimal(total_fee), 0, 1);
		   log.info("充值输入参数 ：--"+map);
		   log.info("充值接口地址 ：--"+url);
		   String result = HttpRequest.sendPost(url, map);
		   log.info("时间 ："+new Date()+"  --结果 ："+result);
		   if(result.indexOf("form")>1) {
			   resmap.put("status", true);
			   resmap.put("msg","充值申请成功");
			   resmap.put("result",result);
		   }else {
			   resmap.put("status", false);
			   resmap.put("msg","充值申请失败");
			   resmap.put("result",result);
		   }
		} catch (Exception e) {
			log.info("保存充值信息异常", e);
			resmap.put("status", false);
			resmap.put("msg","保存充值信息异常");
		    resmap.put("result","保存充值信息异常,请联系管理员");
		}
		return resmap;
	}
	
	//重信支付快捷扫码的接口
		@Override
		public Map<String, Object> appPay(String subzh, String total_fee, String sdorderno) {
			  Map<String, Object>resmap = new  HashMap<String, Object>();
			try {
			   DecimalFormat df=new DecimalFormat("######.00");
			   total_fee=df.format(Double.valueOf(total_fee)).toString();
			   String noSignstr = "version="+version+"&customerid="+customerid+"&total_fee="+total_fee
				        +"&sdorderno="+sdorderno+"&notifyurl="+notifyurl+"&returnurl="+returnurl+"&"+apiKey;		
			   String sign = getMD5(noSignstr);		   
			   Map<String, String>map = new  HashMap<String, String>();
			   map.put("version", version);//版本
			   map.put("customerid", customerid);//商户号
			   map.put("sdorderno", sdorderno);//订单号
			   map.put("total_fee", total_fee);//金额
			   map.put("paytype", "pgzfb");//支付方式
			   map.put("remark", remark);//备注
			   map.put("returnurl", returnurl);//同步返回的url
			   map.put("notifyurl", notifyurl);//异步回调的url
			   map.put("sign", sign);//加密串
			   AgentzhfundLog agentzhfundLog = new AgentzhfundLog();	
			   agentzhfundLog= saveAgentzhfundLog(agentzhfundLog, subzh, sdorderno, new Date(),  new BigDecimal(total_fee), 0, 1);
			   String result = HttpRequest.sendPost(url, map);
			   log.info("时间 ："+new Date()+"  --结果 ："+result);		
			   if(result.startsWith("{")&&result.endsWith("}")) {
				   Map <String,Object> rmap = JSONObject.parseObject(result, Map.class);
				   if("0".equals(rmap.get("code"))) {
					   resmap.put("status", true);
					   resmap.put("msg","充值申请成功");
					   resmap.put("result",rmap.get("msg"));
				   }
			   }else {
				   resmap.put("status", false);
				   resmap.put("msg","充值申请失败");
				   resmap.put("result",result);
			   }
			} catch (Exception e) {
				log.info("保存充值信息异常", e);
				resmap.put("status", false);
				resmap.put("msg","保存充值信息异常");
			    resmap.put("result","保存充值信息异常,请联系管理员");
			}
			return resmap;
		}
	
	
	@Override
	public Map<String, Object> payReturn(HttpServletRequest request) {
		log.info("充值返回地址");
		 Map<String, Object>resmap = new  HashMap<String, Object>();
		try {
	    String status = request.getParameter("status");
	    String customerid = request.getParameter("customerid");
	    String sdorderno = request.getParameter("sdorderno");
	    String total_fee = request.getParameter("total_fee");
	    String paytype = request.getParameter("paytype");
	    String sdpayno = request.getParameter("sdpayno");
	    String remark = request.getParameter("remark");
	    String sign = request.getParameter("sign");

	    String noSignstr = "customerid="+customerid+"&status="+status+"&sdpayno="+sdpayno+
	    		"&sdorderno="+sdorderno+"&total_fee="+total_fee+"&paytype="+paytype+"&"+apiKey;		   
	    String mysign = getMD5(noSignstr);
	    log.info("---充值回调结果参数---- ："+noSignstr);
	    log.info("--充值返回结果验签 ：sign---"+sign);
	    log.info("--本地验签 ：mysign---"+mysign);
	    log.info("--验签结果-mysign.equals(sign)---"+mysign.equals(sign));
	    
	    resmap.put("status", true);
		resmap.put("msg", "充值完成");
	    }catch (Exception e) {
	    	log.error("充值回调异常", e);
	    	resmap.put("status", false);
			resmap.put("msg", "充值回调异常");
		}
		return resmap;
	}

	@Override
	public Map<String, Object> payNotify(HttpServletRequest request) {
		 Map<String, Object>resmap = new  HashMap<String, Object>();
		try {
			log.info("充值异步回调地址");
		    String status = request.getParameter("status");
		    String customerid = request.getParameter("customerid");
		    String sdorderno = request.getParameter("sdorderno");
		    String total_fee = request.getParameter("total_fee");
		    String paytype = request.getParameter("paytype");
		    String sdpayno = request.getParameter("sdpayno");
		    String remark = request.getParameter("remark");
		    String sign = request.getParameter("sign");		    
		    String noSignstr = "customerid="+customerid+"&status="+status+"&sdpayno="+sdpayno+
		    		"&sdorderno="+sdorderno+"&total_fee="+total_fee+"&paytype="+paytype+"&"+apiKey;	    
		    log.info("---充值回调结果参数---- ："+noSignstr);

		    String mysign = getMD5(noSignstr);
		    log.info("--充值回调结果验签 ：sign---"+sign);
		    log.info("--本地验签 ：mysign---"+mysign);
		    log.info("--验签结果-mysign.equals(sign)---"+mysign.equals(sign));
		    AgentzhfundLog afl=new AgentzhfundLog();
		    if(mysign.equals(sign)){
		    	
		    	if(status.equals("1")){
		    		//在这里填写处理代码
		    	List<AgentzhfundLog>alist = agentzhfundLogMapper.selectByorderno(sdorderno);
				if(alist!=null&&alist.size()>0) {
	    			afl=alist.get(0);
	    			if(afl.getStatus()==1){//已经充值成功了。
	    				log.info("该单号充值已完成"+new Date().toString());
	    				resmap.put("status", true);
	    				resmap.put("msg", "该单号充值已完成");
	    				return resmap;
	    			}	    			
	    		}else {
	    			log.info("该单号不存在"+new Date().toString());
    				resmap.put("status", false);
    				resmap.put("msg", "该单号不存在");
    				return resmap;
	    		}
				String subzh= afl.getSubzh();
				Subzh subzhEntity = subzhMapper.selectBySubzh(subzh);
				
				if(subzhEntity==null) {
					log.info("用户"+subzh+"信息不存在");
    				resmap.put("status", false);
    				resmap.put("msg", "用户"+subzh+"信息不存在");
    				return resmap;
				}
				
				subzhEntity.setZhstate(1);
	    		int count=subzhMapper.updateByPrimaryKeySelective(subzhEntity);
	    		log.info("log11:subzhService"+count);
	    		List<FundPzlog> sfplist = getFundPzlogList(subzhEntity);
	    		//调柜台
	    	    Map<String, Object> amap=addMoney(subzhEntity, afl);
	    	    if(null!=amap&&amap.size()>0) {
	    	    	if(null!=amap.get("status")&&(Boolean) amap.get("status")) {
	    	    		afl.setStatus(1);
	    	    		resmap.put("status", true);
	    	    		resmap.put("msg", "充值成功");
	    	        	FundPzlog fundPzlog = saveFundpzlog(subzh, afl.getFund(), sdorderno, DateUtil.getSystemDate(), 6);	    	
	    	    	}else {
	    	    		afl.setStatus(2);//修改状态为2 --表示充值失败	 
	    	    		resmap.put("status", false);
	    	    		resmap.put("msg", "充值失败");
	    	        	
	    	   		 	if ((sfplist == null) && (sfplist.size() <= 1)) {
	    	   		 	subzhEntity.setZhstate(Integer.valueOf(0));
	    	   		 	}
	    	    	  }
	    	    	}else {
		    	    	afl.setStatus(2);//修改状态为2 --表示充值失败
		    	    	resmap.put("status", false);
		    	    	resmap.put("msg", "充值失败");
			        	if ((sfplist == null) && (sfplist.size() <= 1)) {
			        		subzhEntity.setZhstate(Integer.valueOf(0));
	    	   		 	}
		    	    }
	    	    if(afl.getStatus()==2) {
	    	    	  log.info(subzhMapper.updateByPrimaryKeySelective(subzhEntity)>0?"充值回调失败后修改用户激活状态成功":"充值回调失败后修改用户激活状态失败");
	    	    }
		    	}else{
		    		log.info("订单"+sdorderno+"充值失败"+new Date().toString());
    				resmap.put("status", false);
    				resmap.put("msg", "订单"+sdorderno+"充值失败");
    				return resmap;
		    	}

			}else{
				log.info("订单"+sdorderno+"验签失败"+new Date().toString());
				resmap.put("status", false);
				resmap.put("msg", "订单"+sdorderno+"验签失败");
				return resmap;
			}
		} catch (Exception e) {
			log.error("充值回调异常", e);
			resmap.put("status", false);
			resmap.put("msg","充值回调异常");
		}
		
		return resmap;
	}

	/*public  String getMD5(String str) {
        try {
            
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            md.update(str.getBytes());
            
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    } */
	

    public static String getMD5(String str) throws Exception {
        /** 创建MD5加密对象 */
        MessageDigest md5 = MessageDigest.getInstance("MD5"); 
        /** 进行加密 */
        md5.update(str.getBytes());
        /** 获取加密后的字节数组 */
        byte[] md5Bytes = md5.digest();
        String res = "";
        for (int i = 0; i < md5Bytes.length; i++){
            int temp = md5Bytes[i] & 0xFF;
            if (temp <= 0XF){ // 转化成十六进制不够两位，前面加零
                res += "0";
            }
            res += Integer.toHexString(temp);
        }
        return res;
    }
	
	//根据用户名去查询配资信息
		public List<FundPzlog> getFundPzlogList(Subzh subzh){
			List<FundPzlog> sfplist = new ArrayList<FundPzlog>();
			try {
				FundPzlogExample example=new FundPzlogExample();
				Criteria createCriteria = example.createCriteria();
				createCriteria.andSubzhEqualTo(subzh.getSubzh());
				sfplist = pzlogMapper.selectByExample(example);
			} catch (Exception e) {
				log.error("查询用户配资信息", e);
			}
			return sfplist;
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
	private AgentzhfundLog saveAgentzhfundLog(AgentzhfundLog agentzhfundLog,String username,String order_no,Date pay_time,BigDecimal total_fee,int paystate,int bz){
		try{
			String type=paystate==0?"rj":paystate==3?"tzrj":paystate==6?"tx":paystate==11?"tzcj":"qt";
			agentzhfundLog.setSubzh(username);
			agentzhfundLog.setOrderno(order_no);
			agentzhfundLog.setType(type);
			agentzhfundLog.setBz((byte)bz);//充值
			agentzhfundLog.setModifytime(pay_time);
			agentzhfundLog.setFund(total_fee);
			agentzhfundLog.setStatus(paystate);//支付成功
			agentzhfundLog.setName(agentzhfundLog.getName());
			
			TreeMap<String, Object> tmap =new TreeMap<String, Object>();
			if(bz==2) {//提现
				tmap.put("amount",total_fee);
				tmap.put("bankCardNumber",agentzhfundLog.getBankCardNumber());
				tmap.put("phoneNum", agentzhfundLog.getPhoneNum());
				tmap.put("idcard", agentzhfundLog.getIdcard());
				tmap.put("bankcode", agentzhfundLog.getBankcode());
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
				int num=agentzhfundLogMapper.insertSelective(agentzhfundLog);
				log.info("agentzhfundLogMapper==SUCCESS:"+num);
		}catch(Exception e){
			e.printStackTrace();
		}
		return agentzhfundLog;
	}
	
	/**
	 * 配资方法
	 * @param username 用户名
	 * @param accmoney 配资金额
	 * @param orderno 订单号
	 * @param paytime 配资时间
	 * @param fundtype 配资类型
	 * @return
	 */
	public FundPzlog saveFundpzlog(String username,BigDecimal accmoney,String orderno,Date paytime,int fundtype) {
		FundPzlog fundPzlog =new FundPzlog(); 
		log.info("log:开始记录配资"+username+
				"---8--"+"--"+accmoney+"--");
			fundPzlog.setSubzh(username);
			// 1:配资 资金比例 2:加配资金比例 3:减配  4:追加保证金 5:出金  6:充值 7:提现 8:调账入金 9调账出金*/
			fundPzlog.setFundtype(fundtype);
			fundPzlog.setSetpro(0);
			fundPzlog.setFundbalance(accmoney);
			fundPzlog.setCreatetime(DateUtil.getSystemDate());
			
			TreeMap<String, Object> tmap =new TreeMap<String, Object>();
			tmap.put("操作人", fundPzlog.getSubzh());
			tmap.put("操作单号", orderno);
			tmap.put("操作金额",accmoney);
			tmap.put("操作时间",paytime);
			JSONObject descriptions = JSONObject.parseObject(JSON.toJSONString(tmap));
			fundPzlog.setSetdesc(descriptions.toJSONString());
			try {
				int n=pzlogMapper.insertSelective(fundPzlog);
				log.info("log操作配资===》"+n+"=====>"+fundPzlog.getSetdesc());
			} catch (Exception e) {
				log.info("操作配资失败", e);
			}
			return fundPzlog;
	}
	
	
	/**
	 * 调柜台入金协议
	 * @param subzh 账户信息
	 * @param agentzhfundLog  提现信息
	 * @return
	 */
	
	public Map<String, Object> addMoney(Subzh subzh,AgentzhfundLog agentzhfundLog){
			Map<String, Object> map=new HashMap<String, Object>();
			log.info("调柜台的入金金额"+agentzhfundLog.getFund());
			//计算汇率，调柜台协议，把钱加到柜台账户
			BigDecimal fundbalance =agentzhfundLog.getFund();
			try {
				if(subzh!=null&&subzh.getIsadmin()==6) {
					log.info("{\"seq_no\":"+agentzhfundLog.getId()+",\"client_id\":\""+subzh.getSubzh()+"\",\"fund_type\":5,\"prev_fund\":0.00,\"after_fund\":"+fundbalance+
							",\"warning_line\":0.00,\"open_line\":0.00}"+"-------"+DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
					String rbStr = simulateStockService.commonFunction("{\"seq_no\":"+agentzhfundLog.getId()+",\"client_id\":\""+subzh.getSubzh()+"\",\"fund_type\":5,\"prev_fund\":0.00,\"after_fund\":"+fundbalance+
							",\"warning_line\":0.00,\"open_line\":0.00}",DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
					if(!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1){
						JsonParser parser = new JsonParser();
						JsonElement element = parser.parse(rbStr);
						JsonObject jsonObj = element.getAsJsonObject();
						log.info("调入金协议成功1：" + rbStr+"---"+DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
			    		if(CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()){
			    		//掉协议成功，入金成功			    			
			    			log.info("调入金协议成功2：" + rbStr);
			    			map.put("status", true);
			    			map.put("msg", "调入金协议成功");
			    		} else {
			    			//入金失败
			    			log.info("调入金协议失败：" + rbStr);
			    			map.put("status", false);
			    			map.put("msg", "调入金协议失败");
			    		}
					}else {
						log.info("调入金协议失败：" + rbStr);
		    			map.put("status", false);
		    			map.put("msg", "调入金协议失败");
					}
				}else {
					if(subzh.getFundbalance()!=null) {
						subzh.setFundbalance(subzh.getFundbalance().add((agentzhfundLog.getFund())));
				}
					subzhMapper.updateByPrimaryKeySelective(subzh);
				}
			} catch (Exception e) {
				log.error("调入金协议出现异常",e);
			}
			return map;
		}

	/**
	 * //调柜台出金协议
	 * @param subzh 账户信息
	 * @param afl  出金信息
	 * @return
	 */
	
	public Map<String, Object> getMoney(Subzh subzh,AgentzhfundLog afl){
			Map<String, Object> map=new HashMap<String, Object>();
			//计算汇率，调柜台协议，把钱加到柜台账户
			log.info("调柜台的出金金额"+afl.getFund());
			BigDecimal fundbalance =afl.getFund();
			if(null!=afl&&afl.getId()!=null&&afl.getId()!=0){	
				try {
					log.info("提现调柜台协议开始");
					
					String  str="{\"seq_no\":"+afl.getId()+",\"client_id\":\""+subzh.getSubzh()+"\",\"fund_type\":1,\"prev_fund\":0.00,\"after_fund\":"+fundbalance+
							",\"warning_line\":0.00,\"open_line\":0.00}";
					
					String rbStr = simulateStockService.commonFunction(str,DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
					log.info("传到柜台的参数"+rbStr);
					if(!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1){
						JsonParser parser = new JsonParser();
						JsonElement element = parser.parse(rbStr);
						JsonObject jsonObj = element.getAsJsonObject();
			    		if(CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()){
			    			log.info("调柜台协议成功");
			    			//保存资金流水信息
			    			map.put("status", true);
			    			map.put("msg", "申请提现成功");
			    		} else{
			    			//调柜台协议失败删除该条记录
			    			log.info(jsonObj.get("describe"));  
			    			map.put("status", false);
			    			map.put("msg", "提现出现异常，请联系管理员");
			    		}
					}
				} catch (Exception efund) {
					//调柜台协议失败删除该条记录
					log.error("柜台调协议异常：" + efund.getMessage());
					map.put("status", false);
	    			map.put("msg", "提现出现异常，请联系管理员");
				}
			}
			return map;
		}

	@Override
	public Map<String, Object> payfrom(String subzh, String total_fee, String bankcode, String sdorderno) {
		 Map<String, Object>map = new  HashMap<String, Object>();
			try {
			   DecimalFormat df=new DecimalFormat("######.00");
			   total_fee=df.format(Double.valueOf(total_fee)).toString();
			   String noSignstr = "version="+version+"&customerid="+customerid+"&total_fee="+total_fee
				        +"&sdorderno="+sdorderno+"&notifyurl="+notifyurl+"&returnurl="+returnurl+"&"+apiKey;		
			   String sign = getMD5(noSignstr);		   
			  
			   map.put("version", version);//版本
			   map.put("customerid", customerid);//商户号
			   map.put("sdorderno", sdorderno);//订单号
			   map.put("total_fee", total_fee);//金额
			   map.put("paytype", paytype);//支付方式
			   map.put("bankcode", bankcode);//银行编号
			   map.put("remark", remark);//备注
			   map.put("returnurl", returnurl);//同步返回的url
			   map.put("notifyurl", notifyurl);//异步回调的url
			   map.put("sign", sign);//加密串
			   map.put("url", url);//接口地址
			   log.info("充值提交参数 ："+map.toString());
			   AgentzhfundLog agentzhfundLog = new AgentzhfundLog();	
			   agentzhfundLog= saveAgentzhfundLog(agentzhfundLog, subzh, sdorderno, new Date(),  new BigDecimal(total_fee), 0, 1);
			   
			} catch (Exception e) {
				//调柜台协议失败删除该条记录
				log.info("保存充值信息异常", e);
			}
			return map;
	}
	
	//中期第二个支付
	@Override
	public Map<String, Object> secondpayNotify(HttpServletRequest request) {
		log.info("充值异步回调地址");
		 Map<String, Object>resmap = new  HashMap<String, Object>();
		 synchronized (PAY_KEY) {		 
			try {
				String out_trade_no = request.getParameter("out_trade_no");
				String trade_no = request.getParameter("trade_no");
				String status =request.getParameter("status");
				String pay_time =request.getParameter("pay_time");
				String trade_type =request.getParameter("trade_type");
				String sign_type =request.getParameter("sign_type");
				String sign =request.getParameter("sign");
				String total_amount =request.getParameter("total_amount");
				
				Map<String, Object> param = new TreeMap<String, Object>();
				param.put("out_trade_no", out_trade_no);
				param.put("trade_no", trade_no);
				param.put("status", status);
				param.put("pay_time", pay_time);
				param.put("total_amount", total_amount);
				param.put("trade_type", trade_type);
				MapRemoveNullUtil.removeNullEntry(param);
				String mysign = PayUtils.md5(param,"=",PAY_KEY);
				
			    log.info("--充值回调结果验签 ：sign---"+sign);
			    log.info("--本地验签 ：mysign---"+mysign);
			    log.info("--验签结果-mysign.equals(sign)---"+mysign.equals(sign));
			    AgentzhfundLog afl=new AgentzhfundLog();
			    if(mysign.equals(sign)){
			    	
			    	if(status.equals("1")){
			    		//在这里填写处理代码
			    	List<AgentzhfundLog>alist = agentzhfundLogMapper.selectByorderno(out_trade_no);
					if(alist!=null&&alist.size()>0) {
		    			afl=alist.get(0);
		    			if(afl.getStatus()==1){//已经充值成功了。
		    				log.info("该单号充值已完成"+new Date().toString());
		    				resmap.put("status", true);
		    				resmap.put("msg", "该单号充值已完成");
		    				return resmap;
		    			}	    			
		    		}else {
		    			log.info("该单号不存在"+new Date().toString());
	    				resmap.put("status", false);
	    				resmap.put("msg", "该单号不存在");
	    				return resmap;
		    		}
					String subzh= afl.getSubzh();
					Subzh subzhEntity = subzhMapper.selectBySubzh(subzh);
					
					if(subzhEntity==null) {
						log.info("用户"+subzh+"信息不存在");
	    				resmap.put("status", false);
	    				resmap.put("msg", "用户"+subzh+"信息不存在");
	    				return resmap;
					}
					
					subzhEntity.setZhstate(1);
		    		int count=subzhMapper.updateByPrimaryKeySelective(subzhEntity);
		    		log.info("log11:subzhService"+count);
		    		List<FundPzlog> sfplist = getFundPzlogList(subzhEntity);
		    		//调柜台
		    	    Map<String, Object> amap=addMoney(subzhEntity, afl);
		    	    if(null!=amap&&amap.size()>0) {
		    	    	if(null!=amap.get("status")&&(Boolean) amap.get("status")) {
		    	    		afl.setStatus(1);
		    	    		resmap.put("status", true);
		    	    		resmap.put("msg", "充值成功");
		    	        	FundPzlog fundPzlog = saveFundpzlog(subzh, afl.getFund(), out_trade_no, DateUtil.getSystemDate(), 6);	    	
		    	    	}else {
		    	    		afl.setStatus(2);//修改状态为2 --表示充值失败	 
		    	    		resmap.put("status", false);
		    	    		resmap.put("msg", "充值失败");
		    	        	
		    	   		 	if ((sfplist == null) && (sfplist.size() <= 1)) {
		    	   		 	subzhEntity.setZhstate(Integer.valueOf(0));
		    	   		 	}
		    	    	  }
		    	    	}else {
			    	    	afl.setStatus(2);//修改状态为2 --表示充值失败
			    	    	resmap.put("status", false);
			    	    	resmap.put("msg", "充值失败");
				        	if ((sfplist == null) && (sfplist.size() <= 1)) {
				        		subzhEntity.setZhstate(Integer.valueOf(0));
		    	   		 	}
			    	    }
		    	    if(afl.getStatus()==2) {
		    	    	  log.info(subzhMapper.updateByPrimaryKeySelective(subzhEntity)>0?"充值回调失败后修改用户激活状态成功":"充值回调失败后修改用户激活状态失败");
		    	    }
			    	}else{
			    		log.info("订单"+out_trade_no+"充值失败"+new Date().toString());
	    				resmap.put("status", false);
	    				resmap.put("msg", "订单"+out_trade_no+"充值失败");
	    				return resmap;
			    	}

				}else{
					log.info("订单"+out_trade_no+"验签失败"+new Date().toString());
					resmap.put("status", false);
					resmap.put("msg", "订单"+out_trade_no+"验签失败");
					return resmap;
				}
			} catch (Exception e) {
				log.error("充值回调异常", e);
				resmap.put("status", false);
				resmap.put("msg","充值回调异常");
			}
		}	
		return resmap;
	}

	@Override
	public Map<String, Object> secondpayReturn(HttpServletRequest request) {
		log.info("充值返回地址");
		 Map<String, Object>resmap = new  HashMap<String, Object>();
		try {
			String out_trade_no = request.getParameter("out_trade_no");
			String trade_no = request.getParameter("trade_no");
			String status =request.getParameter("status");
			String pay_time =request.getParameter("pay_time");
			String trade_type =request.getParameter("trade_type");
			String sign_type =request.getParameter("sign_type");
			String sign =request.getParameter("sign");
			String total_amount =request.getParameter("total_amount");
			
			Map<String, Object> param = new TreeMap<String, Object>();
			param.put("out_trade_no", out_trade_no);
			param.put("trade_no", trade_no);
			param.put("status", status);
			param.put("pay_time", pay_time);
			param.put("total_amount", total_amount);
			param.put("trade_type", trade_type);
			MapRemoveNullUtil.removeNullEntry(param);
			String mysign = PayUtils.md5(param, "=",PAY_KEY);
			
		    log.info("--充值回调结果验签 ：sign---"+sign);
		    log.info("--本地验签 ：mysign---"+mysign);
		    log.info("--验签结果-mysign.equals(sign)---"+mysign.equals(sign));
	    
		    resmap.put("status", true);
		    resmap.put("msg", "充值完成");
	  	 }catch (Exception e) {
	  		 log.error("充值回调异常", e);
	  		 resmap.put("status", false);
	  		 resmap.put("msg", "充值回调异常");
	  	 }
		return resmap;
	}

	@Override
	public Map<String, Object> secondpay(String subzh, String total_fee, String sdorderno) {
		DecimalFormat df=new DecimalFormat("######.00");
		total_fee=df.format(Double.valueOf(total_fee)).toString();
		Map<String, Object> datamap = new HashMap<String, Object>();
		datamap.put("out_trade_no",sdorderno);
		datamap.put("order_name",order_name);
		datamap.put("total_amount",total_fee);
		datamap.put("spbill_create_ip",spbill_create_ip);
		datamap.put("notify_url",second_notifyurl);
		datamap.put("return_url",second_returnurl);
		datamap.put("bankcode",bankcode);//hzalipayh5-支付h5  -aliqrcode支付宝扫码
		
		String datajson=JSON.toJSONString(datamap);
		Map<String, Object> param = new TreeMap<String, Object>();
		param.put("app_id", APP_ID);
		param.put("method", bankcode);		
		param.put("version", "2.0");
		param.put("content", datajson);
		String md5Sign = PayUtils.md5(param, "=", PAY_KEY);
		//param.put("sign", md5Sign);
		param.put("sign_type", "MD5");
		String data =PayUtils.encoderdata(param, "=",md5Sign);
		Map <String,Object> rmap =new HashMap<String, Object>();
		AgentzhfundLog agentzhfundLog = new AgentzhfundLog();	
		agentzhfundLog= saveAgentzhfundLog(agentzhfundLog, subzh, sdorderno, new Date(),  new BigDecimal(total_fee), 0, 1);
		try {
			String result = Tools.postData(second_url, data);
			log.info("结果 ------"+new String(result.getBytes("ISO-8859-1"), "UTF-8"));
			if(!StringUtil.isAllNullOrEmpty(result)) {
			rmap = JSONObject.parseObject(result, Map.class);
				
				if(rmap.get("respCode")!=null&&"0000".equals(rmap.get("respCode"))){
					rmap.put("status", true);
				}else {
					rmap.put("status", false);
				}
			}else {
				rmap.put("status", false);
				rmap.put("msg", "充值通道异常");
			}				
		} catch (Exception e) {			
			log.error("充值出现异常"+e);
			rmap.put("status", false);
			rmap.put("msg", "充值异常");
		}
	
		return rmap;
	}

	@Override
	public Map<String, Object> paythree(String subzh, String total_fee, String sdorderno, String bankcardnumber) {
		DecimalFormat df=new DecimalFormat("######.00");
		total_fee=df.format(Double.valueOf(total_fee)).toString();
		Map<String, Object> datamap = new HashMap<String, Object>();
		datamap.put("out_trade_no",sdorderno);
		datamap.put("order_name",order_name);
		datamap.put("total_amount",total_fee);
		datamap.put("accNo",bankcardnumber);
		datamap.put("spbill_create_ip",spbill_create_ip);
		datamap.put("notify_url",second_notifyurl);
		datamap.put("return_url",second_returnurl);
		datamap.put("bankcode","kuaijiewap");//hzalipayh5-支付h5 -aliqrcode支付宝扫码
		
		String datajson=JSON.toJSONString(datamap);
		Map<String, Object> param = new TreeMap<String, Object>();
		param.put("app_id", APP_ID);
		param.put("method","kuaijiewap");		
		param.put("version", "2.0");
		param.put("content", datajson);
		String md5Sign = PayUtils.md5(param,"=",PAY_KEY);
		//param.put("sign", md5Sign);
		param.put("sign_type", "MD5");
		String data =PayUtils.encoderdata(param, "=",md5Sign);
		Map <String,Object> rmap =new HashMap<String, Object>();
		AgentzhfundLog agentzhfundLog = new AgentzhfundLog();	
		agentzhfundLog= saveAgentzhfundLog(agentzhfundLog, subzh, sdorderno, new Date(),  new BigDecimal(total_fee), 0, 1);
		try {
			String result = Tools.postData(second_url, data);
			log.info("结果 ------"+result);
			if(!StringUtil.isAllNullOrEmpty(result)) {
				rmap.put("result",result);	
				rmap.put("status", true);
			}else {
				rmap.put("status", false);
				rmap.put("msg", "充值通道异常");
			}				
		} catch (Exception e) {			
			log.error("充值出现异常"+e);
			rmap.put("status", false);
			rmap.put("msg", "充值异常");
		}
	
		return rmap;
	}

	@Override
	public Map<String, Object> four(String subzh, String total_fee, String sdorderno) {
		DecimalFormat df=new DecimalFormat("######.00");
		total_fee=df.format(Double.valueOf(total_fee)).toString();
		Map<String, Object> datamap = new HashMap<String, Object>();
		datamap.put("out_trade_no",sdorderno);
		datamap.put("order_name",order_name);
		datamap.put("total_amount",total_fee);
		datamap.put("spbill_create_ip",spbill_create_ip);
		datamap.put("notify_url",second_notifyurl);
		datamap.put("return_url",second_returnurl);
		datamap.put("bankcode","wxqrcode");//hzalipayh5-支付h5  -aliqrcode支付宝扫码
		
		String datajson=JSON.toJSONString(datamap);
		Map<String, Object> param = new TreeMap<String, Object>();
		param.put("app_id", APP_ID);
		param.put("method", "wxqrcode");		
		param.put("version", "2.0");
		param.put("content", datajson);
		String md5Sign = PayUtils.md5(param, "=", PAY_KEY);
		//param.put("sign", md5Sign);
		param.put("sign_type", "MD5");
		String data =PayUtils.encoderdata(param, "=",md5Sign);
		Map <String,Object> rmap =new HashMap<String, Object>();
		AgentzhfundLog agentzhfundLog = new AgentzhfundLog();	
		agentzhfundLog= saveAgentzhfundLog(agentzhfundLog, subzh, sdorderno, new Date(),  new BigDecimal(total_fee), 0, 1);
		try {
			String result = Tools.postData(second_url, data);
			log.info("结果 ------"+new String(result.getBytes("ISO-8859-1"), "UTF-8"));
			if(!StringUtil.isAllNullOrEmpty(result)) {
			rmap = JSONObject.parseObject(result, Map.class);
				
				if(rmap.get("respCode")!=null&&"0000".equals(rmap.get("respCode"))){
					rmap.put("status", true);
				}else {
					rmap.put("status", false);
				}
			}else {
				rmap.put("status", false);
				rmap.put("msg", "充值通道异常");
			}				
		} catch (Exception e) {			
			log.error("充值出现异常"+e);
			rmap.put("status", false);
			rmap.put("msg", "充值异常");
		}
	
		return rmap;
	}

	
}
