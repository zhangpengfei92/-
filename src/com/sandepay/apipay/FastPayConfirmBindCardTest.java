package com.sandepay.apipay;



import org.junit.Test;

import com.sandepay.domain.ConfirmBindCardRequest;

/**
 * 确认绑卡接入示例
 */
public class FastPayConfirmBindCardTest extends AbstractTest {


    // API确认绑卡
    private static final String FASTPAY_API_CONFIRM_BINDCARD = "fastPay/stdPay/confirmBindCard";

    public FastPayConfirmBindCardTest() {
        SD_REQUEST_URL = "http://192.168.22.79:8080/pay-client/";
    }

    /**
     * 确认绑卡接口调用示例
     * 说明：1、商户接入需加载公私钥到项目中
     *       2、封装调用杉德服务端接口，具体参数说明请参考接入文档
     *       3、POST请求杉德服务端
     *       4、验证杉德返回数据签名
     */
    @Test
    public void confirmBindCardTest() {
        try {
            // 组织申请绑卡HEAD域
            ConfirmBindCardRequest requestHead = new ConfirmBindCardRequest();
            requestHead.setAccessType("1"); //接入类型 1：普通商户，2：平台商户
            requestHead.setChannelType("07"); // 通道类型 默认07：杉德
            requestHead.setMethod("sandPay.fastPay.apiPay.confirmBindCard");    //需要测试的流程
            requestHead.setMid("10020025");            //商户号
            requestHead.setPlMid("");                    //平台商户号，接入类型为2时必送
            requestHead.setProductId("00000016");        // 外部产品号
            requestHead.setReqTime("20170721000000"); // 上送报文时间
            requestHead.setVersion("1.0"); // 接口版本

            // 组织申请绑卡BODY域
            ConfirmBindCardRequest requestBody = new ConfirmBindCardRequest();
            requestBody.setFrontUrl("www.baidu.com");
            requestBody.setExtend("");
            requestBody.setNotifyUrl("www.baidu.com");
            requestBody.setSmsCode("111111"); // 短信验证码
            requestBody.setPhoneNo("13120879660"); // 手机号
            requestBody.setSdMsgNo("2017080405800000000000000211"); // 杉德流水号
            requestBody.setUserId("0000022233"); // 用户ID
            doPost(requestHead, requestBody, FASTPAY_API_CONFIRM_BINDCARD);
        } catch (Exception e) {
            logger.error("确认绑卡失败,{}",e);
        }
    }
}
