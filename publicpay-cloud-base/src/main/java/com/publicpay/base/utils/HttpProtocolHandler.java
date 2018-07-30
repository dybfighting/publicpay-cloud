package com.publicpay.base.utils;

import com.publicpay.base.beans.HttpClientResult;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 基于HttpClient第三方工具的http工具类
 * @author yanfei.zhao
 * @since 2018年6月25日
 */
public class HttpProtocolHandler {

	private static Logger logger = LoggerFactory.getLogger(HttpProtocolHandler.class);

	private static final String DEFAULT_CHARSET = "UTF-8";
	// 设置连接超时时间，单位毫秒。
	private final int CONNECT_TIMEOUT = 10000;

	// 请求获取数据的超时时间(即响应时间)，单位毫秒。
	private static final int SOCKET_TIMEOUT = 10000;

	// HTTP连接池大小
	private static final int POOL_SIZE = 30;

	private static final String HTTP = "http";

	private static final String HTTPS = "https";

	private boolean proxySwitch;
	private String proxyIp;
	private int proxyPort;

	// 统一配置
	private static PoolingHttpClientConnectionManager connectionManager;
	private static RequestConfig requestConfig;

	private HttpProtocolHandler(boolean proxySwitch, String proxyIp, int proxyPort) {

		// 设置连接池
		connectionManager = new PoolingHttpClientConnectionManager();
		// 设置连接池大小
		connectionManager.setMaxTotal(POOL_SIZE);
		connectionManager.setDefaultMaxPerRoute(connectionManager.getMaxTotal());
		connectionManager.setValidateAfterInactivity(1000);

		RequestConfig.Builder configBuilder = RequestConfig.custom();
		// 连接上服务器(握手成功)的时间，超出该时间抛出connect timeout
		configBuilder.setConnectTimeout(CONNECT_TIMEOUT);
		// 服务器返回数据(response)的时间，超过该时间抛出read timeout
		configBuilder.setSocketTimeout(SOCKET_TIMEOUT);
		// 从连接池中获取连接的超时时间，超过该时间未拿到可用连接，会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for connection from pool
		configBuilder.setConnectionRequestTimeout(CONNECT_TIMEOUT);

		requestConfig = configBuilder.build();

		this.proxySwitch = proxySwitch;
		this.proxyIp = proxyIp;
		this.proxyPort = proxyPort;
	}

	private static volatile HttpProtocolHandler httpProtocolHandler;

	public static HttpProtocolHandler getInstance(boolean proxySwitch, String proxyIp, int proxyPort) {

		if (httpProtocolHandler == null) {
			synchronized (HttpProtocolHandler.class) {
				if (httpProtocolHandler == null) {
					httpProtocolHandler = new HttpProtocolHandler(proxySwitch, proxyIp, proxyPort);
				}
			}
		}
		return httpProtocolHandler;
	}

	/**
	 * 发送get请求不带参数
	 * @param url
	 * @return
	 */
	public HttpClientResult sendGet(String url) {

		return sendGet(url, null, null);
	}

	/**
	 * 发送get请求
	 * @param url
	 * @param map
	 * @return
	 */
	public HttpClientResult sendGet(String url, Map<String, String> headers, Map<String, String> params) {

		CloseableHttpClient httpClient = null;

		if (proxySwitch) {
			httpClient = HttpClients.custom().setProxy(getProxy(url)).setConnectionManager(connectionManager).setDefaultRequestConfig(requestConfig)
					.setConnectionManagerShared(true).build();
		} else {
			httpClient = HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(requestConfig).build();
		}

		CloseableHttpResponse httpResponse = null;
		try {
			// 创建访问的地址
			URIBuilder uriBuilder = new URIBuilder(url);
			if (params != null) {
				Set<Entry<String, String>> entrySet = params.entrySet();
				for (Entry<String, String> entry : entrySet) {
					uriBuilder.setParameter(entry.getKey(), entry.getValue());
				}
			}

			// 创建GET请求方法的实例，并填充url
			HttpGet httpGet = new HttpGet(uriBuilder.build());
			httpGet.setConfig(requestConfig);
			// 设置请求头
			packageHeader(headers, httpGet);
			// 发送（执行）请求
			httpResponse = httpClient.execute(httpGet);
			return getHttpClientResult(httpResponse, httpClient, httpGet);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			release(httpResponse);
		}
		return new HttpClientResult(HttpStatus.SC_INTERNAL_SERVER_ERROR);
	}

