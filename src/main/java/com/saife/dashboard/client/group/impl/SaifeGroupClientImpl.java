package com.saife.dashboard.client.group.impl;

import com.saife.dashboard.client.group.SaifeGroup;
import com.saife.dashboard.client.group.SaifeGroupClient;
import com.saife.dashboard.client.group.SaifeGroupList;
import com.saife.dashboard.common.AbstractSaifeClient;
import com.saife.dashboard.common.SaifeClientException;
import com.saife.dashboard.common.SaifeDashboardException;
import com.saife.dashboard.common.SaifeEndpointUrl;
import com.saife.dashboard.common.SaifeParam;
import com.saife.dashboard.http.HttpMethod;
import com.saife.dashboard.http.HttpMethodInvoker;

public class SaifeGroupClientImpl extends AbstractSaifeClient implements SaifeGroupClient {

	public SaifeGroupClientImpl(String apiKey) {
		super(apiKey);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/group", method=HttpMethod.POST)
	public SaifeGroup create(
			@SaifeParam(name="kind") String kind,
			@SaifeParam(name="name") String name,
			@SaifeParam(name="organizationId") String organizationId)
			throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeGroup.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/group/{groupId}", method=HttpMethod.PUT)
	public SaifeGroup edit(
			@SaifeParam(name="groupId") String groupId,
			@SaifeParam(name="name") String name) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeGroup.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/group/{groupId}", method=HttpMethod.DELETE)
	public void disband(
			@SaifeParam(name="groupId") String groupId) throws SaifeClientException, SaifeDashboardException {
		HttpMethodInvoker.invoke(void.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/group/{groupId}/sync", method=HttpMethod.DELETE)
	public void disbandSync(
			@SaifeParam(name="groupId") String groupId) throws SaifeClientException, SaifeDashboardException {
		HttpMethodInvoker.invoke(void.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/group/{groupId}", method=HttpMethod.GET)
	public SaifeGroup details(
			@SaifeParam(name="groupId") String groupId) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeGroup.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/group/{groupId}/cert/{certId}", method=HttpMethod.POST)
	public SaifeGroup addCertificate(
			@SaifeParam(name="groupId") String groupId,
			@SaifeParam(name="certId") String certId)
			throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeGroup.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/group/{groupId}/cert/{certId}/sync", method=HttpMethod.POST)
	public SaifeGroup addCertificateSync(
			@SaifeParam(name="groupId") String groupId,
			@SaifeParam(name="certId") String certId)
			throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeGroup.class);
	}
	
	@Override
	@SaifeEndpointUrl(endpoint="/group/{groupId}/cert/{certId}", method=HttpMethod.DELETE)
	public SaifeGroup removeCertificate(
			@SaifeParam(name="groupId") String groupId,
			@SaifeParam(name="certId") String certId)
			throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeGroup.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/group/{groupId}/cert/{certId}/sync", method=HttpMethod.DELETE)
	public SaifeGroup removeCertificateSync(
			@SaifeParam(name="groupId") String groupId,
			@SaifeParam(name="certId") String certId)
			throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeGroup.class);
	}
	
	@Override
	@SaifeEndpointUrl(endpoint="/group", method=HttpMethod.GET)
	public SaifeGroupList list(
			@SaifeParam(name="groupId", requred=false) String kind,
			@SaifeParam(name="organizationId", requred=false) String organizationId)
			throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeGroupList.class);
	}

	@Override
	@SaifeEndpointUrl(endpoint="/group/{groupId1}/{groupId2}", method=HttpMethod.GET)
	public SaifeGroup merge(
			@SaifeParam(name="groupId1") String groupId1,
			@SaifeParam(name="groupId2") String groupId2) throws SaifeClientException, SaifeDashboardException {
		return HttpMethodInvoker.invoke(SaifeGroup.class);
	}

}
