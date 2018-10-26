/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @FundController.java
 * 功能概要  : 
 * 做成日期  : @2018年8月30日
 * 修改日期  :
 */
package com.jcl.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jcl.dao.SptMapper;
import com.jcl.dao.SubzhMapper;
import com.jcl.pojo.Subzh;
import com.jcl.pojo.SubzhFundLog;
import com.jcl.pojo.SubzhKey;
import com.jcl.service.PayService;
import com.jcl.service.SubzhFundLogService;
import com.jcl.service.UserInfoDataService;
import com.jcl.util.Base64;
import com.jcl.util.Constant;
import com.jcl.util.DeployProperties;
import com.jcl.util.StringUtil;
import com.jcl.util.spt.SignMd5Utils;

/** 
 * @author zpf
 * @version 1.0
 * 
 * pc网关充值
 */
@Controller
@RequestMapping("/fund")
public class FundController {
	
	public static Logger log = Logger.getLogger(FundController.class);

	@Autowired
	private SubzhFundLogService subzhFundLogService;
	@Autowired
	private UserInfoDataService userInfoDataService;
	
	@Autowired
	private SubzhMapper subzhmapper;
	@Autowired
	private SptMapper sptmapper;
	@Autowired
	private PayService payservice;

	private static final String project_path = DeployProperties.getInstance().getPublicProjectePath();
	
	@RequestMapping("/toPaypc")
	public  String toPaypc(HttpSession session,Model model) {
		Subzh subzh = (Subzh) session.getAttribute("userinfo");
		try {
			if(subzh!=null) {
				SubzhKey subzhkey=new SubzhKey();
				subzhkey.setCookie(subzh.getCookie());
				subzhkey.setSubzh(subzh.getSubzh());
				subzh = subzhmapper.selectByPrimaryKey(subzh);
				
				model.addAttribute("subzh", subzh);
			}
		} catch (Exception e) {
			log.error("查询用户信息异常", e);
		}
		
		return "stock/fundpaypc";	
	}
	
	@RequestMapping("/topayLogin")
	public  String topayLogin() {
		
		
		return "stock/paylogin";	
	}
	
