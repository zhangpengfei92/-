package com.jcl.service;

import java.util.List;
import java.util.Map;

import com.jcl.pojo.StockEnquiry;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhFundLog;

public interface StockOptionService {
	int saveStockEnquiry(StockEnquiry se);
	
	List<StockEnquiry> getStockEnquiryList(Map<String,Object> map);

	List<StockEnquiry> getStockEnquiryListBycontionMap(Map<String, Object> contionMap);

	StockEnquiry getStockEnquiryById(Integer id);

	int updatedStockEnquiry(StockEnquiry stockEnquiry,  SubzhFundLog sfl);
	
	int updateTransStatus(StockEnquiry se,Subzh sz);
	
	int updateStockEnquiryByRecord(StockEnquiry se);
}
