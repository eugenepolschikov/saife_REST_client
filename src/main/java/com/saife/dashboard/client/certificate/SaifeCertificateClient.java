package com.saife.dashboard.client.certificate;

import java.util.Date;

import com.saife.dashboard.common.SaifeClientException;
import com.saife.dashboard.common.SaifeDashboardException;

/**
 * Certificate management client interface.
 *
 * Certificate management is the bread-and-butter of SAIFE Management; all SAIFE endpoints have certificates,
 * and a certificate is the smallest managed unit of SAIFE.
 *
 * @see http://saifeinc.com/developers/libraries/management/?shell#certificate
 */
public interface SaifeCertificateClient {

	/**
	 * Creates a new certificate.
	 *
	 * @param pkcs10csr - (required) PKCS10-compliant, ASN.1-encoded CSR
	 * @param capabilities - (required) Certificate capabilities as a String (serialized JSON).
	 * @param userId - (required) The ID of the user that is responsible for the new certificate
	 * @param organizationId - (conditional) The ID of the organization is only required during interactive login sessions.
	 * @param endpointId - (optional) The ID of the endpoint, if any
	 * @param expireTime - (optional) The expiration timestamp; if not specified than a default will be used
	 * @param name - (optional) The certificate name. The default is the user’s first and last names concatenated with a unique ID.
	 */
	SaifeCertificate create(String pkcs10csr, String capabilities, String userId, String organizationId, String endpointId, Date expireTime, String name)
			throws SaifeClientException, SaifeDashboardException;

	/**
	 * Updates the existing certificate by Id.
	 *
	 * @param certId - (required) certificate Id
	 * @param organizationId - (conditional) The ID of the organization is only required during interactive login sessions.
	 * @param endpointId - (optional) The ID of the endpoint, if any
	 * @param expireTime - (optional) The expiration timestamp; if not specified than a default will be used
	 * @param name - (optional) The certificate name. The default is the user’s first and last names concatenated with a unique ID.
	*/
	SaifeCertificate update(String certId, String organizationId, String endpointId, Date expireTime, String name)
			throws SaifeClientException, SaifeDashboardException;

	/**
	 * Returns existing certificate by the given Id.
	 *
	 * @param certId - (required) certificate Id
	 */
	SaifeCertificate getById(String certId)
			throws SaifeClientException, SaifeDashboardException;

	/**
	 * Returns existing certificate by fingerprint.
	 *
	 * @param fingerprint - (required) certificate fingerprint
	 */
	SaifeCertificate getByFingerpring(String fingerprint)
			throws SaifeClientException, SaifeDashboardException;

	/**
	 * Revokes certificate by Id.
	 *
	 * @param certId - (required) certificate Id
	 * @param revokeTime - (optional) The revoke timestamp; if not specified than a default will be used
	 */
	SaifeCertificate revoke(String certId, Date revokeTime)
			throws SaifeClientException, SaifeDashboardException;

	/**
	 *
	 * @param includeRevokedCert - (optional) Flag to include or exclude revoked certificate. True to include revoked cert.
	 * False to exclude revoked cert. Default to true.
	 * @param orgId - A list of certificates (and their details) that belong to that organization
	 * @param groupId - A list of certificates (and their details) that are in a specific group
	 */
	SaifeCertificateList list(boolean includeRevokedCert, String orgId, String groupId)
			throws SaifeClientException, SaifeDashboardException;

	/**
	 * Resets password of certificate.
	 *
	 * @param certId - (required) certificate Id
	 */
	SaifeCertificate resetPassword(String certId)
			throws SaifeClientException, SaifeDashboardException;

}
