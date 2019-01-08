package com.jcl.service;

import java.util.List;

import com.jcl.pojo.Sysuser;

public interface SysuserService {

	Sysuser selectByName(String username);

	List<Sysuser> selectAll();
	
	List<Sysuser> getListByLikeName(String name);
	
	int deleteByPrimaryKey(Integer id);
	
	Sysuser selectByPrimaryKey(Integer id);

	void insert(Sysuser sysuser);

	void insertUserRole(Integer sysuserId, Integer rid);

	void update(Sysuser sysuser);

	Sysuser selectByID(Integer id);

	Sysuser selectByRoleAndPer(String username);

	List<Sysuser> isExist(String username);
}
