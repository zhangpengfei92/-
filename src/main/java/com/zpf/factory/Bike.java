/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @Bike.java
 * 功能概要  : 
 * 做成日期  : @2019年1月30日
 * 修改日期  :
 */
package com.zpf.factory;
/** 
 * @author zpf
 * @version 1.0
 */
public class Bike implements Car {

	@Override
	public void gotowork(){
		System.out.println("gotowork -- by Bike");
	}
}
