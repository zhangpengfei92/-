package com.jcl.stock.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.Resource;

/**
 * properties配置文件处理基类
 */
public abstract class PropertiesConfigBase {
	private static long lastModified = 0L;
	//private File file;
	protected Properties properties = null;
	
	/**
	 * 获取资源
	 */
	protected abstract Resource getResource();
	
	/**
	 * 自动更新
	 */
	protected boolean autoUpdate(){
		return true;
	}
	
	/**
	 * 初始化
	 */
	protected void init(){
		
	}
	
	/**
	 * 加载配置
	 */
	protected void load() throws IOException{
			Resource resource = getResource();
			if(resource==null) throw new RuntimeException("resource is null");
			File file = resource.getFile();
			lastModified = file.lastModified();
			if (lastModified == 0) {
				throw new IOException("Can not find the file. " + file.getPath());
			}
			properties = new Properties();
			properties.load(resource.getInputStream());
			resource = null;
			init();
	}
	
	public String getProperty(String key) {
		return getProperty(key, "");
	}

	public String getProperty(String key, String defaultValue) {
		if(autoUpdate()){
			Resource resource = getResource();
			long newTime= 0L;
			try {
				newTime = resource.getFile().lastModified();
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}
		    if (newTime > lastModified) {
				try {
					properties.clear();
					properties.load(new FileInputStream(resource.getFile()));
				} catch (Exception e) {
					e.printStackTrace();
				}
				lastModified = newTime;
				try {
				    init();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		String v = properties.getProperty(key);
		return v == null ? defaultValue : v;
	}
}
