package com.saife.dashboard.client.apikey;

import java.util.Date;

import com.saife.dashboard.client.common.ClientException;
import com.saife.dashboard.client.common.SaifeException;
import com.saife.dashboard.client.common.SaifeListDTO;

public interface ApiKeyClient {

	ApiKeyDTO generate(String name, String description, Date expireTime)
			throws ClientException, SaifeException;
	
	ApiKeyDTO retrieve(String apiId)
			throws ClientException, SaifeException;
	
	ApiKeyDTO update(String apiId, String name, String description, Date expireTime)
			throws ClientException, SaifeException;
	
	ApiKeyDTO revoke(String apiId)
			throws ClientException, SaifeException;
	
	SaifeListDTO<ApiKeyDTO > list(String organizationId)
			throws ClientException, SaifeException;
	
}
