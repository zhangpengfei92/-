package com.jcl.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.RightsColumnMapper;
import com.jcl.pojo.RightsColumn;
import com.jcl.pojo.RightsColumnExample;
import com.jcl.pojo.RightsColumnExample.Criteria;
import com.jcl.service.RightsColumnService;
import com.jcl.util.StringUtil;

@Service
public class RightsColumnServiceImpl implements RightsColumnService {

	@Autowired
	private RightsColumnMapper rightsColumnMapper;
	
	@Override
	public void insert(RightsColumn RightsColumn) {
		rightsColumnMapper.insert(RightsColumn);
	}

	@Override
	public int insertSelective(RightsColumn rightsColumn) {
		return rightsColumnMapper.insertSelective(rightsColumn);
	}

	@Override
	public RightsColumn selectByPrimaryKey(Integer id) {
		return rightsColumnMapper.selectByPrimaryKey(id);
	}

	@Override
	public void update(RightsColumn RightsColumn) {
		rightsColumnMapper.updateByPrimaryKeySelective(RightsColumn);
	}

	@Override
	public List<RightsColumn> isExist(String rightsColumnname) {
		return rightsColumnMapper.isExist(rightsColumnname);
	}

	@Override
	public List<RightsColumn> selectRightsColumnListByCondition(Map<String, Object> mapCondition) throws Exception {
		
		String status = (String) mapCondition.get("status");
		/*用户名*/
		String columnName = (String) mapCondition.get("columnName");
		//构造查询条件
		RightsColumnExample example = new RightsColumnExample();
		example.setOrderByClause(" id asc");
		Criteria criteria = example.createCriteria();
		if(!StringUtil.isAnyNullOrEmpty(status)){
			criteria.andStatusEqualTo(Integer.parseInt(status));
		}
		if(!StringUtil.isAnyNullOrEmpty(columnName)){
			criteria.andColumnnameLike(columnName);
		}
		
		return rightsColumnMapper.selectByExample(example);
	}

}
