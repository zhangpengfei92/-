package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcl.dao.BzjmbMenuMapper;
import com.jcl.pojo.BzjmbMenu;
import com.jcl.pojo.BzjmbMenuExample;
import com.jcl.service.BzjmbMenuService;

@Service
public class BzjmbMenuServiceImpl implements BzjmbMenuService {

	@Autowired
	private BzjmbMenuMapper bzjmbMenuMapper;
	
	@Override
	public List<BzjmbMenu> selectAll() {
		return bzjmbMenuMapper.selectAll();
	}

	@Override
	public BzjmbMenu selectByPrimaryKey(Integer id) {
		return bzjmbMenuMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<BzjmbMenu> selectByExample(BzjmbMenuExample example) {
		return bzjmbMenuMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return bzjmbMenuMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeyAndRole(BzjmbMenu record) {
		return bzjmbMenuMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public int updateByPrimaryKey(BzjmbMenu record) {
		return bzjmbMenuMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		//return BzjmbMenuMapper.updateByid(email, phone, id);
		return 0;
	}
	
	@Override
	public int insertSelective(BzjmbMenu record) throws Exception {
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
		return bzjmbMenuMapper.insertSelective(record);
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlByBzjmbMenuAndAccount() {
		return BzjmbMenuMapper.selectALlByBzjmbMenuAndAccount();
	}*/
	
	@Override
	public List<BzjmbMenu> isExist(String bzjmbMenu, Integer id) {
		return bzjmbMenuMapper.isExist(bzjmbMenu, id);
	}

	@Override
	public List<BzjmbMenu> selectAllByOrderBy() {
		
		return bzjmbMenuMapper.selectAllByOrderBy();
	}
	
}
