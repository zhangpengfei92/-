/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : RightsRoleService.java
 * 功能概要  : 权限角色管理服务类
 * 做成日期  : 2017年12月15日 
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;

import com.jcl.pojo.RightsRole;

/**
 * 权限角色管理服务类
 * 
 * @author jzq
 * @version 1.0
 */
public interface RightsRoleService {

	void insert(RightsRole rightsRole);
	
	int insertSelective(RightsRole rightsRole);

	void insertRightsRolePer(Integer rightsRoleId, String[] perid);

	List<RightsRole> getListByLikeName(String name);

	int deleteByPrimaryKey(Integer id);

	RightsRole selectByPrimaryKey(Integer id);

	List<RightsRole> selectById(Integer id);

	void update(RightsRole rightsRole);

	List<RightsRole> isExist(String rightsRolename);
}
