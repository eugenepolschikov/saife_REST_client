package com.saife.dashboard.client.endpoint.impl;

import java.util.ArrayList;
import java.util.Arrays;

import com.saife.dashboard.client.common.ClientException;
import com.saife.dashboard.client.common.SaifeException;
import com.saife.dashboard.client.common.SaifeListDTO;
import com.saife.dashboard.client.endpoint.EndpointClient;
import com.saife.dashboard.client.endpoint.EndpointDTO;
import com.saife.dashboard.client.endpoint.UserDTO;

public class EndpointClientMockImpl implements EndpointClient {

	@Override
	public EndpointDTO create(String name, String userId) throws ClientException, SaifeException {
		return createMockEndpointDTO();
	}

	@Override
	public EndpointDTO update(String endpointId, String name, String userId) throws ClientException, SaifeException {
		return createMockEndpointDTO();
	}

	@Override
	public EndpointDTO retrieve(String endpointId) throws ClientException, SaifeException {
		return createMockEndpointDTO();
	}

	@Override
	public EndpointDTO remove(String endpointId) throws ClientException, SaifeException {
		return createMockEndpointDTO();
	}

	@Override
	public SaifeListDTO<EndpointDTO> list(String userId, String groupId) throws ClientException, SaifeException {
		SaifeListDTO<EndpointDTO>res = new SaifeListDTO<EndpointDTO>();
		res.setData(new ArrayList<EndpointDTO>());
		res.getData().add(createMockEndpointDTO());
		return res;
	}

	private EndpointDTO createMockEndpointDTO() {
		EndpointDTO res = new EndpointDTO();
		res.setCertificates(Arrays.asList("cer_000000G", "cer_0000008"));
		res.setId("end_000000R");
		res.setName("Lister");
		
		UserDTO user = new UserDTO();
		user.setFirstName("Chad");
		user.setLastName("Chadington");
		user.setId("usr_000000G");
		user.setProfileImageUrl(null);
		res.setUser(user);
		
		return res;
	}
	
}
