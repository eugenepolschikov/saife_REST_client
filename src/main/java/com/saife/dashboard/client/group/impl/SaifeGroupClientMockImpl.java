package com.saife.dashboard.client.group.impl;

import java.util.ArrayList;

import com.saife.dashboard.client.group.SaifeGroup;
import com.saife.dashboard.client.group.SaifeGroupClient;
import com.saife.dashboard.client.group.SaifeGroupList;
import com.saife.dashboard.client.group.SaifeGroupMember;
import com.saife.dashboard.common.AbstractSaifeClient;

public class SaifeGroupClientMockImpl extends AbstractSaifeClient implements SaifeGroupClient {

	public SaifeGroupClientMockImpl(String apiKey) {
		super(apiKey);
	}

	@Override
	public SaifeGroup create(String kind, String name, String organizationId) {
		SaifeGroup res = createMockGroupDTO();
		res.setKind(kind);
		res.setName(name);
		res.setOrganizationId(organizationId);
		return res;
	}

	@Override
	public SaifeGroup edit(String groupId, String name) {
		SaifeGroup res = createMockGroupDTO();
		res.setId(groupId);
		res.setName(name);
		return res;
	}

	@Override
	public void disband(String groupId) {
	}

	@Override
	public void disbandSync(String groupId) {
	}
	
	@Override
	public SaifeGroup details(String groupId) {
		SaifeGroup res = createMockGroupDTO();
		res.setId(groupId);
		return res;
	}

	@Override
	public SaifeGroup addCertificate(String groupId, String certId) {
		SaifeGroup res = createMockGroupDTO();
		res.setId(groupId);
		SaifeGroupMember mem = new SaifeGroupMember();
		mem.setId(certId);
		mem.setKind(mem.getObject().name());
		res.getMembers().add(mem);
		return res;
	}

	public SaifeGroup addCertificateSync(String groupId, String certId) {
		return addCertificate(groupId, certId);
	}
	
	
	@Override
	public SaifeGroup removeCertificate(String groupId, String certId) {
		SaifeGroup res = createMockGroupDTO();
		res.setId(groupId);
		return res;
	}
	
	@Override
	public SaifeGroup removeCertificateSync(String groupId, String certId) {
		return removeCertificate(groupId, certId);
	}

	@Override
	public SaifeGroupList list(String kind, String organizationId) {
		SaifeGroupList res = new SaifeGroupList();
		res.setData(new ArrayList<SaifeGroup>());
		res.getData().add(createMockGroupDTO());
		res.setHasMore(false);
		return res;
	}

	@Override
	public SaifeGroup merge(String groupId1, String groupId2) {
		SaifeGroup res = createMockGroupDTO();
		res.setId(groupId1);
		return res;
	}

	private SaifeGroup createMockGroupDTO() {
		SaifeGroup res = new SaifeGroup();

		res.setId("grp_0000038");
		res.setKind("omni");
		res.setName("The Revengers");
		res.setOrganizationId("org_0000008");

		res.setMembers(new ArrayList<SaifeGroupMember>());
		res.getMembers().add(createMockGroupMemberDTO());
		return res;
	}

	private SaifeGroupMember createMockGroupMemberDTO() {
		SaifeGroupMember res = new SaifeGroupMember();
		res.setId("cer_W69AF7ZXCC6KT");
		res.setKind("member");
		return res;
	}

}
