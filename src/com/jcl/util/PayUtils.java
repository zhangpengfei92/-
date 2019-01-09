/**
 * Copyright (C) 2009 武汉金策略信息科技有限公司
 *
 * 版权所有。
 *
 * 类名　　  : @PayUtils.java
 * 功能概要  : 
 * 做成日期  : @2018年12月3日
 * 修改日期  :
 */
package com.jcl.util;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

/** 
 * @author zpf
 * @version 1.0
 * 三方支付接口常用到的工具类
 */
public class PayUtils {
	public static Logger log = Logger.getLogger(PayUtils.class);
	
	//md5加密
	public static String md5(Map<String, String> map,String formatStr,String key) {
		   StringBuilder str=new StringBuilder(); 
		   Set<Entry<String, String>> entryset= map.entrySet();
		   Iterator<Entry<String, String>> it = entryset.iterator();
		   
		   while(it.hasNext()){
		   Entry<String, String>  entry =it.next();
		   str.append(entry.getKey()+formatStr+entry.getValue()+"&");
		   }
		   log.info("md5加密串--"+str.toString()+"key="+key);
		   String md5sign=Tools.MD5Encode(str.toString()+"key="+key);
		   //String md5sign=MD5Utils.md5(str.toString()+"key="+key);
		   log.info("md5加密后--"+md5sign);
		   return md5sign;
	}
	
	public static String md5s(Map<String, Object> map,String formatStr,String key) {
		   StringBuilder str=new StringBuilder(); 
		   Set<Entry<String, Object>> entryset= map.entrySet();
		   Iterator<Entry<String, Object>> it = entryset.iterator();
		   
		   while(it.hasNext()){
		   Entry<String, Object>  entry =it.next();
		   str.append(entry.getKey()+formatStr+entry.getValue()+"&");
		   }
		   log.info("md5加密串--"+str.toString()+key);
		   String md5sign=Tools.MD5Encode(str.toString()+"key="+key);
		   //String md5sign=MD5Utils.md5(str.toString()+"key="+key);
		   log.info("md5加密后--"+md5sign);
		   return md5sign;
	}
	
	//encoder编码
	public static String encoderdata(Map<String, Object> map,String formatStr,String md5Sign) {
		   StringBuilder data=new StringBuilder(); 
		   try {
		   Set<Entry<String, Object>> entryset= map.entrySet();
		   Iterator<Entry<String, Object>> it = entryset.iterator();
		   log.info("编码前--"+map.toString());
		   while(it.hasNext()){
		   Entry<String, Object>  entry =it.next();
		  
			   data.append(entry.getKey()+formatStr+URLEncoder.encode((String)entry.getValue(),"UTF-8")+"&");		
		   
		   }
		   data.append("sign="+URLEncoder.encode(md5Sign,"UTF-8"));
		 } catch (Exception e) {
				e.printStackTrace();
			}
		   log.info("编码后--"+data);
		   return data.toString();
	}	
}
