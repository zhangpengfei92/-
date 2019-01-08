/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : RiskTempallService.java
 * 功能概要  : 风控方案信息管理接口类
 * 做成日期  : 2018年04月19日 
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;

import com.jcl.pojo.RiskTempall;
import com.jcl.pojo.RiskTempallExample;

/**
 * 风控方案信息管理接口类
 * 
 * @author jiangzq
 * @version 1.0
 */
public interface RiskTempallService {

	/**
	 * 查询所有风控方案信息
	 * @return list
	 * @throws Exception
	 */
	List<RiskTempall> selectAll();

	/**
	 * 根据条件获取风控方案列表集合
	 * @param RiskTempallExample
	 * @return list
	 * @throws Exception
	 */
	List<RiskTempall> selectByExample(RiskTempallExample example);
	
	/**
	 * 根据主键查询提现信息实体
	 * @param id 主键
	 * @return RiskTempall
	 * @throws Exception
	 */
	RiskTempall selectByPrimaryKey(Integer id);

	/**
	 * 删除风控方案信息实体
	 * @param FundPzlog  风控方案信息实体
	 * @return boolean true 成功/false 失败
	 * @throws Exception
	 */
	int deleteByPrimaryKey(Integer id);
	
	/**
	 * 更新风控方案信息实体
	 * @param record 风控方案信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKey(RiskTempall record);

	/**
	 * 更新风控方案信息实体
	 * @param 风控方案信息
	 * @return int
	 * @throws Exception
	 */
	int updateByid(String email, String phone, Integer id);
	
	/**
	 * 保存风控方案信息实体
	 * @param FundPzlog  风控方案信息实体
	 * @return int
	 * @throws Exception
	 */
	int insertSelective(RiskTempall record) throws Exception;
	
	/**
	 * 判断风控方案信息是否存在
	 * @param typeId  风控方案信息id
	 * 		  name 用户名
	 * @return boolean true 存在/false 不存在
	 * @throws Exception
	 */
	List<RiskTempall> isExist(String username, Integer id);

}