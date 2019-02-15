/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @MainJumpController.java
 * 功能概要  : 
 * 做成日期  : @2019年1月21日
 * 修改日期  :
 */
package com.zpf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * @author zpf
 * @version 1.0
 */
@Controller
public class MainJumpController {
	
	@RequestMapping("/jump/graph_flot")
	public  String  jumping() {
			
		return "graph/flot";		
	}
	
}
