package com.jcl.stock.simulate.service;

import com.jcl.stock.simulate.BussinessException;
import com.jcl.stock.simulate.DefineNumber;
import com.jcl.stock.simulate.Util;

/**        
 * Title: SimulateStockService.java    
 * Description: 模拟炒股接口
 * @author jzq       
 * @created 2016-09-18
 */      
public interface SimulateStockService {
	public static final int COUTER_SERVICE = Util.getCRC32(DefineNumber.SimulateBond);
	public static final int SECURITY_SERVICE = Util.getCRC32(DefineNumber.SecurityService);
	public static final int DB_SERVICE = Util.getCRC32(DefineNumber.DBService);
	public static final int LOCAL_SERVICE = Util.getCRC32(DefineNumber.JavaInterface);
	
	/**
	 * 共同方法
	 * @return
	 * @throws BussinessException
	 */
	public String commonFunction(String str, int functionNum) throws BussinessException;
	
	/**
	 * 共同异步调用方法
	 * @return
	 * @throws BussinessException
	 */
	public long commonAjaxFunction(String str, int functionNum, CallBackStock callBackStock) throws BussinessException;
	

	/**
	 * 获取性能参数
	 * @return
	 */
	public void getPackCount(long[] count,boolean reset);
}