/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @UserInfo.java
 * 功能概要  : 
 * 做成日期  : @2019年1月17日
 * 修改日期  :
 */
package com.zpf.pojo;

import java.io.Serializable;

import lombok.Data;

/** 
 * @author zpf
 * @version 1.0
 */
@Data
public class UserInfo implements Serializable{

	private Integer uid;
	private String username;
	private String phone;
	private String address;
	private Integer age;
	private Integer sex;
	private String password;
	
	
	public UserInfo(Integer uid, String username, String phone, String address, Integer age, Integer sex,
			String password) {
		super();
		this.uid = uid;
		this.username = username;
		this.phone = phone;
		this.address = address;
		this.age = age;
		this.sex = sex;
		this.password = password;
	}
	

	
}
