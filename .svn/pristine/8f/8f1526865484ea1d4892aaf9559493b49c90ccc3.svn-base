package com.sandepay.apipay;



import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.sandepay.domain.ApplyBindCardRequest;

/**
 * 申请绑卡接入示例
 */
public class FastPayApplyBindCardTest extends AbstractTest {


    protected static final Log logger = LogFactory.getLog(FastPayApplyBindCardTest.class);

    // 申请绑卡API
    private static final String FASTPAY_API_APPLY_BINDCARD = "fastPay/apiPay/applyBindCard";

    /**
     * 设置服务端地址
     */
    public FastPayApplyBindCardTest() {
        SD_REQUEST_URL = "http://192.168.22.79:8080/pay-client/";
    }


    /**
     * 申请绑卡接口调用示例
     * 说明：1、商户接入需加载公私钥到项目中
     *       2、封装调用杉德服务端接口，具体参数说明请参考接入文档
     *       3、POST请求杉德服务端
     *       4、验证杉德返回数据签名
     */
    @Test
    public void applyBindCard() {
        try {
            // 组织申请绑卡HEAD域
            ApplyBindCardRequest requestHead = new ApplyBindCardRequest();
            requestHead.setAccessType("1");
            requestHead.setChannelType("07");
            requestHead.setMethod("sandPay.fastPay.apiPay.applyBindCard");    // 需要测试的流程
            requestHead.setMid("10020025");            // 测试商户号
            requestHead.setPlMid("");                    // 测试平台商户号
            requestHead.setProductId("00000016");        // 测试外部产品号
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
            requestBody.setCreditFlag("0"); // 借贷记标识
            requestBody.setCheckNo(""); // CVN码
            requestBody.setCheckExpiry("1712"); // 有效期
            requestBody.setExtend("");
            doPost(requestHead, requestBody, FASTPAY_API_APPLY_BINDCARD);
        } catch (Exception e) {
            logger.error("申请绑卡失败,{}",e);
        }
    }
}
