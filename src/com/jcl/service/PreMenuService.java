/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @PreMenuService.java
 * 功能概要  : 
 * 做成日期  : @2018年4月25日
 * 修改日期  :
 */
package com.jcl.service;

import java.util.List;
import java.util.Map;

import com.jcl.pojo.PreMenu;

/** 
 * @author zpf
 * @version 1.0
 */
public interface PreMenuService {

	Map<Integer, List<PreMenu>> queryAll(String parent);

}
