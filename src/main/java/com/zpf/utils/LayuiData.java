package com.zpf.utils;

public class LayuiData {
	
	private long code = 0;
	
	private long count = 0;
	
	private Object data;
	
	private String msg;

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LayuiData() {
		super();
	}

	public LayuiData(long code, long count, Object data, String msg) {
		super();
		this.code = code;
		this.count = count;
		this.data = data;
		this.msg = msg;
	}
	

	public static LayuiData returnOk(){
		return new LayuiData(200,0,null,"ok");
	}
	
	public static LayuiData returnData(long count,Object data){
		return new LayuiData(0,count,data,"ok");
	}

	public static LayuiData returnFail(String msg) {		
		 return new LayuiData(500,0,null,msg);
	}
}
