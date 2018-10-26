/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @RiskTemplateServiceImpl.java
 * 功能概要  : 
 * 做成日期  : @2018年4月18日
 * 修改日期  :
 */
package com.jcl.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jcl.dao.BzjmbMapper;
import com.jcl.dao.BzjmbMenuMapper;
import com.jcl.dao.CodefeesetMenuMapper;
import com.jcl.dao.RiskTempallMapper;
import com.jcl.dao.RiskTemplateMenuMapper;
import com.jcl.pojo.Bzjmb;
import com.jcl.pojo.BzjmbMenu;
import com.jcl.pojo.CodefeesetMenu;
import com.jcl.pojo.RiskTempall;
import com.jcl.pojo.RiskTemplateMenu;
import com.jcl.pojo.RiskTemplateMenuExample;
import com.jcl.pojo.RiskTemplateMenuExample.Criteria;
import com.jcl.pojo.SubzhObject;
import com.jcl.service.RiskTemplateMenuService;
import com.jcl.util.StringUtil;


/** 
 * @author zpf
 * @version 1.0
 * 
 * 风控模板菜单服务层
 */

@Service
public class RiskTemplateMenuServiceImpl implements RiskTemplateMenuService{
	
	@Autowired
	private RiskTemplateMenuMapper riskTemplateMenuMapper;
	
	@Autowired
	private RiskTempallMapper riskTempallMapper;
	
	@Autowired
	private CodefeesetMenuMapper codefeesetMenuMapper;
	
	@Autowired
	private BzjmbMenuMapper bzjmbMenuMapper;
	
	@Override
	public List<RiskTemplateMenu> selectAll() {
		
		return riskTemplateMenuMapper.selectAll();
	}

	@Override
	public int saveqdSchemes(SubzhObject subzhObject) {
		int num = 0;
		String schemes=subzhObject.getSchemes();
		if(StringUtil.isAllNullOrEmpty(schemes)) {
			return num;
		}
		String scs[]=schemes.split("-");
		if(scs.length==3) {
			String codes=scs[0];//手续费方案
			String bzjs=scs[1];//保证金方案
			String rasks=scs[2];//风控方案
			
			if(!StringUtil.isAllNullOrEmpty(codes)) {//保存渠道下面的手续费方案
				if(bzjs.endsWith(",")) {
					codes=codes.substring(0, codes.length()-1);
					String[] code = codes.split(",");
					if(code.length>0){
						for (String str : code) {
							RiskTemplateMenu menu=new RiskTemplateMenu();
							menu.setAgentzh(subzhObject.getSubzh());
							menu.setUserid(Long.parseLong(str));
							menu.setTitle("1");//1表示手续费方案
							menu.setModifytime(new Date());
							num=riskTemplateMenuMapper.insertSelective(menu);
						}
					}
				}
			}
			
			if(!StringUtil.isAllNullOrEmpty(bzjs)) {//保存渠道下面的保证金费方案
				if(bzjs.endsWith(",")) {
					bzjs=bzjs.substring(0, bzjs.length()-1);
					String[] bzj = bzjs.split(",");
					if(bzj.length>0){
						for (String str : bzj) {
							RiskTemplateMenu menu=new RiskTemplateMenu();
							menu.setAgentzh(subzhObject.getSubzh());
							menu.setUserid(Long.parseLong(str));
							menu.setTitle("2");//1表示保证金方案
							menu.setModifytime(new Date());
							num=riskTemplateMenuMapper.insertSelective(menu);
						}
					}
				}
			}		
			if(!StringUtil.isAllNullOrEmpty(rasks)) {//保存渠道下面的风控费方案
				if(rasks.endsWith(",")) {
					rasks=rasks.substring(0, rasks.length()-1);
					String[] rask = rasks.split(",");
					if(rask.length>0){
						for (String str : rask) {
							RiskTemplateMenu menu=new RiskTemplateMenu();
							menu.setAgentzh(subzhObject.getSubzh());
							menu.setUserid(Long.parseLong(str));
							menu.setTitle("3");//1表示风控方案
							menu.setModifytime(new Date());
							num=riskTemplateMenuMapper.insertSelective(menu);
						}
					}
				}
			}
		}
		return num;
	}

