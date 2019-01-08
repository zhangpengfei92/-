package com.jcl.stock.simulate.service;

import org.apache.log4j.Logger;

public class SynCallBack implements CallBackStock {
	
	private static Logger log = Logger.getLogger(SynCallBack.class);
	
	private String rsp;
	
	//private CountDownLatch synObj = new CountDownLatch(1);
	private Object synObj = "123";
	
	@Override
	public String getResponseResult(Object... arg) {
		rsp = (String) arg[2];
		//synObj.countDown();
		synchronized (synObj) {
			synObj.notify();
		}
		return rsp;
	}
	
	public String getResponse(int timeout) {
		try {
			synchronized (synObj) {
				synObj.wait(timeout);
			}
			//synObj.await(timeout,TimeUnit.MILLISECONDS);
			return rsp;
		} catch (InterruptedException e) {
			log.error("同步等待超时：" + e.getMessage());
			return null;
		}
	}
	
}