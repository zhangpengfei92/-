package com.jcl.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jcl.comm.StockInfo;
import com.jcl.pojo.AppHelp;
import com.jcl.pojo.PremiumCycle;
import com.jcl.pojo.PremiumPrincipal;
import com.jcl.pojo.RiskSetting;
import com.jcl.pojo.RiskSettingWithBLOBs;
import com.jcl.pojo.StockEnquiry;
import com.jcl.pojo.StockPrincipal;
import com.jcl.pojo.SubFeelog;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhFundLog;
import com.jcl.service.AppHelpInfoService;
import com.jcl.service.PayService;
import com.jcl.service.RiskSettingService;
import com.jcl.service.StockOptionService;
import com.jcl.service.StockPrincipalService;
import com.jcl.service.SubFeelogService;
import com.jcl.service.UserInfoDataService;
import com.jcl.util.Constant;
import com.jcl.util.DateUtil;
import com.jcl.util.QuotaSession;
import com.jcl.util.RedisUtil;
import com.jcl.util.StringUtil;


@Controller
@RequestMapping("/stockoption")
public class StockOptionController {
	
	public static Logger log = Logger.getLogger(StockOptionController.class);
	@Autowired
	private StockOptionService stockOptionService;
	@Autowired
	private StockPrincipalService stockPrincipalService;
	@Autowired
	private SubFeelogService subFeelogService;
	@Autowired
	private UserInfoDataService userInfoDataService;
	@Autowired
	private RiskSettingService riskSettingService;
	@Autowired
	private AppHelpInfoService appHelpInfoService;
	@Autowired
	private PayService payservice;
	/**
	 * 页面跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/stockoptionJump")
	public String resPwd(HttpServletRequest request,HttpSession session){
		String str = request.getParameter("str");
		if("loginPage".equals(str)){
			session.setAttribute(Constant.SESSION_ACCOUNTID, "");
			session.setAttribute(Constant.SESSION_LOGINNAME, "");
			session.setAttribute("userInfo", "");
			session.setAttribute("fristOrderList", "");
			return "login";
		}else if("rgcx".equals(str)){//认购查询
			return "stock/subscription";
		}else if("rg".equals(str)){//认购
			return "stock/newSubscription";
		}else if("cd".equals(str)){//撤单
			return "stock/cancelOrder";
		}else if("cc".equals(str)){//持仓
			return "stock/position";
		}else if("js".equals(str)){//结算
			return "stock/settlement";
		}else if("register".equals(str)){//注册
			String broker = request.getParameter("broker");
			if(StringUtil.isAnyNullOrEmpty(broker)){
				return "register";
			}else{
				Map<String,Object> map2 = new HashMap<String,Object>();
				map2.put("isadmin", 2);
				map2.put("subzh", broker);
				List<Subzh> resultList = userInfoDataService.userLogin(map2);
				if(resultList != null && resultList.size() > 0){
					request.setAttribute("brokerName", resultList.get(0).getName());
				}
				request.setAttribute("broker", broker);
				return "newRegister";
			}
		}else if("chRegister".equals(str)){
			String channel = request.getParameter("broker");
			Map<String,Object> map2 = new HashMap<String,Object>();
			map2.put("isadmin", 2);
			map2.put("subzh", channel);
			List<Subzh> resultList = userInfoDataService.userLogin(map2);
			if(resultList != null && resultList.size() > 0){
				request.setAttribute("brokerList", resultList);
			}
			return "channelRegister";
		}else if("per".equals(str)){
			return "stock/personal";
		}else if("newxj".equals(str)){
			return "stock/newInquiry";
		}else if("newrg".equals(str)){
			return "stock/newSubscription";
		}else if("fundtx".equals(str)){//app专用提现
			return "stock/appfundRaising";
		}else if("fund".equals(str) || "fundInfo".equals(str)){//app专用资金管理 || app专用资金明细
			String username = request.getParameter("username");
			if(!StringUtil.isAnyNullOrEmpty(username)){
				Map<String,Object> channelmap = new HashMap<String,Object>();
				channelmap.put("subzh", username);
				channelmap.put("isadmin", 4);
				List<Subzh> subzhList = userInfoDataService.userLogin(channelmap);//得到经纪人编号
				if(subzhList != null && subzhList.size() > 0){
					Subzh sh = subzhList.get(0);
					BigDecimal rzj = sh.getRzj();
					BigDecimal xzj = sh.getXzj();
					BigDecimal zero = BigDecimal.ZERO;
					DecimalFormat df = new DecimalFormat("######0.00");
					if(rzj != null && rzj.compareTo(zero) !=0 ){
						rzj = new BigDecimal(df.format(rzj));
						sh.setRzj(rzj);
					}else{
						sh.setRzj(zero);
					}
					if(xzj != null && xzj.compareTo(zero) !=0){
						xzj = new BigDecimal(df.format(xzj));
						sh.setXzj(xzj);
					}else{
						sh.setXzj(zero);
					}
					if(sh.getBzj() != null){
						sh.setBzj(new BigDecimal(df.format(sh.getBzj())));
					}
					session.setAttribute("userinfo", sh);
					session.setAttribute(Constant.SESSION_ACCOUNTID, subzhList.get(0).getPhone());
					session.setAttribute(Constant.SESSION_LOGINNAME, subzhList.get(0).getSubzh());
				}
			}
			if("fundInfo".equals(str)){
				return "stock/appfundInfo";
			}else{
				return "stock/appfundManage";
			}
			
		}else if("wtxy".equals(str)){
			return "wordhtml/weituoxiyi";
		}else if("fundchart".equals(str)){//app专用充值
			return "stock/appfundChart";
		}else if("fundchartpc".equals(str)){//pc专用充值
			return "stock/appfundChart";
		}else if("fundpc".equals(str)){//pc专用资金管理
			String username = request.getParameter("username");
			if(!StringUtil.isAnyNullOrEmpty(username)){
				
				payservice.isCheckPaySpt(username);
				
				Map<String,Object> channelmap = new HashMap<String,Object>();
				channelmap.put("subzh", username);
				channelmap.put("isadmin", 4);
				List<Subzh> subzhList = userInfoDataService.userLogin(channelmap);//得到经纪人编号
				if(subzhList != null && subzhList.size() > 0){
					Subzh sh = subzhList.get(0);
					BigDecimal rzj = sh.getRzj();
					BigDecimal xzj = sh.getXzj();
					BigDecimal zero = BigDecimal.ZERO;
					DecimalFormat df = new DecimalFormat("######0.00");
					if(rzj != null && rzj.compareTo(zero) !=0 ){
						rzj = new BigDecimal(df.format(rzj));
						sh.setRzj(rzj);
					}else{
						sh.setRzj(zero);
					}
					if(xzj != null && xzj.compareTo(zero) !=0){
						xzj = new BigDecimal(df.format(xzj));
						sh.setXzj(xzj);
					}else{
						sh.setXzj(zero);
					}
					if(sh.getBzj() != null){
						sh.setBzj(new BigDecimal(df.format(sh.getBzj())));
					}
					session.setAttribute("userinfo", sh);
					session.setAttribute(Constant.SESSION_ACCOUNTID, subzhList.get(0).getPhone());
					session.setAttribute(Constant.SESSION_LOGINNAME, subzhList.get(0).getSubzh());
				}
			}
			return "stock/fundManage";
		}else if("fundtxpc".equals(str)){//pc专用提现
			return "stock/appfundRaising";
		}else if("fundInfopc".equals(str)){//pc专用资金明细
			return "stock/fundInfo";
		}else if("wd".equals(str)){//我的
			return "stock/personal";
		}else if("updatepwd".equals(str)){//修改密码
			return "stock/updatePwd";
		}else if("bz".equals(str)){//帮助pc版
			return "stock/helpInfo";
		}else if("bzapp".equals(str)){//帮助app版
			List<AppHelp> list = appHelpInfoService.getHelpInfoList();
			if(list != null && list.size() > 0){
				session.setAttribute("helpAppList", list.get(0));
			}
			return "stock/helpInfoApp";
		}else if("payMent".equals(str)){//第三方支付
			return "stock/payMent";
		}else if("h5paypc".equals(str)){//h5支付页面
			return "stock/fundChartHFive";
		}else if("wgpaypc".equals(str)){//网关支付页面
			return "stock/fundChartWG";
		}else{//登陆页面
			return "login";
		}
	}

	/**
	 * 询价查询
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getStockEnquiry")
	@ResponseBody
	public Map<String,Object> getStockEnquiry(HttpServletRequest request,HttpSession session){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String phone = request.getParameter("phone");//子账户
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("subzh", phone);
		if(StringUtil.isAnyNullOrEmpty(start)){
			start = "1999-01-01";
		}
		map.put("createtimeStart", start + " 00:00:00");
		if(StringUtil.isAnyNullOrEmpty(end)){
			end = DateUtil.dateToString(Calendar.getInstance().getTime());
		}
		map.put("createtimeEnd", end+ " 23:59:59");
		List<StockEnquiry> list = stockOptionService.getStockEnquiryList(map);
		if(list != null && list.size() > 0){
			session.setAttribute("stockEnquiryList", list);
		}else{
			session.setAttribute("stockEnquiryList", null);
		}
		resultMap.put("code", "0");
		resultMap.put("message", "询价查询成功");
		return resultMap;
	}
	
	/**
	 * 获取周期、名义本金
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getCycleAndPrice")
	@ResponseBody
	public Map<String,Object> getCycleAndPrice(HttpServletRequest request,HttpSession session){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		List<RiskSettingWithBLOBs>  rsList = riskSettingService.getRiskSettingList();//查询风控规则
		if(rsList != null && rsList.size() > 0){
			String cycleJson = rsList.get(0).getCycleJson();
			String bjJson = rsList.get(0).getPrincipalJson();
			
			resultMap.put("cycleJson", JSONArray.parseArray(cycleJson));
			resultMap.put("bjJson", JSONArray.parseArray(bjJson));
		}
		List<PremiumCycle>  pcList = riskSettingService.getPremiumCycle();//查询周期权利金
		if(pcList != null && pcList.size() > 0){
			resultMap.put("cycleList", pcList);
		}
		resultMap.put("code", "0");
		resultMap.put("message", "清除成功");
		return resultMap;
	}
	
	/**
	 * app、新页面认购接口
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/appSubscription")
	@ResponseBody
	public Map<String,Object> appSubscription(HttpServletRequest request,HttpSession session){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		boolean b = getEnquiryDate(new Date());
		if(!b){
			resultMap.put("code", "1");
			resultMap.put("message", "非交易日不能认购");
			return resultMap;
		}
		boolean btime = getEnquiryTime(new Date());
		if(!btime){
			resultMap.put("code", "1");
			resultMap.put("message","非交易时间段");
			return resultMap;
		}
		String subzh = request.getParameter("subzh");//用户编号
		String stockcode = request.getParameter("stockcode");//股票代码
		String stockname = request.getParameter("stockname");//股票名称
		String localsource = request.getParameter("localsource");//h5专用字段
		Map<String,Object> stockmap = new HashMap<String,Object>();
		stockmap.put("stockcode", stockcode.substring(2));
		//股票代码查询对应权利金基数
		List<StockPrincipal> stockList = stockPrincipalService.getStockPrincipalList(stockmap);
		if(stockList == null || stockList.size() == 0){
			resultMap.put("code", "1");
			resultMap.put("message", "当前品种不支持询价");
			return resultMap;
		}
		if(!StringUtil.isAnyNullOrEmpty(stockname)){
			if(StringUtil.isAnyNullOrEmpty(localsource)){
				try {
					stockname = new String(stockname.getBytes("iso-8859-1"),"utf-8");
				} catch (UnsupportedEncodingException e) {
					log.info(e.getMessage());
				}
			}
		}
		String qlj = request.getParameter("qlj");//权利金率 单位：%
		String mybj = request.getParameter("mybj");//名义本金 单位：万元
		String money = request.getParameter("money");//权利金额 单位：元
		/*1：天  2：周  3：月 4：年 */
		String cycletype = request.getParameter("type");//周期 0、周 1、月 2、天 3、年 
		String cyclevalue = request.getParameter("value");//周期数
		
