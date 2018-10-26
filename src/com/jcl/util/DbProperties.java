package com.jcl.util;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DbProperties extends PropertiesConfigBase{
	private static Logger logger = Logger.getLogger(DbProperties.class);

	private static final String FILE_NAME = "db.properties";
	private static DbProperties instance = new DbProperties();

	public static DbProperties getInstance() {
		return instance;
	}
	
	@Override
	protected Resource getResource() {
		return new ClassPathResource(FILE_NAME);
	}

	private DbProperties() {
		try {
			this.load();
		} catch (Exception e) {
			logger.error("Failed to load the config file " + FILE_NAME,e);
		}
	}

	public Integer getInt(String key) {
		return Integer.parseInt(getProperty(key));
	}
	
	/**
	 * 获取mongodb.user.dburi
	 * @return
	 */
	public String getMongodbUri(){
		return getProperty("mongodb.user.dburi");
	}
	
	/**
	 * 获取mongodb.ip
	 * @return
	 */
	public String getMongodbIp(){
		return getProperty("mongo.host");
	}
	
	/**
	 * 获取mongodb.port
	 * @return
	 */
	public int getMongodbPort(){
		return Integer.parseInt(getProperty("mongo.port"));
	}
	
	/**
	 * 获取mongodb.datastore
	 * @return
	 */
	public String getMongodbDataStore(){
		return getProperty("mongo.dbName");
	}
}