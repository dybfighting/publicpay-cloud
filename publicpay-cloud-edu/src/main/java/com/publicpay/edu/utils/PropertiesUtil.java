package com.publicpay.edu.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 读取.properties类型的配置文件帮助类
 * @author chenchen.qi
 *
 */
public class PropertiesUtil {
	private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class) ;
	
	/**
	 * 获取Properties对象，该对象加载了classpath路径下指定文件名的文件
	 * @param fileName 文件名称
	 * @return	读取指定文件名称的Properties对象
	 */
	public static Properties getProperties(String fileName){
		
		InputStream in = null;
		Properties prop = null;
		
		try {
			in = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);//没有则返回null
			prop = new Properties();
			prop.load(in);
		}catch (IOException e) {
			logger.error("method=getProperties,{fileName="+fileName+"},{There is a error when loading the file of the fileName.}",e);
		}finally{
			SourceReleaseUtil.release(in, null, null, null);
		}
		
		return prop;
	}
}
