/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : FundPzLogController.java
 * 功能概要  : 资金记录信息 管理Controller类
 * 做成日期  : 2018年04月16日 
 * 修改日期  :
 */
package com.jcl.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jcl.comm.PaginationContext;
import com.jcl.mongodb.Page;
import com.jcl.pojo.Bdzh;
import com.jcl.pojo.ExceptOrder;
import com.jcl.pojo.ExceptOrderExample;
import com.jcl.pojo.FundPzlog;
import com.jcl.pojo.Holderdb;
import com.jcl.pojo.Subcj;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.TradeHedging;
import com.jcl.pojo.TradeHedgingExample;
import com.jcl.service.BdzhService;
import com.jcl.service.ExceptOrderService;
import com.jcl.service.SubzhService;
import com.jcl.service.TradeHedgingService;
import com.jcl.stock.simulate.DefineNumber;
import com.jcl.stock.simulate.service.SimulateStockService;
import com.jcl.util.Constant;
import com.jcl.util.StringUtil;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * 资金记录信息 管理类
 * 
 * @author jiangzq
 * @version 1.0
 */
@Controller
@RequestMapping("/tradeData")
public class TradeDataController {
	
	public static Logger log = Logger.getLogger(TradeDataController.class);
	
	private FundPzlog fundPzlog;
	
	@Autowired
	private SubzhService subzhservice;
	
	/*异常信息管理service*/
	@Autowired
	private ExceptOrderService exceptOrderService;
	
	/*样本账户信息管理service*/
	@Autowired
	private TradeHedgingService tradeHedgingService;
	
	/*交易Service*/
	@Autowired
    private SimulateStockService simulateStockService;
	@Autowired
	private Datastore dsForStock;
	
	@Autowired
	private BdzhService bdzhService;

