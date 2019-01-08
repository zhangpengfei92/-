/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @Page.java
 * 功能概要  : 
 * 做成日期  : @2018年5月4日
 * 修改日期  :
 */
package com.jcl.mongodb;

import java.util.List;

/** 
 * @author zpf
 * @version 1.0
 */
public class Page<T> {
	private Integer pagenum=1;//当前页
	private Integer pagesize=10;//每页显示条数
	private Long countsize;//总条数
	private Integer pagecount;//总页数
	private Integer initialSize;//当前页初始条数
	private List<T> list;//
	
	public Integer getPagenum() {
		return pagenum;
	}
	public void setPagenum(Integer pagenum) {
		this.pagenum = pagenum;
	}
	public Integer getPagesize() {
		return pagesize;
	}
	public void setPagesize(Integer pagesize) {
		this.pagesize = pagesize;
	}
	public Integer getPagecount() {
		return pagecount;
	}
	public void setPagecount(Long countsize) {
		this.pagecount = ((countsize%pagesize ==0 ? (int)(countsize/pagesize) : (int)(countsize/pagesize)+1));
	}
	public Long getCountsize() {
		return countsize;
	}
	public void setCountsize(Long countsize) {
		this.countsize = countsize;
	}
	public Integer getInitialSize() {
		return initialSize;
	}
	public void setInitialSize(Integer pagenum) {
		this.initialSize =(pagenum-1)*pagesize;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}	
	
	
}
