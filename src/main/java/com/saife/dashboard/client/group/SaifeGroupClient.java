package com.saife.dashboard.client.group;

import com.saife.dashboard.client.common.SaifeClientException;
import com.saife.dashboard.client.common.SaifeDashboardException;
import com.saife.dashboard.client.common.SaifeObjectList;

/**
 * Group management client interface. 
 * 
 * SAIFE uses groups (or enclaves) to simplify certificate distribution within the SAIFE Public Key Infrastructure.
 * Groups contain many SAIFE endpoints, and endpoints may be in many groups.
 * 
 * @see http://saifeinc.com/developers/libraries/management/?shell#group
 */
public interface SaifeGroupClient {

	/**
	 * Creates a new group.
	 * @param kind - (required) the kind of group
	 * @param name - (required) the group’s name
	 * @param organizationId - (conditional) the ID of the organization is only required during interactive login sessions
	 */
	SaifeGroup create(String kind, String name, String organizationId)
			throws SaifeClientException, SaifeDashboardException;
	
	/**
	 * Changes the group.
	 * @param groupId - group Id
	 * @param name - (required) The group’s name
	 */
	SaifeGroup edit(String groupId, String name)
			throws SaifeClientException, SaifeDashboardException;

	/**
	 * Disbands the group.
	 * @param groupId - group Id
	 */
	void disband(String groupId)
			throws SaifeClientException, SaifeDashboardException;
	
	/**
	 * Returns Group object containing the group details.
	 * @param groupId - group Id
	 */
	SaifeGroup details(String groupId)
			throws SaifeClientException, SaifeDashboardException;
	
	/**
	 * Adds certificate to the group.
	 * @param groupId - group Id
	 * @param certId - certificate Id 
	 */
	SaifeGroup addCertificate(String groupId, String certId)
			throws SaifeClientException, SaifeDashboardException;
	

	/**
	 * Removes certificate from the group.
	 * @param groupId - group Id
	 * @param certId - certificate Id 
	 */
	SaifeGroup removeCertificate(String groupId, String certId)
			throws SaifeClientException, SaifeDashboardException;
	
	/**
	 * Returns list of groups which matched to queryable arguments. 
	 * @param kind
	 * @param organizationId
	 */
	SaifeObjectList<SaifeGroup> list(String kind, String organizationId)
			throws SaifeClientException, SaifeDashboardException;
	
	/**
	 * Merges two groups into one.
	 * @param groupId1 - first group Id
	 * @param groupId2 - second group Id
	 */
	SaifeGroup merge(String groupId1, String groupId2)
			throws SaifeClientException, SaifeDashboardException;
	
}
