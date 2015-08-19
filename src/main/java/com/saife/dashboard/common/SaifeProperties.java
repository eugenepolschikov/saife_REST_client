package com.saife.dashboard.common;

import java.io.IOException;
import java.util.Properties;

public class SaifeProperties {

	private static Properties properties;

	public static final String SAIFE_ENDPOINT = "saife.endpoint";
	public static final String SAIFE_PROXY_USE = "saife.proxy.use";
	public static final String SAIFE_PROXY_HOST = "saife.proxy.host";
	public static final String SAIFE_PROXY_PORT = "saife.proxy.port";
	public static final String SAIFE_PROXY_SCHEME = "saife.proxy.scheme";

	static {
		properties = new Properties();
		try {
			properties.load(SaifeProperties.class.getResourceAsStream("/saife.properties"));
		} catch (IOException e) {
		}
	}

	public static String getProperty(String name) {
		return properties.getProperty(name);
	}
}
