package com.saife.dashboard.client.apikey;

import java.util.Date;

import com.saife.dashboard.common.AbstractSaifeObject;
import com.saife.dashboard.common.SaifeObjectType;

public class SaifeApiKey extends AbstractSaifeObject {

	private static final long serialVersionUID = 1L;

	private String apiKey;
	private String name;
	private String description;
	private String organizationId;
	private Date createTime;
	private Date expireTime;

	public SaifeApiKey() {
		super();
		setObject(SaifeObjectType.apikey);
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

}
