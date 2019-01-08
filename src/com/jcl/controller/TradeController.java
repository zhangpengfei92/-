/**
 * 
 */
package com.jcl.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.jcl.comm.PaginationContext;
import com.jcl.mongodb.BeanUtil;
import com.jcl.mongodb.Page;
import com.jcl.pojo.CurrentEntrust;
import com.jcl.pojo.CurrentHoder;
import com.jcl.pojo.CurrentMake;
import com.jcl.pojo.Currentzj;
import com.jcl.pojo.DealCj;
import com.jcl.pojo.EntrustOrder;
import com.jcl.pojo.FundMessage;
import com.jcl.pojo.Holder;
import com.jcl.pojo.RiskContract;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.TradeParam;
import com.jcl.pojo.entryEntity;
import com.jcl.service.RiskContractService;
import com.jcl.service.SubzhService;
import com.jcl.stock.simulate.BussinessException;
import com.jcl.stock.simulate.service.SimulateStockService;
import com.jcl.util.Constant;
import com.jcl.util.DateUtil;
import com.jcl.util.MyExcelUtil;
import com.jcl.util.StringUtil;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * @author heqiwen
 * @date 2018-5-22
 * @describe
 * @modify
 * @Copyright jcl
 */
@Controller
@RequestMapping("/trade")
public class TradeController {

	public static Logger log = Logger.getLogger(TradeController.class);
	@Autowired
	private SimulateStockService simulateStockService;
	@Autowired
	private SubzhService subzhservice;
	@Autowired
	private RiskContractService riskcontractService;

