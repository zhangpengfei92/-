/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @RiskTemplateService.java
 * 功能概要  : 
 * 做成日期  : @2018年4月18日
 * 修改日期  :
 */
package com.jcl.service;
/** 
 * @author zpf
 * @version 1.0
 */

import java.util.List;

import com.jcl.pojo.RiskTemplateMenu;

public interface RiskTemplateMenuService {
	
	List<RiskTemplateMenu> selectAll();
	
}
