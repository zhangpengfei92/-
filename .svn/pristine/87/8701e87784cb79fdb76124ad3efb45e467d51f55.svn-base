package com.jcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.comm.WhResult;
import com.jcl.dao.CoursetableMapper;
import com.jcl.pojo.Coursetable;
import com.jcl.pojo.CoursetableExample;
import com.jcl.pojo.CoursetableExample.Criteria;
import com.jcl.service.CoursetableService;

@Service
public class CoursetableServiceImpl implements CoursetableService {
	/**
	 * 投教中心课程安排表
	 * 
	 */

	@Autowired
	private CoursetableMapper coursetableMapper;

	@Override
	public WhResult save(Coursetable coursetable) {
		int i = coursetableMapper.insertSelective(coursetable);
		// 有主键返回,说明插入成功!
		if (i > 0) {
			return WhResult.ok();
		}
		return null;
	}

	/**
	 * 根据日期查询出当天的课表
	 */
	@Override
	public List<Coursetable> getcourseListByDate(String date) {
		// 查询条件
		CoursetableExample example = new CoursetableExample();
		Criteria criteria = example.createCriteria();
		criteria.andDateEqualTo(date);
		List<Coursetable> list = coursetableMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<Coursetable> getDateList() {
		List<Coursetable> list = coursetableMapper.selectDate();
		return list;
	}

	@Override
	public int deleteByDate(String date) {

		return coursetableMapper.deleteByDate(date);
	}

	@Override
	public Coursetable selectByPrimaryKey(Integer id) {
		return coursetableMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		
		return coursetableMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Coursetable record) {
		return coursetableMapper.updateByPrimaryKey(record);
		
	}

	@Override
	public int selectCountByDate() {
		// TODO Auto-generated method stub
		return coursetableMapper.selectCountByDate();
	}
}
