package com.jcl.stock.simulate.service;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONObject;

import com.jcl.stock.queue.WorkThread;
import com.jcl.stock.simulate.BussinessException;
import com.jcl.stock.simulate.DefineNumber;
import com.jcl.stock.simulate.Util;
import com.jcl.stock.simulate.entity.CommPackInfo;
import com.jcl.stock.simulate.entity.JrjMsg;
import com.jcl.stock.simulate.entity.Response;
import com.jcl.stock.simulate.entity.RouterHead;

/**        
 * Title: SimulateStockServiceImpl.java    
 * Description: 模拟炒股接口实现类
 */      
public class SimulateStockServiceImpl implements SimulateStockService {
	//private static Logger logger = Logger.getLogger(SimulateStockServiceImpl.class);

	private static class SynCall {
		public String rsp = null;
		public Object notify = new Object();
	}
	
	/*请求集合*/
	private final ConcurrentHashMap<Long, CallBackStock> reqs;
	private final ConcurrentHashMap<Long, SynCall> synReq;
	
	private Long synid = 0l,successed = 0l;
	private final WorkThread worker = new WorkThread();
	private final Thread thread = new Thread(worker);
	
	public SimulateStockServiceImpl() {
		reqs = new ConcurrentHashMap<Long, CallBackStock>();
		synReq = new ConcurrentHashMap<Long, SynCall>();
		thread.start();
	}

	private final Response response = new Response() {
		
		@Override
		public void response(boolean success, JrjMsg msg) {
			Long syn = msg.pack().synid();
			String rsp = msg.pack().getResponse();
			if (success) {
				synchronized (successed) {
					successed++;
				}
			}
			if (synReq.containsKey(syn)) {
				SynCall call = synReq.get(syn);
				synReq.remove(syn);
				if (success) {
					call.rsp = rsp;
				}
				synchronized(call.notify) {
					call.notify.notifyAll();
				}
				return;
			}
			CallBackStock cb = reqs.get(syn);
			if (cb == null)
			{
				return;
			}
			cb.getResponseResult(syn, msg.pack().funcid(), rsp, Boolean.valueOf(success), msg.head().msg(), msg.head().error());
			reqs.remove(syn);
		}
	};
	
	@Override
	public String commonFunction(String str, int functionNum) throws BussinessException {
		if(Util.isAnyNullOrEmpty(str)){
			throw new BussinessException("入参不能为空");
		}
		Long syn = null;
		String client_id = "";
		if(str.indexOf("\"client_id\"") > -1){
			//client_id = JSONObject.fromObject(str).getString("client_id");
			client_id = new JSONObject(str).getString("client_id");
		}
		byte[] data = client_id.getBytes();
		long cookie = Util.Hash64(data, 0, data.length);
		
		JrjMsg msg = new JrjMsg();
		synchronized (synid) {
			syn = ++synid;
		}
		int service = 0;
		UUID receiver = null;
		if (functionNum > 30000) {
			service = DB_SERVICE;
		} else if (functionNum > 20000 && functionNum < 30000) {
			service = SECURITY_SERVICE;
		} else {
			service = COUTER_SERVICE;
		}
		msg.create(worker.getId(),LOCAL_SERVICE, receiver, service);
		
		RouterHead head = msg.head();
		head.setCookie(cookie);
		
		CommPackInfo pack = new CommPackInfo(null);
		data = str.getBytes(Util.UTF8_CHARSET);
		if (!pack.createPack(DefineNumber.JCL_PROTOCOL_VER, cookie, syn, 0, functionNum, data)) {
			throw new BussinessException("创建请求失败!");
		}
		msg.add(pack);

		SynCall call = new SynCall();
		synReq.put(syn, call);
		msg.setCallback(response);
		if (!worker.postMsg(msg)) {
			throw new BussinessException("投递请求失败!");
		}
		try {
			synchronized(call.notify) {
				call.notify.wait(DefineNumber.RESPONSE_TIME_OUT);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synReq.remove(syn);
		return call.rsp;
	}

	@Override
	public long commonAjaxFunction(String str, int functionNum, CallBackStock callBackStock) throws BussinessException {
		if(Util.isAnyNullOrEmpty(str)){
			throw new BussinessException("入参不能为空");
		}
		Long syn = null;
		String client_id = "";
		if(str.indexOf("\"client_id\"") > -1){
			//client_id = JSONObject.fromObject(str).getString("client_id");
			client_id = new JSONObject(str).getString("client_id");
		}
		byte[] data = client_id.getBytes();
		long cookie = Util.Hash64(data, 0, data.length);
		byte[] b = new byte[8];
		Util.toByteArray(cookie, b, 0, true);
		
		JrjMsg msg = new JrjMsg();
		synchronized (synid) {
			syn = ++synid;
		}
		int service = 0;
		UUID receiver = null;
		if (functionNum > 30000) {
			service = DB_SERVICE;
		} else if (functionNum > 20000 && functionNum < 30000) {
			service = SECURITY_SERVICE;
		} else {
			service = COUTER_SERVICE;
		}
		msg.create(worker.getId(),LOCAL_SERVICE, receiver, service);
		
		RouterHead head = msg.head();
		head.setCookie(cookie);
		
		CommPackInfo pack = new CommPackInfo(null);
		data = str.getBytes(Util.UTF8_CHARSET);
		if (!pack.createPack(DefineNumber.JCL_PROTOCOL_VER, cookie, syn, 0, functionNum, data)) {
			throw new BussinessException("创建请求失败");
		}
		msg.add(pack);

		msg.setCallback(response);
		reqs.put(syn, callBackStock);
		if (!worker.postMsg(msg)) {
			throw new BussinessException("投递请求失败!");
		}
		return syn;
	}

	public WorkThread getWorker() {
		return worker;
	}

	@Override
	public void getPackCount(long[] count, boolean reset) {
		worker.count(count,reset);
		synchronized (successed) {
			count[6] = successed;
		}
	}
	
}