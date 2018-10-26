/**
 * 类名　　  : CommonFunc.java
 * 功能概要  : 共通方法类
 * 做成日期  : 2014年7月14日 
 * 修改日期  :
 */
package com.jcl.util;

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
	
}