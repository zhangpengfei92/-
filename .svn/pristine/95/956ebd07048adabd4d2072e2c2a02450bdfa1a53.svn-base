package com.jcl.stock.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.log4j.Logger;
import org.zeromq.ZMQ;

import com.jcl.stock.common.DeployProperties;
import com.jcl.stock.simulate.DefineNumber;
import com.jcl.stock.simulate.Util;
import com.jcl.stock.simulate.ZookeeperUtil;
import com.jcl.stock.simulate.entity.JrjMsg;
import com.jcl.stock.simulate.entity.RouterHead;
import com.jcl.stock.simulate.service.SimulateStockService;

public class WorkThread implements Runnable {
	private static Logger logger = Logger.getLogger(WorkThread.class);
	private static final String ZEROMQ_SERVER = DeployProperties.getInstance().getZeroMQServer();
	private static final int SESSION_TIMEOUT = 10000;
    private static final String CONNECTION_STRING = DeployProperties.getInstance().getZookeeperServer();
    private static final String ZK_PATH = DeployProperties.getInstance().getZookeeperAddress();
    
    private static class Broker {
    	public ZMQ.Socket sock = null;
    	public long heartbeat = System.currentTimeMillis();
    	public long register = heartbeat;
    }
	
	private final ConcurrentLinkedQueue<JrjMsg> queue = new ConcurrentLinkedQueue<JrjMsg>();
	private final DealThread dealer;
	private final Thread dealerthread;
	private final ZMQ.Context ctx;
	private final UUID id;
	private final byte[] identify;
	private ArrayList<String> servers = new ArrayList<String>();
	private final long count[] = new long[] {0,0};
    
    private ZookeeperUtil sample = null;
	
	public WorkThread() {
		dealer = new DealThread();
		dealerthread = new Thread(dealer);
		dealerthread.start();
		ctx = ZMQ.context(1);
		id = UUID.randomUUID();
		identify = new byte[Util.UUID_BYTES];
		Util.toByteArray(id, identify, 0);
		
		sample = new ZookeeperUtil(this);
	    if(!Util.isAnyNullOrEmpty(CONNECTION_STRING)){
		    sample.createConnection(CONNECTION_STRING, SESSION_TIMEOUT);
		    try {
			    if (sample.createPath(ZK_PATH, "")) {
			    	servers = sample.readListData(ZK_PATH);
			    }
		    } catch (Exception e) {
		    	servers = sample.readListData(ZK_PATH);
				logger.error("NodeExists 继续读取数据" + e.getMessage());
			}
	    } else {
	    	String [] configServer = ZEROMQ_SERVER.split(",");
        	if(configServer.length > 0){
        		for(int i = 0; i < configServer.length; i++){
        			servers.add(configServer[i]);
            	}
        	}
	    }
	}
	
	public UUID getId() {
		return id;
	}
	
	public void stop() {
		dealer.stop();
		try {
			dealerthread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ctx.close();
	}
	
	public boolean postMsg(JrjMsg msg) {
		while (queue.size() > DefineNumber.QUEUE_MAX_SIZE) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		dealer.regsiter(msg);
		return queue.add(msg);
	}
	
	public void count(long[] count, boolean reset) {
		synchronized(this.count) {
			System.arraycopy(this.count, 0, count, 0, 2);
			if (reset) {
				this.count[0] = this.count[1] = 0;
			}
		}
		count[3] = queue.size();
		dealer.count(count);
	}
	
	public void setAddress(ArrayList<String> servers) {
		synchronized (this.servers) {
			this.servers = servers;
		}
	}
	
	private boolean sendCoreMsg(ZMQ.Socket sock,int type) {
		JrjMsg msg = new JrjMsg();
		msg.create(id, SimulateStockService.LOCAL_SERVICE,null,type);
		if (type == 2) {
			msg.add(SimulateStockService.LOCAL_SERVICE);
			msg.add(DefineNumber.JavaInterface);
		}
		return msg.send(sock);
	}

	@Override
	public void run() {
		ArrayList<String> tempServers = null;
		HashMap<String, ZMQ.Socket> mapSockets = new HashMap<String, ZMQ.Socket>(32);
		HashMap<ZMQ.Socket, Broker> mapActive = new HashMap<ZMQ.Socket, Broker>(32);
		ZMQ.Poller poller = new ZMQ.Poller(32);
		while (true) {
			long now = System.currentTimeMillis();
			synchronized(servers) {
				if (tempServers == null || !servers.equals(tempServers)) {
					Set<String> keys = mapSockets.keySet();
					for (String key : keys) {
						if (!servers.contains(key)) {
							ZMQ.Socket sock = mapSockets.get(key);
							poller.unregister(sock);
							mapSockets.remove(key);
							mapActive.remove(sock);
							sendCoreMsg(sock, 3);
							sock.close();
						}
					}
					for (String addr : servers) {
						if (!mapSockets.containsKey(addr)) {
							Broker broker = new Broker();
							broker.sock = ctx.socket(ZMQ.DEALER);
							broker.sock.setIdentity(identify);
							broker.sock.setHWM(0);
							broker.sock.connect(addr);
							mapSockets.put(addr, broker.sock);
							mapActive.put(broker.sock, broker);
							sendCoreMsg(broker.sock, 2);
							broker.heartbeat = broker.register = now;
							poller.register(broker.sock, ZMQ.EVENT_ALL);
						}
					}
					tempServers = servers;
				}
			}
			if (mapSockets.isEmpty()) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				continue;
			}
			int size = mapSockets.size();
			int rc = poller.poll();
			if (rc < 0) break;

			boolean idle = true;
			now = System.currentTimeMillis();
			for (int i = 0; i < size; i++) {
				ZMQ.Socket sock = poller.getSocket(i);
				Broker broker = mapActive.get(sock);
				if (poller.pollout(i)) {
					int sent = 0;
					if (now - broker.register > DefineNumber.REGISTER_INTERVAL) {
						if (!sendCoreMsg(sock, RouterHead.ROUTER_PROTOCOL_NODE_ADD))
							sent = DefineNumber.QUEUE_MAX_SIZE;
						else
							broker.register = now;
					}
					while (sent < DefineNumber.QUEUE_MAX_SIZE) {
						JrjMsg msg = queue.peek();
						if (msg == null) {
							if (now - broker.heartbeat > DefineNumber.HEARTBEAT_INTERVAL) {
								sendCoreMsg(sock, RouterHead.ROUTER_PROTOCOL_HEARTBEAT);
								broker.heartbeat = now;
							}
							break;
						}
						if (!msg.send(sock)) break;
						queue.poll();
						synchronized(count) {
							count[0]++;
						}
						idle = false;
					}
				}
				if (poller.pollin(i)) {
					while (true) {
						JrjMsg msg = new JrjMsg();
						if (!msg.recv(sock)) break;
						broker.heartbeat = now;
						switch (msg.head().receiverService()) {
						case RouterHead.ROUTER_PROTOCOL_HEARTBEAT:
						case RouterHead.ROUTER_PROTOCOL_NODE_ADD:
						case RouterHead.ROUTER_PROTOCOL_NODE_DEL:
							continue;
						}
						dealer.postMsg(msg);
						idle = false;
						synchronized(count) {
							count[1]++;
						}
					}
				}
			}
			if (idle) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					logger.error("线程sleep异常：" + e.getMessage());
				}
			}
		}
	}

}
