package com.saife.dashboard.client;

import com.saife.dashboard.client.certificate.CertificateClient;
import com.saife.dashboard.client.certificate.impl.CertificateClientMockImpl;
import com.saife.dashboard.client.endpoint.EndpointClient;
import com.saife.dashboard.client.endpoint.impl.EndpointClientMockImpl;
import com.saife.dashboard.client.group.GroupClient;
import com.saife.dashboard.client.group.impl.GroupClientMockImpl;

public class SaifeClientFactory {

	private String apiKey;
	
	private SaifeClientFactory(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public static SaifeClientFactory getInstance(String apiKey) {
		return new SaifeClientFactory(apiKey);
	}
	
	public CertificateClient getCertificateClient() {
		return new CertificateClientMockImpl(apiKey);
	}
	
	public GroupClient getGroupClient() {
		return new GroupClientMockImpl(apiKey);
	} 

	public EndpointClient getEndpointClient() {
		return new EndpointClientMockImpl(apiKey);
	} 

}
