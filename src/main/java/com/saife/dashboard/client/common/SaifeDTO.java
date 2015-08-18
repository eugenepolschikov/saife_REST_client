package com.saife.dashboard.client.common;

import java.io.Serializable;

public abstract class SaifeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String id;
	protected SaifeObjects object;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public SaifeObjects getObject() {
		return object;
	}

	public void setObject(SaifeObjects object) {
		this.object = object;
	}
	
}
