package com.jcl.vo;

public class Payroll {

	private String merch;//商户号

	private String orderno;//代付订单号
	
	private String amount;//交易金额，以分为单位，不允许包含任何字符号
	
	private String notifyurl;//代付异步回调通知地址
	
	private String cardtype;//1 对私 2 对公
	
	private String bankcode;//银行卡编码：例如工商银行：ICBC
	
	private String bankname;//银行卡开户行名称
	
	private String bankbranch;//银行卡开户支行名称
	
	private String cardname;//收款人姓名
	
	private String cardno;//收款人银行账号
	
	private String cardmobile;//银行预留手机号
	
	private String certid;//身份证号
	
	private String province;//开户行所在省
	
	private String city;//开户行所在市

	private String sign;//签名串
	
	private String signtype;//签名方式，目前指定 MD5

	public String getMerch() {
		return merch;
	}

	public void setMerch(String merch) {
		this.merch = merch;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getNotifyurl() {
		return notifyurl;
	}

	public void setNotifyurl(String notifyurl) {
		this.notifyurl = notifyurl;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getBankbranch() {
		return bankbranch;
	}

	public void setBankbranch(String bankbranch) {
		this.bankbranch = bankbranch;
	}

	public String getCardname() {
		return cardname;
	}

	public void setCardname(String cardname) {
		this.cardname = cardname;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getCardmobile() {
		return cardmobile;
	}

	public void setCardmobile(String cardmobile) {
		this.cardmobile = cardmobile;
	}

	public String getCertid() {
		return certid;
	}

	public void setCertid(String certid) {
		this.certid = certid;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSigntype() {
		return signtype;
	}

	public void setSigntype(String signtype) {
		this.signtype = signtype;
	}
	
	
	
}
