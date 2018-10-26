package com.jcl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.RoleMapper;
import com.jcl.pojo.Role;
import com.jcl.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public void insert(Role role) {
		roleMapper.insert(role);
	}

	@Override
	public int insertSelective(Role role) {
		return roleMapper.insertSelective(role);
	}

	@Override
	public void insertRolePer(Integer roleId, Integer[] perid) {
		roleMapper.deleteRolePerByRoleId(roleId); 
		for (Integer perId : perid) {
			roleMapper.insertRolePer(roleId,perId,new Date());
		}
	}

	@Override
	public List<Role> getListByLikeName(String name) {
		return roleMapper.getListByLikeName(name);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		roleMapper.deleteRolePerByRoleId(id);
		return roleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Role selectByPrimaryKey(Integer id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public Role selectById(Integer id) {
		Role returnRole = roleMapper.selectById(id);
		return returnRole;
	}

	@Override
	public void update(Role role) {
		roleMapper.updateByPrimaryKeySelective(role);
		
	}

	@Override
	public List<Role> isExist(String rolename) {
		return roleMapper.isExist(rolename);
	}

	@Override
	public List<Role> selectAll() {
		List<Role> rlist = roleMapper.select();
		return rlist;
	}

}
