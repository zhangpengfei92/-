package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcl.dao.FundSettlelogMapper;
import com.jcl.pojo.RightsRole;
import com.jcl.pojo.FundSettlelog;
import com.jcl.pojo.FundSettlelogExample;
import com.jcl.service.FundSettlelogService;

@Service
public class FundSettlelogServiceImpl implements FundSettlelogService {

	@Autowired
	private FundSettlelogMapper fundSettlelogMapper;
	
	@Override
	public List<FundSettlelog> selectAll() {
		return fundSettlelogMapper.selectAll();
	}

	@Override
	public FundSettlelog selectByPrimaryKey(Integer id) {
		return fundSettlelogMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<FundSettlelog> selectByExample(FundSettlelogExample example) {
		return fundSettlelogMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		/*FundSettlelog record = FundSettlelogMapper.selectByPrimaryKey(id);
		if(record != null){
			删除用户权限
			UserRightsExample example = new UserRightsExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(record.getUsername());
			userRightsMapper.deleteByExample(example);
		}*/
		return fundSettlelogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeyAndRole(FundSettlelog record, List<RightsRole> roleList) {
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
		return fundSettlelogMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public int updateByPrimaryKey(FundSettlelog record) {
		return fundSettlelogMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		//return FundSettlelogMapper.updateByid(email, phone, id);
		return 0;
	}
	
	@Override
	public int insertSelective(FundSettlelog record) throws Exception {
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
		return fundSettlelogMapper.insertSelective(record);
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlByFundSettlelogAndAccount() {
		return FundSettlelogMapper.selectALlByFundSettlelogAndAccount();
	}*/
	
	@Override
	public List<FundSettlelog> isExist(String username) {
		//return fundSettlelogMapper.isExist(username);
		return null;
	}
	
}
