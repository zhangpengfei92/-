/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : 
 * 功能概要  : 
 * 做成日期  : 20180年4月13日
 * 修改日期  :
 */
package com.jcl.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jcl.comm.PaginationContext;
import com.jcl.dao.SubzhMapper;
import com.jcl.pojo.Bdzh;
import com.jcl.pojo.BdzhExample;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhExample;
import com.jcl.pojo.BdzhExample.Criteria;
import com.jcl.service.BdzhService;
import com.jcl.service.SubzhService;
import com.jcl.stock.simulate.StringUtil;
import com.jcl.util.Constant;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/** 
 * @author zpf
 * @version 1.0
 * 
 * 报单账户控制器（bazh）--主账户
 */

@Controller
@RequestMapping("/main")
public class BdzhController {
	
	public static Logger log = Logger.getLogger(BdzhController.class);
	
	@Autowired
	private BdzhService bdzhServiceImpl;
	private static String mainzhzj="main_money";
	@Autowired
	private Datastore dsForStock;
	@Autowired
	private SubzhService subzhservice;
	
	@Autowired
	private SubzhMapper subzhMapper;
	
	//查询主账户信息(报单账户表)
	@RequestMapping("/querybdzh")
	public String queryBdzh(HttpSession session, Model model,Bdzh bdzh) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "14");
		try {
			//设置分页参数
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			BdzhExample example = new BdzhExample();
			Criteria criteria = example.createCriteria();
			if(!StringUtil.isAnyNullOrEmpty(bdzh.getAccountid())){
				criteria.andAccountidLike("%" + bdzh.getAccountid() + "%");
				model.addAttribute("accountid", bdzh.getAccountid());
			}
			criteria.andZhstateEqualTo(1);
			List<Bdzh> blist = bdzhServiceImpl.selectLikeAccount(example);
			PageInfo<Bdzh> userpage = new PageInfo<Bdzh>(blist);
			if(blist!=null && blist.size()>0){
				//取每个报单账户的资金数据
				DB db = dsForStock.getDB();
				DBCollection dbCollection=db.getCollection(mainzhzj);//主账号持仓对比 数据
				for(Bdzh mainzh: blist){
					DBObject condition = new BasicDBObject();
					condition.put("account", new BasicDBObject("$eq", mainzh.getAccountid()));
					long total=dbCollection.count(condition);
					if(total!=1){
						log.info(mainzh.getAccountid()+"这个报单账户从mongodb中取得异常，期望只有一个，而返回的是："+total);
					}
					DBCursor cursor = dbCollection.find(condition).skip(0).limit(10);
					int i=0;
					while (cursor.hasNext()) {
						i++;
						BasicDBObject dbObj = (BasicDBObject) cursor.next();
						if(dbObj.containsField("last")){//总权益：  --last静态权益
							mainzh.setSuminterest(new BigDecimal(String.valueOf(dbObj.getDouble("last"))));				    	
						}
						if(dbObj.containsField("freeze")){////占用保证金：  freeze占用保证金（持仓占用+委托冻结）
							mainzh.setBzmoney(new BigDecimal(String.valueOf(dbObj.getDouble("freeze"))));	
						}
						if(dbObj.containsField("available")){//可用资金：  available可用资金
							mainzh.setAvaamoney(new BigDecimal(String.valueOf(dbObj.getDouble("available"))));	
						}
						if(dbObj.containsField("total")){//动态权益    --total动态权益
							mainzh.setDymicEquities(new BigDecimal(String.valueOf(dbObj.getDouble("total"))));	
						}
						if(dbObj.containsField("close_profit")){//平仓盈亏     close_profit 平仓盈亏
							mainzh.setPcProfit(new BigDecimal(String.valueOf(dbObj.getDouble("close_profit"))));	
						}
						if(dbObj.containsField("position_profit")){//持仓盈亏    position_profit持仓，浮动盈亏
							mainzh.setHolderProfit(new BigDecimal(String.valueOf(dbObj.getDouble("position_profit"))));	
						}
						if(dbObj.containsField("fee")){
							mainzh.setFee(dbObj.getDouble("fee"));
						}
						
						log.info("一般来说有一个1是对的，返回的其实是："+i+"它的报单编号 是："+mainzh.getAccountid());
					}
				}
				
				
			}
			//向页面返回数据
			model.addAttribute("blist", blist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询账户列表异常："+e);
		}
		return "fund/bdzhList";	
	}
	
	//去添加页面修改页面
	@RequestMapping("/addBdzhlist")
	public String toAddBdzh(Model model,String id) {
		if(!StringUtil.isAnyNullOrEmpty(id)){
			Bdzh bdzh=bdzhServiceImpl.selectByPrimaryKey(Integer.parseInt(id));
			model.addAttribute("bdzh", bdzh);
		}
		return "fund/addbdsh";	
	}
	
	//添加数据
	@RequestMapping("/addbdzh")
	@ResponseBody
	public String addBdzh(Bdzh bdzh) {
		boolean b=false;
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("server_ip", bdzh.getServerip());
		map.put("username", bdzh.getAccountid());
		map.put("password", bdzh.getPassword());
		map.put("broker", bdzh.getBroker());
		JSONObject config = JSONObject.parseObject(JSON.toJSONString(map));
		
		bdzh.setZhstate(1);
		bdzh.setConfig(config.toJSONString());
		// bdzh.setBroker("CTP");//固定好的,账户接口类型 ,CTP或TFB
		try {
			if(bdzh.getBdzhid()==null){
				bdzhServiceImpl.addBdzh(bdzh);
			}else{
				bdzhServiceImpl.updateBdzh(bdzh);
			}
			b=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(b);	
	}
	
	
	//在删除之前做判断，看这个报单账户能否被删除。主要看它里面是否有资金信息。
	@RequestMapping("/candelete")
	@ResponseBody
	public String candelete(String id,String accountid){
		boolean result=true;
		DB db = dsForStock.getDB();
		DBCollection dbCollection=db.getCollection(mainzhzj);//主账号持仓对比 数据
		DBObject condition = new BasicDBObject();
		condition.put("account", new BasicDBObject("$eq",accountid));
		DBCursor cursor = dbCollection.find(condition).skip(0).limit(10);
		while (cursor.hasNext()) {
			BasicDBObject dbObj = (BasicDBObject) cursor.next();
			if(dbObj.containsField("last")){//总权益：  --last静态权益
				if(dbObj.getDouble("last")>0){
					result=false;
					break;
				}
			}
			if(dbObj.containsField("total")){////占用保证金：  freeze占用保证金（持仓占用+委托冻结）
				if(dbObj.getDouble("total")>0){
					result=false;
					break;
				}
			}
		}
		if(result && !StringUtil.isAnyNullOrEmpty(id)){//判断 了权益都为0，还需要判断它下面是否有交易用户
			Subzh subzh=new Subzh();
			subzh.setBdtd(id);
			List<Subzh> list=subzhservice.getFanganSubzh(subzh);
			if(list!=null && list.size()>0){
				result=false;
			}
		}
		return String.valueOf(result);
	}
	
	//删除报单账号---修改报单这的账号状态
	@RequestMapping("/deletebdzh")
	@ResponseBody
	public String deleteBdzh(Bdzh bdzh) {
		boolean b=true;
		try {
			SubzhExample example = new SubzhExample();
			com.jcl.pojo.SubzhExample.Criteria criteria = example.createCriteria();
			criteria.andBdtdEqualTo(bdzh.getBdzhid()+"");
			List<Subzh> list = subzhMapper.selectByExample(example);
			if(list !=null && list.size()>0){
				return "isexist";	
			}
			bdzhServiceImpl.deleteBdzh(bdzh.getAccountid());
		} catch (Exception e) {
			 b=false;
			e.printStackTrace();
		}
		return String.valueOf(b);	
	}
	
	
	@RequestMapping("/isexist")
	@ResponseBody
	public String isexist(Bdzh bdzh){
		boolean b=true;
		try {
			b=bdzhServiceImpl.isexist(bdzh);//true已存在 ，false表示这个编号 之前不存在
		} catch (Exception e) {
			 b=false;
			e.printStackTrace();
		}
		return String.valueOf(b);
	}
}
