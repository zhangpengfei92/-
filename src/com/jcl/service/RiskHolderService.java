/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : RiskHolderService.java
 * 功能概要  : 持仓比例控制信息管理接口类
 * 做成日期  : 2018年04月19日 
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;

import com.jcl.pojo.RiskHolder;
import com.jcl.pojo.RiskHolderExample;

/**
 * 持仓比例控制信息管理接口类
 * 
 * @author jiangzq
 * @version 1.0
 */
public interface RiskHolderService {

	/**
	 * 查询所有持仓比例控制信息
	 * @return list
	 * @throws Exception
	 */
	List<RiskHolder> selectAll();

	/**
	 * 根据条件获取持仓比例控制列表集合
	 * @param RiskHolderExample
	 * @return list
	 * @throws Exception
	 */
	List<RiskHolder> selectByExample(RiskHolderExample example);
	
	/**
	 * 根据主键查询提现信息实体
	 * @param id 主键
	 * @return RiskHolder
	 * @throws Exception
	 */
	RiskHolder selectByPrimaryKey(Integer id);

	/**
	 * 删除持仓比例控制信息实体
	 * @param FundPzlog  持仓比例控制信息实体
	 * @return boolean true 成功/false 失败
	 * @throws Exception
	 */
	int deleteByPrimaryKey(Integer id);
	
	/**
	 * 更新持仓比例控制信息实体
	 * @param record 持仓比例控制信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKey(RiskHolder record);

	/**
	 * 更新持仓比例控制信息实体
	 * @param 持仓比例控制信息
	 * @return int
	 * @throws Exception
	 */
	int updateByid(String email, String phone, Integer id);
	
	/**
	 * 保存持仓比例控制信息实体
	 * @param FundPzlog  持仓比例控制信息实体
	 * @return int
	 * @throws Exception
	 */
	int insertSelective(RiskHolder record) throws Exception;
	
	/**
	 * 判断持仓比例控制信息是否存在
	 * @param typeId  持仓比例控制信息id
	 * 		  name 用户名
	 * @return boolean true 存在/false 不存在
	 * @throws Exception
	 */
	List<RiskHolder> isExist(String username);

}