package com.jcl.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.SubServiceFeeMapper;
import com.jcl.pojo.SubServiceFee;
import com.jcl.pojo.SubServiceFeeExample;
import com.jcl.pojo.SubServiceFeeExample.Criteria;
import com.jcl.service.SubServiceFeeService;


@Service
public class SubServiceFeeServiceImpl implements SubServiceFeeService {
	
	@Autowired
	private SubServiceFeeMapper subServiceFeeMapper;

	@Override
	public List<SubServiceFee> getSubServiceFeeList(Map<String, Object> map) {
		SubServiceFeeExample example = new SubServiceFeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andSubzhEqualTo((String)map.get("subzh"));
		return subServiceFeeMapper.selectByExample(example);
	}
	
}
