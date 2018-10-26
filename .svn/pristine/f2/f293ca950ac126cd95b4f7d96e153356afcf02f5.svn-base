/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @ContractService.java
 * 功能概要  : 
 * 做成日期  : @2018年5月8日
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;

import com.jcl.pojo.Contract;
import com.jcl.pojo.RiskContract;

/** 
 * @author zpf
 * @version 1.0
 */
public interface RiskContractService {

	//查询所有的合约
	List<RiskContract> queryContractAll(RiskContract contract);

	RiskContract queryByID(String cid);

	int updatebyCid(RiskContract con);

	int addriskcontract(RiskContract con);

	List<RiskContract> queryByTime(String keywords);

	int deleteAllBycode(String cids);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-2
	 * @decribe 当第一次查询合约时，从行情中查到合约，需要保存到数据库中
	 * @param clist
	 * @return
	 */
	int insertBatchContract(List<RiskContract> clist);

}
