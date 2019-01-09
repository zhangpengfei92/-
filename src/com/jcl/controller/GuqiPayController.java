/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @GuqiPayController.java
 * 功能概要  : 
 * 做成日期  : @2018年12月20日
 * 修改日期  :
 */
package com.jcl.controller;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcl.pojo.AgentzhfundLog;
import com.jcl.pojo.Subzh;
import com.jcl.service.GuqiPayService;
import com.jcl.service.SubzhService;
import com.jcl.util.DateUtil;

/** 
 * @author zpf
 * @version 1.0
 *股期策略支付控制层 
 */
@Controller
@RequestMapping("/guqipay")
public class GuqiPayController {
	public static Logger log = Logger.getLogger(GuqiPayController.class);
	
	@Autowired
	private SubzhService subzhService;
	@Autowired
	private  GuqiPayService guqiPayService;
	
	@RequestMapping("/startPay/{status}")
	public String startPay(@PathVariable String status,String subzh,Model model) {
		String paypage="";
		if("1".equals(status)){//status = 1 ---表示充值
			paypage="guqipay/rechargeindex";
		}else if ("2".equals(status)) {//status = 2 ---表示提现
			paypage="guqipay/withdrawalindex";
		}else if ("3".equals(status)) {//status = 3 ---网关
			paypage="guqipay/gatewayPay";
		}
		// 判断当前用户是否已经实名认证
				Map<String, Object> map = isok(subzh, paypage);
				if ((Boolean) map.get("status")) {// true
					log.info(map.get("msg"));
					Subzh sub = (Subzh) map.get("users");
					if (sub != null) {
						// 手机号注册的用户
						model.addAttribute("sub", sub);
						return (String) map.get("payPage");
					}
				} else {
					log.info(map.get("msg"));
					model.addAttribute("msg", map.get("msg"));
					return (String) map.get("payPage");
				}
		
		return "guqipay/errorpage";
	}
	@RequestMapping("/doPay")
	public String doPay(AgentzhfundLog entity,Model model){
		log.info("充值账户;"+entity.getSubzh()+"--订单号;"+entity.getOrderno());
		try {
			Map<String, Object> map=guqiPayService.doPay(entity);
			if(map!=null) {
				if((Boolean) map.get("status")) {
					model.addAttribute("payUrl", map.get("payUrl"));
					return "guqipay/payindex";
				}else {
					model.addAttribute("msg", map.get("msg"));
					return "guqipay/errorpage";
				}
			}else {
				model.addAttribute("msg", "充值接口异常");
				return "guqipay/errorpage";
			}
		} catch (Exception e) {
			log.error("充值接口异常",e);
			model.addAttribute("msg", "充值接口异常");
			return "guqipay/errorpage";
		}		
	}
	
	@RequestMapping("/payNotify")
	@ResponseBody
	public String payNotify(HttpServletRequest request) {
		try {
			Map<String, Object> resmap=guqiPayService.payNotify(request);
			if((Boolean) resmap.get("status")){
				return "OK";
			}else {
				return "FAIL";
			}
		} catch (Exception e) {
			log.error("充值回调异常",e);
			return "FAIL";
		}
	}
	
	
	@RequestMapping("/payCallback")
	public String payCallback(HttpServletRequest request,Model model) {
		try {
			Map<String, Object> resmap=guqiPayService.payCallback(request);
			log.info("充值返回结果 ："+resmap.toString());
			if((Boolean) resmap.get("status")){
				
				model.addAttribute("msg",resmap.get("msg"));
				return "guqipay/callback";				
			}else {
				model.addAttribute("msg",resmap.get("msg"));
				return "guqipay/callback";
			}
		} catch (Exception e) {
			log.error("充值回调异常",e);
			model.addAttribute("msg","充值异常，请联系管理员");
			return "guqipay/callback";
		}
	}
	
	@RequestMapping("/offlinePay")
	public String offlinePay() {
		
		return "guqipay/fundPage";
	}
	
	// 判断该用户是否能出入金
		public Map<String, Object> isok(String subzh, String payPage) {
			Map<String, Object> map = new HashMap<String, Object>();
			String errorpay = "guqipay/errorpage";
			Subzh sub = null;
			if (null == subzh || subzh == "") {
				log.info("用户名不存在");
				map.put("msg", "用户名不存在");
				map.put("status", false);
				map.put("payPage", errorpay);
				return map;
			}
			try {
				sub = subzhService.loginBySubzh(subzh);
				// 判断用户信息是否存在
				if (null == sub) {
					log.info("用户信息不存在");
					map.put("msg", "用户信息不存在");
					map.put("status", false);
					map.put("payPage", errorpay);
					log.info("map  :-----------" + map.toString());
					return map;
				}
				// 当用户操作充值（网关或者银联）判读用户是否是普通用户
				Boolean flag = true;

				Integer isadmin = 0;
				if (payPage == "guqipay/rechargeindex") {
					isadmin = sub.getIsadmin();
					if (null != isadmin && isadmin != 0 && isadmin != 6) {
						log.info("非普通用户无法充值");
						map.put("msg", "非普通用户无法充值");
						map.put("status", false);
						map.put("payPage", errorpay);
						return map;
					}
				}

				// 当用户操作的是提现，判读用户是否是普通用户
				if (payPage == "guqipay/withdrawalindex") {
					isadmin = sub.getIsadmin();
					if (null != isadmin && isadmin != 0 && isadmin != 6) {// 如果用户不是普通用户，则无需实名认证
						flag = false;
					}
				}

				if (flag) {// 当用户操作提现且不是普通用户时，不必进行是否实名认证的判断
					// 判断用户是否实名认证
					if (sub.getAuthState() != null && sub.getAuthState() != 2) {
						String msg = "";
						Integer state = sub.getAuthState();
						msg = state == 0 ? "用户未实名认证" : state == 1 ? "用户实名认证审核中" : "用户实名认证未通过";
						map.put("msg", msg);
						map.put("status", false);
						map.put("payPage", errorpay);
						return map;
					}
				}
				map.put("msg", "用户已实名认证");
				map.put("status", true);
				map.put("users", sub);
				map.put("payPage", payPage);

			} catch (Exception e) {
				log.error("查询用户异常");
			}

			return map;
		}
}
