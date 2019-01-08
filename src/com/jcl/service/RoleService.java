package com.jcl.service;

import java.util.List;

import com.jcl.pojo.Role;

public interface RoleService {

	void insert(Role role);
	
	int insertSelective(Role role);

	void insertRolePer(Integer roleId, Integer[] perid);

	List<Role> getListByLikeName(String name);

	int deleteByPrimaryKey(Integer id);

	Role selectByPrimaryKey(Integer id);

	Role selectById(Integer id);

	void update(Role role);

	List<Role> isExist(String rolename);

	List<Role> selectAll();
}
