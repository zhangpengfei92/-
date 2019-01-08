package com.synPay;


import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;

import sun.misc.BASE64Encoder;

import com.alibaba.fastjson.JSON;
import com.client.config.BryConfig;
import com.client.net.SendHttpRequestUtils;
import com.client.utils.SignUtils;
import com.payment.common.utils.DateUtil;
import com.payment.msg.merchantsettle.MerchantSettleRequest;
import com.payment.msg.merchantsettle.MerchantSettleResponse;
/**
 * 出金
 * @author zhenghuayi
 *
 */
public class MerchantSettleRequestTest
{
    public static void main( String[] args ) throws Exception
    {

        // for (int i = 0; i < 10; i++) {
        MerchantSettleRequest signMerchantSettleRequest = new MerchantSettleRequest();
        signMerchantSettleRequest.setAccountName( "郭鹤超");
        signMerchantSettleRequest.setAccountNumber( "6225887856824251");
        signMerchantSettleRequest.setAccountType( "11" );
        signMerchantSettleRequest.setTranAmt( 200L );
        signMerchantSettleRequest.setMerchantNo( BryConfig.merchantNo );
        signMerchantSettleRequest.setCertType( "0" );
        signMerchantSettleRequest.setCertNumber("421125199009125218");
        signMerchantSettleRequest.setExtraParams( RandomStringUtils.randomNumeric( 18 ) );
        signMerchantSettleRequest.setTxSN( RandomStringUtils.randomNumeric( 18 ) );
        signMerchantSettleRequest.setCertType("0");
        signMerchantSettleRequest.setTransDate( DateUtil.getStandardDate( "yyyy-MM-dd HH:mm:ss", new Date() ) );
        signMerchantSettleRequest.setVersion( "1.0" );
        signMerchantSettleRequest.setLsh( RandomStringUtils.randomNumeric( 17 ) );
        signMerchantSettleRequest.setCardMediaType( "10" );
        signMerchantSettleRequest.setTxCode( "10004" );
        signMerchantSettleRequest.setProvince( "湖北" );
        signMerchantSettleRequest.setCity( "武汉" );
        signMerchantSettleRequest.setBranchName( "无" );
        String sign = SignUtils.createSignData( signMerchantSettleRequest, BryConfig.MER_PRK );
        Map<String, String> reqMap = new HashMap<String, String>();
        reqMap.put( "txCode", signMerchantSettleRequest.getTxCode() );
        reqMap.put( "signature", sign );
        reqMap.put( "version", signMerchantSettleRequest.getVersion() );
        reqMap.put( "message", new BASE64Encoder().encode( JSON.toJSONString( signMerchantSettleRequest ).getBytes( "UTF-8" ) ) );
        reqMap.put( "merchantId", BryConfig.merchantNo );
        StringBuffer postData = new StringBuffer();
        for ( Map.Entry<String, String> entry : reqMap.entrySet() )
        {
            postData.append( entry.getKey() ).append( "=" ).append( URLEncoder.encode( entry.getValue(), "UTF-8" ) ).append( "&" );
        }
        postData.delete( postData.length() - 1, postData.length() );
        String returnMsg = SendHttpRequestUtils.doPost( BryConfig.HTTPS_SYN_URL, "application/x-www-form-urlencoded;charset=utf-8", postData.toString().getBytes( "UTF-8" ), 60 * 1000, 60 * 1000 );
        System.out.println( "getBackInfo>>>>>>>>>>>>>>>>>>>>:" + returnMsg );
        MerchantSettleResponse oneTransResponse = JSON.parseObject( returnMsg, MerchantSettleResponse.class );
        String signData = oneTransResponse.getRspLsh() + BryConfig.MER_PUB_KEY;
        boolean verySign = SignUtils.verySign( signData, BryConfig.PL_PBK, oneTransResponse.getSignature() );
        System.out.println( verySign );
        // }
    }
}
