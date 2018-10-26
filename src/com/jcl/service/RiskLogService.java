/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : RiskLogService.java
 * 功能概要  : 预警平仓信息管理接口类
 * 做成日期  : 2018年05月08日 
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;

import com.jcl.pojo.RightsRole;
import com.jcl.pojo.RiskLog;
import com.jcl.pojo.RiskLogExample;

/**
 * 预警平仓信息管理接口类
 * 
 * @author jiangzq
 * @version 1.0
 */
public interface RiskLogService {

	/**
	 * 查询所有预警平仓信息
	 * @return list
	 * @throws Exception
	 */
	List<RiskLog> selectAll();

	/**
	 * 根据条件获取预警平仓列表集合
	 * @param RiskLogExample
	 * @return list
	 * @throws Exception
	 */
	List<RiskLog> selectByExample(RiskLogExample example);
	
	/**
	 * 根据主键查询提现信息实体
	 * @param id 主键
	 * @return RiskLog
	 * @throws Exception
	 */
	RiskLog selectByPrimaryKey(Integer id);

	/**
	 * 删除预警平仓信息实体
	 * @param FundPzlog  预警平仓信息实体
	 * @return boolean true 成功/false 失败
	 * @throws Exception
	 */
	int deleteByPrimaryKey(Integer id);
	
	/**
	 * 更新用户权限
	 * @param record 预警平仓信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKeyAndRole(RiskLog record, List<RightsRole> roleList);

	/**
	 * 更新预警平仓信息实体
	 * @param record 预警平仓信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKey(RiskLog record);

	/**
	 * 更新预警平仓信息实体
	 * @param 预警平仓信息
	 * @return int
	 * @throws Exception
	 */
	int updateByid(String email, String phone, Integer id);
	
	/**
	 * 保存预警平仓信息实体
	 * @param FundPzlog  预警平仓信息实体
	 * @return int
	 * @throws Exception
	 */
	int insertSelective(RiskLog record, List<RightsRole> roleList) throws Exception;
	
	/**
	 * 判断预警平仓信息是否存在
	 * @param typeId  预警平仓信息id
	 * 		  name 用户名
	 * @return boolean true 存在/false 不存在
	 * @throws Exception
	 */
	List<RiskLog> isExist(String username);

}