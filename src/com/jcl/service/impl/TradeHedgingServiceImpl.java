package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jcl.dao.TradeHedgingMapper;
import com.jcl.pojo.TradeHedging;
import com.jcl.pojo.TradeHedgingExample;
import com.jcl.service.TradeHedgingService;

@Service
public class TradeHedgingServiceImpl implements TradeHedgingService {

	@Autowired
	private TradeHedgingMapper tradeHedgingMapper;
	
	@Override
	public List<TradeHedging> selectAll() {
		return tradeHedgingMapper.selectAll();
	}

	@Override
	public TradeHedging selectByPrimaryKey(Integer id) {
		return tradeHedgingMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public List<TradeHedging> selectByExample(TradeHedgingExample example) {
		return tradeHedgingMapper.selectByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		/*TradeHedging record = TradeHedgingMapper.selectByPrimaryKey(id);
		if(record != null){
			删除用户权限
			UserRightsExample example = new UserRightsExample();
			Criteria criteria = example.createCriteria();
			criteria.andUsernameEqualTo(record.getUsername());
			userRightsMapper.deleteByExample(example);
		}*/
		return tradeHedgingMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeyAndRole(TradeHedging record) {
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
		return tradeHedgingMapper.updateByPrimaryKey(record);
	}
	
	@Override
	public int updateByPrimaryKey(TradeHedging record) {
		return tradeHedgingMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByid(String email, String phone, Integer id) {
		//return TradeHedgingMapper.updateByid(email, phone, id);
		return 0;
	}
	
	@Override
	public int insertSelective(TradeHedging record) throws Exception {
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
		return tradeHedgingMapper.insertSelective(record);
	}
	
	/*@Override
	public List<Map<String,Object>> selectALlByTradeHedgingAndAccount() {
		return TradeHedgingMapper.selectALlByTradeHedgingAndAccount();
	}*/
	
	@Override
	public List<TradeHedging> isExist(String tradeHedging) {
		//return tradeHedgingMapper.isExist(tradeHedging);
		return null;
	}
	
}
