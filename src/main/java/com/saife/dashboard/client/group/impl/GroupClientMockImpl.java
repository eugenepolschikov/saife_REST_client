package com.saife.dashboard.client.group.impl;

import java.util.ArrayList;

import com.saife.dashboard.client.common.SaifeClient;
import com.saife.dashboard.client.common.SaifeListDTO;
import com.saife.dashboard.client.group.GroupClient;
import com.saife.dashboard.client.group.GroupDTO;
import com.saife.dashboard.client.group.GroupMemberDTO;

public class GroupClientMockImpl extends SaifeClient implements GroupClient {

	public GroupClientMockImpl(String apiKey) {
		super(apiKey);
	}

	@Override
	public GroupDTO create(String kind, String name, String organizationId) {
		GroupDTO res = createMockGroupDTO();
		res.setKind(kind);
		res.setName(name);
		res.setOrganizationId(organizationId);
		return res;
	}

	@Override
	public GroupDTO edit(String groupId, String name) {
		GroupDTO res = createMockGroupDTO();
		res.setId(groupId);
		res.setName(name);
		return res;
	}

	@Override
	public void disband(String groupId) {
	}

	@Override
	public GroupDTO details(String groupId) {
		GroupDTO res = createMockGroupDTO();
		res.setId(groupId);
		return res;
	}

	@Override
	public GroupDTO addCertificate(String groupId, String certId) {
		GroupDTO res = createMockGroupDTO();
		res.setId(groupId);
		GroupMemberDTO mem = new GroupMemberDTO();
		mem.setId(certId);
		mem.setKind(mem.getObject().name());
		res.getMembers().add(mem);
		return res;
	}

	@Override
	public GroupDTO removeCertificate(String groupId, String certId) {
		GroupDTO res = createMockGroupDTO();
		res.setId(groupId);
		return res;
	}

	@Override
	public SaifeListDTO<GroupDTO> list(String kind, String organizationId) {
		SaifeListDTO<GroupDTO>res = new SaifeListDTO<GroupDTO>();
		res.setData(new ArrayList<GroupDTO>());
		res.getData().add(createMockGroupDTO());
		res.setHasMore(false);
		return res;
	}

	@Override
	public GroupDTO merge(String groupId1, String groupId2) {
		GroupDTO res = createMockGroupDTO();
		res.setId(groupId1);
		return res;
	}

	private GroupDTO createMockGroupDTO() {
		GroupDTO res = new GroupDTO();
		
		res.setId("grp_0000038");
		res.setKind("omni");
		res.setName("The Revengers");
		res.setOrganizationId("org_0000008");

		res.setMembers(new ArrayList<GroupMemberDTO>());
		res.getMembers().add(createMockGroupMemberDTO());
		return res;
	}
	
	private GroupMemberDTO createMockGroupMemberDTO() {
		GroupMemberDTO res = new GroupMemberDTO();
		res.setId("cer_W69AF7ZXCC6KT");
		res.setKind("member");
		return res;
	}
	
}
