package com.saife.dashboard.proxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import com.saife.dashboard.common.AbstractSaifeClient;
import com.saife.dashboard.common.SaifeClientException;
import com.saife.dashboard.common.SaifeEndpointUrl;
import com.saife.dashboard.common.SaifeParam;
import com.saife.dashboard.http.HttpMethodData;

public class SaifeClientProxy implements InvocationHandler {

	private AbstractSaifeClient saifeClient;

	private static ThreadLocal<HttpMethodData>thHttpMethodData = new ThreadLocal<HttpMethodData>();

	public static Object newInstance(AbstractSaifeClient saifeClient) {
		return Proxy.newProxyInstance(
			saifeClient.getClass().getClassLoader(),
			saifeClient.getClass().getInterfaces(),
			new SaifeClientProxy(saifeClient));
	}

	private SaifeClientProxy(AbstractSaifeClient saifeClient) {
		this.saifeClient = saifeClient;
	}

	@Override
	public Object invoke(Object proxy, Method proxyMethod, Object[] args) throws Throwable {
		Method objMethod = saifeClient.getClass().getMethod(proxyMethod.getName(), proxyMethod.getParameterTypes());
		SaifeEndpointUrl methodEndpoint = objMethod.getAnnotation(SaifeEndpointUrl.class);
		HttpMethodData httpMethodData = new HttpMethodData();
		if (methodEndpoint != null) {
			httpMethodData.setEndpoint(methodEndpoint.endpoint());
			httpMethodData.setMethod(methodEndpoint.method());
			Map<String, Object>params = new HashMap<String,Object>();
			Annotation annotations[][] = objMethod.getParameterAnnotations();
			for (int i=0; i<annotations.length; i++) {
				Annotation[] ann = annotations[i];
				for (int j=0; j<ann.length; j++) {
					if (ann[j] instanceof SaifeParam) {
						SaifeParam saifeParam = (SaifeParam)ann[j];
						if (saifeParam.requred() && args[i] == null) {
							throw new SaifeClientException(saifeClient.getClass().getName() + "." + proxyMethod.getName() + 
									"(): parameter " + saifeParam.name() + " is null but declared as requred.");
						}
						if (args[i] != null) {
							params.put(saifeParam.name(), args[i]);
						}
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
