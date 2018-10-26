/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : RightsColumnService.java
 * 功能概要  : 权限子栏目管理服务类
 * 做成日期  : 2017年12月12日 
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;
import java.util.Map;

import com.jcl.pojo.RightsColumn;

/**
 * 权限子栏目管理服务类
 * 
 * @author jzq
 * @version 1.0
 */
public interface RightsColumnService {

	void insert(RightsColumn rightsColumn);
	
	int insertSelective(RightsColumn rightsColumn);

	RightsColumn selectByPrimaryKey(Integer id);

	void update(RightsColumn rightsColumn);

	List<RightsColumn> isExist(String rightsColumnname);
	
	/**
	 * 根据条件获取权限子栏目信息集合
	 * @param mapCondition
	 * @return list
	 * @throws Exception
	 */
	public List<RightsColumn> selectRightsColumnListByCondition(Map<String,Object> mapCondition) throws Exception;
	
}
