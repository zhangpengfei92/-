/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @CxpayController.java
 * 功能概要  : 
 * 做成日期  : @2018年11月15日
 * 修改日期  :
 */
package com.jcl.controller;
/** 
 * @author zpf
 * @version 1.0
 */


import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcl.service.CxpayService;


@Controller
@RequestMapping("/cxpay")
public class CxpayController {
	
	@Autowired
	public CxpayService cxpayService;
	
	public static Logger log = Logger.getLogger(CxpayController.class);
			
	@RequestMapping("/pay")
	public String pay(Model model,String subzh, String total_fee, String bankcode, String sdorderno,HttpServletResponse response) {		
		try {
			Map<String, Object> map = cxpayService.payfrom(subzh, total_fee, bankcode, sdorderno);	
			if(map!=null){
				model.addAttribute("map", map);
				return "cxpay/pay";
			}else {
				model.addAttribute("msg", "充值失败");
				return "cxpay/callback";
			}
		} catch (Exception e) {
			log.error("充值出现异常",e);
		}
		
		return "cxpay/callback";		
	}
	
	@RequestMapping("/toqrapy")
	public String toqrapy() {
		return "cxpay/qrpay";		
	}
	
	@RequestMapping("/appPay")
	public String appPay(Model model,String subzh, String total_fee, String sdorderno) {
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			 map = cxpayService.appPay(subzh, total_fee, sdorderno);
			if((Boolean) map.get("status")){
				log.info("充值申请成功，返回值 ："+map.get("result"));
				model.addAttribute("map", map);
				return "cxpay/qrpay";	
			}else {
				log.info("充值申请失败，返回值 ："+map.get("result"));
				model.addAttribute("msg", map.get("msg"));
			}
			
		} catch (Exception e) {
			log.error("充值出现异常",e);
			model.addAttribute("msg", "充值出现异常");
		}
		   return "cxpay/noneed";		
	}
	
	@RequestMapping("/payReturn")
	public  String payReturn(HttpServletRequest request,Model model) {
		try {
			Map<String, Object> map = cxpayService.payReturn(request);
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
	
	@RequestMapping("/payNotify")
	@ResponseBody
	public  String payNotify(HttpServletRequest request,Model model) {
		try {
			Map<String, Object> map = cxpayService.payNotify(request);
			if((Boolean) map.get("status")){
				log.info("充值异步返回结果成功："+map.get("msg"));
				return "success";
			}else {
				log.info("充值异步返回结果失败："+map.get("msg"));
				return "fail";
			}
			
			
		} catch (Exception e) {
			log.error("充值异步返回结果异常",e);
			return "fail";
		}		
	}
	@RequestMapping("/paysel")
	public String paysel(Model model,String subzh, String total_fee, String sdorderno,Integer paymode) {
		String paypage="";
		try {
			if(paymode==1) {
				paypage="cxpay/index_first";
			}else if(paymode==2){
				paypage="cxpay/index_second";
			}else if(paymode==3){
				paypage="cxpay/index_three";
			}else if(paymode==4){
				paypage="cxpay/index_four";
			}else {
				model.addAttribute("msg", "选择通道异常，请联系管理员");
				return "cxpay/callback";
			}
			model.addAttribute("subzh",subzh);
			model.addAttribute("total_fee",total_fee);
			model.addAttribute("sdorderno",sdorderno);
		} catch (Exception e) {			
			log.error("选择充值通道异常",e);
			model.addAttribute("msg", "充值异常，请联系管理员");
			return "cxpay/callback";
		}
		
		
		return paypage;
	}
	
	
	/*@RequestMapping("/appPay")
	public String appPay() {
		DecimalFormat df=new DecimalFormat("######.00");
		String total_fee="10.00";
		String sdorderno="201811191331";
		String noSignstr = "version="+version+"&customerid="+customerid+"&total_fee="+total_fee
			        +"&sdorderno="+sdorderno+"&notifyurl="+notifyurl+"&returnurl="+returnurl+"&"+apiKey;		
		String sign = getMD5(noSignstr);		   
		Map<String, String>map = new  HashMap<String, String>();
	    map.put("version", version);//版本
		map.put("customerid", customerid);//商户号
		map.put("sdorderno", sdorderno);//订单号
		map.put("total_fee", total_fee);//金额
		map.put("paytype", "jrzfb");//支付方式
		map.put("bankcode", "");//银行编号
		map.put("remark", remark);//备注
		map.put("returnurl", returnurl);//同步返回的url
	    map.put("notifyurl", notifyurl);//异步回调的url
	    map.put("sign", sign);//加密串
		String result = HttpRequest.sendPost(url, map);
		System.out.println(result);
		
		return "";
	}*/
		
    public  String getMD5(String str) {
        try {
            
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            md.update(str.getBytes());
            
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    } 
	
}
