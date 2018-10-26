package com.jcl.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.PremiumCycleMapper;
import com.jcl.dao.RiskSettingMapper;
import com.jcl.pojo.PremiumCycle;
import com.jcl.pojo.RiskSetting;
import com.jcl.pojo.RiskSettingExample;
import com.jcl.pojo.RiskSettingExample.Criteria;
import com.jcl.pojo.RiskSettingWithBLOBs;
import com.jcl.service.RiskSettingService;


@Service
public class RiskSettingServiceImpl implements RiskSettingService {

	@Autowired
	private RiskSettingMapper riskSettingMapper;
	@Autowired
	private PremiumCycleMapper premiumCycleMapper;
	
	@Override
	public List<RiskSettingWithBLOBs> getRiskSettingList() {
		RiskSettingExample example = new RiskSettingExample();
		example.setOrderByClause("rid asc");
//		Criteria criteria = example.createCriteria();
		return riskSettingMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public List<PremiumCycle> getPremiumCycle() {
		return premiumCycleMapper.selectByExample(null);
	}
	
}
