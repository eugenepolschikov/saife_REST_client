package com.saife.dashboard.client.endpoint;

import com.saife.dashboard.client.common.SaifeClientException;
import com.saife.dashboard.client.common.SaifeDashboardException;

/**
 * Endpoint management client interface.
 * 
 * Endpoints represent things on the Internet, such as Smartphones, Tablets, Laptops, Smart Refrigerators,
 * Proxies and 6LoPAN sensors. Endpoints have one or more certificates associated with them.
 * 
 * @see http://saifeinc.com/developers/libraries/management/?shell#endpoint
 */
public interface SaifeEndpointClient {
	
	/**
	 * Creates a new endpoint. 
	 * @param name - name of endpoint
	 * @param userId - user Id
	 */
	SaifeEndpoint create(String name, String userId)
			throws SaifeClientException, SaifeDashboardException;
	
	/**
	 * Updates the endpoint.
	 * @param endpointId - endpoint Id
	 * @param name - name of endpoint
	 * @param userId - user Id
	 */
	SaifeEndpoint update(String endpointId, String name, String userId)
			throws SaifeClientException, SaifeDashboardException;

	/**
	 * Retrieves the endpoint. 
	 * @param endpointId - endpoint Id
	 */
	SaifeEndpoint retrieve(String endpointId)
			throws SaifeClientException, SaifeDashboardException;

	/**
	 * Removes the endpoint.
	 * @param endpointId - endpoint Id
	 */
	SaifeEndpoint remove(String endpointId)
			throws SaifeClientException, SaifeDashboardException;
	
	/**
	 * Returns list of endpoints matched to input criteria. 
	 * @param userId
	 * @param groupId
	 */
	SaifeEndpointList list(String userId, String groupId)
			throws SaifeClientException, SaifeDashboardException;
}
