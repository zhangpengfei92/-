package com.jcl.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcl.pojo.AppHelp;
import com.jcl.service.AppHelpInfoService;


@Controller
@RequestMapping("/appHelpInfo")
public class AppHelpInfoController {
	
	public static Logger log = Logger.getLogger(AppHelpInfoController.class);
	@Autowired
	private AppHelpInfoService appHelpInfoService;
	/**
	 * 查询帮助信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getHelpInfoList")
	@ResponseBody
	public Map<String,Object> getHelpInfoList(HttpServletRequest request,HttpSession session){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			
			List<AppHelp> helpList =  appHelpInfoService.getHelpInfoList();
			if(helpList != null && helpList.size() > 0){
				session.setAttribute("helpList", helpList.get(0));
				resultMap.put("code", "0");
				resultMap.put("message", "查询成功");
			}
		} catch (Exception e) {
			resultMap.put("code", "1");
			resultMap.put("message", "查询失败");
			log.error("查询帮助信息失败",e);
		}
		
		return resultMap;
	}
}
