package com.jcl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jcl.dao.FundOrderMapper;
import com.jcl.dao.SubzhFundLogMapper;
import com.jcl.pojo.FundOrder;
import com.jcl.pojo.FundOrderExample;
import com.jcl.pojo.FundOrderExample.Criteria;
import com.jcl.pojo.FundOrderExample.Criterion;
import com.jcl.pojo.SubzhFundLog;
import com.jcl.pojo.SubzhFundLogExample;
import com.jcl.service.SubzhFundLogService;
import com.jcl.util.DateUtil;
import com.jcl.util.StringUtil;

@Service
@Transactional(rollbackFor=Exception.class)  
public class SubzhFundLogServiceImpl implements SubzhFundLogService{
	@Autowired
	private SubzhFundLogMapper SubzhFundLogMapper;
	
	@Autowired
	private FundOrderMapper fundOrderMapper;

	@Override
	public int saveFundOrder(FundOrder fo) {
		return fundOrderMapper.insertSelective(fo);
	}

	@Override
	public int save(SubzhFundLog subzhFundLog,FundOrder fo) {
		try {
			int i = fundOrderMapper.insertSelective(fo);
			int j = SubzhFundLogMapper.insertSelective(subzhFundLog);
			if(i > 0 && j > 0){
				return 1;
			}else{
				return 0;
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	@Override
	public List<FundOrder> getFundInfoList(FundOrder fo) {
		FundOrderExample foe = new FundOrderExample();
		foe.setOrderByClause("orderid desc");
		Criteria criteria = foe.createCriteria();
		criteria.andSubzhEqualTo(fo.getSubzh());
		if(fo.getZjUse() != null && fo.getZjUse() != ""){
			criteria.andZjUseEqualTo(fo.getZjUse());
		}
		if(fo.getPaymentzh() != null && fo.getPaymentzh() != ""){
			criteria.andPaymentzhEqualTo(fo.getPaymentzh());
		}
		return fundOrderMapper.selectByExample(foe);
	}

	@Override
	public int saveSubzhFundLog(SubzhFundLog subzhFundLog) {
		try {

			int j = SubzhFundLogMapper.insertSelective(subzhFundLog);
			if(j > 0){
				return 1;
			}else{
				return 0;
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	@Override
	public List<SubzhFundLog> selectByOrder(String order_no) {
		List<SubzhFundLog> sflist=new ArrayList<>();
		try {
			SubzhFundLogExample example=new SubzhFundLogExample();
			com.jcl.pojo.SubzhFundLogExample.Criteria createCriteria = example.createCriteria();
			if(!StringUtil.isAllNullOrEmpty(order_no)) {
				createCriteria.andBankflownumEqualTo(order_no);
			}
			sflist = SubzhFundLogMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sflist;
	}

	@Override
	public int updateFundlog(SubzhFundLog sfl) {
		try {

			int j = SubzhFundLogMapper.updateByPrimaryKeySelective(sfl);
			if(j > 0){
				return 1;
			}else{
				return 0;
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	@Override
	public List<SubzhFundLog> selectBySubzh(String subzh) {
		List<SubzhFundLog> slist=new ArrayList<>();
		try {
			SubzhFundLogExample example=new SubzhFundLogExample();
			com.jcl.pojo.SubzhFundLogExample.Criteria createCriteria = example.createCriteria();
			createCriteria.andSubzhEqualTo(subzh);
			createCriteria.andTypeEqualTo("7");
			createCriteria.andStatusEqualTo(new Byte("1"));
			createCriteria.andModifytimeBetween(DateUtil.getToday00(), DateUtil.getToday23());
			slist= SubzhFundLogMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return slist;
	}

	@Override
	public List<FundOrder> selectfundorderBysubzhor(String subzh) {
		List<FundOrder> flist=new ArrayList<>();
		try {
			FundOrderExample example=new FundOrderExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andSubzhEqualTo(subzh);
			createCriteria.andZjUseEqualTo("2");
			List<String>list= new ArrayList<>();
			list.add("0");
			list.add("3");
			createCriteria.andStatusIn(list);
			createCriteria.andCreateTimeBetween(DateUtil.getToday00(), DateUtil.getToday23());
			flist=fundOrderMapper.selectByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flist;
	}
}