	/**
	 * 发送post请求
	 * @param url
	 * @param map
	 * @return
	 */
	public HttpClientResult sendPost(String url, Map<String, String> headers, Map<String, String> params) {

		CloseableHttpClient httpClient = null;
		if (proxySwitch) {
			httpClient = HttpClients.custom().setProxy(getProxy(url)).setConnectionManager(connectionManager).setDefaultRequestConfig(requestConfig)
					.setConnectionManagerShared(true).build();
		} else {
			httpClient = HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(requestConfig).setConnectionManagerShared(true)
					.build();
		}
		// 创建请求方法实例，填充url
		HttpPost httpPost = new HttpPost(url);
		httpPost.setConfig(requestConfig);
		CloseableHttpResponse httpResponse = null;
		try {
			// 设置请求头
			packageHeader(headers, httpPost);
			packageParam(params, httpPost);
			// 发送（执行）
			httpResponse = httpClient.execute(httpPost);
			return getHttpClientResult(httpResponse, httpClient, httpPost);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			release(httpResponse);
		}
		return new HttpClientResult(HttpStatus.SC_INTERNAL_SERVER_ERROR);
	}

	/**
	 * 发送put请求
	 * @param url
	 * @param map
	 * @return
	 */
	public HttpClientResult sendPut(String url, Map<String, String> headers, Map<String, String> params) {

		CloseableHttpClient httpClient = null;
		if (proxySwitch) {
			httpClient = HttpClients.custom().setProxy(getProxy(url)).setConnectionManager(connectionManager).setDefaultRequestConfig(requestConfig)
					.setConnectionManagerShared(true).build();
		} else {
			httpClient = HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(requestConfig).setConnectionManagerShared(true)
					.build();
		}

		CloseableHttpResponse httpResponse = null;
		try {
			// 创建访问的地址
			URIBuilder uriBuilder = new URIBuilder(url);
			if (params != null) {
				Set<Entry<String, String>> entrySet = params.entrySet();
				for (Entry<String, String> entry : entrySet) {
					uriBuilder.setParameter(entry.getKey(), entry.getValue());
				}
			}
			// 创建请求方法实例并填充url
			HttpPut httpPut = new HttpPut(uriBuilder.build());
			httpPut.setConfig(requestConfig);
			// 设置请求头
			packageHeader(headers, httpPut);
			httpResponse = httpClient.execute(httpPut);
			return getHttpClientResult(httpResponse, httpClient, httpPut);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			release(httpResponse);
		}
		return new HttpClientResult(HttpStatus.SC_INTERNAL_SERVER_ERROR);
	}

	/**
	 * 发送delete请求
	 * @param url
	 * @return
	 */
	public HttpClientResult sendDelete(String url, Map<String, String> headers, Map<String, String> params) {

		CloseableHttpClient httpClient = null;
		if (proxySwitch) {
			httpClient = HttpClients.custom().setProxy(getProxy(url)).setConnectionManager(connectionManager).setDefaultRequestConfig(requestConfig)
					.setConnectionManagerShared(true).build();
		} else {
			httpClient = HttpClients.custom().setConnectionManager(connectionManager).setDefaultRequestConfig(requestConfig).setConnectionManagerShared(true)
					.build();
		}

		CloseableHttpResponse httpResponse = null;
		// 执行
		try {
			// 创建访问的地址
			URIBuilder uriBuilder = new URIBuilder(url);
			if (params != null) {
				Set<Entry<String, String>> entrySet = params.entrySet();
				for (Entry<String, String> entry : entrySet) {
					uriBuilder.setParameter(entry.getKey(), entry.getValue());
				}
			}
			// 创建方法实例
			HttpDelete httpDelete = new HttpDelete(uriBuilder.build());
			httpDelete.setConfig(requestConfig);
			// 设置请求头
			packageHeader(headers, httpDelete);
			httpResponse = httpClient.execute(httpDelete);
			return getHttpClientResult(httpResponse, httpClient, httpDelete);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			release(httpResponse);
		}
		return new HttpClientResult(HttpStatus.SC_INTERNAL_SERVER_ERROR);
	}

