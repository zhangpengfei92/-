/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @FundsetController.java
 * 功能概要  : 
 * 做成日期  : @2018年9月16日
 * 修改日期  :
 */
package com.jcl.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcl.pojo.Fundset;
import com.jcl.service.FundsetService;
import com.jcl.util.Constant;

/** 
 * @author zpf
 * @version 1.0
 */
@Controller
@RequestMapping("/fundset")
public class FundsetController {
	
	public static Logger log = Logger.getLogger(FundsetController.class);
	
	//注入service层
	@Autowired
	private FundsetService fundsetService;
	
	@RequestMapping("/fundsetlist")
	public  String  fundsetlist(HttpSession session,Model model) {		
		session.setAttribute(Constant.SESSION_LEFTMENU, "23");
		try {
			Fundset fundset=fundsetService.selectone();
			if(fundset!=null) {
				model.addAttribute("fundset",fundset);
			}
			
		} catch (Exception e) {
		
		}
		
		
		return "fund/fundsetlist";		
	}
	
	@RequestMapping("/savefundset")
	@ResponseBody
	public  String savefundset(Fundset fundset) {
		if(fundset.getPcswitch()==null||fundset.getPcswitch()!=1) {
			fundset.setPcswitch(2);
		}
		
		if(fundset.getAppswitch()==null||fundset.getAppswitch()!=1) {
			fundset.setAppswitch(2);
		}
		
		String msg="";
		try {
			int num=fundsetService.savefundset(fundset);
			
			if(num>0) {
				msg="SUCCESS";
			}else {
				msg="FAIL";
			}
		} catch (Exception e) {
			log.error("保存出入金设置异常", e);
			
		}

		
		return msg;
	}

}
