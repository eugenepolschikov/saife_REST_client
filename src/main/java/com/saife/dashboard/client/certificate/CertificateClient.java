package com.saife.dashboard.client.certificate;

import java.util.Date;

import com.saife.dashboard.client.common.ClientException;
import com.saife.dashboard.client.common.SaifeException;
import com.saife.dashboard.client.common.SaifeListDTO;

/**
 * Certificate management client interface.
 * 
 * Certificate management is the bread-and-butter of SAIFE Management; all SAIFE endpoints have certificates,
 * and a certificate is the smallest managed unit of SAIFE.
 * 
 * @see http://saifeinc.com/developers/libraries/management/?shell#certificate
 */
public interface CertificateClient {

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
	CertificateDTO create(String pkcs10csr, String capabilities, String userId, String organizationId, String endpointId, Date expireTime, String name)
			throws ClientException, SaifeException;

	/**
	 * Updates the existing certificate by Id. 
	 * 
	 * @param certId - (required) certificate Id
	 * @param organizationId - (conditional) The ID of the organization is only required during interactive login sessions.
	 * @param endpointId - (optional) The ID of the endpoint, if any
	 * @param expireTime - (optional) The expiration timestamp; if not specified than a default will be used
	 * @param name - (optional) The certificate name. The default is the user’s first and last names concatenated with a unique ID.
	*/
	CertificateDTO update(String certId, String organizationId, String endpointId, Date expireTime, String name)
			throws ClientException, SaifeException;
	
	/**
	 * Returns existing certificate by the given Id.
	 * 
	 * @param certId - (required) certificate Id
	 */
	CertificateDTO getById(String certId)
			throws ClientException, SaifeException;

	/**
	 * Returns existing certificate by fingerprint.
	 * 
	 * @param certId - (required) certificate Id
	 */
	CertificateDTO getByFingerpring(String certId)
			throws ClientException, SaifeException;
	
	/**
	 * Revokes certificate by Id.
	 * 
	 * @param certId - (required) certificate Id
	 * @param revokeTime - (optional) The revoke timestamp; if not specified than a default will be used
	 */
	CertificateDTO revoke(String certId, Date revokeTime)
			throws ClientException, SaifeException;
	
	/**
	 * 
	 * @param includeRevokedCert - (optional) Flag to include or exclude revoked certificate. True to include revoked cert.
	 * False to exclude revoked cert. Default to true.
	 * @param orgId - A list of certificates (and their details) that belong to that organization
	 * @param groupId - A list of certificates (and their details) that are in a specific group
	 */
	SaifeListDTO<CertificateDTO> list(boolean includeRevokedCert, String orgId, String groupId)
			throws ClientException, SaifeException;
	
	/**
	 * Resets password of certificate.
	 * 
	 * @param certId - (required) certificate Id
	 */
	CertificateDTO resetPassword(String certId)
			throws ClientException, SaifeException;
	
}
