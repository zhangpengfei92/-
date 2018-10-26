package com.jcl.util;

import java.util.HashSet;
import java.util.Set;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class Pinyin4jUtil {
	public static String getPinyin(String chinese) {  
        return getPinyinZh_CN(makeStringByStringSet(chinese));  
    }  
  
    /**
     * 拼音大写输出 
     * @Name: Pinyin4jUtil.java 
     * @param chinese 
     * @return 
     */  
    public static String getPinyinToUpperCase(String chinese) {  
        return getPinyinZh_CN(makeStringByStringSet(chinese)).toUpperCase();  
    }  
  
    /**
     * 拼音小写输出 
     * @Name: Pinyin4jUtil.java 
     * @param chinese 
     * @return 
     */  
    public static String getPinyinToLowerCase(String chinese) {  
        return getPinyinZh_CN(makeStringByStringSet(chinese)).toLowerCase();  
    }  
  
    /**
     * 首字母大写输出 
     * @Name: Pinyin4jUtil.java 
     * @param chinese 
     * @return 
     */  
    public static String getPinyinFirstToUpperCase(String chinese) {  
        return getPinyin(chinese);  
    }  
  
    /**
     * 拼音简拼输出 
     * @Name: Pinyin4jUtil.java 
     * @param chinese 
     * @return 
     */  
    public static String getPinyinJianPin(String chinese) {  
        return getPinyinConvertJianPin(getPinyin(chinese));  
    }  
  
    /**
     * 字符集转换 
     * @Name: Pinyin4jUtil.java 
     * @param chinese 
     *            中文汉字 
     * @throws BadHanyuPinyinOutputFormatCombination 
     */  
    public static Set<String> makeStringByStringSet(String chinese) {  
       // char[] chars = chinese.toCharArray();  
        if (chinese != null && !chinese.trim().equalsIgnoreCase("")) {  
            char[] srcChar = chinese.toCharArray();  
            String[][] temp = new String[chinese.length()][];  
            for (int i = 0; i < srcChar.length; i++) {  
  
                // 是中文或者a-z或者A-Z转换拼音  
               // if (String.valueOf(c).matches("[\\u4E00-\\u9FA5]+")) {  
  
                    try {  
                    	if(null != PinyinHelper.toHanyuPinyinStringArray(srcChar[i])){
                    		temp[i] = PinyinHelper.toHanyuPinyinStringArray(srcChar[i]);  
                    	}else{
                    		char ss = srcChar[i];
                    		String str = String.valueOf(ss);
                    		String[] s = {str};
                    		temp[i] = s;
                    	}
  
                    } catch (Exception e) {  
                        e.printStackTrace();  
                    }  
               /* } else if (((int) c >= 65 && (int) c <= 90)  
                        || ((int) c >= 97 && (int) c <= 122)) {  
                    temp[i] = new String[] { String.valueOf(srcChar[i]) };  
                } else {  
                    temp[i] = new String[] { "" };  
                } */ 
            }  
            String[] pingyinArray = Exchange(temp);  
            Set<String> zhongWenPinYin = new HashSet<String>();  
            for (int i = 0; i < pingyinArray.length; i++) {  
                zhongWenPinYin.add(pingyinArray[i]);  
            }  
            return zhongWenPinYin;  
        }  
        return null;  
    }  
  
    /**
     * Default Format 默认输出格式 
     *  
     * @Name: Pinyin4jUtil.java 
     * @return 
     */  
    public static HanyuPinyinOutputFormat getDefaultOutputFormat() {  
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();  
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 小写  
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 没有音调数字  
        format.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);// u显示  
        return format;  
    }  
  
    /**
     * @Name: Pinyin4jUtil.java 
     * @param strJaggedArray 
     * @return 
     */  
    public static String[] Exchange(String[][] strJaggedArray) {  
        String[][] temp = DoExchange(strJaggedArray);  
        return temp[0];  
    }  
  
    /**
     * @Name: Pinyin4jUtil.java 
     * @param strJaggedArray 
     * @return 
     */  
    private static String[][] DoExchange(String[][] strJaggedArray) {  
        int len = strJaggedArray.length;  
        if (len >= 2) {  
            int len1 = strJaggedArray[0].length;  
            int len2 = strJaggedArray[1].length;  
            int newlen = len1 * len2;  
            String[] temp = new String[newlen];  
            int Index = 0;  
            for (int i = 0; i < len1; i++) {  
                for (int j = 0; j < len2; j++) {  
                    temp[Index] = capitalize(strJaggedArray[0][i])  
                            + capitalize(strJaggedArray[1][j]);  
                    Index++;  
                }  
            }  
            String[][] newArray = new String[len - 1][];  
            for (int i = 2; i < len; i++) {  
                newArray[i - 1] = strJaggedArray[i];  
            }  
            newArray[0] = temp;  
            return DoExchange(newArray);  
        }else if(len == 1){  
        	String[] temp = strJaggedArray[0];
        	for (int i = 0; i < temp.length; i++) {
        		temp[i] = capitalize(temp[i]);
			}
        	strJaggedArray[0] = temp;
            return strJaggedArray;  
        }else{
        	return strJaggedArray;  
        }
    }  
  
    /**
     * 首字母大写 
     * @Name: Pinyin4jUtil.java 
     * @author: wang_chian@foxmail.com 
     * @version: Jan 13, 2012 9:36:18 AM 
     * @param s 
     * @return 
     */  
    public static String capitalize(String s) {  
        char ch[];  
        ch = s.toCharArray();  
        if (ch[0] >= 'a' && ch[0] <= 'z') {  
            ch[0] = (char) (ch[0] - 32);  
        }  
        String newString = new String(ch);  
        return newString;  
    }  
  
    /**
     * 字符串集合转换字符串(逗号分隔) 
     *  
     * @Name: Pinyin4jUtil.java 
     * @author: wang_chian@foxmail.com 
     * @version: Jan 13, 2012 9:37:57 AM 
     * @param stringSet 
     * @return 
     */  
    public static String getPinyinZh_CN(Set<String> stringSet) {  
        StringBuilder str = new StringBuilder();  
        int i = 0;  
        if(null != stringSet){
        	for (String s : stringSet) {  
        		if (i == stringSet.size() - 1) {  
        			str.append(s);  
        		} else {  
        			str.append(s + ",");  
        		}  
        		i++;  
        	}  
        	return str.toString();  
        }else{
        	return "";
        }
    }  
  
    /*
     * 获取每个拼音的简称 
     * @Name: Pinyin4jUtil.java 
     * @param chinese 
     * @return 
     */  
    public static String getPinyinConvertJianPin(String chinese) {  
        String[] strArray = chinese.split(",");  
        for (int j = 0; j < strArray.length; j++) {
        	 String strChar = ""; 
        	 char arr[] = strArray[j].toCharArray(); 
        	 for (int i = 0; i < arr.length; i++) {  
                 if (arr[i] >= 65 && arr[i] < 91) { // 判断是否是大写字母  
                     strChar += new String(arr[i] + "");  
                 }
             }
        	 strArray[j] = strChar;
		}
        
        
        //实例化一个set集合
        Set<String> set = new HashSet<String>();
        //遍历数组并存入集合,如果元素已存在则不会重复存入
        for (int i = 0; i < strArray.length; i++) {
            set.add(strArray[i]);
        }
        String restr = "";
        for (String string : set) {
        	restr += string + "|";
		}
        
        return restr.substring(0, restr.length()-1);  
       // return null;
    }  
  
    public static void main(String[] args) {  
        String str = "";  
        /*System.out.println("小写输出：" + getPinyinToLowerCase(str));  
        System.out.println("大写输出：" + getPinyinToUpperCase(str));  
        System.out.println("首字母大写输出：" + getPinyinFirstToUpperCase(str));  */
        System.out.println("简拼输出：" + getPinyinJianPin(str));  
  
    }
}
