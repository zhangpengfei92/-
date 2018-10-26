/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @OperateSchemeService.java
 * 功能概要  : 
 * 做成日期  : @2018年4月18日
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jcl.pojo.OperateScheme;

/** 
 * @author zpf
 * @version 1.0
 */

public interface OperateSchemeService {

   	List<OperateScheme> selectAll();

	OperateScheme selectByID(Integer id);

	int addOperateScheme(OperateScheme operateScheme);

	int updateOperateScheme(OperateScheme operateScheme);

	int deleteo(Integer osid);

	List<OperateScheme> selectByName(String str); 
}
