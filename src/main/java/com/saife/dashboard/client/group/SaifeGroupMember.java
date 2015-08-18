package com.saife.dashboard.client.group;

import com.saife.dashboard.client.common.SaifeObjectType;
import com.saife.dashboard.client.common.SaifeObject;

public class SaifeGroupMember extends SaifeObject {

	private static final long serialVersionUID = 1L;

	private String kind;

	public SaifeGroupMember() {
		super();
		setObject(SaifeObjectType.member);
	}
	
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
}
