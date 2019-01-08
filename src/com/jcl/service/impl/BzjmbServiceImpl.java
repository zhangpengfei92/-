package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcl.dao.BzjmbMapper;
import com.jcl.pojo.Bzjmb;
import com.jcl.pojo.BzjmbExample;
import com.jcl.service.BzjmbService;

@Service
public class BzjmbServiceImpl implements BzjmbService {

	@Autowired
	private BzjmbMapper bzjmbMapper;
	
	@Override
	public List<Bzjmb> selectAll() {
		return bzjmbMapper.selectAll();
	}

	@Override
	public Bzjmb selectByPrimaryKey(Integer id) {
		return bzjmbMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<Bzjmb> selectByExample(BzjmbExample example) {
		return bzjmbMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		/*Bzjmb record = BzjmbMapper.selectByPrimaryKey(id);
		if(record != null){
			删除用户权限
			UserRightsExample example = new UserRightsExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(record.getUsername());
			userRightsMapper.deleteByExample(example);
		}*/
		return bzjmbMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeyAndRole(Bzjmb record) {
		return bzjmbMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public int updateByPrimaryKey(Bzjmb record) {
		return bzjmbMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		//return BzjmbMapper.updateByid(email, phone, id);
		return 0;
	}
	
	@Override
	public int insertSelective(Bzjmb record) throws Exception {
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
		return bzjmbMapper.insertSelective(record);
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlByBzjmbAndAccount() {
		return BzjmbMapper.selectALlByBzjmbAndAccount();
	}*/
	
	@Override
	public List<Bzjmb> isExist(String bzjmb,Integer id, Integer parentId) {
		return bzjmbMapper.isExist(bzjmb,id,parentId);
	}
	
	
	public int deleteByParent(Integer parentid){
		return bzjmbMapper.deleteByParent(parentid);
	}
}
