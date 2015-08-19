package com.saife.dashboard.client.user;

import com.saife.dashboard.client.common.AbstractSaifeObject;
import com.saife.dashboard.client.common.SaifeObjectType;

public class SaifeUser extends AbstractSaifeObject {

	private static final long serialVersionUID = 1L;

	private String firstName;
	private boolean disabled;
	private String lastName;
	private String profileImageUrl;
	
	public SaifeUser() {
		super();
		setObject(SaifeObjectType.user);
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
