package com.saife.dashboard.client.group;

import java.util.List;

import com.saife.dashboard.common.AbstractSaifeObject;
import com.saife.dashboard.common.SaifeObjectType;

public class SaifeGroup extends AbstractSaifeObject {

	private static final long serialVersionUID = 1L;

	private String kind;
    private String name;
    private String organizationId;
    private List<SaifeGroupMember>members;

	public SaifeGroup() {
		super();
		setObject(SaifeObjectType.group);
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

	public List<SaifeGroupMember> getMembers() {
		return members;
	}

	public void setMembers(List<SaifeGroupMember> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "SaifeGroup [id=" + id + ", object=" + object + ", kind=" + kind + ", name=" + name + ", organizationId="
				+ organizationId + ", members=" + members + "]";
	}

}
