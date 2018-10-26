package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.SubzhContractMapper;
import com.jcl.pojo.SubzhContract;
import com.jcl.service.SubzhContractService;


@Service
public class SubzhContractServiceImpl implements SubzhContractService {
	@Autowired
	private SubzhContractMapper subzhContractMapper;

	@Override
	public List<SubzhContract> selectBySubzh(String subzh) {

		return subzhContractMapper.selectSubzhContractsBySubzh(subzh);
	}
}
