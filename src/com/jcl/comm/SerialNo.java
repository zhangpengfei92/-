package com.jcl.comm;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class SerialNo {

	public SerialNo() {
	}

	public static synchronized String getUNID() {
		String currentTime = getCurrentDateString("yyMMddHHmmssSSS");
		if (compareTime == null || compareTime.compareTo(currentTime) != 0) {
			compareTime = currentTime;
			sequence = 1L;
		} else {
			sequence++;
		}
		return (new StringBuilder(String.valueOf(currentTime))).append(
				numberFormat.format(sequence)).toString();
	}

	public static synchronized String getDateID() {
		String currentTime = getCurrentDateString("yyyyMMdd");
		if (compareTime == null || compareTime.compareTo(currentTime) != 0) {
			compareTime = currentTime;
			sequence = 1L;
		} else {
			sequence++;
		}
		return (new StringBuilder(String.valueOf(currentTime))).append(
				numberFormat.format(sequence)).toString();
	}

	/**
	 * 字符串长度为30
	 * 
	 * @return
	 */
	public static synchronized String getLongUNID() {
		String currentTime = getCurrentDateString("yyyyMMddHHmmssSSS");
		if (longTime == null || longTime.compareTo(currentTime) != 0) {
			longTime = currentTime;
			longSequence = 1L;
		} else {
			longSequence++;
		}
		return (new StringBuilder(String.valueOf(currentTime))).append(
				longFormat.format(longSequence)).toString();
	}

	public static String getSerialforDB() {
		return getCurrentDateString("yyMMddHHmmssSSS");
	}

	public static String getShortSerial() {
		return getCurrentDateString("mmssSSS");
	}

	public static synchronized String getSmallUNID() {
		String currentTime = getCurrentDateString("yyMMddHHmmss");
		if (smallTime == null || smallTime.compareTo(currentTime) != 0) {
			smallTime = currentTime;
			smallSequence = 1L;
		} else {
			smallSequence++;
		}
		return (new StringBuilder(String.valueOf(currentTime))).append(
				smallFormat.format(smallSequence)).toString();
	}

	private static long sequence;
	private static String compareTime;
	private static NumberFormat numberFormat;
	private static long smallSequence;
	private static String smallTime;
	private static NumberFormat smallFormat;

	private static long longSequence;
	private static String longTime;
	private static NumberFormat longFormat;

	static {
		numberFormat = NumberFormat.getInstance();
		numberFormat.setGroupingUsed(false);
		numberFormat.setMinimumIntegerDigits(5);
		numberFormat.setMaximumIntegerDigits(5);
		smallFormat = NumberFormat.getInstance();
		smallFormat.setGroupingUsed(false);
		smallFormat.setMinimumIntegerDigits(4);
		smallFormat.setMaximumIntegerDigits(4);
		longFormat = NumberFormat.getInstance();
		// 是否允许分组 1123456=》1,123,456
		longFormat.setGroupingUsed(false);
		// 允许小整数位数
		longFormat.setMinimumIntegerDigits(13);
		// 允许大整数位数
		longFormat.setMaximumIntegerDigits(13);
	}

	private static String getCurrentDateString(String formatString) {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatString,
				Locale.PRC);
		return dateFormat.format(currentDate);
	}

	public static synchronized String unRepeatSixCode() {
	    String sixChar = "";
	    SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
	    Date date = new Date();
	    String time = sdf.format(date);
	    for (int i = 0; i < time.length() / 2; i++) {
	        String singleChar;
	        String x = time.substring(i * 2, (i + 1) * 2);
	        int b = Integer.parseInt(x);
	        if (b < 10) {
	            singleChar = Integer.toHexString(Integer.parseInt(x));
	        }
	        else if (b >= 10 && b < 36) {
	            singleChar = String.valueOf((char) (Integer.parseInt(x) + 55));
	        }
	        else {
	            singleChar = String.valueOf((char) (Integer.parseInt(x) + 61));
	        }
	        sixChar = sixChar + singleChar;
	    }
	    System.out.println("生成一个6位不可重复的字符编码是：" + sixChar);
	    return sixChar;
	}
	
	public static void main(String[] args) {
//		String pk = SerialNo.getLongUNID();
//		System.out.println(pk);
//		System.out.println(pk.length());
//		String unid = SerialNo.getUNID();
//		System.out.println(unid);
//		System.out.println(unid.length());
	    String unRepeatSixCode = unRepeatSixCode();
	    for (int i = 0; i < 100; i++) {
	        System.out.println(unRepeatSixCode);
        }
	}
	
    
}