		String cycleqlj = request.getParameter("cycleqlj");//周期上浮点数 单位：%
		String mybjqlj = request.getParameter("mybjqlj");//名义本金上浮点数 单位：%
		
		String endtime = request.getParameter("endtime");//到期时间 yyyy-MM-dd
		
		
		StockEnquiry se = new StockEnquiry();
		Date date = new Date();
		se.setCreatetime(date);
		se.setBuytime(date);
		se.setStarttime(date);
		se.setSubzh(subzh);
		se.setStockcode(stockcode);
		se.setStockname(stockname);
		se.setPrincipalfloat(new BigDecimal(qlj));
		se.setPrincipalbalance(new BigDecimal(mybj));
		se.setRoyaltybalance(new BigDecimal(money).setScale(0, BigDecimal.ROUND_HALF_UP));
		se.setType(cycletype);
		se.setEnquirytime(Integer.parseInt(cyclevalue));
		se.setEndtime(DateUtil.stringToDate(endtime.replace(".", "-"), "yyyy-MM-dd"));
		se.setCyclefloat(new BigDecimal(cycleqlj));
		se.setMybjfloat(new BigDecimal(mybjqlj));
		se.setStatus(1);
		SubzhFundLog sfl = new SubzhFundLog();//认购记录表
		sfl.setModifytime(date);
		sfl.setSubzh(subzh);
		sfl.setBz(new Byte("2"));
		sfl.setType("8");
		sfl.setStatus(new Byte("0"));
		sfl.setAfterfund(new BigDecimal(money));
		
