package com.sandepay.apipay;



import cn.com.sandpay.cashier.sdk.util.DateUtil;

import org.junit.Test;

import com.sandepay.domain.PayRequest;

/**
 * API支付示例
 *
 * @author moon
 */
public class FastPayApiPayTest extends AbstractTest {

    /*
     * 下单支付
     */
    private static final String PAY_API_NAME = "fastPay/apiPay/pay";


    /**
     * 设置服务端地址
     */
    public FastPayApiPayTest() {
        SD_REQUEST_URL = "http://192.168.22.79:8080/pay-client/";
    }

    /**
     * API支付接口调用示例
     * 说明：1、商户接入需加载公私钥到项目中
     * 2、封装调用杉德服务端接口，具体参数说明请参考接入文档
     * 3、POST请求杉德服务端
     * 4、验证杉德返回数据签名
     */
    @Test
    public void payTest() {
        try {
            // 组织支付HEAD域
            PayRequest requestHead = new PayRequest();
            requestHead.setVersion("1.0");
            requestHead.setMethod("sandPay.fastPay.apiPay.pay");    // 需要测试的流程
            requestHead.setProductId("00000016");                    // 测试外部产品号
            requestHead.setAccessType("1");
            requestHead.setMid("10020025");                        // 测试商户号
            requestHead.setPlMid("");                                // 测试平台商户号
            requestHead.setChannelType("07");
            requestHead.setReqTime(DateUtil.getCurrentDate14());

            // 组织支付BODY域
            PayRequest requestBody = new PayRequest();
            requestBody.setUserId("0000022233"); // 用户ID
            requestBody.setBid("SDSMP00000001002002520170804105848705372"); // 绑卡支付
            requestBody.setPhoneNo("13120879660"); // 手机号码
            requestBody.setSmsCode("111111"); // 支付短信验证码
            requestBody.setMerchOrderNo(DateUtil.getCurrentDate14() + "001"); // 商户上送唯一订单号
            requestBody.setMerchOrderTime(DateUtil.getCurrentDate14());
            requestBody.setOrderAmount("000000000005"); // 金额为以分为单位12位字符
            requestBody.setOrderTitle("moon测试标题");
            requestBody.setOrderDesc("moon测试描述");
            requestBody.setCurrencyCode("156"); // 币种
            requestBody.setNotifyUrl("http://192.168.22.133:8080/moon-servlet01/test02"); // 异步通知地址，需要向杉德报备
            requestBody.setFrontUrl("xxxx-FrontUrl");// 前端通知地址，支付完成之后进行页面回跳
            requestBody.setClearCycle("2"); // 0-T1, 1-T0, 2-D0 // 清算标识
            requestBody.setExtend("");
            doPost(requestHead, requestBody, PAY_API_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
