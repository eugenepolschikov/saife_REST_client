package com.saife.dashboard;

import com.saife.dashboard.client.SaifeClientFactory;
import com.saife.dashboard.client.certificate.SaifeCertificate;
import com.saife.dashboard.client.certificate.SaifeCertificateClient;
import com.saife.dashboard.client.certificate.SaifeCertificateList;

public class SaifeCertificateMain {

	public static void main(String[] args) throws Exception {

		SaifeClientFactory factory = SaifeClientFactory.getInstance("6QHJH09ED82KPH0EEW9HSZ5DJ7MGRPFACBECEKE1SN9QKEA4F2A0");
		SaifeCertificateClient client = factory.getCertificateClient();
		SaifeCertificateList list = client.list(false, null, null);
		System.out.println(list);
		if(list.getData() != null) {
			for (SaifeCertificate cert : list.getData()) {
				System.out.println("ID: " + client.retrieveById(cert.getId()));
				if (cert.getFingerprint() != null) {
					System.out.println("FP: " + client.retrieveByFingerpring(cert.getFingerprint()));
				}
			}
		}

	}
}
