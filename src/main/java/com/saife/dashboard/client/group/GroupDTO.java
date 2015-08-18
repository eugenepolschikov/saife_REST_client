package com.saife.dashboard.client.group;

import java.util.List;

import com.saife.dashboard.client.common.SaifeObjects;
import com.saife.dashboard.client.common.SaifeDTO;

public class GroupDTO extends SaifeDTO {

	private static final long serialVersionUID = 1L;

	private String kind;
    private String name;
    private String organizationId;
    private List<GroupMemberDTO>members;
	
	public GroupDTO() {
		super();
		setObject(SaifeObjects.group);
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public List<GroupMemberDTO> getMembers() {
		return members;
	}

	public void setMembers(List<GroupMemberDTO> members) {
		this.members = members;
	}

}
