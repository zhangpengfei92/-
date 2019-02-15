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
import org.springframework.web.bind.annotation.ResponseBody;

import com.zpf.pojo.UserInfo;
import com.zpf.utils.LayuiData;

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
		
		return "user/userlist";
		
	}
	@RequestMapping("/queryUser")
	@ResponseBody
	public LayuiData queryUser(Integer page,Integer limit){
		List<UserInfo> ulist = new ArrayList<UserInfo>();
		for (int i = (page-1)*limit; i < page*limit; i++) {
			ulist.add(new UserInfo(i, "李白"+page, "1523659878", "武汉"+page, i, i, "123456"));
		}
		System.out.println(ulist.toString());
		return LayuiData.returnData(100,ulist);
	}
}
