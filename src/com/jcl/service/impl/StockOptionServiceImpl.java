package com.jcl.service.impl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.jcl.dao.StockEnquiryMapper;
import com.jcl.dao.SubzhFundLogMapper;
import com.jcl.dao.SubzhMapper;
import com.jcl.pojo.StockEnquiry;
import com.jcl.pojo.StockEnquiryExample;
import com.jcl.pojo.StockEnquiryExample.Criteria;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhExample;
import com.jcl.pojo.SubzhFundLog;
import com.jcl.service.StockOptionService;
import com.jcl.util.DateUtil;


@Service
@Transactional(rollbackFor=Exception.class)  
public class StockOptionServiceImpl implements StockOptionService {
	
	@Autowired
	private StockEnquiryMapper stockEnquiryMapper;
	
	@Autowired
	private SubzhMapper subzhMapper;
	
	@Autowired
	private SubzhFundLogMapper subzhFundLogMapper;

	@Override
	public int saveStockEnquiry(StockEnquiry so) {
		StockEnquiryExample example = new StockEnquiryExample();
		Criteria criteria = example.createCriteria();
		criteria.andSubzhEqualTo(so.getSubzh());
		criteria.andStockcodeEqualTo(so.getStockcode());
		List<Integer> intg = new ArrayList<Integer>();
		intg.add(0);
		intg.add(1);
		criteria.andStatusIn(intg);
		List<StockEnquiry> list = stockEnquiryMapper.selectByExample(example);
		if(list != null && list.size() > 0){
			so.setId(list.get(0).getId());
			return stockEnquiryMapper.updateByPrimaryKeySelective(so);
		}else{
			return stockEnquiryMapper.insertSelective(so);
		}
		
	}

	@Override
	public List<StockEnquiry> getStockEnquiryList(Map<String, Object> map) {
//		List<Integer> intg = new ArrayList<Integer>();
//		intg.add(3);
//		intg.add(2);
//		intg.add(1);
		StockEnquiryExample example = new StockEnquiryExample();
		example.setOrderByClause("createtime desc");
		Criteria criteria = example.createCriteria();
		if(map.get("stockcode") !=null){
			criteria.andStockcodeEqualTo((String)map.get("stockcode"));
		}
//		criteria.andStatusIn(intg);
		if(map.get("subzh") !=null){
			criteria.andSubzhEqualTo((String)map.get("subzh"));
		}
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(map.get("id") !=null){
			criteria.andIdEqualTo(Integer.parseInt(map.get("id").toString()));
		}
		if(map.get("createtimeStart") !=null && map.get("createtimeEnd") !=null){
			try {
				criteria.andCreatetimeBetween(sdf.parse((String)map.get("createtimeStart")), sdf.parse((String)map.get("createtimeEnd")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return stockEnquiryMapper.selectByExample(example);
	}

	@Override
	public List<StockEnquiry> getStockEnquiryListBycontionMap(Map<String, Object> contionMap) {
		List<Integer> intg = new ArrayList<Integer>();
		StockEnquiryExample example = new StockEnquiryExample();
		example.setOrderByClause("id desc");
		Criteria criteria = example.createCriteria();
		Date startDate=null;
		Date endDate=null;
		startDate=contionMap.get("start") !=null?
						DateUtil.stringToDate((String)contionMap.get("start")+" 00:00:00", "yyyy-MM-dd HH:mm:ss"):
						DateUtil.stringToDate("2000-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
		/*if(contionMap.get("start") !=null){
			startDate=DateUtil.stringToDate((String)contionMap.get("start")+" 00:00:00", "yyyy-MM-dd HH:mm:ss");
		}else{
			startDate=DateUtil.stringToDate("2000-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
		}*/
		if(contionMap.get("end") !=null){
			endDate=DateUtil.stringToDate((String)contionMap.get("end")+" 23:59:59", "yyyy-MM-dd HH:mm:ss");
		}else{
			endDate=new Date();
		}
		if(contionMap.get("subzh") !=null){
			criteria.andSubzhEqualTo((String)contionMap.get("subzh"));
		}
		if(contionMap.get("status") !=null ){
			if(contionMap.get("status").toString().length()==1){
				criteria.andStatusEqualTo((Integer)contionMap.get("status"));
			}else{
				String[] split = contionMap.get("status").toString().split(",");
				for (int i = 0; i < split.length; i++) {
					intg.add(Integer.parseInt(split[i]));
				}
				criteria.andStatusIn(intg);
				//结算支持时间查询
				if("4".equals(split[0])){
					criteria.andBuytimeBetween(startDate, endDate);
				}
			}
		}
		if(contionMap.get("stockCode") !=null){
			criteria.andStockcodeEqualTo((String)contionMap.get("stockCode"));
		}
		return stockEnquiryMapper.selectByExample(example);
	}

	@Override
	public StockEnquiry getStockEnquiryById(Integer id) {
		return stockEnquiryMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updatedStockEnquiry(StockEnquiry stockEnquiry,SubzhFundLog sfl) {
		/*SubzhExample example = new SubzhExample();
		com.jcl.pojo.SubzhExample.Criteria criteria = example.createCriteria();
		criteria.andPhoneEqualTo(userInfo.getPhone());
		criteria.andSubzhEqualTo(userInfo.getSubzh());
		int i = subzhMapper.updateByExample(userInfo, example);*/
		int j=stockEnquiryMapper.updateByPrimaryKeySelective(stockEnquiry);
		if(j > 0){
			return 1;
		}else{
			return 0;
		}
	}

	@Override
	public int updateTransStatus(StockEnquiry se,Subzh sz) {
		try {
			int i = 0;
			if(se.getId() == null || se.getId() == 0){
				i = stockEnquiryMapper.insertSelective(se);
			}else{
				i = stockEnquiryMapper.updateByPrimaryKeySelective(se);
			}
			
			int j = subzhMapper.updateByPrimaryKeySelective(sz);
			if(i > 0 && j > 0){
				return 1;
			}else{
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
				return 0;
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return 0;
		}
	}

	@Override
	public int updateStockEnquiryByRecord(StockEnquiry se) {
		return stockEnquiryMapper.updateByPrimaryKeySelective(se);
	}
	
}
