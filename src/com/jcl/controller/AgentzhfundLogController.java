/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : AgentzhfundLogController.java
 * 功能概要  : 提现记录信息 管理Controller类
 * 做成日期  : 2018年04月08日 
 * 修改日期  :
 */
package com.jcl.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jcl.comm.PaginationContext;
import com.jcl.pojo.AgentzhfundLog;
import com.jcl.pojo.AgentzhfundLogExample;
import com.jcl.pojo.FundPzlog;
import com.jcl.pojo.FundPzlogExample;
import com.jcl.pojo.AgentzhfundLogExample.Criteria;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.TradeParam;
import com.jcl.service.AgentzhfundLogService;
import com.jcl.service.SubzhService;
import com.jcl.util.CommonFunc;
import com.jcl.util.Constant;
import com.jcl.util.DeployProperties;
import com.jcl.util.MyExcelUtil;
import com.jcl.util.StringUtil;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import com.unspay.Md5Encrypt;

/**
 * 提现记录信息 管理类
 * 
 * @author jiangzq
 * @version 1.0
 */
@Controller
@RequestMapping("/fundlog")
public class AgentzhfundLogController {
	
	public static Logger log = Logger.getLogger(AgentzhfundLogController.class);
	
	private AgentzhfundLog agentzhfundLog;
	private Object synObj = "126";
	
	/*银生宝快捷支付参数*/
	private static final String UNSPAY_MARKETNO = DeployProperties.getInstance().getUnspayMarket();
	private static final String UNSPAY_PASSWORD = DeployProperties.getInstance().getUnspayPassword();
	/*获取快捷支付地址*/
	//private static final String UNSPAY_QUICKPAY = DeployProperties.getInstance().getUnspayQuickpay();
	/*获取代付地址*/
	private static final String UNSPAY_WITHDRAW = DeployProperties.getInstance().getUnspayPaywithdraw();
	/*获取银生宝支付成功回调地址*/
	private static final String UNSPAY_SUCCESSSERVER = DeployProperties.getInstance().getUnspaySuccessServer();
	//private static final String UNSPAY_CALLBACK = DeployProperties.getInstance().getUnspayCallbackAddr();
	/*提现记录信息管理service*/
	@Autowired
	private AgentzhfundLogService agentzhfundLogService;
	
	/*子账户信息管理service*/
	@Autowired
	private SubzhService subzhService;

