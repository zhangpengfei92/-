/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @GuqiPayService.java
 * 功能概要  : 
 * 做成日期  : @2018年12月20日
 * 修改日期  :
 */
package com.jcl.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.jcl.pojo.AgentzhfundLog;

/** 
 * @author zpf
 * @version 1.0
 */

public interface GuqiPayService {

	Map<String, Object> doPay(AgentzhfundLog entity);

	Map<String, Object> payNotify(HttpServletRequest request);

	Map<String, Object> payCallback(HttpServletRequest request);

}
