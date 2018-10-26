package com.jcl.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.SubFeelogMapper;
import com.jcl.dao.SubzhFundLogMapper;
import com.jcl.pojo.SubFeelog;
import com.jcl.pojo.SubzhFundLog;
import com.jcl.service.SubFeelogService;


@Service
public class SubFeelogServiceImpl implements SubFeelogService {
	@Autowired
	SubFeelogMapper subFeelogMapper;
	
	@Autowired
	SubzhFundLogMapper subzhFundLogMapper;
	
	@Override
	public int saveSubFeelog(SubFeelog sfl) {
		return subFeelogMapper.insertSelective(sfl);
	}

	@Override
	public int saveSubzhFundlog(SubzhFundLog sfl) {
		return subzhFundLogMapper.insertSelective(sfl);
	}
	
	
	
}
