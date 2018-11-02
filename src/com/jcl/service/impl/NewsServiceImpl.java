/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @NewsServiceImpl.java
 * 功能概要  : 
 * 做成日期  : @2018年5月22日
 * 修改日期  :
 */
package com.jcl.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.NewsMapper;
import com.jcl.pojo.News;
import com.jcl.pojo.NewsExample;
import com.jcl.pojo.NewsExample.Criteria;
import com.jcl.service.NewsService;
import com.jcl.util.DateUtil;
import com.jcl.vo.NewsVo;

/** 
 * @author zpf
 * @version 1.0
 * 
 * 新闻管理服务层
 */

@Service
public class NewsServiceImpl implements NewsService{
	
	//注入新闻管理的mapper
	@Autowired
	private NewsMapper newsMapper;

	@Override
	public Map<Integer, List<NewsVo>> queryAll() {
		
		List<NewsVo>nlist1 =new ArrayList<NewsVo>();
		List<NewsVo>nlist2 =new ArrayList<NewsVo>();
		List<NewsVo>nlist3 =new ArrayList<NewsVo>();
		List<NewsVo>nlist4 =new ArrayList<NewsVo>();

		List<News>nlist =newsMapper.selectByExample(null);
		
		Map<Integer, List<NewsVo>> map=new HashMap();
		
		for (News news : nlist) {
			if(news.getNtype()==1) {
				NewsVo newsVo = new NewsVo();
				try {
					BeanUtils.copyProperties(newsVo, news);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				String [] dateString=DateUtil.getYearandMonthandDay(news.getModifytime());
				newsVo.setNewsyear(dateString[0]);
				newsVo.setNewsmonth(dateString[1]);
				newsVo.setNewsday(dateString[2]);
				nlist1.add(newsVo);
			}
			if(news.getNtype()==2) {
				NewsVo newsVo = new NewsVo();
				try {
					BeanUtils.copyProperties(newsVo, news);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				String [] dateString=DateUtil.getYearandMonthandDay(news.getModifytime());
				newsVo.setNewsyear(dateString[0]);
				newsVo.setNewsmonth(dateString[1]);
				newsVo.setNewsday(dateString[2]);
				nlist2.add(newsVo);
			}
			if(news.getNtype()==3) {
				NewsVo newsVo = new NewsVo();
				try {
					BeanUtils.copyProperties(newsVo, news);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				String [] dateString=DateUtil.getYearandMonthandDay(news.getModifytime());
				newsVo.setNewsyear(dateString[0]);
				newsVo.setNewsmonth(dateString[1]);
				newsVo.setNewsday(dateString[2]);
				nlist3.add(newsVo);
			}
			if(news.getNtype()==4) {
				NewsVo newsVo = new NewsVo();
				try {
					BeanUtils.copyProperties(newsVo, news);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				String [] dateString=DateUtil.getYearandMonthandDay(news.getModifytime());
				newsVo.setNewsyear(dateString[0]);
				newsVo.setNewsmonth(dateString[1]);
				newsVo.setNewsday(dateString[2]);
				nlist4.add(newsVo);
			}
		}
		
		map.put(1, nlist1);
		map.put(2, nlist2);
		map.put(3, nlist3);
		map.put(4, nlist4);
		
		return map;
	}

	@Override
	public NewsVo queryByID(Integer nid) {
		NewsVo newsVo= new NewsVo();
		
		News news =newsMapper.selectByPrimaryKey(nid);

		try {
			BeanUtils.copyProperties(newsVo, news);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		String [] dateString=DateUtil.getYearandMonthandDay(news.getModifytime());
		newsVo.setNewsyear(dateString[0]);
		newsVo.setNewsmonth(dateString[1]);
		newsVo.setNewsday(dateString[2]);
		
		return newsVo;
	}

	@Override
	public List<News> queryNewsByType(int num) {
		 List<News> list = newsMapper.selectByNewsByType(num);
		return list;
	}
		
	
}
