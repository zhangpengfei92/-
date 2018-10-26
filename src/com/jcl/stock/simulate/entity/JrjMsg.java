package com.jcl.stock.simulate.entity;
import java.util.ArrayList;
import java.util.UUID;

import org.zeromq.ZMQ;

import com.jcl.stock.simulate.DefineNumber;
import com.jcl.stock.simulate.Util;

public class JrjMsg {
	private static final byte[] NULL_MSG = new byte[0];
	private ArrayList<byte[]> msgs = new ArrayList<byte[]>();
	private RouterHead head = null;
	private CommPackInfo pack = null;
	private Response callback = null;
	private final long time = System.currentTimeMillis();
	
	public JrjMsg() {
	}

	public void create(UUID sender,int sendservice,UUID receiver,int receiverservice) {
		msgs.clear();
		msgs.add(NULL_MSG);
		
		head = new RouterHead();
		head.setSender(sender, sendservice);
		head.setReceiver(receiver, receiverservice);
		head.setError(RouterHead.ROUTER_ERROR_SUCCESS, "");
		msgs.add(head.getBuffer());
	}

	public boolean recv(ZMQ.Socket sock) {
		msgs.clear();
		head = null;
		do {
			byte[] msg = sock.recv(ZMQ.DONTWAIT);
			if (msg == null) break;
			msgs.add(msg);
		} while (sock.hasReceiveMore());
		
		if (msgs.size() < 2) {
			msgs.clear();
			return false;
		}
		
		//��֡
		if (msgs.get(0).length != 0) {
			System.out.println("��һ֡��ݲ��Ϸ�!");
			msgs.clear();
			return false;
		}
		//RouterHead֡
		head = new RouterHead(msgs.get(1));
		if (!head.legal()) {
			System.out.println("�ڶ�֡��ݲ��Ϸ�!");
			msgs.clear();
			head = null;
			return false;
		}
		
		return true;
	}
	
	public boolean send(ZMQ.Socket sock) {
		int size = msgs.size();
		if (size < 2) return false;
		for (int i = 0; i < size - 1; i++) {
			if (!sock.sendMore(msgs.get(i)))
				return false;
		}
		return sock.send(msgs.get(size-1), ZMQ.DONTWAIT);
	}

	public RouterHead head() {
		return head;
	}
	
	public void clear() {
		for (int i = msgs.size(); i > 2; i--) {
			msgs.remove(i-1);
		}
	}
	
	public void add(byte[] data) {
		msgs.add(data);
	}
	
	public void add(String s) {
		add(s.getBytes());
	}
	
	public void add(int data) {
		byte[] b = new byte[Util.INT_BYTES];
		Util.toByteArray(data, b, 0, true);
		add(b);
	}
	
	public void add(CommPackInfo pack) {
		this.pack = pack;
		msgs.add(pack.getBuffer());
	}

	public byte[] get(int index) {
		if (msgs.size() < index + 2) {
			return null;
		}
		return msgs.get(index + 2);
	}
	public CommPackInfo pack() {
		if (pack != null) return pack;
		byte[] data = get(0);
		if (data == null) return pack;
		pack = new CommPackInfo(data);
		if (!pack.isLegal()) pack = null;
		return pack;
	}

	public Response callback() {
		return callback;
	}

	public void setCallback(Response callback) {
		this.callback = callback;
	}
	
	public boolean expire(long now) {
		return now - time > DefineNumber.RESPONSE_TIME_OUT;
	}
}
