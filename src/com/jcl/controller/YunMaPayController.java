/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @YunMaPayController.java
 * 功能概要  : 
 * 做成日期  : @2018年12月3日
 * 修改日期  :
 */
package com.jcl.controller;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import java.util.Set;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcl.util.DateUtil;
import com.jcl.util.PayUtils;

/** 
 * @author zpf
 * @version 1.0
 */
@Controller
@RequestMapping("/yunpay")
public class YunMaPayController {
	public static final String PAY_KEY="";
	
	@RequestMapping("/pay")
	public String pay() {
		Map<String, Object> datamap = new LinkedHashMap<String, Object>();
/*
 * version={value}&customerid={value}
 * &total_fee={value}&sdorderno={value}
 * &notifyurl={value}&returnurl={value}
 * &{apikey}
 */
		datamap.put("version","1.0");
		datamap.put("customerid","10056");
		datamap.put("sdorderno","15118953197"+DateUtil.dateFormat(new Date(), "yyyyMMddHHMMSSS"));
		datamap.put("total_fee","10.00");
		datamap.put("notifyurl","www.baidu.com");
		datamap.put("returnurl","www.huohu.com");		
		String sign = PayUtils.md5(datamap, "=",PAY_KEY);
		datamap.put("paytype","测试");
		datamap.put("bankcode","三生三世");
		datamap.put("remark","ces");
		datamap.put("get_code","get_code");
		datamap.put("sign",sign);
		return null;	
	}
	
	
	@RequestMapping("/callback")
	public String callbackurl(HttpServletRequest request,Model model) {
		   Map<String, Object> notifyParams = new HashMap<String, Object>();
	        Enumeration enu = request.getParameterNames();
	        while(enu.hasMoreElements()){
	            String paraName=(String)enu.nextElement();
	            notifyParams.put(paraName, request.getParameter(paraName));
	        }
	        System.out.println(notifyParams);
		return "cxpay/callback";
	}
	
	@RequestMapping("/paynotify")
	@ResponseBody
	public String paynotify(HttpServletRequest request) {
		return null;
		
	}
	
	public static void main(String[] args) {
		Map<String, Object> datamap = new LinkedHashMap<String, Object>();
		datamap.put("version","1.0");
		datamap.put("customerid","10056");
		datamap.put("sdorderno","15118953197"+DateUtil.dateFormat(new Date(), "yyyyMMddHHMMSSS"));
		datamap.put("total_fee","10.00");
		datamap.put("paytype","测试");
		datamap.put("bankcode","三生三世");
		datamap.put("notifyurl","www.baidu.com");
		datamap.put("returnurl","www.huohu.com");
		datamap.put("remark","ces");
		datamap.put("get_code","get_code");
		datamap.put("sign", "sign");
		
		Set<Entry<String, Object>> entryset=datamap.entrySet();
		Iterator<Entry<String, Object>> iterator=entryset.iterator();
		while(iterator.hasNext()){
			Entry<String, Object> entry=iterator.next();
			System.out.println("key->"+entry.getKey()+"  value->"+entry.getValue());
		}
	}
}