		Map<String,Object> channelmap = new HashMap<String,Object>();
		channelmap.put("subzh", subzh);
		channelmap.put("isadmin", 4);
		List<Subzh> subzhList = userInfoDataService.userLogin(channelmap);//得到经纪人编号
		if(subzhList == null || subzhList.size() == 0){
			resultMap.put("code", "1");
			resultMap.put("message","账户不存在");
			return resultMap;
		}
		if(subzhList != null && subzhList.size() > 0){
			channelmap.put("subzh", subzhList.get(0).getPagentzh());
			channelmap.put("isadmin", 2);//经纪人
			se.setPhone(subzhList.get(0).getPhone());
			sfl.setName(subzhList.get(0).getPhone());
			List<Subzh> agentList = userInfoDataService.userLogin(channelmap);//得到经纪人数据
			if(agentList != null && agentList.size() > 0){
				se.setAgent(agentList.get(0).getName());
				se.setAgentid(agentList.get(0).getSubzh());
				se.setAgentf(new BigDecimal(agentList.get(0).getProportion()));
				sfl.setAgentzh(agentList.get(0).getName());
				
				channelmap.put("subzh", agentList.get(0).getPagentzh());
				channelmap.put("isadmin", 3);//渠道
				List<Subzh> channelList = userInfoDataService.userLogin(channelmap);//得到渠道数据
				if(channelList != null && channelList.size() > 0){
					se.setDitch(channelList.get(0).getName());
					se.setDitchid(channelList.get(0).getSubzh());
					sfl.setReason(channelList.get(0).getName());
					
					se.setOrginf(new BigDecimal(channelList.get(0).getProportion()));
				}
			}
		}else{
			resultMap.put("code", "1");
			resultMap.put("message", "用户不存在");
			return resultMap;
		}
		
