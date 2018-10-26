package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcl.dao.CodefeesetMenuMapper;
import com.jcl.pojo.CodefeesetMenu;
import com.jcl.pojo.CodefeesetMenuExample;
import com.jcl.service.CodefeesetMenuService;

@Service
public class CodefeesetMenuServiceImpl implements CodefeesetMenuService {

	@Autowired
	private CodefeesetMenuMapper codefeesetMenuMapper;
	
	@Override
	public List<CodefeesetMenu> selectAll() {
		return codefeesetMenuMapper.selectAll();
	}

	@Override
	public CodefeesetMenu selectByPrimaryKey(Integer id) {
		return codefeesetMenuMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<CodefeesetMenu> selectByExample(CodefeesetMenuExample example) {
		return codefeesetMenuMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return codefeesetMenuMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeyAndRole(CodefeesetMenu record) {
		return codefeesetMenuMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public int updateByPrimaryKey(CodefeesetMenu record) {
		return codefeesetMenuMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		//return CodefeesetMenuMapper.updateByid(email, phone, id);
		return 0;
	}
	
	@Override
	public int insertSelective(CodefeesetMenu record) throws Exception {
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
		return codefeesetMenuMapper.insertSelective(record);
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlByCodefeesetMenuAndAccount() {
		return CodefeesetMenuMapper.selectALlByCodefeesetMenuAndAccount();
	}*/
	
	@Override
	public List<CodefeesetMenu> isExist(String codefeesetMenu, Integer id) {
		return codefeesetMenuMapper.isExist(codefeesetMenu, id);
	}
	
}
