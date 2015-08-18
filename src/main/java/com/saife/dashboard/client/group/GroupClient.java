package com.saife.dashboard.client.group;

import com.saife.dashboard.client.common.ClientException;
import com.saife.dashboard.client.common.SaifeException;
import com.saife.dashboard.client.common.SaifeListDTO;

/**
 * Group management client interface. 
 * 
 * SAIFE uses groups (or enclaves) to simplify certificate distribution within the SAIFE Public Key Infrastructure.
 * Groups contain many SAIFE endpoints, and endpoints may be in many groups.
 * 
 * @see http://saifeinc.com/developers/libraries/management/?shell#group
 */
public interface GroupClient {

	/**
	 * Creates a new group.
	 * @param kind - (required) the kind of group
	 * @param name - (required) the group’s name
	 * @param organizationId - (conditional) the ID of the organization is only required during interactive login sessions
	 */
	GroupDTO create(String kind, String name, String organizationId)
			throws ClientException, SaifeException;
	
	/**
	 * Changes the group.
	 * @param groupId - group Id
	 * @param name - (required) The group’s name
	 */
	GroupDTO edit(String groupId, String name)
			throws ClientException, SaifeException;

	/**
	 * Disbands the group.
	 * @param groupId - group Id
	 */
	void disband(String groupId)
			throws ClientException, SaifeException;
	
	/**
	 * Returns Group object containing the group details.
	 * @param groupId - group Id
	 */
	GroupDTO details(String groupId)
			throws ClientException, SaifeException;
	
	/**
	 * Adds certificate to the group.
	 * @param groupId - group Id
	 * @param certId - certificate Id 
	 */
	GroupDTO addCertificate(String groupId, String certId)
			throws ClientException, SaifeException;
	

	/**
	 * Removes certificate from the group.
	 * @param groupId - group Id
	 * @param certId - certificate Id 
	 */
	GroupDTO removeCertificate(String groupId, String certId)
			throws ClientException, SaifeException;
	
	/**
	 * Returns list of groups which matched to queryable arguments. 
	 * @param kind
	 * @param organizationId
	 */
	SaifeListDTO<GroupDTO> list(String kind, String organizationId)
			throws ClientException, SaifeException;
	
	/**
	 * Merges two groups into one.
	 * @param groupId1 - first group Id
	 * @param groupId2 - second group Id
	 */
	GroupDTO merge(String groupId1, String groupId2)
			throws ClientException, SaifeException;
	
}
