package com.publicpay.alipay.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 资源释放的帮助类
 * @author chenchen.qi
 *
 */
public class SourceReleaseUtil {

	private static final Logger logger = LoggerFactory.getLogger(SourceReleaseUtil.class) ;
	
	/**
	 * 释放资源
	 * @param in	输入流对象
	 * @param out	输出流对象
	 * @param s		Socket对象
	 * @param ss	ServerSocket对象
	 */
	public static void release(InputStream in,OutputStream out,Socket s,ServerSocket ss){
		
		if(in != null){
			try{
				in.close();
			}catch(IOException e){
				logger.error("method=release,{There is a error when closing the InputStream.}",e);
			}
			in = null;
		}
		if(out != null){
			try{
				out.close();
			}catch(IOException e){
				logger.error("method=release,{There is a error when closing the OutputStream.}",e);
			}
			out = null;
		}
		if(s != null){
			try{
				logger.info("method=release,{The socket is closed.}");
				s.close();
			}catch(IOException e){
				logger.error("method=release,{There is a error when closing the Socket.}",e);
			}
			s = null;
		}
		if(ss != null){
			try{
				logger.info("method=release,{The serversocket is closed.}");
				ss.close();
			}catch(IOException e){
				logger.error("method=release,{There is a error when closing the ServerSocket.}",e);
			}
			ss = null;
		}
	}
}