/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @OfflinePayController.java
 * 功能概要  : 
 * 做成日期  : @2019年1月3日
 * 修改日期  :
 */
package com.jcl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @author zpf
 * @version 1.0
 */
@RequestMapping("/offline")
@Controller
public class OfflinePayController {

	@RequestMapping("/offlinePay")
	public String OfflinePay() {
		
		return "phonePay/payment";
	}
}
