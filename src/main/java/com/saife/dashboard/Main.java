package com.saife.dashboard;

import com.saife.dashboard.client.SaifeClientFactory;
import com.saife.dashboard.client.certificate.SaifeCertificateClient;
import com.saife.dashboard.client.common.SaifeException;

public class Main {

	public static void main(String[] args) throws SaifeException {
		
		SaifeClientFactory f = SaifeClientFactory.getInstance("1234567");
		
		SaifeCertificateClient cc = f.getCertificateClient();
		
		cc.create("+pkcs10csr", "+capabilities", "+userId", "+organizationId", "+endpointId", null, "+name");

		
		
	}
}
