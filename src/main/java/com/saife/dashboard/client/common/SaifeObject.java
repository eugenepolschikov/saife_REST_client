package com.saife.dashboard.client.common;

import java.io.Serializable;

public abstract class SaifeObject implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String id;
	protected SaifeObjectType object;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SaifeObjectType getObject() {
		return object;
	}

	public void setObject(SaifeObjectType object) {
		this.object = object;
	}
	
}
