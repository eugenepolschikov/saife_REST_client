package com.saife.dashboard.client.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.saife.dashboard.client.common.SaifeClientException;
import com.saife.dashboard.client.common.SaifeDashboardError;
import com.saife.dashboard.client.common.SaifeDashboardException;

public class HttpMethodInvoker {

	private static final String CHARSET = "UTF-8";

	// TODO for multithreading a pool of clients is needed
	private static HttpClient client = HttpClientBuilder.create().build();

	public static <T> T invoke (Class<T>result) throws SaifeClientException, SaifeDashboardException {
		
		HttpMethodData httpMethodData = SaifeClientProxy.getHttpMethodData();
		if (httpMethodData == null) {
			throw new SaifeClientException("HTTP request data is not initialized.");
		} 

		HttpRequestBase req = getHttpRequest(httpMethodData.getMethod());
		req.addHeader("Authorization", "Basic " + Base64.encodeBase64String(httpMethodData.getApiKey().getBytes()));

// TODO: use proxy config 
//		HttpHost proxy = new HttpHost("localhost", 8888, );
//		RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
//		req.setConfig(config);


		String uri;
		try {
			uri = buildUriAndParameters(httpMethodData.getEndpoint(), req, httpMethodData.getParameters());
		} catch (UnsupportedEncodingException ex) {
			throw new SaifeClientException(ex.getMessage(), ex);
		}
		try {
			req.setURI(new URI(uri));
		} catch (URISyntaxException ex) {
			throw new SaifeClientException("Could not make URI from: " + uri, ex);
		}

		try {
			String responseBody = client.execute(req, new ResponseHandler<String>() {
				@Override
				public String handleResponse(HttpResponse resp) throws ClientProtocolException, IOException {
					int code = resp.getStatusLine().getStatusCode();
					if (code >= 400) { 
						for (SaifeDashboardError error : SaifeDashboardError.values()) {
							if (code == error.getCode()) {
								throw new SaifeHttpException(error, resp.getStatusLine().getReasonPhrase());
							}
						}
						throw new SaifeHttpException(SaifeDashboardError.UNKNOWN_ERROR, "Unexpected error code received: " + code);
					}
					HttpEntity entity = resp.getEntity();
					return entity == null ? null : EntityUtils.toString(entity);
				}
			});
			
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.000+0000").create();
			return gson.fromJson(responseBody, result);
		} catch (IOException ex) {
			throw new SaifeClientException("Could not execute HTTP request.", ex);
		} catch (SaifeHttpException ex) {
			throw new SaifeDashboardException(ex.getSaifeError(), ex.getMessage());
		} 
	}

	private static HttpRequestBase getHttpRequest(HttpMethod httpMethod) throws SaifeClientException {
			switch (httpMethod) {
			case GET:
				return new HttpGet();
			case POST:
				return new HttpPost();
			case PUT:
				return new HttpPut();
			case DELETE:
				return new HttpDelete();
			default:
				throw new SaifeClientException("Unsupported HTTP method: " + httpMethod.name());
			}
	}

	private static String buildUriAndParameters(String uri, HttpRequestBase req, Map<String,Object>params) throws UnsupportedEncodingException {
		
		if (uri == null || params == null) {
			return null;
		}

		for (Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator(); it.hasNext(); ) {
			Map.Entry<String, Object> entry = it.next();
			String key = '{' + entry.getKey() + '}';
			if (uri.contains(key)) {
				uri = uri.replace(key, URLEncoder.encode(entry.getValue().toString(), CHARSET));
				it.remove();
			}
		}

		if (!params.isEmpty()) {
			if (req instanceof HttpEntityEnclosingRequest) {
				// PUT, POST
				HttpEntityEnclosingRequest eeReq = (HttpEntityEnclosingRequest)req;
				List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
				for (Map.Entry<String, Object> entry : params.entrySet()) {
					urlParameters.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
				}
				eeReq.setEntity(new UrlEncodedFormEntity(urlParameters, Charset.forName(CHARSET)));
			} else {
				// GET, DELETE
				boolean first = true;
				StringBuilder sb = new StringBuilder(uri); 
				for (Map.Entry<String, Object> entry : params.entrySet()) {
					if (first) {
						first = false;
						sb.append('?');
					} else {
						sb.append('&');
					}
					sb.append(entry.getKey()).append('=').append(URLEncoder.encode(entry.getValue().toString(), CHARSET));
				}
				uri = sb.toString();
			}
		}

		return uri;
	}

}
