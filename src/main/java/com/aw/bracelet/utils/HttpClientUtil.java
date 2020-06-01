package com.aw.bracelet.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.*;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * HTTPCLIENT4 带连接池的HTTP/HTTPS请求工具类
 * 
 * @author SHI CHANGGEN
 * @since 2016-02-26
 */
public class HttpClientUtil {

	private final static Log logger = LogFactory.getLog(HttpClientUtil.class);

	private static PoolingHttpClientConnectionManager connManager = null;
	private static CloseableHttpClient httpclient = null;

	static {
		try {
			// SSLContext sslContext = SSLContexts.custom().useTLS().build();
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, new TrustManager[] { new X509TrustManager() {

				//@Override
				public X509Certificate[] getAcceptedIssuers() {
					// TODO Auto-generated method stub
					return null;
				}

				//@Override
				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					// TODO Auto-generated method stub

				}

				//@Override
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					// TODO Auto-generated method stub

				}
			} }, null);

			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
					.<ConnectionSocketFactory> create().register("http", PlainConnectionSocketFactory.INSTANCE)
					.register("https", new SSLConnectionSocketFactory(sslContext)).build();

			connManager = new PoolingHttpClientConnectionManager(socketFactoryRegistry);

			// 请求重试处理
			HttpRequestRetryHandler retryHandler = new HttpRequestRetryHandler() {

				//@Override
				public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
					logger.info("第" + executionCount + "次请求......");
					if (executionCount >= 5) {// 如果已经重试了5次，就放弃
						return false;
					}
					if (exception instanceof NoHttpResponseException) {// 如果服务器丢掉了连接，那么就重试
						return true;
					}
					if (exception instanceof SSLHandshakeException) {// 不要重试SSL握手异常
						return false;
					}
					if (exception instanceof InterruptedIOException) {// 超时
						return false;
					}
					if (exception instanceof UnknownHostException) {// 目标服务器不可达
						return false;
					}
					if (exception instanceof ConnectTimeoutException) {// 连接被拒绝
						return false;
					}
					if (exception instanceof SSLException) {// SSL握手异常
						return false;
					}

					HttpClientContext clientContext = HttpClientContext.adapt(context);
					HttpRequest request = clientContext.getRequest();
					// 如果请求是幂等的，就再次尝试
					if (!(request instanceof HttpEntityEnclosingRequest)) {
						return true;
					}
					return false;
				}

			};

			// 是否使用代理设置。如果使用，设置代理服务器认证用户
			/*if ("1".equals(Constant.HttpClientSetting.proxySwich)) {
				CredentialsProvider credsProvider = new BasicCredentialsProvider();
				credsProvider.setCredentials(new AuthScope(Constant.HttpClientSetting.proxyIp,
						Constant.HttpClientSetting.proxyPort), // 可以访问的范围
						new UsernamePasswordCredentials(Constant.HttpClientSetting.proxyUserName,
								Constant.HttpClientSetting.proxyPassword));// 用户名和密码
				httpclient = HttpClients.custom().setConnectionManager(connManager)
						.setSSLHostnameVerifier(new HostnameVerifier() {

							//@Override
							public boolean verify(String arg0, SSLSession arg1) {
								return true;
							}
						}).setDefaultCredentialsProvider(credsProvider).build();
			} else {*/
				// httpclient =
				// HttpClients.custom().setConnectionManager(connManager).setRetryHandler(retryHandler).build();
				httpclient = HttpClients.custom().setConnectionManager(connManager).build();
			//}

			// Create socket configuration
			SocketConfig socketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
			connManager.setDefaultSocketConfig(socketConfig);

			// Create message constraints
			MessageConstraints messageConstraints = MessageConstraints.custom().setMaxHeaderCount(200)
					.setMaxLineLength(2000).build();

			// Create connection configuration
			ConnectionConfig connectionConfig = ConnectionConfig.custom()
					.setMalformedInputAction(CodingErrorAction.IGNORE)
					.setUnmappableInputAction(CodingErrorAction.IGNORE).setCharset(Consts.UTF_8)
					.setMessageConstraints(messageConstraints).build();
			connManager.setDefaultConnectionConfig(connectionConfig);
			connManager.setMaxTotal(200);
			connManager.setDefaultMaxPerRoute(20);
		} catch (KeyManagementException e) {
			logger.error("KeyManagementException", e);
		} catch (NoSuchAlgorithmException e) {
			logger.error("NoSuchAlgorithmException", e);
		}
	}
	@SuppressWarnings("deprecation")
	public static String invokeGet(String url, Map<String, String> params, String encode, int connectTimeout,
			int soTimeout) {
		//HttpHost proxy = new HttpHost(Constant.HttpClientSetting.proxyIp, Constant.HttpClientSetting.proxyPort);
		String responseString = null;
		RequestConfig requestConfig = null;

		/*if ("1".equals(Constant.HttpClientSetting.proxySwich)) {
			logger.info("使用代理服务器访问网络invokeGet:" + Constant.HttpClientSetting.proxyIp + ",目标地址:" + url);
			requestConfig = RequestConfig.custom().setProxy(proxy).setSocketTimeout(180000)
					.setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectTimeout)
					.setExpectContinueEnabled(false).build();
		} else {*/
			requestConfig = RequestConfig.custom().setSocketTimeout(connectTimeout).setConnectTimeout(connectTimeout)
					.setConnectionRequestTimeout(connectTimeout).setExpectContinueEnabled(false).build();
		//}

		StringBuilder sb = new StringBuilder();
		sb.append(url);
		int i = 0;
		for (Entry<String, String> entry : params.entrySet()) {
			if (i == 0 && !url.contains("?")) {
				sb.append("?");
			} else {
				sb.append("&");
			}
			sb.append(entry.getKey());
			sb.append("=");
			String value = entry.getValue();
			try {
				sb.append(URLEncoder.encode(value, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				logger.warn("encode http get params error, value is " + value, e);
				sb.append(URLEncoder.encode(value));
			}
			i++;
		}
		logger.info("[HttpUtils Get] begin invoke:" + sb.toString());
		HttpGet get = new HttpGet(sb.toString());
		get.setConfig(requestConfig);

		try {
			CloseableHttpResponse response = httpclient.execute(get);
			try {
				HttpEntity entity = response.getEntity();
				try {
					if (entity != null) {
						responseString = EntityUtils.toString(entity, encode);
					}
				} finally {
					if (entity != null) {
						entity.getContent().close();
					}
				}
			} catch (Exception e) {
				logger.error(String.format("[HttpUtils Get]get response error, url:%s", sb.toString()), e);
				return responseString;
			} finally {
				if (response != null) {
					response.close();
				}
			}
			logger.info(String.format("[HttpUtils Get]Debug url:%s , response string %s:", sb.toString(),
					responseString));
		} catch (SocketTimeoutException e) {
			logger.error(String.format("[HttpUtils Get]invoke get timout error, url:%s", sb.toString()), e);
			return responseString;
		} catch (Exception e) {
			logger.error(String.format("[HttpUtils Get]invoke get error, url:%s", sb.toString()), e);
		} finally {
			get.releaseConnection();
		}
		return responseString;
	}
	public final static int connectTimeout = 5000;

	/**
	 * HTTPS请求，默认超时为5S
	 * 
	 */
	public static String connectPostHttps(String reqURL, Map<String, String> params, String encode) {
		if(StringUtils.isEmpty(encode)){
			encode =  "UTF-8";
		}
		//HttpHost proxy = new HttpHost(Constant.HttpClientSetting.proxyIp, Constant.HttpClientSetting.proxyPort);
		String responseContent = null;
		HttpPost httpPost = new HttpPost(reqURL);
		try {
			RequestConfig requestConfig = null;
			/*if ("1".equals(Constant.HttpClientSetting.proxySwich)) {
				logger.info("使用代理服务器访问网络connectPostHttps:" + Constant.HttpClientSetting.proxyIp + ",目标地址:" + reqURL);
				requestConfig = RequestConfig.custom().setProxy(proxy).setSocketTimeout(connectTimeout)
						.setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectTimeout).build();
			} else {*/
				requestConfig = RequestConfig.custom().setSocketTimeout(connectTimeout)
						.setConnectTimeout(connectTimeout).setConnectionRequestTimeout(connectTimeout).build();
			//}

			List<NameValuePair> formParams = new ArrayList<NameValuePair>();
			// 绑定到请求 Entry
			for (Entry<String, String> entry : params.entrySet()) {
				formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
			httpPost.setEntity(new UrlEncodedFormEntity(formParams, Charset.forName(encode)));
			httpPost.setConfig(requestConfig);

			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				// 执行POST请求
				HttpEntity entity = response.getEntity(); // 获取响应实体
				try {
					if (null != entity) {
						responseContent = EntityUtils.toString(entity, Charset.forName(encode));
					}
				} finally {
					if (entity != null) {
						entity.getContent().close();
					}
				}
			} finally {
				if (response != null) {
					response.close();
				}
			}
			logger.info("requestURI : " + httpPost.getURI() + ", responseContent: " + responseContent);
		} catch (ClientProtocolException e) {
			logger.error("ClientProtocolException", e);
		} catch (IOException e) {
			logger.error("IOException", e);
		} finally {
			httpPost.releaseConnection();
		}
		return responseContent;
	}

	public static void main(String[] args) {
		String uri = "https://query.do";
		Map<String, String> params = new HashMap<String, String>();
		String result = HttpClientUtil.connectPostHttps(uri, params, "UTF-8");
		System.out.println(result);
	}

}