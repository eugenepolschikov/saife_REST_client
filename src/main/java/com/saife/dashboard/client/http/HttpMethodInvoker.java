package com.saife.dashboard.client.http;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.saife.dashboard.client.common.SaifeClientException;
import com.saife.dashboard.client.common.SaifeDashboardError;
import com.saife.dashboard.client.common.SaifeDashboardException;

public class HttpMethodInvoker {

	// TODO for multithreading a pool is needed
	private static HttpClient client = HttpClientBuilder.create().build();
	
	public static <T> T invoke (Class<T>result) throws SaifeClientException, SaifeDashboardException {
		
		HttpRequestBase req = getHttpRequest();
		String uri = buildUri(SaifeClientProxy.getEndpoint(), SaifeClientProxy.getParameters());
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
					if (code >= 300) { 
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
			
			Gson gson = new Gson();
			return gson.fromJson(responseBody, result);
		} catch (IOException ex) {
			throw new SaifeClientException("Could not execute HTTP request.", ex);
		} catch (SaifeHttpException ex) {
			throw new SaifeDashboardException(ex.getSaifeError(), ex.getMessage());
		} 
	}

	private static HttpRequestBase getHttpRequest() throws SaifeClientException {
		if (SaifeClientProxy.getHttpMethod() != null) {
			switch (SaifeClientProxy.getHttpMethod()) {
			case GET:
				return new HttpGet();
			case POST:
				return new HttpPost();
			case PUT:
				return new HttpPut();
			case DELETE:
				return new HttpDelete();
			default:
				throw new SaifeClientException("Unsupported HTTP method: " + SaifeClientProxy.getHttpMethod().name());
			}
			
		} 
		throw new SaifeClientException("HTTP method is not specified.");
	}

	private static String encodeParameter(String param) {
		try {
			return URLEncoder.encode(param, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return param;
		}
	}
	
	private static String buildUri(String uri, Map<String,Object>params) {
		
		if (uri == null || params == null) {
			return null;
		}
		
		for (Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator(); it.hasNext(); ) {
			Map.Entry<String, Object> entry = it.next();
			String key = '{' + entry.getKey() + '}';
			if (uri.contains(key)) {
				uri = uri.replace(key, encodeParameter(entry.getValue().toString()));
				it.remove();
			}
		}
		
		if (!params.isEmpty()) {
			boolean first = true;
			StringBuilder sb = new StringBuilder(uri); 
			for (Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator(); it.hasNext(); ) {
				Map.Entry<String, Object> entry = it.next();
				if (first) {
					first = false;
					sb.append('?');
				} else {
					sb.append('&');
				}
				sb.append(entry.getKey()).append('=').append(encodeParameter(entry.getValue().toString()));
			}
			uri = sb.toString();
		}

		return uri;
	}
	
}