	// 会员管理页面跳转
	@RequestMapping("/agentzhfundLogList")
	public String agentzhfundLogList(HttpSession session, Model model) {
		session.setAttribute(Constant.SESSION_LEFTMENU, "2");
		
		List<String> strlist=new ArrayList<String>();
		List<Subzh> sublist=new ArrayList<Subzh>();
		Subzh subzh = new Subzh ();
		String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
		Integer isAdmin = (Integer)session.getAttribute(Constant.SESSION_ISADMIN);
		try {
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
			List<Subzh> userlist = new ArrayList<Subzh>();
			userlist = subzhService.getSubzhLevelList(subzh);
			AgentzhfundLogExample example=new AgentzhfundLogExample();
			Criteria criteria = example.createCriteria();
			criteria.andBzEqualTo((byte)2);
			example.setOrderByClause(" id desc, createtime desc");
				if(userlist!=null && userlist.size()>0){
					for(Subzh su:userlist){
						strlist.add(su.getSubzh());
					}
				criteria.andSubzhIn(strlist);
				}
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			List<AgentzhfundLog> fundlist = agentzhfundLogService.selectByExample(example);
			PageInfo<AgentzhfundLog> userpage = new PageInfo<AgentzhfundLog>(fundlist);
			List<AgentzhfundLog>list=new ArrayList<AgentzhfundLog>();
			if(null!=fundlist&&fundlist.size()>0) {
				for (AgentzhfundLog agentzhfundlog : fundlist) {
					Subzh subzhs=subzhService.selectBySubzh(agentzhfundlog.getSubzh());
					if(subzhs!=null) {
						if(!StringUtil.isAllNullOrEmpty(subzhs.getAllocbroker())) {
							Subzh broker=subzhService.selectBySubzh(subzhs.getAllocbroker());
							if(!StringUtil.isAllNullOrEmpty(broker.getName())) {
								agentzhfundlog.setAllocbroker(broker.getName());
							}
						}
						if(!StringUtil.isAllNullOrEmpty(subzhs.getAllocagent())) {
							Subzh agent=subzhService.selectBySubzh(subzhs.getAllocagent());
							if(!StringUtil.isAllNullOrEmpty(agent.getName())) {
								agentzhfundlog.setAllocagent(agent.getName());
							}
							
						}
						if(!StringUtil.isAllNullOrEmpty(subzhs.getAllocchannel())) {
							Subzh channel=subzhService.selectBySubzh(subzhs.getAllocchannel());
							if(!StringUtil.isAllNullOrEmpty(channel.getName())) {
								agentzhfundlog.setAllocchannel(channel.getName());
							}
						}
					}				
						list.add(agentzhfundlog);						
				}
			}
			
			model.addAttribute("userlist", list);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return "fund/agentzhfundLogList";
	}

	// 会员列表模糊查询
	@RequestMapping("/selectPage")
	public String selectPage(Subzh subzh, Model model,HttpSession session) throws UnsupportedEncodingException {
		List<String> strlist=new ArrayList<String>();
		List<Subzh> sublist=new ArrayList<Subzh>();
		String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
		Integer isAdmin = (Integer)session.getAttribute(Constant.SESSION_ISADMIN);
		try {
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
			List<Subzh> userlist = new ArrayList<Subzh>();
			userlist = subzhService.getSubzhLevelList(subzh);
	
			
			AgentzhfundLogExample example=new AgentzhfundLogExample();
			Criteria criteria = example.createCriteria();
			criteria.andBzEqualTo((byte)2);
			example.setOrderByClause(" id desc, createtime desc");
			String nickname=subzh.getSubzh();
			if(!StringUtil.isAllNullOrEmpty(nickname)) {
				criteria.andSubzhLike("%"+nickname+"%");
			}else {
				if(userlist!=null && userlist.size()>0){
					for(Subzh su:userlist){
						strlist.add(su.getSubzh());
					}
				criteria.andSubzhIn(strlist);
				}
				
			}
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			List<AgentzhfundLog> fundlist = agentzhfundLogService.selectByExample(example);
			PageInfo<AgentzhfundLog> userpage = new PageInfo<AgentzhfundLog>(fundlist);
			List<AgentzhfundLog>list=new ArrayList<AgentzhfundLog>();
			if(null!=fundlist&&fundlist.size()>0) {
				for (AgentzhfundLog agentzhfundlog : fundlist) {
					Subzh subzhs=subzhService.selectBySubzh(agentzhfundlog.getSubzh());
					if(subzhs!=null) {
						if(!StringUtil.isAllNullOrEmpty(subzhs.getAllocbroker())) {
							Subzh broker=subzhService.selectBySubzh(subzhs.getAllocbroker());
							if(!StringUtil.isAllNullOrEmpty(broker.getName())) {
								agentzhfundlog.setAllocbroker(broker.getName());
							}
						}
						if(!StringUtil.isAllNullOrEmpty(subzhs.getAllocagent())) {
							Subzh agent=subzhService.selectBySubzh(subzhs.getAllocagent());
							if(!StringUtil.isAllNullOrEmpty(agent.getName())) {
								agentzhfundlog.setAllocagent(agent.getName());
							}
							
						}
						if(!StringUtil.isAllNullOrEmpty(subzhs.getAllocchannel())) {
							Subzh channel=subzhService.selectBySubzh(subzhs.getAllocchannel());
							if(!StringUtil.isAllNullOrEmpty(channel.getName())) {
								agentzhfundlog.setAllocchannel(channel.getName());
							}
						}
					}				
						list.add(agentzhfundlog);						
				}
			}
			
			model.addAttribute("sub", subzh);
			model.addAttribute("nickname", nickname);
			model.addAttribute("userlist", list);
			model.addAttribute("userpage", userpage);
		} catch (Exception e) {
			log.error("查询提现记录列表异常：" + e);
		}		
		return "fund/agentzhfundLogList";
	}
	
	
		// 导出
		@RequestMapping("/selectExport")
		public void selectExport(Subzh subzh, Model model,HttpSession session,HttpServletResponse response)  {
			List<String> strlist=new ArrayList<String>();
			List<Subzh> sublist=new ArrayList<Subzh>();
			String username = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
			Integer isAdmin = (Integer)session.getAttribute(Constant.SESSION_ISADMIN);
			try {
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
				List<Subzh> userlist = new ArrayList<Subzh>();
				userlist = subzhService.getSubzhLevelList(subzh);
		
							
				AgentzhfundLogExample example=new AgentzhfundLogExample();
				Criteria criteria = example.createCriteria();
				criteria.andBzEqualTo((byte)2);
				example.setOrderByClause(" id desc, createtime desc");
				String nickname=subzh.getSubzh();
				if(!StringUtil.isAllNullOrEmpty(nickname)) {
					criteria.andSubzhLike("%"+nickname+"%");
				}else {
					if(userlist!=null && userlist.size()>0){
						for(Subzh su:userlist){
							strlist.add(su.getSubzh());
						}
					criteria.andSubzhIn(strlist);
					}
					
				}
				PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
				List<AgentzhfundLog> fundlist = agentzhfundLogService.selectByExample(example);
				PageInfo<AgentzhfundLog> userpage = new PageInfo<AgentzhfundLog>(fundlist);
				List<AgentzhfundLog>list=new ArrayList<AgentzhfundLog>();
				if(null!=fundlist&&fundlist.size()>0) {
					for (AgentzhfundLog agentzhfundlog : fundlist) {
						Subzh subzhs=subzhService.selectBySubzh(agentzhfundlog.getSubzh());
						if(subzhs!=null) {
							if(!StringUtil.isAllNullOrEmpty(subzhs.getAllocbroker())) {
								Subzh broker=subzhService.selectBySubzh(subzhs.getAllocbroker());
								if(!StringUtil.isAllNullOrEmpty(broker.getName())) {
									agentzhfundlog.setAllocbroker(broker.getName());
								}
							}
							if(!StringUtil.isAllNullOrEmpty(subzhs.getAllocagent())) {
								Subzh agent=subzhService.selectBySubzh(subzhs.getAllocagent());
								if(!StringUtil.isAllNullOrEmpty(agent.getName())) {
									agentzhfundlog.setAllocagent(agent.getName());
								}
								
							}
							if(!StringUtil.isAllNullOrEmpty(subzhs.getAllocchannel())) {
								Subzh channel=subzhService.selectBySubzh(subzhs.getAllocchannel());
								if(!StringUtil.isAllNullOrEmpty(channel.getName())) {
									agentzhfundlog.setAllocchannel(channel.getName());
								}
							}
						}				
							list.add(agentzhfundlog);						
					}
				}
				SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日");
				JSONArray ja = new JSONArray();// 获取业务数据集
				ja.addAll(list);
				Map<String, String> headMap = new LinkedHashMap<String, String>();
/*				headMap.put("allocchannel", "所属渠道");
				headMap.put("allocagent", "所属代理商");
				headMap.put("allocbroker", "所属经纪人");*/
				headMap.put("subzh", "账户代号");
				headMap.put("cmd", "类型");
				headMap.put("fund", "金额");
				headMap.put("accountType", "状态");
				headMap.put("modifytime", "更新时间");
				MyExcelUtil.downloadExcelFile("提现审核" + myFmt.format(new Date()), headMap, ja, "yyyy-MM-dd HH:mm:ss", 0,
						response);
			}
				catch (Exception e) {
					log.error("生成提现审核报表异常",e);
				}
		}

		
	// 编辑会员
	@RequestMapping("/editAgentzhfundLog")
	public String editAgentzhfundLog(Integer id, Model model) {
		try {
			/*List<RightsRole> roles = rightsRoleService.getListByLikeName(null);
			model.addAttribute("rightsRoles", roles);*/
			AgentzhfundLog user = agentzhfundLogService.selectByPrimaryKey(id);
			/*if(user.getStarttime() != null){
				model.addAttribute("starttimeStr", DateUtil.dateToString(user.getStarttime()));
			}
			if(user.getEndtime() != null){
				model.addAttribute("endtimeStr", DateUtil.dateToString(user.getEndtime()));
			}*/
			model.addAttribute("user", user);
		} catch (Exception e) {
			log.error("获取权限列表异常：" + e.getMessage());
		}
		return "fund/addAgentzhfundLog";
	}
	
	// 新增会员
	@RequestMapping("/addAgentzhfundLog")
	public String addAgentzhfundLog(Integer id, Model model) {
		try {
			/*List<RightsRole> roles = rightsRoleService.getListByLikeName(null);
			model.addAttribute("rightsRoles", roles);*/
			AgentzhfundLog user = agentzhfundLogService.selectByPrimaryKey(id);
			model.addAttribute("user", user);
		} catch (Exception e) {
			log.error("获取权限列表异常：" + e.getMessage());
		}
		return "fund/addAgentzhfundLog";
	}
	
	// 编辑会员
	@RequestMapping("/editAgentzhfundLogMsg")
	@ResponseBody
	public String editAgentzhfundLogMsg(AgentzhfundLog user, String starttimeStr, String endtimeStr, Integer id) {
		
		return "false";
	}

	// 批量删除
	@RequestMapping("/deleteAgentzhfundLogList")
	@ResponseBody
	public String deleteAgentzhfundLogList(Integer[] ids) {
		if (ids != null) {
			/*for (Integer id : ids) {
				try {
					//AgentzhfundLog user = AgentzhfundLogservice.selectByPrimaryKey(id);
					//user.setStatus(0);
					//i = AgentzhfundLogservice.updateByPrimaryKey(user);
					//AgentzhfundLogservice.deleteByPrimaryKey(id);
				} catch (Exception e) {
					log.error("删除提现记录异常：" + e.getMessage());
					return "false";
				}
			}*/
		}
		return "true";
	}

	// 单个删除
	@RequestMapping("/deleteAgentzhfundLog")
	@ResponseBody
	public String deleteAgentzhfundLog(Integer id) {
		try {
			agentzhfundLogService.deleteByPrimaryKey(id);
		} catch (Exception e) {
			log.error("删除提现记录异常：" + e.getMessage());
			return "false";
		}
		return "true";
	}
	
	//审核通过
	//废弃  20180621-zpf 原因：提现审核在出入金的fundController中操作
	@RequestMapping("/reinstate")
	@ResponseBody
	public String reinstate(Integer id, Integer status) {
		int i = 0;
		try {
			if(id != null && id > 0){
				agentzhfundLog = agentzhfundLogService.selectByPrimaryKey(id);
				if(agentzhfundLog != null && agentzhfundLog.getStatus() != null && agentzhfundLog.getStatus() == 4){/*状态   2:预提现  3：提现成功   4:提现申请  5：审核通过  6：拒绝*/
					if(status != null && status == 6){
						try {
							agentzhfundLog.setName("中金原油投顾提现");
							agentzhfundLog.setDescription("中金原油投顾提现:" + agentzhfundLog.getFund() + " 订单号:" + agentzhfundLog.getDescription());
							agentzhfundLog.setStatus(6);/*状态   2:预提现  3：提现成功   4:提现申请  5：审核通过  6：拒绝*/
			 				//fundLog.setModifytime(Calendar.getInstance().getTime());
			 				log.info("审核通过保存状态：" + agentzhfundLogService.updateByPrimaryKey(agentzhfundLog));
			 			} catch (Exception efundlog) {
			 				log.error("保存预提现信息异常：" + efundlog.getMessage());
			 			}
						
						try {
							Subzh subzhEntity = subzhService.selectByPrimaryKey(agentzhfundLog.getSubzh());
							synchronized (synObj) {
				 				if(subzhEntity.getFundbalance() != null){
				 					subzhEntity.setFundbalance(subzhEntity.getFundbalance().add(agentzhfundLog.getFund()));
				 				} else {
				 					subzhEntity.setFundbalance(agentzhfundLog.getFund());
				 				}
				 				log.info("审核拒绝返现，保存资产状态：" + subzhService.updateByPrimaryKey(subzhEntity));
				 			}
						} catch (Exception es) {
			 				log.error("审核拒绝返现，保存资产信息异常：" + es.getMessage());
			 			}
						return "true";
					}
					
					String requestid = "1";//订单号
					if(agentzhfundLog.getSubzh().length() > 5){
						requestid = agentzhfundLog.getSubzh().substring(agentzhfundLog.getSubzh().length()-5, agentzhfundLog.getSubzh().length()) + System.currentTimeMillis();
					} else {
						requestid = agentzhfundLog.getSubzh() + System.currentTimeMillis();
					}
					String queryBalanceUrl = UNSPAY_WITHDRAW + "delegatePay/pay";
					StringBuffer paramStr = new StringBuffer();
					StringBuffer sf = new StringBuffer();
					sf.append("accountId=").append(UNSPAY_MARKETNO);
					sf.append("&name=").append(agentzhfundLog.getName());
					sf.append("&cardNo=").append(agentzhfundLog.getDescription());//银行卡号
					sf.append("&orderId=").append(requestid);
					sf.append("&purpose=").append("中金原油投顾");
					sf.append("&amount=").append(agentzhfundLog.getFund().doubleValue());
					sf.append("&responseUrl=").append(UNSPAY_SUCCESSSERVER);
					sf.append("&key=").append(UNSPAY_PASSWORD);
					
					String mac = Md5Encrypt.md5(sf.toString()).toUpperCase();
					paramStr.append("accountId=").append(UNSPAY_MARKETNO);
					paramStr.append("&name=").append(URLEncoder.encode(agentzhfundLog.getName(), "UTF-8"));
					paramStr.append("&cardNo=").append(agentzhfundLog.getDescription());//银行卡号
					paramStr.append("&orderId=").append(requestid);
					paramStr.append("&purpose=").append(URLEncoder.encode("中金原油投顾", "UTF-8"));
					paramStr.append("&amount=").append(agentzhfundLog.getFund().doubleValue());
					paramStr.append("&responseUrl=").append(UNSPAY_SUCCESSSERVER);
					paramStr.append("&mac=").append(mac);
			       
				 	//String result = HttpFormParam.doPost(queryBalanceUrl, param);
			        String result = CommonFunc.sendPost(queryBalanceUrl, paramStr.toString());
				 	log.info("提现请求接口返回>>"+result);
				 	JSONObject array = new JSONObject(result);	
			 		String result_code = array.getString("result_code");
			 		if(!StringUtil.isAnyNullOrEmpty(result_code) && "0000".equals(result_code)){
			 			try {
			 				agentzhfundLog.setName("中金原油投顾提现" + requestid);
			 				agentzhfundLog.setDescription("中金原油投顾提现:" + agentzhfundLog.getFund() + " 订单号:" + requestid);
			 				agentzhfundLog.setStatus(5);/*状态   2:预提现  3：提现成功   4:提现申请  5：审核通过  6：拒绝*/
			 				//fundLog.setModifytime(Calendar.getInstance().getTime());
			 				log.info("审核通过保存状态：" + agentzhfundLogService.updateByPrimaryKey(agentzhfundLog));
			 			} catch (Exception efundlog) {
			 				log.error("保存预提现信息异常：" + efundlog.getMessage());
			 			}
			 			return "true";
			 		} else {
			 			try {
			 				agentzhfundLog.setName("中金原油投顾提现");
			 				agentzhfundLog.setDescription("中金原油投顾提现:" + agentzhfundLog.getFund() + " 订单号:" + agentzhfundLog.getDescription());
			 				agentzhfundLog.setStatus(6);/*状态   2:预提现  3：提现成功   4:提现申请  5：审核通过  6：拒绝*/
			 				//fundLog.setModifytime(Calendar.getInstance().getTime());
			 				log.info("审核银生宝拒绝保存状态：" + agentzhfundLogService.updateByPrimaryKey(agentzhfundLog));
			 				try {
			 					Subzh subzhEntity = subzhService.selectByPrimaryKey(agentzhfundLog.getSubzh());
								synchronized (synObj) {
					 				if(subzhEntity.getFundbalance() != null){
					 					subzhEntity.setFundbalance(subzhEntity.getFundbalance().add(agentzhfundLog.getFund()));
					 				} else {
					 					subzhEntity.setFundbalance(agentzhfundLog.getFund());
					 				}
					 				log.info("审核拒绝返现，保存资产状态：" + subzhService.updateByPrimaryKey(subzhEntity));
					 			}
							} catch (Exception es) {
				 				log.error("审核拒绝返现，保存资产信息异常：" + es.getMessage());
				 			}
			 			} catch (Exception efundlog) {
			 				log.error("保存预提现信息异常：" + efundlog.getMessage());
			 			}
			 			return array.getString("result_msg");
			 		}
				}
			}
		} catch (Exception e) {
			log.error("删除账户异常：" + e.getMessage());
		}
		if (i > 0) {
			return "true";
		} else {
			return "false";
		}
	}
	
	
	/**
	 * 
	 * @return 
	 * @author heqiwen
	 * @date 2018-6-11
	 * @decribe
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping("/checkWithdraw")
	@ResponseBody
	public String checkWithdraw(Integer id, Integer status) {

		try {
				AgentzhfundLog fundLog = agentzhfundLogService.selectByPrimaryKey(id);  
				Subzh subzhEntity=null;
				if(fundLog != null){
					if(status!=null && status==6){
						try {
			 				fundLog.setStatus(6);/*状态   0是申请姿态。1是成功 5：审核通过  6：拒绝*/
			 				fundLog.setModifytime(Calendar.getInstance().getTime());
			 				log.info("审核通过保存状态：" + agentzhfundLogService.updateByPrimaryKey(fundLog));
			 			} catch (Exception efundlog) {
			 				log.error("保存预提现信息异常：" + efundlog.getMessage());
			 				return "false";
			 			}
						
