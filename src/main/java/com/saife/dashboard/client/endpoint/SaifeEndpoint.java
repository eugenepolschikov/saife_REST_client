package com.saife.dashboard.client.endpoint;

import java.util.List;

import com.saife.dashboard.client.user.SaifeUser;
import com.saife.dashboard.common.AbstractSaifeObject;
import com.saife.dashboard.common.SaifeObjectType;

public class SaifeEndpoint extends AbstractSaifeObject {

	private static final long serialVersionUID = 1L;

	private String name;
	private SaifeUser user;
	private List<String> certificates;

	public SaifeEndpoint() {
		super();
		setObject(SaifeObjectType.endpoint);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SaifeUser getUser() {
		return user;
	}

	public void setUser(SaifeUser user) {
		this.user = user;
	}

	public List<String> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<String> certificates) {
		this.certificates = certificates;
	}

}
