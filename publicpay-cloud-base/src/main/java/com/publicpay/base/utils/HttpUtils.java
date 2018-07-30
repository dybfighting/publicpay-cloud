//package com.publicpay.base.utils;
//
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLEngine;
//import javax.net.ssl.SSLSession;
//import java.io.*;
//import java.net.InetSocketAddress;
//import java.net.Proxy;
//import java.security.cert.CertificateException;
//import java.security.cert.X509Certificate;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * http 工具类
// * @author minchao.du
// */
//public class HttpUtils {
//
//	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);
//
//	private static final int CONNECT_TIME_OUT = 10000;
//
//	private static final int READ_TIME_OUT = 10000;
//
//	public static String sendGet(String url, String param){
//		String response = sendGet(url, param, false, null, null, CONNECT_TIME_OUT, READ_TIME_OUT);
//		return response;
//	}
//
//	public static String sendGetProxy(String url, String param , String proxyHost, Integer proxyPort){
//		String response = sendGet(url, param, true, proxyHost, proxyPort, CONNECT_TIME_OUT, READ_TIME_OUT);
//		return response;
//	}
//
//	public static String sendPost(String url , Map<String, String> params){
//		String response = sendPost(url, params, false, null, null);
//		return  response;
//	}
//
//	public static String sendPostProxy(String url , Map<String, String> params, String proxyHost, Integer proxyPort){
//		String response = sendPost(url, params, true, proxyHost, proxyPort);
//		return response;
//	}
//
//	/**
//	 * GET请求
//	 *
//	 * @param url
//	 *            请求的URL
//	 * @param param
//	 *            请求参数，name1=value1&name2=value2 的形式
//	 * @return 响应结果
//	 */
//	private static String sendGet(String url, String param, boolean isproxy , String proxyHost, Integer proxyPort, int ConnectTimeOut, int readTimeOut) {
//		String result = "";
//		BufferedReader in = null;
//		HttpURLConnection connection = null;
//		try {
//			if (StringUtils.isNotBlank(param))
//				url = url + "?" + param;
//			URL realUrl = new URL(url);
//			logger.info("请求的url路径为： {}", url);
//			if (isproxy) {// 使用代理模式
//				Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(proxyHost, proxyPort));
//				connection = (HttpURLConnection) realUrl.openConnection(proxy);
//			} else {
//				connection = (HttpURLConnection) realUrl.openConnection();
//			}
//
//			// https 忽略证书验证
//			if (url.substring(0, 5).equals("https")) {
//				SSLContext ctx = MyX509TrustManagerUtils();
//				((HttpsURLConnection) connection).setSSLSocketFactory(ctx.getSocketFactory());
//				((HttpsURLConnection) connection).setHostnameVerifier(new HostnameVerifier() {
//					@Override
//					public boolean verify(String arg0, SSLSession arg1) {
//						return true;
//					}
//				});
//			}
//
//			connection.setConnectTimeout(ConnectTimeOut);
//			connection.setReadTimeout(readTimeOut);
//
//			connection.connect();	// 建立连接
//			// 定义 BufferedReader输入流来读取URL的响应
//			if (connection.getResponseCode() == HttpURLConnection.HTTP_OK
//					|| connection.getResponseCode() == HttpURLConnection.HTTP_CREATED
//					|| connection.getResponseCode() == HttpURLConnection.HTTP_ACCEPTED) {
//				in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
//			} else {
//				in = new BufferedReader(new InputStreamReader(connection.getErrorStream(), "UTF-8"));
//			}
//			String line;
//			while ((line = in.readLine()) != null) {
//				result += line;
//			}
//		} catch (Exception e) {
//			logger.info("发送GET请求出现异常, {}", e);
//		}
//		// 使用finally块来关闭输入流
//		finally {
//			try {
//				if (in != null) {
//					in.close();
//				}
//			} catch (Exception e) {
//				logger.info("关闭输入流抛出异常， {}", e);
//			}
//		}
//		return result;
//	}
//
//	/**
//	 * POST请求
//	 *
//	 * @param url
//	 *            发送请求的 URL
//	 * @param paramMap
//	 *            请求参数 name1=value1&name2=value2 的形式
//	 * @param isproxy
//	 *            是否使用代理模式
//	 * @return 响应结果
//	 */
//	private static String sendPost(String url, Map<String,String> paramMap, boolean isproxy, String proxyHost, Integer proxyPort) {
//		OutputStreamWriter out = null;
//		BufferedReader in = null;
//		String result = "";
//		String param = "";
//		StringBuilder paramTemp = new StringBuilder("");
//
//		for (Map.Entry<String, String> paramItem : paramMap.entrySet()) {
//			String key = paramItem.getKey();
//			String value = paramItem.getValue();
//			if (org.apache.commons.lang3.StringUtils.isNotBlank(value)) {
//				paramTemp.append(key).append("=").append(value).append("&");
//			}
//		}
//
//		param = paramTemp.toString();
//		param = param.substring(0,param.length()-1);
//		System.out.println(param);
//
//		try {
//			URL realUrl = new URL(url);
//			HttpURLConnection conn = null;
//			if (isproxy) {// 使用代理模式
//				@SuppressWarnings("static-access")
//				Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress(proxyHost, proxyPort));
//				conn = (HttpURLConnection) realUrl.openConnection(proxy);
//			} else {
//				conn = (HttpURLConnection) realUrl.openConnection();
//			}
//
//			// https
//			if (url.substring(0, 5).equals("https")) {
//				SSLContext ctx = MyX509TrustManagerUtils();
//				((HttpsURLConnection) conn).setSSLSocketFactory(ctx.getSocketFactory());
//				((HttpsURLConnection) conn).setHostnameVerifier(new HostnameVerifier() {
//					//在握手期间，如果 URL 的主机名和服务器的标识主机名不匹配，则验证机制可以回调此接口的实现程序来确定是否应该允许此连接。
//					@Override
//					public boolean verify(String arg0, SSLSession arg1) {
//						return true;
//					}
//				});
//			}
//
//			// 发送POST请求必须设置如下两行
//			conn.setDoOutput(true);
//			conn.setDoInput(true);
//			conn.setRequestMethod("POST"); // POST方法
//
//			conn.connect();
//
//			// 获取URLConnection对象对应的输出流
//			out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
//			// 发送请求参数
//			out.write(param);
//			// flush输出流的缓冲
//			out.flush();
//			// 定义BufferedReader输入流来读取URL的响应
//			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK
//					|| conn.getResponseCode() == HttpURLConnection.HTTP_CREATED
//					|| conn.getResponseCode() == HttpURLConnection.HTTP_ACCEPTED) {
//				in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
//			} else {
//				in = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
//			}
//			String line;
//			while ((line = in.readLine()) != null) {
//				result += line;
//			}
//		} catch (Exception e) {
//			System.out.println("发送 POST 请求出现异常！");
//			e.printStackTrace();
//		}
//		// 使用finally块来关闭输出流、输入流
//		finally {
//			try {
//				if (out != null) {
//					out.close();
//				}
//				if (in != null) {
//					in.close();
//				}
//			} catch (IOException ex) {
//				ex.printStackTrace();
//			}
//		}
//		return result;
//	}
//
//	// ===========================utils===================
//
//	/**
//	 * url编码
//	 *
//	 * @param source
//	 *            待编码字符串
//	 * @param encode
//	 *            字符编码 eg:UTF-8
//	 * @return 编码字符串
//	 */
//	public static String urlEncode(String source, String encode) {
//		String result = source;
//		try {
//			result = URLEncoder.encode(source, encode);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//			return "0";
//		}
//		return result;
//	}
//
//	/*
//     * HTTPS忽略证书验证,防止高版本jdk因证书算法不符合约束条件,使用继承X509ExtendedTrustManager的方式
//     */
//	class MyX509TrustManager extends X509ExtendedTrustManager {
//
//		@Override
//		public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
//			// TODO Auto-generated method stub
//		}
//
//		@Override
//		public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
//			// TODO Auto-generated method stub
//		}
//
//		@Override
//		public X509Certificate[] getAcceptedIssuers() {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		@Override
//		public void checkClientTrusted(X509Certificate[] arg0, String arg1, Socket arg2) throws CertificateException {
//			// TODO Auto-generated method stub
//		}
//
//		@Override
//		public void checkClientTrusted(X509Certificate[] arg0, String arg1, SSLEngine arg2)
//				throws CertificateException {
//			// TODO Auto-generated method stub
//		}
//
//		@Override
//		public void checkServerTrusted(X509Certificate[] arg0, String arg1, Socket arg2) throws CertificateException {
//			// TODO Auto-generated method stub
//		}
//
//		@Override
//		public void checkServerTrusted(X509Certificate[] arg0, String arg1, SSLEngine arg2)
//				throws CertificateException {
//			// TODO Auto-generated method stub
//		}
//
//	}
//
//	public static SSLContext MyX509TrustManagerUtils() {
//
//		TrustManager[] tm = { new HttpUtils().new MyX509TrustManager() };
//		SSLContext ctx = null;
//		try {
//			ctx = SSLContext.getInstance("TLS");
//			ctx.init(null, tm, null);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return ctx;
//	}
//
//	public static void main(String[] args) {
//
//		String url = "https://ipos.cardinfo.com.cn/iposcloudgate/facilitatorservice/pos/getPos";
//		Map<String, String> params = new HashMap<>();
//		params.put("sn", "7792017081100005");
//		params.put("sign", "4534494E958118036D13");
//
//		String getResult = HttpUtils.sendPost(url, params, false, null, null);
//		System.out.println(getResult);
//	}
//}
