/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @PreMenuServiceImpl.java
 * 功能概要  : 
 * 做成日期  : @2018年4月25日
 * 修改日期  :
 */
package com.jcl.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.PreMenuMapper;
import com.jcl.dao.SubzhMapper;
import com.jcl.pojo.PreMenu;
import com.jcl.service.PreMenuService;
import com.jcl.stock.simulate.StringUtil;

/** 
 * @author zpf
 * @version 1.0
 */
@Service
public class PreMenuServiceImpl implements PreMenuService{

	@Autowired
	private PreMenuMapper preMenuMapper ;
	@Autowired
	private SubzhMapper subzhMapper;

	@Override
	public Map<Integer, List<PreMenu>> queryAll(String parent) {
		List<PreMenu> plsit=new ArrayList<PreMenu>();//查询出所有的权限菜单列表
		if(StringUtil.isAnyNullOrEmpty(parent)){//如果是设置渠道的权限就将所有的菜单提供出来让他选择
			plsit = preMenuMapper.selectAll();
		}else{//查询上一级角色所拥有的权限
			plsit=subzhMapper.selectByRoleAndPer(parent);
		}
		
		List<PreMenu> list2=new ArrayList<PreMenu>();
		List<PreMenu> list3=new ArrayList<PreMenu>();
		List<PreMenu> list4=new ArrayList<PreMenu>();
		List<PreMenu> list5=new ArrayList<PreMenu>();
		
		Map<Integer, List<PreMenu>> map=new HashMap<Integer, List<PreMenu>>();
		//将权限菜单按权限进行分组，然后存入到map中，返回到控制层
		for (PreMenu preMenu : plsit) {
			if(preMenu.getPreId()==3) {
				list3.add(preMenu);
			}else if (preMenu.getPreId()==4) {
				list4.add(preMenu);
			}else if(preMenu.getPreId()==5){
				list5.add(preMenu);
			}else if(preMenu.getPreId()==2) {
				list2.add(preMenu);
			}
			map.put(2, list2);
			map.put(3, list3);
			map.put(4, list4);
			map.put(5, list5);
		}
		return map;
	}
	
}
