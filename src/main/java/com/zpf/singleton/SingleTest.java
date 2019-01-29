/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @SingleTest.java
 * 功能概要  : 
 * 做成日期  : @2019年1月29日
 * 修改日期  :
 */
package com.zpf.singleton;
/** 
 * @author zpf
 * @version 1.0
 */

import org.junit.Test;

public class SingleTest {
	
	//测试单例模式饿汉式
	//@Test
	public void hungerTest() {
		HungerSingleton singleton1=HungerSingleton.getInstance();
		HungerSingleton singleton2=HungerSingleton.getInstance();
		System.out.println(" singleton1的地址 ："+singleton1+"\n singleton2的地址 ："+singleton2+
				"\n singleton1和singleton2的内存地址是否相同 : "+(singleton1==singleton2));
	}
	
	@Test
	public void lazyTest() throws InterruptedException {		
		  Runnable task = ()->{
	            String threadName = Thread.currentThread().getName();
	            LazySingleton singleton1=LazySingleton.getInstance();
	            System.out.println("线程 " + threadName + "\t => " + singleton1.hashCode());
	        };
	        // 模拟多线程环境下使用 Singleton 类获得对象
	        for(int i=0;i<1000;i++){
	            new Thread(task,"" + i).start();
	        }		
	}
}
