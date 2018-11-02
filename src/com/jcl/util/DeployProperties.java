package com.jcl.util;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DeployProperties extends PropertiesConfigBase{
	private static Logger logger = Logger.getLogger(DeployProperties.class);

	private static final String FILE_NAME = "deployconfig.properties";
	private static DeployProperties instance = new DeployProperties();

	public static DeployProperties getInstance() {
		return instance;
	}
	
	
	@Override
	protected Resource getResource() {
		return new ClassPathResource(FILE_NAME);
	}

	private DeployProperties() {
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
	 * 获取apache路径
	 * @return
	 */
	public String getPublicApachePath(){
		return getProperty("public_apache_path");
	}
	
}