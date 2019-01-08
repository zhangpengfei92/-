package com.sandepay.apipay;


import cn.com.sandpay.cashier.sdk.util.DateUtil;
import org.junit.Test;

import com.sandepay.domain.SmsRequest;

/**
 * 短信发送接口示例
 *
 * @author moon
 */
public class FastPaySmsSendTest extends AbstractTest {

    /*
     * 下单支付
     */
    private static final String PAY_API_NAME = "fastPay/apiPay/sms";


    /**
     * 设置服务端地址
     */
    public FastPaySmsSendTest() {
        SD_REQUEST_URL = "http://192.168.22.79:8080/pay-client/";
    }

    /**
     * API短信发送接口调用示例
     * 说明：1、商户接入需加载公私钥到项目中
     * 2、封装调用杉德服务端接口，具体参数说明请参考接入文档
     * 3、POST请求杉德服务端
     * 4、验证杉德返回数据签名
     */
    @Test
    public void payTest() {
        try {

            // 组织短信发送HEAD域
            SmsRequest requestHead = new SmsRequest();
            requestHead.setVersion("1.0");
            requestHead.setMethod("sandPay.fastPay.common.sms");    // 需要测试的流程
            requestHead.setProductId("00000016");                    // 测试外部产品号
            requestHead.setAccessType("1");
            requestHead.setMid("10020025");                        // 测试商户号
            requestHead.setPlMid("");                                // 测试平台商户号
            requestHead.setChannelType("07");
            requestHead.setReqTime(DateUtil.getCurrentDate14());

            // 组织短信发送BODY域
            SmsRequest requestBody = new SmsRequest();
            requestBody.setBid("SDSMP00000001002002520170804105848705372"); // 绑卡BID
            requestBody.setMerchOrderNo(DateUtil.getCurrentDate14() + "001"); // 订单号
            requestBody.setPhoneNo("13120879660"); // 手机号
            requestBody.setUserId("0000022233"); // 用户号
            requestBody.setExtend("");
            doPost(requestHead, requestBody, PAY_API_NAME);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
