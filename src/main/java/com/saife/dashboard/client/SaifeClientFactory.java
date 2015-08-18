package com.saife.dashboard.client;

import com.saife.dashboard.client.certificate.CertificateClient;
import com.saife.dashboard.client.certificate.impl.CertificateClientMockImpl;
import com.saife.dashboard.client.group.GroupClient;
import com.saife.dashboard.client.group.impl.GroupClientMockImpl;

public class SaifeClientFactory {

	public static CertificateClient getCertificateClient() {
		return new CertificateClientMockImpl();
	}
	
	public static GroupClient getGroupClient() {
		return new GroupClientMockImpl();
	} 
}
