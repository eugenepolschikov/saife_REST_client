package com.saife.dashboard.client.certificate;

import java.util.List;

import com.saife.dashboard.client.common.SaifeObjectList;

public class SaifeCertificateList extends SaifeObjectList {

	private static final long serialVersionUID = 1L;

	private List<SaifeCertificate>data;

	public List<SaifeCertificate> getData() {
		return data;
	}

	public void setData(List<SaifeCertificate> data) {
		this.data = data;
	}
	
	
	
}
