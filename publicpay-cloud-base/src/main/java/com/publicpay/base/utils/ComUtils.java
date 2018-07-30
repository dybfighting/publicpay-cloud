package com.publicpay.base.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.stream.Collectors;

/**
 *<p>Title: 常用工具类</p>
 * <p>Description: 常用工具类</p>
 * <p>Copyriht: Copyright (c) 2012</p>
 * <p>Company: *** Co., Ltd</p>
 * @author shixy
 * @version 1.0 Date: 2012-11-27 15:42
 * (non-javadoc)
 */
public class ComUtils {

    public static final String DATE_STYLE = "yyyy-MM-dd";
    public static final String DATE_STYLE_DAY = "yyMMdd";
    public static final String DATE_STYLE_MIN = "yyyyMMddHHmm";
    public static final String TIME_STYLE = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_STYLE_SS = "yyyyMMddHHmmssSS";
    public static final String TIME_STYLE_SECOND = "yyyyMMddHHmmss";
    private static final String EXT="_ext";
    private static final String SUFFIX=".jsp";
    public static String EMPTY = "";
    public static String SEMICOLON = ";";
    private static Logger logger = LoggerFactory.getLogger(ComUtils.class);
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()+5);
    private static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    
    /**
     * null字符串转化为""
     * @param s 输入字符串
     * @return 输出字符串
     */
    public static String replaceNull2Space(String s) {
        if (s == null)
            return "";
        if (s.trim().toUpperCase().equals("NULL"))
            return "";
        return s.trim();
    }
    public static String getString(Object s) {
        if (s == null)
            return "";
        if (s.toString().trim().toUpperCase().equals("NULL"))
            return "";
        return s.toString().trim();
    }
    /**
     * 日期转字符串
     * @param dt 日期
     * @return yyyy-MM-dd类型
     */
    public static String Date2String(Date dt) {
        if (dt == null || dt.equals(""))
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_STYLE);
        try {
            return sdf.format(dt);
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * 日期转字符串
     *
     * @param dt        日期
     * @param dateStyle 类型
     * @return
     */
    public static String Date2String(Date dt, String dateStyle) {
        if (dt == null || dt.equals(""))
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat(dateStyle);
        try {
            return sdf.format(dt);
        } catch (Exception ex) {
            return "";
        }
    }
    /**
     * 时间转字符串
     * @param dt 日期类型
     * @return yyyy-MM-dd类型
     */
    public static String Time2String(Date dt) {
        if (dt == null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_STYLE);
        try {
            return sdf.format(dt);
        } catch (Exception ex) {
            return "";
        }
    }
    public static String getNO(Date dt) {
    	 if (dt == null)
             return "";
         SimpleDateFormat sdf = new SimpleDateFormat(TIME_STYLE_SS);
         try {
             return sdf.format(dt);
         } catch (Exception ex) {
             return "";
         }
    }
    /**
     * 字符串转时间
     * @param time String类型
     * @return Date
     */
    public static Date String2Time(String time) {
        if ("".equals(replaceNull2Space(time))) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(TIME_STYLE);
        Date d = null;
        if (time != null && !time.equals("")) {
            try {
                d = format.parse(time);
            } catch (Exception ex) {

            }
        }
        return d;
    }

    /**
     * 将字符串按指定的格式转换成时间
     *
     * @param time
     * @param style
     * @return
     */
    public static Date String2Time(String time, String style) {
        if ("".equals(replaceNull2Space(time))) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(style);
        Date d = null;
        if (time != null && !time.equals("")) {
            try {
                d = format.parse(time);
            } catch (Exception ex) {

            }
        }
        return d;
    }
    
    
    /**
     * 字符串转时间
     * @param date String类型
     * @return Date
     */
    public static Date String2Date(String date) {
    	if("".equals(replaceNull2Space(date))){
    		return null;
    	}
        SimpleDateFormat format = new SimpleDateFormat(DATE_STYLE);
        Date d = null;
        if (date != null && !date.equals("")) {
            try {
                d = format.parse(date);
            } catch (Exception ex) {
            }
        }
        return d;
    }
    
    /**
     * 字符串中的汉字转化成16进制的ascii编码
     * @param s
     * @return
     */
    public static String str2HexAscii(String s) {
		String str = "";
		if (s == null || s.trim().equals(""))
			return str;
		for (int i = 0; i < s.length(); i++) {
			int ch;
			String s4;
			byte[] bytes = (String.valueOf(s.charAt(i))).getBytes();
			if (bytes.length == 1) { //英文字符不转化

				s4 = String.valueOf(s.charAt(i));
			} else {
				ch = (int) s.charAt(i);
				s4 = "\\u" + Integer.toHexString(ch);
			}
			str = str + s4;
		}
		return str;
	}  
    
    /**
     * 隐藏字符窜的一些信息
     * @param s
     * @return
     */
    public static String hideSomeInfo(String s) {
    	try {
    		StringBuffer sb  = new StringBuffer();
    		String split = "*";
    		if (s != null && s.length() > 5) {
    			int end = s.length()-4;//倒数第5位的正向位置
    			int start = 2;//默认正数第2位
    			if (end > 4) start = end - 3;
    			
    			char[] chars = s.toCharArray();
    			for (int i = 0; i < s.length(); i++) {
    				int t = i + 1;
    				if (t < start || t > end) {
    					sb.append(chars[i]);
    				} else {
    					sb.append(split);
    				}
    			}
    		} else {
    			return s;
    		}
    		return sb.toString();
    	} catch (Exception ex) {
    		return s;
    	}
    }
    
    /**
     * 对传入的Map内容进行升序排列
     * @param paramsMap
     * @return
     */
    public static String sortStr(Map<String, Object> paramsMap) {
        if (paramsMap != null && !paramsMap.isEmpty()){
            ArrayList<String> paramNames = new ArrayList<>(paramsMap.keySet());
            Collections.sort(paramNames);
            StringBuilder signSource = new StringBuilder();
            Iterator<String> iterator = paramNames.iterator();
            while (iterator.hasNext()) {
                String paramName = iterator.next();
                if (StringUtils.isNotBlank(ComUtils.replaceNull2Space(paramsMap.get(paramName) + ""))) {
                    signSource.append(paramName).append("=").append(paramsMap.get(paramName) + "");
                    if (iterator.hasNext()) {
                        signSource.append("&");
                    }
                }
            }
            String signSourceStr = signSource.toString();
            if (signSourceStr.endsWith("&")) 
            	signSourceStr = signSourceStr.substring(0, signSourceStr.length()-1);
            return signSourceStr;
        }
        return "";
    }

    public static String hideCardNo(String s) {

        return s.substring(0, 6) + "****" + s.substring(6, 10);
    }

    /**
     * 得到线程池
     * @return
     */
    public static ExecutorService getFixedThreadPool() {
        return executor;
    }

    /**
     * 得到调度对象
     */
    public static ScheduledExecutorService getSingleThreadScheduledExecutor() {
        return executorService;
    }
    
    /**
     * 获取调用者Code
     * @param callerType
     * @param callerCode
     * @return
     */
    public static String getCallerCode(String callerType, String callerCode) {
    	String code = "";
    	
    	if ("USER".equals(callerType)) {
    		code = "USER";
    	} else {
    		if (StringUtils.isNotBlank(callerCode)) {
    			code = callerCode;
    		}
    	}
    	
    	return code;
    }
    
    /**
     * 根据传入的json窜和key得到对应的value
     * @param json
     * @param key
     * @return
     */
    public static String getValue(String json, String key) {
    	String value = "";
    	if (StringUtils.isNotBlank(json) && StringUtils.isNotBlank(key)) {
    		Map<String, String> contentObj = JsonHelper.parseJsonStr(json, new TypeReference<Map<String, String>>(){});
    		if (contentObj != null && !contentObj.isEmpty()) {
    			value = contentObj.get(key);
    		}
    	}
    	return value;
    }

    /**
     * 把map中的包含"_"的key转换成驼峰命名的key
     * @param map
     * @return
     * @auth : minchao.du
     */
    public static Map<String, String> convertMapKey(Map<String, String> map){
        Map resultMap = new HashMap<>();
        for (Map.Entry<String, String> entry :map.entrySet() ) {
            String keyValue = entry.getKey();
            String newKey = "";
            if (StringUtils.isNotBlank(keyValue)){
                // 把String进行分割后首字母大写
                newKey = Arrays.stream(keyValue.split("_"))
                            .map((key) -> key.toLowerCase().substring(0, 1).toUpperCase() + key.substring(1))
                            .collect(Collectors.joining());
                newKey = newKey.substring(0, 1).toLowerCase() + newKey.substring(1);
            }else{
                newKey = keyValue;
            }
            resultMap.put(newKey, entry.getValue());
        }
        return resultMap;
    }

    /**
     * 得到解密后的内容
     * @param request
     * @return
     */
    public static String getDecryptConent(HttpServletRequest request) {
    	return ComUtils.replaceNull2Space(request.getAttribute("decryptContent")+"");
    }

    public static void main(String[] args) {
    	//String str = "1234567890";
    	//String newStr = ComUtils.hideCardNo(str);
    	String str = "123456789&";
    	if (str.endsWith("&")) str = str.substring(0, str.length()-1);
    	System.out.println("===新窜为:"+str);
    }
}
