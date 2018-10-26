package com.jcl.stock.simulate.entity;
import java.util.UUID;

import com.jcl.stock.simulate.Util;

public class RouterHead {
	private static final int OFFSET_SENDER_SERVICE = 0;
	private static final int OFFSET_SENDER_ID = OFFSET_SENDER_SERVICE + Util.INT_BYTES;
	private static final int OFFSET_RECEIVER_SERVICE = OFFSET_SENDER_ID + Util.UUID_BYTES;
	private static final int OFFSET_RECEIVER_ID = OFFSET_RECEIVER_SERVICE + Util.INT_BYTES;
	private static final int OFFSET_COOKIE = OFFSET_RECEIVER_ID + Util.UUID_BYTES;
	private static final int OFFSET_STATUS = OFFSET_COOKIE + Util.LONG_BYTES;
	private static final int OFFSET_MSG = OFFSET_STATUS + Util.LONG_BYTES;
	private static final int MSG_BYTES = 32;
	private static final int OFFSET_RESERVED_1 = OFFSET_MSG + MSG_BYTES;
	private static final int OFFSET_RESERVED_2 = OFFSET_RESERVED_1 + Util.INT_BYTES;
	private static final int OFFSET_RESERVED_3 = OFFSET_RESERVED_2 + Util.INT_BYTES;
	private static final int OFFSET_RESERVED_4 = OFFSET_RESERVED_3 + Util.INT_BYTES;
	public static final int HEAD_LENGTH = OFFSET_RESERVED_4 + Util.INT_BYTES;
	
	public static final int ROUTER_PROTOCOL_ERROR = 0;
	public static final int ROUTER_PROTOCOL_HEARTBEAT = 1;
	public static final int ROUTER_PROTOCOL_NODE_ADD = 2;
	public static final int ROUTER_PROTOCOL_NODE_DEL = 3;

	public static final int ROUTER_ERROR_SUCCESS			= 0;
	public static final int ROUTER_ERROR_SERVICE_NOT_FOUND	= 1;
	public static final int ROUTER_ERROR_SERVICE_BUSY		= 2;
	public static final int ROUTER_ERROR_NODE_NOT_FOUND		= 3;
	public static final int ROUTER_ERROR_INVALID_PARAMETER	= 4;
	public static final int ROUTER_ERROR_GENNERIC			= 5;
	public static final int ROUTER_ERROR_TIMEOUT			= 6;
	
	private byte[] head = null;
	
	public RouterHead() {
		head = new byte[HEAD_LENGTH];
	}
	
	public RouterHead(byte[] buf) {
		head = buf;
	}
	
	public boolean legal() {
		return head != null && head.length == HEAD_LENGTH;
	}
	
 	public void setSender(UUID id,int service) {
		Util.toByteArray(id, head, OFFSET_SENDER_ID);
		Util.toByteArray(service, head, OFFSET_SENDER_SERVICE, true);
	}
 	
 	public UUID senderId() {
 		return Util.toUUID(head, OFFSET_SENDER_ID);
 	}
 	
 	public int senderService() {
 		return Util.toInt(head, OFFSET_SENDER_SERVICE, true);
 	}
	
	public void setReceiver(UUID id,int service) {
		if (id != null) {
			Util.toByteArray(id, head, OFFSET_RECEIVER_ID);
		} else {
			Util.clear(head, OFFSET_RECEIVER_ID, Util.UUID_BYTES);
		}
		Util.toByteArray(service, head, OFFSET_RECEIVER_SERVICE, true);
	}
 	
 	public UUID receiverId() {
 		return Util.toUUID(head, OFFSET_RECEIVER_ID);
 	}
 	
 	public int receiverService() {
 		return Util.toInt(head, OFFSET_RECEIVER_SERVICE, true);
 	}
	
	public void setCookie(long cookie) {
		Util.toByteArray(cookie, head, OFFSET_COOKIE, true);
	}
 	
 	public long cookie() {
 		return Util.toLong(head, OFFSET_COOKIE, true);
 	}
	
	public void setError(int error,String msg) {
		Util.toByteArray(error, head, OFFSET_STATUS, true);
		Util.toByteArray(msg, head, OFFSET_MSG, MSG_BYTES, true);
	}
 	
 	public int error() {
 		return Util.toInt(head, OFFSET_STATUS, true);
 	}
 	
 	public String msg() {
 		return Util.toString(head, OFFSET_MSG, MSG_BYTES, true);
 	}
	
	public byte[] getBuffer() {
		return head;
	}
	
}
