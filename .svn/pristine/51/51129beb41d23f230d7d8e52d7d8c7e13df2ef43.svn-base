/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @OperateSchemeController.java
 * 功能概要  : 
 * 做成日期  : @2018年4月18日
 * 修改日期  :
 */
package com.jcl.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jcl.comm.PaginationContext;
import com.jcl.pojo.Bdzh;
import com.jcl.pojo.OperateScheme;
import com.jcl.pojo.RiskTempall;
import com.jcl.pojo.RiskTemplateMenu;
import com.jcl.service.OperateSchemeService;
import com.jcl.service.RiskTempallService;
import com.jcl.service.RiskTemplateMenuService;
import com.jcl.util.Constant;
import com.jcl.util.StringUtil;
import com.sun.org.apache.regexp.internal.recompile;

/** 
 * @author zpf
 * @version 1.0
 */
@Controller
@RequestMapping("/OperateScheme")
public class OperateSchemeController {
	
	public static Logger log = Logger.getLogger(OperateSchemeController.class);
	//注入操盘服务对象
	@Autowired
	private OperateSchemeService operateSchemeServiceImpl;
/*	//注入风控模板菜单服务
	@Autowired 
	private RiskTemplateMenuService riskTemplateMenuService;*/
	
	//注入风控模板菜单
	@Autowired
	private RiskTempallService riskTempallServiceImpl;
	
	//操盘方案全查询
	@RequestMapping("queryAll")
	public String queryAll(HttpSession session, Model model) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "11");
		try {
			//设置分页参数
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			List<OperateScheme> olist = operateSchemeServiceImpl.selectAll();
			PageInfo<OperateScheme> userpage = new PageInfo<OperateScheme>(olist);
			
			//向页面返回数据
			model.addAttribute("olist", olist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询账户列表异常："+e.getMessage());
		}
		return "fund/schemeList";		
	}
	
	//模糊查询
	@RequestMapping("selectPage")
	public String selectByName(Model model,String schemename) {
		try {
			//设置分页参数
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			if(!StringUtil.isAnyNullOrEmpty(schemename)) {
				model.addAttribute("schemename", schemename);
			}
			
			List<OperateScheme> olist = operateSchemeServiceImpl.selectByName(schemename);
			PageInfo<OperateScheme> userpage = new PageInfo<OperateScheme>(olist);
			if(!StringUtil.isAnyNullOrEmpty(schemename)) {
				model.addAttribute("schemename", schemename);
			}
			//向页面返回数据
			model.addAttribute("olist", olist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询账户列表异常："+e.getMessage());
		}
		return "fund/schemeList";		
	}
	
	@RequestMapping("addoplist")
	public String toadd(Model model) {
		
		try {
			
		 List<RiskTempall> rlist = riskTempallServiceImpl.selectAll();
			model.addAttribute("rlist", rlist);
			
		} catch (Exception e) {
			log.error("查询账户列表异常："+e.getMessage());
		}
		return "fund/addopList";
	}
	
	@RequestMapping("upoplist")
	public String update(Model model, Integer id) {
		
	try {
		List<RiskTempall> rlist = riskTempallServiceImpl.selectAll();
		OperateScheme os=operateSchemeServiceImpl.selectByID(id);
		model.addAttribute("os", os);
		model.addAttribute("rlist", rlist);
		} catch (Exception e) {
			log.error("查询账户列表异常："+e.getMessage());
		}
		
		return "fund/addopList";	
	}
	
	//条件查询
	
	//添加
	@RequestMapping("add")
	@ResponseBody
	public int addOperateScheme(OperateScheme operateScheme){
		operateScheme.setOsstate(1);
		return operateSchemeServiceImpl.addOperateScheme(operateScheme);
	}
	//修改
	@RequestMapping("update")
	@ResponseBody
	public int updateOperateScheme(OperateScheme operateScheme){
		operateScheme.setOsstate(1);
		return operateSchemeServiceImpl.updateOperateScheme(operateScheme);	
	}
	
	//删除
	@RequestMapping("deleteos")
	public String deleteos(Integer osid) {
		operateSchemeServiceImpl.deleteo(osid);	
		return "redirect:/OperateScheme/queryAll";	
	}
	
}
