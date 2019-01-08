/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : BzjmbMenuService.java
 * 功能概要  : 保证金方案信息管理接口类
 * 做成日期  : 2018年04月19日 
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;

import com.jcl.pojo.BzjmbMenu;
import com.jcl.pojo.BzjmbMenuExample;

/**
 * 保证金方案信息管理接口类
 * 
 * @author jiangzq
 * @version 1.0
 */
public interface BzjmbMenuService {

	/**
	 * 查询所有保证金方案信息
	 * @return list
	 * @throws Exception
	 */
	List<BzjmbMenu> selectAll();

	/**
	 * 根据条件获取保证金方案列表集合
	 * @param BzjmbMenuExample
	 * @return list
	 * @throws Exception
	 */
	List<BzjmbMenu> selectByExample(BzjmbMenuExample example);
	
	/**
	 * 根据主键查询提现信息实体
	 * @param id 主键
	 * @return BzjmbMenu
	 * @throws Exception
	 */
	BzjmbMenu selectByPrimaryKey(Integer id);

	/**
	 * 删除保证金方案信息实体
	 * @param FundPzlog  保证金方案信息实体
	 * @return boolean true 成功/false 失败
	 * @throws Exception
	 */
	int deleteByPrimaryKey(Integer id);
	
	/**
	 * 更新用户权限
	 * @param record 保证金方案信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKeyAndRole(BzjmbMenu record);

	/**
	 * 更新保证金方案信息实体
	 * @param record 保证金方案信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKey(BzjmbMenu record);

	/**
	 * 更新保证金方案信息实体
	 * @param 保证金方案信息
	 * @return int
	 * @throws Exception
	 */
	int updateByid(String email, String phone, Integer id);
	
	/**
	 * 保存保证金方案信息实体
	 * @param FundPzlog  保证金方案信息实体
	 * @return int
	 * @throws Exception
	 */
	int insertSelective(BzjmbMenu record) throws Exception;
	
	/**
	 * 判断保证金方案信息是否存在
	 * @param typeId  保证金方案信息id
	 * 		  name 用户名
	 * @return boolean true 存在/false 不存在
	 * @throws Exception
	 */
	List<BzjmbMenu> isExist(String username, Integer id);

}