package com.saife.dashboard.client.certificate;

import java.util.Date;

import com.saife.dashboard.client.common.SaifeObjects;
import com.saife.dashboard.client.common.SaifeDTO;

public class ManagerDTO extends SaifeDTO {

	private static final long serialVersionUID = 1L;

	private String	certificateChain;
    private Date	createTime;
    private Date	expireTime;
    private String 	fingerprint;

    public ManagerDTO() {
    	super();
    	setObject(SaifeObjects.manager);
    }
    
    public String getCertificateChain() {
		return certificateChain;
	}
	public void setCertificateChain(String certificateChain) {
		this.certificateChain = certificateChain;
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
	public String getFingerprint() {
		return fingerprint;
	}
	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}
}
