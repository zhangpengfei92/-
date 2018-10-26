package com.jcl.stock.simulate.entity;

  
    /**        
     * Title: HeadData.java    
     * Description: 包头参数集合
     * @author zhuj       
     * @created 2015-5-15 下午1:29:07    
     */      
    
public class HeadData {
	
	private long hs; // 包头校验(校验整个和后面的数据)
	private long cookie;// 用户上层自己携带的信息（可能服务端主动推送给客户端的）
	private long synId;// 同步ID，保留使用的异步信息
	private long assisId;// 辅助ID，方便客户端携带更多信息
	
	private int rawLen;// 原始没有压缩的长度
	private int packLen;// 包长,不包括包头自己;放到最前，可以兼容其他系统
	private int funcId;// 功能号；常见协议类型，如果需要具体分类，自行处理
	
	private int version;//版本号
	private int compressed;//压缩或者加密，混合最多情况(0 : 没有压缩；1：zlib；2：c压缩)
	private int encrypt;// 加密方式：0 不加密 ；1 ssl加密 ；
	
	private int hclient;// 协议版本号256个版本
	private String guid;//GUID
	private String businessId;//请求流水号，用于匹配   当前请求与当前响应
	
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
	public int getCompressed() {
		return compressed;
	}
	public void setCompressed(int compressed) {
		this.compressed = compressed;
	}
	public int getRawLen() {
		return rawLen;
	}
	public void setRawLen(int rawLen) {
		this.rawLen = rawLen;
	}
	
}
