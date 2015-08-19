package com.saife.dashboard;

import com.saife.dashboard.client.SaifeClientFactory;
import com.saife.dashboard.client.certificate.SaifeCertificate;
import com.saife.dashboard.client.certificate.SaifeCertificateClient;
import com.saife.dashboard.client.certificate.SaifeCertificateList;

public class SaifeCertificateMain {

	public static void main(String[] args) throws Exception {

		SaifeClientFactory f = SaifeClientFactory.getInstance("6QHJH09ED82KPH0EEW9HSZ5DJ7MGRPFACBECEKE1SN9QKEA4F2A0");
		SaifeCertificateClient scc = f.getCertificateClient();
		SaifeCertificateList list = scc.list(false, null, null);
		System.out.println(list);
		if(list.getData() != null) {
			for (SaifeCertificate cert : list.getData()) {
				System.out.println("ID: " + scc.getById(cert.getId()));
				if (cert.getFingerprint() != null) {
					System.out.println("FP: " + scc.getByFingerpring(cert.getFingerprint()));
				}
			}
		}
		
	}
}