	@RequestMapping("/payLogin")
	@ResponseBody
	public Map<String,Object> payLogin(HttpServletRequest request,HttpSession session) {
		
		
		String sessionId=request.getSession().getId();
		
		String userPhone = request.getParameter("phone");
		String userPwd = request.getParameter("password");
		/*手机类型*/
		String phoneType = request.getParameter("location");
		if(!StringUtil.isAllNullOrEmpty(phoneType)){
			byte[] base64 = Base64.decode(userPwd);
			try {
				userPwd = new String(base64,"iso-8859-1");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("username", userPhone);
		map.put("password", userPwd);
		BigDecimal zero = BigDecimal.ZERO;
		//验证登录信息
		List<Subzh> list = userInfoDataService.userLogin(map);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		if(list != null && list.size()>0){
			session.setAttribute(Constant.SESSION_ACCOUNTID, list.get(0).getPhone());
			session.setAttribute(Constant.SESSION_LOGINNAME, list.get(0).getSubzh());
			Subzh sh = list.get(0);
			BigDecimal rzj = sh.getRzj();
			BigDecimal xzj = sh.getXzj();
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
			
			resultMap.put("code", "0");
			resultMap.put("message", "登录成功");
			resultMap.put("sid", sessionId);
			resultMap.put("subzh", sh.getSubzh());
		}else{
			resultMap.put("code", "1");
			resultMap.put("message", "账号或密码错误");
		}
		return resultMap;	
	}
	
	@RequestMapping(value = "/pcpayMent")
	public String pcpayMent(HttpServletRequest request, Model model) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String dates = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		String username = request.getParameter("username");// 用户编号
		String Amonut = request.getParameter("txmoney"); // 元
		BigDecimal money = new BigDecimal(Amonut);
		money = money.multiply(new BigDecimal("100")).setScale(0);

		String url = Constant.SPT_WG_PAY_URL;
		String testKey = Constant.SPT_SECRTKEY;// 秘钥

		Map<String, String> payMap = new HashMap<String, String>();
		// 必填参数
		payMap.put("merch", Constant.SPT_MERCHART);// 商户号
		String orderno=dates + StringUtil.getRandomString(4)+username;
		payMap.put("orderno",orderno); // 商户订单号，查询时需要

		payMap.put("amount", money.toString()); // 金额，单位分
		payMap.put("tranchannel", "CMB"); // 银行渠道编码
		payMap.put("body", "充值");// 商品描述

		payMap.put("notifyurl",project_path+ "/subzhfund/returnSptPayMent");// 异步回调通知地址
		payMap.put("pageurl", project_path+ "/fund/toPaypc");// 异步回调通知地址
		
		payMap.put("comment", username);// 附加信息
		String sign = SignMd5Utils.createSign(payMap, testKey);// 签名
		payMap.put("sign", sign);// 签名串
		payMap.put("signtype", "MD5");
		SubzhFundLog agentzhfundLog = new SubzhFundLog();
		saveAgentzhfundLog(agentzhfundLog, username, orderno, new Date(),money, 1, 1);

		model.addAttribute("payMap", payMap);
		model.addAttribute("url", url);
		return "stock/payMentpc";
	}
	
	
	
	/**
	 * 
	 * @param agentzhfundLog 
	 * @param username 用户id--subzh
	 * @param order_no  交易订单号
	 * @param pay_time	交易时间
	 * @param total_fee 交易金额
	 * @param paystate  操作状态
	 * @param bz 操作类型  
	 * @return
	 */
	private SubzhFundLog saveAgentzhfundLog(SubzhFundLog agentzhfundLog,String username,String order_no,Date pay_time,BigDecimal total_fee,int paystate,int bz){
		try{
			String type=bz==1?"6":bz==2?"7":"";
			
			agentzhfundLog.setSubzh(username);
			agentzhfundLog.setBankflownum(order_no);
			agentzhfundLog.setType(type);
			agentzhfundLog.setBz((byte)bz);//充值
			agentzhfundLog.setAfterfund(total_fee);
			agentzhfundLog.setModifytime(pay_time);
			agentzhfundLog.setFund(total_fee);
			//agentzhfundLog.setStatus((byte)paystate);//支付成功
			agentzhfundLog.setName(agentzhfundLog.getName());		
			Map<String, Object> channelmap = new HashMap<String, Object>();
			channelmap.put("subzh", username);	
			List<Subzh> subzhList = userInfoDataService.userLogin(channelmap);// 得到经纪人编号
			if (subzhList == null || subzhList.size() == 0) {
				log.info("查询用户失败");
				return null;
			}
			channelmap.put("subzh", subzhList.get(0).getPagentzh());
			channelmap.put("isadmin", 2);// 经纪人

			List<Subzh> agentList = userInfoDataService.userLogin(channelmap);// 得到经纪人数据
			if (agentList != null && agentList.size() > 0) {
				agentzhfundLog.setAgentzh(agentList.get(0).getName());

				channelmap.put("subzh", agentList.get(0).getPagentzh());
				channelmap.put("isadmin", 3);// 渠道
				List<Subzh> channelList = userInfoDataService.userLogin(channelmap);// 得到渠道数据
				if (channelList != null && channelList.size() > 0) {
					agentzhfundLog.setReason(channelList.get(0).getName());
				}
			}
			
			TreeMap<String, Object> tmap =new TreeMap<String, Object>();
			if(bz==2) {//提现
				tmap.put("amount",total_fee);
				tmap.put("bankcardnum",agentzhfundLog.getBankcardnum());//卡号
				tmap.put("phoneNum", agentzhfundLog.getPhoneNum());//手机号
				tmap.put("idcard", agentzhfundLog.getIdcard());//身份证号
				tmap.put("bankcode", agentzhfundLog.getBankcode());//银行编号
				tmap.put("openbankname", agentzhfundLog.getOpenbankname());//开户支行名称
				tmap.put("name", agentzhfundLog.getName());//开户人姓名
				tmap.put("bankaccname", agentzhfundLog.getBankcode());//开户银行名称
				tmap.put("city", agentzhfundLog.getCity());//开户所在市
				tmap.put("province", agentzhfundLog.getProvince());//开户所在省
				JSONObject description = JSONObject.parseObject(JSON.toJSONString(tmap));
				agentzhfundLog.setDescription(description.toJSONString());
			}else {
				tmap.put("充值方式",type);
				tmap.put("充值人", agentzhfundLog.getName());
				tmap.put("充值单号", order_no);
				tmap.put("充值金额", agentzhfundLog.getFund());
				tmap.put("充值时间", agentzhfundLog.getModifytime());
				JSONObject description = JSONObject.parseObject(JSON.toJSONString(tmap));
				agentzhfundLog.setDescription(description.toJSONString());
			}
				log.info("log6:"+agentzhfundLog.getDescription());
				log.info("保存资金信息状态:"+subzhFundLogService.saveSubzhFundLog(agentzhfundLog));
		}catch(Exception e){
			e.printStackTrace();
		}
		return agentzhfundLog;
	}
}
