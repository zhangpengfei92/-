package com.jcl.util;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DeployProperties extends PropertiesConfigBase{
	private static Logger logger = Logger.getLogger(DeployProperties.class);

	private static final String FILE_NAME = "resoure.properties";
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

	/**
	 * 获取股票的行情
	 * @return
	 */
	public String getStockInfoUrl(){
		return getProperty("hq.stockinfo");
	}
	/**
	 * 获取apache路径
	 * @return
	 */
	public String getPublicApachePath(){
		return getProperty("http_apache");
	}
	/**
	 * 获取项目部署路径
	 * @return
	 */
	public String getPublicProjectePath(){
		return getProperty("public.http.project");
	}
	
	/**
	 * 获取文件上传卢进
	 * @return
	 */
	public String getPublicFilePath(){
		return getProperty("file_path");
	}
	
	/**
	 * 获取app访问路径
	 * @return
	 */
	public String getPublichttpAppPath(){
		return getProperty("http_app_file_path");
	}
	/**
	 * 获取app上传路径
	 * @return
	 */
	public String getPublicAppPath(){
		return getProperty("app_file_path");
	}
	/**
	 * 获取redis IP
	 * @return
	 */
	public String getRedisUrlPort(){
		return getProperty("public.redis.host");
	}
	/**
	 * 获取redis PORT
	 * @return
	 */
	public String getRedisPort(){
		return getProperty("public.redis.port");
	}
	
	/**
	 * 获取上传图片地址
	 * 
	 * @return
	 */
	public String getPhotoUploadUrl() {
		return getProperty("public.photo.uploadurl");
	}
	/**
	 * 获取图片上传目录
	 * 
	 * @return
	 */
	public String getPhotoDirectory() {
		return getProperty("public.photo.directory");
	}
	
	/**
	 * 获取每日结算时间
	 * @return
	 */
	public String getPublicSettleTime(){
		return getProperty("public.list.settletime");
	}
	
	/**
	 * 获取分成比例
	 * @return
	 */
	public String getPublicInviterProportion(){
		return getProperty("public.inviter.proportion");
	}
	
	/**
	 * 短信服务
	 * 获取Send Message url
	 * @return
	 */
	public String getSendMessageUrl(){
		return getProperty("public.message.url");
	}
	/**
	 * 获取Send Message uid
	 * @return
	 */
	public String getSendMessageUid(){
		return getProperty("public.message.uid");
	}
	/**
	 * 获取Send Message username
	 * @return
	 */
	public String getSendMessageUsername(){
		return getProperty("public.message.username");
	}
	/**
	 * 获取Send Message password
	 * @return
	 */
	public String getSendMessagePassword(){
		return getProperty("public.message.password");
	}
	/**
	 * 获取Send Message password
	 * @return
	 */
	public String getSendEmailFrom(){
		return getProperty("mail.smtp.from");
	}
	
}