package com.jcl.service;

import java.util.List;
import java.util.Map;

import com.jcl.pojo.RightsRole;
import com.jcl.pojo.UserInfo;
import com.jcl.pojo.UserInfoExample;


public interface UserInfoService {

	// 查询所有会员信息
	List<UserInfo> selectAll();

	UserInfo selectByPrimaryKey(Integer id);

	// 模糊查询niclname和usertype
	List<Map<String,Object>> selectByLike(String nickname, Integer usertype);
	
	/**
	 * 根据条件获取会员列表集合
	 * @param userInfoExample
	 * @return list
	 * @throws Exception
	 */
	List<UserInfo> selectByExample(UserInfoExample example);

	int deleteByPrimaryKey(Integer id);
	
	/*更新用户权限*/
	int updateByPrimaryKeyAndRole(UserInfo record, List<RightsRole> roleList);

	int updateByPrimaryKey(UserInfo record);

	// 更新会员信息
	int updateByid(String email, String phone, Integer id);
	
	/*保存账户信息*/
	int insertSelective(UserInfo record, List<RightsRole> roleList) throws Exception;
	
	//List<Map<String,Object>> selectALlByUserInfoAndAccount();
	
	List<UserInfo> isExist(String username);

	int add(UserInfo userInfo);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-5
	 * @decribe
	 * @param example
	 */
	void deleteByExample(UserInfoExample example);

}
