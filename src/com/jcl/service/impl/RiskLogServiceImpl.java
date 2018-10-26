package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcl.dao.RiskLogMapper;
import com.jcl.pojo.RightsRole;
import com.jcl.pojo.RiskLog;
import com.jcl.pojo.RiskLogExample;
import com.jcl.service.RiskLogService;

@Service
public class RiskLogServiceImpl implements RiskLogService {

	@Autowired
	private RiskLogMapper riskLogMapper;
	
	@Override
	public List<RiskLog> selectAll() {
		//return RiskLogMapper.selectAll();
		return null;
	}

	@Override
	public RiskLog selectByPrimaryKey(Integer id) {
		return riskLogMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<RiskLog> selectByExample(RiskLogExample example) {
		return riskLogMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		/*RiskLog record = RiskLogMapper.selectByPrimaryKey(id);
		if(record != null){
			删除用户权限
			UserRightsExample example = new UserRightsExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(record.getUsername());
			userRightsMapper.deleteByExample(example);
		}*/
		return riskLogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeyAndRole(RiskLog record, List<RightsRole> roleList) {
		return riskLogMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public int updateByPrimaryKey(RiskLog record) {
		return riskLogMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		//return RiskLogMapper.updateByid(email, phone, id);
		return 0;
	}
	
	@Override
	public int insertSelective(RiskLog record, List<RightsRole> roleList) throws Exception {
		return riskLogMapper.insertSelective(record);
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlByRiskLogAndAccount() {
		return RiskLogMapper.selectALlByRiskLogAndAccount();
	}*/
	
	@Override
	public List<RiskLog> isExist(String riskLog) {
		//return RiskLogMapper.isExist(RiskLog);
		return null;
	}
	
}
