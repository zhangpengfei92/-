package com.jcl.stock.simulate;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;

public class StringUtil {

	//private static Logger logger = Logger.getLogger(StringUtil.class);
			
	/**
	 * 判断是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public static String isNull(Object obj) {
		return null == obj ? "" : obj.toString();
	}

	/**
	 * @判断字符串是否是整数
	 * @param str
	 * @return
	 */
	public static boolean isInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @精度加法运算
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2).doubleValue();

	}

	/**
	 * 判断字符串是否为null和空
	 * 
	 * @param strs
	 * @return
	 */
	public static boolean isAnyNullOrEmpty(String... strs) {
		for (String str : strs) {
			if (str == null || str.trim().length() == 0) {
				return true;
			}
		}
		return false;
	}

	// 判断运行时间时间是否超时
	public static boolean readTimeOut(Date date) {
		return (new Date().getTime() - date.getTime()) > DefineNumber.SO_TIME_OUT;
	}

	
	
	/*BKDRHash算法是字符串hash算法*/
	//public static int seed = 31;
	public static int getHashCodeInt(String str, int seed){
	    int hash = 0;
	    for(int i = 0;i!= str.length();++i) {
	        hash =  seed * hash + str.charAt(i);
	    }
	    return hash;
	}
	
	public static long getHashCode(String str, int seed) {  
		//long seed = 131; // 31 131 1313 13131 131313 etc..  
		long hash = 0;  
		for(int i = 0; i < str.length(); i++){  
			hash = (hash * seed) + str.charAt(i);  
		}
		return hash;  
	}
	
	public static long GenHash(byte[] str,long seed) {
		long hash = 0;
		for (int i=0;i<str.length;i++) {
		    hash = hash * seed + str[i];
		    hash = (int)hash;
		}
		if (hash < 0) hash += 0x100000000l;
		return hash;
	}
	
	public static long[] GenHash64(byte[] str) {
		long [] hash = new long[2];
		hash[0] = GenHash(str,31);
		hash[1] = GenHash(str,131);
		return hash;
	}
	
	/**
	 * 将32位的int值放到4字节的byte[]里
	 * 
	 * @param num
	 * @return
	 */
	public static byte[] int2byteArray(int num) {
		byte[] result = new byte[4];
		result[0] = (byte) (num >>> 24);// 取最高8位放到0下标
		result[1] = (byte) (num >>> 16);// 取次高8为放到1下标
		result[2] = (byte) (num >>> 8); // 取次低8位放到2下标
		result[3] = (byte) (num); // 取最低8位放到3下标
		return result;
	}
	
	/** 
     * @方法功能 字节数组和长整型的转换 
     * @param 字节数组 
     * @return 长整型 
     */  
    public static byte[] longToByte(long number) {  
        long temp = number;  
        byte[] b = new byte[8];  
        for (int i = 0; i < b.length; i++) {  
            b[i] = new Long(temp & 0xff).byteValue();  
            // 将最低位保存在最低位  
            temp = temp >> 8;  
            // 向右移8位  
        }  
        return b;  
    }  

	public static BigInteger getLastHashCode(String str){
		/*byte [] byte8 = ConvertData.margeByteArray(longToByte(getHashCode(str, 131)), int2byteArray(getHashCodeInt(str, 31)));
		long longValue = DataParseUtil.byteToLong(byte8);*/
		long hash[] = GenHash64(str.getBytes());
    	BigInteger a = BigInteger.valueOf(hash[0]);
    	BigInteger b = BigInteger.valueOf(hash[1]);
    	BigInteger c = BigInteger.valueOf(0x100000000l);
    	BigInteger d = a.add(b.multiply(c));
    	
	    return d;
	}
	
	public static byte[] getLastHashCodeByte(String str){
		long hash[] = GenHash64(str.getBytes());
		byte[] reqBuffer = new byte[8];
		byte[] b1 = longToByte(hash[0]);
		System.arraycopy(b1, 0, reqBuffer, 0, 4);
		byte[] b2 = longToByte(hash[1]);
		System.arraycopy(b2, 0, reqBuffer, 4, 4);
		return reqBuffer;
	}
	
	/**
	 * 对象转JSON串
	 * 
	 * @param obj
	 * @return
	 */
	public static String getJsonData(Object str){
		//return String.valueOf(JSONObject.fromObject(str));
		return String.valueOf(new JSONObject(str));
	}
	
	/*调用协议公共方法类*/
	/*public static String commonFunction(String str, int functionNum) throws BussinessException {
		try {
			if (str == null) {
				throw new BussinessException("空值异常");
			}
			// 获得请求协议体
			if(functionNum < 30000){
				byte [] RspData = HeadSession.getJsonData(functionNum,str,JSONObject.fromObject(str).getString("client_id"),null,ServerNumber.SimulateBond);
				return AccountResponseData.getJsonByByte(RspData);
			} else {
				byte [] RspData = HeadSession.getJsonData(functionNum,str,"",null,ServerNumber.DBService);
				return AccountResponseData.getJsonByByte(RspData);
			}
		} catch (Exception e) {
			logger.error("调用协议异常: Method Number->" + functionNum + e.getMessage());
			throw new BussinessException("调用协议异常: Method Number->" + functionNum + e.getMessage());
		}
	}*/
	
	/**
	 * 是否存在中文
	 * @param str
	 * @return
	 */
	public static boolean isChineseChar(String str){
       boolean temp = false;
       Pattern p = Pattern.compile("[\u4e00-\u9fa5]"); 
       Matcher m = p.matcher(str); 
       if(m.find()){ 
           temp =  true;
       }
       return temp;
    }
	
	/**
	 * 中文转encode
	 * @param str
	 * @return
	 */
	public static String chineseToEncode(String str){
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if((String.valueOf(str.charAt(i))).getBytes().length > 1) {
				try {
					//sb.append(URLEncoder.encode(String.valueOf(str.charAt(i)), "UTF-8"));
					//sb.append(URLEncoder.encode(String.valueOf(str.charAt(i)), "gb2312"));
					sb.append(new String(String.valueOf(str.charAt(i)).getBytes(), "UTF-8").trim());
				} catch (UnsupportedEncodingException e) {
					sb.append(String.valueOf(str.charAt(i)));
				}
			} else {
				sb.append(str.charAt(i));
			}
     	}
		return sb.toString();
	}

}