/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @AccountsController.java
 * 功能概要  : 
 * 做成日期  : @2018年7月6日
 * 修改日期  :
 */
package com.jcl.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcl.service.FundService;
import com.jcl.util.Constant;
import com.jcl.util.DeployProperties;

/** 
 * @author zpf
 * @version 1.0
 */

@Controller		  
@RequestMapping("/accounts")
public class AccountsController {
	
	public static Logger log = Logger.getLogger(AccountsController.class);
	//public static final  String EXCHANGE_RATE=DeployProperties.getInstance().getPublicexchange_rate();//汇率
	@Autowired
	public FundService fundService;
	
	@RequestMapping("/toAccount")
	public String toAccount(Model model,HttpSession session) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "22");
		return "fund/acccounts";
	}	
	/*@RequestMapping(value = "/saveAccount",produces="text/html;charset=UTF-8;")*/
	@RequestMapping(value = "/saveAccount")
	@ResponseBody
	public Map<String, Object> saveAccount(String username,String accmoney,Integer mstatus,Model model) {
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			
		map=fundService.saveAccount(username,accmoney,mstatus);
		
			if(map==null){
				map.put("status", false);
				map.put("msg","用户调账失败");
			}
		} catch (Exception e) {
			log.error("保存用户调账信息失败", e);
		}
		
		return map;
	}
}