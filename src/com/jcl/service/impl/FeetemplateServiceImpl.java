package com.jcl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcl.dao.FeetemplateMapper;
import com.jcl.dao.Feetemplate_menuMapper;
import com.jcl.pojo.FeetemplateExample;
import com.jcl.pojo.FeetemplateExample.Criteria;
import com.jcl.service.FeetemplateService;

@Service
@Transactional(rollbackFor=Exception.class)
public class FeetemplateServiceImpl implements FeetemplateService {
	
	@Autowired
	private FeetemplateMapper feetemplateMapper;
	
	@Autowired
	private Feetemplate_menuMapper feetemplate_menuMapper;
	
	@Override
	public void deleteByMenuId(Integer id) {
		feetemplate_menuMapper.deleteByPrimaryKey(id);
		FeetemplateExample example = new FeetemplateExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentidEqualTo(id);
		feetemplateMapper.deleteByExample(example);
	}

}