	@Override
	public Map<String, Object> querySchemes(String subzh) {
		Map<String, Object> map=new HashMap<String, Object>();
		try {
			RiskTemplateMenuExample example=new RiskTemplateMenuExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andAgentzhEqualTo(subzh);
			List<RiskTemplateMenu> rtmlist = riskTemplateMenuMapper.selectByExample(example);
		
			List<CodefeesetMenu> cfmlist=new ArrayList<CodefeesetMenu>();//保存手续费方案
			List<BzjmbMenu>blist=new ArrayList<BzjmbMenu>();//保存保证金方案方案
			List<RiskTempall> rtlist=new ArrayList<RiskTempall>();//风控方案
		
			for (RiskTemplateMenu riskTemplateMenu : rtmlist) {
				if(!StringUtil.isAllNullOrEmpty(riskTemplateMenu.getTitle())&&riskTemplateMenu.getTitle().equals("1")){				
					CodefeesetMenu codefeesetMenu = codefeesetMenuMapper.selectByPrimaryKey(Integer.parseInt(riskTemplateMenu.getUserid().toString()));
					cfmlist.add(codefeesetMenu);
				}else if(!StringUtil.isAllNullOrEmpty(riskTemplateMenu.getTitle())&&riskTemplateMenu.getTitle().equals("2")) {
					BzjmbMenu bzjmb=bzjmbMenuMapper.selectByPrimaryKey(Integer.parseInt(riskTemplateMenu.getUserid().toString()));
					blist.add(bzjmb);
				}else if(!StringUtil.isAllNullOrEmpty(riskTemplateMenu.getTitle())&&riskTemplateMenu.getTitle().equals("3")){
					RiskTempall riskTempall=riskTempallMapper.selectByPrimaryKey(Integer.parseInt(riskTemplateMenu.getUserid().toString()));
					rtlist.add(riskTempall);
				}
			}
			map.put("1", cfmlist);
			map.put("2", blist);
			map.put("3", rtlist);
		
		} catch (Exception e) {
		e.printStackTrace();
	}
		return map;
	}
/*
	@Override
	public List<RiskTemplateMenu> queryiIsexist(String subzh, String sid, String tid) {
		List<RiskTemplateMenu> rtmlist=new ArrayList<>();
		try {
			RiskTemplateMenuExample example=new RiskTemplateMenuExample();
			
			Criteria createCriteria = example.createCriteria();
			
			if(!StringUtil.isAllNullOrEmpty(subzh)) {
				createCriteria.andAgentzhEqualTo(subzh);
			}
			if(!StringUtil.isAllNullOrEmpty(tid)) {
				createCriteria.andTitleEqualTo(tid);
			}
			if(!StringUtil.isAllNullOrEmpty(sid)) {
				createCriteria.andUseridEqualTo(Long.parseLong(sid));
			}
			
			rtmlist = riskTemplateMenuMapper.selectByExample(example);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rtmlist;
	}*/

	@Override
	public int deletescheme(String subzh) {
		int count = 0;
		try {
			RiskTemplateMenuExample example=new RiskTemplateMenuExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andAgentzhEqualTo(subzh);
			if(!StringUtil.isAllNullOrEmpty(subzh)){
				createCriteria.andAgentzhEqualTo(subzh);
			}
			count=riskTemplateMenuMapper.deleteByExample(example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return count;
	}

	@Override
	public List<RiskTemplateMenu> selectSchemes(Integer id, int i) {
		List<RiskTemplateMenu> rtmlist=new ArrayList<>();
		try {
			RiskTemplateMenuExample example=new RiskTemplateMenuExample();
			
			Criteria createCriteria = example.createCriteria();

			if(!StringUtil.isAllNullOrEmpty(String.valueOf(i))) {
				createCriteria.andTitleEqualTo(String.valueOf(i));
			}
			if(!StringUtil.isAllNullOrEmpty(String.valueOf(id))) {
				createCriteria.andUseridEqualTo(Long.parseLong(String.valueOf(id)));
			}
			
			rtmlist = riskTemplateMenuMapper.selectByExample(example);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rtmlist;
	}
	
	
}
