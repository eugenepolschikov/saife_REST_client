package com.saife.dashboard.common;

public abstract class AbstractSaifeClient {

	protected String apiKey;

	public AbstractSaifeClient(String apiKey) {
		super();
		this.apiKey = apiKey + ":";
	}

	public String getApiKey() {
		return apiKey;
	}
}
