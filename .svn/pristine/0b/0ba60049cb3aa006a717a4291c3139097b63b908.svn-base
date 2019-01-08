package com.sandepay.apipay;



import cn.com.sandpay.cashier.sdk.util.CertUtil;
import cn.com.sandpay.cashier.sdk.util.CryptoUtil;
import cn.com.sandpay.cashier.sdk.util.SDKUtil;
import com.alibaba.fastjson.JSONObject;
import com.sandepay.common.HttpRequestUtil;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;

import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;

/**
 * 抽象发送报文类
 */
public class AbstractTest {

    protected static final Log logger = LogFactory.getLog(AbstractTest.class);

    // 产品地址
    protected static String SD_REQUEST_URL;


    /**
     * 初始化公私钥
     * 说明：轻配置对应公私钥地址防止公私钥加载不到
     */
    @Before
    public void init() {
        // 初始化公私钥
        try {
            logger.info("初始化公私钥");
            CertUtil.init("classpath:sand-test.cer", "classpath:mid-test.pfx", "123456");
        } catch (Exception e) {
            logger.error("初始化公私钥失败{}", e);
        }
    }

    /**
     * 发送请求到杉德服务端
     *
     * @param requestHead：head域对象
     * @param requestBody:body域对象
     * @param apiName：对应api地址
     * @throws Exception
     */
    protected void doPost(Object requestHead, Object requestBody, String apiName) throws Exception {
        String request = getRequestMessage(requestHead, requestBody);
        // 模拟请求
        logger.info("请求报文------>request：" + request);
        String response = HttpRequestUtil.sendPost(SD_REQUEST_URL + apiName, request);
        // 将响应报文解码
        String result = URLDecoder.decode(response, "UTF-8");
        // 响应结果打印
        logger.info("响应报文------------>response:" + result);
        // 验证签名(需要先URL解码才能转换成为MAP)
        Map respMap = SDKUtil.convertResultStringToMap(result);
        String respData = (String) respMap.get("data");
        String respSign = (String) respMap.get("sign");
        try {
            boolean valid = CryptoUtil.verifyDigitalSign(respData.getBytes("UTF-8"), Base64.decodeBase64(respSign), CertUtil.getPublicKey(), "SHA1WithRSA");
            if (!valid) {
                logger.error("响应验证杉德签名------------>失败！");
                throw new RuntimeException("verify sign fail.");
            } else {
                logger.error("响应验证杉德签名------------>成功！");
            }
        } catch (Exception e) {
            logger.error("响应验证杉德签名------------>失败！", e);
        }
    }


    /**
     * 组装杉德服务端所需报文
     *
     * @param o1：head对象
     * @param o2:body对象
     * @return
     */
    protected String getRequestMessage(Object o1, Object o2) {
        // 组织DATA域
        JSONObject data = new JSONObject();
        try {
            // head
            JSONObject head = new JSONObject();
            Method[] ms1 = o1.getClass().getMethods();
            for (int i = 0; i < ms1.length; i++) {
                if (ms1[i].getName().startsWith("get") && !ms1[i].getName().startsWith("getClass")) {
                    String paramName = ms1[i].getName().substring(3);
                    head.put(paramName.substring(0, 1).toLowerCase() + paramName.substring(1), ms1[i].invoke(o1, new Object[]{}));
                }
            }
            data.put("head", head);

            // body
            JSONObject body = new JSONObject();
            Method[] ms2 = o2.getClass().getMethods();
            for (int i = 0; i < ms2.length; i++) {
                if (ms2[i].getName().startsWith("get") && !ms2[i].getName().startsWith("getClass")) {
                    String paramName = ms2[i].getName().substring(3);
                    body.put(paramName.substring(0, 1).toLowerCase() + paramName.substring(1), ms2[i].invoke(o2, new Object[]{}));
                }
            }
            data.put("body", body);
            String dataParam = "data=" + data.toJSONString() + "&";

            // 组织其他域
            String charsetParam = "charset=UTF-8&";
            String signTypeParam = "signType=01&";
            String signParam = "sign=" +
                    URLEncoder.encode(
                            new String(Base64.encodeBase64(
                                    CryptoUtil.digitalSign(data.toJSONString().getBytes("UTF-8"), CertUtil.getPrivateKey(), "SHA1WithRSA")))
                    ) + "&";

            String extendParam = "extend=";

            StringBuffer resultMsg = new StringBuffer();
            resultMsg.append(charsetParam);
            resultMsg.append(dataParam);
            resultMsg.append(signTypeParam);
            resultMsg.append(signParam);
            resultMsg.append(extendParam);
            return resultMsg.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
