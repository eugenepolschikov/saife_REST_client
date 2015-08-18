package com.saife.dashboard.client.endpoint;

import com.saife.dashboard.client.common.ClientException;
import com.saife.dashboard.client.common.SaifeException;
import com.saife.dashboard.client.common.SaifeListDTO;

/**
 * Endpoint management client interface.
 * 
 * Endpoints represent things on the Internet, such as Smartphones, Tablets, Laptops, Smart Refrigerators,
 * Proxies and 6LoPAN sensors. Endpoints have one or more certificates associated with them.
 * 
 * @see http://saifeinc.com/developers/libraries/management/?shell#endpoint
 */
public interface EndpointClient {
	
	/**
	 * Creates a new endpoint. 
	 * @param name - name of endpoint
	 * @param userId - user Id
	 */
	EndpointDTO create(String name, String userId)
			throws ClientException, SaifeException;
	
	/**
	 * Updates the endpoint.
	 * @param endpointId - endpoint Id
	 * @param name - name of endpoint
	 * @param userId - user Id
	 */
	EndpointDTO update(String endpointId, String name, String userId)
			throws ClientException, SaifeException;

	/**
	 * Retrieves the endpoint. 
	 * @param endpointId - endpoint Id
	 */
	EndpointDTO retrieve(String endpointId)
			throws ClientException, SaifeException;

	/**
	 * Removes the endpoint.
	 * @param endpointId - endpoint Id
	 */
	EndpointDTO remove(String endpointId)
			throws ClientException, SaifeException;
	
	/**
	 * Returns list of endpoints matched to input criteria. 
	 * @param userId
	 * @param groupId
	 */
	SaifeListDTO<EndpointDTO>list(String userId, String groupId)
			throws ClientException, SaifeException;
}
