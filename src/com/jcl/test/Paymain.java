/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @Paymain.java
 * 功能概要  : 
 * 做成日期  : @2018年11月13日
 * 修改日期  :
 */
package com.jcl.test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.jcl.util.spt.HttpRequest;

/** 
 * @author zpf
 * @version 1.0
 */
public class Paymain { 

	private static final String url="http://47.244.3.128/apibank";
	
	private static final String apiKey="da1d58b9c3dccb3374379d08d1dc0879e821a5e8";

	public static void main(String[] args) {
		
		doPay();
	}
	
	public static void doPay() {
		String version = "1.0";
		   String customerid = "11042";
		   String sdorderno ="123456789668";
		   String total_fee ="5.00";
		   String paytype = "jrzfb";
		   //String bankcode = "CCB";
		   String remark = "TEST";
		   String returnurl ="http://120.26.246.221:5880/cxpay/payReturn";
		   String notifyurl = "http://120.26.246.221:5880/cxpay/payNotify";
		   String noSignstr = "version="+version+"&customerid="+customerid+"&total_fee="+total_fee
			        +"&sdorderno="+sdorderno+"&notifyurl="+notifyurl+"&returnurl="+returnurl+"&"+apiKey;

		   String sign = getMD5(noSignstr);
		   
		   Map<String, String>map = new  HashMap<String, String>();		   
		    map.put("version", version);//版本
			map.put("customerid", customerid);//商户号
			map.put("sdorderno", sdorderno);//订单号
			map.put("total_fee", total_fee);//金额
			map.put("paytype", "jrzfb");//支付方式
			map.put("bankcode", "");//银行编号
			map.put("remark", remark);//备注
			map.put("returnurl", returnurl);//同步返回的url
		    map.put("notifyurl", notifyurl);//异步回调的url
		    map.put("sign", sign);//加密串
		   String result = HttpRequest.sendPost(url, map);
		   System.out.println("时间 ："+new Date()+"  --结果 ："+result);
	}

    public static  String getMD5(String str) {
        try {
            
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            md.update(str.getBytes());
            
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    } 
	
}
