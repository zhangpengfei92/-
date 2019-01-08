package com.synPay;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;

import sun.misc.BASE64Encoder;

import com.alibaba.fastjson.JSON;
import com.client.config.BryConfig;
import com.client.net.SendHttpRequestUtils;
import com.client.utils.SignUtils;
import com.payment.msg.queryone.QueryOneTransRequest;
import com.payment.msg.queryone.QueryOneTransResponse;

public class QueryOneRequestTest
{
    public static void main( String[] args ) throws Exception
    {
        QueryOneTransRequest queryOneTransRequest = new QueryOneTransRequest();

        queryOneTransRequest.setTxSN( "809043339663575615" );
        queryOneTransRequest.setVersion( "1.0" );
        queryOneTransRequest.setMerchantNo( BryConfig.merchantNo );
        queryOneTransRequest.setLsh( RandomStringUtils.randomNumeric( 17 ) );
        queryOneTransRequest.setTxCode( "10002" );
        String sign = SignUtils.createSignData( queryOneTransRequest, BryConfig.MER_PRK );

        Map<String, String> reqMap = new HashMap<String, String>();
        reqMap.put( "txCode", queryOneTransRequest.getTxCode() );
        reqMap.put( "signature", sign );
        reqMap.put( "version", queryOneTransRequest.getVersion() );
        reqMap.put( "message", new BASE64Encoder().encode( JSON.toJSONString( queryOneTransRequest ).getBytes( "UTF-8" ) ) );
        reqMap.put( "merchantId", BryConfig.merchantNo );
        StringBuffer postData = new StringBuffer();
        for ( Map.Entry<String, String> entry : reqMap.entrySet() )
        {
            postData.append( entry.getKey() ).append( "=" ).append( URLEncoder.encode( entry.getValue(), "UTF-8" ) ).append( "&" );
        }
        postData.delete( postData.length() - 1, postData.length() );
        String returnMsg = SendHttpRequestUtils.doPost( BryConfig.HTTPS_SYN_URL, "application/x-www-form-urlencoded;charset=utf-8", postData.toString().getBytes( "UTF-8" ), 60 * 1000, 60 * 1000 );
        QueryOneTransResponse oneTransResponse = JSON.parseObject( returnMsg, QueryOneTransResponse.class );
        String signData = oneTransResponse.getRspLsh() + BryConfig.MER_PUB_KEY;
        boolean verySign = SignUtils.verySign( signData, BryConfig.PL_PBK, oneTransResponse.getSignature() );
        System.out.println( verySign );
    }
}
