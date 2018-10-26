package com.jcl.stock.queue;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.log4j.Logger;

import com.jcl.stock.simulate.DefineNumber;
import com.jcl.stock.simulate.entity.CommPackInfo;
import com.jcl.stock.simulate.entity.JrjMsg;
import com.jcl.stock.simulate.entity.RouterHead;

public class DealThread implements Runnable {
	
	public static Logger log = Logger.getLogger(DealThread.class);
	private final ConcurrentLinkedQueue<JrjMsg> queue = new ConcurrentLinkedQueue<JrjMsg>();
	private final ConcurrentHashMap<Long, JrjMsg> callback = new ConcurrentHashMap<Long, JrjMsg>();
	private boolean stop = false;
	private long clean = System.currentTimeMillis();
	
	public boolean postMsg(JrjMsg msg) {
		return queue.add(msg);
	}
	
	public void stop() {
		stop = true;
	}
		
	public boolean regsiter(JrjMsg msg) {
		if (msg.pack() == null || msg.callback() == null) return false;
		long synid = msg.pack().synid();
		callback.put(synid, msg);
		return true;
	}

	@Override
	public void run() {
		while (!stop) {
			JrjMsg msg = queue.poll();
			if (msg == null) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			int service = msg.head().receiverService();
			switch(service) {
			case RouterHead.ROUTER_PROTOCOL_ERROR:
				CommPackInfo pack = msg.pack();
				if (pack == null) continue;
				Long syn = pack.synid();
				JrjMsg cb = callback.get(syn);
				if (cb != null) {
					log.info(msg.head().msg());
					cb.callback().response(false, msg);
					callback.remove(syn);
				}
				continue;
			case RouterHead.ROUTER_PROTOCOL_HEARTBEAT:
			case RouterHead.ROUTER_PROTOCOL_NODE_ADD:
			case RouterHead.ROUTER_PROTOCOL_NODE_DEL:
				continue;
			}
			Long syn = msg.pack().synid();
			JrjMsg cb = callback.get(syn);
			if (cb != null) {
				cb.callback().response(true, msg);
				callback.remove(syn);
			}
			cleanTimeout();
		}
	}

	public void count(long[] count) {
		count[4] = queue.size();
		count[5] = callback.size();
	}
	
	private void cleanTimeout() {
		long now = System.currentTimeMillis();
		if (now - clean < DefineNumber.RESPONSE_TIME_OUT)
			return;
		Set<Long> keys = callback.keySet();
		for (Long key : keys) {
			JrjMsg msg = callback.get(key);
			if (msg != null && msg.expire(now)) {
				callback.remove(key);
				msg.head().setError(RouterHead.ROUTER_ERROR_TIMEOUT, "应答超时!");
				msg.callback().response(false, msg);
			}
		}
		clean = System.currentTimeMillis();
	}
}
