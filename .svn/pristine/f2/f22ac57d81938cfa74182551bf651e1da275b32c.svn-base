package com.jcl.stock.simulate.entity;
  
/**        
 * Title: LoginInfoRsp.java    
 * Description: 登录返回结果
 */      
public class LoginInfoRsp{

	private long hs; // 包头校验(校验整个和后面的数据)
	private int hclient;// 协议版本号256个版本
	private long cookie;// 用户上层自己携带的信息（可能服务端主动推送给客户端的）
	private long synId;// 同步ID，保留使用的异步信息
	private long assisId;// 辅助ID，方便客户端携带更多信息
	private int funcId;// 功能号；常见协议类型，如果需要具体分类，自行处理
	private int encrypt;// 加密方式：0 不加密 ；
	private int packLen;// 包长,不包括包头自己;放到最前，可以兼容其他系统
	private int version;//版本号
	private String guid;//GUID
	private String businessId;//请求流水号，用于匹配   当前请求与当前响应

	private int status;//状态
	private String description;//描述
	private int srvId;// 
	private int lastLoginData;// 上次登录的日期 YYYYMMDD
	private String lastLoginTime;// 上次登录的时间? HHMMSS
	
	private int serviceId;// 服务ID
	private byte [] destId = new byte[16];// Guid数组
	
	private String lastLoginName;// 上次登录机器昵称
	private String lastLoginMac;//  MAC地址
	private String lastIp;//  IP地址
	private int lastClientType;// 上次客户登陆类型
	private String digest;// 个性签名，摘要信息
	private String userCheckNo;//交易用户校验编号
	private String deptCode;//营业部代码
	private String clientId;//客户ID
	
	public long getHs() {
		return hs;
	}
	public void setHs(long hs) {
		this.hs = hs;
	}
	public int getHclient() {
		return hclient;
	}
	public void setHclient(int hclient) {
		this.hclient = hclient;
	}
	public long getCookie() {
		return cookie;
	}
	public void setCookie(long cookie) {
		this.cookie = cookie;
	}
	public long getSynId() {
		return synId;
	}
	public void setSynId(long synId) {
		this.synId = synId;
	}
	public long getAssisId() {
		return assisId;
	}
	public void setAssisId(long assisId) {
		this.assisId = assisId;
	}
	public int getFuncId() {
		return funcId;
	}
	public void setFuncId(int funcId) {
		this.funcId = funcId;
	}
	public int getEncrypt() {
		return encrypt;
	}
	public void setEncrypt(int encrypt) {
		this.encrypt = encrypt;
	}
	public int getPackLen() {
		return packLen;
	}
	public void setPackLen(int packLen) {
		this.packLen = packLen;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getLastLoginData() {
		return lastLoginData;
	}
	public void setLastLoginData(int lastLoginData) {
		this.lastLoginData = lastLoginData;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginName() {
		return lastLoginName;
	}
	public void setLastLoginName(String lastLoginName) {
		this.lastLoginName = lastLoginName;
	}
	public String getLastLoginMac() {
		return lastLoginMac;
	}
	public void setLastLoginMac(String lastLoginMac) {
		this.lastLoginMac = lastLoginMac;
	}
	public String getLastIp() {
		return lastIp;
	}
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	public int getLastClientType() {
		return lastClientType;
	}
	public void setLastClientType(int lastClientType) {
		this.lastClientType = lastClientType;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getUserCheckNo() {
		return userCheckNo;
	}
	public void setUserCheckNo(String userCheckNo) {
		this.userCheckNo = userCheckNo;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public int getSrvId() {
		return srvId;
	}
	public void setSrvId(int srvId) {
		this.srvId = srvId;
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public byte[] getDestId() {
		return destId;
	}
	public void setDestId(byte[] destId) {
		this.destId = destId;
	}
	
	
}
