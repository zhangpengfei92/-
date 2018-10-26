/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : CodefeesetMenuService.java
 * 功能概要  : 收费方案信息管理接口类
 * 做成日期  : 2018年04月26日 
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;

import com.jcl.pojo.CodefeesetMenu;
import com.jcl.pojo.CodefeesetMenuExample;

/**
 * 收费方案信息管理接口类
 * 
 * @author jiangzq
 * @version 1.0
 */
public interface CodefeesetMenuService {

	/**
	 * 查询所有收费方案信息
	 * @return list
	 * @throws Exception
	 */
	List<CodefeesetMenu> selectAll();

	/**
	 * 根据条件获取收费方案列表集合
	 * @param CodefeesetMenuExample
	 * @return list
	 * @throws Exception
	 */
	List<CodefeesetMenu> selectByExample(CodefeesetMenuExample example);
	
	/**
	 * 根据主键查询提现信息实体
	 * @param id 主键
	 * @return CodefeesetMenu
	 * @throws Exception
	 */
	CodefeesetMenu selectByPrimaryKey(Integer id);

	/**
	 * 删除收费方案信息实体
	 * @param FundPzlog  收费方案信息实体
	 * @return boolean true 成功/false 失败
	 * @throws Exception
	 */
	int deleteByPrimaryKey(Integer id);
	
	/**
	 * 更新用户权限
	 * @param record 收费方案信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKeyAndRole(CodefeesetMenu record);

	/**
	 * 更新收费方案信息实体
	 * @param record 收费方案信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKey(CodefeesetMenu record);

	/**
	 * 更新收费方案信息实体
	 * @param 收费方案信息
	 * @return int
	 * @throws Exception
	 */
	int updateByid(String email, String phone, Integer id);
	
	/**
	 * 保存收费方案信息实体
	 * @param FundPzlog  收费方案信息实体
	 * @return int
	 * @throws Exception
	 */
	int insertSelective(CodefeesetMenu record) throws Exception;
	
	/**
	 * 判断收费方案信息是否存在
	 * @param typeId  收费方案信息id
	 * 		  name 用户名
	 * @return boolean true 存在/false 不存在
	 * @throws Exception
	 */
	List<CodefeesetMenu> isExist(String username, Integer id);

	List<CodefeesetMenu> selectAllByOrderBy();

}