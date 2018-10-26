/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : 
 * 功能概要  : 
 * 做成日期  : 
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;

import com.jcl.pojo.Bdzh;
import com.jcl.pojo.BdzhExample;

/** 
 * @author zpf
 * @version 1.0
 * 
 * 报单账户查询接口 
 */
public interface BdzhService {
	
	/*
	 * 全查询bdzh(报单账户表)
	 */
	List<Bdzh> queryAll();
	
	/*
	 * 根据条件查询查询bdzh(报单账户表)
	 */
	List<Bdzh> queryBy(Bdzh bdzh);

	int addBdzh(Bdzh bdzh);

	void deleteBdzh(String accountid);
	
	Bdzh selectByPrimaryKey(Integer bdzhid);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-1
	 * @decribe
	 * @param bdzh
	 */
	int updateBdzh(Bdzh bdzh);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-14
	 * @decribe
	 * @param bdzh
	 */
	boolean isexist(Bdzh bdzh);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-15
	 * @decribe
	 * @param example
	 * @return
	 */
	List<Bdzh> selectLikeAccount(BdzhExample example);
}
