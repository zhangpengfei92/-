package com.jcl.stock.simulate;

import java.util.LinkedList;
import java.util.List;

    /**        
     * Title: BussinessException.java    
     * Description: 业务异常类
     * @author zhujie       
     * @created 2015-8-14 上午9:35:35    
     */      
    
public class BussinessException extends Exception {
	private static final long serialVersionUID = -1527557493891940144L;
	private List<String> errorCodeList; 
	
	/**
	 * 构造函数
	 * 
	 * @param errorCode 异常错误代码
	 */
	public BussinessException(String errorCode) {
		this.errorCodeList = new LinkedList<String>();
		this.errorCodeList.add(errorCode);
	}

	/**
	 * 异常错误代码列表
	 * 
	 * @param errors
	 */
	public BussinessException(List<String> errors) {
		this.errorCodeList = errors;
	}

	/**
	 * 获取一个错误异常代码
	 * 
	 * @return string
	 */
	public String getError() {
		if (this.errorCodeList == null)
			return null;
		else
			return this.errorCodeList.get(0);
	}

	/**
	 * 获取所有错误异常列表
	 * 
	 * @return List<String>
	 */
	public List<String> getAllErrors() {
		return this.errorCodeList;
	}
	
	public String getMessage(){
		return getError();
	}

}
