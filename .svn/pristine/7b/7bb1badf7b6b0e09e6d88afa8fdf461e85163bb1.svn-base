package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcl.dao.ExceptOrderMapper;
import com.jcl.pojo.RightsRole;
import com.jcl.pojo.ExceptOrder;
import com.jcl.pojo.ExceptOrderExample;
import com.jcl.service.ExceptOrderService;

@Service
public class ExceptOrderServiceImpl implements ExceptOrderService {

	@Autowired
	private ExceptOrderMapper exceptOrderMapper;
	
	@Override
	public List<ExceptOrder> selectAll() {
		return exceptOrderMapper.selectAll();
	}

	@Override
	public List<ExceptOrder> selectByExample(ExceptOrderExample example) {
		return exceptOrderMapper.selectByExample(example);
	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		//return ExceptOrderMapper.updateByid(email, phone, id);
		return 0;
	}
	
	@Override
	public int insertSelective(ExceptOrder record, List<RightsRole> roleList) throws Exception {
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
		return exceptOrderMapper.insertSelective(record);
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlByExceptOrderAndAccount() {
		return ExceptOrderMapper.selectALlByExceptOrderAndAccount();
	}*/
	
	@Override
	public List<ExceptOrder> isExist(String username) {
		return exceptOrderMapper.isExist(username);
	}
	
}
