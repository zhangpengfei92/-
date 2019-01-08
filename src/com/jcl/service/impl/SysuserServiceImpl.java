package com.jcl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.SysuserMapper;
import com.jcl.pojo.Sysuser;
import com.jcl.service.SysuserService;

@Service
public class SysuserServiceImpl implements SysuserService {

	@Autowired
	private SysuserMapper sysusermapper;

	@Override
	public Sysuser selectByName(String username) {
		return sysusermapper.selectByName( username);
	}

	@Override
	public List<Sysuser> selectAll() {
		return sysusermapper.selectAll();
	}

	@Override
	public List<Sysuser> getListByLikeName(String name) {
		if(null != name ){
			if(name != "" && !name.equals("")){
				name = "%"+name+"%";
			}else{
				name = null;
			}
		}
		return sysusermapper.getListByLikeName(name);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		sysusermapper.deleteUserRoleByUserId(id); 
		return sysusermapper.deleteByPrimaryKey(id);
	}

	@Override
	public Sysuser selectByPrimaryKey(Integer id) {
		return sysusermapper.selectByPrimaryKey(id);
	}

	@Override
	public void insert(Sysuser sysuser) {
		sysusermapper.insertSelective(sysuser);
	}

	@Override
	public void insertUserRole(Integer sysuserId, Integer rid) {
		sysusermapper.deleteUserRoleByUserId(sysuserId); 
		sysusermapper.insertUserRole(sysuserId,rid,new Date());
	}

	@Override
	public void update(Sysuser sysuser) {
		sysusermapper.updateByPrimaryKey(sysuser);
	}

	@Override
	public Sysuser selectByID(Integer id) {
		
		Sysuser returnSysuser = sysusermapper.getlistByAdmin(id);
		return returnSysuser;
	}

	@Override
	public Sysuser selectByRoleAndPer(String username) {
		return sysusermapper.selectByRoleAndPer(username);
	}

	@Override
	public List<Sysuser> isExist(String username) {
		return sysusermapper.isExist(username);
	}

}
