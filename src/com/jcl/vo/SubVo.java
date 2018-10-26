/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @SubVo.java
 * 功能概要  : 
 * 做成日期  : @2018年4月23日
 * 修改日期  :
 */
package com.jcl.vo;

import com.jcl.pojo.SubzhKey;

/** 
 * @author zpf
 * @version 1.0
 * 扩展一个vo类--用于存放子账户的菜单权限和角色信息
 */
public class SubVo extends SubzhKey{
	//角色id
    private Integer roleid;
	
    //权限菜单id
    private Integer pmid;
    
    //模糊查询的字段
    private String nickname;
    
    //模糊查询中匹配当前用户的字段
    private String username;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public Integer getPmid() {
		return pmid;
	}

	public void setPmid(Integer pmid) {
		this.pmid = pmid;
	} 
}
