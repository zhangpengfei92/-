/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @PhonePayService.java
 * 功能概要  : 
 * 做成日期  : @2018年10月17日
 * 修改日期  :
 */
package com.jcl.service;
/** 
 * @author zpf
 * @version 1.0
 *  衫德支付--服务接口
 */

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.jcl.pojo.AgentzhfundLog;
import com.jcl.pojo.Subzh;

public interface PhonePayService {
	
	//网关接口
	public Map<String, Object> orderPay(HttpServletRequest request);
	
	//快捷接口
	public Map<String, Object> fastPay(HttpServletRequest request);
	
	//充值回调接口
	public Map<String, Object> shandePayCallback(HttpServletRequest request);
	
	//审核通过接口
	public Map<String, Object> AgentPay(Integer qlId,Integer status);
	
	//提现申请接口
	public Map<String, Object> withdrawend(AgentzhfundLog agentzhfundLog);
	
	public AgentzhfundLog saveAgentzhfundLog(AgentzhfundLog agentzhfundLog, String subzh,String order_no,Date pay_time,BigDecimal total_fee,int paystate,int bz);

	//充值回调接口
	public Map<String, Object> keyPayCallback(HttpServletRequest request,String token);

	public Map<String, Object> addMoney(Subzh subzh, AgentzhfundLog agentzhfundLog);
	
	
}
