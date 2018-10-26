package com.jcl.service;

import java.util.List;

import com.jcl.pojo.FundOrder;
import com.jcl.pojo.SubzhFundLog;

public interface SubzhFundLogService {

	int save(SubzhFundLog subzhFundLog,FundOrder fo);
	
	int saveFundOrder(FundOrder fo);
	
	List<FundOrder> getFundInfoList(FundOrder fo);
	
	int saveSubzhFundLog(SubzhFundLog subzhFundLog);

	List<SubzhFundLog> selectByOrder(String order_no);

	int updateFundlog(SubzhFundLog sfl);

	List<SubzhFundLog> selectBySubzh(String subzh);

	List<FundOrder> selectfundorderBysubzhor(String subzh);
	
}
