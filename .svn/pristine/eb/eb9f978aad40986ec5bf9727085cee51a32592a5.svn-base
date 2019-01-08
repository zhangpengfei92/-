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
		return getProperty("public.http.apache");
	}
	
	/**
	 * 获取文件上传路径
	 * @return
	 */
	public String getPublicFilePath(){
		return getProperty("public.file.path");
	}
	
	/**
	 * 获取文件spt回调路径
	 * @return
	 */
	public String getSptReturn(){
		return getProperty("public.http.project");
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
	 * 获取体验版ID
	 * @return
	 */
	public int getPublicFreeversionRoleId(){
		return Integer.parseInt(getProperty("public.freeversion.roleid"));
	}
	
	/**
	 * 获取体验版免费时间
	 * @return
	 */
	public int getPublicFreeversionDays(){
		return Integer.parseInt(getProperty("public.freeversion.days"));
	}
	
	/**
	 * 获取重置密码
	 * @return
	 */
	public String getPublicDefaultPassword(){
		return getProperty("public.default.password");
	}
	
	/**
	 * 获取商户号
	 * @return
	 */
	public String getUnspayMarket(){
		return getProperty("public.unspay.marketno");
	}
	
	/**
	 * 商户密钥
	 * @return
	 */
	public String getUnspayPassword(){
		return getProperty("public.unspay.password");
	}
	
	/**
	 * 获取快捷支付地址
	 * @return
	 */
	public String getUnspayQuickpay(){
		return getProperty("public.unspay.quickpay");
	}
	
	/**
	 * 获取代付地址
	 * @return
	 */
	public String getUnspayPaywithdraw(){
		return getProperty("public.unspay.paywithdraw");
	}
	
	/**
	 * 获取银生宝支付成功回调地址
	 * @return
	 */
	public String getUnspaySuccessServer(){
		return getProperty("public.unspay.successserver");
	}
	
	/**
	 * 获取银生宝前台响应地址
	 * @return
	 */
	public String getUnspayCallbackAddr(){
		return getProperty("public.unspay.callbackaddr");
	}
	
	/**
	 * 获取MS代码链市场信息	
	 * @return
	 */
	public String getMsCodeMarket(){
		return getProperty("public.mscode.market");
	}
	
	/**
	 * 获取MS代码链市场信息	
	 * @return
	 */
	public String getMsCodeCtpMarket(){
		return getProperty("public.mscode.ctpmarket");
	}
	
	/**
	 * 获取MS代码链地址	
	 * @return
	 */
	public String getMsCodeUrl(){
		return getProperty("public.mscode.url");
	}
	
	/**
	 * 获取项目部署路径
	 * @return
	 */
	public String getPublicProjectePath(){
		return getProperty("public.http.project");
	}
	
	/**
	 * 获取短信发送配置
	 * @return
	 */
	public String getMessageConfig(){
		return getProperty("public.httpmsg.config");
	}
	
}