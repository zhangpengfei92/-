package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcl.dao.FundSumlogMapper;
import com.jcl.pojo.RightsRole;
import com.jcl.pojo.FundSumlog;
import com.jcl.pojo.FundSumlogExample;
import com.jcl.service.FundSumlogService;

@Service
public class FundSumlogServiceImpl implements FundSumlogService {

	@Autowired
	private FundSumlogMapper fundSumlogMapper;
	
	@Override
	public List<FundSumlog> selectAll() {
		return fundSumlogMapper.selectAll();
	}

	@Override
	public FundSumlog selectByPrimaryKey(Integer id) {
		return fundSumlogMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<FundSumlog> selectByExample(FundSumlogExample example) {
		return fundSumlogMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		/*FundSumlog record = FundSumlogMapper.selectByPrimaryKey(id);
		if(record != null){
			删除用户权限
			UserRightsExample example = new UserRightsExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(record.getUsername());
			userRightsMapper.deleteByExample(example);
		}*/
		return fundSumlogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeyAndRole(FundSumlog record, List<RightsRole> roleList) {
		/*删除用户权限、更新用户权限
		UserRightsExample example = new UserRightsExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(record.getUsername());
		userRightsMapper.deleteByExample(example);
		if(roleList != null && roleList.size() > 0){//保存用户权限
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
		return fundSumlogMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public int updateByPrimaryKey(FundSumlog record) {
		return fundSumlogMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		//return FundSumlogMapper.updateByid(email, phone, id);
		return 0;
	}
	
	@Override
	public int insertSelective(FundSumlog record) throws Exception {
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
		return fundSumlogMapper.insertSelective(record);
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlByFundSumlogAndAccount() {
		return FundSumlogMapper.selectALlByFundSumlogAndAccount();
	}*/
	
	@Override
	public List<FundSumlog> isExist(String username) {
		//return fundSumlogMapper.isExist(username);
		return null;
	}
	
}
