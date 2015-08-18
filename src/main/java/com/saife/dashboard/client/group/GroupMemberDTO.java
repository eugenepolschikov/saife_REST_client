package com.saife.dashboard.client.group;

import com.saife.dashboard.client.common.SaifeObjects;
import com.saife.dashboard.client.common.SaifeDTO;

public class GroupMemberDTO extends SaifeDTO {

	private static final long serialVersionUID = 1L;

	private String kind;

	public GroupMemberDTO() {
		super();
		setObject(SaifeObjects.member);
	}
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
}
