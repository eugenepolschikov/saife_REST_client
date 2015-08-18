package com.saife.dashboard.client.certificate.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.saife.dashboard.client.certificate.CertificateClient;
import com.saife.dashboard.client.certificate.CertificateDTO;
import com.saife.dashboard.client.certificate.ManagerDTO;
import com.saife.dashboard.client.common.SaifeClient;
import com.saife.dashboard.client.common.SaifeListDTO;

public class CertificateClientMockImpl extends SaifeClient implements CertificateClient {

	public CertificateClientMockImpl(String apiKey) {
		super(apiKey);
	}

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000+0000");
	
	@Override
	public CertificateDTO create(String pkcs10csr, String capabilities, String userId, String organizationId,
			String endpointId, Date expireTime, String name) {
		return createMockCertificateDTO();
	}

	@Override
	public CertificateDTO update(String certId, String organizationId, String endpointId, Date expireTime, String name) {
		return createMockCertificateDTO();
	}

	@Override
	public CertificateDTO getById(String certId) {
		return createMockCertificateDTO();
	}

	@Override
	public CertificateDTO getByFingerpring(String certId) {
		return createMockCertificateDTO();
	}

	@Override
	public CertificateDTO revoke(String certId, Date revokeTime) {
		return createMockCertificateDTO();
	}

	@Override
	public SaifeListDTO<CertificateDTO> list(boolean includeRevokedCert, String orgId, String groupId) {
		SaifeListDTO<CertificateDTO>res = new SaifeListDTO<CertificateDTO>();
		res.setData(new ArrayList<CertificateDTO>());
		res.setHasMore(false);
		res.getData().add(createMockCertificateDTO());
		return res;
	}

	@Override
	public CertificateDTO resetPassword(String certId) {
		return createMockCertificateDTO();
	}

	private CertificateDTO createMockCertificateDTO() {
		CertificateDTO res = new CertificateDTO();
		res.setCapabilities(Arrays.asList("com::saife::crypto::capability::AES_128_BIT","com::saife::demo::echo"));
		res.setCertificateLeaf("MIIBuzCCAUCgAwIBAgIGAU8/miu7MAoGCCqGSM49BAMCMCExHzAdBgNVBAMTFmRhc2hib2FyZC5zYWlmZWluYy5jb20wHhcNMTUwODE3MjEwMDAwWhcNMTUxMDA4MjEwMDAwWjASMRAwDgYDVQQDEwdkZW1vQXBwMHYwEAYHKoZIzj0CAQYFK4EEACIDYgAEh8vDMvdPPLDlSeH5GRlC7KNf6DP6Cksdy35chIgAfngTa5bZs48TQFmyZtH65pTCLEOdoqfil8shy6o95tOqmzxI3GkTrb8aeBM7w6218Va2HtzjamzWVPcvi9Txj69Qo1YwVDBSBggrBgEFBQcDMARGMEQwD2EDAgEBYgMBAQBjAwEBADAPYQMCAQRiAwEBAGMDAQEAMA9hAwIBAmIDAQEAYwMBAQAwD2EDAgEDYgMBAQBjAwEBADAKBggqhkjOPQQDAgNpADBmAjEA1+MSkZmK04f+zO4gOVNI0zc7WN5GGzVACfJz80RcisfN/Z9tKE9o3BTQA9hArEmHAjEAvWsvVrOWiITsxqq8S0rM/nZHFajt0Ni8ivwRiR1VyunZJr0tAAbwheziYmZqPE0f");
		res.setCreateTime(parseDate("2015-08-10T09:31:02.000+0000"));
		res.setEndpointId("end_00003Y0");
		res.setExpireTime(parseDate("2015-10-08T21:00:00.000+0000"));
		res.setFingerprint("-BULerh_HLabCTgwjbNUYkJCEdwCdMKDIooh2Y0-cVk");
		res.setId("cer_000072G");
		res.setLicenseId(null);
		
		ManagerDTO manager = new ManagerDTO();
		manager.setId("man_0000008");
		manager.setCreateTime(parseDate("2015-02-19T02:15:04.000+0000"));
		manager.setExpireTime(parseDate("2015-02-19T02:15:04.000+0000"));
		manager.setFingerprint("9pvPkJaIYJKXkwBh8DcKzNj9pjljVVNf1XVsDXNn3t8=");
		manager.setCertificateChain("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");
		res.setManager(manager);

		res.setManagerId(manager.getId());
		res.setModifyTime(parseDate("2015-08-18T06:58:32.506+0000"));
		res.setName("demoApp");
		res.setOrganizationId("org_0000088");
		res.setRevokeTime(null);
		res.setUserId("usr_00000NR");
		
		return res;
	}
	
	private Date parseDate(String dateStr) {
		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			return null;
		}
	}
	
}
