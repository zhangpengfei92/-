/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @FundServiceImpl.java
 * 功能概要  : 
 * 做成日期  : @2018年6月29日
 * 修改日期  :
 */
package com.jcl.service.impl;

import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.bouncycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.client.config.BryConfig;
import com.client.net.SendHttpRequestUtils;
import com.client.utils.SignUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jcl.dao.AgentzhfundLogMapper;
import com.jcl.dao.FundPzlogMapper;
import com.jcl.dao.SubzhMapper;
import com.jcl.pojo.AgentzhfundLog;
import com.jcl.pojo.FundPzlog;
import com.jcl.pojo.FundPzlogExample;
import com.jcl.pojo.FundPzlogExample.Criteria;
import com.jcl.pojo.Subzh;

import com.jcl.service.FundServices;
import com.jcl.stock.entity.CONST;
import com.jcl.stock.simulate.DefineNumber;
import com.jcl.stock.simulate.service.SimulateStockService;
import com.jcl.util.DateUtil;
import com.jcl.util.DeployProperties;
import com.jcl.util.StringUtil;
import com.jcl.util.spt.HttpRequest;
import com.jcl.util.spt.MD5Utils;
import com.jcl.util.spt.SignMd5Utils;
import com.payment.helper.ValidationUtil;
import com.payment.msg.gateway.GateWayPayRequest;
import com.payment.msg.merchantsettle.MerchantSettleRequest;
import com.payment.msg.merchantsettle.MerchantSettleResponse;
import com.payment.msg.queryone.QueryOneTransResponse;
import com.payment.msg.wappay.WapPayRequest;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/** 
 * @author zpf
 * @version 1.0
 */
/**
 * 出入金
 */
@Service
public class FundServiceImpls implements FundServices{
	//资金明细的mapper
	@Autowired
	private AgentzhfundLogMapper agentzhfundLogMapper;
	
	//用户的mapper
	@Autowired
	private SubzhMapper subzhMapper;
	
	//用户配资的mapper
	@Autowired
	private FundPzlogMapper pzlogMapper;
	
	//调协议的服务
	@Autowired
	private  SimulateStockService simulateStockService;
	
	public static Logger log = Logger.getLogger(FundServiceImpls.class);
	
	private static final String project_path = DeployProperties.getInstance().getSptReturn();
	public static final  String EXCHANGE_RATE="1";//汇率
	
