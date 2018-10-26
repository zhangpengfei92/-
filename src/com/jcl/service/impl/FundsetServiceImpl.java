/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @FundsetServiceImpl.java
 * 功能概要  : 
 * 做成日期  : @2018年9月17日
 * 修改日期  :
 */
package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.FundsetMapper;
import com.jcl.pojo.Fundset;
import com.jcl.pojo.FundsetExample;
import com.jcl.pojo.FundsetExample.Criteria;
import com.jcl.service.FundsetService;
import com.jcl.util.StringUtil;

/** 
 * @author zpf
 * @version 1.0
 */
@Service
public class FundsetServiceImpl implements FundsetService{

	@Autowired
	private FundsetMapper fundsetMapper;
	
	@Override
	public int savefundset(Fundset fundset) {
		
		int num =0;
		
		if(fundset.getId()==null||fundset.getId()==0){
			num=fundsetMapper.insertSelective(fundset);//添加
		}else {
			num=fundsetMapper.updateByPrimaryKeySelective(fundset);//修改
		}

		return num;
	}

	@Override
	public Fundset selectone() {
		Fundset fundset=null;
		List<Fundset> flist = fundsetMapper.selectByExample(null);
		if(flist!=null&&flist.size()>0) {
			fundset=flist.get(0);
			fundset.setStarttime(fundset.getStarttime().substring(0, fundset.getStarttime().indexOf(".")));
			fundset.setEndtime(fundset.getEndtime().substring(0, fundset.getEndtime().indexOf(".")));
			
		}
		
		return fundset;
	}

	@Override
	public Fundset selectByTime(String dateTotimeString) {
		FundsetExample example=new FundsetExample();
		Criteria createCriteria = example.createCriteria();
		if(!StringUtil.isAllNullOrEmpty(dateTotimeString)) {
			List<Fundset> flist = fundsetMapper.selectByExample(example);
			
		}
		
		return null;
	}

}
