package com.saife.dashboard.client.endpoint.impl;

import java.util.ArrayList;
import java.util.Arrays;

import com.saife.dashboard.client.common.SaifeClientException;
import com.saife.dashboard.client.common.SaifeClient;
import com.saife.dashboard.client.common.SaifeDashboardException;
import com.saife.dashboard.client.common.SaifeObjectList;
import com.saife.dashboard.client.endpoint.SaifeEndpointClient;
import com.saife.dashboard.client.endpoint.SaifeEndpoint;
import com.saife.dashboard.client.user.SaifeUser;

public class SaifeEndpointClientMockImpl extends SaifeClient implements SaifeEndpointClient {

	public SaifeEndpointClientMockImpl(String apiKey) {
		super(apiKey);
	}

	@Override
	public SaifeEndpoint create(String name, String userId) throws SaifeClientException, SaifeDashboardException {
		return createMockEndpointDTO();
	}

	@Override
	public SaifeEndpoint update(String endpointId, String name, String userId) throws SaifeClientException, SaifeDashboardException {
		return createMockEndpointDTO();
	}

	@Override
	public SaifeEndpoint retrieve(String endpointId) throws SaifeClientException, SaifeDashboardException {
		return createMockEndpointDTO();
	}

	@Override
	public SaifeEndpoint remove(String endpointId) throws SaifeClientException, SaifeDashboardException {
		return createMockEndpointDTO();
	}

	@Override
	public SaifeObjectList<SaifeEndpoint> list(String userId, String groupId) throws SaifeClientException, SaifeDashboardException {
		SaifeObjectList<SaifeEndpoint>res = new SaifeObjectList<SaifeEndpoint>();
		res.setData(new ArrayList<SaifeEndpoint>());
		res.getData().add(createMockEndpointDTO());
		return res;
	}

	private SaifeEndpoint createMockEndpointDTO() {
		SaifeEndpoint res = new SaifeEndpoint();
		res.setCertificates(Arrays.asList("cer_000000G", "cer_0000008"));
		res.setId("end_000000R");
		res.setName("Lister");
		
		SaifeUser user = new SaifeUser();
		user.setFirstName("Chad");
		user.setLastName("Chadington");
		user.setId("usr_000000G");
		user.setProfileImageUrl(null);
		res.setUser(user);
		
		return res;
	}
	
}