		Subzh sz = subzhList.get(0);
		BigDecimal xzj = sz.getXzj();//可用资金
		BigDecimal rzj = sz.getRzj();//总资金
		BigDecimal bzj = sz.getBzj();//冻结资金
		
		Map<String,Object> contionMap = new HashMap<String,Object>();
		contionMap.put("stockCode",stockcode);
		contionMap.put("status",3);
		//查询股票持仓总数
		List<StockEnquiry> steList = stockOptionService.getStockEnquiryListBycontionMap(contionMap);
		List<RiskSettingWithBLOBs>  rsList = riskSettingService.getRiskSettingList();//查询风控规则
		
		if(rsList != null && rsList.size() > 0){
			BigDecimal min = rsList.get(0).getPrincipalMin();
			BigDecimal max = rsList.get(0).getPrincipalMax();
			if(new BigDecimal(mybj).compareTo(min) == -1){
				resultMap.put("code", "1");
				resultMap.put("message", "低于单笔名义本金最低限额");
				return resultMap;
			}
			if(new BigDecimal(mybj).compareTo(max) == 1){
				resultMap.put("code", "1");
				resultMap.put("message", "超过单笔名义本金最大限额");
				return resultMap;
			}
			try {
				if(steList != null && steList.size() > 0){
					BigDecimal totMax = new BigDecimal("0");
					if(rsList != null && rsList.size() > 0){
						totMax = rsList.get(0).getSingleTotalMax();
					}
					BigDecimal sum = new BigDecimal("0");
					for(int i = 0; i < steList.size(); i++){
						sum = sum.add(steList.get(i).getPrincipalbalance());
					}
					if(sum.compareTo(totMax) > 0){
						resultMap.put("code", "1");
						resultMap.put("message", "超过单股名义本金最大限额");
						return resultMap;
					}
				}
				se.setTimefly(rsList.get(0).getLessday()); //最短行权周期 例 T+1
				StockInfo stockinfo = QuotaSession.getStockInfo(se.getStockcode());
				double price = stockinfo.getNewPrice();//现价
				double closeprice = stockinfo.getClosePrice();//昨收价
				
				BigDecimal pricebigd = new BigDecimal(price+"");
				BigDecimal closepricebigd = new BigDecimal(closeprice+"");
				
				BigDecimal riskUpMax = new BigDecimal(rsList.get(0).getUpScopeMax());
				BigDecimal riskDownMax = new BigDecimal(rsList.get(0).getDownScopeMax());
				
				BigDecimal up = riskUpMax.divide(new BigDecimal("100")).add(new BigDecimal("1"));//允许最大涨幅
				BigDecimal down = new BigDecimal("1").subtract(riskDownMax.divide(new BigDecimal("100"))) ;//允许最大跌幅
				BigDecimal upproce = up.multiply(closepricebigd);//涨停价
				BigDecimal downproce = down.multiply(closepricebigd);//跌停价
				
				upproce = upproce.setScale(2, BigDecimal.ROUND_HALF_DOWN);//涨停价
				downproce = downproce.setScale(2, BigDecimal.ROUND_HALF_UP);//跌停价
				if(pricebigd.compareTo(upproce) == 1 || pricebigd.compareTo(upproce) == 0){
					resultMap.put("code", "1");
					resultMap.put("message", "股票涨幅超过限制");
					return resultMap;
				}
				if(pricebigd.compareTo(downproce) == -1 ){
					resultMap.put("code", "1");
					resultMap.put("message", "股票跌幅超过限制");
					return resultMap;
				}
				
//				se.setFreeprice(new BigDecimal(price));
//				BigDecimal fl = se.getPrincipalfloat().divide(new BigDecimal("100"));//权利金
//				BigDecimal xqj = fl.multiply(se.getFreeprice());//增长
//				xqj = xqj.add(se.getFreeprice());
//				se.setEnquiryprice(xqj);
				
			} catch (Exception e1) {
			   log.error("查询股票当前价格信息异常：stockCode->" + se.getStockcode() + e1.getMessage());
			} 
			
		}
		BigDecimal douValue = new BigDecimal(0);
		StringBuffer strBuffer = new StringBuffer("询价成功，认购金额:");
		
