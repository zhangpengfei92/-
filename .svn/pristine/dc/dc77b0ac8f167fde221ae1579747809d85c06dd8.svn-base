package com.jcl.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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
import com.jcl.comm.StockInfo;
import com.jcl.pojo.RiskSettingWithBLOBs;
import com.jcl.pojo.StockEnquiry;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhFundLog;
import com.jcl.service.RiskSettingService;
import com.jcl.service.StockOptionService;
import com.jcl.service.UserInfoDataService;
import com.jcl.util.Constant;
import com.jcl.util.DateUtil;
import com.jcl.util.QuotaSession;
import com.jcl.util.StringUtil;

@Controller
@RequestMapping("/stockoptionDealList")
public class StockOptionDealListController {
	
	public static Logger log = Logger.getLogger(StockOptionController.class);
	@Autowired
	StockOptionService stockOptionService;
	@Autowired
	private UserInfoDataService userInfoDataService;
	@Autowired
	private RiskSettingService riskSettingService;
	
	/**
	 * 查询结算的信息
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/getSetStockEnquiryList")
	@ResponseBody
	public List<StockEnquiry> getSetStockEnquiryList(HttpSession session,String start,String end){
		 List<StockEnquiry> resultList =null;
		//获取子账户
		String subzh=(String) session.getAttribute(Constant.SESSION_LOGINNAME);
		if(! StringUtil.isAnyNullOrEmpty(subzh)){
			Map<String,Object> contionMap=new HashMap<>();
			//子账户
			if(! StringUtil.isAnyNullOrEmpty(start)){
				contionMap.put("start", start);
			}
			if(! StringUtil.isAnyNullOrEmpty(end)){
				contionMap.put("end", end);
			}
			contionMap.put("subzh", subzh);
			//状态 4:认购成功(可以行权)
			contionMap.put("status", "4,5,6");  //3认购成功4行权成功5 放弃行权6 行权中
			resultList=stockOptionService.getStockEnquiryListBycontionMap(contionMap);
		}
		return resultList;
	 }
	/**
	 * 行权调用接口类
	 * @param id
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/executeStockEnquiry")
	@ResponseBody
	public Map<String,Object> executeStockEnquiry(HttpServletRequest request,HttpSession session){
		Integer id = Integer.parseInt(request.getParameter("id"));
		String subzh=request.getParameter("subzh");
		log.info("id==========="+id);
		log.info("subzh==========="+subzh);
		Map<String,Object> resultMap=new HashMap<>();
		DecimalFormat df = new DecimalFormat("######0.00");
		if(! StringUtil.isAnyNullOrEmpty(subzh)){
			StockEnquiry stockEnquiry=stockOptionService.getStockEnquiryById(id);
			boolean btime = getEnquiryTime(new Date());
			if(!btime){
				resultMap.put("code", "1");
				resultMap.put("message","非交易时间段");
				return resultMap;
			}
			//最少行权时间
			Integer day = stockEnquiry.getTimefly();
			if(day !=null){
				long currenTime = stockEnquiry.getBuytime().getTime()+day * 24 * 60 * 60 * 1000;
				long nowTime = new Date().getTime();
				if(nowTime<currenTime){
					resultMap.put("code", 1);
					resultMap.put("msg","请于T+"+day+"天后执行行权");
					return resultMap;
				}
			}
			//行权价
			String stockcode = stockEnquiry.getStockcode();
			StockInfo stockinfo=null;
			double price=0.00;
			try {
				   stockinfo = QuotaSession.getStockInfo(stockcode);
				   price = stockinfo.getNewPrice();
				   String format = df.format(new BigDecimal(price));
				   price=Double.parseDouble(format);
			   } catch (Exception e1) {
				   log.error("查询股票当前价格信息异常：stockCode->" + stockcode + e1.getMessage());
			   }
			//stockEnquiry.setSettleprice(new BigDecimal(price));
			if(stockEnquiry.getFreeprice().doubleValue()>=price){
				resultMap.put("code", 1);
				resultMap.put("msg","当前价低于期初价,无法行权");
				return resultMap;
			}/*else{
				//计算结算盈亏
				//行权的差价
				BigDecimal subtract = new BigDecimal(price).subtract(stockEnquiry.getFreeprice());
				//百分比
				BigDecimal divide = subtract.divide(stockEnquiry.getFreeprice(),7,BigDecimal.ROUND_HALF_UP);
				BigDecimal profit = divide.multiply(stockEnquiry.getPrincipalbalance()).multiply(new BigDecimal(10000));
				stockEnquiry.setProfit(new BigDecimal(df.format(profit)));
			}*/
			//3:下单成功(行权)
			if(stockEnquiry.getStatus()==3){
				SubzhFundLog sfl = new SubzhFundLog();//认购记录表
				sfl.setModifytime(new Date());
				sfl.setSubzh(subzh);
				sfl.setBz(new Byte("2"));
				sfl.setType("4");
				sfl.setStatus(new Byte("0"));
				sfl.setAfterfund(stockEnquiry.getProfit());
				
				
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
					sfl.setName(subzhList.get(0).getPhone());
					List<Subzh> agentList = userInfoDataService.userLogin(channelmap);//得到经纪人数据
					if(agentList != null && agentList.size() > 0){
						sfl.setAgentzh(agentList.get(0).getName());
						
						channelmap.put("subzh", agentList.get(0).getPagentzh());
						channelmap.put("isadmin", 3);//渠道
						List<Subzh> channelList = userInfoDataService.userLogin(channelmap);//得到渠道数据
						if(channelList != null && channelList.size() > 0){
							sfl.setReason(channelList.get(0).getName());
						}
					}
				}else{
					resultMap.put("code", "1");
					resultMap.put("message", "用户不存在");
					return resultMap;
				}
				sfl.setDescription("行权成功，行权盈亏:费用-冻结资金:"+stockEnquiry.getProfit());
				stockEnquiry.setStatus(6);//行权中
				stockEnquiry.setBuytime(new Date());
				/*Subzh userInfo=userInfoDataService.getUserInfoByPhone(stockEnquiry.getPhone());
				//今日卖出冻结
				if(userInfo.getBzj() !=null){
					userInfo.setBzj(userInfo.getBzj().add(stockEnquiry.getProfit()));
				}else{
					userInfo.setBzj(stockEnquiry.getProfit());
				}
				userInfo.setRzj(userInfo.getRzj().add(stockEnquiry.getProfit()));*/
				int i = stockOptionService.updatedStockEnquiry(stockEnquiry,sfl);
				if(i>0){
					/*Subzh sh = userInfo;
					BigDecimal subzhrzj = sh.getRzj();
					BigDecimal subzhxzj = sh.getXzj();
					BigDecimal zero = new BigDecimal("0");
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
					session.setAttribute("userinfo", sh);*/
					resultMap.put("code", 0);
				}else{
					resultMap.put("code", 1);
					resultMap.put("msg","行权失败");
				}
			}
		}else{
			resultMap.put("code", 1);
			resultMap.put("msg","用户不存在");
		}
		return resultMap;
	}
	/**
	 * 查询个股持仓信息
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/getStockEnquiryList")
	@ResponseBody
	public List<StockEnquiry> getStockEnquiryList(HttpSession session){
		List<StockEnquiry> resultList =null;
		//获取子账户
		String subzh=(String) session.getAttribute(Constant.SESSION_LOGINNAME);
		if(! StringUtil.isAnyNullOrEmpty(subzh)){
			Map<String,Object> contionMap=new HashMap<>();
			//子账户
			contionMap.put("subzh", subzh);
			//状态 3:认购成功(可以行权)
			contionMap.put("status", 3);  ////3认购成功4行权成功5 放弃行权6 行权中
			resultList=stockOptionService.getStockEnquiryListBycontionMap(contionMap);
		}
		return resultList;
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
}
