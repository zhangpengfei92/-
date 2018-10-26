/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @AgentzhServiceImpl.java
 * 功能概要  : 
 * 做成日期  : @2018年4月24日
 * 修改日期  :
 */
package com.jcl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.AgentzhMapper;
import com.jcl.service.AgentzhService;

/** 
 * @author zpf
 * @version 1.0
 * 
 */
@Service
public class AgentzhServiceImpl implements AgentzhService{
	
	@Autowired
	private AgentzhMapper agentzhMapper;
	
	
	
}
