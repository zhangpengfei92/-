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

public class UserInfo {

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


	public Integer getUid() {
		return uid;
	}


	public void setUid(Integer uid) {
		this.uid = uid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public Integer getSex() {
		return sex;
	}


	public void setSex(Integer sex) {
		this.sex = sex;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
