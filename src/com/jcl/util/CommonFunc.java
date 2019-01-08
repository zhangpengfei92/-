/**
 * 类名　　  : CommonFunc.java
 * 功能概要  : 共通方法类
 * 做成日期  : 2014年7月14日 
 * 修改日期  :
 */
package com.jcl.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;

/**
 * 共通方法类
 * 
 * @author
 * @version 1.0
 */
public class CommonFunc implements java.io.Serializable {

	private static final long serialVersionUID = 7733278168606143789L;
	/*日期格式*/
	public static final String DATETIME_PATTERN = "yyyy-MM-dd";
	public static final String DATETIME_PATTERN_POINT = "yyyy.MM.dd";
	public static final String DATETIME_PATTERN_CHINESE = "yyyy年MM月dd日";
	public static final String DATETIME_PATTERN_FULL = "yyyy-MM-dd HH:mm:ss";
	public static final String DATETIME_PATTERN_MINUTE = "yyyy-MM-dd HH:mm";
	
	private static long updateTimeMsCodeMap = 0L;
	
	public static final String MSCODE_URL = DeployProperties.getInstance().getMsCodeUrl();
	public static final String MSCODE_MARKET = DeployProperties.getInstance().getMsCodeMarket();
	public static final String MSCODE_CTPMARKET = DeployProperties.getInstance().getMsCodeCtpMarket();

	//private static Logger logger = Logger.getLogger(CommonFunc.class.getName());
	
	/** 
	 * 格式化特殊字符
	 */
	public static String ReplaceSqlLike(String str) {
		if (str == null) {
			return "";
		}
		String strRet = str.replace("/", "//");
		strRet = strRet.replace("%", "/%");
		strRet = strRet.replace("_", "/_");

		return strRet;
	}
	
	/**
	 * 将字符串中的html字符过滤掉
	 * @param str 待处理的字符串
	 * @return 过滤后的字符串
	 * @author jzq
	 */
	public static String encodeHtml(String str) {
		if(str != "" && str != null){
			str = str.replaceAll("&", "&amp;")
					 .replaceAll("<", "&lt;")
					 .replaceAll(">", "&gt;")
					 .replaceAll("\"", "&quot;")
					 .replaceAll("'", "&apos;");
		}
		return str;
	}
	
	public static String htmlEncode(String text) {
		if (text == null || text.length() == 0)
			return text;
		int length = text.length();
		StringBuffer ret = new StringBuffer((length * 12) / 10);
		boolean isEncodeSpace = true;
		int last = 0;
		for (int i = 0; i < length; i++) {
			char c = text.charAt(i);
			switch (c) {
			case 32: // ' '
				if (isEncodeSpace) {
					if (last < i)
						ret.append(text.substring(last, i));
					last = i + 1;
					ret.append("&nbsp;");
					isEncodeSpace = false;
				} else {
					isEncodeSpace = true;
				}
				break;

			case 38: // '&'
				if (last < i)
					ret.append(text.substring(last, i));
				last = i + 1;
				ret.append("&amp;");
				isEncodeSpace = false;
				break;

			case 62: // '>'
				if (last < i)
					ret.append(text.substring(last, i));
				last = i + 1;
				ret.append("&gt;");
				isEncodeSpace = false;
				break;

			case 60: // '<'
				if (last < i)
					ret.append(text.substring(last, i));
				last = i + 1;
				ret.append("&lt;");
				isEncodeSpace = false;
				break;

			case 34: // '"'
				if (last < i)
					ret.append(text.substring(last, i));
				last = i + 1;
				ret.append("&quot;");
				isEncodeSpace = false;
				break;

			case 10: // '\n'
				if (last < i)
					ret.append(text.substring(last, i));
				last = i + 1;
				ret.append("<br/>");
				isEncodeSpace = false;
				break;

			default:
				isEncodeSpace = false;
				break;
			}
		}

		if (last < length)
			ret.append(text.substring(last));
		return ret.toString();
	}
	
	/** 
	 * 获取当前登录用户名
	 */
	public static String getLoginUserName(HttpSession session) {
		String strRet = (String) session.getAttribute(Constant.SESSION_LOGINNAME);
		if(strRet != null){
			return strRet;
		} else {
			return "";
		}
	}
	
