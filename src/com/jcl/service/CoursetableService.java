package com.jcl.service;

import java.util.List;

import com.jcl.comm.WhResult;
import com.jcl.pojo.Coursetable;

public interface CoursetableService {

	WhResult save(Coursetable coursetable);

	List<Coursetable> getcourseListByDate(String date);

	List<Coursetable> getDateList();
	
	int deleteByDate(String date);
	
	int deleteByPrimaryKey(Integer id);
	
	 //查询不重复的日期数量
    int selectCountByDate();
	
	int updateByPrimaryKey(Coursetable record);
	
	Coursetable selectByPrimaryKey(Integer id);

}
