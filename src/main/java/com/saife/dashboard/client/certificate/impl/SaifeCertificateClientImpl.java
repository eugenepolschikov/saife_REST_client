package com.saife.dashboard.client.certificate.impl;

import java.util.Date;

import com.saife.dashboard.client.certificate.SaifeCertificate;
import com.saife.dashboard.client.certificate.SaifeCertificateClient;
import com.saife.dashboard.client.certificate.SaifeCertificateList;
import com.saife.dashboard.common.AbstractSaifeClient;
import com.saife.dashboard.common.SaifeClientException;
import com.saife.dashboard.common.SaifeDashboardException;
import com.saife.dashboard.common.SaifeEndpointUrl;
import com.saife.dashboard.common.SaifeParam;
import com.saife.dashboard.http.HttpMethod;
import com.saife.dashboard.http.HttpMethodInvoker;

public class SaifeCertificateClientImpl extends AbstractSaifeClient implements SaifeCertificateClient {

	public SaifeCertificateClientImpl(String apiKey) {
		super(apiKey);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/certificate/pkcs10csr", method=HttpMethod.POST)
	public SaifeCertificate create(
			@SaifeParam("pkcs10csr") String pkcs10csr,
			@SaifeParam("capabilities") String capabilities,
			@SaifeParam("userId") String userId,
			@SaifeParam("organizationId") String organizationId,
			@SaifeParam("endpointId") String endpointId,
			@SaifeParam("expireTime") Date expireTime,
			@SaifeParam("name") String name) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeCertificate.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/certificate/{certId}", method=HttpMethod.PUT)
	public SaifeCertificate update(
			@SaifeParam("certId") String certId,
			@SaifeParam("organizationId") String organizationId,
			@SaifeParam("endpointId") String endpointId,
			@SaifeParam("expireTime") Date expireTime,
			@SaifeParam("name") String name) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeCertificate.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/certificate/{certId}", method=HttpMethod.GET)
	public SaifeCertificate retrieveById(
			@SaifeParam("certId") String certId) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeCertificate.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/certificate/fingerprint/{fingerprint}", method=HttpMethod.GET)
	public SaifeCertificate retrieveByFingerpring(
			@SaifeParam("fingerprint") String fingerprint) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeCertificate.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/certificate/{certId}", method=HttpMethod.DELETE)
	public SaifeCertificate revoke(
			@SaifeParam("certId") String certId)
			throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeCertificate.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/certificate/{certId}/{date}", method=HttpMethod.DELETE)
	public SaifeCertificate revoke(
			@SaifeParam("certId") String certId,
			@SaifeParam("revokeTime") Date revokeTime)
			throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeCertificate.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/certificate", method=HttpMethod.GET)
	public SaifeCertificateList list(
			@SaifeParam("includeRevokedCert") boolean includeRevokedCert,
			@SaifeParam("orgId") String orgId,
			@SaifeParam("groupId") String groupId)
			throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeCertificateList.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/certificate/{certId}/resetpw", method=HttpMethod.GET)
	public SaifeCertificate resetPassword(
			@SaifeParam("certId") String certId) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeCertificate.class);
	}

}
