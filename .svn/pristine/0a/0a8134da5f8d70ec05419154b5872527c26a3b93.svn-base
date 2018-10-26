/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @RiskTempallController.java
 * 功能概要  : 
 * 做成日期  : @2018年4月28日
 * 修改日期  :
 */
package com.jcl.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcl.pojo.RiskTempall;
import com.jcl.service.RiskTempallService;

/** 
 * @author zpf
 * @version 1.0
 */
@RequestMapping("/riskTempall")
@Controller
public class RiskTempallController {
	
	public static Logger log = Logger.getLogger(SubzhController.class);
	
	@Autowired
	private RiskTempallService riskTempallServiceImpl;
	
		@RequestMapping("/queryRiskTempall")
		public String queryRiskTempall(Model model,Integer id) {
			
			try {
				RiskTempall riskTempall = riskTempallServiceImpl.selectByPrimaryKey(id);
				model.addAttribute("rt", riskTempall);
			} catch (Exception e) {
				log.error("查询账户列表异常：" + e.getMessage());
			}
			
			return "fund/riskTempall";
		}
}
