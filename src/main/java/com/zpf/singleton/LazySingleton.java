package com.zpf.singleton;
/** 
 * @author zpf
 * @version 1.0
 * 懒汉式
 */
public class LazySingleton {
	//声明一个静态的私有化类对象
	private static LazySingleton singleton;
	
	private static  int count ;
	//空构造方法私有化
	private LazySingleton() {
		System.out.println("单例模式-懒汉式的构造方法被调用了"+(++count)+"次");
	}
	//对外提供一个获取类对象的静态公共方法
	public static LazySingleton getInstance(){
		if(singleton==null) {
			
			singleton=new  LazySingleton();
		}					
		return singleton;		
	}
}
