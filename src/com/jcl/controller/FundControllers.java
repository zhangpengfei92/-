/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @FundController.java
 * 功能概要  : 
 * 做成日期  : @2018年6月13日
 * 修改日期  :
 */
package com.jcl.controller;
/** 
 * @author zpf
 * @version 1.0
 */


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcl.dao.AgentzhfundLogMapper;
import com.jcl.pojo.AgentzhfundLog;
import com.jcl.pojo.Subzh;
import com.jcl.service.AgentzhfundLogService;
import com.jcl.service.FundServices;
import com.jcl.service.SubzhService;
import com.jcl.util.Constant;
import com.jcl.util.StringUtil;
import com.jcl.util.spt.HttpRequest;
/**
 * 资金充值提现的控制层
 */

@Controller
@RequestMapping("/subzhfunds")
public class FundControllers {
	public static Logger log = Logger.getLogger(FundControllers.class);
	
	@Autowired
	private FundServices fundServiceimpl;
	
	@Autowired
	private SubzhService subzhService;
	
	//去h5充值页面
	@RequestMapping("/toPayH5")
	public String goH5Pay(String subzh,Model model,HttpSession session) {
		//判断当前用户是否已经实名认证
		//session.setAttribute(Constant.SESSION_LOGINNAME, subzh);
		//判断当前用户是否已经实名认证
		Map<String, Object> map=isok(subzh, "register_h5/fund_h5");
		//Map<String, Object> map=isok(subzh, "register_h5/fundChartHFive");
		if((Boolean) map.get("status")) {//true
			
			log.info(map.get("msg"));
			Subzh sub=(Subzh) map.get("users");
			model.addAttribute("sub", sub);
			return (String) map.get("payPage");
		
		}else {
			log.info(map.get("msg"));
			model.addAttribute("msg", map.get("msg"));
			return (String) map.get("payPage");
		}
	}
	
	//去pc页面
		@RequestMapping("/goPcPay")
		public String goPcPay(String subzh,Model model,HttpSession session) {
			//判断当前用户是否已经实名认证
			//session.setAttribute(Constant.SESSION_LOGINNAME, subzh);
			//判断当前用户是否已经实名认证
			Map<String, Object> map=isok(subzh, "register_h5/fund_pc");
			if((Boolean) map.get("status")) {//true
				
				log.info(map.get("msg"));
				Subzh sub=(Subzh) map.get("users");
				model.addAttribute("sub", sub);
				return (String) map.get("payPage");
			
			}else {
				log.info(map.get("msg"));
				model.addAttribute("msg", map.get("msg"));
				return (String) map.get("payPage");
			}
		}
	
	//去提现页面
	@RequestMapping("/drawMoneyH5")
	public  String  goGetMoney(String subzh,Model model,HttpSession session) {
		session.setAttribute(Constant.SESSION_LOGINNAME, subzh);
		//判断当前用户是否已经实名认证
	
		Map<String, Object> map=isok(subzh, "register_h5/fundRaising");
		if((Boolean) map.get("status")) {//true
			
			log.info(map.get("msg"));
			Subzh sub=(Subzh) map.get("users");
			if(null!=sub&&sub.getIsadmin()==6){
				BigDecimal fundbalance=fundServiceimpl.getfundbalance(sub);
				log.info("用户可提金额 : "+fundbalance);
				sub.setFundbalance(fundbalance);
			}
			model.addAttribute("sub", sub);
			return (String) map.get("payPage");
		
		}else {
			log.info(map.get("msg"));
			model.addAttribute("msg", map.get("msg"));
			return (String) map.get("payPage");
		}
	}
	//保存快捷充值信息
	@RequestMapping("/ispay")
	public String ispay(HttpServletRequest request,HttpServletResponse response) {
		
		fundServiceimpl.paymentH5(request,response);

	    return null;
	}
	//保存网关充值信息
	@RequestMapping(value = "/payment")
	public String payment(HttpServletRequest request,HttpServletResponse response) {
		fundServiceimpl.payment(request,response);
		return null;
	}
	
	
	
