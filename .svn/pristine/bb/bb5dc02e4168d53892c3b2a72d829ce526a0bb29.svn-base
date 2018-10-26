/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : FeeSchemeService.java
 * 功能概要  : 收费信息管理接口类
 * 做成日期  : 2018年04月19日 
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;

import com.jcl.pojo.FeeScheme;
import com.jcl.pojo.FeeSchemeExample;

/**
 * 收费信息管理接口类
 * 
 * @author jiangzq
 * @version 1.0
 */
public interface FeeSchemeService {

	/**
	 * 查询所有收费信息
	 * @return list
	 * @throws Exception
	 */
	List<FeeScheme> selectAll();

	/**
	 * 根据条件获取收费列表集合
	 * @param FeeSchemeExample
	 * @return list
	 * @throws Exception
	 */
	List<FeeScheme> selectByExample(FeeSchemeExample example);
	
	/**
	 * 根据主键查询提现信息实体
	 * @param id 主键
	 * @return FeeScheme
	 * @throws Exception
	 */
	FeeScheme selectByPrimaryKey(Integer id);

	/**
	 * 删除收费信息实体
	 * @param FundPzlog  收费信息实体
	 * @return boolean true 成功/false 失败
	 * @throws Exception
	 */
	int deleteByPrimaryKey(Integer id);
	
	/**
	 * 更新收费信息实体
	 * @param record 收费信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKey(FeeScheme record);

	/**
	 * 更新收费信息实体
	 * @param 收费信息
	 * @return int
	 * @throws Exception
	 */
	int updateByid(String email, String phone, Integer id);
	
	/**
	 * 保存收费信息实体
	 * @param FundPzlog  收费信息实体
	 * @return int
	 * @throws Exception
	 */
	int insertSelective(FeeScheme record) throws Exception;
	
	/**
	 * 判断收费信息是否存在
	 * @param typeId  收费信息id
	 * 		  name 用户名
	 * @return boolean true 存在/false 不存在
	 * @throws Exception
	 */
	List<FeeScheme> isExist(String username);

}