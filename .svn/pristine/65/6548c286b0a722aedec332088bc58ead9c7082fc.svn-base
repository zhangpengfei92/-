package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcl.dao.RiskStockMapper;
import com.jcl.pojo.RiskStock;
import com.jcl.pojo.RiskStockExample;
import com.jcl.service.RiskStockService;

@Service
public class RiskStockServiceImpl implements RiskStockService {

	@Autowired
	private RiskStockMapper riskStockMapper;
	
	@Override
	public List<RiskStock> selectAll() {
		return riskStockMapper.selectAll();
	}

	@Override
	public RiskStock selectByPrimaryKey(Integer id) {
		return riskStockMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<RiskStock> selectByExample(RiskStockExample example) {
		return riskStockMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return riskStockMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(RiskStock record) {
		return riskStockMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		//return RiskStockMapper.updateByid(email, phone, id);
		return 0;
	}
	
	@Override
	public int insertSelective(RiskStock record) throws Exception {
		return riskStockMapper.insertSelective(record);
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlByRiskStockAndAccount() {
		return RiskStockMapper.selectALlByRiskStockAndAccount();
	}*/
	
	@Override
	public List<RiskStock> isExist(Integer parentid, Integer type, String riskStock) {
		return riskStockMapper.isExist(parentid, type, riskStock);
	}
	
}