		SubFeelog subFeelog = new SubFeelog();
		subFeelog.setSubzh(subzh);
		subFeelog.setFeetype(1);//1:认购
		//douValue = 名义本金(万)*10000*权利金(%)/100
		douValue = new BigDecimal(money);
		Map<String,Object> moneyjson = new HashMap<String,Object>();
		if(bzj != null && (bzj.compareTo(douValue)  == 1 || bzj.compareTo(douValue) == 0)){
			bzj = bzj.subtract(douValue);
			sz.setBzj(bzj);
			moneyjson.put("bzj", douValue);
			moneyjson.put("xzj", Double.parseDouble("0.00"));
		}else{
			if(xzj != null && (rzj.compareTo(douValue) == 1 || rzj.compareTo(douValue) == 0)){
				moneyjson.put("bzj", bzj);
				if(bzj != null){
					moneyjson.put("xzj", douValue.subtract(bzj));
				}else{
					moneyjson.put("xzj", douValue);
				}
				if(bzj == null){
					xzj = xzj.subtract(douValue);
				}else{
					xzj = xzj.add(bzj).subtract(douValue);
				}
				bzj = new BigDecimal("0");
				sz.setBzj(bzj);//可用不可取资金
				sz.setXzj(xzj);//可用可取资金
			}else{
				resultMap.put("code", "1");
				resultMap.put("message","账户余额不足");
				return resultMap;
			}
		}	
		String json = JSON.toJSONString(moneyjson);
		se.setEnquirydesc(json);
		if(sz.getPcx() != null ){
			sz.setPcx(sz.getPcx().add(douValue));//认购冻结资金
		}else{
			sz.setPcx(douValue);//认购冻结资金
		}
		
