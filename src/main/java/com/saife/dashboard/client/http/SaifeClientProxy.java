package com.saife.dashboard.client.http;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class SaifeClientProxy implements InvocationHandler {

	private Object obj;
	private SaifeEndpoint commonEndpoint = null;
	
	private static ThreadLocal<String>currentEndpoint = new ThreadLocal<String>();
	private static ThreadLocal<HttpMethod>httpMethod = new ThreadLocal<HttpMethod>();
	private static ThreadLocal<Map<String,Object>>parameters = new ThreadLocal<Map<String,Object>>();
	
	public static Object newInstance(Object obj) {
		return Proxy.newProxyInstance(
            obj.getClass().getClassLoader(),
            obj.getClass().getInterfaces(),
            new SaifeClientProxy(obj));
    }
	
	private SaifeClientProxy(Object obj) {
		this.obj = obj;
		Class<?>clazz = obj.getClass();
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
		Method objMethod = obj.getClass().getMethod(proxyMethod.getName(), proxyMethod.getParameterTypes());
		SaifeEndpoint methodEndpoint = objMethod.getAnnotation(SaifeEndpoint.class);
		if (commonEndpoint != null && methodEndpoint != null) {
			currentEndpoint.set(commonEndpoint.endpoint() + methodEndpoint.endpoint());
			httpMethod.set(methodEndpoint.method());
			Map<String, Object>params = new HashMap<String,Object>();
			Annotation annotations[][] = objMethod.getParameterAnnotations();
			for (int i=0; i<annotations.length; i++) {
				Annotation[] ann = annotations[i];
				for (int j=0; j<ann.length; j++) {
					if (ann[j] instanceof SaifeParam) {
						params.put(((SaifeParam)ann[j]).name(), args[i]);
					}
				}
			}
			parameters.set(params);
		}
		try {
			return proxyMethod.invoke(obj, args);
		} finally {
			currentEndpoint.remove();
			httpMethod.remove();
			parameters.remove();
		}
	}

	public static String getEndpoint() {
		return currentEndpoint.get();
	}
	
	public static HttpMethod getHttpMethod() {
		return httpMethod.get();
	}
	
	public static Map<String,Object> getParameters() {
		return parameters.get();
	}
}
