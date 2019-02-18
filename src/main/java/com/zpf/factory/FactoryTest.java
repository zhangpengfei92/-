/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @FactoryTest.java
 * 功能概要  : 
 * 做成日期  : @2019年2月18日
 * 修改日期  :
 */
package com.zpf.factory;
/** 
 * @author zpf
 * @version 1.0
 */

import java.util.Scanner;


public class FactoryTest {
	
	public static void main(String[] args) {
		System.out.println("-------------欢迎进入上班工具生产系统-----------------");
		for (int i = 5; i >=0; i--) {
			try {
				Thread.sleep(1000);
				System.out.println("请等待"+i+"秒");
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
		System.out.println("请输入你要生产的交通工具(BUS/BIKE)");
		
		scUtils();
	}
	
	public static void scUtils(){
		System.out.println();
		Scanner sc = new Scanner(System.in);
		String carname = sc.nextLine();
		if(carname==""||carname==null){
			System.out.println("输入有误，请重新输入");
			scUtils();
		}else {
			System.out.println(carname);
			Car car = Factory.getFactory().getCar(carname);
			if(car!=null){
				car.gotowork();
			}else{
				System.out.println("生产汽车失败--");
			}
		}	
	}
}
