package com.sandepay.apipay;



import org.junit.Test;

import com.sandepay.domain.ConfirmUnbindCardRequest;

/**
 * 解绑
 */
public class FastPayUnBindCardTest extends AbstractTest {


    // API解绑
    private static final String FASTPAY_API_UNBINDCARD = "fastPay/apiPay/confirmUnbindCard";

    public FastPayUnBindCardTest() {
        SD_REQUEST_URL = "http://192.168.22.79:8080/pay-client/";
    }

    /**
     * 解绑卡接口调用示例
     * 说明：1、商户接入需加载公私钥到项目中
     *       2、封装调用杉德服务端接口，具体参数说明请参考接入文档
     *       3、POST请求杉德服务端
     *       4、验证杉德返回数据签名
     */
    @Test
    public void createOrderTest() {

        try {
            // 组织申请绑卡HEAD域
            ConfirmUnbindCardRequest requestHead = new ConfirmUnbindCardRequest();
            requestHead.setAccessType("1");
            requestHead.setChannelType("07");
            requestHead.setMethod("sandPay.fastPay.apiPay.unbindCard");    //需要测试的流程
            requestHead.setMid("10020025");            //测试商户号
            requestHead.setPlMid("");                    //测试平台商户号
            requestHead.setProductId("00000016");        //测试外部产品号
            requestHead.setReqTime("20170721000000");
            requestHead.setVersion("1.0");

            // 组织申请绑卡BODY域
            ConfirmUnbindCardRequest requestBody = new ConfirmUnbindCardRequest();
            requestBody.setUserId("00000" + String.valueOf(Math.round(Math.random() * 89999999 + 10000000))); // 用户ID
            requestBody.setApplyNo("000000" + String.valueOf(Math.round(Math.random() * 899999 + 100000))); //
            requestBody.setBid("SDSMP00000001002002520170804103644603610");
            requestBody.setNotifyUrl("www.baidu.com");
            requestBody.setFrontUrl("www.baidu.com");
            requestBody.setExtend("");
            doPost(requestHead, requestBody, FASTPAY_API_UNBINDCARD);
        } catch (Exception e) {
            logger.error("解绑卡失败,{}",e);
        }
    }
}
