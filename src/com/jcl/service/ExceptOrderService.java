/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : ExceptOrderService.java
 * 功能概要  : 异常订单管理接口类
 * 做成日期  : 2018年04月18日 
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;

import com.jcl.pojo.RightsRole;
import com.jcl.pojo.ExceptOrder;
import com.jcl.pojo.ExceptOrderExample;

/**
 * 异常订单管理接口类
 * 
 * @author jiangzq
 * @version 1.0
 */
public interface ExceptOrderService {

	/**
	 * 查询所有异常订单
	 * @return list
	 * @throws Exception
	 */
	List<ExceptOrder> selectAll();

	/**
	 * 根据条件获取资金流水列表集合
	 * @param ExceptOrderExample
	 * @return list
	 * @throws Exception
	 */
	List<ExceptOrder> selectByExample(ExceptOrderExample example);
	
	/**
	 * 更新异常订单实体
	 * @param 异常订单
	 * @return int
	 * @throws Exception
	 */
	int updateByid(String email, String phone, Integer id);
	
	/**
	 * 保存异常订单实体
	 * @param ExceptOrder  异常订单实体
	 * @return int
	 * @throws Exception
	 */
	int insertSelective(ExceptOrder record, List<RightsRole> roleList) throws Exception;
	
	/**
	 * 判断异常订单是否存在
	 * @param typeId  异常订单id
	 * 		  name 用户名
	 * @return boolean true 存在/false 不存在
	 * @throws Exception
	 */
	List<ExceptOrder> isExist(String username);

}