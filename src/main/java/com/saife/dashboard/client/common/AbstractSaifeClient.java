package com.saife.dashboard.client.common;

import com.saife.dashboard.client.http.SaifeEndpoint;

@SaifeEndpoint(endpoint="https://dashboard.saifeinc.com/api/v2")
public abstract class AbstractSaifeClient {

	protected String apiKey;

	protected AbstractSaifeClient(String apiKey) {
		super();
		this.apiKey = apiKey;
	}
	
}
