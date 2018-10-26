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
	/** session key : 登录用户的所属机构*/
	public static final String SESSION_AGENTZHGL = "SESSION_AGENTZHGL";
	/** session key : 登录用户的所属平台*/
	public static final String SESSION_PLATEFORM = "SESSION_PLATEFORM";
	
	/** session key : 登录用户的级别*/
	public static final String SESSION_ISADMIN = "SESSION_ISADMIN";//1子管理，2渠道，3经纪人，4普通用户
	/** 删除标识，已删除 */
	public static final Integer DELETED_INT_YES = 0;
	public static final Integer DELETED_INT_NO = 1;
	/** 产品状态标识，启用 */
	public static final Integer PRODUCT_INT_YES = 1;
	/** 产品状态标识，停用 */
	public static final Integer PRODUCT_INT_NO = 2;
	
	/** 类型 1:日收益 2:月收益 3:总收益*/
	public static final String SETTLE_PROFIT_TYPE_DAY = "1";
	public static final String SETTLE_PROFIT_TYPE_MONTH = "2";
	public static final String SETTLE_PROFIT_TYPE_TOTAL = "3";
	public static final String SETTLE_PROFIT_TYPE_MEND = "4";
	
	public static final String SESSION_LEFTMENU = "leftmenu";
	
	//public static final String SESSION_EMP="empusername";
	
	
	/*SPT商户号*/
	public static final String SPT_MERCHART="8000152137";//商务号
	public static final String SPT_SECRTKEY="bb91b11167fe0d461c8d6cf6a100dc53";//秘钥

	
	/**
	 * 银联h5
	 */
	public static final String SPT_H5_PAY_URL="http://gw.spt-pay.cn/pay/h5";

	
}