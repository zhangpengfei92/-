/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @RiskTemplateServiceImpl.java
 * 功能概要  : 
 * 做成日期  : @2018年4月18日
 * 修改日期  :
 */
package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.RiskTemplateMenuMapper;
import com.jcl.pojo.RiskTemplateMenu;
import com.jcl.service.RiskTemplateMenuService;


/** 
 * @author zpf
 * @version 1.0
 * 
 * 风控模板菜单服务层
 */

@Service
public class RiskTemplateMenuServiceImpl implements RiskTemplateMenuService{
	
	@Autowired
	private RiskTemplateMenuMapper riskTemplateMenuMapper;
	
	@Override
	public List<RiskTemplateMenu> selectAll() {
		
		return riskTemplateMenuMapper.selectAll();
	}
	
	
}
