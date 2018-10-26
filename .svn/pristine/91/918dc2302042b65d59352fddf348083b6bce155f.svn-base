/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @DocumentServiceImpl.java
 * 功能概要  : 
 * 做成日期  : @2018年4月20日
 * 修改日期  :
 */
package com.jcl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.DocumentMapper;
import com.jcl.pojo.Document;
import com.jcl.pojo.DocumentExample;
import com.jcl.service.DocumentService;
import com.jcl.util.DateUtil;

/** 
 * @author zpf
 * @version 1.0
 */
@Service
public class DocumentServiceImpl implements DocumentService{
		
	@Autowired
	private DocumentMapper documentMapper;
	
	@Override
	public int add(Document document) {
		document.setDoctime(new Date());
		document.setDocstate(1);
	return	documentMapper.insertSelective(document);
	}

	@Override
	public List<Document> queryAll() {
		DocumentExample example=new DocumentExample();
		List<Document> dlist = documentMapper.selectByExample(example);
		return dlist;
	}

	@Override
	public Document queryDocByID(Integer did) {
		
		return documentMapper.selectByPrimaryKey(did);
	}

	@Override
	public int deldoc(int did) {
		return documentMapper.deleteByPrimaryKey(did);
	}

	@Override
	public List<Document> queryByname(String docnaem) {
		List<Document> dlist=documentMapper.selectByname(docnaem);
		return dlist;
	}
}
