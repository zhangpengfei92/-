 package com.jcl.stock.simulate;

import java.io.UnsupportedEncodingException;



  
    /**        
     * Title: DataParseUtil.java    
     * Description: 数据转换
     * @author zhuj       
     * @created 2015-5-14 上午9:12:05    
     */      
    
public class DataParseUtil {

	public static final int intToHByte(int value, int offset, int length,
			byte buffer[]) {
		int i = 0;
		for (int j = length - 1; i < length; j--) {
			if (j + offset >= 0) {
				buffer[i + offset] = (byte) (value >> i * 8 & 0xff);
			}
			i++;
		}

		return offset + length;
	}

	
	public static final int byteToNInt(byte buffer[], int offset, int length) {
		int IByte = 0;
		try {
			for (int i = length - 1; i >= 0; i--) {
				IByte = (IByte << 8)
						+ (int) (buffer[offset + i] < 0 ? buffer[offset + i] + 256
								: buffer[offset + i]);
			}
		} catch (Exception ex) {
		}
		return IByte;
	}

	
	
	public static byte[] shortToByte(short number) {
		short temp = number;
		byte[] b = new byte[16];
		for (int i = 0; i < b.length; i++) {
			b[i] = new Short((short) (temp & 1)).byteValue();
			temp = (short) (temp >> 1);
		}
		return b;
	}
	
	public static final short byteToNShort(byte buffer[], int offset, int length) {
		short value = 0;
		value = (short) byteToNInt(buffer, offset, length);
		return value;
	}
	
	public static final byte floatToByte(float f) {
		if (f < 0.0f) { // round negatives up to zero
			f = 0.0f;
		}
		if (f == 0.0f) { // zero is a special case
			return 0;
		}
		int bits = Float.floatToIntBits(f); // parse float into parts
		int mantissa = (bits & 0xffffff) >> 21;
		int exponent = (((bits >> 24) & 0x7f) - 63) + 15;
		if (exponent > 31) { // overflow: use max value
			exponent = 31;
			mantissa = 7;
		}
		if (exponent < 1) { // underflow: use min value
			exponent = 1;
			mantissa = 0;
		}
		return (byte) ((exponent << 3) | mantissa); // pack into a byte
	}
	public static float byteToFloat(byte b) {
		if (b == 0) { // zero is a special case
			return 0.0f;
		}
		int mantissa = b & 7;
		int exponent = (b >> 3) & 31;
		int bits = ((exponent + (63 - 15)) << 24) | (mantissa << 21);
		return Float.intBitsToFloat(bits);
	}

	

	public static final float byteToNFloat(byte buffer[], int offset, int length) {

		float value = 0;
		int bits = 0;
		try {
			for (int i = 3; i >= 0; i--) {
				bits = (bits << 8)
						+ (int) (buffer[offset + i] < 0 ? buffer[offset + i] + 256
								: buffer[offset + i]);
			}
			value = Float.intBitsToFloat(bits);
		} catch (Exception e) {
			return 0;
		}

		return value;
	}

	
    
	
	public static byte[] float2byte(float f) {
		// 把float转换为byte[]
		int fbit = Float.floatToIntBits(f);
		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			b[i] = (byte) (fbit >> (24 - i * 8));
		}
		// 翻转数组
		int len = b.length;
		// 建立一个与源数组元素类型相同的数组
		byte[] dest = new byte[len];
		// 为了防止修改源数组，将源数组拷贝一份副本
		System.arraycopy(b, 0, dest, 0, len);
		byte temp;
		// 将顺位第i个与倒数第i个交换
		for (int i = 0; i < len / 2; ++i) {
			temp = dest[i];
			dest[i] = dest[len - i - 1];
			dest[len - i - 1] = temp;
		}
		return dest;
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
  
    /** 
     * @方法功能 字节数组和长整型的转换 
     * @param 字节数组 
     * @return 长整型 
     */  
    public static long byteToLong(byte[] b) {  
        long s = 0;  
        long s0 = b[0] & 0xff;// 最低位  
        long s1 = b[1] & 0xff;  
        long s2 = b[2] & 0xff;  
        long s3 = b[3] & 0xff;  
        long s4 = b[4] & 0xff;// 最低位  
        long s5 = b[5] & 0xff;  
        long s6 = b[6] & 0xff;  
        long s7 = b[7] & 0xff; // s0不变  
        s1 <<= 8;  
        s2 <<= 16;  
        s3 <<= 24;  
        s4 <<= 8 * 4;  
        s5 <<= 8 * 5;  
        s6 <<= 8 * 6;  
        s7 <<= 8 * 7;  
        s = s0 | s1 | s2 | s3 | s4 | s5 | s6 | s7;  
        return s;  
    }  
    
    
    
    
    
    
    
    /** 
     * double转换byte 
     *  
     * @param bb 
     * @param x 
     * @param index 
     */  
    public static byte[] doubleToByte(double data)  
    {  
        long intBits = Double.doubleToLongBits(data);  
        return getBytes(intBits);  
    }  
    
    public static byte[] getBytes(long data)  
    {  
        byte[] bytes = new byte[8];  
        bytes[0] = (byte) (data & 0xff);  
        bytes[1] = (byte) ((data >> 8) & 0xff);  
        bytes[2] = (byte) ((data >> 16) & 0xff);  
        bytes[3] = (byte) ((data >> 24) & 0xff);  
        bytes[4] = (byte) ((data >> 32) & 0xff);  
        bytes[5] = (byte) ((data >> 40) & 0xff);  
        bytes[6] = (byte) ((data >> 48) & 0xff);  
        bytes[7] = (byte) ((data >> 56) & 0xff);  
        return bytes;  
    }  
  
    /** 
     * 通过byte数组取得float 
     *  
     * @param bb 
     * @param index 
     * @return 
     */  
    public static double byteToDouble(byte[] b) {  
        long l;  
        l = b[0];  
        l &= 0xff;  
        l |= ((long) b[1] << 8);  
        l &= 0xffff;  
        l |= ((long) b[2] << 16);  
        l &= 0xffffff;  
        l |= ((long) b[3] << 24);  
        l &= 0xffffffffl;  
        l |= ((long) b[4] << 32);  
        l &= 0xffffffffffl;  
        l |= ((long) b[5] << 40);  
        l &= 0xffffffffffffl;  
        l |= ((long) b[6] << 48);  
        l &= 0xffffffffffffffl;  
        l |= ((long) b[7] << 56);  
        return Double.longBitsToDouble(l);  
    }  
    
    public static double byteToNDouble(byte buffer[], int offset, int length){
    	byte[] tmpbuf = new byte[length];
		System.arraycopy(buffer, offset, tmpbuf, 0, length);
		return byteToDouble(tmpbuf);
    }
    
    
    public static long byteToNLong(byte buffer[], int offset, int length){
    	byte[] tmpbuf = new byte[length];
		System.arraycopy(buffer, offset, tmpbuf, 0, length);
		return byteToLong(tmpbuf);
    }
    
    public static String byteToNString(byte buffer[], int offset, int length){
		String result = null;
    	try {
			byte[] tmpbuf = new byte[length];
			System.arraycopy(buffer, offset, tmpbuf, 0, length);
			result=new String(tmpbuf, "GBK").trim();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return result;
    }
}
