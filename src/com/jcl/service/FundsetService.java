/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @FundsetService.java
 * 功能概要  : 
 * 做成日期  : @2018年9月17日
 * 修改日期  :
 */
package com.jcl.service;

import com.jcl.pojo.Fundset;

/** 
 * @author zpf
 * @version 1.0
 */
public interface FundsetService {

	int savefundset(Fundset fundset);

	Fundset selectone();

	Fundset selectByTime(String dateTotimeString);

}