	// 订单记录
	@RequestMapping("/dealHolderList")
	public String dealHolderList(HttpSession session, String subzh, String orderNo, Model model) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "5");
		/*try {
			if(StringUtil.isAnyNullOrEmpty(subzh) && auth_id != null && auth_id == 1){//子账户为空
				renderText("{}");
				return;
			}
		} catch (Exception e) {
			log.error("判断结算报表数据显示异常：" + e.getMessage());
		}*/
		PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
		Map<String, Object> mapCondition = new HashMap<String, Object>();
		//String agentzh=(String)getSession().getAttribute(Constant.SESSION_LOGIN_AGENTZH);
		int start = (PaginationContext.getPageNum()-1)*PaginationContext.getPageSize();
		int limit = PaginationContext.getPageNum()*PaginationContext.getPageSize();
		mapCondition.put("start", start);
		mapCondition.put("limit", limit);
		mapCondition.put("client_id", subzh);
		mapCondition.put("orderNo", orderNo);//订单编号
		mapCondition.put("entrust_type", 0);//0.全部 1.股票 2.组合 3.比赛
		PageInfo<Subcj> subPage = new PageInfo<Subcj>();
		int totalCount=0;
		try {
			String s = "";
			//SimulateStockService simulateStockService = new SimulateStockServiceImpl();
			//成交记录  当日JCL_PROTOCOL_ID_REQ_DRWTCX   历史JCL_PROTOCOL_ID_REQ_LSCJ 11121
			String[] columns = {"lsh", "agentzh", "subzh", "wtbh", "cjbh","bz","entrust_bs", "code", "hydm", "xdzllx", "cjsl", "cjjg", "yj","cjtime", "cost", "stopjg", "mainzh","bond","sxf"};
			String rbStr = null;
			/*if(ishistory!=null&&ishistory==1){
				mapCondition.put("start_date", startday);
				mapCondition.put("end_date", endday);
				//mapCondition.put("agentzh", agentzh);
				s=JsonCommon.convertToJson(mapCondition);
				//rbStr = simulateStockService.commonFunction(s, DefineNumber.JCL_PROTOCOL_ID_REQ_LSCJ);
				rbStr=subcjService.getSubcjPageByCondition(getQueryParameter(), mapCondition, columns);
			} else {*/
			s = (new JSONObject(mapCondition)).toString();
			rbStr = simulateStockService.commonFunction(s, DefineNumber.JCL_PROTOCOL_ID_REQ_DRCJCX);
			log.info("从成交记录接口中返回的数据:"+rbStr);
			List<Subcj> list=new ArrayList<Subcj>();
			if(rbStr!=null){
				JSONObject obj = new JSONObject(rbStr);
				if(obj.has("status")){
					int i=obj.getInt("status");
					if(obj.has("totalnum")){
						totalCount=obj.getInt("totalnum");
					}
					if(i==0){
						//Map<String,Object> map=new HashMap<String,Object>();
						JSONArray arr=obj.getJSONArray("records");
						for(int j=0;j<arr.length();j++){//返回的所有参数都在这里
							Subcj dealcj=new Subcj();
							JSONObject cj =(JSONObject)arr.get(j);
							dealcj.setWtbh(cj.getString("entrust_no"));//委托标识,编号
							if(cj.has("business_no")){
								dealcj.setCjbh(cj.getString("business_no"));//成交编号
							}
							dealcj.setExchange(cj.getInt("exchange_type"));//交易所类别
							dealcj.setHydm(cj.getString("stock_code"));//股票代码
							dealcj.setCode(cj.getString("stock_name"));//股票名称
							dealcj.setEntrust_bs(cj.getInt("entrust_bs"));//买卖方向
							double d=cj.getDouble("business_vol");//成交量
							dealcj.setCjsl((int)d);
							dealcj.setCjjg(cj.getDouble("business_price"));//成交价格
							if(cj.has("new_position")){
								dealcj.setNewPosition(cj.getDouble("new_position"));//新仓位
							}if(cj.has("old_position")){
								dealcj.setOldPosition(cj.getDouble("old_position"));//旧仓位
							}if(cj.has("fee")){
								dealcj.setSxf(cj.getDouble("fee"));
								dealcj.setYj(cj.getDouble("fee"));
							}if(cj.has("direction_type")){//xdzllx 这里指开平.
								dealcj.setXdzllx(cj.getInt("direction_type"));
							}
							String busdate=String.valueOf(cj.getInt("business_date"));
							String bustime=String.valueOf(cj.getInt("business_time"));
							if(bustime.length()==5){
								bustime="0"+bustime;
							}
							String date=busdate.substring(0,4)+"-"+busdate.substring(4,6)+"-"+busdate.substring(6);
							String time=bustime.substring(0,2)+":"+bustime.substring(2,4)+":"+bustime.substring(4);
							SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							Date cjtime=formatter.parse(date+" "+time);
							dealcj.setCjtime(new Timestamp(cjtime.getTime()));//成交时间
							System.out.println("date+ time:"+date+" "+time+ "    cjtime:"+cjtime);
							dealcj.setMaincjtime(date+" "+time);
							dealcj.setSubzh(subzh);
							list.add(dealcj);
						}
						System.out.println("成交记录当日查询："+s);
						/*Gson gson = new Gson();
						Type type = new TypeToken<List<DealCj>>(){}.getType();
						list = gson.fromJson(obj.getJSONArray("records").toString(), type);*/
						Collections.sort(list);
						//rbStr=JsonCommon.convertToJson(subPage);
					}
					
				}
			}
			//}
			PageInfo<Subcj> userpage = new PageInfo<Subcj>(list);
			
			model.addAttribute("userlist", list);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			//renderText("{}");
			log.error("查询当日成交或历史成交记录失败" + e.getMessage());
		}
		return "fund/dealHolderList";
	}

	// 订单记录列表模糊查询
	@RequestMapping("/selectPageDealHolder")
	public String selectPageDealHolder(String nickname, String orderNo, Model model) throws UnsupportedEncodingException {
		try {
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			Map<String, Object> mapCondition = new HashMap<String, Object>();
			int start = (PaginationContext.getPageNum()-1)*PaginationContext.getPageSize();
			int limit = PaginationContext.getPageNum()*PaginationContext.getPageSize();
			mapCondition.put("start", start);
			mapCondition.put("limit", limit);
			mapCondition.put("client_id", nickname);
			mapCondition.put("orderNo", orderNo);//订单编号
			mapCondition.put("entrust_type", 0);//0.全部 1.股票 2.组合 3.比赛
			PageInfo<Subcj> subPage = new PageInfo<Subcj>();
			int totalCount=0;
			String s = "";
			//SimulateStockService simulateStockService = new SimulateStockServiceImpl();
			//成交记录  当日JCL_PROTOCOL_ID_REQ_DRWTCX   历史JCL_PROTOCOL_ID_REQ_LSCJ 11121
			String rbStr = null;
			/*if(ishistory!=null&&ishistory==1){
				mapCondition.put("start_date", startday);
				mapCondition.put("end_date", endday);
				//mapCondition.put("agentzh", agentzh);
				s=JsonCommon.convertToJson(mapCondition);
				//rbStr = simulateStockService.commonFunction(s, DefineNumber.JCL_PROTOCOL_ID_REQ_LSCJ);
				rbStr=subcjService.getSubcjPageByCondition(getQueryParameter(), mapCondition, columns);
			} else {*/
			s = (new JSONObject(mapCondition)).toString();
			rbStr = simulateStockService.commonFunction(s, DefineNumber.JCL_PROTOCOL_ID_REQ_DRCJCX);
			log.info("从成交记录接口中返回的数据:"+rbStr);
			List<Subcj> list=new ArrayList<Subcj>();
			if(rbStr!=null){
				JSONObject obj = new JSONObject(rbStr);
				if(obj.has("status")){
					int i=obj.getInt("status");
					if(obj.has("totalnum")){
						totalCount=obj.getInt("totalnum");
					}
					if(i==0){
						//Map<String,Object> map=new HashMap<String,Object>();
						JSONArray arr = obj.getJSONArray("records");
						for(int j=0;j<arr.length();j++){//返回的所有参数都在这里
							Subcj dealcj = new Subcj();
							JSONObject cj =(JSONObject)arr.get(j);
							dealcj.setWtbh(cj.getString("entrust_no"));//委托标识,编号
							if(cj.has("business_no")){
								dealcj.setCjbh(cj.getString("business_no"));//成交编号
							}
							dealcj.setExchange(cj.getInt("exchange_type"));//交易所类别
							dealcj.setHydm(cj.getString("stock_code"));//股票代码
							dealcj.setCode(cj.getString("stock_name"));//股票名称
							dealcj.setEntrust_bs(cj.getInt("entrust_bs"));//买卖方向
							double d=cj.getDouble("business_vol");//成交量
							dealcj.setCjsl((int)d);
							dealcj.setCjjg(cj.getDouble("business_price"));//成交价格
							if(cj.has("new_position")){
								dealcj.setNewPosition(cj.getDouble("new_position"));//新仓位
							}if(cj.has("old_position")){
								dealcj.setOldPosition(cj.getDouble("old_position"));//旧仓位
							}if(cj.has("fee")){
								dealcj.setSxf(cj.getDouble("fee"));
								dealcj.setYj(cj.getDouble("fee"));
							}if(cj.has("direction_type")){//xdzllx 这里指开平.
								dealcj.setXdzllx(cj.getInt("direction_type"));
							}
							String busdate=String.valueOf(cj.getInt("business_date"));
							String bustime=String.valueOf(cj.getInt("business_time"));
							if(bustime.length()==5){
								bustime="0"+bustime;
							}
							String date=busdate.substring(0,4)+"-"+busdate.substring(4,6)+"-"+busdate.substring(6);
							String time=bustime.substring(0,2)+":"+bustime.substring(2,4)+":"+bustime.substring(4);
							SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							Date cjtime=formatter.parse(date+" "+time);
							dealcj.setCjtime(new Timestamp(cjtime.getTime()));//成交时间
							System.out.println("date+ time:"+date+" "+time+ "    cjtime:"+cjtime);
							dealcj.setMaincjtime(date+" "+time);
							//dealcj.setSubzh(subzh);
							dealcj.setSubzh(nickname);
							list.add(dealcj);
						}
						/*Gson gson = new Gson();
						Type type = new TypeToken<List<DealCj>>(){}.getType();
						list = gson.fromJson(obj.getJSONArray("records").toString(), type);*/
						Collections.sort(list);
						//rbStr=JsonCommon.convertToJson(subPage);
					}
					
				}
			}
			//}
			PageInfo<Subcj> userpage = new PageInfo<Subcj>(list);
				
			model.addAttribute("nickname", nickname);
			model.addAttribute("orderNo", orderNo);
			model.addAttribute("userlist", list);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询提现记录列表异常：" + e.getMessage());
		}
		return "fund/fundPzLogList";
	}

	// 持仓对比
