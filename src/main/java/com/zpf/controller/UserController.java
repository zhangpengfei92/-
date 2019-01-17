/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @UserController.java
 * 功能概要  : 
 * 做成日期  : @2019年1月17日
 * 修改日期  :
 */
package com.zpf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zpf.pojo.UserInfo;

/** 
 * @author zpf
 * @version 1.0
 */
@Controller
@RequestMapping("/useraction")
public class UserController{
	
	@RequestMapping("/welcome")
	public String welcome(){
		
		return "welcome";		
	}
	
	@RequestMapping("/toRegister")
	public String toRegister(){
		
		return "user/toRegister";		
	}
	
	@RequestMapping("/userlist")
	public  String userlist(Model model){
		List<UserInfo> ulist = new ArrayList<UserInfo>();
		for (int i = 0; i < 10; i++) {
			ulist.add(new UserInfo(i, "李白", "1523659878", "武汉", i, i, "123456"));
		}
		model.addAttribute("ulist",ulist);
		return "user/userlist";
		
	}
}
