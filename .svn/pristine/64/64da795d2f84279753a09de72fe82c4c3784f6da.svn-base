package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcl.dao.CodefeesetMapper;
import com.jcl.pojo.Codefeeset;
import com.jcl.pojo.CodefeesetExample;
import com.jcl.service.CodefeesetService;

@Service
public class CodefeesetServiceImpl implements CodefeesetService {

	@Autowired
	private CodefeesetMapper codefeesetMapper;
	
	@Override
	public List<Codefeeset> selectAll() {
		return codefeesetMapper.selectAll();
	}

	@Override
	public Codefeeset selectByPrimaryKey(Integer id) {
		return codefeesetMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<Codefeeset> selectByExample(CodefeesetExample example) {
		return codefeesetMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		/*Codefeeset record = CodefeesetMapper.selectByPrimaryKey(id);
		if(record != null){
			删除用户权限
			UserRightsExample example = new UserRightsExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(record.getUsername());
			userRightsMapper.deleteByExample(example);
		}*/
		return codefeesetMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeyAndRole(Codefeeset record) {
		return codefeesetMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public int updateByPrimaryKey(Codefeeset record) {
		return codefeesetMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		//return CodefeesetMapper.updateByid(email, phone, id);
		return 0;
	}
	
	@Override
	public int insertSelective(Codefeeset record) throws Exception {
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
		return codefeesetMapper.insertSelective(record);
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlByCodefeesetAndAccount() {
		return CodefeesetMapper.selectALlByCodefeesetAndAccount();
	}*/
	
	@Override
	public List<Codefeeset> isExist(String codefeeset, Integer id, Integer parentId) {
		return codefeesetMapper.isExist(codefeeset, id, parentId);
	}
	
	
	public int deleteByMenu(Integer parentid){
		return codefeesetMapper.deleteByMenu(parentid);
	}
}
