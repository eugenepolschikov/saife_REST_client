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
			@SaifeParam(name="name") String name,
			@SaifeParam(name="userId") String userId) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeEndpoint.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/endpoint/{endpointId}", method=HttpMethod.PUT)
	public SaifeEndpoint update(
			@SaifeParam(name="endpointId") String endpointId,
			@SaifeParam(name="name") String name,
			@SaifeParam(name="userId") String userId)
			throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeEndpoint.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/endpoint/{endpointId}", method=HttpMethod.GET)
	public SaifeEndpoint retrieve(
			@SaifeParam(name="endpointId") String endpointId) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeEndpoint.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/endpoint/{endpointId}", method=HttpMethod.DELETE)
	public SaifeEndpoint remove(
			@SaifeParam(name="endpointId") String endpointId) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeEndpoint.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/endpoint", method=HttpMethod.GET)
	public SaifeEndpointList list(
			@SaifeParam(name="userId", requred=false) String userId,
			@SaifeParam(name="groupId", requred=false) String groupId) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeEndpointList.class);
	}

}
