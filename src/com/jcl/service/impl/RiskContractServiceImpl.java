/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @ContractServiceImpl.java
 * 功能概要  : 
 * 做成日期  : @2018年5月8日
 * 修改日期  :
 */
package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.RiskContractMapper;
import com.jcl.pojo.RiskContract;
import com.jcl.pojo.RiskContractExample;
import com.jcl.pojo.RiskContractExample.Criteria;
import com.jcl.pojo.RiskContractExample.Criterion;
import com.jcl.service.RiskContractService;
import com.jcl.stock.simulate.StringUtil;

/** 
 * @author zpf
 * @version 1.0
 */
@Service
public class RiskContractServiceImpl implements RiskContractService{
	
	
	@Autowired
	private RiskContractMapper riskcontractMapper;
	
	//查询所有的合约
	@Override
	public List<RiskContract> queryContractAll(RiskContract contract) {
		if(contract!=null){
			RiskContractExample example=new RiskContractExample();
			Criteria cri=example.createCriteria();
			if(!StringUtil.isAnyNullOrEmpty(contract.getExchangeName())){
				cri.andExchangeNameEqualTo(contract.getExchangeName());
			}
			if(!StringUtil.isAnyNullOrEmpty(contract.getContractName())){
				//cri.andContractNameEqualTo(contract.getContractName());
				cri.andContractNameLike("%"+contract.getContractName()+"%");
			}
			return riskcontractMapper.selectByExample(example);
		}else{
			return riskcontractMapper.selectByExample(null);
		}
		
	}
	
	@Override
	public RiskContract queryByID(String cid) {
		return riskcontractMapper.selectByPrimaryKey(cid);
	}

	@Override
	public int updatebyCid(RiskContract con) {
		return	riskcontractMapper.updateByPrimaryKeySelective(con);
	}

	@Override
	public int addriskcontract(RiskContract con) {
		
		return	riskcontractMapper.insertSelective(con);
	}

	@Override
	public List<RiskContract> queryByTime(String keywords) {
	
		return riskcontractMapper.selectByTime(keywords);
	}

	@Override
	public int deleteAllBycode(String cids) {
		int num = 0;
		cids =cids.substring(0, cids.length()-1);	
		String arr []=cids.split(",");
		for (String i : arr) {
		num=riskcontractMapper.deleteByPrimaryKey(i);
		}
		return num;
	}
	
	public int insertBatchContract(List<RiskContract> clist){
		
		return riskcontractMapper.insertBatchContract(clist);
	}
	
}
