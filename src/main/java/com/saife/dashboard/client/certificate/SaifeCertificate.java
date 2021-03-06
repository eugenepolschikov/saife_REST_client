package com.saife.dashboard.client.certificate;

import java.util.Date;

import com.saife.dashboard.common.AbstractSaifeObject;
import com.saife.dashboard.common.SaifeObjectType;

public class SaifeCertificate extends AbstractSaifeObject {

	private static final long serialVersionUID = 1L;

	private String		capabilities;
	private String		certificateLeaf;
	private Date		createTime;
	private String		endpointId;
	private Date		expireTime;
	private String		fingerprint;
	private String		licenseId;
	private SaifeManager manager;
	private String		managerId;
	private Date		modifyTime;
	private String		organizationId;
	private Date		revokeTime;
	private String		name;
	private String		userId;

	public SaifeCertificate() {
		super();
		setObject(SaifeObjectType.certificate);
	}
	public String getCapabilities() {
		return capabilities;
	}
	public void setCapabilities(String capabilities) {
		System.out.println(capabilities);
	}
	public String getCertificateLeaf() {
		return certificateLeaf;
	}
	public void setCertificateLeaf(String certificateLeaf) {
		this.certificateLeaf = certificateLeaf;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getEndpointId() {
		return endpointId;
	}
	public void setEndpointId(String endpointId) {
		this.endpointId = endpointId;
	}
	public Date getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}
	public String getFingerprint() {
		return fingerprint;
	}
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
	public String getLicenseId() {
		return licenseId;
	}
	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}
	public SaifeManager getManager() {
		return manager;
	}
	public void setManager(SaifeManager manager) {
		this.manager = manager;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public Date getRevokeTime() {
		return revokeTime;
	}
	public void setRevokeTime(Date revokeTime) {
		this.revokeTime = revokeTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "SaifeCertificate [capabilities=" + capabilities + ", certificateLeaf=" + certificateLeaf
				+ ", createTime=" + createTime + ", endpointId=" + endpointId + ", expireTime=" + expireTime
				+ ", fingerprint=" + fingerprint + ", licenseId=" + licenseId + ", manager=" + manager + ", managerId="
				+ managerId + ", modifyTime=" + modifyTime + ", organizationId=" + organizationId + ", revokeTime="
				+ revokeTime + ", name=" + name + ", userId=" + userId + "]";
	}
}
