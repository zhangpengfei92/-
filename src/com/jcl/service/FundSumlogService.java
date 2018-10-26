/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : FundSumlogService.java
 * 功能概要  : 资金销售统计信息管理接口类
 * 做成日期  : 2018年04月24日 
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;

import com.jcl.pojo.RightsRole;
import com.jcl.pojo.FundSumlog;
import com.jcl.pojo.FundSumlogExample;

/**
 * 资金销售统计信息管理接口类
 * 
 * @author jiangzq
 * @version 1.0
 */
public interface FundSumlogService {

	/**
	 * 查询所有资金销售统计信息
	 * @return list
	 * @throws Exception
	 */
	List<FundSumlog> selectAll();

	/**
	 * 根据条件获取资金销售统计列表集合
	 * @param FundSumlogExample
	 * @return list
	 * @throws Exception
	 */
	List<FundSumlog> selectByExample(FundSumlogExample example);
	
	/**
	 * 根据主键查询提现信息实体
	 * @param id 主键
	 * @return FundSumlog
	 * @throws Exception
	 */
	FundSumlog selectByPrimaryKey(Integer id);

	/**
	 * 删除资金销售统计信息实体
	 * @param FundSumlog  资金销售统计信息实体
	 * @return boolean true 成功/false 失败
	 * @throws Exception
	 */
	int deleteByPrimaryKey(Integer id);
	
	/**
	 * 更新用户权限
	 * @param record 资金销售统计信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKeyAndRole(FundSumlog record, List<RightsRole> roleList);

	/**
	 * 更新资金销售统计信息实体
	 * @param record 资金销售统计信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKey(FundSumlog record);

	/**
	 * 更新资金销售统计信息实体
	 * @param 资金销售统计信息
	 * @return int
	 * @throws Exception
	 */
	int updateByid(String email, String phone, Integer id);
	
	/**
	 * 保存资金销售统计信息实体
	 * @param FundSumlog  资金销售统计信息实体
	 * @return int
	 * @throws Exception
	 */
	int insertSelective(FundSumlog record) throws Exception;
	
	/**
	 * 判断资金销售统计信息是否存在
	 * @param typeId  资金销售统计信息id
	 * 		  name 用户名
	 * @return boolean true 存在/false 不存在
	 * @throws Exception
	 */
	List<FundSumlog> isExist(String username);

}