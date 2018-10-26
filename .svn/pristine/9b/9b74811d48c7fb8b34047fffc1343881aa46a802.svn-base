package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcl.dao.FeeSchemeMapper;
import com.jcl.pojo.FeeScheme;
import com.jcl.pojo.FeeSchemeExample;
import com.jcl.service.FeeSchemeService;

@Service
public class FeeSchemeServiceImpl implements FeeSchemeService {

	@Autowired
	private FeeSchemeMapper feeSchemeMapper;
	
	@Override
	public List<FeeScheme> selectAll() {
		return feeSchemeMapper.selectAll();
	}

	@Override
	public FeeScheme selectByPrimaryKey(Integer id) {
		return feeSchemeMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<FeeScheme> selectByExample(FeeSchemeExample example) {
		return feeSchemeMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return feeSchemeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(FeeScheme record) {
		return feeSchemeMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		//return FeeSchemeMapper.updateByid(email, phone, id);
		return 0;
	}
	
	@Override
	public int insertSelective(FeeScheme record) throws Exception {
		return feeSchemeMapper.insertSelective(record);
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlByFeeSchemeAndAccount() {
		return FeeSchemeMapper.selectALlByFeeSchemeAndAccount();
	}*/
	
	@Override
	public List<FeeScheme> isExist(String FeeScheme) {
		return feeSchemeMapper.isExist(FeeScheme);
	}
	
}