//	@RequestMapping("/holderCompareList")
//	public String holderCompareList(HttpSession session, String mainzh, String subzh, String orderNo, Model model) {
//		session.setAttribute(Constant.SESSION_LEFTMENU, "6");
//		PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
//		Map<String, Object> mapCondition = new HashMap<String, Object>();
//		int start = (PaginationContext.getPageNum()-1)*PaginationContext.getPageSize();
//		int limit = PaginationContext.getPageNum()*PaginationContext.getPageSize();
//		
//		//mapCondition.put("client_id", mainzh);//将主账号放到client_id中,因为接口的入参名称是client_id
//		mapCondition.put("mainzh", mainzh);
//		int pageNo = PaginationContext.getPageNum();
//		int pageSize = PaginationContext.getPageSize();
//		mapCondition.put("start", start);
//		mapCondition.put("limit", limit);
//		List<Ccdb> list2 = new ArrayList<Ccdb>();
//		try {
//			//SimulateStockService simulateStockService = new SimulateStockServiceImpl();
//			String rbStr = "";
//			mapCondition.put("client_id", mainzh);
//			String s = (new JSONObject(mapCondition)).toString();
//			//持仓对比
//			rbStr = simulateStockService.commonFunction(s, DefineNumber.JCL_PROTOCOL_ID_REQ_HOLDLISTCOMPARE);
//			if(rbStr != null){
//				JSONObject obj = new JSONObject(rbStr);
//				log.info("从持仓对比接口中返回的数据:"+rbStr);
//				if(obj.has("status")){
//					int i=obj.getInt("status");
//					if(i==0){
//						Map<String,Object> map=new HashMap<String,Object>();
//						JSONArray arr=obj.getJSONArray("records");
//						List<Ccdb> list = new ArrayList<Ccdb>();
//						for(int j=0;j<arr.length();j++){
//							String name="";
//							JSONObject datalist =(JSONObject)arr.get(j);
//							if(datalist.has("name")){
//								name=datalist.getString("name");//分组名称
//							}if(datalist.has("hold")&&name.equals(mainzh)){//持仓数据集
//								JSONArray arr2 = datalist.getJSONArray("hold");
//								Map<String,Ccdb> ishmap = new HashMap<String, Ccdb>();
//								for(int k=0;k<arr2.length();k++){
//									Ccdb ccdb=new Ccdb();
//									ccdb.setName(name);
//									ccdb.setMain_client_id(name);
//									JSONObject ccdb1 =(JSONObject)arr2.get(k);
//									String stock_code=ccdb1.getString("stock_code");
//									if(ccdb1.has("main_exchange")){
//										ccdb.setMain_exchange(ccdb1.getString("main_exchange"));//主账号市场编码 (新接口中没有)
//									}
//									if(ccdb1.has("exchange_type")){
//										ccdb.setExchange_type(ccdb1.getInt("exchange_type"));
//									}
//									ccdb.setStock_code(stock_code);
//									ccdb.setSub_holders_empty(ccdb1.getInt("sub_holders_empty"));
//									ccdb.setSub_holders_more(ccdb1.getInt("sub_holders_more"));
//									if(ccdb1.has("main_holders")){
//										ccdb.setMain_holders(ccdb1.getInt("main_holders"));//主账号市场编码 (新接口中增加)
//									}
//									if(ccdb1.has("main_income_balance")){
//										ccdb.setMain_income_balance(ccdb1.getDouble("main_income_balance"));
//									}else{
//										ccdb.setMain_exchange("-");
//									}
//									if(ccdb1.has("sub_income_balance")){
//										ccdb.setSub_income_balance(ccdb1.getDouble("sub_income_balance"));//主账号市场编码 (新接口中增加)
//									}else{
//										ccdb.setContract_code("-");
//									}
//									
//									if(ccdb1.has("main_cost_empty")){
//										ccdb.setMain_cost_more(ccdb1.getDouble("main_cost_empty"));//主账号市场编码 (新接口中增加)
//									}if(ccdb1.has("main_cost_more")){
//										ccdb.setMain_cost_empty(ccdb1.getDouble("main_cost_more"));
//									}
//									if(ccdb1.has("main_holders_more")){
//										ccdb.setMain_holders_more(ccdb1.getInt("main_holders_more"));
//									}if(ccdb1.has("main_holders_empty")){
//										ccdb.setMain_holders_empty(ccdb1.getInt("main_holders_empty"));//主账号市场编码 (新接口中增加)
//									}if(ccdb1.has("now_price")){
//										ccdb.setNow_price(ccdb1.getDouble("now_price"));
//									}
//									if(ccdb1.has("sub_cost_more")){
//										ccdb.setSub_cost_more(ccdb1.getDouble("sub_cost_more"));//主账号市场编码 (新接口中增加)
//									}if(ccdb1.has("sub_cost_empty")){
//										ccdb.setSub_cost_empty(ccdb1.getDouble("sub_cost_empty"));
//									}
//									if(k==0){
//										ishmap.put(stock_code, ccdb);
//									}else{
//										Set<Entry<String, Ccdb>> set = ishmap.entrySet();  
//										Iterator<Entry<String, Ccdb>> it=set.iterator();
//										//Iterator<Map.Entry<String, Ccdb>> it  = ishmap.entrySet().iterator();
//										int has=0;
//										while (it.hasNext()) {  
//											Entry<String, Ccdb> entry = it.next();
//											  //如果是重复的
//											  if(stock_code.equals(entry.getKey())){
//												  has=1;
//												  Ccdb c=entry.getValue();
//												  c.setMain_holders_more(c.getMain_holders_more()+ccdb.getMain_holders_more());
//												  c.setMain_holders_empty(c.getMain_holders_empty()+ccdb.getMain_holders_empty());
//												  c.setSub_holders_more(c.getSub_holders_more()+ccdb.getSub_holders_more());
//												  c.setSub_holders_empty(c.getSub_holders_empty()+ccdb.getSub_holders_empty());
//												  	/*BigDecimal b1 = new BigDecimal(Double.toString(v1));
//											        BigDecimal b2 = new BigDecimal(Double.toString(v2));
//											        b1.add(b2).doubleValue();*/
//												  c.setMain_cost_more(c.getMain_cost_more()+ccdb.getMain_cost_more());
//												  c.setMain_cost_empty(c.getMain_cost_empty()+ccdb.getMain_cost_empty());
//												  c.setSub_cost_empty(c.getSub_cost_empty()+ccdb.getSub_cost_empty());
//												  c.setSub_cost_more(c.getSub_cost_more()+ccdb.getSub_cost_more());
//												  break;
//											  }
//											   
//										}
//										if(has==0){
//											ishmap.put(stock_code, ccdb);
//										}
//									}
//									
//								}
//								//将map中的数据放到list中
//								Set<Entry<String, Ccdb>> set = ishmap.entrySet();  
//								Iterator<Entry<String, Ccdb>> it=set.iterator();
//								int k=0;
//								while (it.hasNext()) {
//									Entry<String, Ccdb> entry = it.next();
//									list.add(entry.getValue());
//									k++;
//									if(k>start&&k<limit){
//										list2.add(entry.getValue());
//									}
//								}
//							}
//							
//						}
//						map.put("result", list);
//						int totalrecords=list.size();
//						map.put("totalrecords", totalrecords);
//						int total=1;
//						if(totalrecords>0){
//							total=totalrecords/pageSize+(totalrecords%pageSize==0 ? 0 : 1);
//						}
//						map.put("currpage", pageNo);
//						map.put("totalpages", total);
//						/*ccPage.setPageNo(pageNo);
//						ccPage.setPageSize(pageSize);
//						ccPage.setTotalCount(totalrecords);
//						ccPage.setResult(list2);*/
//						//rbStr = JsonCommon.convertToJson(ccPage, columns, getQueryParameter());
//					}
//					
//				}
//			}
//		
//			PageInfo<Ccdb> userpage = new PageInfo<Ccdb>(list2);
//			
//			model.addAttribute("userlist", list2);
//			model.addAttribute("userpage", userpage);
//		} catch (Exception e) {
//			log.error("查询持仓对比失败" + e.getMessage());
//		}
//		return "fund/holderCompareList";
//	}

	/**
	 * 
	 * @return 
	 * @author heqiwen 持仓对比不是这里
	 * @date 2018-6-5
	 * @decribe
	 * @param model
	 * @param session
	 * @param bdzh
	 * @param mark
	 * @param code
	 * @return
	 */
	@RequestMapping("/holderCompareList")
	public String holderDbList(Model model,HttpSession session,String bdzh,Integer mark,String code){
		try{
			session.setAttribute(Constant.SESSION_LEFTMENU, "6");
			long totalCount=0;
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin=(Integer)session.getAttribute(Constant.SESSION_ISADMIN);//当前登录者角色标识，1机构2平台，3渠道，4代理商，5经纪人
			String pt=(String) session.getAttribute(Constant.SESSION_PLATEFORM);
			int start = (PaginationContext.getPageNum()-1)*PaginationContext.getPageSize();
			int limit = PaginationContext.getPageNum()*PaginationContext.getPageSize();
			Page<Holderdb> fundPage=new Page<Holderdb>();
			fundPage.setPagenum(PaginationContext.getPageNum());
			fundPage.setPagesize(PaginationContext.getPageSize());
			List<Holderdb> fmList=new ArrayList<Holderdb>();
			DB db = dsForStock.getDB();
			DBCollection dbCollection=db.getCollection("main_holder");//主账号持仓对比 数据
			DBObject condition = new BasicDBObject();
			if(!StringUtil.isAnyNullOrEmpty(bdzh)){
				condition.put("account", new BasicDBObject("$eq", bdzh));
			}
			if(!StringUtil.isAnyNullOrEmpty(code)){
				condition.put("code", new BasicDBObject("$eq", code));
			}
			
			if(mark!=null){
				condition.put("mark", new BasicDBObject("$eq", mark));
			}

			Subzh subzh=new Subzh();
			if(isAdmin==1){//如果是机构登录，那就查询条件中带机构
				subzh.setManage(username);
			}else if(isAdmin==2){//如果是平台登录，那就查询条件中带平台
				subzh.setAllocpt(username);
			}else if(isAdmin==3){//如果是渠道登录，那就查询条件中带渠道
				subzh.setAllocchannel(username);
			}else if(isAdmin==4){//如果是代理商登录，那就查询条件中带代理商
				subzh.setAllocagent(username);
			}else if(isAdmin==5){//如果是经纪人登录，那就查询条件中带经纪人
				subzh.setAllocbroker(username);
			}
			subzh.setIsadmin(6);
			List<Subzh> sublist=subzhservice.getSubzhLevelList(subzh);//登录用户可以查看到的子账号
			BasicDBList values = new BasicDBList();
			if(sublist!=null && sublist.size()>0){
				for(Subzh sub:sublist){
					values.add(sub.getSubzh());
				}
			}
			if(values.size()>0){
				//condition.put("sub_zh",  new BasicDBObject("$in", values));
				DBObject subholder = new BasicDBObject();
				subholder.put("subholder", new BasicDBObject("$elemMatch", new BasicDBObject("account", new BasicDBObject("$in", values))));
				if(condition.containsField("account")||condition.containsField("code")||condition.containsField("mark")){
					condition=new BasicDBObject("$and", Arrays.asList(condition, subholder));//当日成交记录
				}else{
					condition=subholder;
				}
				
			}else{
				return "fund/holderCompareList";
			}
		
			DBObject orderBy = new BasicDBObject();  
			orderBy.put("vol", -1);//按vol倒序排  
			totalCount=dbCollection.count(condition);
			DBCursor cursor = dbCollection.find(condition).sort(orderBy).skip(start).limit(limit);
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				Holderdb ccdb=new Holderdb();
				//BeanUtil.dbObject2Bean(dbObj,fund);
				
				
				fmList.add(ccdb);
			}
			fundPage.setList(fmList);
			fundPage.setCountsize(totalCount);
			fundPage.setPagecount(totalCount);
			model.addAttribute("page", fundPage);
		
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "fund/holderCompareList";
	}
	
	
	
	/**
	 * 
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-5
	 * @decribe
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/exceptionOrderList")
	public String exceptionOrderList(HttpSession session,Model model,String userId){
		try{
			session.setAttribute(Constant.SESSION_LEFTMENU, "7");
			long totalCount=0;
			String manage = (String) session.getAttribute(Constant.SESSION_AGENTZHGL);
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin=(Integer)session.getAttribute(Constant.SESSION_ISADMIN);//当前登录者角色标识，1机构2平台，3渠道，4代理商，5经纪人
			String pt=(String) session.getAttribute(Constant.SESSION_PLATEFORM);
			
			int start = (PaginationContext.getPageNum()-1)*PaginationContext.getPageSize();
			int limit = PaginationContext.getPageNum()*PaginationContext.getPageSize();
			Page<ExceptOrder> fundPage=new Page<ExceptOrder>();
			fundPage.setPagenum(PaginationContext.getPageNum());
			fundPage.setPagesize(PaginationContext.getPageSize());
			List<ExceptOrder> fmList=new ArrayList<ExceptOrder>();
			DB db = dsForStock.getDB();
			DBCollection dbCollection=db.getCollection("sub_exception");//异常订单数据
			DBObject condition = new BasicDBObject();
			if(!StringUtil.isAnyNullOrEmpty(userId)){
				//condition.put("sub_zh", new BasicDBObject("$regex", "/"+userId+"/"));
				Pattern pattern = Pattern.compile("^.*"+userId+".*$", Pattern.CASE_INSENSITIVE);
				condition = new BasicDBObject();
				condition.put("sub_zh",pattern);
			}else{
				Subzh subzh=new Subzh();
				if(isAdmin==1){//如果是机构登录，那就查询条件中带机构
					subzh.setManage(username);
				}else if(isAdmin==2){//如果是平台登录，那就查询条件中带平台
					subzh.setAllocpt(username);
				}else if(isAdmin==3){//如果是渠道登录，那就查询条件中带渠道
					subzh.setAllocchannel(username);
				}else if(isAdmin==4){//如果是代理商登录，那就查询条件中带代理商
					subzh.setAllocagent(username);
				}else if(isAdmin==5){//如果是经纪人登录，那就查询条件中带经纪人
					subzh.setAllocbroker(username);
				}
				subzh.setIsadmin(6);
				List<Subzh> sublist=subzhservice.getSubzhLevelList(subzh);////登录用户可以查看到的子账号
				BasicDBList values = new BasicDBList();
				if(sublist!=null && sublist.size()>0){
					for(Subzh sub:sublist){
						values.add(sub.getSubzh());
					}
				}
				if(values.size()>0){
					condition.put("sub_zh",  new BasicDBObject("$in", values));
				}else{
					return "fund/exceptionOrderList";
				}
				
			}
			
			DBObject orderBy = new BasicDBObject();  
			orderBy.put("order_date", -1);//按vol倒序排  
			orderBy.put("order_time", -1);//按vol倒序排  
			totalCount=dbCollection.count(condition);
			DBCursor cursor = dbCollection.find(condition).sort(orderBy).skip(start).limit(PaginationContext.getPageSize());
			while (cursor.hasNext()) {
				BasicDBObject dbObj = (BasicDBObject) cursor.next();
				ExceptOrder eorder=new ExceptOrder();
				//BeanUtil.dbObject2Bean(dbObj,fund);
				eorder=fromDBObject(dbObj);
				fmList.add(eorder);
			}
			fundPage.setList(fmList);
			fundPage.setCountsize(totalCount);
			fundPage.setPagecount(totalCount);
			model.addAttribute("page", fundPage);
			model.addAttribute("userId", userId);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "fund/exceptionOrderList";
	}

	/**
	 * 
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-5
	 * @decribe 将从mongodb中取得的数据转化为实体类
	 * @param dbObj
	 * @return
	 */
	public ExceptOrder fromDBObject(BasicDBObject dbObj){
		ExceptOrder order=new ExceptOrder();
		try {
			String agentzh=dbObj.getString("agent");
			String userId=dbObj.getString("sub_zh");
			String mainzh=dbObj.getString("main_zh");
			Integer market=dbObj.getInt("mark");
			String hycode=dbObj.getString("code");
			String hypz=dbObj.getString("name");
			Integer direction=dbObj.getInt("order_bs");
			Integer vol=dbObj.getInt("order_vol");
			Double price=dbObj.getDouble("order_price");
			Integer orderdate=dbObj.getInt("order_date");
			Integer ordertime=dbObj.getInt("order_time");
			Integer order_direction=dbObj.getInt("order_direction");//开平
			if(dbObj.containsField("reason")){
				order.setReason(dbObj.getString("reason"));
			}
			String entrusttime="";
			if(orderdate!=null && ordertime!=null && orderdate>10000 && ordertime>1000){
				entrusttime=String.valueOf(orderdate);
				if(ordertime<100000){
					entrusttime+="0"+ordertime;
				}else{
					entrusttime+=ordertime;
				}
				DateFormat df1=new SimpleDateFormat("yyyyMMddHHmmss");
				DateFormat df2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				entrusttime=df2.format(df1.parse(entrusttime));
			}
			if(order_direction!=null){
				if(order_direction==0){
					order.setOrderDirec("开仓");
				}else{
					order.setOrderDirec("平仓");
				}
			}
			order.setAgentzh(agentzh);
			order.setUserId(userId);
			if(!StringUtil.isAnyNullOrEmpty(mainzh)){
				if(mainzh.length()>7 || mainzh.startsWith("0")){
					order.setMainzh(mainzh);
				}else{
					Integer bdzhid=Integer.parseInt(mainzh);
					Bdzh bdzh=bdzhService.selectByPrimaryKey(bdzhid);
					if(bdzh==null){
						order.setMainzh(mainzh);
					}else{
						order.setMainzh(bdzh.getAccountid());
					}
				}
				
			}else{
				Subzh sub=subzhservice.selectBySubzh(userId);
				if(sub!=null && !StringUtil.isAnyNullOrEmpty(sub.getAccountid())){
					Integer bdzhid=Integer.parseInt(sub.getAccountid());
					Bdzh bdzh=bdzhService.selectByPrimaryKey(bdzhid);
					if(bdzh!=null){
						order.setMainzh(bdzh.getAccountid());
					}
					//order.setMainzh(sub.getAccountid());
				}else{
					order.setMainzh(mainzh);
				}
			}
			order.setEntrusttime(entrusttime);
			if(market!=null){
				if(market==3){
					order.setExchange("中金所");
				}else if(market==4){
					order.setExchange("上期所");
				}else if(market==5){
					order.setExchange("大商所");
				}else if(market==6){
					order.setExchange("郑商所");
				}else if(market==24){
					order.setExchange("上期能源INE");
				}
			}
			order.setHycode(hycode);
			order.setHypz(hypz);
			if(direction!=null){
				if(direction==0){
					order.setFangx("买入");
				}else{
					order.setFangx("卖出");
				}
			}
			order.setVol(vol);
			order.setPrice(price);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return order;
		
	}
	
	// 异常订单列表模糊查询
	@RequestMapping("/selectPageExceptionOrder")
	public String selectPageExceptionOrder(String mainzh, String nickname, String orderNo, Model model) {
		try {
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			ExceptOrderExample example = new ExceptOrderExample();
			example.setOrderByClause(" id desc, order_time desc");
			com.jcl.pojo.ExceptOrderExample.Criteria criteria = example.createCriteria();
			//criteria.andStatusGreaterThan((byte)2);//状态   2:预提现  3：提现成功   4:提现申请  5：审核通过  6：拒绝
			if(!StringUtil.isAnyNullOrEmpty(nickname)){
				criteria.andUserIdLike("%" + nickname + "%");
			}
			/*if(!StringUtil.isAnyNullOrEmpty(usertype)){
				criteria.andIsadminEqualTo(Integer.parseInt(usertype));
			}*/
			List<ExceptOrder> userlist = exceptOrderService.selectByExample(example);
			PageInfo<ExceptOrder> userpage = new PageInfo<ExceptOrder>(userlist);
			model.addAttribute("nickname", nickname);
			model.addAttribute("userlist", userlist);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询提现记录列表异常：" + e.getMessage());
		}
		return "fund/exceptionOrderList";
	}
	
	// 对冲账户列表
	@RequestMapping("/tradeHedgingList")
	public String tradeHedgingList(HttpSession session, Model model) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "19");
		try {
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			//List<FundPzLog> userlist = FundPzLogservice.selectAll();
			TradeHedgingExample example = new TradeHedgingExample();
			example.setOrderByClause(" id desc, createdate desc");
			//Criteria criteria = example.createCriteria();
			//criteria.andTypeEqualTo("3");//
			//criteria.andStatusGreaterThan((byte)2);//状态   2:预提现  3：提现成功   4:提现申请  5：审核通过  6：拒绝
			List<TradeHedging> userList = tradeHedgingService.selectByExample(example);
			PageInfo<TradeHedging> userpage = new PageInfo<TradeHedging>(userList);
			
			model.addAttribute("userlist", userList);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询样本账户列表失败" + e.getMessage());
		}
		return "fund/tradeHedgingList";
	}

	// 对冲账户列表
	@RequestMapping("/selectPageTradeHedging")
	public String selectPageTradeHedging(String mainzh, String nickname, String orderNo, Model model) {
		try {
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			TradeHedgingExample example = new TradeHedgingExample();
			example.setOrderByClause(" id desc, createdate desc");
			com.jcl.pojo.TradeHedgingExample.Criteria criteria = example.createCriteria();
			if(!StringUtil.isAnyNullOrEmpty(nickname)){
				criteria.andVipnumberLike("%" + nickname + "%");
			}
			if(!StringUtil.isAnyNullOrEmpty(orderNo)){
				criteria.andAccountcodeLike("%" + orderNo + "%");
			}
			List<TradeHedging> userList = tradeHedgingService.selectByExample(example);
			PageInfo<TradeHedging> userpage = new PageInfo<TradeHedging>(userList);
			model.addAttribute("nickname", nickname);
			model.addAttribute("orderNo", orderNo);
			model.addAttribute("userlist", userList);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询样本账户列表异常：" + e.getMessage());
		}
		return "fund/tradeHedgingList";
	}
	
	// 样本账户查询列表
	@RequestMapping("/getTrackAcount")
	public String getTrackAcount(String vipNumber, Model model) {
		try {
			/*TradeHedgingExample example = new TradeHedgingExample();
			example.setOrderByClause(" id desc, createdate desc");
			com.jcl.pojo.TradeHedgingExample.Criteria criteria = example.createCriteria();
			if(!StringUtil.isAnyNullOrEmpty(vipNumber)){
				criteria.andVipnumberEqualTo(vipNumber);
			}
			List<TradeHedging> userList = tradeHedgingService.selectByExample(example);*/
			/*获取渠道/代理商/经纪人账号 下的所有账户信息*/
			List<TradeHedging> userList = new ArrayList<TradeHedging>();
			Subzh subzhTemp = subzhservice.getTradeUserOne(vipNumber);
			log.info("查询：subzh->" + subzhTemp.getSubzh() + " isadmin->" + subzhTemp.getIsadmin() + " vipNumber->" +  vipNumber);
			if(subzhTemp != null && subzhTemp.getIsadmin() != null){
				Subzh subzh = new Subzh();
				if(subzhTemp.getIsadmin()==1){//如果是机构登录，那就查询条件中带机构
					subzh.setManage(vipNumber);
				}else if(subzhTemp.getIsadmin()==2){//如果是平台登录，那就查询条件中带平台
					subzh.setAllocpt(vipNumber);
				}else if(subzhTemp.getIsadmin()==3){//如果是渠道登录，那就查询条件中带渠道
					subzh.setAllocchannel(vipNumber);
				}else if(subzhTemp.getIsadmin()==4){//如果是代理商登录，那就查询条件中带代理商
					subzh.setAllocagent(vipNumber);
				}else if(subzhTemp.getIsadmin()==5){//如果是经纪人登录，那就查询条件中带经纪人
					subzh.setAllocbroker(vipNumber);
				}
				subzh.setIsadmin(6);
				//List<Subzh> subzhList = subzhservice.selectQdJjrUser(subzh);
				List<Subzh> subzhList = subzhservice.selectTradeUser(subzh);
				if(subzhList != null && subzhList.size() > 0){
					TradeHedging temp = null;
					for(Subzh subzhEntity : subzhList){
						temp = new TradeHedging();
						temp.setVipnumber(vipNumber);
						temp.setAccountcode(subzhEntity.getSubzh());
						temp.setId(subzhEntity.getId());
						temp.setCreatedate(subzhEntity.getKhdate());
						userList.add(temp);
					}
				}
			}
			
			Map<String, List<TradeHedging>> map = new HashMap<String, List<TradeHedging>>();
			map.put("trackAcount", userList);
			model.addAttribute("tradeHedgingData", new JSONObject(map));
		} catch (Exception es) {
			log.error("查询样本账户数据集合异常：" + es.getMessage());
		}
		return "fund/tradeHedgingData";
	}
	
	// 新增样本账户
	@RequestMapping("/addTradeHedging")
	public String addCodefeesetMenu() {
		return "fund/addTradeHedging";
	}
	
	// 编辑样本账户
	@RequestMapping("/editTradeHedging")
	public String editCodefeeset(Integer id, Model model) {
		try {
			if(id != null){
				TradeHedging user = tradeHedgingService.selectByPrimaryKey(id);
				model.addAttribute("user", user);
			}
		} catch (Exception e) {
			log.error("获取权限列表异常：" + e.getMessage());
		}
		return "fund/addTradeHedging";
	}
		
	// 编辑样本账户信息
	@RequestMapping("/editTradeHedgingMsg")
	@ResponseBody
	public String editTradeHedgingMsg(HttpSession session, TradeHedging infomsg, Integer id) {
		/*判断方案名称是否已存在*/
		try {
			TradeHedgingExample example = new TradeHedgingExample();
			example.setOrderByClause(" id desc, createdate desc");
			com.jcl.pojo.TradeHedgingExample.Criteria criteria = example.createCriteria();
			criteria.andVipnumberEqualTo(infomsg.getVipnumber());
			criteria.andAccountcodeEqualTo(infomsg.getAccountcode());
			List<TradeHedging> userList = tradeHedgingService.selectByExample(example);
			if(userList != null && userList.size() > 0){
				return "isExist";
			}
			int i = 0;
			if(id == null){//新增
				infomsg.setCreatedate(Calendar.getInstance().getTime());
				i = tradeHedgingService.insertSelective(infomsg);
			} else {
				infomsg.setId(id);
				infomsg.setCreatedate(Calendar.getInstance().getTime());
				i = tradeHedgingService.updateByPrimaryKey(infomsg);
			}
			
			if(i > 0){
				return "true";
			}
		} catch (Exception es) {
			log.error("查询方案名称是否已存在异常：" + es.getMessage());
			tradeHedgingService.deleteByPrimaryKey(infomsg.getId());
		}
		
		return "false";
	}
	
	// 删除样本账户信息
	@RequestMapping("/reinstateTradeHedging")
	@ResponseBody
	public String reinstateTradeHedging(HttpSession session, Integer id) {
		/*判断方案名称是否已存在*/
		try {
			int i = tradeHedgingService.deleteByPrimaryKey(id);
			
			if(i > 0){
				return "true";
			}
		} catch (Exception es) {
			log.error("样本账户删除异常：" + es.getMessage());
		}
		
		return "false";
	}

	public FundPzlog getFundPzlog() {
		return fundPzlog;
	}

	public void setFundPzlog(FundPzlog fundPzlog) {
		this.fundPzlog = fundPzlog;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}