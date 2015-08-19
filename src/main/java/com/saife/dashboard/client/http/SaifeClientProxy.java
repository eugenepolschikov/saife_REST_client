package com.saife.dashboard.client.http;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import com.saife.dashboard.client.common.AbstractSaifeClient;

public class SaifeClientProxy implements InvocationHandler {

	private AbstractSaifeClient saifeClient;
	private SaifeEndpoint commonEndpoint = null;
	
	private static ThreadLocal<HttpMethodData>thHttpMethodData = new ThreadLocal<HttpMethodData>();
	
	public static Object newInstance(AbstractSaifeClient saifeClient) {
		return Proxy.newProxyInstance(
			saifeClient.getClass().getClassLoader(),
			saifeClient.getClass().getInterfaces(),
			new SaifeClientProxy(saifeClient));
	}
	
	private SaifeClientProxy(AbstractSaifeClient saifeClient) {
		this.saifeClient = saifeClient;
		Class<?>clazz = saifeClient.getClass();
		while (clazz != null) {
			commonEndpoint = clazz.getAnnotation(SaifeEndpoint.class);
			if (commonEndpoint != null) {
				break;
			} 
			clazz = clazz.getSuperclass();
		}
	}

	@Override
	public Object invoke(Object proxy, Method proxyMethod, Object[] args) throws Throwable {
		Method objMethod = saifeClient.getClass().getMethod(proxyMethod.getName(), proxyMethod.getParameterTypes());
		SaifeEndpoint methodEndpoint = objMethod.getAnnotation(SaifeEndpoint.class);

		HttpMethodData httpMethodData = new HttpMethodData();

		if (commonEndpoint != null && methodEndpoint != null) {
			httpMethodData.setEndpoint(commonEndpoint.endpoint() + methodEndpoint.endpoint());
			httpMethodData.setMethod(methodEndpoint.method());
			Map<String, Object>params = new HashMap<String,Object>();
			Annotation annotations[][] = objMethod.getParameterAnnotations();
			for (int i=0; i<annotations.length; i++) {
				Annotation[] ann = annotations[i];
				for (int j=0; j<ann.length; j++) {
					if (ann[j] instanceof SaifeParam && args[i] != null) {
						params.put(((SaifeParam)ann[j]).name(), args[i]);
					}
				}
			}
			httpMethodData.setParameters(params);
			httpMethodData.setApiKey(saifeClient.getApiKey());
		}

		thHttpMethodData.set(httpMethodData);
		try {
			return proxyMethod.invoke(saifeClient, args);
		} catch(InvocationTargetException ex) {
			throw ex.getTargetException();
		}
	}

	public static HttpMethodData getHttpMethodData() {
		return thHttpMethodData.get();
	}
	
}