	/**
	 * Description: 封装请求头
	 * @param params
	 * @param httpMethod
	 */
	public static void packageHeader(Map<String, String> headers, HttpRequestBase httpMethod) {
		// 封装请求头
		if (headers != null) {
			Set<Entry<String, String>> entrySet = headers.entrySet();
			for (Entry<String, String> entry : entrySet) {
				// 设置到请求头到HttpRequestBase对象中
				httpMethod.setHeader(entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * Description: 封装请求参数
	 * @param params
	 * @param httpMethod
	 * @throws UnsupportedEncodingException
	 */
	public static void packageParam(Map<String, String> params, HttpEntityEnclosingRequestBase httpMethod) throws UnsupportedEncodingException {

		if (httpMethod instanceof HttpPut) {
			// 设置到请求的http对象中
			StringEntity stringEntity = new StringEntity(JsonHelper.toJsonStr(params), DEFAULT_CHARSET);
			httpMethod.setEntity(stringEntity);
		}
		// 封装请求参数
		if (params != null) {
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			Set<Entry<String, String>> entrySet = params.entrySet();
			for (Entry<String, String> entry : entrySet) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}

			// 设置到请求的http对象中
			httpMethod.setEntity(new UrlEncodedFormEntity(nvps, DEFAULT_CHARSET));
		}
	}

	/**
	 * Description: 获得响应结果
	 * @param httpResponse
	 * @param httpClient
	 * @param httpMethod
	 * @return
	 * @throws Exception
	 */
	public static HttpClientResult getHttpClientResult(CloseableHttpResponse httpResponse, CloseableHttpClient httpClient, HttpRequestBase httpMethod)
			throws Exception {

		// 获取返回结果
		if (httpResponse != null && httpResponse.getStatusLine() != null) {
			int statusCode = httpResponse.getStatusLine().getStatusCode();
			logger.info("执行状态码:{}", statusCode); // 获取响应内容
			String content = "";
			if (httpResponse.getEntity() != null) {
				InputStream instream = httpResponse.getEntity().getContent();
				BufferedReader in = new BufferedReader(new InputStreamReader(instream, DEFAULT_CHARSET));
				StringBuffer buffer = new StringBuffer();
				String line = "";
				while ((line = in.readLine()) != null) {
					buffer.append(line);
				}
				content = buffer.toString();
			}
			return new HttpClientResult(httpResponse.getStatusLine().getStatusCode(), content);
		}
		return new HttpClientResult(HttpStatus.SC_INTERNAL_SERVER_ERROR);
	}

	/**
	 * Description: 释放资源
	 * @param httpResponse
	 * @param httpClient
	 * @throws IOException
	 */
	public static void release(CloseableHttpResponse httpResponse) {
		// 释放资源
		try {
			if (httpResponse.getEntity() != null) {
				EntityUtils.consume(httpResponse.getEntity());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private HttpHost getProxy(String url) {
		HttpHost proxy = null;
		if (url.startsWith(HTTP)) {
			proxy = new HttpHost(proxyIp, proxyPort, HTTP);
		} else if (url.startsWith(HTTPS)) {
			proxy = new HttpHost(proxyIp, proxyPort, HTTPS);
		}
		return proxy;
	}
}