						try {
							subzhEntity = subzhService.getPuriSubzh((fundLog.getSubzh()));
							synchronized (synObj) {
				 				if(subzhEntity.getFundbalance() != null){
				 					BigDecimal fund=new BigDecimal(String.valueOf(fundLog.getFund()));
				 					subzhEntity.setFundbalance(subzhEntity.getFundbalance().add(fund));
				 				} else {
				 					subzhEntity.setFundbalance(fundLog.getFund());
				 				}
				 				log.info("审核拒绝返现，保存资产状态：" + subzhService.updateByPrimaryKey(subzhEntity));
				 			}
						} catch (Exception es) {
			 				log.error("审核拒绝返现，保存资产信息异常：" + es.getMessage());
			 				return "false";
			 			}
						
						return "true";
					}
					
					//如果审核通过
					String province=fundLog.getProvince();
					String city=fundLog.getCity();
					String name =fundLog.getName();
					String account=fundLog.getDescription();
					String bankName=fundLog.getBanchname();
					String bankCode=fundLog.getType();
					String orderNo=fundLog.getOrderno();
					String branchName=fundLog.getBanchname();
					String platformID = "100672";	//商户接口编号，请根据开户信息填写
					String merchNo = "61504577@qq.com";	//商户帐号，请根据开户信息填写
					String key="EEA46BFE79F36370834C78F45813C36B";
					String apiName="TRAN_PFA";
					DecimalFormat df = new DecimalFormat("######0.00");
					Double amt=fundLog.getFund().doubleValue();
					String amtp=df.format(amt);
					//这里提现的密钥可能和支付密钥不一样。  可以是45B19269B6B7。
					String ms="45B19269B6B7";//提现密钥
					String srcMsg = String.format("apiName=%s&platformID=%s&merchNo=%s&orderNo=%s&amt=%s&bankName=%s&bankCode=%s&account=%s&name=%s&province=%s&city=%s&branchName=%s",
							apiName, platformID, merchNo, orderNo, amtp, bankName, bankCode,account,name,province,city,branchName);
					
					//加KEY
					srcMsg=srcMsg+key;
					//计算签名
					MessageDigest md5 = MessageDigest.getInstance("MD5");
					byte[] sign = md5.digest(srcMsg.getBytes("UTF-8"));
					StringBuffer ret = new StringBuffer(sign.length);
					String hex = "";
					for (int i = 0; i < sign.length; i++) {
						hex = Integer.toHexString(sign[i] & 0xFF);
						if (hex.length() == 1) {
								hex = '0' + hex;
						}
						ret.append(hex);
					}
					String signMsg = ret.toString();
					
					String queryBalanceUrl = "http://pay.lylefeng.com/pay_pfa.php";
					StringBuffer paramStr = new StringBuffer();
					
					paramStr.append("apiName=").append(apiName);
					paramStr.append("&platformID=").append(platformID);
					paramStr.append("&merchNo=").append(merchNo);//
					paramStr.append("&orderNo=").append(orderNo);
					paramStr.append("&amt=").append(amtp);
					paramStr.append("&bankName=").append(bankName);
					paramStr.append("&bankCode=").append(bankCode);
					paramStr.append("&account=").append(account);
					paramStr.append("&name=").append(name);
					paramStr.append("&province=").append(province);
					paramStr.append("&city=").append(city);
					paramStr.append("&branchName=").append(branchName);
					paramStr.append("&ms=").append(ms);
					paramStr.append("&signMsg=").append(signMsg);
			       
			        String result = CommonFunc.sendPost(queryBalanceUrl, paramStr.toString());
				 	log.info("提现请求接口返回>>"+result);
				 	if(result.indexOf("{")<0){
				 		return result;
				 	}
				 	JSONObject array = new JSONObject(result);	
				 	//返回的结果中其中status 为0或2表示处理中， status为1表示到帐成功，为3表示到帐失败
				 	//{
