package com.jcl.stock.simulate.data;

import java.io.UnsupportedEncodingException;

import com.jcl.stock.simulate.BussinessException;

public class AccountResponseData {
	
	/*数组转JSON串*/
	public static String getJsonByByte(byte[] lpBuf) throws BussinessException {
		String str = "";
		try {
			//str = new String(lpBuf, "GBK").trim();
			str = new String(lpBuf, "UTF-8").trim();
		} catch (UnsupportedEncodingException e) {
		    throw new BussinessException("应答，byte数组转JSON异常:" + e.getMessage());
		}
		return str;
	}
	
	/*数组转JSON串*/
	public static String getJsonByByteLength(byte[] FullDataBuffer, int offset, int length) throws BussinessException {
		
		String str = "";
		try {
			//str = new String(lpBuf, "GBK").trim();
			//str = new String(lpBuf, "UTF-8").trim();
			str = new String(FullDataBuffer, offset, length, "UTF-8").trim();
		} catch (UnsupportedEncodingException e) {
		    throw new BussinessException("应答，byte数组转JSON异常:" + e.getMessage());
		}
		return str;
	}
	
}