		//更新subzh 资产和StockEnquiry 状态
		int i = stockOptionService.updateTransStatus(se,sz);
		if(i > 0){
			subFeelog.setAddbalance(douValue);
			strBuffer.append("费用-权利金:").append(douValue);
			subFeelog.setCreatetime(Calendar.getInstance().getTime());
			
			subFeelog.setFeedesc(strBuffer.toString());
			subFeelog.setEnquiryid(se.getId());
			sfl.setDescription(strBuffer.toString());
//			log.info("询价记录：" + subFeelogService.saveSubzhFundlog(sfl));
//			log.info("认购权利金记录：" + subFeelogService.saveSubFeelog(subFeelog));
			Map<String,Object> subzhmap = new HashMap<String,Object>();
			subzhmap.put("username", subzh);
			BigDecimal zero = BigDecimal.ZERO;
			//验证登录信息
			Subzh sh = sz;
			BigDecimal subzhrzj = sh.getRzj();
			BigDecimal subzhxzj = sh.getXzj();
			DecimalFormat df = new DecimalFormat("######0.00");
			if(subzhrzj != null && subzhrzj.compareTo(zero) !=0 ){
				subzhrzj = new BigDecimal(df.format(subzhrzj));
				sh.setRzj(subzhrzj);
			}else{
				sh.setRzj(zero);
			}
			if(subzhxzj != null && subzhxzj.compareTo(zero) !=0){
				subzhxzj = new BigDecimal(df.format(subzhxzj));
				sh.setXzj(subzhxzj);
			}else{
				sh.setXzj(zero);
			}
			if(sh.getBzj() != null){
				sh.setBzj(new BigDecimal(df.format(sh.getBzj())));
			}
			session.setAttribute("userinfo", sh);
			resultMap.put("code", "0");
			resultMap.put("message", "认购成功");
		}else{
			resultMap.put("code", "1");
			resultMap.put("message", "认购失败");
		}
		return resultMap;
	}
	
	
	/**
	 * 查询股票权利金
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getStockFloat")
	@ResponseBody
	public Map<String,Object> getStockFloat(HttpServletRequest request,HttpSession session){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String stockcode = request.getParameter("stockcode");//股票代码
		String stockcycle = request.getParameter("stockcycle");//股票周期
		String stockmybj = request.getParameter("stockmybj");//名义本金
		Map<String,Object> feemap = new HashMap<String,Object>();
		
		if(!StringUtil.isAnyNullOrEmpty(stockcycle)){
			String type = "";
			String time = "";
			String temp = stockcycle.substring(stockcycle.length()-1);
			if("天".equals(temp)){
				type = "1";
				time = stockcycle.substring(0, stockcycle.length()-1);
			}else if("周".equals(temp)){
				type = "2";
				time = stockcycle.substring(0, stockcycle.length()-1);
			}else if("月".equals(temp)){
				type = "3";
				time = stockcycle.substring(0, stockcycle.length()-2);
			}
			
			feemap.put("queryCycleType", type);
			feemap.put("queryCycle", time);
			
			BigDecimal cycleqlj = getCycleqlj(feemap);
			resultMap.put("cycleqlj", cycleqlj);//周期权利金
		}
		if(!StringUtil.isAnyNullOrEmpty(stockcode)){
			feemap.put("stockcode", stockcode.substring(2));
			//股票代码查询对应权利金基数
			List<StockPrincipal> feeList = stockPrincipalService.getStockPrincipalList(feemap);
			if(feeList != null && feeList.size() > 0){
				BigDecimal rp = feeList.get(0).getRealprice();
				resultMap.put("realprice", rp);//基础权利金
			}else{
				resultMap.put("code", "1");
				resultMap.put("message", "股票代码维护中");
				return resultMap;
			}
			
		}
		if(!StringUtil.isAnyNullOrEmpty(stockmybj)){
			//查询名义本金对应上浮点数
			List<PremiumPrincipal> ppList = stockPrincipalService.getPremiumPrincipalList(null);
			if(ppList != null && ppList.size() > 0){
				BigDecimal mybj = new BigDecimal(stockmybj);
				BigDecimal mybjqlj = new BigDecimal("0");
				String rType = "";//ppList.get(0).getRateType();
				BigDecimal rate = new BigDecimal("0");//new BigDecimal(ppList.get(0).getRate());
				for(int i = 0; i < ppList.size(); i++){
					String pp = ppList.get(i).getPrincipal();
					String pps[] = pp.split("-");
					BigDecimal bigdMin = new BigDecimal(pps[0]);
					BigDecimal bigdMax = new BigDecimal(pps[1]);
					if(mybj.compareTo(bigdMin) == 0 || mybj.compareTo(bigdMin) == 1 && mybj.compareTo(bigdMax) == -1){
						rType = ppList.get(i).getRateType();
						rate = new BigDecimal(ppList.get(i).getRate());
						break;
					}
					if(i == ppList.size()){
						resultMap.put("code", "1");
						resultMap.put("message", "名义本金超过限额");
						return resultMap; 
					}
				}
				
				if("1".equals(rType)){
					mybjqlj = rate;
				}else{
					mybjqlj = rate;
				}
				resultMap.put("mybjqlj", mybjqlj);
			}
		}
		resultMap.put("code", "0");
		resultMap.put("message", "查询成功");
		return resultMap;
	}
	
	/**
	 * 获取股票代码权利金list
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/getStockcodeList")
	@ResponseBody
	public Map<String,Object> getStockcodeList(HttpServletRequest request,HttpSession session){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String stockcode = request.getParameter("stockcode");//股票代码
		Map<String,Object> feemap = new HashMap<String,Object>();
		feemap.put("stockcode", stockcode.substring(2));
		List<StockPrincipal> feeList = stockPrincipalService.getStockPrincipalList(feemap);
		if(feeList != null && feeList.size() > 0 ){
			List<Map<String,Object>> resultList = new ArrayList<Map<String,Object>>();
			for(int i = 0; i < feeList.size(); i++){
				Map<String,Object> temp = new HashMap<String,Object>();
				String type = feeList.get(i).getEnquirytype();
				String time = String.valueOf(feeList.get(i).getEnquirytime());
				
				feemap.put("queryCycleType", type);
				feemap.put("queryCycle", time);
				
				BigDecimal cycleqlj = getCycleqlj(feemap);
				BigDecimal stockcodeqlj = feeList.get(i).getRealprice();
				stockcodeqlj = stockcodeqlj.add(cycleqlj);
				temp.put("stockcodeqlj", stockcodeqlj);
				temp.put("cycleqlj", cycleqlj);
				temp.put("cycleType", type);
				temp.put("cycleTime", time);
				resultList.add(temp);
			}
			resultMap.put("stockcodeList", resultList);
			resultMap.put("code", "0");
			resultMap.put("message", "查询成功");
		}else{
			resultMap.put("code", "1");
			resultMap.put("message", "股票正在维护中");
		}
		return resultMap;
	}
	
	/**
	 * 清除缓存
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/clearRedis")
	@ResponseBody
	public Map<String,Object> clearRedis(HttpServletRequest request,HttpSession session){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		String phone = request.getParameter("phone");//子账户
		/*设置缓存*/
		RedisUtil.setString("se"+phone,null);
		resultMap.put("code", "0");
		resultMap.put("message", "清除成功");
		return resultMap;
	}
	
	//查询交易时间
	public boolean getEnquiryTime(Date date){
		boolean bol = false;
		List<RiskSettingWithBLOBs>  rsList = riskSettingService.getRiskSettingList();//查询风控规则
		if(rsList != null && rsList.size() > 0){
			RiskSettingWithBLOBs rs = rsList.get(0);
			String timerisk = rs.getTimeJson();
	    	if(!StringUtil.isAnyNullOrEmpty(timerisk)){
	    	    
	    		List<Map> times = JSON.parseArray(timerisk, Map.class);
	    		for (int i = 0; i < times.size(); i++) {
	    			String end = (String) times.get(i).get("endtime");
	        		String start = (String) times.get(i).get("starttime");
	        		
	        		bol = DateUtil.isBelong(date,start,end);
	        	    if(bol){
	        	    	break;
	        	    }else{
	        	    	continue;
	        	    }
				}
	    	}
    	}
    	return bol;
	}
	
	//查询交易日
	public boolean getEnquiryDate(Date date){
		SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
        String currSun = dateFm.format(date);  
        List<RiskSettingWithBLOBs>  rsList = riskSettingService.getRiskSettingList();//查询风控规则
		if(rsList != null && rsList.size() > 0){
			RiskSetting rs = rsList.get(0);
	        if(rs != null){
	        	if("星期一".equals(currSun)){
	        		if(rs.getMon() == 0){
	        			return true;
	        		}
	        	}else if("星期二".equals(currSun)){
	        		if(rs.getMon() == 0){
	        			return true;
	        		}
	        	}else if("星期三".equals(currSun)){
	        		if(rs.getMon() == 0){
	        			return true;
	        		}
	        	}else if("星期四".equals(currSun)){
	        		if(rs.getMon() == 0){
	        			return true;
	        		}
	        	}else if("星期五".equals(currSun)){
	        		if(rs.getMon() == 0){
	        			return true;
	        		}
	        	}else{
	        		return false;
	        	}
	        	
	        }
		}
		return false;
	}
	//查询周期上浮点数
	public BigDecimal getCycleqlj(Map<String,Object> feemap){
		BigDecimal cycleqlj = new BigDecimal("0");
		List<PremiumCycle> cycleList = stockPrincipalService.getPremiumCycleList(feemap);
		if(cycleList != null && cycleList.size() > 0){
			String rType = cycleList.get(0).getRateType();
			BigDecimal rate = new BigDecimal(cycleList.get(0).getRate());
			if("1".equals(rType)){
				cycleqlj = rate;
			}else{
				cycleqlj = rate;
			}
		}
		return cycleqlj;
	}
	public static void main(String[] args) {
		BigDecimal a = new BigDecimal("3.5");
		BigDecimal b = new BigDecimal("3.7");
		DecimalFormat df = new DecimalFormat("######0.00");
		BigDecimal subtract = b.subtract(a);
		//百分比
		BigDecimal divide = subtract.divide(a,8,BigDecimal.ROUND_HALF_UP);
		BigDecimal profit = divide.multiply(new BigDecimal("100000"));
		System.out.println(new BigDecimal(df.format(profit)));
	}
}