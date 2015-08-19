package com.saife.dashboard.client.endpoint.impl;

import com.saife.dashboard.client.endpoint.SaifeEndpoint;
import com.saife.dashboard.client.endpoint.SaifeEndpointClient;
import com.saife.dashboard.client.endpoint.SaifeEndpointList;
import com.saife.dashboard.common.AbstractSaifeClient;
import com.saife.dashboard.common.SaifeClientException;
import com.saife.dashboard.common.SaifeDashboardException;
import com.saife.dashboard.common.SaifeEndpointUrl;
import com.saife.dashboard.common.SaifeParam;
import com.saife.dashboard.http.HttpMethod;
import com.saife.dashboard.http.HttpMethodInvoker;

public class SaifeEndpointClientImpl extends AbstractSaifeClient implements SaifeEndpointClient {

	public SaifeEndpointClientImpl(String apiKey) {
		super(apiKey);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/endpoint", method=HttpMethod.POST)
	public SaifeEndpoint create(
			@SaifeParam("name") String name,
			@SaifeParam("userId") String userId) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeEndpoint.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/endpoint/{endpointId}", method=HttpMethod.PUT)
	public SaifeEndpoint update(
			@SaifeParam("endpointId") String endpointId,
			@SaifeParam("name") String name,
			@SaifeParam("userId") String userId)
			throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeEndpoint.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/endpoint/{endpointId}", method=HttpMethod.GET)
	public SaifeEndpoint retrieve(
			@SaifeParam("endpointId") String endpointId) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeEndpoint.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/endpoint/{endpointId}", method=HttpMethod.DELETE)
	public SaifeEndpoint remove(
			@SaifeParam("endpointId") String endpointId) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeEndpoint.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/endpoint", method=HttpMethod.GET)
	public SaifeEndpointList list(
			@SaifeParam("userId") String userId,
			@SaifeParam("groupId") String groupId) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeEndpointList.class);
	}

}
