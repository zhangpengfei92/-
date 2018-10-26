package com.jcl.util;

public class Constant {
	/** session key : path */
	public static final String SESSION_PATH = "path";
	/** session key : basePath */
	public static final String SESSION_BASEPATH = "basePath";
	/** session key : themePath */
	public static final String SESSION_CSSPATH = "cssPath";
	/** session key : jsPath */
	public static final String SESSION_JSPATH = "jsPath";
	/** session key : imagesPath */
	public static final String SESSION_IMAGESPATH = "imagesPath";
	/** session key : 验证码 */
	public static final String SESSION_CAPTCHA = "SESSION_CAPTCHA";
	/** session key : 登录用户的账户id */
	public static final String SESSION_ACCOUNTID = "SESSION_ACCOUNTID";
	/** session key : 登录用户的用户名  */
	public static final String SESSION_LOGINNAME = "SESSION_LOGINNAME";
	/** 删除标识，已删除 */
	public static final Integer DELETED_INT_YES = 0;
	/** 产品状态标识，启用 */
	public static final Integer PRODUCT_INT_YES = 1;
	/** 产品状态标识，停用 */
	public static final Integer PRODUCT_INT_NO = 2;
	/** 产品状态标识，停用 */
	public static final Integer PRODUCT_INT_INFO = 3;
	/** 默认登录密码  */
	public static final String DEFAULT_PWD = "111111";
	/** default usertype */
	public static final String USERTYPE_DEFAULT = "0";
	/** default syncinfo */
	public static final String SYNCINFO_DEFAULT = "1";
	/** default clientFrom */
	public static final String CLIENTFORM_DEFAULT = "bl";
	/** 删除标识，未删除 */
	public static final String DELETED_NO = "0";
	/** 映射路径地址 */
	public static final String TOMCAT_MAP_PATH = DeployProperties.getInstance().getPhotoDirectory();
	/** 映射服务器地址 */
	public static final String TOMCAT_SERVER_PATH = DeployProperties.getInstance().getPhotoUploadUrl();
	/**当前服务器IIS ip:port 地址*/
	public static final String IIS_SERVERADDRESS = DeployProperties.getInstance().getPublicApachePath();
	/**apache 地址*/
	public static final String APACHEPATH = DeployProperties.getInstance().getProperty("file_path");
	/**apache 访问地址*/
	public static final String APACHEPATH_HTTP = DeployProperties.getInstance().getProperty("http_apache");
	
	/** 类型 1:日收益 2:月收益 3:总收益*/
	public static final String SETTLE_PROFIT_TYPE_DAY = "1";
	public static final String SETTLE_PROFIT_TYPE_MONTH = "2";
	public static final String SETTLE_PROFIT_TYPE_TOTAL = "3";
	public static final String SETTLE_PROFIT_TYPE_MEND = "4";
	public static final String SETTLE_SELL_TYPE_MEND = "sellEntrustList";
	public static final String SETTLE_BUY_TYPE_MEND = "buyEntrustList";
	public static final String SETTLE_TRADER_TYPE_MEND = "traderOrderList";
	public static final String SETTLE_CLOSE_TYPE_MEND = "closeOrderList";
	public static final String SETTLE_CANCEL_TYPE_MEND = "cancelOrderList";
	
	/*SPT商户号*/
	public static final String SPT_MERCHART="8000605151";
	public static final String SPT_SECRTKEY="d0aca96c7e679c7107958cbe43380328";
	/**
	 * 快捷支付收银台
	 */
	public static final String SPT_UNION_PAY_URL="https://gw.lpt-pay.com/pay/union/quick/syt";
	/**
	 * 银联h5
	 */
	public static final String SPT_H5_PAY_URL="https://gw.lpt-pay.com/pay/h5";
	/**
	 * 银联网关
	 */
	public static final String SPT_WG_PAY_URL="https://gw.lpt-pay.com/pay/union/gateway";
	

	
}