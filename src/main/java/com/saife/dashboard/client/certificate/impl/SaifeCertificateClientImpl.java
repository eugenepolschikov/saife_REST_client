package com.saife.dashboard.client.certificate.impl;

import java.util.Date;

import com.saife.dashboard.client.certificate.SaifeCertificate;
import com.saife.dashboard.client.certificate.SaifeCertificateClient;
import com.saife.dashboard.client.certificate.SaifeCertificateList;
import com.saife.dashboard.common.AbstractSaifeClient;
import com.saife.dashboard.common.SaifeClientException;
import com.saife.dashboard.common.SaifeDashboardException;
import com.saife.dashboard.common.SaifeEndpoint;
import com.saife.dashboard.common.SaifeParam;
import com.saife.dashboard.http.HttpMethod;
import com.saife.dashboard.http.HttpMethodInvoker;

public class SaifeCertificateClientImpl extends AbstractSaifeClient implements SaifeCertificateClient {

	public SaifeCertificateClientImpl(String apiKey) {
		super(apiKey);
	}

	@Override
	@SaifeEndpoint(endpoint="/certificate/pkcs10csr", method=HttpMethod.POST)
	public SaifeCertificate create(
			@SaifeParam(name="pkcs10csr") String pkcs10csr,
			@SaifeParam(name="capabilities") String capabilities,
			@SaifeParam(name="userId") String userId,
			@SaifeParam(name="organizationId") String organizationId,
			@SaifeParam(name="endpointId") String endpointId,
			@SaifeParam(name="expireTime") Date expireTime,
			@SaifeParam(name="name") String name) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeCertificate.class);
	}

	@Override
	@SaifeEndpoint(endpoint="/certificate/{certId}", method=HttpMethod.PUT)
	public SaifeCertificate update(
			@SaifeParam(name="certId") String certId,
			@SaifeParam(name="organizationId") String organizationId,
			@SaifeParam(name="endpointId") String endpointId,
			@SaifeParam(name="expireTime") Date expireTime,
			@SaifeParam(name="name") String name) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeCertificate.class);
	}

	@Override
	@SaifeEndpoint(endpoint="/certificate/{certId}", method=HttpMethod.GET)
	public SaifeCertificate getById(
			@SaifeParam(name="certId") String certId) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeCertificate.class);
	}

	@Override
	@SaifeEndpoint(endpoint="/certificate/fingerprint/{fingerprint}", method=HttpMethod.GET)
	public SaifeCertificate getByFingerpring(
			@SaifeParam(name="fingerprint") String fingerprint) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeCertificate.class);
	}

	@Override
	@SaifeEndpoint(endpoint="/certificate/{certId}/{date}", method=HttpMethod.GET)
	public SaifeCertificate revoke(
			@SaifeParam(name="certId") String certId,
			@SaifeParam(name="revokeTime") Date revokeTime)
			throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeCertificate.class);
	}

	@Override
	@SaifeEndpoint(endpoint="/certificate", method=HttpMethod.GET)
	public SaifeCertificateList list(
			@SaifeParam(name="includeRevokedCert") boolean includeRevokedCert,
			@SaifeParam(name="orgId") String orgId,
			@SaifeParam(name="groupId") String groupId)
			throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeCertificateList.class);
	}

	@Override
	@SaifeEndpoint(endpoint="/certificate/{certId}/resetpw", method=HttpMethod.GET)
	public SaifeCertificate resetPassword(
			@SaifeParam(name="certId") String certId) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeCertificate.class);
	}

}