//					"platformID": "300111",
//					"userOrderId": "14662415363961",
//					"retCode": "SUCCESS",
//					"retMsg": "OK",
//					"status": "0",
//					"transTime": "2016-06-18 17:12:15"
//				}
			 		String state = array.getString("status");
			 		log.info("提现请求接口status:=>>"+state);
			 		if(!StringUtil.isAnyNullOrEmpty(state) && "1".equals(state)){//到帐成功
			 			try {
			 				fundLog.setStatus(5);/*状态   2:预提现  3：提现成功   4:提现申请  5：审核通过  6：拒绝*/
			 				fundLog.setModifytime(Calendar.getInstance().getTime());
			 				String accno=array.getString("userOrderId");
			 				fundLog.setAccNo(accno);
			 				log.info("审核通过保存状态：" + agentzhfundLogService.updateByPrimaryKey(fundLog));
			 			} catch (Exception efundlog) {
			 				log.error("保存预提现信息异常：" + efundlog.getMessage());
			 			}
			 			return "true";
			 		} else if(!StringUtil.isAnyNullOrEmpty(state) && "3".equals(state)){
			 			try {
			 				fundLog.setDescription("提现:" + fundLog.getFund() + " 订单号:" + fundLog.getDescription());
			 				fundLog.setStatus(3);/*状态   2:预提现  3：提现失败  4:提现申请  5：审核通过  6：拒绝*/
			 				fundLog.setModifytime(Calendar.getInstance().getTime());
			 				log.info("审核天宏付拒绝保存状态：" + agentzhfundLogService.updateByPrimaryKey(fundLog));
			 				try {
								subzhEntity = subzhService.getPuriSubzh((fundLog.getSubzh()));
								synchronized (synObj) {
					 				if(subzhEntity.getFundbalance() != null){
					 					BigDecimal fund=new BigDecimal(String.valueOf(fundLog.getFund()));
					 					subzhEntity.setFundbalance(subzhEntity.getFundbalance().add(fund));
					 				} else {
					 					subzhEntity.setFundbalance(fundLog.getFund());
					 				}
					 				log.info("审核拒绝返现，保存资产状态：" + subzhService.updateByPrimaryKey(subzhEntity));
					 			}
							} catch (Exception es) {
				 				log.error("审核拒绝返现，保存资产信息异常：" + es.getMessage());
				 			}
			 			} catch (Exception efundlog) {
			 				log.error("保存预提现信息异常：" + efundlog.getMessage());
			 			}
			 			return "提现失败";
			 		}else{
			 			return "存在处理过程中";
			 		}
			 		
				} else {
					return "审核信息不存在";
				}
			} catch (Exception es) {
				es.printStackTrace();
				log.error("根据账户提现申请信息异常：subzh->" + es.getMessage());
			}
			return null;
		
	}
	
	
	
	//增加测试金
	@RequestMapping("/addUserFund")
	@ResponseBody
	public String addUserFund(HttpServletRequest request, String subzh) {
		String re="false";
		try {
			subzh = request.getParameter("subzh");
			if(!StringUtil.isAnyNullOrEmpty(subzh)){
				double fundDouble = 500000d;
				try {
					Subzh subzhEntity = subzhService.selectByPrimaryKey(subzh);
					synchronized (synObj) {
		 				if(subzhEntity.getFundbalance() != null){
		 					subzhEntity.setFundbalance(subzhEntity.getFundbalance().add(new BigDecimal(fundDouble)));
		 				} else {
		 					subzhEntity.setFundbalance(new BigDecimal(fundDouble));
		 				}
		 				log.info("审核拒绝返现，保存资产状态：" + subzhService.updateByPrimaryKey(subzhEntity));
		 			}
				} catch (Exception es) {
	 				log.error("审核拒绝返现，保存资产信息异常：" + es.getMessage());
	 			}
				String str = "{\"subzh\":\""+subzh+"\",\"setpro\":3,\"fundtype\":1,\"fundBalance\":0,\"nowBalance\":500000,\"feeBalance\":0.0}";
				str = Base64.encode(str.getBytes());
				log.info("data=" + str);
				str = CommonFunc.sendPost("http://127.0.0.1:8081/ctpcms/servlet/PageFundPzlogServlet", "data="+str);
				re="true";
				return re;
			}
		} catch (Exception e) {
			re="false";
			log.error("删除账户异常：" + e.getMessage());
		}
		return re;
	}

	public AgentzhfundLog getAgentzhfundLog() {
		return agentzhfundLog;
	}

	public void setAgentzhfundLog(AgentzhfundLog agentzhfundLog) {
		this.agentzhfundLog = agentzhfundLog;
	}
	
}