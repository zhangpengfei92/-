/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @FileController.java
 * 功能概要  : 
 * 做成日期  : @2018年4月19日
 * 修改日期  :
 */
package com.jcl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jcl.comm.PaginationContext;
import com.jcl.pojo.Bdzh;
import com.jcl.pojo.Document;
import com.jcl.service.DocumentService;
import com.jcl.util.BuildHtmlUtil;
import com.jcl.util.Constant;
import com.jcl.util.DateUtil;

import zmq.Req;

/** 
 * @author zpf
 * @version 1.0
 * 
 * App文档控制层
 */
@RequestMapping("/doc")
@Controller
public class DocumentController {
	public static Logger log = Logger.getLogger(DocumentController.class);
	
	@Autowired
	private DocumentService documentServiceImpl;

	
	@RequestMapping("/queryAll")	
	public String toNewFunFile(Model model,HttpSession session){
		session.setAttribute(Constant.SESSION_LEFTMENU, "21");
		try {
			//设置分页参数
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			List<Document> dlist = documentServiceImpl.queryAll();
			PageInfo<Document> userpage = new PageInfo<Document>(dlist);
			
			//向页面返回数据
			model.addAttribute("dlist", dlist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询账户列表异常："+e.getMessage());
		}
		return "file/docList";
	}
	
	@RequestMapping("/queryByname")	
	public String queryByname(String docnaem,Model model){
		try {
			//设置分页参数
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			List<Document> dlist = documentServiceImpl.queryByname(docnaem);
			PageInfo<Document> userpage = new PageInfo<Document>(dlist);
			
			//向页面返回数据
			model.addAttribute("docnaem", docnaem);
			model.addAttribute("dlist", dlist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询账户列表异常："+e.getMessage());
		}
		return "file/docList";
	}
	
	@RequestMapping("/queryDoc")	
	public String queryDoc(Integer did,Model model){
		String docurl="docList";
		try {	
			Document doc= documentServiceImpl.queryDocByID(did);
			docurl= doc.getDocurl();
			model.addAttribute("docurl", doc.getDocurl());
		} catch (Exception e) {
			log.error("查询账户列表异常："+e.getMessage());
		}
		return "";
	}
	
	
	
	//去添加
	@RequestMapping("/toAdd")
	public String toAdd(){	
		
		return "file/addDoc";	
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public int AddDoc(Document doc,HttpSession session){	
		doc.setAuthor((String) session.getAttribute(Constant.SESSION_LOGINNAME));
		try {	
			
			 HashMap<String,Object> map = new HashMap<String, Object>();
			 	map.put("docname", doc.getDocname());
		        map.put("title", doc.getTitle());
		        map.put("time", DateUtil.dateToString(new Date()));
		        map.put("content", doc.getDoccontext());
		        String htmlAddress="../app/doc_"+System.currentTimeMillis()+".html";
		        doc.setDocurl(htmlAddress);
				BuildHtmlUtil.createHtml(map, "infoModel.ftl", htmlAddress,session);		        
		} catch (Exception e) {
			log.error("查询账户列表异常："+e.getMessage());
		}
		
		return documentServiceImpl.add(doc);	
	}
	
	@Transactional
	@RequestMapping("/delByid")
	@ResponseBody
	public int delByid(@RequestParam("id") int id,Model model){
	int num	=documentServiceImpl.deldoc(id);
	return num;	
	}
}
