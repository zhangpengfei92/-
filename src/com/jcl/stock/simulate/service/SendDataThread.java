package com.jcl.stock.simulate.service;

import java.lang.Thread.UncaughtExceptionHandler;

import com.jcl.stock.simulate.BussinessException;

public class SendDataThread implements Runnable, UncaughtExceptionHandler {
	
	private static int i = 0;
	
	public SendDataThread() {
		super();
	}
	
	public void run() {// 向均衡发送请求
		SimulateStockServiceImpl sss = new SimulateStockServiceImpl();
		SimulateTest simulateTest3 = new SimulateTest();
		while (true) {
    		for (int i = 0; i < 100000; i++) {
	       	 	String str131 = "{\"client_id\":\"fdsa1023\",\"start\":0,\"limit\":1000,\"entrust_type\":0}";
			    try {
					sss.commonAjaxFunction(str131, 11119, simulateTest3);
				} catch (BussinessException e) {
					e.printStackTrace();
				}
		    }
    		try {
    			System.out.println(i++);
		    	//Thread.sleep(1);
    			if(i > 100){
    				i = 0;
    				Thread.sleep(1);
    			}
		    } catch (Exception e) {
			}
    	}
	}
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		//再次启用线程
		Thread sendDataThread = new Thread(new SendDataThread());
		sendDataThread.start();
	}
	
}