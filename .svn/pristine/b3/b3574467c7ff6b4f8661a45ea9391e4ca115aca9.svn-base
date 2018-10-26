package com.jcl.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;
import com.jcl.comm.StockInfo;

  
/**        
 * Title: QuotaSession.java    
 * Description: 行情
 * @author zhuj       
 * @created 2015-5-28 下午3:15:29    
 */      
public class QuotaSession {
	public static final String STOCKINFO_URL =DeployProperties.getInstance().getStockInfoUrl();
	public static Logger log = Logger.getLogger(QuotaSession.class);
//	public static StockInfo getStockInfo(String stockCode) throws Exception{
//		StockInfo stockInfo = new StockInfo();
//		try {
//			StringBuffer urlBuffer = new StringBuffer(STOCKINFO_URL);
//			urlBuffer.append("?").append("symbol=").append(stockCode)
//			         .append("&").append("r=").append(Math.random());
//			URL url = new URL(urlBuffer.toString());
//			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			conn.setDoOutput(true);
//			conn.setDoInput(true);
//			conn.setUseCaches(false);
//			conn.setRequestMethod("POST");
//			conn.setRequestProperty("connection", "Keep-Alive");
//			conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
//			conn.setRequestProperty("Charsert", "UTF-8");
//			conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
//			conn.connect();
//			// 定义BufferedReader输入流来读取URL的响应
//			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
//			String line = null;
//			int i=0;
//			while ((line = reader.readLine()) != null) {
//				if(i==3){
//					String stockInfo_str = line.toString();
//					String[] stockInfos = stockInfo_str.split(",");
//					if(stockInfos.length==20){
//						stockInfo.setOpenPrice(Float.parseFloat(stockInfos[0]));
//						stockInfo.setClosePrice(Float.parseFloat(stockInfos[1]));
//						stockInfo.setHighPrice(Float.parseFloat(stockInfos[2]));
//						stockInfo.setLowPrice(Float.parseFloat(stockInfos[3]));
//						stockInfo.setNewPrice(Float.parseFloat(stockInfos[4]));
//						stockInfo.setDealNum(Integer.parseInt(stockInfos[5]));
//						stockInfo.setDealFund(Float.parseFloat(stockInfos[6]));
//						stockInfo.setVolumeRatio(Float.parseFloat(stockInfos[7]));
//						stockInfo.setExchangeRate(Float.parseFloat(stockInfos[8]));
//						stockInfo.setSwing(Float.parseFloat(stockInfos[9]));
//						stockInfo.setInvol(Integer.parseInt(stockInfos[10]));
//						stockInfo.setOutvol(Integer.parseInt(stockInfos[11]));
//						stockInfo.setPeRatio(Float.parseFloat(stockInfos[12]));
//						stockInfo.setMarketValue(stockInfos[13]);
//						stockInfo.setAvePrice(Float.parseFloat(stockInfos[14]));
//						stockInfo.setCommittee(Float.parseFloat(stockInfos[15]));
//						stockInfo.setCommission(Float.parseFloat(stockInfos[16]));
//						//stockInfo.setCityNet(Float.parseFloat(stockInfos[17]));
//						stockInfo.setEquity(Float.parseFloat(stockInfos[18]));
//						stockInfo.setEquityTotal(Float.parseFloat(stockInfos[19]));
//					}
//				}
//				i++;
//			}
//			reader.close();
//			return stockInfo;
//		} catch (Exception e) {
//			throw new Exception("请求行情异常"+e.getMessage());
//		}
//	}
	
	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static StockInfo getStockInfo(String stockCode) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		StockInfo stockInfo = new StockInfo();
		try {
			URL realUrl = new URL("http://hq.pb.jclkj.cn:9001/FreeHQWebServer/KLineResource?symbol="+stockCode+"&num=1&period=100&ex=1&synid=99910");
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setRequestProperty("Charsert", "UTF-8");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
//			out.print(param);
			// System.out.println(param.length());
			// flush输出流的缓冲
			out.flush();
			// 定义BufferedReader输入流来读取URL的响应
			// in = new BufferedReader(new
			// InputStreamReader(conn.getInputStream()));
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			log.error("发送 POST 请求出现异常！" + e.getMessage());
		} finally {// 使用finally块来关闭输出流、输入流
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		if(!StringUtil.isAnyNullOrEmpty(result)){
			String arr[] = result.split(",");
			stockInfo.setClosePrice(Float.parseFloat(arr[13]));
			stockInfo.setNewPrice(Float.parseFloat(arr[17]));
		}else{
			stockInfo.setClosePrice(Float.parseFloat("0"));
			stockInfo.setNewPrice(Float.parseFloat("0"));
		}
		return stockInfo;
	}
	
	public static void main(String[] args) {
		
//		   String list = sendPost("000001");
	}
}