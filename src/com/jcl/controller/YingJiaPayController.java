/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @YingjiaController.java
 * 功能概要  : 
 * 做成日期  : @2018年11月29日
 * 修改日期  :
 */
package com.jcl.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcl.util.DateUtil;
import com.jcl.util.spt.MD5Utils;

/** 
 * @author zpf
 * @version 1.0
 */

@Controller
@RequestMapping("/zqpay")
public class YingJiaPayController {

	public static Logger log = Logger.getLogger(YingJiaPayController.class);

	
	public static final String url ="http://59.56.110.219:8081/Pay_Index.html";
	
	@RequestMapping("/pay")
	public String pay(Model model) {
		Map<String, Object> map = new TreeMap<String, Object>();
		String pay_key="lMMIlGoZYVWhP9GJcgWTZo7CN6fMgl"; 
		map.put("pay_memberid","10024");
		map.put("pay_orderid","");
		map.put("pay_amount", "1.00");
		map.put("pay_applydate",DateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:MM:SSS"));
		map.put("pay_bankcode","CCB");
		map.put("pay_notifyurl","http://120.26.246.221:5880/outcrude_v/zqpay/paynotify");
		map.put("pay_callbackurl","http://120.26.246.221:5880/outcrude_v/zqpay/callback");
		map.put("tongdao", "test");
		log.info("MD5加密参数"+map.toString());
		String pay_md5sign = md5(map, "=>", pay_key);
		map.put("pay_md5sign",pay_md5sign);
		map.put("url",url);
		map.put("pay_reserved1","13112659874"+DateUtil.dateFormat(new Date(), "yyyyMMddHHMMSSS"));
		model.addAttribute("map",map);
		return "zqpay/pay";
	}
	public String md5(Map<String, Object> map,String formatStr,String key) {
		   StringBuilder str=new StringBuilder(); 
		   Set<Entry<String, Object>> entryset= map.entrySet();
		   Iterator<Entry<String, Object>> it = entryset.iterator();
		   
		   while(it.hasNext()){
		   Entry<String, Object>  entry =it.next();
		   str.append(entry.getKey()+formatStr+entry.getValue()+"&");
		   }
		   log.info("md5加密串--"+str.toString()+"key="+key);
		   String md5sign=MD5Utils.md5(str.toString()+"key="+key).toUpperCase();
		   log.info("md5加密后--"+md5sign);
		   return md5sign;
	}
	@RequestMapping("/callback")
	public String callbackurl() {
		
		return "zqpay/callback";
	}
	
	@RequestMapping("/paynotify")
	public String payCome(HttpServletRequest request) {
		log.info("回调了");
		
		return "";
	}
}
