/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : RiskStockService.java
 * 功能概要  : 风控名单信息管理接口类
 * 做成日期  : 2018年04月19日 
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;

import com.jcl.pojo.RiskStock;
import com.jcl.pojo.RiskStockExample;

/**
 * 风控名单信息管理接口类
 * 
 * @author jiangzq
 * @version 1.0
 */
public interface RiskStockService {

	/**
	 * 查询所有风控名单信息
	 * @return list
	 * @throws Exception
	 */
	List<RiskStock> selectAll();

	/**
	 * 根据条件获取风控名单列表集合
	 * @param RiskStockExample
	 * @return list
	 * @throws Exception
	 */
	List<RiskStock> selectByExample(RiskStockExample example);
	
	/**
	 * 根据主键查询提现信息实体
	 * @param id 主键
	 * @return RiskStock
	 * @throws Exception
	 */
	RiskStock selectByPrimaryKey(Integer id);

	/**
	 * 删除风控名单信息实体
	 * @param FundPzlog  风控名单信息实体
	 * @return boolean true 成功/false 失败
	 * @throws Exception
	 */
	int deleteByPrimaryKey(Integer id);
	
	/**
	 * 更新风控名单信息实体
	 * @param record 风控名单信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKey(RiskStock record);

	/**
	 * 更新风控名单信息实体
	 * @param 风控名单信息
	 * @return int
	 * @throws Exception
	 */
	int updateByid(String email, String phone, Integer id);
	
	/**
	 * 保存风控名单信息实体
	 * @param FundPzlog  风控名单信息实体
	 * @return int
	 * @throws Exception
	 */
	int insertSelective(RiskStock record) throws Exception;
	
	/**
	 * 判断风控名单信息是否存在
	 * @param typeId  风控名单信息id
	 * 		  name 用户名
	 * @return boolean true 存在/false 不存在
	 * @throws Exception
	 */
	List<RiskStock> isExist(Integer parentid, Integer type, String username);

}