	/** 
	 * 获取当前登录用户权限
	 */
	public static String getLoginUserRights(HttpSession session) {
		/*String strRet = (String) session.getAttribute(Constant.SYSRIGHTS_KEY);
		if(strRet != null){
			return strRet;
		} else {
			return "";
		}*/
		return "";
	}
	
	/** 
	 * 获取当前登录用户ID
	 */
	public static Integer getLoginUserId() {
		/*HttpSession session = ServletActionContext.getRequest().getSession();
		Integer userId = (Integer) session.getAttribute(Constant.SESSION_ACCOUNTID);
		if(userId != null){
			return userId;
		} else {
			String address = session.getAttribute(Constant.SESSION_BASEPATH) + "/login!login.action";
			try {
				ServletActionContext.getResponse().sendRedirect(address);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}*/
		return null;
	}
	
	//*********************************随机字符串********************************//
	private static char[] captchars = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
	
	/**
	 * 返回6位随机字符串
	 * 
	 * @return sixRandomStr
	 */
	public static String getSixRandomStr() {
		// 生成随机类
		Random random = new Random();
		// 取随机产生的认证码(6位数字)
		String sixRandomStr = "";
		for (int i = 0; i < 6; i++) {
			int car = captchars.length - 1;
			String rand = String.valueOf(captchars[random.nextInt(car) + 1]);
			sixRandomStr += rand;
		}
		return sixRandomStr;
	}
	
	/**
	 * 返回8位随机字符串
	 * 
	 * @return eightRandomStr
	 */
	public static String getEightRandomStr() {
		// 生成随机类
		Random random = new Random();
		// 取随机产生的认证码(6位数字)
		String sixRandomStr = "";
		for (int i = 0; i < 8; i++) {
			int car = captchars.length - 1;
			String rand = String.valueOf(captchars[random.nextInt(car) + 1]);
			sixRandomStr += rand;
		}
		return sixRandomStr;
	}

	/**
	 * create cell 创建表头
	 * 
	 * @param row
	 * @param cell
	 * @param headers
	 * @param normalStyle
	 */
	public static void createHeader(HSSFRow row, String[] headers,
			HSSFCellStyle normalStyle) {
		for (int i = 0; i < headers.length; i++) {
			// 创建单元格
			HSSFCell cell = row.createCell(i);
			// 给每个单元格赋值
			cell.setCellValue(new HSSFRichTextString(headers[i]));
			// 设置Style
			cell.setCellStyle(normalStyle);
		}
	}
	
	/**
	 * 创建单元格，并向单元格中写入数据（写入的值为Integer类型）
	 * 
	 * @param row
	 * @param index
	 * @param value
	 * @param normalStyle
	 */
	public static void createCell(HSSFRow row, int index, Integer value,
			HSSFCellStyle normalStyle) {
		// 创建单元格
		HSSFCell cell = row.createCell(index);
		// 给第一个单元格赋值
		cell.setCellValue(value);
		// 设置Style
		cell.setCellStyle(normalStyle);
	}
	
	/**
	 * 创建单元格，并向单元格中写入数据（写入的值为String类型）
	 * 
	 * @param row
	 * @param index
	 * @param value
	 * @param normalStyle
	 */
	public static void createCell(HSSFRow row, int index, String value,
			HSSFCellStyle normalStyle) {
		// 创建单元格
		HSSFCell cell = row.createCell(index);
		// 给第一个单元格赋值
		cell.setCellValue(value==null?"":value);
		// 设置Style
		cell.setCellStyle(normalStyle);
	}
	
