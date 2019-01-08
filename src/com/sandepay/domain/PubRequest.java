package com.sandepay.domain;

public class PubRequest {
	
    /** 调用的接口版本 **/
    private String version;
    /** 接口名称 **/
    private String method;
    /** 产品编号 */
    private String productId;
    /** 接入类型 **/
    private String accessType;
	/** 商户号 **/
    private String mid;
    /** 平台商户号 **/
    private String plMid;
    /** 渠道类型 */
    private String channelType;
    /** 商户请求时间 **/
    private String reqTime;
    
    /** 请求IP **/
    private String clientIP;
    
    public String getClientIP() {
		return clientIP;
	}
	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPlMid() {
		return plMid;
	}
	public void setPlMid(String plMid) {
		this.plMid = plMid;
	}
	public String getChannelType() {
		return channelType;
	}
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	public String getReqTime() {
		return reqTime;
	}
	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}
    
    
}
