package com.jcl.service;

import java.util.List;
import java.util.Map;

import com.jcl.pojo.Subzh;

public interface UserInfoDataService {
	List<Subzh> userLogin(Map<String,Object> map);
	
	int regUserInfoData(Map<String,Object> map) throws Exception;
	
	int updatePwd(Map<String,Object> map) throws Exception;
	
	int updateUserInfoData(Subzh ud) throws Exception;

	Subzh getUserInfoByid(Integer id);
	
	//查询用户信息
	List<Subzh> getUserInfoAllOrByPhone(String phone);

	Subzh getUserInfoByPhone(String phone);
}
