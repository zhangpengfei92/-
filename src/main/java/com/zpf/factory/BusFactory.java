/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @BusFactory.java
 * 功能概要  : 
 * 做成日期  : @2019年2月18日
 * 修改日期  :
 */
package com.zpf.factory;
/** 
 * @author zpf
 * @version 1.0
 */
public class BusFactory implements CarFactory {

	@Override
	public Car getCar() {
		
		return new Bus();
	}

}
