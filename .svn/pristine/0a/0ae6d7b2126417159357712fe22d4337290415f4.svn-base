/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : CodefeesetService.java
 * 功能概要  : 收费信息管理接口类
 * 做成日期  : 2018年04月26日 
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;

import com.jcl.pojo.Codefeeset;
import com.jcl.pojo.CodefeesetExample;

/**
 * 收费信息管理接口类
 * 
 * @author jiangzq
 * @version 1.0
 */
public interface CodefeesetService {

	/**
	 * 查询所有收费信息
	 * @return list
	 * @throws Exception
	 */
	List<Codefeeset> selectAll();

	/**
	 * 根据条件获取收费列表集合
	 * @param CodefeesetExample
	 * @return list
	 * @throws Exception
	 */
	List<Codefeeset> selectByExample(CodefeesetExample example);
	
	/**
	 * 根据主键查询提现信息实体
	 * @param id 主键
	 * @return Codefeeset
	 * @throws Exception
	 */
	Codefeeset selectByPrimaryKey(Integer id);

	/**
	 * 删除收费信息实体
	 * @param FundPzlog  收费信息实体
	 * @return boolean true 成功/false 失败
	 * @throws Exception
	 */
	int deleteByPrimaryKey(Integer id);
	
	/**
	 * 更新用户权限
	 * @param record 收费信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKeyAndRole(Codefeeset record);

	/**
	 * 更新收费信息实体
	 * @param record 收费信息实体
	 * @return int
	 * @throws Exception
	 */
	int updateByPrimaryKey(Codefeeset record);

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
	int insertSelective(Codefeeset record) throws Exception;
	
	/**
	 * 判断收费信息是否存在
	 * @param typeId  收费信息id
	 * 		  name 用户名
	 * @return boolean true 存在/false 不存在
	 * @throws Exception
	 */
	List<Codefeeset> isExist(String username, Integer id, Integer parentId);

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-14
	 * @decribe
	 * @param id
	 */
	int deleteByMenu(Integer parentid);

}