package com.jcl.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcl.dao.AgentzhfundLogMapper;
import com.jcl.pojo.RightsRole;
import com.jcl.pojo.AgentzhfundLog;
import com.jcl.pojo.AgentzhfundLogExample;
import com.jcl.pojo.AgentzhfundLogExample.Criteria;
import com.jcl.service.AgentzhfundLogService;

@Service
public class AgentzhfundLogServiceImpl implements AgentzhfundLogService {

	@Autowired
	private AgentzhfundLogMapper agentzhfundLogMapper;
	
	@Override
	public List<AgentzhfundLog> selectAll() {
		return agentzhfundLogMapper.selectAll();
	}

	@Override
	public AgentzhfundLog selectByPrimaryKey(Integer id) {
		return agentzhfundLogMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<AgentzhfundLog> selectByorderno(String  orderno) {
		
		return agentzhfundLogMapper.selectByorderno(orderno);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		/*AgentzhfundLog record = AgentzhfundLogMapper.selectByPrimaryKey(id);
		if(record != null){
			删除用户权限
			UserRightsExample example = new UserRightsExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(record.getUsername());
			userRightsMapper.deleteByExample(example);
		}*/
		return agentzhfundLogMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeyAndRole(AgentzhfundLog record, List<RightsRole> roleList) {
		/*删除用户权限、更新用户权限
		UserRightsExample example = new UserRightsExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(record.getUsername());
		userRightsMapper.deleteByExample(example);
		if(roleList != null && roleList.size() > 0){//保存用户权限
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
		return agentzhfundLogMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public int updateByPrimaryKey(AgentzhfundLog record) {
		
		return agentzhfundLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		//return AgentzhfundLogMapper.updateByid(email, phone, id);
		return 0;
	}
	
	@Override
	public int insertSelective(AgentzhfundLog record, List<RightsRole> roleList) throws Exception {
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
		return agentzhfundLogMapper.insertSelective(record);
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlByAgentzhfundLogAndAccount() {
		return AgentzhfundLogMapper.selectALlByAgentzhfundLogAndAccount();
	}*/
	
	@Override
	public List<AgentzhfundLog> isExist(String agentzhfundLog) {
		
		return agentzhfundLogMapper.isExist(agentzhfundLog);
	}

	@Override
	public int insertagentzhfundLog(AgentzhfundLog afl) {
	
		return agentzhfundLogMapper.insertSelective(afl);
	}

	@Override
	public List<AgentzhfundLog> selectByExample(String strToDateLong) {
		
		AgentzhfundLogExample example=new AgentzhfundLogExample();
		Criteria create = example.createCriteria();
		create.andOrdernoEqualTo(strToDateLong);
		return agentzhfundLogMapper.selectByExample(example);
	}

	@Override
	public int updateStateBysubzh(AgentzhfundLog agentzhfundLog) {
		return agentzhfundLogMapper.updateByPrimaryKeySelective(agentzhfundLog);
	}

	@Override
	public List<AgentzhfundLog> selectByExample(AgentzhfundLogExample example) {
		
		return agentzhfundLogMapper.selectByExample(example);
	}


	public int saveAgentzhFundLog(AgentzhfundLog agentzhfundLog){
		if(agentzhfundLog!=null){
			if(agentzhfundLog.getId()!=null){//修改
				return agentzhfundLogMapper.updateByPrimaryKey(agentzhfundLog);
			}else{//增加
				return agentzhfundLogMapper.insertSelective(agentzhfundLog);
			}
		}else{
			return 0;
		}
	}
	
}
