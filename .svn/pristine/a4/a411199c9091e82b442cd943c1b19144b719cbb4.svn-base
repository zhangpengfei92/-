package com.jcl.util;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.UUID;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class Util {
	public static final int LONG_BYTES = Long.SIZE >> 3;
	public static final int INT_BYTES = Integer.SIZE >> 3;
	public static final int SHORT_BYTES = Short.SIZE >> 3;
	public static final int FLOAT_BYTES = Float.SIZE >> 3;
	public static final int DOUBLE_BYTES = Double.SIZE >> 3;
	public static final int UUID_BYTES = LONG_BYTES << 1;
	public static final Charset UTF8_CHARSET = Charset.forName("utf-8");
	public static final Charset GBK_CHARSET = Charset.forName("gbk");

	private static CRC32 crc = new CRC32();
	
	static public long Hash(byte[] data,int offset,int len,int seed) {
		long hash = 0;
		for (int i=0;i<len;i++) {
		    hash = hash * seed + data[offset+i];
		    hash = (int)hash;
		}
		if (hash < 0) hash += 0x100000000l;
		return hash;
	}
	
	static public long Hash64(byte[] data,int offset,int len) {
		long hash = Hash(data, offset, len, 131);
		hash <<= 32;
		hash |= Hash(data, offset, len, 31);
		return hash;
	}
	
	static public byte[] compress(byte[] data,int offset,int len) {
		Deflater zip = new Deflater();
		zip.reset();
		zip.setInput(data,offset,len);
		zip.finish();
		
		ByteArrayOutputStream bout = new ByteArrayOutputStream(data.length);
		byte[] b = new byte[1024];
		while (!zip.finished()) {
			len = zip.deflate(b);
			bout.write(b, 0, len);
		}
		return bout.toByteArray();
	}
	
	static public byte[] decompress(byte[] data,int offset,int len) {
		Inflater zip = new Inflater();
		zip.reset();
		zip.setInput(data, offset, len);
		
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		byte[] b = new byte[1024];
		while (!zip.finished()) {
			try {
				len = zip.inflate(b);
			} catch (DataFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			bout.write(b, 0, len);
		}
		return bout.toByteArray();
	}
	
	static public int getCRC32(String s) {
		byte[] b = s.getBytes();
		return getCRC32(b,0,b.length);
	}
	
	static synchronized public int getCRC32(byte[] buf,int offset,int len) {
		crc.reset();
		crc.update(buf,offset,len);
		return (int) crc.getValue();
	}
	
	static public void clear(byte[] arr,int offset,int len) {
		for (int i = 0; i < len; i++) {
			arr[offset+i] = 0;
		}
	}

	static public void toByteArray(short data,byte[] arr,int offset,boolean little) {
		if (little) {
			for (int i = 0; i < SHORT_BYTES; i++) {
				arr[offset+i] = (byte)(data&0xff);
				data >>= 8;
			}
		} else {
			for (int i = SHORT_BYTES-1; i >= 0; i--) {
				arr[offset+i] = (byte)(data&0xff);
				data >>= 8;
			}
		}
	}
	
	static public void toByteArray(int data,byte[] arr,int offset,boolean little) {
		if (little) {
			for (int i = 0; i < INT_BYTES; i++) {
				arr[offset+i] = (byte)(data&0xff);
				data >>= 8;
			}
		} else {
			for (int i = INT_BYTES-1; i >= 0; i--) {
				arr[offset+i] = (byte)(data&0xff);
				data >>= 8;
			}
		}
	}
	
	static public void toByteArray(long data,byte[] arr,int offset,boolean little) {
		if (little) {
			for (int i = 0; i < LONG_BYTES; i++) {
				arr[offset+i] = (byte)(data&0xff);
				data >>= 8;
			}
		} else {
			for (int i = LONG_BYTES-1; i >= 0; i--) {
				arr[offset+i] = (byte)(data&0xff);
				data >>= 8;
			}
		}
	}

	static public void toByteArray(float data,byte[] arr,int offset) {
		toByteArray(Float.floatToRawIntBits(data), arr, offset, true);
	}
	
	static public void toByteArray(double data,byte[] arr,int offset) {
		toByteArray(Double.doubleToRawLongBits(data), arr, offset, true);
	}
	
	static public void toByteArray(UUID uuid,byte[] arr,int offset) {
		toByteArray(uuid.getMostSignificantBits(), arr, offset, true);
		toByteArray(uuid.getLeastSignificantBits(), arr, offset+LONG_BYTES, true);
	}

	static public int toByteArray(String s,byte[] arr,int offset,int len,boolean gbk) {
		byte[] b = s.getBytes(gbk?GBK_CHARSET:UTF8_CHARSET);
		if (b.length < len) {
			System.arraycopy(b, 0, arr, offset, b.length);
			for (int i = b.length; i < len; i++)
				arr[offset + i] = 0;
		} else {
			System.arraycopy(b, 0, arr, offset, len - 1);
			arr[offset + len] = 0;
		}
		return b.length + 1;
	}
	
	static public short toShort(byte[] arr,int offset,boolean little) {
		short data = 0;
		if (little) {
			for (int i = SHORT_BYTES-1; i >= 0; i--) {
				int t = arr[offset+i] & 0xff;
				data = (short) ((data << 8) | t);
			}
		} else {
			for (int i = 0; i < SHORT_BYTES; i++) {
				int t = arr[offset+i] & 0xff;
				data = (short) ((data << 8) | t);
			}
		}
		return data;
	}

	static public int toInt(byte[] arr,int offset,boolean little) {
		int data = 0;
		if (little) {
			for (int i = INT_BYTES-1; i >= 0; i--) {
				int t = arr[offset+i] & 0xff;
				data = (data << 8) | t;
			}
		} else {
			for (int i = 0; i < INT_BYTES; i++) {
				int t = arr[offset+i] & 0xff;
				data = (data << 8) | t;
			}
		}
		return data;
	}

	static public long toLong(byte[] arr,int offset,boolean little) {
		long data = 0;
		if (little) {
			for (int i = LONG_BYTES-1; i >= 0; i--) {
				long t = arr[offset+i] & 0xff;
				data = (data << 8) | t;
			}
		} else {
			for (int i = 0; i < LONG_BYTES; i++) {
				long t = arr[offset+i] & 0xff;
				data = (data << 8) | t;
			}
		}
		return data;
	}
	
	static public float toFloat(byte[] arr,int offset) {
		return Float.intBitsToFloat(toInt(arr, offset, true));
	}

	static public double toDouble(byte[] arr,int offset) {
		return Double.longBitsToDouble(toLong(arr, offset, true));
	}
	
	static public UUID toUUID(byte[] arr,int offset) {
		return new UUID(toLong(arr, offset, true),toLong(arr, offset+LONG_BYTES, true));
	}
	
	static public String toString(byte[] arr,int offset,int len,boolean gbk) {
		return new String(arr, offset, len, gbk?GBK_CHARSET:UTF8_CHARSET);
	}
	
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
	
	/**
	 * 负值 有符号long转为 正值
	 */
	public static final BigDecimal readUnsignedLong(long value) throws Exception {
		long lowValue = value & 0x7fffffffffffffffL;
		return BigDecimal.valueOf(lowValue).add(BigDecimal.valueOf(Long.MAX_VALUE)).add(BigDecimal.valueOf(1));
	}
	
}
