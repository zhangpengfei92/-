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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcl.service.CxpayService;
import com.jcl.util.DateUtil;
import com.jcl.util.PayUtils;

/** 
 * @author zpf
 * @version 1.0
 */
@Controller
@RequestMapping("/secondpay")
public class ZQPaySecondController {
	public static Logger log = Logger.getLogger(ZQPaySecondController.class);
	
	@Autowired
	public CxpayService cxpayService;
	
	@RequestMapping("/pay")
	public String pay(Model model,String subzh, String total_fee,String sdorderno) {	
		try {
			Map<String, Object> map = cxpayService.secondpay(subzh, total_fee, sdorderno);	
			if(map!=null&&map.size()>0){
				if((Boolean) map.get("status")) {
					model.addAttribute("map", map);
					return "zqpay/qrpay";
				}else {
					model.addAttribute("msg", "充值接口失败");
					return "cxpay/callback";
				}
				
			}else {
				model.addAttribute("msg", "充值接口异常");
				return "cxpay/callback";
			}
		} catch (Exception e) {
			log.error("充值出现异常",e);
			model.addAttribute("msg", "充值失败");
		}
		
		return "cxpay/callback";	
	}
	@RequestMapping("/callback")
	public String callbackurl(HttpServletRequest request,Model model) {
		try {
			Map<String, Object> map = cxpayService.secondpayReturn(request);
			if((Boolean) map.get("status")){
				log.info("充值同步返回结果成功："+map.get("msg"));
				model.addAttribute("msg", map.get("msg"));
			}else {
				log.info("充值同步返回结果失败："+map.get("msg"));
				model.addAttribute("msg", map.get("msg"));
			}
			
			
		} catch (Exception e) {
			log.error("充值同步返回结果异常",e);
			model.addAttribute("msg", "充值同步返回结果异常,请联系管理员");
		}	
		return "cxpay/callback";
	}
	
	@RequestMapping("/paynotify")
	@ResponseBody
	public String paynotify(HttpServletRequest request){
		try {
			Map<String, Object> map = cxpayService.secondpayNotify(request);
			if((Boolean) map.get("status")){
				log.info("充值异步返回结果成功："+map.get("msg"));  
				return "notify_success";
			}else {
				log.info("充值异步返回结果失败："+map.get("msg"));
				return "fail";
			}	
		}catch (Exception e){
			log.error("充值异步返回结果异常",e);
			return "fail";
		}
	}
	
	@RequestMapping("/paythree")
	@ResponseBody
	public String paythree(Model model,String subzh, String total_fee,String sdorderno,String bankcardnumber) {	
		try {
			Map<String, Object> map = cxpayService.paythree(subzh, total_fee, sdorderno,bankcardnumber);	
			if(map!=null&&map.size()>0){
				log.info("map-----"+map);
				return (String) map.get("result");
			}else{
				return "充值失败请联系管理员";
			}		
		} catch (Exception e) {
			log.error("充值出现异常",e);
			return "充值出现异常请联系管理员";
		}
	}
	
	@RequestMapping("/four")
	public String four(Model model,String subzh, String total_fee,String sdorderno) {	
		try {
			Map<String, Object> map = cxpayService.four(subzh, total_fee, sdorderno);	
			if(map!=null&&map.size()>0){
				if((Boolean) map.get("status")) {
					model.addAttribute("map", map);
					return "zqpay/qrwechat";
				}else {
					model.addAttribute("msg", "充值接口失败");
					return "cxpay/callback";
				}
				
			}else {
				model.addAttribute("msg", "充值接口异常");
				return "cxpay/callback";
			}
		} catch (Exception e) {
			log.error("充值出现异常",e);
			model.addAttribute("msg", "充值失败");
		}
		
		return "cxpay/callback";	
	}
	@RequestMapping("/payFive")
	public String payFive() {
		String key ="4df8b6b63eed56d8dc79c26376fe73e2";
		HashMap<String, Object> map=new HashMap<String,Object>();
		map.put("tradeNo", DateUtil.dateFormat(new Date(), "yyyymmddhhss")+"15118953197");
		map.put("payType", "1");
		map.put("orderPrice", "0.01");
		map.put("merchantId", "");
		map.put("productName", "zq");
		map.put("remark", "test");
		String sign=PayUtils.md5(map, "=", key);
		map.put("sign",sign);
		return "";
	}
	
}
