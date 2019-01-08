package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcl.dao.RiskTempallMapper;
import com.jcl.pojo.RiskTempall;
import com.jcl.pojo.RiskTempallExample;
import com.jcl.service.RiskTempallService;

@Service
public class RiskTempallServiceImpl implements RiskTempallService {

	@Autowired
	private RiskTempallMapper riskTempallMapper;
	
	@Override
	public List<RiskTempall> selectAll() {
		return riskTempallMapper.selectAll();
	}

	@Override
	public RiskTempall selectByPrimaryKey(Integer id) {
		return riskTempallMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<RiskTempall> selectByExample(RiskTempallExample example) {
		return riskTempallMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return riskTempallMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(RiskTempall record) {
		return riskTempallMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		//return RiskTempallMapper.updateByid(email, phone, id);
		return 0;
	}
	
	@Override
	public int insertSelective(RiskTempall record) throws Exception {
		return riskTempallMapper.insertSelective(record);
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlByRiskTempallAndAccount() {
		return RiskTempallMapper.selectALlByRiskTempallAndAccount();
	}*/
	
	@Override
	public List<RiskTempall> isExist(String riskTempall, Integer id) {
		return riskTempallMapper.isExist(riskTempall, id);
	}
	
}