	@Autowired
	private Datastore dsForStock;
	
	
	/**
	 * 实时成交统计
	 */
	@RequestMapping("/getTotalDeal")
	@ResponseBody
	public Map getTotalDeal(HttpSession session, String subzh, String[] subzhs, TradeParam trade) {
		Map<String, Object> resultMap = new HashMap<String, Object>(3);
		Integer trade_vol = 0; // 成交数量
		Double trade_amount = 0.00;// 盈亏
		Double fee = 0.00;// 手续费
		DB db = dsForStock.getDB();
		DBCollection dbCollection = db.getCollection("sub_cj");// 历史持仓信息
		DBObject condition = new BasicDBObject();
		// 如果是直接查询某个用户的资金
		// 如果是直接查询某个用户的资金
		if (!StringUtil.isAnyNullOrEmpty(subzh)) {
			condition.put("sub_zh", new BasicDBObject("$eq", subzh));
		} else if (!StringUtil.isAnyNullOrEmpty(subzhs) && subzhs.length > 0) {
			BasicDBList values = new BasicDBList();
			for (int i = 0; i < subzhs.length; i++) {
				values.add(new BasicDBObject("sub_zh", new BasicDBObject("$eq", subzhs[i])));
			}
			condition.put("$or", values);
		} else {
			return null;
		}
		if (!StringUtil.isAnyNullOrEmpty(trade.getStockCode())) {
			condition.put("code", new BasicDBObject("$eq", trade.getStockCode()));
		}
		if (!StringUtil.isAnyNullOrEmpty(trade.getStockName())) {
			condition.put("name", new BasicDBObject("$eq", trade.getStockName()));
		}
		condition.put("used", false);
		DBCursor cursor = dbCollection.find(condition);
		CurrentMake fund = null;
		while (cursor.hasNext()) {
			try {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				String string = dbObj.toString();
				fund = JSON.parseObject(string, CurrentMake.class);
				trade_vol += fund.getTrade_vol();
				trade_amount += fund.getTrade_amount().doubleValue();
				fee += fund.getFee().doubleValue();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		resultMap.put("trade_vol", trade_vol);
		resultMap.put("trade_amount", trade_amount);
		resultMap.put("fee", fee);
		return resultMap;
	}
	
	
	/**
	 * 实时持仓统计
	 */
	@RequestMapping("/getTotalHoder")
	@ResponseBody
	public Map getTotalHoder(HttpSession session,String subzh,String [] subzhs,TradeParam trade) {
		Map<String,Object> resultMap = new HashMap<String, Object>(2);
		Double position_vol=0.00;  //总持仓
		Double today_vol=0.00;//今持仓
		Double history_vol=0.00;//昨仓
		Double profit=0.00; //持仓盈亏
		Double sell_vol=0.00; //可平量
		DB db = dsForStock.getDB();
		DBCollection dbCollection=db.getCollection("sub_cc");//历史持仓信息
		DBObject condition = new BasicDBObject();
		//如果是直接查询某个用户的资金
		if( ! StringUtil.isAnyNullOrEmpty(subzh)){
			condition.put("sub_zh", new BasicDBObject("$eq", subzh));
		}else if(!StringUtil.isAnyNullOrEmpty(subzhs) && subzhs.length>0){
			BasicDBList values=new BasicDBList();
			for (int i = 0; i < subzhs.length; i++) {
				values.add(new BasicDBObject("sub_zh", new BasicDBObject("$eq", subzhs[i])));
			}
			condition.put("$or", values);
		}else{
			return null;
		}	
		
		
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockCode())) {
				condition.put("code", new BasicDBObject("$eq", trade.getStockCode()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockName())) {
				condition.put("name", new BasicDBObject("$eq", trade.getStockName()));
			}
			DBCursor cursor = dbCollection.find(condition);
			CurrentHoder fund=null;
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				fund=new CurrentHoder();
				try {
					String string = dbObj.toString();
					fund=JSON.parseObject(string, CurrentHoder.class);
					position_vol +=fund.getPosition_vol();
					today_vol +=fund.getToday_vol();
					if(fund.getProfit() !=null){
						profit +=fund.getProfit();
					}
					sell_vol +=fund.getPosition_vol()-fund.getSellfreeze_vol();
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		resultMap.put("position_vol", position_vol);
		resultMap.put("today_vol", today_vol);
		resultMap.put("history_vol", position_vol-today_vol);
		resultMap.put("profit", profit);
		resultMap.put("sell_vol", sell_vol);
		return resultMap;
	}
	
	/**
	 * 实时资金统计
	 */
	@RequestMapping("/getTotalFund")
	@ResponseBody
	public Map getTotalFund(HttpSession session,String subzh,String [] subzhs) {
		Map<String,Object> resultMap = new HashMap<String, Object>(2);
		Double totalRight=0.00;  //静态权益   上日结存(last) + 当日入金(deposit) - 当日出金(withdraw)
		Double total=0.00;//动态权益
		Double position_profit=0.00; //持仓盈亏
		Double margi=0.00;         // 占用保证金
		Double freeze=0.00;       //冻结保证金
		Double available=0.00;        //可用资金
		Double fee=0.00;           ////手续费汇总
		DB db = dsForStock.getDB();
		DBCollection dbCollection=db.getCollection("sub_zj");//历史资金信息
		DBObject condition = new BasicDBObject();
		//如果是直接查询某个用户的资金
		if( ! StringUtil.isAnyNullOrEmpty(subzh)){
			condition.put("account", new BasicDBObject("$eq", subzh));
		}else if(!StringUtil.isAnyNullOrEmpty(subzhs) && subzhs.length>0){
			BasicDBList values=new BasicDBList();
			for (int i = 0; i < subzhs.length; i++) {
				values.add(new BasicDBObject("account", new BasicDBObject("$eq", subzhs[i])));
			}
			condition.put("$or", values);
		}else{
			return null;
		}
			  
			DBCursor cursor = dbCollection.find(condition);
			Currentzj fund=null;
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				fund=new Currentzj();
				try {
					String string = dbObj.toString();
					fund=JSON.parseObject(string, Currentzj.class);
					totalRight=totalRight+fund.getLast()+fund.getDeposit()-fund.getWithdraw();
					total=total+fund.getTotal();
					position_profit=position_profit+fund.getPosition_profit();
					margi=margi+fund.getMargin();
					freeze=freeze+fund.getFreezeVol();       //冻结保证金
					available+= fund.getAvailable();        //可用资金
					fee += fund.getFee();           ////手续费汇总
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		if(freeze<0){
			freeze=0.00;
		}
		resultMap.put("totalRight", totalRight);
		resultMap.put("total", total);
		resultMap.put("position_profit", position_profit);
		resultMap.put("margi", margi);
		resultMap.put("freeze", freeze);
		resultMap.put("available", available);
		resultMap.put("fee", fee);
		return resultMap;
	}
	
	
	
	
	
	/**
	 * 
	 * @return
	 * @author heqiwen
	 * @date 2018-5-22
	 * @decribe 获取用户资金
	 * @param session
	 * @param model
	 * @param map
	 * @return
	 */
	@RequestMapping("/getFund")
	public String getDrFund(HttpSession session, Model model, String subzh, String[] subzhs, TradeParam trade) {
		Map<String, Object> map = new HashMap<String, Object>();
		long totalCount = 0;
		String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
		String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
		Integer isAdmin = (Integer) session.getAttribute(Constant.SESSION_ISADMIN);// 当前登录者角色标识，1机构2平台，3渠道，4代理商，5经纪人
		String pt = (String) session.getAttribute(Constant.SESSION_PLATEFORM);
		int start = (PaginationContext.getPageNum() - 1) * PaginationContext.getPageSize();
		int limit = PaginationContext.getPageNum() * PaginationContext.getPageSize();
		Page<Currentzj> fundPage = new Page<Currentzj>();
		fundPage.setPagenum(PaginationContext.getPageNum());
		fundPage.setPagesize(PaginationContext.getPageSize());
		List<Currentzj> fmList = new ArrayList<Currentzj>();
		DB db = dsForStock.getDB();
		DBCollection dbCollection = db.getCollection("sub_zj");// 历史资金信息
		DBObject condition = new BasicDBObject();
		// 如果是直接查询某个用户的资金
		if (!StringUtil.isAnyNullOrEmpty(subzh)) {
			condition.put("account", subzh);
		} else if (!StringUtil.isAnyNullOrEmpty(subzhs) && subzhs.length > 0) {
			BasicDBList values = new BasicDBList();
			for (int i = 0; i < subzhs.length; i++) {
				values.add(new BasicDBObject("account", subzhs[i]));
			}
			condition.put("$or", values);
		} else {
			model.addAttribute("status", 3);
			model.addAttribute("lsflag", trade.getLsflag());
			return "fund/fundtable";
		}
		DBObject orderBy = new BasicDBObject();
		orderBy.put("trade_date", -1);// 按tradedate倒序排
		totalCount = dbCollection.count(condition);
		DBCursor cursor = dbCollection.find(condition).sort(orderBy).skip(start).limit(PaginationContext.getPageSize());
		Currentzj fund = null;
		while (cursor.hasNext()) {
			BasicDBObject dbObj = (BasicDBObject) cursor.next();
			fund = new Currentzj();
			try {
				String string = dbObj.toString();
				fund=JSON.parseObject(string, Currentzj.class);
								
				Subzh user = subzhservice.getTradeUserOne(fund.getAccount());
				if (user != null) {
					fund.setChannel(user.getChannelname());
					fund.setAgentzh(user.getAgentname());
					fund.setBroker(user.getBrokername());
					//fund.setUsername(user.getName());
					fund.setDemicRight(fund.getLast() + fund.getDeposit() - fund.getWithdraw());
					/*if(fund.getFreeze()<0){
						fund.setFreeze(0.00);
					}*/
				}
				fmList.add(fund);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		map.put("status", 0);
		map.put("data", fmList);
		model.addAttribute("status",0);
		fundPage.setList(fmList);
		fundPage.setCountsize(Long.valueOf(String.valueOf(totalCount)));
		fundPage.setPagecount(fundPage.getCountsize());
		model.addAttribute("page", fundPage);
		model.addAttribute("lsflag", trade.getLsflag());
		return "fund/fundtable";

	}

	/**
	 * 
	 * @return
	 * @author heqiwen
	 * @date 2018-5-22
	 * @decribe 资金页面
	 * @param session
	 * @param model
	 * @param trade
	 * @return
	 */
	@RequestMapping("/fundlist")
	public String toFundPage(HttpSession session, Model model) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "5");
		String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
		String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
		Integer isAdmin = (Integer) session.getAttribute(Constant.SESSION_ISADMIN);
		Subzh condition = new Subzh();
		if (isAdmin == 1 || isAdmin == 2) {// 如果是机构登录，那就查询条件中带机构
			if (isAdmin == 1) {
				condition.setManage(username);
			} else {
				condition.setAllocpt(username);
			}
			condition.setIsadmin(6);
			List<Subzh> jylist = subzhservice.getSubzhLevelList(condition);// 查普通交易用户集合
			model.addAttribute("jyList", jylist);

			condition.setIsadmin(3);
			List<Subzh> qdlist = subzhservice.getSubzhLevelList(condition);// 查渠道集合
			model.addAttribute("channelList", qdlist);

			condition.setIsadmin(4);
			List<Subzh> dlslist = subzhservice.getSubzhLevelList(condition);// 查代理商集合
			model.addAttribute("agentList", dlslist);

			condition.setIsadmin(5);
			List<Subzh> jjrlist = subzhservice.getSubzhLevelList(condition);// 查经纪人集合
			model.addAttribute("brokerList", jjrlist);
		} else if (isAdmin == 3) {// 渠道登录后，需要加载代理商，经纪人集合
			condition.setAllocchannel(username);
			condition.setIsadmin(6);
			List<Subzh> jylist = subzhservice.getSubzhLevelList(condition);// 查经纪人集合
			model.addAttribute("jyList", jylist);
			condition.setIsadmin(4);
			List<Subzh> dlslist = subzhservice.getSubzhLevelList(condition);// 查代理商集合
			model.addAttribute("agentList", dlslist);
			condition.setIsadmin(5);
			List<Subzh> jjrlist = subzhservice.getSubzhLevelList(condition);// 查经纪人集合
			model.addAttribute("brokerList", jjrlist);
		} else if (isAdmin == 4) {// 代理商登录时，需要加载经纪人下拉框数据
			condition.setAllocagent(username);
			condition.setIsadmin(6);
			List<Subzh> jylist = subzhservice.getSubzhLevelList(condition);// 查普通交易用户集合
			model.addAttribute("jyList", jylist);
			condition.setIsadmin(5);
			List<Subzh> jjrlist = subzhservice.getSubzhLevelList(condition);// 查经纪人集合
			model.addAttribute("brokerList", jjrlist);
		} else if (isAdmin == 5) {// 经纪人登录时，需要加载交易用户下拉框数据
			List<Subzh> jjrlist = new ArrayList<Subzh>();
			Subzh jjr = subzhservice.getPuriSubzh(username);
			jjrlist.add(jjr);
			model.addAttribute("brokerList", jjrlist);
			if (jjrlist != null && jjrlist.size() > 0) {
				condition.setAllocbroker(jjrlist.get(0).getSubzh());
				condition.setIsadmin(6);
				List<Subzh> jylist = subzhservice.getSubzhLevelList(condition);// 查经纪人集合
				model.addAttribute("jyList", jylist);
			}
		}
		model.addAttribute("isadmin", isAdmin);
		return "fund/fundlist";

	}

	/**
	 * 
	 * @return
	 * @author heqiwen
	 * @date 2018-5-22
	 * @decribe 持仓查询页面
	 * @param session
	 * @param model
	 * @param trade
	 * @return
	 */
	@RequestMapping("/holderlist")
	public String toHoldPage(HttpSession session, Model model) {
		toFundPage(session, model);
		return "fund/holderlist";
	}

	/**
	 * 
	 * @return
	 * @author heqiwen
	 * @date 2018-5-23
	 * @decribe 查询实时持仓数据
	 * @param session
	 * @param model
	 * @param trade
	 * @return
	 */
	@RequestMapping("/getDrHolder")
	public String getDrHolder(HttpSession session, Model model, TradeParam trade, String subzh, String[] subzhs) {
		try {
			long totalCount = 0;
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin = (Integer) session.getAttribute(Constant.SESSION_ISADMIN);// 当前登录者角色标识，1机构2平台，3渠道，4代理商，5经纪人
			String pt = (String) session.getAttribute(Constant.SESSION_PLATEFORM);
			trade.setJg(manage);
			trade.setPt(pt);
			int start = (PaginationContext.getPageNum() - 1) * PaginationContext.getPageSize();
			int limit = PaginationContext.getPageNum() * PaginationContext.getPageSize();
			Page<CurrentHoder> hpage = new Page<CurrentHoder>();
			hpage.setPagenum(PaginationContext.getPageNum());
			hpage.setPagesize(PaginationContext.getPageSize());
			trade.setStart(0);
			trade.setLimit(100);
			List<CurrentHoder> holdList = new ArrayList<CurrentHoder>();
			DB db = dsForStock.getDB();
			DBCollection dbCollection = db.getCollection("sub_cc");// 历史资金信息
			DBObject condition = new BasicDBObject();
			// 如果是直接查询某个用户的资金
			if (!StringUtil.isAnyNullOrEmpty(subzh)) {
				condition.put("sub_zh", subzh);
			} else if (!StringUtil.isAnyNullOrEmpty(subzhs) && subzhs.length > 0) {
				BasicDBList values = new BasicDBList();
				for (int i = 0; i < subzhs.length; i++) {
					values.add(new BasicDBObject("sub_zh", subzhs[i]));
				}
				condition.put("$or", values);
			} else {
				model.addAttribute("status", 3);
				model.addAttribute("lsflag", trade.getLsflag());
				return "fund/currHolderlist";
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockCode())) {
				condition.put("code", trade.getStockCode());
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockName())) {
				condition.put("name", trade.getStockName());
			}
			
			totalCount = dbCollection.count(condition);
			DBCursor cursor = dbCollection.find(condition).skip(start).limit(PaginationContext.getPageSize());
			CurrentHoder fund = null;
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				fund = new CurrentHoder();
				try {
					String string = dbObj.toString();
					fund=JSON.parseObject(string, CurrentHoder.class);
					//BeanUtil.dbObject2Bean(dbObj, fund);
					Subzh user = subzhservice.getTradeUserOne(fund.getSub_zh());
					if (user != null) {
						fund.setChannel(user.getChannelname());
						fund.setAgentzh(user.getAgentname());
						fund.setBroker(user.getBrokername());
						//fund.setUsername(user.getName());
						if(fund.getBs_type()==0){
							fund.setAgent("买入");
						}else{
							fund.setAgent("卖出");
						}
						fund.setHistory_vol(fund.getPosition_vol()-fund.getToday_vol());
						fund.setSell_vol(fund.getPosition_vol()-fund.getSellfreeze_vol());
					}
					holdList.add(fund);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			hpage.setList(holdList);
			hpage.setCountsize(Long.valueOf(String.valueOf(totalCount)));
			hpage.setPagecount(hpage.getCountsize());
			model.addAttribute("status", 0);
			model.addAttribute("page", hpage);
		} catch (Exception e) {
			model.addAttribute("status", 2);
			model.addAttribute("describe", "此用户账户不存在");
			e.printStackTrace();
		}
		model.addAttribute("lsflag", trade.getLsflag());
		return "fund/currHolderlist";

	}

	/**
	 * @return
	 * @author heqiwen
	 * @date 2018-6-14
	 * @decribe
	 * @param profit
	 * @param clist
	 * @return
	 */
	private Double formateCondouble(Double profit, List<RiskContract> clist, String stock) {
		if (profit == null) {
			profit = 0.0;
		}
		Double d = formateDouble(profit);
		if (clist == null || clist.size() == 0 || StringUtil.isAnyNullOrEmpty(stock)) {
			return d;
		} else {
			for (RiskContract contract : clist) {
				if (stock.equals(contract.getContractCode())) {
					log.info(stock + "对应合约找到最小变动价" + contract.getMinchangeprice());
					if (contract.getMinchangeprice() != null) {
						String minchage = String.valueOf(contract.getMinchangeprice());
						if (minchage.indexOf(".") > 0) {
							while (minchage.endsWith("0")) {
								minchage = minchage.substring(0, minchage.length() - 1);
							}
							if (minchage.endsWith(".")) {// 整数
								minchage = minchage.substring(0, minchage.length() - 1);
								BigDecimal b = new BigDecimal(String.valueOf(profit));
								d = b.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
							} else {
								int index = minchage.indexOf(".");
								int i = minchage.length() - index - 1;
								BigDecimal b = new BigDecimal(String.valueOf(profit));
								d = b.setScale(i, BigDecimal.ROUND_HALF_UP).doubleValue();
							}

						} else {
							BigDecimal b = new BigDecimal(String.valueOf(profit));
							d = b.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
						}
					}
					break;
				}
			}
		}
		return d;
	}

	/**
	 * 
	 * @return
	 * @author heqiwen
	 * @date 2018-5-23
	 * @decribe 查询当日委托记录
	 * @param session
	 * @param model
	 * @param trade
	 * @return
	 */
	@RequestMapping("/getDrEntrust")
	public String getDrEntrust(HttpSession session, Model model, TradeParam trade, String subzh, String[] subzhs) {
		try {
			long totalCount = 0;
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin = (Integer) session.getAttribute(Constant.SESSION_ISADMIN);// 当前登录者角色标识，1机构2平台，3渠道，4代理商，5经纪人
			String pt = (String) session.getAttribute(Constant.SESSION_PLATEFORM);
			trade.setJg(manage);
			trade.setPt(pt);
			int start = (PaginationContext.getPageNum() - 1) * PaginationContext.getPageSize();
			int limit = PaginationContext.getPageNum() * PaginationContext.getPageSize();
			Page<CurrentEntrust> hpage = new Page<CurrentEntrust>();
			hpage.setPagenum(PaginationContext.getPageNum());
			hpage.setPagesize(PaginationContext.getPageSize());
			trade.setStart(0);
			trade.setLimit(100);
			List<CurrentEntrust> holdList = new ArrayList<CurrentEntrust>();
			DB db = dsForStock.getDB();
			DBCollection dbCollection = db.getCollection("sub_wt");// 历史资金信息
			DBObject condition = new BasicDBObject();
			// 如果是直接查询某个用户的资金
			if (!StringUtil.isAnyNullOrEmpty(subzh)) {
				condition.put("sub_zh", subzh);
			} else if (!StringUtil.isAnyNullOrEmpty(subzhs) && subzhs.length > 0) {
				BasicDBList values = new BasicDBList();
				for (int i = 0; i < subzhs.length; i++) {
					values.add(new BasicDBObject("sub_zh", subzhs[i]));
				}
				condition.put("$or", values);
			} else {
				model.addAttribute("status", 3);
				model.addAttribute("lsflag", trade.getLsflag());
				return "fund/entrustActualList";
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockCode())) {
				condition.put("code", trade.getStockCode());
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockName())) {
				condition.put("name", trade.getStockName());
			}
			condition.put("used", false);
			  DBObject orderBy = new BasicDBObject(); orderBy.put("order_date",
			 -1);//按tradedate倒序排 totalCount=dbCollection.count(condition);
			totalCount = dbCollection.count(condition);
			DBCursor cursor = dbCollection.find(condition).sort(orderBy).skip(start).limit(PaginationContext.getPageSize());
			log.info("查询当日委托条件..............."+cursor);
			CurrentEntrust fund = null;
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				fund = new CurrentEntrust();
				try {
					String string = dbObj.toString();
					fund=JSON.parseObject(string, CurrentEntrust.class);
					
					
					Subzh user = subzhservice.getTradeUserOne(fund.getSub_zh());
					if (user != null) {
						fund.setChannel(user.getChannelname());
						fund.setAgentzh(user.getAgentname());
						fund.setBroker(user.getBrokername());
						//fund.setUsername(user.getName());
					}
					holdList.add(fund);
					log.info("查询当日委托..............."+fund.getOrder_date());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			hpage.setList(holdList);
			log.info("查询当日委托个数..............."+holdList.size());
			hpage.setCountsize(Long.valueOf(String.valueOf(totalCount)));
			hpage.setPagecount(hpage.getCountsize());
			model.addAttribute("status", 0);
			model.addAttribute("page", hpage);
		} catch (Exception e) {
			model.addAttribute("status", 2);
			model.addAttribute("describe", "此用户账户不存在");
			e.printStackTrace();
		}
		log.info("查询当日委托...............1111");
		model.addAttribute("lsflag", trade.getLsflag());
		log.info("查询当日委托结束...............");
		return "fund/entrustActualList";
	
	}

	/**
	 * 
	 * @return
	 * @author heqiwen
	 * @date 2018-5-23
	 * @decribe 查询当日成交记录
	 * @param session
	 * @param model
	 * @param trade
	 * @return
	 */
	@RequestMapping("/getDrDealcj")
	public String getDrDealcj(HttpSession session, Model model, TradeParam trade, String subzh, String[] subzhs) {
		try {
			long totalCount = 0;
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin = (Integer) session.getAttribute(Constant.SESSION_ISADMIN);// 当前登录者角色标识，1机构2平台，3渠道，4代理商，5经纪人
			String pt = (String) session.getAttribute(Constant.SESSION_PLATEFORM);
			trade.setJg(manage);
			trade.setPt(pt);
			int start = (PaginationContext.getPageNum() - 1) * PaginationContext.getPageSize();
			int limit = PaginationContext.getPageNum() * PaginationContext.getPageSize();
			Page<CurrentMake> hpage = new Page<CurrentMake>();
			hpage.setPagenum(PaginationContext.getPageNum());
			hpage.setPagesize(PaginationContext.getPageSize());
			trade.setStart(0);
			trade.setLimit(100);
			List<CurrentMake> holdList = new ArrayList<CurrentMake>();
			DB db = dsForStock.getDB();
			DBCollection dbCollection = db.getCollection("sub_cj");// 成交
			DBObject condition = new BasicDBObject();
			// 如果是直接查询某个用户的资金
			if (!StringUtil.isAnyNullOrEmpty(subzh)) {
				condition.put("sub_zh", new BasicDBObject("$eq", subzh));
			} else if (!StringUtil.isAnyNullOrEmpty(subzhs) && subzhs.length > 0) {
				BasicDBList values = new BasicDBList();
				for (int i = 0; i < subzhs.length; i++) {
					values.add(new BasicDBObject("sub_zh", new BasicDBObject("$eq", subzhs[i])));
				}
				condition.put("$or", values);
			} else {
				model.addAttribute("status", 3);
				model.addAttribute("lsflag", trade.getLsflag());
				return "fund/currDealList";
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockCode())) {
				condition.put("code", new BasicDBObject("$eq", trade.getStockCode()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockName())) {
				condition.put("name", new BasicDBObject("$eq", trade.getStockName()));
			}
			condition.put("used", false);
			  DBObject orderBy = new BasicDBObject(); orderBy.put("trade_time",
			 -1);//按tradedate倒序排 totalCount=dbCollection.count(condition);
			totalCount = dbCollection.count(condition);
			DBCursor cursor = dbCollection.find(condition).sort(orderBy).skip(start).limit(PaginationContext.getPageSize());
			CurrentMake fund = null;
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				fund = new CurrentMake();
				try {
					String string = dbObj.toString();
					fund=JSON.parseObject(string, CurrentMake.class);
					//BeanUtil.dbObject2Bean(dbObj, fund);
					Subzh user = subzhservice.getTradeUserOne(fund.getSub_zh());
					if (user != null) {
						fund.setChannel(user.getChannelname());
						fund.setAgentzh(user.getAgentname());
						fund.setBroker(user.getBrokername());
						//fund.setUsername(user.getName());
					}
					holdList.add(fund);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			hpage.setList(holdList);
			hpage.setCountsize(Long.valueOf(String.valueOf(totalCount)));
			hpage.setPagecount(hpage.getCountsize());
			model.addAttribute("status", 0);
			model.addAttribute("page", hpage);
		} catch (Exception e) {
			model.addAttribute("status", 1);
			model.addAttribute("describe", "查询当日成交记录出错");
			e.printStackTrace();
		}
		model.addAttribute("lsflag", trade.getLsflag());
		return "fund/currDealList";

	}

	public static void main(String[] args) {
		/*
		 * String data=
		 * "[{\"current_vol\":200,\"enable_vol\":200,\"entrust_bs\":0,\"exchange_type\":0,\"income_balance\":203.9998474121099,\"keep_cost_price\":21.280,\"last_price\":22.30,\"position_id\":\"\",\"stock_code\":\"000034\",\"stock_name\":\"神州数码\",\"stop_loss\":0.0,\"stop_profit\":0.0},{\"current_vol\":200,\"enable_vol\":200,\"entrust_bs\":0,\"exchange_type\":0,\"income_balance\":-111.9999847412110,\"keep_cost_price\":25.480,\"last_price\":24.920,\"position_id\":\"\",\"stock_code\":\"002405\",\"stock_name\":\"四维图新\",\"stop_loss\":0.0,\"stop_profit\":0.0}]";
		 * //Holder hold=JSONObject.parseObject(obj.toJSONString(), Holder.class);
		 * List<Holder> list=JSONObject.parseArray(data, Holder.class); if(list!=null &&
		 * list.size()>0){ System.out.println("size:"+list.size()); Holder
		 * holder=list.get(0);
		 * System.out.println(holder.getStockCode()+holder.getStockName()+holder
		 * .getCurrentVol()); }else{ System.out.println("没有人"); }
		 */

		/*
		 * String minchage="0.000"; while(minchage.endsWith("0")){
		 * minchage=minchage.substring(0, minchage.length()-1); }
		 * if(minchage.endsWith(".")){ System.out.println("1"); }else{
		 * System.out.println("2"+",minchage:"+minchage); int
		 * index=minchage.indexOf("."); int i=minchage.length()-index-1;
		 * System.out.println("index:"+index+",i:"+i); }
		 */
		BigDecimal b = new BigDecimal("4.56");
		double d = b.setScale(0, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(d);
	}

	/**
	 * 
	 * @return
	 * @author heqiwen
	 * @date 2018-5-23
	 * @decribe 查询机构，平台，渠道，代理商或经纪人下的交易用户
	 * @param trade
	 * @param manage
	 * @return
	 */
	private List<Subzh> getJyusers(TradeParam trade) {
		Subzh sub = new Subzh();
		if (!StringUtil.isAnyNullOrEmpty(trade.getBroker())) {//
			sub.setAllocbroker(trade.getBroker());
			sub.setIsadmin(6);
		} else if (!StringUtil.isAnyNullOrEmpty(trade.getAgentzh())) {//
			sub.setAllocagent(trade.getAgentzh());
			sub.setIsadmin(6);
		} else if (!StringUtil.isAnyNullOrEmpty(trade.getChannel())) {//
			sub.setAllocchannel(trade.getChannel());
			sub.setIsadmin(6);
		} else {
			if (!StringUtil.isAnyNullOrEmpty(trade.getPt())) {
				sub.setAllocpt(trade.getPt());
			} else {
				sub.setManage(trade.getJg());
			}
			sub.setIsadmin(6);
		}
		List<Subzh> userlist = subzhservice.getTradeUserList(sub);
		return userlist;
	}

	/**
	 * 
	 * @param condition
	 * @param numb
	 * @return
	 * @author heqiwen
	 * @date 2018年4月11日
	 * @description 调用柜台接口
	 */
	public JSONObject invokeCounter(String s, int numb) {
		JSONObject obj = new JSONObject();
		try {
			log.info("功能号为" + numb + "调接口的入参：" + s);
			String rbStr = simulateStockService.commonFunction(s, numb);// 历史委托查询
			log.info("功能号为" + numb + "的接口，返回rbStr为：" + rbStr);
			// System.out.println(condition.get("client_id")+"功能号为"+numb+"的接口，返回rbStr为："+rbStr);
			if (rbStr == null || rbStr == "null" || rbStr.equals("")) {
				rbStr = "{\"status\":10,\"describe\":\"地址错误或网络错误\"}";
				obj = JSONObject.parseObject(rbStr);
			} else if (rbStr.indexOf("{") < 0) {
				rbStr = "{\"status\":11,\"describe\":\"返回信息出错\"}";
				obj = JSONObject.parseObject(rbStr);
			} else {// 正常情况下
				obj = JSONObject.parseObject(rbStr);

			}
		} catch (JSONException e) {

			e.printStackTrace();
		} catch (BussinessException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return obj;
	}

	///////////////////////////////////////// 历史查询数据/////////////////////////////////////////////////////////
	/**
	 * 
	 * @return
	 * @author heqiwen
	 * @date 2018-5-29
	 * @decribe 查询历史资金信息
	 * @param trade
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/getLsFund")
	public String getFundLsList(TradeParam trade, HttpSession session, Model model, String[] subzhs) {
		try {
			long totalCount = 0;
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin = (Integer) session.getAttribute(Constant.SESSION_ISADMIN);
			int start = (PaginationContext.getPageNum() - 1) * PaginationContext.getPageSize();
			int limit = PaginationContext.getPageNum() * PaginationContext.getPageSize();
			Page<FundMessage> fundPage = new Page<FundMessage>();
			fundPage.setPagenum(PaginationContext.getPageNum());
			fundPage.setPagesize(PaginationContext.getPageSize());
			List<FundMessage> fmList = new ArrayList<FundMessage>();
			DB db = dsForStock.getDB();
			DBCollection dbCollection = db.getCollection("history_fund");// 历史资金信息
			DBObject condition = new BasicDBObject();
			if (!StringUtil.isAnyNullOrEmpty(trade.getSubzh())) {
				condition.put("subzh", new BasicDBObject("$eq", trade.getSubzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getBroker())) {
				condition.put("broker", new BasicDBObject("$eq", trade.getBroker()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getAgentzh())) {
				condition.put("agentzh", new BasicDBObject("$eq", trade.getAgentzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getChannel())) {
				condition.put("channel", new BasicDBObject("$eq", trade.getChannel()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getPt())) {
				condition.put("pt", new BasicDBObject("$eq", trade.getPt()));
			}
			if (trade.getExchange() != null) {
				condition.put("exchange", new BasicDBObject("$eq", trade.getExchange()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockCode())) {
				condition.put("stockCode", new BasicDBObject("$eq", trade.getStockCode()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockName())) {
				condition.put("stockName", new BasicDBObject("$eq", trade.getStockName()));
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getStarttime())){
				trade.setStarttime("2018-01-01");
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getEndtime())){
				trade.setEndtime(DateUtil.dateFormat(new Date(), "yyyy-MM-dd"));
			}
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
			String startdate = df2.format(df1.parse(trade.getStarttime()));
			String enddate = df2.format(df1.parse(trade.getEndtime()));
			BasicDBList values = new BasicDBList();  
		    values.add(new BasicDBObject("settleDate", new BasicDBObject("$gte", Integer.parseInt(startdate))));  
		    values.add(new BasicDBObject("settleDate", new BasicDBObject("$lte", Integer.parseInt(enddate))));  
		    condition.put("$and", values);
						
			/*if (!StringUtil.isAnyNullOrEmpty(trade.getStarttime())
					|| !StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
				if (!StringUtil.isAnyNullOrEmpty(trade.getStarttime())) {
					String startdate = df2.format(df1.parse(trade.getStarttime()));
					condition.put("settleDate", new BasicDBObject("$gte", Integer.parseInt(startdate)));
				}
				if (!StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
					String enddate = df2.format(df1.parse(trade.getEndtime()));
					condition.put("settleDate", new BasicDBObject("$lte", Integer.parseInt(enddate)));
				}
			}*/
			if (isAdmin != null) {
				if (isAdmin == 3) {
					condition.put("channel", new BasicDBObject("$eq", username));
				} else if (isAdmin == 4) {
					condition.put("agentzh", new BasicDBObject("$eq", username));
				} else if (isAdmin == 5) {
					condition.put("broker", new BasicDBObject("$eq", username));
				}
			}

			DBObject orderBy = new BasicDBObject();
			orderBy.put("settleDate", -1);// 按tradedate倒序排
			totalCount = dbCollection.count(condition);
			DBCursor cursor = dbCollection.find(condition).sort(orderBy).skip(start)
					.limit(PaginationContext.getPageSize());
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				
				String string = dbObj.toString();
				FundMessage fund=JSON.parseObject(string, FundMessage.class);
				//FundMessage fund = new FundMessage();
				//BeanUtil.dbObject2Bean(dbObj, fund);
				int settledate = dbObj.getInt("settleDate");
				String date = String.valueOf(settledate);
				if (settledate > 10000000) {
					String settletime = date.substring(0, 4) + "." + date.substring(4, 6) + "." + date.substring(6);
					fund.setSettleTime(settletime);
				} else if (date.length() == 7) {
					String settletime = date.substring(0, 4) + "." + date.substring(4, 5) + "." + date.substring(5);
					fund.setSettleTime(settletime);
				}
				// 可用资金enableBalance

				fmList.add(fund);
			}
			fundPage.setList(fmList);
			fundPage.setCountsize(totalCount);
			fundPage.setPagecount(totalCount);
			model.addAttribute("page", fundPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("lsflag", trade.getLsflag());
		model.addAttribute("status", 0);
		return "fund/lsfundtable";
	}
	//统计历史资金
	@RequestMapping("/getCountLsFund")
	@ResponseBody
	public Map<String, Object> getCountLsFund(TradeParam trade, HttpSession session, Model model, String[] subzhs) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Double countPreFundBalance =0.00;//当日结存汇总
			Double countOutcomingBalance =0.00;//当日出金汇总
			Double countIncomingBalance =0.00;//当日入金汇总
			Double countFreezeBalance =0.00;//占用保证金汇总
			Double countFee =0.00;//收费总额汇总
			Double countTotalCloseprofit =0.00;//平仓盈亏汇总
			Double countTotalFloatprofit =0.00;//结算盈亏汇总
			long totalCount = 0;
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin = (Integer) session.getAttribute(Constant.SESSION_ISADMIN);
			DB db = dsForStock.getDB();
			DBCollection dbCollection = db.getCollection("history_fund");// 历史资金信息
			DBObject condition = new BasicDBObject();
			if (!StringUtil.isAnyNullOrEmpty(trade.getSubzh())) {
				condition.put("subzh", new BasicDBObject("$eq", trade.getSubzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getBroker())) {
				condition.put("broker", new BasicDBObject("$eq", trade.getBroker()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getAgentzh())) {
				condition.put("agentzh", new BasicDBObject("$eq", trade.getAgentzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getChannel())) {
				condition.put("channel", new BasicDBObject("$eq", trade.getChannel()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getPt())) {
				condition.put("pt", new BasicDBObject("$eq", trade.getPt()));
			}
			if (trade.getExchange() != null) {
				condition.put("exchange", new BasicDBObject("$eq", trade.getExchange()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockCode())) {
				condition.put("stockCode", new BasicDBObject("$eq", trade.getStockCode()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockName())) {
				condition.put("stockName", new BasicDBObject("$eq", trade.getStockName()));
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getStarttime())){
				trade.setStarttime("2018-01-01");
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getEndtime())){
				trade.setEndtime(DateUtil.dateFormat(new Date(), "yyyy-MM-dd"));
			}
			DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
			DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
			String startdate = df2.format(df1.parse(trade.getStarttime()));
			String enddate = df2.format(df1.parse(trade.getEndtime()));
			BasicDBList values = new BasicDBList();  
		    values.add(new BasicDBObject("settleDate", new BasicDBObject("$gte", Integer.parseInt(startdate))));  
		    values.add(new BasicDBObject("settleDate", new BasicDBObject("$lte", Integer.parseInt(enddate))));  
		    condition.put("$and", values);
			if (isAdmin != null) {
				if (isAdmin == 3) {
					condition.put("channel", new BasicDBObject("$eq", username));
				} else if (isAdmin == 4) {
					condition.put("agentzh", new BasicDBObject("$eq", username));
				} else if (isAdmin == 5) {
					condition.put("broker", new BasicDBObject("$eq", username));
				}
			}

			DBObject orderBy = new BasicDBObject();
			orderBy.put("settleDate", -1);// 按tradedate倒序排
			totalCount = dbCollection.count(condition);
			DBCursor cursor = dbCollection.find(condition).sort(orderBy);
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				
				String string = dbObj.toString();
				FundMessage fund=JSON.parseObject(string, FundMessage.class);
				countPreFundBalance+=fund.getPreFundBalance()==null?0:fund.getPreFundBalance();
				countOutcomingBalance+=fund.getOutcomingBalance()==null?0:fund.getOutcomingBalance();
				countIncomingBalance+=fund.getIncomingBalance()==null?0:fund.getIncomingBalance();
				countFreezeBalance+=fund.getFreezeBalance()==null?0:fund.getFreezeBalance();
				countFee+=fund.getFee()==null?0:fund.getFee();
				countTotalCloseprofit+=fund.getTotalCloseprofit()==null?0:fund.getTotalCloseprofit();
				countTotalFloatprofit+=fund.getTotalFloatprofit()==null?0:fund.getTotalFloatprofit();			
			}
			map.put("countPreFundBalance",countPreFundBalance);	
			map.put("countOutcomingBalance", countOutcomingBalance);	
			map.put("countIncomingBalance",countIncomingBalance);	
			map.put("countFreezeBalance",countFreezeBalance);	
			map.put("countFee",countFee);	
			map.put("countTotalCloseprofit",countTotalCloseprofit);	
			map.put("countTotalFloatprofit",countTotalFloatprofit);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 
	 * @return
	 * @author heqiwen
	 * @date 2018-5-29
	 * @decribe 查询历史持仓数据
	 * @param trade
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/getLsHold")
	public String getHolderLsList(TradeParam trade, HttpSession session, Model model) {
		try {
			long totalCount = 0;
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin = (Integer) session.getAttribute(Constant.SESSION_ISADMIN);
			int start = (PaginationContext.getPageNum() - 1) * PaginationContext.getPageSize();
			int limit = PaginationContext.getPageNum() * PaginationContext.getPageSize();
			Page<Holder> fundPage = new Page<Holder>();
			fundPage.setPagenum(PaginationContext.getPageNum());
			fundPage.setPagesize(PaginationContext.getPageSize());
			List<Holder> fmList = new ArrayList<Holder>();
			DB db = dsForStock.getDB();
			DBCollection dbCollection = db.getCollection("history_hold");// 历史持仓数据
			DBObject condition = new BasicDBObject();
			if (!StringUtil.isAnyNullOrEmpty(trade.getSubzh())) {
				condition.put("subzh", new BasicDBObject("$eq", trade.getSubzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getBroker())) {
				condition.put("broker", new BasicDBObject("$eq", trade.getBroker()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getAgentzh())) {
				condition.put("agentzh", new BasicDBObject("$eq", trade.getAgentzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getChannel())) {
				condition.put("channel", new BasicDBObject("$eq", trade.getChannel()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getPt())) {
				condition.put("pt", new BasicDBObject("$eq", trade.getPt()));
			}
			if (trade.getExchange() != null) {
				condition.put("mark", new BasicDBObject("$eq", trade.getExchange()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockCode())) {
				 Pattern pattern = Pattern.compile("^.*" + trade.getStockCode() + ".*$");
				condition.put("stockCode", pattern);
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockName())) {
				Pattern pattern = Pattern.compile("^.*" + trade.getStockName() + ".*$");
				condition.put("stockName", pattern);
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getStarttime())){
				trade.setStarttime("2018-01-01");
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getEndtime())){
				trade.setEndtime(DateUtil.dateFormat(new Date(), "yyyy-MM-dd"));
			}
			BasicDBList values = getIntegerValue(trade,"holderDate");  
		    condition.put("$and", values); 
			
			
			/*if (!StringUtil.isAnyNullOrEmpty(trade.getStarttime())
					|| !StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
				if (!StringUtil.isAnyNullOrEmpty(trade.getStarttime())) {
					String startdate = df2.format(df1.parse(trade.getStarttime()));
					condition.put("holderDate", new BasicDBObject("$gte", Integer.parseInt(startdate)));
				}
				if (!StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
					String enddate = df2.format(df1.parse(trade.getEndtime()));
					condition.put("holderDate", new BasicDBObject("$lte", Integer.parseInt(enddate)));
				}
			}*/
			if (isAdmin != null) {
				if (isAdmin == 3) {
					condition.put("channel", new BasicDBObject("$eq", username));
				} else if (isAdmin == 4) {
					condition.put("agentzh", new BasicDBObject("$eq", username));
				} else if (isAdmin == 5) {
					condition.put("broker", new BasicDBObject("$eq", username));
				}
			}
			DBObject orderBy = new BasicDBObject();
			orderBy.put("holderDate", -1);// 按tradedate倒序排
			totalCount = dbCollection.count(condition);
			DBCursor cursor = dbCollection.find(condition).sort(orderBy).skip(start)
					.limit(PaginationContext.getPageSize());
			Holder holder = null;
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				String string = dbObj.toString();
				holder=JSON.parseObject(string, Holder.class);
				
				//BeanUtil.dbObject2Bean(dbObj, holder);
				int settledate = dbObj.getInt("holderDate");
				String date = String.valueOf(settledate);
				if (settledate > 10000000) {
					String settletime = date.substring(0, 4) + "." + date.substring(4, 6) + "." + date.substring(6);
					holder.setHolderTime(settletime);
				} else if (date.length() == 7) {
					String settletime = date.substring(0, 4) + "." + date.substring(4, 5) + "." + date.substring(5);
					holder.setHolderTime(settletime);
				}
				if (holder.getEntrustBs() != null && holder.getEntrustBs() == 1) {
					holder.setFangx("卖出");
				} else {
					holder.setFangx("买入");
				}
				fmList.add(holder);
			}
			fundPage.setList(fmList);
			fundPage.setCountsize(totalCount);
			fundPage.setPagecount(totalCount);
			model.addAttribute("page", fundPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("status", 0);
		model.addAttribute("lsflag", trade.getLsflag());
		return "fund/holderlist";
	}

	// 历史持仓统计
	@RequestMapping("/getCountLsHold")
	@ResponseBody
	public Map<String, Object> getCountLsHold(TradeParam trade, HttpSession session) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			double countVol = 0;// 统计总持仓
			double countProfit = 0;//统计持仓盈亏
			long totalCount = 0;
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin = (Integer) session.getAttribute(Constant.SESSION_ISADMIN);
			DB db = dsForStock.getDB();
			DBCollection dbCollection = db.getCollection("history_hold");// 历史持仓数据
			DBObject condition = new BasicDBObject();
			if (!StringUtil.isAnyNullOrEmpty(trade.getSubzh())) {
				condition.put("subzh", new BasicDBObject("$eq", trade.getSubzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getBroker())) {
				condition.put("broker", new BasicDBObject("$eq", trade.getBroker()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getAgentzh())) {
				condition.put("agentzh", new BasicDBObject("$eq", trade.getAgentzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getChannel())) {
				condition.put("channel", new BasicDBObject("$eq", trade.getChannel()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getPt())) {
				condition.put("pt", new BasicDBObject("$eq", trade.getPt()));
			}
			if (trade.getExchange() != null) {
				condition.put("mark", new BasicDBObject("$eq", trade.getExchange()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockCode())) {
				 Pattern pattern = Pattern.compile("^.*" + trade.getStockCode() + ".*$");
				condition.put("stockCode", pattern);
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockName())) {
				Pattern pattern = Pattern.compile("^.*" + trade.getStockName() + ".*$");
				condition.put("stockName", pattern);
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getStarttime())){
				trade.setStarttime("2018-01-01");
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getEndtime())){
				trade.setEndtime(DateUtil.dateFormat(new Date(), "yyyy-MM-dd"));
			}
			BasicDBList values = getIntegerValue(trade,"holderDate");  
		    condition.put("$and", values); 
						
			if (isAdmin != null) {
				if (isAdmin == 3) {
					condition.put("channel", new BasicDBObject("$eq", username));
				} else if (isAdmin == 4) {
					condition.put("agentzh", new BasicDBObject("$eq", username));
				} else if (isAdmin == 5) {
					condition.put("broker", new BasicDBObject("$eq", username));
				}
			}
			DBObject orderBy = new BasicDBObject();
			orderBy.put("holderDate", -1);// 按tradedate倒序排
			totalCount = dbCollection.count(condition);
			DBCursor cursor = dbCollection.find(condition).sort(orderBy);
			Holder holder = null;
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				String string = dbObj.toString();
				holder=JSON.parseObject(string, Holder.class);
				countVol += holder.getCurrentVol() == null ? 0 : holder.getCurrentVol();
				countProfit += holder.getProfit() == null ? 0 : holder.getProfit();									
			}
			map.put("countVol", countVol);
			map.put("countProfit", countProfit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	return map;

}
	
	private BasicDBList getIntegerValue(TradeParam trade,String dataParam) throws ParseException {
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
		String startdate = df2.format(df1.parse(trade.getStarttime()));
		String enddate = df2.format(df1.parse(trade.getEndtime()));
		BasicDBList values = new BasicDBList();  
		values.add(new BasicDBObject(dataParam, new BasicDBObject("$gte", Integer.parseInt(startdate))));  
		values.add(new BasicDBObject(dataParam, new BasicDBObject("$lte", Integer.parseInt(enddate))));
		return values;
	}
	
	private BasicDBList getLongDateValue(TradeParam trade,String dataParam) throws ParseException {
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
		String startdate = df2.format(df1.parse(trade.getStarttime()));
		String enddate = df2.format(df1.parse(trade.getEndtime()));
		BasicDBList values = new BasicDBList();  
		values.add(new BasicDBObject(dataParam, new BasicDBObject("$gte", Long.parseLong(startdate + "000000"))));  
		values.add(new BasicDBObject(dataParam, new BasicDBObject("$lte", Long.parseLong(enddate + "235959"))));
		return values;
	}
		
	/**
	 * 
	 * @return
	 * @author heqiwen
	 * @date 2018-5-29
	 * @decribe 查询历史的委托记录
	 * @param trade
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/getLsEntrust")
	public String getEntrustLsList(TradeParam trade, HttpSession session, Model model) {
		try {
			long totalCount = 0;
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin = (Integer) session.getAttribute(Constant.SESSION_ISADMIN);
			int start = (PaginationContext.getPageNum() - 1) * PaginationContext.getPageSize();
			int limit = PaginationContext.getPageNum() * PaginationContext.getPageSize();
			Page<EntrustOrder> fundPage = new Page<EntrustOrder>();
			fundPage.setPagenum(PaginationContext.getPageNum());
			fundPage.setPagesize(PaginationContext.getPageSize());
			List<EntrustOrder> fmList = new ArrayList<EntrustOrder>();
			DB db = dsForStock.getDB();
			DBCollection dbCollection = db.getCollection("history_wt");// 历史委托记录
			DBObject condition = new BasicDBObject();
			if (!StringUtil.isAnyNullOrEmpty(trade.getSubzh())) {
				condition.put("subzh", new BasicDBObject("$eq", trade.getSubzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getBroker())) {
				condition.put("broker", new BasicDBObject("$eq", trade.getBroker()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getAgentzh())) {
				condition.put("agentzh", new BasicDBObject("$eq", trade.getAgentzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getChannel())) {
				condition.put("channel", new BasicDBObject("$eq", trade.getChannel()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getPt())) {
				condition.put("pt", new BasicDBObject("$eq", trade.getPt()));
			}
			if (trade.getExchange() != null) {
				condition.put("exchangeType", new BasicDBObject("$eq", trade.getExchange()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockCode())) {
				 Pattern pattern = Pattern.compile("^.*" + trade.getStockCode() + ".*$");
				condition.put("stockCode", pattern);
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockName())) {
				Pattern pattern = Pattern.compile("^.*" + trade.getStockName() + ".*$");
				condition.put("stockName", pattern);
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getStarttime())){
				trade.setStarttime("2018-01-01");
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getEndtime())){
				trade.setEndtime(DateUtil.dateFormat(new Date(), "yyyy-MM-dd"));
			}
			BasicDBList values = getLongDateValue(trade,"mentrusttime");  
		    condition.put("$and", values);
			
			/*if (!StringUtil.isAnyNullOrEmpty(trade.getStarttime())
					|| !StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
				if (!StringUtil.isAnyNullOrEmpty(trade.getStarttime())) {
					String startdate = df2.format(df1.parse(trade.getStarttime()));
					condition.put("mentrusttime", new BasicDBObject("$gte", Long.parseLong(startdate + "000000")));
				}
				if (!StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
					String enddate = df2.format(df1.parse(trade.getEndtime()));
					condition.put("mentrusttime", new BasicDBObject("$lte", Long.parseLong(enddate + "235959")));
				}
			}*/
			
			if (isAdmin != null) {
				if (isAdmin == 3) {
					condition.put("channel", new BasicDBObject("$eq", username));
				} else if (isAdmin == 4) {
					condition.put("agentzh", new BasicDBObject("$eq", username));
				} else if (isAdmin == 5) {
					condition.put("broker", new BasicDBObject("$eq", username));
				}
			}
			DBObject orderBy = new BasicDBObject();
			orderBy.put("mentrusttime", -1);// 按tradedate倒序排
			totalCount = dbCollection.count(condition);
			DBCursor cursor = dbCollection.find(condition).sort(orderBy).skip(start)
					.limit(PaginationContext.getPageSize());
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				//EntrustOrder entrust = new EntrustOrder();
				//BeanUtil.dbObject2Bean(dbObj, entrust);
				
				String string = dbObj.toString();
				EntrustOrder entrust=JSON.parseObject(string, EntrustOrder.class);
				
				long sdate = dbObj.getLong("mentrusttime");
				String date = String.valueOf(sdate);
				if (sdate > 10000000) {
					String entrusttime = date.substring(0, 4) + "." + date.substring(4, 6) + "." + date.substring(6, 8);
					entrust.setEntime(entrusttime);
					if (date.length() > 12) {
						String dealtime = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8)
								+ " " + date.substring(8, 10) + ":" + date.substring(10, 12) + ":" + date.substring(12);
						entrust.setDealtime(dealtime);
					} else {
						String dealtime = date.substring(0, 4) + "-" + date.substring(4, 6) + "-"
								+ date.substring(6, 8);
						entrust.setDealtime(dealtime);
					}

				}
				entrust.setEno(getStateName(entrust.getEntrustStatus()));
				fmList.add(entrust);
			}
			fundPage.setList(fmList);
			fundPage.setCountsize(totalCount);
			fundPage.setPagecount(totalCount);
			model.addAttribute("page", fundPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("status", 0);
		model.addAttribute("lsflag", trade.getLsflag());
		return "fund/entrustlist";
	}

	/**
	 * 
	 * @return
	 * @author heqiwen
	 * @date 2018-5-29
	 * @decribe 查询历史成交记录
	 * @param trade
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/getLsDeal")
	public String getDealcjLsList(TradeParam trade, HttpSession session, Model model) {
		try {
			long totalCount = 0;
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin = (Integer) session.getAttribute(Constant.SESSION_ISADMIN);
			int start = (PaginationContext.getPageNum() - 1) * PaginationContext.getPageSize();
			int limit = PaginationContext.getPageNum() * PaginationContext.getPageSize();
			Page<DealCj> fundPage = new Page<DealCj>();
			fundPage.setPagenum(PaginationContext.getPageNum());
			fundPage.setPagesize(PaginationContext.getPageSize());
			List<DealCj> fmList = new ArrayList<DealCj>();
			DB db = dsForStock.getDB();
			DBCollection dbCollection = db.getCollection("history_cj");// 历史成交记录
			DBObject condition = new BasicDBObject();
			if (!StringUtil.isAnyNullOrEmpty(trade.getSubzh())) {
				condition.put("subzh", new BasicDBObject("$eq", trade.getSubzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getBroker())) {
				condition.put("broker", new BasicDBObject("$eq", trade.getBroker()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getAgentzh())) {
				condition.put("agentzh", new BasicDBObject("$eq", trade.getAgentzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getChannel())) {
				condition.put("channel", new BasicDBObject("$eq", trade.getChannel()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getPt())) {
				condition.put("pt", new BasicDBObject("$eq", trade.getPt()));
			}
			if (trade.getExchange() != null) {
				condition.put("exchangeType", new BasicDBObject("$eq", trade.getExchange()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockCode())) {
				 Pattern pattern = Pattern.compile("^.*" + trade.getStockCode() + ".*$");
				condition.put("stockCode", pattern);
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockName())) {
				Pattern pattern = Pattern.compile("^.*" + trade.getStockName() + ".*$");
				condition.put("stockName", pattern);
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getStarttime())){
				trade.setStarttime("2018-01-01");
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getEndtime())){
				trade.setEndtime(DateUtil.dateFormat(new Date(), "yyyy-MM-dd"));
			}
			BasicDBList values = getLongDateValue(trade,"mdealtime");  
		    condition.put("$and", values);
			
			/*if (!StringUtil.isAnyNullOrEmpty(trade.getStarttime())
					|| !StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
				if (!StringUtil.isAnyNullOrEmpty(trade.getStarttime())) {
					String startdate = df2.format(df1.parse(trade.getStarttime()));
					condition.put("mdealtime", new BasicDBObject("$gte", Long.parseLong(startdate + "000000")));
				}
				if (!StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
					String enddate = df2.format(df1.parse(trade.getEndtime()));
					condition.put("mdealtime", new BasicDBObject("$lte", Long.parseLong(enddate + "235959")));
				}
			}*/
			if (isAdmin != null) {
				if (isAdmin == 3) {
					condition.put("channel", new BasicDBObject("$eq", username));
				} else if (isAdmin == 4) {
					condition.put("agentzh", new BasicDBObject("$eq", username));
				} else if (isAdmin == 5) {
					condition.put("broker", new BasicDBObject("$eq", username));
				}
			}
			DBObject orderBy = new BasicDBObject();
			orderBy.put("mdealtime", -1);// 按tradedate倒序排
			totalCount = dbCollection.count(condition);
			DBCursor cursor = dbCollection.find(condition).sort(orderBy).skip(start)
					.limit(PaginationContext.getPageSize());
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				//DealCj deal = new DealCj();
				//BeanUtil.dbObject2Bean(dbObj, deal);
				
				String string = dbObj.toString();
				DealCj deal=JSON.parseObject(string, DealCj.class);
				
				long sdate = dbObj.getLong("mdealtime");
				String date = String.valueOf(sdate);
				if (sdate > 10000000) {
					String dealcjtime = date.substring(0, 4) + "." + date.substring(4, 6) + "." + date.substring(6, 8);
					deal.setDealcjtime(dealcjtime);
					String eorderno = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
					if (date.length() > 8) {
						eorderno = eorderno + " " + date.substring(8, 10) + ":" + date.substring(10, 12) + ":"
								+ date.substring(12);
					}
					deal.setOrdertime(eorderno);
				}
				fmList.add(deal);
			}
			Integer lsflag = trade.getLsflag();
			fundPage.setList(fmList);
			fundPage.setCountsize(totalCount);
			fundPage.setPagecount(totalCount);
			model.addAttribute("page", fundPage);
		} catch (Exception e) {
			log.error("查询历史成交异常", e);
			e.printStackTrace();
		}
		model.addAttribute("status", 0);
		model.addAttribute("lsflag", trade.getLsflag());
		return "fund/deallist";
	}
	
	
	
	// 历史成交统计
		@RequestMapping("/getCountdeal")
		@ResponseBody
		public Map<String, Object> getCountdeal(TradeParam trade, HttpSession session) {
			Map<String, Object> map = new HashMap<String, Object>();
			try {
				double countVol = 0;// 统计成交总数
				double countFee = 0;
				double countAmout = 0;
				long totalCount = 0;
				String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
				String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
				Integer isAdmin = (Integer) session.getAttribute(Constant.SESSION_ISADMIN);
				List<DealCj> fmList = new ArrayList<DealCj>();
				DB db = dsForStock.getDB();
				DBCollection dbCollection = db.getCollection("history_cj");// 历史成交记录
				DBObject condition = new BasicDBObject();
				if (!StringUtil.isAnyNullOrEmpty(trade.getSubzh())) {
					Pattern pattern = Pattern.compile("^.*" + trade.getSubzh() + ".*$");
					condition.put("subzh", pattern);
					// condition.put("subzh", new BasicDBObject("$eq",
					// trade.getSubzh()));
				}
				if (!StringUtil.isAnyNullOrEmpty(trade.getBroker())) {
					condition.put("broker", new BasicDBObject("$eq", trade.getBroker()));
				}
				if (!StringUtil.isAnyNullOrEmpty(trade.getAgentzh())) {
					condition.put("agentzh", new BasicDBObject("$eq", trade.getAgentzh()));
				}
				if (!StringUtil.isAnyNullOrEmpty(trade.getChannel())) {
					condition.put("channel", new BasicDBObject("$eq", trade.getChannel()));
				}
				if (!StringUtil.isAnyNullOrEmpty(trade.getPt())) {
					condition.put("pt", new BasicDBObject("$eq", trade.getPt()));
				}
				if (trade.getExchange() != null) {
					condition.put("exchangeType", new BasicDBObject("$eq", trade.getExchange()));
				}
				if (!StringUtil.isAnyNullOrEmpty(trade.getStockCode())) {
					Pattern pattern = Pattern.compile("^.*" + trade.getStockCode() + ".*$");
					condition.put("stockCode", pattern);
					// condition.put("stockCode", new BasicDBObject("$eq",
					// trade.getStockCode()));
				}
				if (!StringUtil.isAnyNullOrEmpty(trade.getStockName())) {
					Pattern pattern = Pattern.compile("^.*" + trade.getStockName() + ".*$");
					condition.put("stockName", pattern);
					// condition.put("stockName", new BasicDBObject("$eq",
					// trade.getStockName()));
				}

				if (StringUtil.isAnyNullOrEmpty(trade.getStarttime())) {
					trade.setStarttime("2018-01-01");
				}

				if (StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
					trade.setEndtime(DateUtil.dateFormat(new Date(), "yyyy-MM-dd"));
				}
				BasicDBList values = getLongDateValue(trade, "mdealtime");
				condition.put("$and", values);
				if (isAdmin != null) {
					if (isAdmin == 3) {
						condition.put("channel", new BasicDBObject("$eq", username));
					} else if (isAdmin == 4) {
						condition.put("agentzh", new BasicDBObject("$eq", username));
					} else if (isAdmin == 5) {
						condition.put("broker", new BasicDBObject("$eq", username));
					}
				}
				DBObject orderBy = new BasicDBObject();
				orderBy.put("mdealtime", -1);// 按tradedate倒序排
				totalCount = dbCollection.count(condition);
				DBCursor cursor = dbCollection.find(condition).sort(orderBy);
				while (cursor.hasNext()) {
					BasicDBObject dbObj = (BasicDBObject) cursor.next();
					String string = dbObj.toString();
					DealCj deal = JSON.parseObject(string, DealCj.class);

					countVol += deal.getBusinessVol() == null ? 0 : deal.getBusinessVol();
					countFee += deal.getFee() == null ? 0 : deal.getFee();
					countAmout += deal.getOccurBalance() == null ? 0 : deal.getOccurBalance();
				}

				map.put("countVol", countVol);
				map.put("countFee", countFee);
				map.put("countAmout", countAmout);
			} catch (Exception e) {
				e.printStackTrace();
			}
			log.info("countVol --统计手数" + map.get("countVol") + "\n" + "countFee --统计手续费" + map.get("countFee") + "\n"
					+ "countAmout --统计盈亏" + map.get("countAmout"));
			return map;

		}
	
	///////////////////////////////////////// 导出报表/////////////////////////////////////////////////////////
	/**
	 * 
	 * @return
	 * @author heqiwen
	 * @date 2018-5-29
	 * @decribe 导出查询历史资金信息
	 * @param trade
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/exportLsFund")
	@ResponseBody
	public void exportFundLsList(TradeParam trade, HttpSession session, Model model, HttpServletResponse response) {
		try {
			long totalCount = 0;
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin = (Integer) session.getAttribute(Constant.SESSION_ISADMIN);
			int start = (PaginationContext.getPageNum() - 1) * PaginationContext.getPageSize();
			int limit = PaginationContext.getPageNum() * PaginationContext.getPageSize();
			// Page<FundMessage> fundPage=new Page<FundMessage>();
			// fundPage.setPagenum(PaginationContext.getPageNum());
			// fundPage.setPagesize(PaginationContext.getPageSize());
			List<FundMessage> fmList = new ArrayList<FundMessage>();
			DB db = dsForStock.getDB();
			DBCollection dbCollection = db.getCollection("history_fund");// 历史资金信息
			DBObject condition = new BasicDBObject();
			if (!StringUtil.isAnyNullOrEmpty(trade.getSubzh())) {
				condition.put("subzh", new BasicDBObject("$eq", trade.getSubzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getBroker())) {
				condition.put("broker", new BasicDBObject("$eq", trade.getBroker()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getAgentzh())) {
				condition.put("agentzh", new BasicDBObject("$eq", trade.getAgentzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getChannel())) {
				condition.put("channel", new BasicDBObject("$eq", trade.getChannel()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getPt())) {
				condition.put("pt", new BasicDBObject("$eq", trade.getPt()));
			}
			if (trade.getExchange() != null) {
				condition.put("exchange", new BasicDBObject("$eq", trade.getExchange()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockCode())) {
				 Pattern pattern = Pattern.compile("^.*" + trade.getStockCode() + ".*$");
				condition.put("stockCode", pattern);
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockName())) {
				Pattern pattern = Pattern.compile("^.*" + trade.getStockName() + ".*$");
				condition.put("stockName", pattern);
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getStarttime())){
				trade.setStarttime("2018-01-01");
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getEndtime())){
				trade.setEndtime(DateUtil.dateFormat(new Date(), "yyyy-MM-dd"));
			}
			BasicDBList values = getIntegerValue(trade,"settleDate");  
		    condition.put("$and", values);
			
			/*if (!StringUtil.isAnyNullOrEmpty(trade.getStarttime())
					|| !StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
				if (!StringUtil.isAnyNullOrEmpty(trade.getStarttime())) {
					String startdate = df2.format(df1.parse(trade.getStarttime()));
					condition.put("settleDate", new BasicDBObject("$gte", Integer.parseInt(startdate)));
				}
				if (!StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
					String enddate = df2.format(df1.parse(trade.getEndtime()));
					condition.put("settleDate", new BasicDBObject("$lte", Integer.parseInt(enddate)));
				}
			}*/
			if (isAdmin != null) {
				if (isAdmin == 3) {
					condition.put("channel", new BasicDBObject("$eq", username));
				} else if (isAdmin == 4) {
					condition.put("agentzh", new BasicDBObject("$eq", username));
				} else if (isAdmin == 5) {
					condition.put("broker", new BasicDBObject("$eq", username));
				}
			}

			DBObject orderBy = new BasicDBObject();
			orderBy.put("settleDate", -1);// 按tradedate倒序排
			totalCount = dbCollection.count(condition);
			DBCursor cursor = dbCollection.find(condition).sort(orderBy)/*.skip(start)
					.limit(500)*/;
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				String string = dbObj.toString();
				FundMessage fund=JSON.parseObject(string, FundMessage.class);
				//FundMessage fund = new FundMessage();
				//BeanUtil.dbObject2Bean(dbObj, fund);
				int settledate = dbObj.getInt("settleDate");
				String date = String.valueOf(settledate);
				if (settledate > 10000000) {
					String settletime = date.substring(0, 4) + "." + date.substring(4, 6) + "." + date.substring(6);
					fund.setSettleTime(settletime);
				} else if (date.length() == 7) {
					String settletime = date.substring(0, 4) + "." + date.substring(4, 5) + "." + date.substring(5);
					fund.setSettleTime(settletime);
				}
				// 可用资金enableBalance
				fmList.add(fund);
			}
			SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日");
			JSONArray ja = new JSONArray();// 获取业务数据集
			ja.addAll(fmList);
			Map<String, String> headMap = new LinkedHashMap<String, String>();
			headMap.put("settleTime", "日期");
			headMap.put("subzh", "用户账号");
			headMap.put("channelname", "所属渠道");
			headMap.put("agentname", "所属代理商");
			headMap.put("brokername", "所属经纪人");

			headMap.put("preFundBalance", "当日结存");
			headMap.put("outcomingBalance", "出金");
			headMap.put("incomingBalance", "入金");
			headMap.put("freezeBalance", "占用保证金");
			headMap.put("fee", "手续费总额");
			headMap.put("totalCloseprofit", "平仓盈亏");
			headMap.put("totalFloatprofit", "结算盈亏");
			headMap.put("rate", "风险率(%)");
			MyExcelUtil.downloadExcelFile("资金流水" + myFmt.format(new Date()), headMap, ja, "yyyy-MM-dd HH:mm:ss", 0,
					response);
		} catch (Exception e) {
			log.info("数据导出异常");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 * @author heqiwen
	 * @date 2018-5-29
	 * @decribe 导出历史持仓数据
	 * @param trade
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/exportLsHold")
	public String getHolderLsList(TradeParam trade, HttpSession session, HttpServletResponse response) {
		try {
			long totalCount = 0;
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin = (Integer) session.getAttribute(Constant.SESSION_ISADMIN);
			int start = (PaginationContext.getPageNum() - 1) * PaginationContext.getPageSize();
			int limit = PaginationContext.getPageNum() * PaginationContext.getPageSize();
			Page<Holder> fundPage = new Page<Holder>();
			fundPage.setPagenum(PaginationContext.getPageNum());
			fundPage.setPagesize(PaginationContext.getPageSize());
			List<Holder> fmList = new ArrayList<Holder>();
			DB db = dsForStock.getDB();
			DBCollection dbCollection = db.getCollection("history_hold");// 历史持仓数据
			DBObject condition = new BasicDBObject();
			if (!StringUtil.isAnyNullOrEmpty(trade.getSubzh())) {
				condition.put("subzh", new BasicDBObject("$eq", trade.getSubzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getBroker())) {
				condition.put("broker", new BasicDBObject("$eq", trade.getBroker()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getAgentzh())) {
				condition.put("agentzh", new BasicDBObject("$eq", trade.getAgentzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getChannel())) {
				condition.put("channel", new BasicDBObject("$eq", trade.getChannel()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getPt())) {
				condition.put("pt", new BasicDBObject("$eq", trade.getPt()));
			}
			if (trade.getExchange() != null) {
				condition.put("mark", new BasicDBObject("$eq", trade.getExchange()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockCode())) {
				 Pattern pattern = Pattern.compile("^.*" + trade.getStockCode() + ".*$");
				condition.put("stockCode", pattern);
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockName())) {
				Pattern pattern = Pattern.compile("^.*" + trade.getStockName() + ".*$");
				condition.put("stockName", pattern);
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getStarttime())){
				trade.setStarttime("2018-01-01");
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getEndtime())){
				trade.setEndtime(DateUtil.dateFormat(new Date(), "yyyy-MM-dd"));
			}
			
			BasicDBList values = getIntegerValue(trade,"holderDate");  
		    condition.put("$and", values);
			
			/*if (!StringUtil.isAnyNullOrEmpty(trade.getStarttime())
					|| !StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
				if (!StringUtil.isAnyNullOrEmpty(trade.getStarttime())) {
					String startdate = df2.format(df1.parse(trade.getStarttime()));
					condition.put("holderDate", new BasicDBObject("$gte", Integer.parseInt(startdate)));
				}
				if (!StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
					String enddate = df2.format(df1.parse(trade.getEndtime()));
					condition.put("holderDate", new BasicDBObject("$lte", Integer.parseInt(enddate)));
				}
			}*/
			if (isAdmin != null) {
				if (isAdmin == 3) {
					condition.put("channel", new BasicDBObject("$eq", username));
				} else if (isAdmin == 4) {
					condition.put("agentzh", new BasicDBObject("$eq", username));
				} else if (isAdmin == 5) {
					condition.put("broker", new BasicDBObject("$eq", username));
				}
			}
			DBObject orderBy = new BasicDBObject();
			orderBy.put("holderDate", -1);// 按tradedate倒序排
			totalCount = dbCollection.count(condition);
			DBCursor cursor = dbCollection.find(condition).sort(orderBy)/*.skip(start)
					.limit(PaginationContext.getPageSize())*/;
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				String string = dbObj.toString();
				Holder holder=JSON.parseObject(string, Holder.class);
				int settledate = dbObj.getInt("holderDate");
				String date = String.valueOf(settledate);
				if (settledate > 10000000) {
					String settletime = date.substring(0, 4) + "." + date.substring(4, 6) + "." + date.substring(6);
					holder.setHolderTime(settletime);
				} else if (date.length() == 7) {
					String settletime = date.substring(0, 4) + "." + date.substring(4, 5) + "." + date.substring(5);
					holder.setHolderTime(settletime);
				}
				if (holder.getEntrustBs() != null && holder.getEntrustBs() == 1) {
					holder.setFangx("卖出");
				} else {
					holder.setFangx("买入");
				}
				fmList.add(holder);
			}
			SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日");
			JSONArray ja = new JSONArray();// 获取业务数据集
			ja.addAll(fmList);
			Map<String, String> headMap = new LinkedHashMap<String, String>();
			headMap.put("holderTime", "日期");
			headMap.put("subzh", "用户账号");
			headMap.put("channelname", "所属渠道");
			headMap.put("agentname", "所属代理商");
			headMap.put("brokername", "所属经纪人");

			headMap.put("stockCode", "合约代码");
			headMap.put("stockName", "合约名称");
			headMap.put("fangx", "方向");
			headMap.put("currentVol", "总持仓");
			headMap.put("keepCostPrice", "持仓均价");
			headMap.put("profit", "持仓盈亏");
			MyExcelUtil.downloadExcelFile("历史持仓" + myFmt.format(new Date()), headMap, ja, "yyyy-MM-dd HH:mm:ss", 0,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @return
	 * @author heqiwen
	 * @date 2018-5-29
	 * @decribe 导出历史的委托记录
	 * @param trade
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/exportLsEntrust")
	public String getEntrustLsList(TradeParam trade, HttpSession session, HttpServletResponse response) {
		try {
			long totalCount = 0;
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin = (Integer) session.getAttribute(Constant.SESSION_ISADMIN);
			int start = (PaginationContext.getPageNum() - 1) * PaginationContext.getPageSize();
			int limit = PaginationContext.getPageNum() * PaginationContext.getPageSize();
			Page<EntrustOrder> fundPage = new Page<EntrustOrder>();
			fundPage.setPagenum(PaginationContext.getPageNum());
			fundPage.setPagesize(PaginationContext.getPageSize());
			List<EntrustOrder> fmList = new ArrayList<EntrustOrder>();
			DB db = dsForStock.getDB();
			DBCollection dbCollection = db.getCollection("history_wt");// 历史委托记录
			DBObject condition = new BasicDBObject();
			if (!StringUtil.isAnyNullOrEmpty(trade.getSubzh())) {
				condition.put("subzh", new BasicDBObject("$eq", trade.getSubzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getBroker())) {
				condition.put("broker", new BasicDBObject("$eq", trade.getBroker()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getAgentzh())) {
				condition.put("agentzh", new BasicDBObject("$eq", trade.getAgentzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getChannel())) {
				condition.put("channel", new BasicDBObject("$eq", trade.getChannel()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getPt())) {
				condition.put("pt", new BasicDBObject("$eq", trade.getPt()));
			}
			if (trade.getExchange() != null) {
				condition.put("exchangeType", new BasicDBObject("$eq", trade.getExchange()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockCode())) {
				 Pattern pattern = Pattern.compile("^.*" + trade.getStockCode() + ".*$");
				condition.put("stockCode", pattern);
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockName())) {
				Pattern pattern = Pattern.compile("^.*" + trade.getStockName() + ".*$");
				condition.put("stockName", pattern);
			}
			
			
			if(StringUtil.isAnyNullOrEmpty(trade.getStarttime())){
				trade.setStarttime("2018-01-01");
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getEndtime())){
				trade.setEndtime(DateUtil.dateFormat(new Date(), "yyyy-MM-dd"));
			}
			BasicDBList values = getLongDateValue(trade,"mentrusttime");  
		    condition.put("$and", values);
			
			/*if (!StringUtil.isAnyNullOrEmpty(trade.getStarttime())
					|| !StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
				if (!StringUtil.isAnyNullOrEmpty(trade.getStarttime())) {
					String startdate = df2.format(df1.parse(trade.getStarttime()));
					condition.put("mentrusttime", new BasicDBObject("$gte", Long.parseLong(startdate + "000000")));
				}
				if (!StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
					String enddate = df2.format(df1.parse(trade.getEndtime()));
					condition.put("mentrusttime", new BasicDBObject("$lte", Long.parseLong(enddate + "235959")));
				}
			}*/
			
			
			
			
			if (isAdmin != null) {
				if (isAdmin == 3) {
					condition.put("channel", new BasicDBObject("$eq", username));
				} else if (isAdmin == 4) {
					condition.put("agentzh", new BasicDBObject("$eq", username));
				} else if (isAdmin == 5) {
					condition.put("broker", new BasicDBObject("$eq", username));
				}
			}
			DBObject orderBy = new BasicDBObject();
			orderBy.put("mentrusttime", -1);// 按tradedate倒序排
			totalCount = dbCollection.count(condition);
			DBCursor cursor = dbCollection.find(condition).sort(orderBy)/*.skip(start)
					.limit(PaginationContext.getPageSize())*/;
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				String string = dbObj.toString();
				EntrustOrder entrust=JSON.parseObject(string, EntrustOrder.class);
				long sdate = dbObj.getLong("mentrusttime");
				String date = String.valueOf(sdate);
				if (sdate > 10000000) {
					String entrusttime = date.substring(0, 4) + "." + date.substring(4, 6) + "." + date.substring(6, 8);
					entrust.setEntime(entrusttime);
					if (date.length() > 12) {
						String dealtime = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8)
								+ " " + date.substring(8, 10) + ":" + date.substring(10, 12) + ":" + date.substring(12);
						entrust.setDealtime(dealtime);
					} else {
						String dealtime = date.substring(0, 4) + "-" + date.substring(4, 6) + "-"
								+ date.substring(6, 8);
						entrust.setDealtime(dealtime);
					}

				}
				entrust.setEno(getStateName(entrust.getEntrustStatus()));
				if (entrust.getEntrustBs() == 1) {
					entrust.setCmd("卖出");
				} else {
					entrust.setCmd("买入");
				}
				if (entrust.getDirectionType() == 0) {
					entrust.setMark("开仓");
				} else if (entrust.getDirectionType() == 1) {
					entrust.setMark("平仓");
				} else if (entrust.getDirectionType() == 2) {
					entrust.setMark("平今");
				} else if (entrust.getDirectionType() == 3) {
					entrust.setMark("平昨");
				}
				fmList.add(entrust);
			}
			SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日");
			JSONArray ja = new JSONArray();// 获取业务数据集
			ja.addAll(fmList);
			Map<String, String> headMap = new LinkedHashMap<String, String>();
			headMap.put("entime", "日期");
			headMap.put("subzh", "用户账号");
			headMap.put("channelname", "所属渠道");
			headMap.put("agentname", "所属代理商");
			headMap.put("brokername", "所属经纪人");
			headMap.put("exchangeTypeShift", "市场");
			headMap.put("stockCode", "合约代码");
			headMap.put("stockName", "合约名称");
			headMap.put("cmd", "方向");
			headMap.put("mark", "开平");
			headMap.put("eno", "状态");
			headMap.put("entrustPrice", "委托价格");
			headMap.put("entrustVol", "委托数量");
			headMap.put("businessVol", "已成数量");
			headMap.put("businessPrice", "已成均价");
			headMap.put("dealtime", "下单时间");
			MyExcelUtil.downloadExcelFile("历史委托" + myFmt.format(new Date()), headMap, ja, "yyyy-MM-dd HH:mm:ss", 0,
					response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/// 格式化小数，
	private Double formateDouble(Double d) {
		if (d == null) {
			return 0.00;
		}
		BigDecimal b = new BigDecimal(String.valueOf(d));
		double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}

	private String getStateName(int status) {
		String state = "";
		if (status == 0) {
			state = "已报";
		} else if (status == 1) {
			state = "已撤";
		} else if (status == 2) {
			state = "全部成交";
		} else if (status == 3) {
			state = "部分成交";
		} else if (status == 4) {
			state = "部撤";
		} else if (status == 5) {
			state = "废单";
		} else if (status == 6) {
			state = "报单中";
		} else if (status == 7) {
			state = "撤单中";
		} else if (status == 8) {
			state = "待报";
		} else if (status == 9) {
			state = "报单失败";
		} else if (status == 10) {
			state = "撤单失败";
		}
		return state;
	}

	/**
	 * 历史成交导出
	 * 
	 * @param trade
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/exportLsDeal/{lsflag}")
	@ResponseBody
	public void getDealcjLsListExport(TradeParam trade, @PathVariable("lsflag") Integer lsflag, HttpSession session,
			HttpServletResponse response) {
		try {
			if (lsflag != null) {
				trade.setLsflag(lsflag);
			}
			long totalCount = 0;
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin = (Integer) session.getAttribute(Constant.SESSION_ISADMIN);
			int start = (PaginationContext.getPageNum() - 1) * PaginationContext.getPageSize();
			int limit = PaginationContext.getPageNum() * PaginationContext.getPageSize();
			/*
			 * Page<DealCj> fundPage = new Page<DealCj>();
			 * fundPage.setPagenum(PaginationContext.getPageNum());
			 * fundPage.setPagesize(PaginationContext.getPageSize());
			 */
			List<DealCj> fmList = new ArrayList<DealCj>();
			DB db = dsForStock.getDB();
			DBCollection dbCollection = db.getCollection("history_cj");// 历史成交记录
			DBObject condition = new BasicDBObject();
			if (!StringUtil.isAnyNullOrEmpty(trade.getSubzh())) {
				condition.put("subzh", new BasicDBObject("$eq", trade.getSubzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getBroker())) {
				condition.put("broker", new BasicDBObject("$eq", trade.getBroker()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getAgentzh())) {
				condition.put("agentzh", new BasicDBObject("$eq", trade.getAgentzh()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getChannel())) {
				condition.put("channel", new BasicDBObject("$eq", trade.getChannel()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getPt())) {
				condition.put("pt", new BasicDBObject("$eq", trade.getPt()));
			}
			if (trade.getExchange() != null) {
				condition.put("exchangeType", new BasicDBObject("$eq", trade.getExchange()));
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockCode())) {
				 Pattern pattern = Pattern.compile("^.*" + trade.getStockCode() + ".*$");
				condition.put("stockCode", pattern);
			}
			if (!StringUtil.isAnyNullOrEmpty(trade.getStockName())) {
				Pattern pattern = Pattern.compile("^.*" + trade.getStockName() + ".*$");
				condition.put("stockName", pattern);
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getStarttime())){
				trade.setStarttime("2018-01-01");
			}
			
			if(StringUtil.isAnyNullOrEmpty(trade.getEndtime())){
				trade.setEndtime(DateUtil.dateFormat(new Date(), "yyyy-MM-dd"));
			}
			BasicDBList values = getLongDateValue(trade,"mdealtime");  
		    condition.put("$and", values);
			
			
			/*if (!StringUtil.isAnyNullOrEmpty(trade.getStarttime())
					|| !StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
				DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
				DateFormat df2 = new SimpleDateFormat("yyyyMMdd");
				if (!StringUtil.isAnyNullOrEmpty(trade.getStarttime())) {
					String startdate = df2.format(df1.parse(trade.getStarttime()));
					condition.put("mdealtime", new BasicDBObject("$gte", Long.parseLong(startdate + "000000")));
				}
				if (!StringUtil.isAnyNullOrEmpty(trade.getEndtime())) {
					String enddate = df2.format(df1.parse(trade.getEndtime()));
					condition.put("mdealtime", new BasicDBObject("$lte", Long.parseLong(enddate + "235959")));
				}
			}*/
			if (isAdmin != null) {
				if (isAdmin == 3) {
					condition.put("channel", new BasicDBObject("$eq", username));
				} else if (isAdmin == 4) {
					condition.put("agentzh", new BasicDBObject("$eq", username));
				} else if (isAdmin == 5) {
					condition.put("broker", new BasicDBObject("$eq", username));
				}
			}
			DBObject orderBy = new BasicDBObject();
			orderBy.put("mdealtime", -1);// 按tradedate倒序排
			totalCount = dbCollection.count(condition);
			DBCursor cursor = dbCollection.find(condition).sort(orderBy)/*.skip(start)
					.limit(PaginationContext.getPageSize())*/;
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				String string = dbObj.toString();
				DealCj deal=JSON.parseObject(string, DealCj.class);
				long sdate = dbObj.getLong("mdealtime");
				String date = String.valueOf(sdate);
				if (sdate > 10000000) {
					String dealcjtime = date.substring(0, 4) + "." + date.substring(4, 6) + "." + date.substring(6, 8);
					deal.setDealcjtime(dealcjtime);
					String eorderno = date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
					if (date.length() > 8) {
						eorderno = eorderno + " " + date.substring(8, 10) + ":" + date.substring(10, 12) + ":"
								+ date.substring(12);
					}
					deal.setOrdertime(eorderno);
				}
				fmList.add(deal);
			}
			JSONArray json = new JSONArray();
			json.addAll(fmList);
			Map<String, String> headMap = new LinkedHashMap<String, String>();
			if (trade.getLsflag() != null && trade.getLsflag() == 2) {
				headMap.put("dealcjtime", "日期");
			}
			headMap.put("subzh", "用户账户");
			headMap.put("channelname", "所属渠道");
			headMap.put("agentname", "所属代理商");
			headMap.put("brokername", "所属经纪人");
			headMap.put("exchangeTypeShift", "市场");
			headMap.put("stockCode", "合约代码");
			headMap.put("stockName", "合约名称");
			headMap.put("entrustBsShift", "方向");
			headMap.put("directionTypeShift", "开平");
			headMap.put("businessVol", "成交数量");
			headMap.put("businessPrice", "成交均价");
			headMap.put("occurBalance", "平仓盈亏");
			headMap.put("ordertime", "成交时间");
			headMap.put("fee", "手续费");
			MyExcelUtil.downloadExcelFile("成交记录", headMap, json, "yyyy-MM-dd", 0, response);
			/*
			 * fundPage.setList(fmList); fundPage.setCountsize(totalCount);
			 * fundPage.setPagecount(totalCount);
			 */
			// model.addAttribute("page", fundPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// model.addAttribute("status", 0);
		// model.addAttribute("lsflag", trade.getLsflag());
	}
	
	/**
	 * 后台强平操作
	 * 
	 * @param trade
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/ringout")
	@ResponseBody
	public JSONObject getDealcjLsListExport(entryEntity entry) {
		if(entry.getEntrust_bs()==0){
			entry.setEntrust_bs(1);
		}else{
			entry.setEntrust_bs(0);   //买卖方向 0买 1卖
		}
		entry.setAuth_id("5826295222812504710");
		entry.setEntrust_way(4);
		entry.setEntrust_direction(1); //平仓
		entry.setHedge_type(4);// 投机方式 4强平
		entry.setEntrust_price("0");  //委托价格，市价单填0
		entry.setEntrust_type(1);    //委托类型 0限价单 1市价单
		//调用柜台协议
		JSONObject obj=invokeCounter(JSON.toJSONString(entry),11116);//查找用户资金信息
		return obj;
	}
	
}
