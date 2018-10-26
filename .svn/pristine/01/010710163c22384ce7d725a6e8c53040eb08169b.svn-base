/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @OperateSchemeServiceImpl.java
 * 功能概要  : 
 * 做成日期  : @2018年4月18日
 * 修改日期  :
 */
package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.OperateSchemeMapper;
import com.jcl.pojo.OperateScheme;
import com.jcl.service.OperateSchemeService;

/** 
 * @author zpf
 * @version 1.0
 */
@Service
public class OperateSchemeServiceImpl implements OperateSchemeService{
	
	@Autowired
	private OperateSchemeMapper operateSchemeMapper;
	
	//查询所有的操盘方案
	@Override
	public List<OperateScheme> selectAll() {
		
		return operateSchemeMapper.selectAll();
	}
	
	//根据ID查询单个操盘方案
	@Override
	public OperateScheme selectByID(Integer id) {
		
		return operateSchemeMapper.selectByID(id);
	}
	//添加操盘方案
	@Override
	public int addOperateScheme(OperateScheme operateScheme) {
	
		return operateSchemeMapper.insertSelective(operateScheme);
	}

	@Override
	public int updateOperateScheme(OperateScheme operateScheme) {
		
		return operateSchemeMapper.updateByPrimaryKey(operateScheme);
	}

	@Override
	public int deleteo(Integer osid) {
		operateSchemeMapper.updateOsstate(osid);
		return 0;
	}

	@Override
	public List<OperateScheme> selectByName(String str) {
		
		return operateSchemeMapper.selectByName(str);
	}

}
