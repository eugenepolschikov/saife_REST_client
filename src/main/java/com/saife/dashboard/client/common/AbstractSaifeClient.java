package com.saife.dashboard.client.common;

import com.saife.dashboard.client.http.SaifeEndpoint;

@SaifeEndpoint(endpoint="http://dashboard.saifeinc.com/api/v2")
public abstract class AbstractSaifeClient {

	protected String apiKey;

	protected AbstractSaifeClient(String apiKey) {
		super();
		this.apiKey = apiKey + ":";
	}

	public String getApiKey() {
		return apiKey;
	}
}
