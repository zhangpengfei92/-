package com.sandepay.domain;



/**
 * ClassName:CancelResponse.java <br/>
 * Function: 申请绑卡<br/>
 * Date: 2016年11月22日 上午10:01:01 <br/>
 */
public class ApplyBindCardRequest extends PubRequest {
    private String userId;

    private String cardNo;
    private String userName;
    private String phoneNo;
    private String certificateNo;
    private String certificateType;
    private String creditFlag;
	private String notifyUrl; //异步通知地址：需要向杉德报备该地址信息
	private String frontUrl; //前端通知地址
    private String checkNo;        //贷记卡Cvn2码：贷记卡绑卡时必送
    private String checkExpiry;    //贷记卡有效期：贷记卡绑卡时必送
    private String applyNo; // 商户请求流水号
    private String extend;
    
    public String getApplyNo() {
        return applyNo;
    }

    public String getNotifyUrl() {
		return notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getFrontUrl() {
		return frontUrl;
	}

	public void setFrontUrl(String frontUrl) {
		this.frontUrl = frontUrl;
	}

	public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCreditFlag() {
        return creditFlag;
    }

    public void setCreditFlag(String creditFlag) {
        this.creditFlag = creditFlag;
    }

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    public String getCheckExpiry() {
        return checkExpiry;
    }

    public void setCheckExpiry(String checkExpiry) {
        this.checkExpiry = checkExpiry;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    @Override
    public String toString() {
        return "ApplyBindCardRequest [userId=" + userId + ", cardNo=" + cardNo
                + ", userName=" + userName + ", phoneNo=" + phoneNo
                + ", certificateNo=" + certificateNo + ", creditFlag="
                + creditFlag + ", checkNo=" + checkNo + ", checkExpiry="
                + checkExpiry + ", applyNo=" + applyNo + ", extend=" + extend
                + ", toString()=" + super.toString() + "]";
    }

}
