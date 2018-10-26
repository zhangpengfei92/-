package com.jcl.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.PremiumCycleMapper;
import com.jcl.dao.PremiumPrincipalMapper;
import com.jcl.dao.StockPrincipalMapper;
import com.jcl.pojo.PremiumCycle;
import com.jcl.pojo.PremiumCycleExample;
import com.jcl.pojo.PremiumPrincipal;
import com.jcl.pojo.PremiumPrincipalExample;
import com.jcl.pojo.StockPrincipal;
import com.jcl.pojo.StockPrincipalExample;
import com.jcl.pojo.StockPrincipalExample.Criteria;
import com.jcl.service.StockPrincipalService;



@Service
public class StockPrincipalServiceImpl implements StockPrincipalService {
	
	@Autowired
	private StockPrincipalMapper stockPrincipalMapper;
	@Autowired
	private PremiumCycleMapper premiumCycleMapper;
	@Autowired
	private PremiumPrincipalMapper premiumPrincipalMapper;

	@Override
	public List<StockPrincipal> getStockPrincipalList(Map<String, Object> map) {
		StockPrincipalExample example = new StockPrincipalExample();
		Criteria criteria = example.createCriteria();
		criteria.andStockcodeEqualTo((String)map.get("stockcode"));
		if(map.get("queryCycleType") != null && map.get("queryCycleType") != ""){
			criteria.andEnquirytypeEqualTo((String)map.get("queryCycleType"));
		}
		if(map.get("queryCycle") != null && map.get("queryCycle") != ""){
			criteria.andEnquirytimeEqualTo(Integer.parseInt((String)map.get("queryCycle")));
		}
		return stockPrincipalMapper.selectByExample(example);
	}

	@Override
	public List<PremiumCycle> getPremiumCycleList(Map<String, Object> map) {
		PremiumCycleExample example = new PremiumCycleExample();
		com.jcl.pojo.PremiumCycleExample.Criteria criteria = example.createCriteria();
		criteria.andCycleEqualTo((String)map.get("queryCycle"));
		criteria.andTypeEqualTo((String)map.get("queryCycleType"));
		return premiumCycleMapper.selectByExample(example);
	}

	@Override
	public List<PremiumPrincipal> getPremiumPrincipalList(Map<String, Object> map) {
		return premiumPrincipalMapper.selectByExample(null);
	}
	
}
