/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @HjController.java
 * 功能概要  : 
 * 做成日期  : @2018年11月26日
 * 修改日期  :
 */
package com.jcl.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jcl.util.AESUtil;

/** 
 * @author zpf
 * @version 1.0
 */
@Controller
@RequestMapping("/testpay")
public class HjController {

	@RequestMapping("/pay")
	public String pay(Model model) {
		Map<String, String> map= new HashMap<String, String>();
		Map<String, String> datamap= new HashMap<String, String>();
		try {
		datamap.put("notify_url", "");
		datamap.put("return_url", "");
		datamap.put("body", "");
		datamap.put("subject", "");
		datamap.put("money", "");		
		byte[] data = AESUtil.encryptAES(JSON.toJSON(datamap).toString().getBytes(), "123456789".getBytes());	
		map.put("merchants", "");
		map.put("oid", "");
		map.put("sign_type", "");
		map.put("create_time", "");
		map.put("sign", "");
		map.put("data",data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "hjpay/pay";
	}
	
}
