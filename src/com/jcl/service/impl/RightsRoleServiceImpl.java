package com.jcl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.RightsRoleMapper;
import com.jcl.pojo.RightsRole;
import com.jcl.service.RightsRoleService;

@Service
public class RightsRoleServiceImpl implements RightsRoleService {

	@Autowired
	private RightsRoleMapper rightsRoleMapper;
	
	@Override
	public void insert(RightsRole rightsRole) {
		rightsRoleMapper.insert(rightsRole);
	}

	@Override
	public int insertSelective(RightsRole rightsRole) {
		return rightsRoleMapper.insertSelective(rightsRole);
	}

	@Override
	public void insertRightsRolePer(Integer rightsRoleId, String[] perid) {
		rightsRoleMapper.deleteRightsRolePerByRightsRoleId(rightsRoleId); 
		for (String perId : perid) {
			rightsRoleMapper.insertRightsRolePer(rightsRoleId, Integer.parseInt(perId), new Date());
		}
	}

	@Override
	public List<RightsRole> getListByLikeName(String name) {
		return rightsRoleMapper.getListByLikeName(name);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		rightsRoleMapper.deleteRightsRolePerByRightsRoleId(id);
		return rightsRoleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public RightsRole selectByPrimaryKey(Integer id) {
		return rightsRoleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<RightsRole> selectById(Integer id) {
		List<RightsRole> returnRightsRole = rightsRoleMapper.selectById(id);
		return returnRightsRole;
	}

	@Override
	public void update(RightsRole rightsRole) {
		rightsRoleMapper.updateByPrimaryKeySelective(rightsRole);
	}

	@Override
	public List<RightsRole> isExist(String rightsRolename) {
		return rightsRoleMapper.isExist(rightsRolename);
	}

}
