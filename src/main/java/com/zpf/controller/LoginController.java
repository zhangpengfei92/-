/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @LoginController.java
 * 功能概要  : 
 * 做成日期  : @2019年1月11日
 * 修改日期  :
 */
package com.zpf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * @author zpf
 * @version 1.0
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@RequestMapping("/dologin")
	public String login(){
		System.out.println("lll");
		
		return "index";
	}
}
