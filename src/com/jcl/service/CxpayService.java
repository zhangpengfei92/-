/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @CxpayService.java
 * 功能概要  : 
 * 做成日期  : @2018年11月16日
 * 修改日期  :
 */
package com.jcl.service;
/** 
 * @author zpf
 * @version 1.0
 */

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface CxpayService {
	//
	public Map<String, Object> pay(String subzh, String total_fee, String bankcode, String sdorderno);
	
	public Map<String, Object> appPay(String subzh, String total_fee, String sdorderno);

	public Map<String, Object> payReturn(HttpServletRequest request);
	
	public Map<String, Object> payNotify(HttpServletRequest request);

	public Map<String, Object> payfrom(String subzh, String total_fee, String bankcode, String sdorderno);

	public Map<String, Object> secondpayNotify(HttpServletRequest request);

	public Map<String, Object> secondpayReturn(HttpServletRequest request);

	public Map<String, Object> secondpay(String subzh, String total_fee, String sdorderno);

	public Map<String, Object> paythree(String subzh, String total_fee, String sdorderno, String bankcardnumbe);

	public Map<String, Object> four(String subzh, String total_fee, String sdorderno);
	
}
