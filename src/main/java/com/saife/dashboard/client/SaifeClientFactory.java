package com.saife.dashboard.client;

import com.saife.dashboard.client.certificate.SaifeCertificateClient;
import com.saife.dashboard.client.certificate.impl.SaifeCertificateClientImpl;
import com.saife.dashboard.client.endpoint.SaifeEndpointClient;
import com.saife.dashboard.client.endpoint.impl.SaifeEndpointClientMockImpl;
import com.saife.dashboard.client.group.SaifeGroupClient;
import com.saife.dashboard.client.group.impl.SaifeGroupClientMockImpl;
import com.saife.dashboard.proxy.SaifeClientProxy;

public class SaifeClientFactory {

	private String apiKey;

	private SaifeClientFactory(String apiKey) {
		this.apiKey = apiKey;
	}

	public static SaifeClientFactory getInstance(String apiKey) {
		return new SaifeClientFactory(apiKey);
	}

	public SaifeCertificateClient getCertificateClient() {
		return (SaifeCertificateClient)SaifeClientProxy.newInstance(new SaifeCertificateClientImpl(apiKey));
	}

	public SaifeGroupClient getGroupClient() {
		return new SaifeGroupClientMockImpl(apiKey);
	}

	public SaifeEndpointClient getEndpointClient() {
		return new SaifeEndpointClientMockImpl(apiKey);
	}

}
