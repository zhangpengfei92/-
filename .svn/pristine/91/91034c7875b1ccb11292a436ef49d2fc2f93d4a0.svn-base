package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcl.dao.RiskHolderMapper;
import com.jcl.pojo.RiskHolder;
import com.jcl.pojo.RiskHolderExample;
import com.jcl.service.RiskHolderService;

@Service
public class RiskHolderServiceImpl implements RiskHolderService {

	@Autowired
	private RiskHolderMapper riskHolderMapper;
	
	@Override
	public List<RiskHolder> selectAll() {
		return riskHolderMapper.selectAll();
	}

	@Override
	public RiskHolder selectByPrimaryKey(Integer id) {
		return riskHolderMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<RiskHolder> selectByExample(RiskHolderExample example) {
		return riskHolderMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		/*RiskHolder record = RiskHolderMapper.selectByPrimaryKey(id);
		if(record != null){
			删除用户权限
			UserRightsExample example = new UserRightsExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(record.getUsername());
			userRightsMapper.deleteByExample(example);
		}*/
		return riskHolderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(RiskHolder record) {
		return riskHolderMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		//return RiskHolderMapper.updateByid(email, phone, id);
		return 0;
	}
	
	@Override
	public int insertSelective(RiskHolder record) throws Exception {
		/*if(roleList != null && roleList.size() > 0){//保存用户权限
			UserRights userRights = null;
			Date nowDate = Calendar.getInstance().getTime();
			for(RightsRole rightsRole : roleList){
				userRights = new UserRights();
				userRights.setUsername(record.getUsername());
				userRights.setInfo(rightsRole.getColumnId().toString());//权限ID
				userRights.setStarttime(record.getStarttime());//开始时间
				userRights.setEndtime(record.getEndtime());//结束时间
				userRights.setCreatedAt(nowDate);
				userRightsMapper.insertSelective(userRights);
			}
		}*/
		return riskHolderMapper.insertSelective(record);
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlByRiskHolderAndAccount() {
		return RiskHolderMapper.selectALlByRiskHolderAndAccount();
	}*/
	
	@Override
	public List<RiskHolder> isExist(String riskHolder) {
		return riskHolderMapper.isExist(riskHolder);
	}
	
}