	//网关商户私钥
	private static final  String MER_PRK="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCn/KIw+LQ39BSZysYuQ79u/OZAyTUPBhXk/rAhU44XVPALYfzz6rncXlQH+yBx6D/6lx1oCk7LnGQ/63uYtb4ZJB1Yae3fFBP5eC4TqDh0J6/LBuSOsIXS9h94iP+gd+dAwhsAq0oMqBoJxXAqdPLnMMQ57lUOk41iGcC711AefPgPHvzfZ5S40ir6wCnlMuJQs/y/B6cEmdSneeCELgP9ksP3XPcY3HbyccYjzK1tUVSyNDyNnCfncd76WQ8w+FHKr93PgQ8wv8vgb2RjcTRbG8mwUqf3BnJ4ptcZWbkDicGgXPJwKahaYYsoLEbngZkPL4C5I2rzenx1LWiNzZdfAgMBAAECggEAR7ogSsa2tLl8Xlptmm2E/M/xRLJk/GA90wRIkkJKBn5W7JVPW5ra91QzjyDULq7bOpVxke3szRWe3Iggwwi+/Z8lBI5eagT5rmh5TB1k1XvonMj5qE+JJJXAxEfC1nK8BDOdMgDxYkwYqhlqlkZPPRXeg1nXaZzpHn0ehVYfOJS0SCNhQINOBP85EgUq0tyEVbkmQL7wMeSGjKcPgAGBT4UALuVG01gBmgzanL9VJItiTNL8wpNYKCe5cUKa9HqOuBbrNSomah+gNhQFlLmjQ79lbel/6CHuEoZ2dS4SjjgOiV6+EWsDEQKggNWaXSjn7RqlwJCg/ZrIJeC0Zug2AQKBgQDaKRC3xB8VARyryLXHTCtSXBUnHZJXEJYXAU7SirHzp3Yt77LXfinAGUBo5hic3Cc585tyK8AV1/BpYr1eYf7NS4GrvyzENrObZJVmX7Hyy3l09r/TbRXmfdCObO7x+r+MMMgLbyWgE0j6SQK2LoZUYXKLJgUEnuLCyKhzW98bAQKBgQDFH7ilehedMz81EEyOmfNOUpj/fqpDjKrlhChvzpshASpy2JnVKsmA4aRMfnJ7EvBjePTdLVZxMLmD7YxDtCpG26fpltzPL+URVg6sArYZP+inNpsFDAzCNRuHQtSXJh00km8+VU74wK5gJvefUQQ5Se7PbtnYeRjPx5KTxJySXwKBgDaPKpUqwTM5kfgMPBnZnMP+L3QW2zBW/5JFS3cwJIzxBoc6eRmXfc2DAy64zNL94/mESQ3mjyVnWcKhZQajr1ucVJOlPgbcP1LPduWhbRlxdbCgvRydHWsFcBEOgTuXICxpTr49T8WWzRt7AuiY/hNAQ6s1GPAs5D0efbJL+aIBAoGAJMkkpgzAt19G3loqTzo/g1A6qQM0NuLbSXV+Lk8599DF4SS2oGcZr2lsRbIbHwiLv6Rk3ZmGVh0noY0E7eWDNjHrhdXXYvqnHrMWjdb7sH6SphG0oB59iwhqGLXKAmLkdFkXVWSKFjWu1NawwxRVW3OGk0M2eAUxMiUmH1lDdrUCgYEAzD6y5ApdnrjqJSDDQZbjMjfP9UDnnQ2DSdn0hlsUKiSJMTWt6KPfMLq0mL2osqZhtE6l5CfR3TwEoEInwbGmI/kN8OlaDVSdrEPkT0K8fBdODe4cPRbPHdqlr8cgl3F5hK/suboH6IL916DeeNaRidJoORolJ0gf6f6TfIU00Bk=";
	//网关商户公钥
	private static final  String MER_PUB_KEY="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp/yiMPi0N/QUmcrGLkO/bvzmQMk1DwYV5P6wIVOOF1TwC2H88+q53F5UB/sgceg/+pcdaApOy5xkP+t7mLW+GSQdWGnt3xQT+XguE6g4dCevywbkjrCF0vYfeIj/oHfnQMIbAKtKDKgaCcVwKnTy5zDEOe5VDpONYhnAu9dQHnz4Dx7832eUuNIq+sAp5TLiULP8vwenBJnUp3nghC4D/ZLD91z3GNx28nHGI8ytbVFUsjQ8jZwn53He+lkPMPhRyq/dz4EPML/L4G9kY3E0WxvJsFKn9wZyeKbXGVm5A4nBoFzycCmoWmGLKCxG54GZDy+AuSNq83p8dS1ojc2XXwIDAQAB";
	//网关平台公钥
	private static final  String PL_PBK="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAp/yiMPi0N/QUmcrGLkO/bvzmQMk1DwYV5P6wIVOOF1TwC2H88+q53F5UB/sgceg/+pcdaApOy5xkP+t7mLW+GSQdWGnt3xQT+XguE6g4dCevywbkjrCF0vYfeIj/oHfnQMIbAKtKDKgaCcVwKnTy5zDEOe5VDpONYhnAu9dQHnz4Dx7832eUuNIq+sAp5TLiULP8vwenBJnUp3nghC4D/ZLD91z3GNx28nHGI8ytbVFUsjQ8jZwn53He+lkPMPhRyq/dz4EPML/L4G9kY3E0WxvJsFKn9wZyeKbXGVm5A4nBoFzycCmoWmGLKCxG54GZDy+AuSNq83p8dS1ojc2XXwIDAQAB";
	//网关商务号
	private static final  String merchantNo="5806095317791613";
	//快捷商务号
	private static final String merchantid="7833859941684744";
	//快捷商户私钥
	private static final String MER_PRKs="MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDzc5LogiAbBJv0+eeKAChsIiunGZYgYas+3Fy2rsf9Ab5JWNBX3KlRp6JOekCIJMekQc/7acvEdENu8u31Uj7IpYoAtUEmxgB3mYdm6QhZuDxgTvXob9MVyX86Cljf0A19i6VLZFDTcS1bpfT5Ksi4BFLDgG1wup12zGlm6p1nHUU+LEAfsOOHQtaIiQ5ijaoQo9Iy16sKha86BEIZy2EMdF0zB340yFtpIHPvV/dKKLwlHncxo2inZWlTDmVphSsIC6nVt+EIq22huizNygqCRXBvqpP8AXZAjxDWKiRNajinuCDIMoBZqBSvugLzvMikY9Me4GulpZWrfyAr3g4XAgMBAAECggEAaZCaCVwzk8Oh5M5gikSbQphmmWTM5mmzmeRwB38ulRUmcCOk5BR5D0FDbggw51gbgaxQBVLQ2vUXMIsCiDgLpXGyr6/o+mktVq8qOYOe7VioRZK3qvyiaXYgRwiplRNgZiohmNl8+tK+uljyKwFUXAbz5HZR/mnNUfA9XDUr38PG99GWOCEizIZrbR6l4hmB7K0Neha69uu6heDIXiwruN0N+R1kyptz/iaDTxF0zM3ltjYgrykdEa6wpQEMfaY0N+BudR39HBNyd9NsRkoIk3ajlQhLlZj/W3cBqMTdokliFsRbXcup+itguExcM7kVf1X6RDM6ooQpoqrvlhfTkQKBgQD8bHDV0DtZm/oRwkLK8bdr/8ZL4Rh2R1AExY09I/h76eOxAWyh2MtdaXMMB1sZKH/nOt29ZyAl7vQh+SUnuq2aZ/LqHdvOFMGn3lc4lOAMh5evD9t6ktINhcfyCXMQje/JvVAR1SMs58Ygc/RRa0xAD16dhxWEv4vKVg1rGDftWwKBgQD25pcqTKeCQ9f3Wgd3TePPECLHmgvXAareq8hYQtcvGjwBH4oyNYnOQgdL258S3TnA+DMBxj6dX6Pd5uUaBYOuHjng8fWsfa6nl3sPO2XHA7+L50vJojiSLpYRjzOD5FA3dXAOf2asV0u0UB8WjVi4727hlEirWxOKhSEdug6S9QKBgQCjVewhfo+Y6WQEL8aWmZhNqwD+QpZYmsZ9f/Nnl6oHTI4IEFrh022scTp/kxbwjZNN5XpsP5m+0gNpJFVVguco3ZCCy3VawXWaETYxJ6xejzKolcM4al6/X0zFIjYxhRafXP+9ukP7n7JFd6KlOJ/rZ8aaejmDX4quD8a5AL/XtwKBgQCIYb10jx0kVqdwKZngK/U/hpE/oncR0Aj7sPYc0uccTKiCklJ7A5nYhh6Tp4AKIotpbXB3dXNW6OKSi51Xr14aivW7rMvg+RfF2WYPdub0dLyU4jG58lK/ZN5eWrTBERfCWquIRpWHcz0NIAjcIz20AgZEsu0lQkzcAkfVrNWqFQKBgQCNCSym+R7B8QTt8/dwxd0f/s1sAdKKVgHz54M+THC9MjdHhRCjFt+i+5Tsk3RhLM6ClxQqQby/CPhY/YEgY+cvtdeDK9Tpo4e1oa7uL7jpp/qd4jHIMRvSnUsjycrgnTnE3+8VCTwT8BYTT0ifjo/E9UFlTsXbrmv9b5gBtjzIQw==";
	//快捷商户公钥
	private static final String MER_PUB_KEYs="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA83OS6IIgGwSb9PnnigAobCIrpxmWIGGrPtxctq7H/QG+SVjQV9ypUaeiTnpAiCTHpEHP+2nLxHRDbvLt9VI+yKWKALVBJsYAd5mHZukIWbg8YE716G/TFcl/OgpY39ANfYulS2RQ03EtW6X0+SrIuARSw4BtcLqddsxpZuqdZx1FPixAH7Djh0LWiIkOYo2qEKPSMterCoWvOgRCGcthDHRdMwd+NMhbaSBz71f3Sii8JR53MaNop2VpUw5laYUrCAup1bfhCKttoboszcoKgkVwb6qT/AF2QI8Q1iokTWo4p7ggyDKAWagUr7oC87zIpGPTHuBrpaWVq38gK94OFwIDAQAB";
	//快捷平台公钥
	private static final String PL_PBKs="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjU1vtdr+wCwDE0cr3VKIvK4aUdN/ipb4kV90BjTcEuY+FGONciDnIZ4QjvmodOufSeKKAw9sLwbMCLpW8kOCAC5bKWwX6iaDRnveGZ+s3me3aJUpjE4R/X7AkjRr7k2XTCJmv+ZHox65Hg6LzwrNnaSffaqDye0lIHaKbzjZJL5vlZRJCJ4IOyCCneG7tfV9ienmRmVpfTffl37QELmOHz5WozpXqrrBuyQ+0K0DrbwMEw5HyGQGDbqxLQnmaHY5ySZ+Jh5eAeQABmG8KOms4BEIerdJlj+nMggf/0wl+9zW+XRT4crL4wM7x1sMsY95Lw9z7hU/5mO4qqJce3kgRQIDAQAB";
	//生成网关支付信息
	@Override
	public Map<String, Object> payment(HttpServletRequest request,HttpServletResponse response) {
		
	try {
		BryConfig.MER_PRK=MER_PRK;
		BryConfig.MER_PUB_KEY=MER_PUB_KEY;
		BryConfig.PL_PBK=PL_PBK;
		BryConfig.merchantNo=merchantNo;
		request.setCharacterEncoding("UTF-8");
		String txSN = request.getParameter("txSN");//订单号
		String tranAmt = request.getParameter("tranAmt");//金额
		String accountType = request.getParameter("accountType");//账户类型  11个人账户  12企业账户
		String prodInfo = "充值";//商品信息 
		String usage = "充值";//资金用途
		String returnURL = project_path+"/subzhfund/payCallBack";//同步调账地址
		String notificationURL = project_path+"/subzhfund/payNotyfy";//异步地址
		String subzh = request.getParameter("subzh");//用户名
		//将页面生成的订单号和用户名称组合成新的订单
		txSN=subzh+txSN;
		AgentzhfundLog agentzhfundLog= new AgentzhfundLog();
		//保存一条充值信息，状态为充值申请状态
		
		//充值金额为分，需要转换为人民币保存到数据库
		BigDecimal fund=new BigDecimal(tranAmt);
		log.info("保存充值流水参数 agentzhfundLog  :" +agentzhfundLog+"  subzh  : "+subzh+"    txSN   : "+txSN+"    fund : "+fund+"  time : "+DateUtil.getSystemDate());

		//保存充值信息
		saveAgentzhfundLog(agentzhfundLog,subzh, txSN, DateUtil.getSystemDate(), fund, 0, 1);
		
		tranAmt=String.valueOf(Integer.parseInt(tranAmt)*100);
		GateWayPayRequest gateWayPayRequest = new GateWayPayRequest();
		gateWayPayRequest.setTxSN(txSN);//订单号
		gateWayPayRequest.setTranAmt(Long.parseLong(tranAmt));//金额
		gateWayPayRequest.setAccountType(accountType);//账户类型
		gateWayPayRequest.setProdInfo(prodInfo);//商品信息 
		gateWayPayRequest.setReturnURL(returnURL);//同步调账地址
		gateWayPayRequest.setNotificationURL(notificationURL);//异步地址
		gateWayPayRequest.setUsage(usage);//资金用途
		gateWayPayRequest.setTxCode("10012");//业务编码
		gateWayPayRequest.setMerchantNo(BryConfig.merchantNo);//商务号
		//交易时间
		gateWayPayRequest.setTransDate(com.payment.common.utils.DateUtil.getStandardDate("yyyy-MM-dd HH:mm:ss", new Date()));
		gateWayPayRequest.setVersion("1.0");//版本
		gateWayPayRequest.setLsh(RandomStringUtils.randomNumeric(17));//流水号
		String sign = "";
		try {
			sign = SignUtils.createSignData(gateWayPayRequest,BryConfig.MER_PRK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, String> reqMap = new HashMap<String, String>();
		reqMap.put("txCode", gateWayPayRequest.getTxCode());
		reqMap.put("signature", sign);
		reqMap.put("version", gateWayPayRequest.getVersion());
		reqMap.put("message", new BASE64Encoder().encode(JSON.toJSONString(gateWayPayRequest).getBytes("UTF-8")));
		reqMap.put("merchantId", BryConfig.merchantNo);
		StringBuffer formHtml = new StringBuffer();

		formHtml.append("<form name='form' method='post' action='"
				+ BryConfig.HTTPS_AYN_URL
				+ "'>");
		for (Map.Entry<String, String> entry : reqMap.entrySet()) {
			formHtml.append("<input type='hidden' name='" + entry.getKey() + "' value='" + entry.getValue() + "'/>");
		}
		formHtml.append("</form>");
		formHtml.append("<script type='text/javascript'>");
		formHtml.append(" form.submit();");
		formHtml.append("</script>");
		request.setAttribute("submitForm", formHtml);
		request.getRequestDispatcher("/request.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	

	
	//网关充值异步回调BBBB
	@Override
	public  Map<String, Object>  payNotyfy(HttpServletRequest request) {
		log.info("网关充值回调开始");
		Map<String, Object>map=new HashMap<String, Object>();
	try {
		request.setCharacterEncoding("UTF-8");
		String sign = request.getParameter("sign");
		String message = request.getParameter("message");
		 log.info("sign--回调参数   :   " +sign);
		 log.info("message--回调参数   :   " +message);
		
		QueryOneTransResponse oneTransResponse = JSON.parseObject(
				new String(new BASE64Decoder().decodeBuffer(message), "UTF-8"), QueryOneTransResponse.class);

		JSONObject jsonObject = (JSONObject) JSON.toJSON(oneTransResponse);
		Map<String, String> omap = new HashMap<String, String>();
		List<String> keys = new ArrayList<String>();
		if (null != jsonObject) {
			Set<Entry<String, Object>> set = jsonObject.entrySet();
			for (Entry<String, Object> entry : set) {
				omap.put(entry.getKey(), String.valueOf(entry.getValue()));
				if (ValidationUtil.isNotBlank(entry.getValue())) {
					keys.add(entry.getKey());
				}
			}
		}
		Collections.sort(keys);
		StringBuffer signStr = new StringBuffer();
		for (String key : keys) {
			signStr.append(key).append("=").append(omap.get(key)).append("&");
		}
		if (signStr.toString().endsWith("&")) {
			signStr.delete(signStr.length() - 1, signStr.length());
		}
		
		log.info("signStr   :   " +signStr);
		boolean verfy=false;
		try {
			 verfy = SignUtils.verySign(signStr.toString(),PL_PBK, sign);
			 log.info("verfy--交易状态   :   " +verfy);
		} catch (Exception e) {
			log.error("验签出现异常", e);
		}
	
		if(verfy){
			String orderid = oneTransResponse.getTxSN();//订单号
			long amount=oneTransResponse.getTranAmt();//金额
			String datetime=oneTransResponse.getTransDate();//交易时间
			String returncode=oneTransResponse.getReturnCode();//交易状态
			String returnMsg=oneTransResponse.getReturnMsg();//
			String resultCode=oneTransResponse.getResultCode();//
			String resultMsg=oneTransResponse.getResultMsg();
			AgentzhfundLog afl=new AgentzhfundLog();
			if(null!=resultCode&&resultCode.equals("FL0000")) {
				log.info("充值金额  ： "+amount +"   充值时间   ：  "+ datetime+"   订单号   ："+orderid);
				log.info("returnMsg  ： "+returnMsg +"   returncode   ：  "+ returncode+"   resultMsg  ："+resultMsg);
				
	    		List<AgentzhfundLog> alist= null;
	    		alist = agentzhfundLogMapper.selectByorderno(orderid);
	    		log.info("alist ===>"+alist.size());
	    		if(alist!=null&&alist.size()>0) {
	    			afl=alist.get(0);
	    			if(afl.getStatus()==1){//已经充值成功了。
	    				log.info("该单号充值已完成"+new Date().toString());
	    				map.put("msg", "该单号充值已完成");
	    				map.put("status", false);
	    				return map;
	    			}
	    		}
	    		Subzh sub = subzhMapper.selectBySubzh(afl.getSubzh());
	    	 	if(sub!=null) {	    			
		    		log.info("log8:subzh"+sub);
		    		sub.setZhstate(1);
		    		int count=subzhMapper.updateByPrimaryKeySelective(sub);
		    		log.info("log11:subzhService"+count);
		    		List<FundPzlog> sfplist = getFundPzlogList(sub);
		    		afl.setFund(afl.getFund().multiply(new BigDecimal(0.996)));
		    		//调柜台
		    	    Map<String, Object> amap=addMoney(sub, afl);
		    	    if(null!=amap&&amap.size()>0) {
		    	    	if(null!=amap.get("status")&&(Boolean) amap.get("status")) {
		    	    		afl.setStatus(1);//修改状态为1 --表示充值成功
		    	    		map.put("status", true);
		    	        	map.put("msg", "充值成功");
		    	        	FundPzlog fundPzlog = saveFundpzlog(sub.getSubzh(), afl.getFund(), orderid, DateUtil.getSystemDate(), 6);	    	
		    	    	}else {
		    	    		afl.setStatus(2);//修改状态为2 --表示充值失败	 
		    	    		map.put("status", false);
		    	        	map.put("msg", "充值失败");
		    	        	
		    	   		 	if ((sfplist == null) && (sfplist.size() <= 1)) {
		    	   		 		sub.setZhstate(0);
		    	   		 	}
		    	    	  }
		    	    	}else {
			    	    	afl.setStatus(2);//修改状态为2 --表示充值失败
			    	    	map.put("status", false);
				        	map.put("msg", "充值失败");
				        	if ((sfplist == null) && (sfplist.size() <= 1)) {
		    	   		 		sub.setZhstate(Integer.valueOf(0));
		    	   		 	}
			    	    }
		    	    subzhMapper.updateByPrimaryKeySelective(sub);
		    		log.info("log11:subzhService");
		    	    }
	    	 	agentzhfundLogMapper.updateByPrimaryKeySelective(afl);
			}else{
	        	map.put("status", false);
	        	map.put("msg", "充值失败");
	        }
		}else{
	    	log.info("验签失败");
        	map.put("status", false);
        	map.put("msg", "充值失败");
	    }
	}catch (Exception e) {
		log.info("充值回调异常", e);
	}
	return map;

	}
	
	//保存提现信息DDDD
	@Override
	public  Map<String, Object> savePay(AgentzhfundLog afl, String subzh) {
		Map<String, Object> map=new HashMap<String, Object>();
		//根据传过来subzh去查询用户信息
		Subzh sub = subzhMapper.selectBySubzh(subzh);
		
		//判断用户信息是否存在
		if(null==sub) {
			log.info("sub==null:用户信息为null");	
			map.put("status", false);
			map.put("msg", "用户信息为存在");
			return map;
		}
		
		//判断用户的账户资金是否大于提现金额
		if (sub.getFundbalance() == null&&sub.getFundbalance().doubleValue() - Double.valueOf(afl.getAmount()) < 0) {
			log.info("result1:余额不足");	
			map.put("status", false);
			map.put("msg", "余额不足1");
			return map;
		}
		
		
		
		log.info("getSubzh:==》"+sub.getSubzh());
		String dates = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		Date paydate=DateUtil.getSystemDate();
	
		String	pay_orderid=subzh+RandomStringUtils.randomNumeric( 17 );
		BigDecimal fund=new BigDecimal(afl.getAmount());
		sub.setFundbalance(sub.getFundbalance().subtract(new BigDecimal(afl.getAmount())));

		afl.setFund(fund);
		
		saveAgentzhfundLog(afl,subzh, pay_orderid, paydate, fund, 6,2);
		
		List<AgentzhfundLog> alist = agentzhfundLogMapper.selectByorderno(pay_orderid);
		
		if(alist!=null&&alist.size()>0){
			int num=subzhMapper.updateByPrimaryKeySelective(sub);
			if(num>0) {
				map.put("status", true); 
			}
			
			log.info("提现减去fundbalance字段的钱  ：  " +num);
		}else {
			map.put("status", false);
        	map.put("msg", "提现申请提交失败");
        	afl.setStatus(10);
		}
		
		//调柜台协议
		if(null!=sub.getIsadmin()&&sub.getIsadmin()==6){
		Map<String, Object> gmap =  getMoney(sub, afl);
		if(null!=gmap&&gmap.size()>0) {
			if(null!=gmap.get("status")&& (Boolean)gmap.get("status")){
				map.put("status", true);
	        	map.put("msg", "提现申请提交成功");	        	
				
			}else {
				map.put("status", false);
	        	map.put("msg", "提现申请提交失败");
	        	afl.setStatus(10);
			}
		}else {
			map.put("status", false);
        	map.put("msg", "提现申请提交失败");
        	afl.setStatus(10);
		}
		}
		agentzhfundLogMapper.updateByPrimaryKeySelective(afl);
		return map;
	}
	
	//提现审核服务EEEE
	@Override
	public Map<String, Object> isPay(Integer id, Integer status) {
		BryConfig.MER_PRK=MER_PRK;//商户私钥
		BryConfig.MER_PUB_KEY=MER_PUB_KEY;//商户公钥
		BryConfig.PL_PBK=PL_PBK;//平台公钥
		BryConfig.merchantNo=merchantNo;//商务号
		
		Map<String, Object> map=new HashMap<String, Object>();
		AgentzhfundLog afl=null;
		if(null==id&&id==0) {
			map.put("msg", "提现信息不存在");
			map.put("status", false);
			return map;
		}
		
		afl = agentzhfundLogMapper.selectByPrimaryKey(id);

		
		if(afl!=null&&afl.getStatus()==6){
			if(status!=7) {
				map.put("status", false);
				map.put("msg", "提现信息不存在");
				return map;
			}
		}else {
			map.put("status", false);
			map.put("msg", "审核未通过");
			return map;
		}
		//将数据库保存的对应提现分别set到对应的实体类字段
		String description= afl.getDescription();
 		JSONObject jsonobj = JSONObject.parseObject(description);
		
		afl.setAmount(jsonobj.getString("amount"));
		afl.setBankCardNumber(jsonobj.getString("bankCardNumber"));	
		afl.setPhoneNum(jsonobj.getString("phoneNum"));
		afl.setIdcard(jsonobj.getString("idcard"));
		afl.setBankcode(jsonobj.getString("bankcode"));
		
			
	try {
		String subzh = afl.getSubzh();
			
		if (subzh == null) {
			map.put("status", false);
			map.put("msg", "result用户不存在");
			return map;
		}
		Subzh sub=subzhMapper.selectBySubzh(subzh);
		 MerchantSettleRequest signMerchantSettleRequest = new MerchantSettleRequest();
	        signMerchantSettleRequest.setAccountName(afl.getName());//用户名
	        signMerchantSettleRequest.setAccountNumber(afl.getBankCardNumber());//银行卡号
	        signMerchantSettleRequest.setAccountType( "11" );//账户类型
	        log.info("提现金额   ：  "+afl.getFund());
	        String amt=String.valueOf(afl.getFund().multiply(new BigDecimal(100)));
	        signMerchantSettleRequest.setTranAmt(getLong(amt));//金额
	        log.info("提现金额   ：  "+signMerchantSettleRequest.getTranAmt());
	        signMerchantSettleRequest.setMerchantNo( BryConfig.merchantNo );//商户号
	        signMerchantSettleRequest.setCertType("0");//
	        signMerchantSettleRequest.setCertNumber(afl.getIdcard());//身份证号
	        //signMerchantSettleRequest.setExtraParams( RandomStringUtils.randomNumeric( 18 ) );
	        signMerchantSettleRequest.setTxSN(afl.getOrderno());//订单号
	        signMerchantSettleRequest.setCertType("0");
	        signMerchantSettleRequest.setTransDate(com.payment.common.utils.DateUtil.getStandardDate( "yyyy-MM-dd HH:mm:ss", new Date() ) );
	        signMerchantSettleRequest.setVersion( "1.0" );
	        signMerchantSettleRequest.setLsh(RandomStringUtils.randomNumeric( 17 ));//流水号
	        signMerchantSettleRequest.setCardMediaType("10");
	        signMerchantSettleRequest.setTxCode( "10004" );//业务编码
	        signMerchantSettleRequest.setProvince(afl.getProvince());
	        signMerchantSettleRequest.setCity(afl.getCity());
	        signMerchantSettleRequest.setBranchName(afl.getBankname());
	        String sign = SignUtils.createSignData( signMerchantSettleRequest, BryConfig.MER_PRK );
	        Map<String, String> reqMap = new HashMap<String, String>();
	        reqMap.put( "txCode", signMerchantSettleRequest.getTxCode() );
	        reqMap.put( "signature", sign );
	        reqMap.put( "version", signMerchantSettleRequest.getVersion() );
	        reqMap.put( "message", new BASE64Encoder().encode( JSON.toJSONString( signMerchantSettleRequest ).getBytes( "UTF-8" ) ) );
	        reqMap.put( "merchantId", BryConfig.merchantNo );
	        StringBuffer postData = new StringBuffer();
	        for ( Map.Entry<String, String> entry : reqMap.entrySet() )
	        {
	            postData.append( entry.getKey() ).append( "=" ).append( URLEncoder.encode( entry.getValue(), "UTF-8" ) ).append( "&" );
	        }
	        postData.delete( postData.length() - 1, postData.length() );
	        String returnMsg = SendHttpRequestUtils.doPost( BryConfig.HTTPS_SYN_URL, "application/x-www-form-urlencoded;charset=utf-8", postData.toString().getBytes( "UTF-8" ), 60 * 1000, 60 * 1000 );
	        log.info( "getBackInfo>>>>>>>>>>>>>>>>>>>>:" + returnMsg );
	        MerchantSettleResponse oneTransResponse = JSON.parseObject( returnMsg, MerchantSettleResponse.class );
	        String signData = oneTransResponse.getRspLsh() + BryConfig.MER_PUB_KEY;
	        boolean verySign = SignUtils.verySign( signData, BryConfig.PL_PBK, oneTransResponse.getSignature() );
	        System.out.println( verySign );
		
	        if(verySign) {
	        	String lsh = oneTransResponse.getRspLsh();//订单号
				String returncode=oneTransResponse.getReturnCode();//交易状态
				String resultCode=oneTransResponse.getResultCode();//
				String msg=oneTransResponse.getResultMsg();
		/*		if(!lsh.equals(signMerchantSettleRequest.getLsh())) {
					map.put("status", "false");
					map.put("msg", "订单出错请重新提交");
					return map;
				}*/	
			log.info("提现申请状态:===>"+msg+"==提现申请状态码：====》"+resultCode);
			
			if(!StringUtil.isAllNullOrEmpty(returncode)&&returncode.equals("FL0000")) {//returncode=FL0000表示流程执行成功
				if(!StringUtil.isAllNullOrEmpty(resultCode)&&resultCode.equals("FL0000")) {
					log.info("resultCode1  :"+resultCode);
					//修改操作状态为审核中
					afl.setStatus(7);
					map.put("status", "true");
					map.put("msg", msg);
				}else if(!StringUtil.isAllNullOrEmpty(resultCode)&&resultCode.equals("FL0002")){
					log.info("resultCode2  :"+resultCode);
					afl.setStatus(7);
					map.put("msg","提现状态："+msg);
					map.put("status", "true");
					log.info("提现处理中");
				}else {
					log.info("resultCode3  :"+resultCode);
					map.put("msg","提现失败:"+msg);
					map.put("status", false);
					afl.setStatus(10);
					log.info("提现失败");
				}
			}else {
				log.info("resultCode4  :"+resultCode);
				afl.setStatus(10);//提现失败
				map.put("status", "false");
				map.put("msg", msg);
				return map;
			}	
			int num=agentzhfundLogMapper.updateByPrimaryKeySelective(afl);	
			
			if(null!=afl.getStatus()&&afl.getStatus()==10) {
				if(null!=subzh) {
					//调柜台协议，把钱加到柜台账户
				log.info("调柜台协议将用户的提现失败的金额反回给客户");
				Map<String, Object> amap = addMoney(sub, afl);
				if(null!=amap&&amap.size()>0) {
					if(null!=amap.get("status")&& (Boolean)amap.get("status")){
						log.info("将用户提现失败金额返回给客户成功");
							}
						}
					}
				}
			
	        }
		} catch (Exception e) {
			log.info("提现记录异常=>"+e);
			map.put("status", "false");
			map.put("msg", "提现失败");
			return map;
		}
		return map;
	}
	
	
	//提现回调
		@Override
		public Map<String, Object>  saveGetMoney(HttpServletRequest request) {
			log.info("提现回调开始");
			AgentzhfundLog agentzhfundLog=null;
			Map<String, Object> map= new HashMap<String, Object>();
			try {
				request.setCharacterEncoding("UTF-8");
				String sign = request.getParameter("sign");
				String message = request.getParameter("message");
				 log.info("sign--回调参数   :   " +sign);
				 log.info("message--回调参数   :   " +message);
				
				QueryOneTransResponse oneTransResponse = JSON.parseObject(
						new String(new BASE64Decoder().decodeBuffer(message), "UTF-8"), QueryOneTransResponse.class);

				JSONObject jsonObject = (JSONObject) JSON.toJSON(oneTransResponse);
				log.info("提现回调参数      :"+jsonObject);
				Map<String, String> omap = new HashMap<String, String>();
				List<String> keys = new ArrayList<String>();
				if (null != jsonObject) {
					Set<Entry<String, Object>> set = jsonObject.entrySet();
					for (Entry<String, Object> entry : set) {
						omap.put(entry.getKey(), String.valueOf(entry.getValue()));
						if (ValidationUtil.isNotBlank(entry.getValue())) {
							keys.add(entry.getKey());
						}
					}
				}
				Collections.sort(keys);
				StringBuffer signStr = new StringBuffer();
				for (String key : keys) {
					signStr.append(key).append("=").append(omap.get(key)).append("&");
				}
				if (signStr.toString().endsWith("&")) {
					signStr.delete(signStr.length() - 1, signStr.length());
				}
				
				log.info("signStr   :   " +signStr);
				boolean verfy=false;
				try {
					 verfy = SignUtils.verySign(signStr.toString(),PL_PBK, sign);
					 log.info("verfy--交易状态   :   " +verfy);
				} catch (Exception e) {
					log.error("验签出现异常", e);
				}
				String orderid = oneTransResponse.getTxSN();//订单号
				long amount=oneTransResponse.getTranAmt();//金额
				String datetime=oneTransResponse.getTransDate();//交易时间
				String returncode=oneTransResponse.getReturnCode();//交易状态
				String returnMsg=oneTransResponse.getReturnMsg();//
				String resultCode=oneTransResponse.getResultCode();//
				String resultMsg=oneTransResponse.getResultMsg();
				
				List<AgentzhfundLog> alist = agentzhfundLogMapper.selectByorderno(orderid);
				if(alist!=null&&alist.size()>0) {
					agentzhfundLog=alist.get(0);
				}else {
					map.put("status", false);
					map.put("status","该订单不存在");
					log.info("该订单不存在");
					return map;
				}
				String username=agentzhfundLog.getSubzh();
				
				Subzh subzh=subzhMapper.selectBySubzh(username);
				
				if(agentzhfundLog.getStatus()==10) {
					map.put("status", false);
					map.put("status","该订单提现失败");
					log.info("该订单提现失败");
					return map;
				}
				
				if(verfy){
					AgentzhfundLog afl=new AgentzhfundLog();
					if(!StringUtil.isAllNullOrEmpty(returncode)&&returncode.equals("FL0000")) {
						log.info("提现金额  ： "+amount +"   提现时间   ：  "+ datetime+"   订单号   ："+orderid);
						log.info("returnMsg  ： "+returnMsg +"   returncode   ：  "+ returncode+"   resultMsg  ："+resultMsg);
					if(!StringUtil.isAllNullOrEmpty(resultCode)&&resultCode.equals("FL0000")) {

					if(agentzhfundLog!=null&&agentzhfundLog.getStatus()==7) {
							agentzhfundLog.setStatus(9);//修改提现专题为成功
							agentzhfundLogMapper.updateByPrimaryKeySelective(agentzhfundLog);					
							BigDecimal fund = agentzhfundLog.getFund();
							saveFundpzlog(username,fund, orderid, DateUtil.getSystemDate(), 7);
							map.put("status", true);	
					  }
					}else if(!StringUtil.isAllNullOrEmpty(resultCode)&&resultCode.equals("FL0002")){
						map.put("msg","提现处理中");
						map.put("status", false);
						log.info("提现处理中");
					}else {
						map.put("msg","提现失败");
						map.put("status", false);
						agentzhfundLog.setStatus(10);
						log.info("提现失败");
					}
					}else {
						agentzhfundLog.setStatus(10);
					}
				}else {
					agentzhfundLog.setStatus(10);
				}
				agentzhfundLogMapper.updateByPrimaryKeySelective(agentzhfundLog);
				//判断状态为10，表示提现失败，把钱返回到客户手中
				Object object = new Object();
				synchronized (object) {
				if(null!=agentzhfundLog.getStatus()&&agentzhfundLog.getStatus()==10) {
					if(null!=subzh) {
						//调柜台协议，把钱加到柜台账户
					log.info("调柜台协议将用户的提现失败的金额反回给客户");
					Map<String, Object> amap = addMoney(subzh, agentzhfundLog);
					if(null!=amap&&amap.size()>0) {
						if(null!=amap.get("status")&& (Boolean)amap.get("status")){
							log.info("将用户提现失败金额返回给客户成功");
								}
							}
						}
					}
				}
			} catch (Exception e) {
				log.error("提现回调异常",e);
			}
			return map;
		}
	
	
	//审核不通过时调用FFFF
	@Override
	public Map<String, Object> checkWithdraw(Integer id, Integer status) {
		Map<String, Object> map=new HashMap<String, Object>();
		
		try {
			synchronized (merchantNo) {
				AgentzhfundLog fundLog = agentzhfundLogMapper.selectByPrimaryKey(id); 
				
				Subzh subzhEntity=null;
				if(fundLog != null){
					if(status!=null && status==8){
						try {
			 				fundLog.setStatus(8);/*状态   0是申请状态。1是成功 5：审核通过  6：拒绝*/
			 				fundLog.setModifytime(Calendar.getInstance().getTime());
			 				log.info("审核通过保存状态：" + agentzhfundLogMapper.updateByPrimaryKeySelective(fundLog));
			 			} catch (Exception efundlog) {
			 				log.error("保存预提现信息异常：" + efundlog.getMessage());
			 				map.put("msg", "false");
			 				return map;
			 			}
						subzhEntity=subzhMapper.selectBySubzh(fundLog.getSubzh());
						//调柜台协议，把钱加到柜台账户
						log.info("提现审核拒绝后调入金协议");
						Map<String, Object> amap = addMoney(subzhEntity, fundLog);
						if(null!=amap&&amap.size()>0) {
							if(null!=amap.get("status")&& (Boolean)amap.get("status")){
								log.info("将用户提现失败金额返回给客户成功");
						   }
						}
						map.put("status", "true");						
		 				return map;
					}
				}
			}
			
		}catch(Exception e) {
			map.put("status", "false");
			return map;
		}
		return map;
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
	private AgentzhfundLog saveAgentzhfundLog(AgentzhfundLog agentzhfundLog,String username,String order_no,Date pay_time,BigDecimal total_fee,int paystate,int bz){
		try{
			String type=paystate==0?"rj":paystate==3?"tzrj":paystate==6?"tx":paystate==11?"tzcj":"qt";
			agentzhfundLog.setSubzh(username);
			agentzhfundLog.setOrderno(order_no);
			agentzhfundLog.setType(type);
			agentzhfundLog.setBz((byte)bz);//充值
			agentzhfundLog.setModifytime(pay_time);
			agentzhfundLog.setFund(total_fee);
			agentzhfundLog.setStatus(paystate);//支付成功
		
			
			TreeMap<String, Object> tmap =new TreeMap<String, Object>();
			if(bz==2) {//提现
				agentzhfundLog.setName(agentzhfundLog.getName());
				tmap.put("amount",total_fee);
				tmap.put("bankCardNumber",agentzhfundLog.getBankCardNumber());
				tmap.put("phoneNum", agentzhfundLog.getPhoneNum());
				tmap.put("idcard", agentzhfundLog.getIdcard());
				tmap.put("bankcode", agentzhfundLog.getBankcode());
				JSONObject description = JSONObject.parseObject(JSON.toJSONString(tmap));
				agentzhfundLog.setDescription(description.toJSONString());
			}else {
				agentzhfundLog.setName(username);
				tmap.put("充值方式",type);
				tmap.put("充值人", agentzhfundLog.getName());
				tmap.put("充值单号", order_no);
				tmap.put("充值金额", agentzhfundLog.getFund());
				tmap.put("充值时间", agentzhfundLog.getModifytime());
				JSONObject description = JSONObject.parseObject(JSON.toJSONString(tmap));
				agentzhfundLog.setDescription(description.toJSONString());
			}
			log.info("agentzhfundLog  :  " + agentzhfundLog);
				log.info("log6:"+agentzhfundLog.getDescription());
				int num=agentzhfundLogMapper.insertSelective(agentzhfundLog);
				log.info("agentzhfundLogMapper==SUCCESS:"+num);
		}catch(Exception e){
			e.printStackTrace();
		}
		return agentzhfundLog;
	}
	
	/**
	 * 配资方法
	 * @param username 用户名
	 * @param accmoney 配资金额
	 * @param orderno 订单号
	 * @param paytime 配资时间
	 * @param fundtype 配资类型
	 * @return
	 */
	public FundPzlog saveFundpzlog(String username,BigDecimal accmoney,String orderno,Date paytime,int fundtype) {
		FundPzlog fundPzlog =new FundPzlog(); 
		log.info("log:开始记录配资"+username+
				"---8--"+"--"+accmoney+"--");
			fundPzlog.setSubzh(username);
			// 1:配资 资金比例 2:加配资金比例 3:减配  4:追加保证金 5:出金  6:充值 7:提现 8:调账入金 9调账出金*/
			fundPzlog.setFundtype(fundtype);
			fundPzlog.setSetpro(0);
			fundPzlog.setFundbalance(accmoney);
			fundPzlog.setCreatetime(DateUtil.getSystemDate());
			
			TreeMap<String, Object> tmap =new TreeMap<String, Object>();
			tmap.put("操作人", fundPzlog.getSubzh());
			tmap.put("操作单号", orderno);
			tmap.put("操作金额",accmoney);
			tmap.put("操作时间",paytime);
			JSONObject descriptions = JSONObject.parseObject(JSON.toJSONString(tmap));
			fundPzlog.setSetdesc(descriptions.toJSONString());
			try {
				int n=pzlogMapper.insertSelective(fundPzlog);
				log.info("log操作配资===》"+n+"=====>"+fundPzlog.getSetdesc());
			} catch (Exception e) {
				log.info("操作配资失败", e);
			}
			return fundPzlog;
	}
	
	//判断某个用户是否有持仓
	private boolean isHaveHold(String user){
		log.info("进来了");
		boolean b=true;
		try{
			log.info("进来了");
			String con="{\"start\":0,\"limit\":10,\"client_id\":\""+user+"\"}";
			
			String rbStr = simulateStockService.commonFunction(con, 11123);//持仓记录
			log.info("进来了2"+rbStr);
			if(rbStr==null||rbStr=="null" || rbStr.equals("")){
				log.info("进来了3"+rbStr);
				rbStr="{\"status\":10,\"describe\":\"地址错误或网络错误\"}";
				JSONObject obj = JSONObject.parseObject(rbStr);
			}else if(rbStr.indexOf("{")<0){
				log.info("进来了4"+rbStr);
				rbStr="{\"status\":11,\"describe\":\"返回信息出错\"}";
				JSONObject obj = JSONObject.parseObject(rbStr);
			}else{//正常情况下
				JSONObject obj = JSONObject.parseObject(rbStr);
				if(obj.containsKey("status") && obj.getIntValue("status")==0){
					JSONArray arr=obj.getJSONArray("holders");
					if(arr.size()>0){
						b=false;
						log.info("查持仓ok"+arr.size());
					}
				}else {
					log.info(obj.get("describe"));
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return b;
	}
	
	//查询可用资金
	@Override
	public BigDecimal getfundbalance(Subzh subzh) {
		if(subzh!=null){
				try{
					log.info("调协议查询可用资金");
					String con="{\"client_id\":\""+subzh.getSubzh()+"\"}";
					log.info("log——con===》"+con);
					String rbStr = simulateStockService.commonFunction(con, 11103);//用户资金信息查询
					log.info("log——rbStr===》"+rbStr);
					if(rbStr==null||rbStr=="null" || rbStr.equals("")){
						rbStr="{\"status\":10,\"describe\":\"地址错误或网络错误\"}";
						JSONObject obj = JSONObject.parseObject(rbStr);
						log.info("log1——obj===》"+obj);
					}else if(rbStr.indexOf("{")<0){
						rbStr="{\"status\":11,\"describe\":\"返回信息出错\"}";
						JSONObject obj = JSONObject.parseObject(rbStr);
						log.info("log2——obj===》"+obj);
					}else{//正常情况下
						Map<String, Object> map=JSONObject.parseObject(rbStr);
						JSONObject data=(JSONObject) JSONObject.toJSON(map.get("data"));
						if(data==null) {
							log.info("调协议失败，data=null");
							return null;
						}
						log.info("log3——obj===》"+data+"enable_balance===》"+data.get("enable_balance"));
						if(map.containsKey("status") &&Integer.parseInt(map.get("status").toString())==0){
							log.info("调协议查询可用资金成功");
							BigDecimal fundbalance=new BigDecimal(String.valueOf(data.get("enable_balance")));
							subzh.setFundbalance(fundbalance.multiply(new BigDecimal(EXCHANGE_RATE)));
						}
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			try {
				subzhMapper.updateByPrimaryKeySelective(subzh);
			} catch (Exception e) {
				log.error("查询柜台后修改客户可用资金", e);
			}
		return subzh.getFundbalance();
	}
	
	//根据用户名去查询配资信息
	public List<FundPzlog> getFundPzlogList(Subzh subzh){
		List<FundPzlog> sfplist = new ArrayList<FundPzlog>();
		try {
			FundPzlogExample example=new FundPzlogExample();
			Criteria createCriteria = example.createCriteria();
			createCriteria.andSubzhEqualTo(subzh.getSubzh());
			sfplist = pzlogMapper.selectByExample(example);
		} catch (Exception e) {
			log.error("查询用户配资信息", e);
		}
		return sfplist;
	}
	
	
	/**
	 * 调柜台入金协议
	 * @param subzh 账户信息
	 * @param agentzhfundLog  提现信息
	 * @return
	 */
	
	public Map<String, Object> addMoney(Subzh subzh,AgentzhfundLog agentzhfundLog){
			Map<String, Object> map=new HashMap<String, Object>();
			log.info("调柜台的入金金额"+agentzhfundLog.getFund());
			//计算汇率，调柜台协议，把钱加到柜台账户
			BigDecimal fundbalance =agentzhfundLog.getFund().divide(new BigDecimal(EXCHANGE_RATE), 2,RoundingMode.HALF_UP);
			try {
				if(subzh!=null&&subzh.getIsadmin()==6) {
					String rbStr = simulateStockService.commonFunction("{\"seq_no\":"+agentzhfundLog.getId()+",\"client_id\":\""+subzh.getSubzh()+"\",\"fund_type\":5,\"prev_fund\":0.00,\"after_fund\":"+fundbalance+
							",\"warning_line\":0.00,\"open_line\":0.00}",DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
					if(!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1){
						JsonParser parser = new JsonParser();
						JsonElement element = parser.parse(rbStr);
						JsonObject jsonObj = element.getAsJsonObject();
						log.info("调入金协议成功1：" + rbStr+"---"+DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
			    		if(CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()){
			    		//掉协议成功，入金成功			    			
			    			log.info("调入金协议成功2：" + rbStr);
			    			map.put("status", true);
			    			map.put("msg", "调入金协议成功");
			    		} else {
			    			//入金失败
			    			log.info("调入金协议失败：" + rbStr);
			    			map.put("status", true);
			    			map.put("msg", "调入金协议失败");
			    		}
					}
				}else {
					if(subzh.getFundbalance()!=null) {
						subzh.setFundbalance(subzh.getFundbalance().add((agentzhfundLog.getFund())));
				}
					subzhMapper.updateByPrimaryKeySelective(subzh);
				}
			} catch (Exception e) {
				log.error("调入金协议出现异常",e);
			}
			return map;
		}

	/**
	 * //调柜台出金协议
	 * @param subzh 账户信息
	 * @param afl  出金信息
	 * @return
	 */
	
	public Map<String, Object> getMoney(Subzh subzh,AgentzhfundLog afl){
			Map<String, Object> map=new HashMap<String, Object>();
			//计算汇率，调柜台协议，把钱加到柜台账户
			log.info("调柜台的出金金额"+afl.getFund());
			BigDecimal fundbalance =afl.getFund().divide(new BigDecimal(EXCHANGE_RATE), 2,RoundingMode.HALF_UP);
			try {
			if(null!=afl&&afl.getId()!=null&&afl.getId()!=0){	
					
						log.info("提现调柜台协议开始");
						
						String  str="{\"seq_no\":"+afl.getId()+",\"client_id\":\""+subzh.getSubzh()+"\",\"fund_type\":1,\"prev_fund\":0.00,\"after_fund\":"+fundbalance+
								",\"warning_line\":0.00,\"open_line\":0.00}";
						
						String rbStr = simulateStockService.commonFunction(str,DefineNumber.JCL_PROTOCOL_ID_REQ_FUNDMESSAGE);
						log.info("传到柜台的参数"+rbStr);
						if(!StringUtil.isAnyNullOrEmpty(rbStr) && rbStr.indexOf("{") > -1){
							JsonParser parser = new JsonParser();
							JsonElement element = parser.parse(rbStr);
							JsonObject jsonObj = element.getAsJsonObject();
				    		if(CONST.STATUS_INT_INSTANCE_SUCCESS == jsonObj.get("status").getAsInt()){
				    			log.info("调柜台协议成功");
				    			//保存资金流水信息
				    			map.put("status", true);
				    			map.put("msg", "申请提现成功");
				    		} else{
				    			//调柜台协议失败删除该条记录
				    			log.info(jsonObj.get("describe"));  
				    			map.put("status", false);
				    			map.put("msg", "提现出现异常，请联系管理员");
				    		}
						}

				}
			}catch (Exception efund) {
					//调柜台协议失败删除该条记录
					log.error("柜台调协议异常：" + efund.getMessage());
					map.put("status", false);
	    			map.put("msg", "提现出现异常，请联系管理员");
				}
			return map;
		}
	
	public Long getLong(String str) {
		String[] arr = str.split("\\.");
		
		return Long.parseLong(arr[0]);
	}

	//快捷充值接口
	@Override
	public void paymentH5(HttpServletRequest request, HttpServletResponse response) {
		BryConfig.MER_PRK=MER_PRKs;
		BryConfig.MER_PUB_KEY=MER_PUB_KEYs;
		BryConfig.PL_PBK=PL_PBKs;
		BryConfig.merchantNo=merchantid;
		String returnURL = project_path+"/subzhfund/payCallBack";//同步跳转地址
		String noticeURL = project_path+"/subzhfund/payNotyfyH5";//异步地址
		try {
			request.setCharacterEncoding("UTF-8");
			Enumeration<String> enumeration = request.getParameterNames();

			WapPayRequest wapPayRequest = new WapPayRequest();
			Class c = WapPayRequest.class;
			while (enumeration.hasMoreElements()) {
				String key = enumeration.nextElement();
				Field f = c.getDeclaredField(key);
				f.setAccessible(true);
				if ("tranAmt".equalsIgnoreCase(key)) {
					f.set(wapPayRequest, Long.parseLong(request.getParameter(key)));
				} else {
					f.set(wapPayRequest, request.getParameter(key));
				}
			}
			wapPayRequest.setTxCode("10013");
			wapPayRequest.setMerchantNo(BryConfig.merchantNo);
			wapPayRequest.setTransDate(com.payment.common.utils.DateUtil.getStandardDate("yyyy-MM-dd HH:mm:ss", new Date()));
			wapPayRequest.setVersion("1.0");
			wapPayRequest.setLsh(RandomStringUtils.randomNumeric(17));
			wapPayRequest.setNoticeURL(noticeURL);
			wapPayRequest.setReturnURL(returnURL);
			//保存充值信息
			AgentzhfundLog agentzhfundLog=new AgentzhfundLog();
			
			String txSN=wapPayRequest.getTxSn();
			String subzh=txSN.substring(0, 11);
			long fundlong= wapPayRequest.getTranAmt();
			wapPayRequest.setTranAmt(fundlong*100);
			BigDecimal fund = new BigDecimal(fundlong);
			saveAgentzhfundLog(agentzhfundLog,subzh, txSN, DateUtil.getSystemDate(), fund, 0, 1);
			//加密验签
			String sign = SignUtils.createSignData(wapPayRequest, BryConfig.MER_PRK);
			 String jsonString = JSON.toJSONString(wapPayRequest); 
			log.info("请求参数     ：  "+jsonString);
			Map<String, String> reqMap = new HashMap<String, String>();
			reqMap.put("txCode", wapPayRequest.getTxCode());
			reqMap.put("signature", sign);
			reqMap.put("version", wapPayRequest.getVersion());
			reqMap.put("message", new BASE64Encoder().encode(JSON.toJSONString(wapPayRequest).getBytes("UTF-8")));
			reqMap.put("merchantId", BryConfig.merchantNo);
			//log.info("请求参数     ：  "+reqMap);
			StringBuffer formHtml = new StringBuffer();
			System.out.println(BryConfig.HTTPS_WAP_PAY_URL);
			formHtml.append("<form name='form' method='post' action='" + BryConfig.HTTPS_WAP_PAY_URL + "'>");
			for (Map.Entry<String, String> entry : reqMap.entrySet()) {
				formHtml.append(
						"<input type='hidden' name='" + entry.getKey() + "' value='" + entry.getValue() + "'/>");
			}
			formHtml.append("</form>");
			formHtml.append("<script type='text/javascript'>");
			formHtml.append(" form.submit();");
			formHtml.append("</script>");
			request.setAttribute("submitForm", formHtml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			request.getRequestDispatcher("/request.jsp").forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}




	@Override
	public Map<String, Object> payNotyfyh5(HttpServletRequest request) {
		log.info("快捷充值回调开始");
		Map<String, Object>map=new HashMap<String, Object>();
	try {
		request.setCharacterEncoding("UTF-8");
		String sign = request.getParameter("sign");
		String message = request.getParameter("message");
		 log.info("sign--回调参数   :   " +sign);
		 log.info("message--回调参数   :   " +message);
		
		QueryOneTransResponse oneTransResponse = JSON.parseObject(
				new String(new BASE64Decoder().decodeBuffer(message), "UTF-8"), QueryOneTransResponse.class);

		JSONObject jsonObject = (JSONObject) JSON.toJSON(oneTransResponse);
		Map<String, String> omap = new HashMap<String, String>();
		List<String> keys = new ArrayList<String>();
		if (null != jsonObject) {
			Set<Entry<String, Object>> set = jsonObject.entrySet();
			for (Entry<String, Object> entry : set) {
				omap.put(entry.getKey(), String.valueOf(entry.getValue()));
				if (ValidationUtil.isNotBlank(entry.getValue())) {
					keys.add(entry.getKey());
				}
			}
		}
		Collections.sort(keys);
		StringBuffer signStr = new StringBuffer();
		for (String key : keys) {
			signStr.append(key).append("=").append(omap.get(key)).append("&");
		}
		if (signStr.toString().endsWith("&")) {
			signStr.delete(signStr.length() - 1, signStr.length());
		}
		
		log.info("signStr   :   " +signStr);
		boolean verfy=false;
		try {
			 verfy = SignUtils.verySign(signStr.toString(),PL_PBKs, sign);
			 log.info("verfy--交易状态   :   " +verfy);
		} catch (Exception e) {
			log.error("验签出现异常", e);
		}
	
		if(verfy){
			String orderid = oneTransResponse.getTxSN();//订单号
			long amount=oneTransResponse.getTranAmt();//金额
			String datetime=oneTransResponse.getTransDate();//交易时间
			String returncode=oneTransResponse.getReturnCode();//交易状态
			String returnMsg=oneTransResponse.getReturnMsg();//
			String resultCode=oneTransResponse.getResultCode();//
			String resultMsg=oneTransResponse.getResultMsg();
			AgentzhfundLog afl=new AgentzhfundLog();
			if(null!=resultCode&&resultCode.equals("FL0000")) {
				log.info("充值金额  ： "+amount +"   充值时间   ：  "+ datetime+"   订单号   ："+orderid);
				log.info("returnMsg  ： "+returnMsg +"   returncode   ：  "+ returncode+"   resultMsg  ："+resultMsg);
				
	    		List<AgentzhfundLog> alist= null;
	    		alist = agentzhfundLogMapper.selectByorderno(orderid);
	    		log.info("alist ===>"+alist.size());
	    		if(alist!=null&&alist.size()>0) {
	    			afl=alist.get(0);
	    			if(afl.getStatus()==1){//已经充值成功了。
	    				log.info("该单号充值已完成"+new Date().toString());
	    				map.put("msg", "该单号充值已完成");
	    				map.put("status", false);
	    				return map;
	    			}
	    		}
	    		Subzh sub = subzhMapper.selectBySubzh(afl.getSubzh());
	    	 	if(sub!=null) {	    			
		    		log.info("log8:subzh"+sub);
		    		sub.setZhstate(1);
		    		int count=subzhMapper.updateByPrimaryKeySelective(sub);
		    		log.info("log11:subzhService"+count);
		    		List<FundPzlog> sfplist = getFundPzlogList(sub);
		    		afl.setFund(afl.getFund().multiply(new BigDecimal(0.994)));
		    		//调柜台
		    	    Map<String, Object> amap=addMoney(sub, afl);
		    	    if(null!=amap&&amap.size()>0) {
		    	    	if(null!=amap.get("status")&&(Boolean) amap.get("status")) {
		    	    		afl.setStatus(1);//修改状态为1 --表示充值成功
		    	    		map.put("status", true);
		    	        	map.put("msg", "充值成功");
		    	        	FundPzlog fundPzlog = saveFundpzlog(sub.getSubzh(), afl.getFund(), orderid, DateUtil.getSystemDate(), 6);	    	
		    	    	}else {
		    	    		afl.setStatus(2);//修改状态为2 --表示充值失败	 
		    	    		map.put("status", false);
		    	        	map.put("msg", "充值失败");
		    	        	
		    	   		 	if ((sfplist == null) && (sfplist.size() <= 1)) {
		    	   		 		sub.setZhstate(Integer.valueOf(0));
		    	   		 	}
		    	    	  }
		    	    	}else {
			    	    	afl.setStatus(2);//修改状态为2 --表示充值失败
			    	    	map.put("status", false);
				        	map.put("msg", "充值失败");
				        	if ((sfplist == null) && (sfplist.size() <= 1)) {
		    	   		 		sub.setZhstate(Integer.valueOf(0));
		    	   		 	}
			    	    }
		    	    subzhMapper.updateByPrimaryKeySelective(sub);
		    		log.info("log11:subzhService");
		    	    }
	    	 	agentzhfundLogMapper.updateByPrimaryKeySelective(afl);
			}else{
	        	map.put("status", false);
	        	map.put("msg", "充值失败");
	        }
		}else{
	    	log.info("验签失败");
        	map.put("status", false);
        	map.put("msg", "充值失败");
	    }
	}catch (Exception e) {
		log.info("充值回调异常", e);
	}
	return map;
	}
		

}