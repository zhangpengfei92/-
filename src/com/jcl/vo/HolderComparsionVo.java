/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @HolderComparsionVo.java
 * 功能概要  : 
 * 做成日期  : @2018年5月11日
 * 修改日期  :
 */
package com.jcl.vo;

import com.jcl.pojo.HoldComparison;

/** 
 * @author zpf
 * @version 1.0
 */

//持仓对比的扩展类
public class HolderComparsionVo extends HoldComparison{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer mzh;//净持仓
	
	private Integer holdMany;//持多
	
	private Integer holdnull;//持空

	public Integer getMzh() {
		return mzh;
	}
	
	//计算净持仓
	public void setMzh(Integer holdMany,Integer holdnull) {
		this.mzh = holdMany-holdnull;
	}

	public Integer getHoldMany() {
		return holdMany;
	}

	public void setHoldMany(Integer holdMany) {
		this.holdMany = holdMany;
	}

	public Integer getHoldnull() {
		return holdnull;
	}

	public void setHoldnull(Integer holdnull) {
		this.holdnull = holdnull;
	}

	
	
}