	//支付成功跳转的页面
	@RequestMapping(value = "/payCallBack")
	public String  payCallBack(HttpServletRequest request) {
		
		
		return "register_h5/callback";
	}
	//快捷的回调
	@RequestMapping(value = "/payNotyfyH5",method=RequestMethod.POST,produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String h5PayNotyfy(HttpServletRequest request) {
		Map<String, Object> map=fundServiceimpl.payNotyfyh5(request);
	    if ((map != null) && (map.size() > 0)) {
	      log.info("充值状态===》" + map.get("status"));
	      if ((Boolean)map.get("status")) {
	        return "success";
	      }else {
	    	 log.info("充值失败    ：  " + map.get("msg"));
	    	 return "false";		    	 
	      }   
	    }else {
	    	log.info("充值失败    ：  " + map.get("msg"));
	    	return "false";
	    }
	}
	
	
	//充值回调的方法payNotyfy
	@RequestMapping(value = "/payNotyfy",method=RequestMethod.POST,produces="text/html;charset=UTF-8;")
	@ResponseBody
	public  String  payNotyfy(HttpServletRequest request) {
	
			
			Map<String, Object> map=fundServiceimpl.payNotyfy(request);
		    if ((map != null) && (map.size() > 0)) {
		      log.info("充值状态===》" + map.get("status"));
		      if ((Boolean)map.get("status")) {
		        return "success";
		      }else {
		    	 log.info("充值失败    ：  " + map.get("msg"));
		    	 return "false";		    	 
		      }   
		    }else {
		    	log.info("充值失败    ：  " + map.get("msg"));
		    	return "false";
		    }
	}
	
	//保存提现信息
	  @RequestMapping(value={"/savePay"}, produces={"text/html;charset=UTF-8;"})
	  @ResponseBody
	  public String savePay(AgentzhfundLog afl, HttpSession session, Model model)
	  {
	    log.info("保存提现信息");
	    String subzh = (String)session.getAttribute("SESSION_LOGINNAME");
	    log.info("subzh===》" + subzh);
	    Map<String, Object> map = null;
	    if (subzh == null)
	    {
	      log.info("subzh:账户为null");
	      return "用户不存在";
	    }
	    try
	    {
	      map = this.fundServiceimpl.savePay(afl, subzh);
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      log.error("savePay--保存体提现信息异常", e);
	    }
	    if ((map != null) && (map.size() > 0))
	    {
	      log.info("保存提现信息状态===》" + map.get("status"));
	      if ((Boolean)map.get("status")) {
	        return "ok";
	      }
	      return (String) map.get("msg")==null?"提现失败":(String) map.get("msg");
	    }
	    return "提现失败";
	  }
	
	//审核并且提现
	@RequestMapping(value = "/isPay",produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String isPay(Integer id, Integer status) {
		log.info("提现审核开始");
		Map<String, Object>map=fundServiceimpl.isPay(id,status);
		   if ((map != null) && (map.size() > 0)) {
		      log.info("保存提现信息状态===》" + map.get("status"));
		      if (map.get("status")=="true") {
		    	  log.info("保存提现信息成功");
		    	  return "true";
		      }else {
		    	  return (String) map.get("msg");
		      }
		    }else {
		    	  return "提现审核失败";
		    }
		   
	}
	//提现回调
	@RequestMapping("/getmoneyNotyfy")
	@ResponseBody
	public  String getmoneyNotyfy(HttpServletRequest request){
		log.info("提现回调开始");
		Map<String, Object>map=fundServiceimpl.saveGetMoney(request);
		   if ((map != null) && (map.size() > 0)) {
		      log.info("保存提现回调状态===》" + map.get("status"));
		      if (map.get("status")=="true") {
		    	  log.info("提现回调成功");
		    	  return "success";
		      }else {
		    	  return "false";
		      }
		    }else {
		    	  return "false";
		    }
	}
	
	//拒绝通过审核
		@RequestMapping("/checkWithdraw")
		@ResponseBody
		public String checkWithdraw(Integer id, Integer status) {
			
			Map<String, Object>map=fundServiceimpl.checkWithdraw(id,status);
			if(null!=map&&map.get("status")=="true") {
				return "true";
			}else {
				return "false";
			}
		}
	
	//判断该用户是否能出入金	
	public Map<String, Object> isok(String subzh,String payPage){
		Map<String, Object>map=new HashMap<String, Object>();
		String errorpay="register_h5/noneed";
		Subzh sub =null;
		if(null==subzh||subzh=="") {
			log.info("用户名不存在");
			map.put("msg","用户名不存在");
			map.put("status",false);
			map.put("payPage",errorpay);
			return map;
		}
		try {
			sub = subzhService.loginBySubzh(subzh);
			//判断用户信息是否存在
			if(null==sub) {
				log.info("用户信息不存在");
				map.put("msg","用户信息不存在");
				map.put("status",false);
				map.put("payPage",errorpay);
				return map;
			}
			//当用户操作充值（网关或者银联）判读用户是否是普通用户
			Boolean flag=true;
			if(payPage=="register_h5/fund_h5"||payPage=="register_h5/fund_pc") {
				Integer isadmin=sub.getIsadmin();
				if(null!=isadmin&&isadmin!=0&&isadmin!=6) {
					log.info("非普通用户无法充值");
					map.put("msg","非普通用户无法充值");
					map.put("status",false);
					map.put("payPage",errorpay);
					return map;
				}
			}
			
			//当用户操作的是提现，判读用户是否是普通用户
			if(payPage=="register_h5/fundRaising") {
				Integer isadmin=sub.getIsadmin();
				if(null!=isadmin&&isadmin!=0&&isadmin!=6) {//如果用户不是普通用户，则无需实名认证
					flag=false;
				}
			}
			
			if(flag){//当用户操作提现且不是普通用户时，不必进行是否实名认证的判断
			//判断用户是否实名认证
			if (sub.getAuthState()!=null&&sub.getAuthState()!=2) {
				String msg="";
				Integer state=sub.getAuthState();
				msg=state==0?"用户未实名认证":state==1?"用户实名认证审核中":"用户实名认证未通过";
				map.put("msg",msg);
				map.put("status",false);
				map.put("payPage",errorpay);
				return map;
				}
			}
			map.put("msg","用户已实名认证");
			map.put("status",true);
			map.put("users",sub);
			map.put("payPage",payPage);
		} catch (Exception e) {
			log.error("查询用户异常");
		}

		return map;
	}	
}