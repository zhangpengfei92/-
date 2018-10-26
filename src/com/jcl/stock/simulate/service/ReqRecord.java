package com.jcl.stock.simulate.service;

import com.jcl.stock.simulate.DefineNumber;

public class ReqRecord {
	public CallBackStock cb;
	public long reqTime;
	
	public ReqRecord(CallBackStock cb) {
		this.cb = cb;
		reqTime = System.currentTimeMillis();
	}
	
	public boolean isRetire(long now) {
		return (now - reqTime > DefineNumber.RESPONSE_TIME_OUT);
	}
	
}
