package com.jcl.stock.simulate.entity;


/**
 * Title: EtfRsp.java Description: 注册请求参数
 * 
 * @author zhuj
 * @created 2015-5-27 下午1:18:16
 */

//public class RegisterReq extends ReqBase {
public class RegisterReq {
	/*private String userName;//用户名
	private String passWord;//用户名
	private double dInitialcapital;//初始资产
	private String telNum;//电话号码
	private int isRobot;//
	*/
	private String client_id;//用户名
	private String nickname;//昵称
	private String tel_num;//手机号
	
	/*public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public double getdInitialcapital() {
		return dInitialcapital;
	}
	public void setdInitialcapital(double dInitialcapital) {
		this.dInitialcapital = dInitialcapital;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public int getIsRobot() {
		return isRobot;
	}
	public void setIsRobot(int isRobot) {
		this.isRobot = isRobot;
	}*/
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTel_num() {
		return tel_num;
	}
	public void setTel_num(String tel_num) {
		this.tel_num = tel_num;
	}
	
	
}
