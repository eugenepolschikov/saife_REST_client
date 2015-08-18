package com.saife.dashboard.client;

import com.saife.dashboard.client.certificate.SaifeCertificateClient;
import com.saife.dashboard.client.certificate.impl.SaifeCertificateClientMockImpl;
import com.saife.dashboard.client.endpoint.SaifeEndpointClient;
import com.saife.dashboard.client.endpoint.impl.SaifeEndpointClientMockImpl;
import com.saife.dashboard.client.group.SaifeGroupClient;
import com.saife.dashboard.client.group.impl.SaifeGroupClientMockImpl;

public class SaifeClientFactory {

	private String apiKey;
	
	private SaifeClientFactory(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public static SaifeClientFactory getInstance(String apiKey) {
		return new SaifeClientFactory(apiKey);
	}
	
	public SaifeCertificateClient getCertificateClient() {
		return new SaifeCertificateClientMockImpl(apiKey);
	}
	
	public SaifeGroupClient getGroupClient() {
		return new SaifeGroupClientMockImpl(apiKey);
	} 

	public SaifeEndpointClient getEndpointClient() {
		return new SaifeEndpointClientMockImpl(apiKey);
	} 

}
