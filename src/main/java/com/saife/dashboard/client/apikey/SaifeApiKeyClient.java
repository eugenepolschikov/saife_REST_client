package com.saife.dashboard.client.apikey;

import java.util.Date;

import com.saife.dashboard.client.common.SaifeClientException;
import com.saife.dashboard.client.common.SaifeDashboardException;
import com.saife.dashboard.client.common.SaifeObjectList;

public interface SaifeApiKeyClient {

	SaifeApiKey generate(String name, String description, Date expireTime)
			throws SaifeClientException, SaifeDashboardException;
	
	SaifeApiKey retrieve(String apiId)
			throws SaifeClientException, SaifeDashboardException;
	
	SaifeApiKey update(String apiId, String name, String description, Date expireTime)
			throws SaifeClientException, SaifeDashboardException;
	
	SaifeApiKey revoke(String apiId)
			throws SaifeClientException, SaifeDashboardException;
	
	SaifeObjectList<SaifeApiKey > list(String organizationId)
			throws SaifeClientException, SaifeDashboardException;
	
}
