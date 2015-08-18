package com.saife.dashboard.client.endpoint;

import java.util.List;

import com.saife.dashboard.client.common.SaifeDTO;
import com.saife.dashboard.client.common.SaifeObjects;

public class EndpointDTO extends SaifeDTO {

	private static final long serialVersionUID = 1L;

	private String name;
	private UserDTO user;
	private List<String> certificates;
	
	public EndpointDTO() {
		super();
		setObject(SaifeObjects.endpoint);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public List<String> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<String> certificates) {
		this.certificates = certificates;
	}

}
