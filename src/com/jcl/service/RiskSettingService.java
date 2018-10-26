package com.jcl.service;

import java.util.List;

import com.jcl.pojo.PremiumCycle;
import com.jcl.pojo.RiskSettingWithBLOBs;

public interface RiskSettingService {
	
	List<RiskSettingWithBLOBs> getRiskSettingList();
	
	List<PremiumCycle> getPremiumCycle();
}
