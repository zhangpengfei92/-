package com.jcl.util;
/**
 * 格式化金额
 * @author zhenghuayi
 *
 */
public class FomaAmount {
	/**
	 * 订单金额：12 位订单金额 000000000001
	 * @param amount
	 * @return
	 */
	public  static String getFomaAmount(String amount) {
		if(! StringUtil.isAnyNullOrEmpty(amount)){
			int length = amount.length();
			int index=12-length;
			String zero="";
			for (int i = 0; i < index; i++) {
				zero="0"+zero;
			}
			return zero+amount;
		}
		return "";
	}
	
	public static void main(String[] args) {
		String fomaAmount = getFomaAmount("1");
		System.out.println(fomaAmount);
	}
}
