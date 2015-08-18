package com.saife.dashboard.client.endpoint;

import com.saife.dashboard.client.common.SaifeDTO;
import com.saife.dashboard.client.common.SaifeObjects;

public class UserDTO extends SaifeDTO {

	private static final long serialVersionUID = 1L;

    private String firstName;
    private boolean disabled;
    private String lastName;
    private String profileImageUrl;
	
	public UserDTO() {
		super();
		setObject(SaifeObjects.user);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

}
