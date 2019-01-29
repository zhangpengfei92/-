package com.zpf.singleton;
/** 
 * @author zpf
 * @version 1.0
 * 单例模式-恶汉式
 */
public class HungerSingleton {
	//在本类中初始化一个私有的类对象
	private static HungerSingleton singleton = new HungerSingleton();
	//构造方法私有化-不让外界的直接通过new来获取这个类对象
	private HungerSingleton() {} 
	
	//对外提供一个公共的静态方法来获取本类对象；
	public  static HungerSingleton getInstance(){
		
		return singleton;
	}
	
	
}
