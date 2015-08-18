package com.saife.dashboard.client.endpoint;

import java.util.List;

import com.saife.dashboard.client.common.SaifeObjectList;

public class SaifeEndpointList extends SaifeObjectList {

	private static final long serialVersionUID = 1L;
	
	private List<SaifeEndpoint>data;

	public List<SaifeEndpoint> getData() {
		return data;
	}

	public void setData(List<SaifeEndpoint> data) {
		this.data = data;
	}

}
