/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @WeblinkServiceImpl.java
 * 功能概要  : 
 * 做成日期  : @2018年5月24日
 * 修改日期  :
 */
package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.WeblinkMapper;
import com.jcl.pojo.News;
import com.jcl.pojo.Weblink;
import com.jcl.service.WeblinkService;

/** 
 * @author zpf
 * @version 1.0
 */
@Service
public class WeblinkServiceImpl implements WeblinkService{

		@Autowired
		private WeblinkMapper weblinkMapper;

		@Override
		public List<Weblink> selectAll() {
			
			return weblinkMapper.selectByExample(null);
		}

		@Override
		public Weblink queryByid(Integer id) {
			
			return weblinkMapper.selectByPrimaryKey(id);
		}

		@Override
		public int delete(Integer id) {
			
			return weblinkMapper.deleteByPrimaryKey(id);
		}

		@Override
		public int add(Weblink weblink) {
			
			return weblinkMapper.insertSelective(weblink);
		}

		@Override
		public int update(Weblink weblink) {
			
			return weblinkMapper.updateByPrimaryKeySelective(weblink);
		}
		
		
}
