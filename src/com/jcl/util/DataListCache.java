package com.jcl.util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataListCache {
	//并发map，支持16线程读写
	@SuppressWarnings("rawtypes")
	private static ConcurrentHashMap<String, List> subjectMap = new ConcurrentHashMap<String, List>();
	private static ConcurrentHashMap<String, Integer> idMap = new ConcurrentHashMap<String, Integer>();
	
	private static ConcurrentHashMap<String, Map<String, String>> msCodeMap = new ConcurrentHashMap<String, Map<String, String>>();

	/*设置ID在缓存中*/
	public static void setIdCache(String key, Integer value) {
		idMap.put(key, value);
	}
	
	/*根据key获取缓存ID*/
	public static Integer getIdCache(String key) {
		Integer id = idMap.get(key);
		return id;
	}
	
	/*设置集合到缓存中*/
	@SuppressWarnings("rawtypes")
	public static void setListCache(String key, List list) {
		subjectMap.put(key, list);
	}
	
	/*在缓存中获取集合*/
	@SuppressWarnings("rawtypes")
	public static List getListCache(String key) {
		List list = subjectMap.get(key);
		return list;
	}
	
	/*设置集合到缓存中*/
	public static void setMsCodeCache(String key, Map<String, String> map) {
		msCodeMap.put(key, map);
	}
	
	/*在缓存中获取集合*/
	public static Map<String, String> getMsCodeCache(String key) {
		Map<String, String> map = msCodeMap.get(key);
		return map;
	}
	
}