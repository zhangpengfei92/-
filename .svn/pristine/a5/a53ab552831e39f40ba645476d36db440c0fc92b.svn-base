package com.sandepay.apipay;



import org.junit.Test;

import com.sandepay.domain.ApplyBindCardRequest;

/**
 * 快速绑卡接入示例
 */
public class FastPayBindCardTest extends AbstractTest {


    // API方式
    private static final String FASTPAY_API_BINDCARD = "fastPay/apiPay/bindCard";

    public FastPayBindCardTest() {
        SD_REQUEST_URL = "http://192.168.22.204:8080/pay-client/";
    }

    /**
     * 快速绑卡接口调用示例
     * 说明：1、商户接入需加载公私钥到项目中
     *       2、封装调用杉德服务端接口，具体参数说明请参考接入文档
     *       3、POST请求杉德服务端
     *       4、验证杉德返回数据签名
     */
    @Test
    public void createOrderTest() {

        try {
            // 组织申请绑卡HEAD域
            ApplyBindCardRequest requestHead = new ApplyBindCardRequest();
            requestHead.setAccessType("1");
            requestHead.setChannelType("07");
            requestHead.setMethod("sandPay.fastPay.apiPay.bindCard");    //需要测试的流程
            requestHead.setMid("10657066");            //测试商户号
            requestHead.setPlMid("");                    //测试平台商户号
            requestHead.setProductId("00000016");        //测试外部产品号
            requestHead.setReqTime("20170721000000");
            requestHead.setVersion("1.0");

            // 组织申请绑卡BODY域
            ApplyBindCardRequest requestBody = new ApplyBindCardRequest();
            requestBody.setUserId("0000022233"); // 用户ID
            requestBody.setCardNo("6228480402564"); // 卡号
            requestBody.setUserName("吴高俊"); // 户名
            requestBody.setApplyNo("111111" + String.valueOf(Math.round(Math.random() * 899999 + 100000))); //
            requestBody.setPhoneNo("13120879660"); // 手机号
            requestBody.setCertificateNo("411722197508214014"); // 身份证号码
            requestBody.setCertificateType("01"); // 证件类型，默认01（身份证）
            requestBody.setCreditFlag("0"); // 借贷记标识 0 借记，1 贷记
            requestBody.setCheckNo(""); // CVN码
            requestBody.setCheckExpiry("1712"); // 有效期
            requestBody.setExtend("");
            doPost(requestHead, requestBody, FASTPAY_API_BINDCARD);
        } catch (Exception e) {
            logger.error("快速绑卡失败,{}",e);
        }
    }
}
