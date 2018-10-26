package com.jcl.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.authdao.UserInfoMapper;
import com.jcl.dao.UserRightsMapper;
import com.jcl.pojo.RightsRole;
import com.jcl.pojo.UserInfo;
import com.jcl.pojo.UserInfoExample;
import com.jcl.pojo.UserRights;
import com.jcl.pojo.UserRightsExample;
import com.jcl.pojo.UserRightsExample.Criteria;
import com.jcl.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Autowired
	private UserRightsMapper userRightsMapper;

	@Override
	public List<UserInfo> selectAll() {
		return userInfoMapper.selectByExample(null);
	}

	@Override
	public UserInfo selectByPrimaryKey(Integer id) {
		return userInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Map<String,Object>> selectByLike(String nickname, Integer usertype) {

		return userInfoMapper.selectByLike(nickname, usertype);

	}
	
	@Override
	public List<UserInfo> selectByExample(UserInfoExample example) {
		return userInfoMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		UserInfo record = userInfoMapper.selectByPrimaryKey(id);
		if(record != null){
			/*删除用户权限*/
			UserRightsExample example = new UserRightsExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(record.getUsername());
			userRightsMapper.deleteByExample(example);
		}
		return userInfoMapper.deleteByPrimaryKey(id);

	}

	@Override
	public int updateByPrimaryKeyAndRole(UserInfo record, List<RightsRole> roleList) {
		/*删除用户权限、更新用户权限*/
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
		}
		return userInfoMapper.updateByPrimaryKey(record);

	}
	
	@Override
	public int updateByPrimaryKey(UserInfo record) {
		return userInfoMapper.updateByPrimaryKeySelective(record);

	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		return userInfoMapper.updateByid(email, phone, id);

	}
	
	@Override
	public int insertSelective(UserInfo record, List<RightsRole> roleList) throws Exception {
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
		}
		return userInfoMapper.insertSelective(record);
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlByUserInfoAndAccount() {
		return userInfoMapper.selectALlByUserInfoAndAccount();
	}*/
	
	@Override
	public List<UserInfo> isExist(String username) {
		return userInfoMapper.isExist(username);
	}

	@Override
	public int add(UserInfo userInfo) {
		return userInfoMapper.insertSelective(userInfo);		
	}
	
	
	
	public void deleteByExample(UserInfoExample example){
		userInfoMapper.deleteByExample(example);
	}
	
}
