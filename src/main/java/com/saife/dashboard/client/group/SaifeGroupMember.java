package com.saife.dashboard.client.group;

import com.saife.dashboard.common.AbstractSaifeObject;
import com.saife.dashboard.common.SaifeObjectType;

public class SaifeGroupMember extends AbstractSaifeObject {

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

	@Override
	public String toString() {
		return "SaifeGroupMember [id=" + id + ", object=" + object + ", kind=" + kind + "]";
	}
}
