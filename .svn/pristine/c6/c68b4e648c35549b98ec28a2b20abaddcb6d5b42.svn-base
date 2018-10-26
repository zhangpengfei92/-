package com.jcl.stock.simulate;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**        
 * Title: ConvertData.java    
 * Description: Object对象数据与byte数组转换
 * @author Z.J       
 * @created 2016-1-21 上午10:52:11    
 */      
public class ConvertData {
	
    /**
     * 
     * @discription 合并byte数组
     * @author Z.J       
     * @created 2016-1-21 上午10:57:32     
     * @param a  需要合并的数组a
     * @param b  需要合并的数组b
     * @return   合并后的数组
     */
    public static byte[] margeByteArray(byte[] a,byte[] b){
    	byte[] margeByte = new byte[a.length+b.length];
    	System.arraycopy(a,0,margeByte,0,a.length);
    	System.arraycopy(b,0,margeByte,a.length,b.length);
    	return margeByte;
    }    
   
    /**
	 * 压缩
	 * 
	 * @param data
	 *            待压缩数据
	 * @return byte[] 压缩后的数据
	 */
	public static byte[] compress(byte[] data) {
		byte[] output = new byte[0];

		Deflater compresser = new Deflater();

		compresser.reset();
		compresser.setInput(data);
		compresser.finish();
		ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length);
		try {
			byte[] buf = new byte[1024];
			while (!compresser.finished()) {
				int i = compresser.deflate(buf);
				bos.write(buf, 0, i);
			}
			output = bos.toByteArray();
		} catch (Exception e) {
			output = data;
			e.printStackTrace();
		} finally {
			try {
				bos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		compresser.end();
		return output;
	}
	
	/**
	 * 解压缩
	 * 
	 * @param data
	 *            待压缩的数据
	 * @return byte[] 解压缩后的数据
	 */
	public static byte[] decompress(byte[] data) {
		byte[] output = new byte[0];

		Inflater decompresser = new Inflater();
		decompresser.reset();
		decompresser.setInput(data);

		ByteArrayOutputStream o = new ByteArrayOutputStream(data.length);
		try {
			byte[] buf = new byte[1024];
			while (!decompresser.finished()) {
				int i = decompresser.inflate(buf);
				o.write(buf, 0, i);
			}
			output = o.toByteArray();
		} catch (Exception e) {
			output = data;
			e.printStackTrace();
		} finally {
			try {
				o.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		decompresser.end();
		return output;
	}
	
	/**
	 * 解压缩
	 * 
	 * @param data
	 *            待压缩的数据
	 * @return byte[] 解压缩后的数据
	 */
	public static byte[] decompressLength(byte[] FullDataBuffer, int offset, int length) {
		byte[] data = new byte[length];
	    System.arraycopy(FullDataBuffer, offset, data, 0, length);
				
		byte[] output = new byte[0];

		Inflater decompresser = new Inflater();
		decompresser.reset();
		decompresser.setInput(data);

		ByteArrayOutputStream o = new ByteArrayOutputStream(data.length);
		try {
			byte[] buf = new byte[1024];
			while (!decompresser.finished()) {
				int i = decompresser.inflate(buf);
				o.write(buf, 0, i);
			}
			output = o.toByteArray();
		} catch (Exception e) {
			output = data;
			e.printStackTrace();
		} finally {
			try {
				o.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		decompresser.end();
		return output;
	}
	
}