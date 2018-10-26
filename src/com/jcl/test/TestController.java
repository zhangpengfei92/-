/**
 * Copyright (C) 20012 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @TestController.java
 * 功能概要  : 
 * 做成日期  : @20121年4月13日
 * 修改日期  :
 */
package com.jcl.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jcl.dao.FundSettlelogMapper;
import com.jcl.dao.SubzhMapper;
import com.jcl.mongodb.BeanUtil;
import com.jcl.mongodb.MongoUtils;
import com.jcl.pojo.AgentzhfundLog;
import com.jcl.pojo.Bdzh;
import com.jcl.pojo.FundSettlelog;
import com.jcl.pojo.HoldComparison;

import com.jcl.pojo.OperateScheme;
import com.jcl.pojo.Order;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.TradeParam;
import com.jcl.pojo.UserInfo;
import com.jcl.service.AgentzhfundLogService;
import com.jcl.service.BdzhService;
import com.jcl.service.FundPzLogService;
import com.jcl.service.FundSettlelogService;
import com.jcl.service.OperateSchemeService;
import com.jcl.service.UserInfoService;
import com.jcl.task.CountfundTask;
import com.jcl.task.HistoryRecordTask;
import com.jcl.util.DateUtil;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/** 
 * @author zpf
 * @version 1.0
 */
public class TestController {
	 public static void main(String[] args) {
		 app();//测试spring上下文
	 }


	private static void app() {		 ApplicationContext app=new ClassPathXmlApplicationContext("spring/spring-*.xml");
		 FundSettlelogService  os=app.getBean(FundSettlelogService.class);
		 
		 TradeParam trade=new TradeParam();
		 trade.setSubzh("1");
		 FundSettlelog sumFundSettlelogFund = os.sumFundSettlelogFund(trade);
		 
		 System.out.println("zzzsz");
		 System.out.println("总额总计   ： "+sumFundSettlelogFund.getSummoney()+
				 "渠道残留总计   ： "+sumFundSettlelogFund.getSumfeenextbalance()+
				 "代理商残留总计   ： "+sumFundSettlelogFund.getSumaddbalance()+
				 "经纪人残留总计   ： "+sumFundSettlelogFund.getSumoverbalance());
		
	}
	
	private static void count() {
		BigDecimal fund=new BigDecimal(7.75);
		
		/*fund=fund.divide(new BigDecimal(7.75), 2, RoundingMode.HALF_UP);*/
		fund=fund.multiply(new BigDecimal(7.75));
		
		System.out.println(fund);
	}

	


}
