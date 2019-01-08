package com.jcl.util.spt;


import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Administrator on 2017/4/26.
 */
public class SignMd5Utils {	

    /**
     * 生成签名
     * @param packageParams
     * @param signKey
     * @return
     */
    public static String createSign(Map<String, String> packageParams, String signKey) {
        TreeMap sortedMap = new TreeMap(packageParams);
        StringBuilder toSign = new StringBuilder();
        Iterator i$ = sortedMap.keySet().iterator();
        while (i$.hasNext()) {
            String key = (String) i$.next();
            String value = (String) packageParams.get(key);
            if (value != "" && !"sign".equals(key) && !"key".equals(key)) {
                toSign.append(key + "=" + value + "&");
            }
        }

        toSign.append("key=" + signKey);
        return MD5Utils.encode(toSign.toString()).toUpperCase();
    }
    
    public static String createSign1(Map<String, String> packageParams) {
        TreeMap sortedMap = new TreeMap(packageParams);
        StringBuilder toSign = new StringBuilder();
        Iterator i$ = sortedMap.keySet().iterator();
        while (i$.hasNext()) {
            String key = (String) i$.next();
            String value = (String) packageParams.get(key);
            if (value != "" && !"sign".equals(key) && !"key".equals(key)) {
                toSign.append(value);
            }
        }

        System.out.println(toSign);
        return MD5Utils.encode(toSign.toString()).toLowerCase();
    }

}