	/**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestMethod("POST");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Charsert", "UTF-8");
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            //System.out.println(param.length());
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            //in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        } finally {  //使用finally块来关闭输出流、输入流
            try {
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
    
    public static Map<String, String> getHttpMsCode() throws Exception{
		Map<String, String> stockInfoMap = null;
		try {
			/*每隔1小时获取一次代码链*/
			// 如果当前缓存正在更新或者缓存超出时限，需重新加载
			long currentTime = System.currentTimeMillis();
			/*获取缓存中数据集合*/
			if (!isTimeOutMap(currentTime)) {
				stockInfoMap = DataListCache.getMsCodeCache("ms_code");
			}
			if(stockInfoMap == null){
				stockInfoMap = new HashMap<String, String>();
				String [] marketInt = MSCODE_MARKET.split(",");//3,4,5,6,24
				if(marketInt.length > 0){
					int initInt = 0;
					int maxInt = marketInt.length;
					/*初始化变量*/
					StringBuffer urlBuffer = null;
					URL url = null;
					HttpURLConnection conn = null;
					for(int i = 0; i < maxInt; i++){
						initInt = Integer.parseInt(marketInt[i]);
						urlBuffer = new StringBuffer(MSCODE_URL);
						urlBuffer.append("?").append("setcode=").append(initInt);
						url = new URL(urlBuffer.toString());
						conn = (HttpURLConnection) url.openConnection();
						conn.setDoOutput(true);
						conn.setDoInput(true);
						conn.setUseCaches(false);
						conn.setRequestMethod("GET");
						conn.setRequestProperty("connection", "Keep-Alive");
						conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
						conn.setRequestProperty("Charsert", "UTF-8");
						conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
						conn.connect();
						// 定义BufferedReader输入流来读取URL的响应
						BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
						String line = null;
						while ((line = reader.readLine()) != null) {
							String[] stockInfos = line.toString().split(",");
							//if(stockInfos.length==6){
							if(stockInfos.length > 7){
								if(stockInfos[3].equals("品种名称"))continue;
								stockInfoMap.put(stockInfos[2]+"-"+stockInfos[1]+","+initInt, stockInfos[3]);
							}
						}
						
					}
				}
				if(stockInfoMap != null && stockInfoMap.size() > 0){//设置缓存
					DataListCache.setMsCodeCache("ms_code", stockInfoMap);
					updateTimeMsCodeMap = currentTime;// 缓存更新时间 
				}
			}
			
		} catch (Exception e) {
			throw new Exception("请求行情异常"+e.getMessage());
		}
		return stockInfoMap;
	}
    
    /*获取原油行情信息*/
    public static Map<String, String> getHttpCtpMsCode() throws Exception{
		Map<String, String> stockInfoMap = null;
		try {
			stockInfoMap = new HashMap<String, String>();
			String [] marketInt = MSCODE_CTPMARKET.split(",");//6,24
			if(marketInt.length > 0){
				int initInt = 0;
				int maxInt = marketInt.length;
				/*初始化变量*/
				StringBuffer urlBuffer = null;
				URL url = null;
				HttpURLConnection conn = null;
				for(int i = 0; i < maxInt; i++){
					initInt = Integer.parseInt(marketInt[i]);
					urlBuffer = new StringBuffer(MSCODE_URL);
					urlBuffer.append("?").append("setcode=").append(initInt);
					url = new URL(urlBuffer.toString());
					conn = (HttpURLConnection) url.openConnection();
					conn.setDoOutput(true);
					conn.setDoInput(true);
					conn.setUseCaches(false);
					conn.setRequestMethod("GET");
					conn.setRequestProperty("connection", "Keep-Alive");
					conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
					conn.setRequestProperty("Charsert", "UTF-8");
					conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
					conn.connect();
					// 定义BufferedReader输入流来读取URL的响应
					BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
					String line = null;
					while ((line = reader.readLine()) != null) {
						String[] stockInfos = line.toString().split(",");
						//if(stockInfos.length==6){
						if(stockInfos.length > 5){
							if(stockInfos[3].equals("品种名称"))continue;
							stockInfoMap.put(stockInfos[2]+"-"+stockInfos[1]+","+initInt, stockInfos[3]);
						}
					}
					
				}
			}
			
		} catch (Exception e) {
			throw new Exception("请求行情异常"+e.getMessage());
		}
		return stockInfoMap;
	}
    
    private static boolean isTimeOutMap(long currentTime) {  
		return ((currentTime - updateTimeMsCodeMap) > 3600000);// 超过时限，超时   1H
	}
	
}