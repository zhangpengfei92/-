/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @MyListen.java
 * 功能概要  : 
 * 做成日期  : @2019年2月12日
 * 修改日期  :
 */
package com.zpf.Filter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/** 
 * @author zpf
 * @version 1.0
 */
@WebListener()
public class MyListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("开始监听-------");
		String contextPath = sce.getServletContext().getContextPath();
		System.out.println("监听到的地址 ："+contextPath);		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
