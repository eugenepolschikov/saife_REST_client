package com.saife.dashboard.client.common;

public abstract class SaifeClient {

	protected String apiKey;

	protected SaifeClient(String apiKey) {
		super();
		this.apiKey = apiKey;
	}
	
}
