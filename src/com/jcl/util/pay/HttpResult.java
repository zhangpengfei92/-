package com.jcl.util.pay;

/**
 * HttpResult 请求接收实体
 */
public class HttpResult {

    private String sign;

    private String payMessage;

    private String errMsg;

    private String resultCOde;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPayMessage() {
        return payMessage;
    }

    public void setPayMessage(String payMessage) {
        this.payMessage = payMessage;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getResultCOde() {
        return resultCOde;
    }

    public void setResultCOde(String resultCOde) {
        this.resultCOde = resultCOde;
    }
}
