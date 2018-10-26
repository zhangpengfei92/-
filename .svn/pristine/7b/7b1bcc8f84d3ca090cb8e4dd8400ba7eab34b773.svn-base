package com.jcl.stock.simulate.entity;

import com.jcl.stock.simulate.DefineNumber;
import com.jcl.stock.simulate.Util;

public class CommPackInfo {
	private static final int OFFSET_HASH = 0;
	private static final int OFFSET_VERSION = OFFSET_HASH + Util.LONG_BYTES;
	private static final int OFFSET_COMPRESSED = OFFSET_VERSION + 1;
	private static final int OFFSET_ENCRYPT = OFFSET_COMPRESSED + 1;
	private static final int OFFSET_COOKIE = OFFSET_ENCRYPT + 1;
	private static final int OFFSET_SYNID = OFFSET_COOKIE + Util.LONG_BYTES;
	private static final int OFFSET_ASSISID = OFFSET_SYNID + Util.LONG_BYTES;
	private static final int OFFSET_RAWLEN = OFFSET_ASSISID + Util.LONG_BYTES;
	private static final int OFFSET_PACKLEN = OFFSET_RAWLEN + Util.INT_BYTES;
	private static final int OFFSET_FUNCID = OFFSET_PACKLEN + Util.INT_BYTES;
	public static final int HEAD_LENGTH = OFFSET_FUNCID + Util.INT_BYTES;
	private byte[] buf;
	
	public CommPackInfo(byte[] buf) {
		this.buf = buf;
	}
	
	public boolean createPack(byte version,long cookie,long synid,long assisid,int func,byte[] data) {
		byte compressed = 0;
		int packlen = data.length;
		if (data.length > DefineNumber.ZIP_DATALENGTH) {
			byte[] b = Util.compress(data, 0, data.length);
			packlen = b.length;
			buf = new byte[HEAD_LENGTH + packlen];
			System.arraycopy(buf, HEAD_LENGTH, b, 0, packlen);
			compressed = 1;
		} else {
			buf = new byte[HEAD_LENGTH + packlen];
			System.arraycopy(data, 0, buf, HEAD_LENGTH, packlen);
		}
		Util.toByteArray((long)Util.getCRC32(data, 0, data.length), buf, OFFSET_HASH, true);
		buf[OFFSET_VERSION] = version;
		buf[OFFSET_COMPRESSED] = compressed;
		buf[OFFSET_ENCRYPT] = 0;
		Util.toByteArray(cookie, buf, OFFSET_COOKIE, true);
		Util.toByteArray(synid, buf, OFFSET_SYNID, true);
		Util.toByteArray(assisid, buf, OFFSET_ASSISID, true);
		Util.toByteArray(packlen, buf, OFFSET_PACKLEN, true);
		Util.toByteArray(data.length, buf, OFFSET_RAWLEN, true);
		Util.toByteArray(func, buf, OFFSET_FUNCID, true);
		return true;
	}
	
	public byte version() {
		return buf[OFFSET_VERSION];
	}

	public byte compressed() {
		return buf[OFFSET_COMPRESSED];
	}
	
	public long cookie() {
		return Util.toLong(buf, OFFSET_COOKIE, true);
	}
		
	public long synid() {
		return Util.toLong(buf, OFFSET_SYNID, true);
	}
		
	public long assisid() {
		return Util.toLong(buf, OFFSET_ASSISID, true);
	}
	
	public int rawlen() {
		return Util.toInt(buf, OFFSET_RAWLEN, true);
	}
	
	public int packlen() {
		return Util.toInt(buf, OFFSET_PACKLEN, true);
	}
	
	public int funcid() {
		return Util.toInt(buf, OFFSET_FUNCID, true);
	}
	
	public byte[] getBuffer() {
		return buf;
	}
	
	public boolean isLegal() {
		if (buf.length < HEAD_LENGTH || buf.length < packlen() + HEAD_LENGTH) return false;
		if (compressed() != 0) {
			byte[] data = Util.decompress(buf, HEAD_LENGTH, packlen());
			return data.length == rawlen();
		}
		return true;
	}
	
	public String getResponse() {
		if (compressed() != 0) {
			byte[] rsp = Util.decompress(buf, HEAD_LENGTH, packlen());
			return Util.toString(rsp, 0, rsp.length, false);
		}
		return Util.toString(buf, HEAD_LENGTH, packlen(), false);
	}
}
