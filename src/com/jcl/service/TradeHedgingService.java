/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : TradeHedgingService.java
 * 功能概要  : 提现记录信息管理接口类
 * 做成日期  : 2018年04月08日 
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;

import com.jcl.pojo.TradeHedging;
import com.jcl.pojo.TradeHedgingExample;

/**
 * 提现记录信息管理接口类
 * 
 * @author jiangzq
 * @version 1.0
 */
public interface TradeHedgingService {

	/**
	 * 查询所有提现记录信息
	 * @return list
	 * @throws Exception
	 */
	List<TradeHedging> selectAll();

	/**
	 * 根据条件获取提现记录列表集合
	 * @param TradeHedgingExample
	 * @return list
	 * @throws Exception
	 */
	List<TradeHedging> selectByExample(TradeHedgingExample example);
	
	/**
	 * 根据主键查询提现信息实体
	 * @param id 主键
	 * @return TradeHedging
	 * @throws Exception
	 */
	TradeHedging selectByPrimaryKey(Integer id);

	/**
	 * 删除提现记录信息实体
	 * @param FundPzlog  提现记录信息实体
	 * @return boolean true 成功/false 失败
	 * @throws Exception
	 */
	int deleteByPrimaryKey(Integer id);
	
	/**
	 * 更新用户权限
	 * @param record 提现记录信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKeyAndRole(TradeHedging record);

	/**
	 * 更新提现记录信息实体
	 * @param record 提现记录信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKey(TradeHedging record);

	/**
	 * 更新提现记录信息实体
	 * @param 提现记录信息
	 * @return int
	 * @throws Exception
	 */
	int updateByid(String email, String phone, Integer id);
	
	/**
	 * 保存提现记录信息实体
	 * @param FundPzlog  提现记录信息实体
	 * @return int
	 * @throws Exception
	 */
	int insertSelective(TradeHedging record) throws Exception;
	
	/**
	 * 判断提现记录信息是否存在
	 * @param typeId  提现记录信息id
	 * 		  name 用户名
	 * @return boolean true 存在/false 不存在
	 * @throws Exception
	 */
	List<TradeHedging> isExist(String username);

}