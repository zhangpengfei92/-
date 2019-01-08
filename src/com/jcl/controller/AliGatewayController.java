/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @AliGateway.java
 * 功能概要  : 
 * 做成日期  : @2019年1月7日
 * 修改日期  :
 */
package com.jcl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcl.service.impl.GuqiPayServiceImpl;
import com.jcl.util.DateUtil;
import com.jcl.util.DeployProperties;
import com.jcl.util.aliutils.MD5;
import com.jcl.util.aliutils.SignUtils;
import com.jcl.util.aliutils.XmlUtils;

/** 
 * @author zpf
 * @version 1.0
 */
@Controller
@RequestMapping("/aliGateway")
public class AliGatewayController {
	
	public static Logger log = Logger.getLogger(AliGatewayController.class);
	
	private static final String mch_id=DeployProperties.getInstance().getProperty("public.alipay.mch_id");//
	private static final String appid=DeployProperties.getInstance().getProperty("public.alipay.appid");//
	private static final String method=DeployProperties.getInstance().getProperty("public.alipay.method");//
	private static final String notify_url=DeployProperties.getInstance().getProperty("public.alipay.notify_url");//
	private static final String key=DeployProperties.getInstance().getProperty("public.alipay.key");//
	private static final String net_url=DeployProperties.getInstance().getProperty("public.alipay.net_url");//
	
	@RequestMapping("/doPay")
	public String doPay(Model model){
		Map<String, String> map=new TreeMap<String, String>();
		map.put("version", "2.0.0");
		map.put("out_trade_no",DateUtil.dateFormat(new Date(), "yyyymmddhhss")+"15118953197");
		map.put("total_fee", "100");
		map.put("mch_id",mch_id);
	    map.put("appid",appid);
	    map.put("method",method);
	    map.put("notify_url",notify_url);
	    
	    System.out.println("notify_url="+notify_url);

        Map<String,String> params = SignUtils.paraFilter(map);
        StringBuilder buf = new StringBuilder((params.size() +1) * 10);
        SignUtils.buildPayParams(buf,params,false);
        String preStr = buf.toString();
        String sign = MD5.sign(preStr, "&key=" +key, "utf-8").toUpperCase();
        log.info(params.toString());    
        params.put("sign", sign);
        log.info("params-----"+params.toString()); 
        model.addAttribute("params",params);
        model.addAttribute("method",method);
        model.addAttribute("url",net_url);
		return "gatewaypay/pay";
	}
	@RequestMapping("payNotify")
	@ResponseBody
	public String payNotify(HttpServletRequest req) {
	      try {
	            req.setCharacterEncoding("utf-8");
	            String resString = XmlUtils.parseRequst(req);
	            System.out.println("通知内容：" + resString);
	            
	            String respString = "fail";
	            Map<String,String> returnMap = new HashMap<String, String>();
	            
	            returnMap.put("return_code", "FAIL");
	            
	            if(resString != null && !"".equals(resString)){
	                Map<String,String> map = XmlUtils.toMap(resString.getBytes(), "utf-8");
	                String res = XmlUtils.toXml(map);
	                System.out.println("通知结果：" + res);
	                if(map.containsKey("sign")){
	                    if(!SignUtils.checkParam(map,key)){
	                        res = "验证签名不通过";
	                        
	                        returnMap.put("return_msg", res);
	                    }else{
	                    	if("SUCCESS".equals(map.get("return_code")) && "SUCCESS".equals(map.get("result_code"))){
	                			
	                		}
	                    	returnMap.put("return_code", "SUCCESS");
	                        returnMap.put("return_msg", "");
	                    }
	                }
	            }
	            return XmlUtils.toXml(returnMap);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return null;
	}
}
