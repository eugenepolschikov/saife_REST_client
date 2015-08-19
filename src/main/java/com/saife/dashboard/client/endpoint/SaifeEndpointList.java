package com.saife.dashboard.client.endpoint;

import java.util.List;

import com.saife.dashboard.common.SaifeObjectList;

public class SaifeEndpointList extends SaifeObjectList {

	private static final long serialVersionUID = 1L;

	private List<SaifeEndpoint>data;

	public List<SaifeEndpoint> getData() {
		return data;
	}

	public void setData(List<SaifeEndpoint> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("SaifeEndpointList [object=" + object + ", hasMore=" + hasMore + ", data=[");
		if (data != null) {
			for (SaifeEndpoint se : data) {
				sb.append('\n').append(se);
			}
		}
		sb.append("\n]]");
		return sb.toString();
	}
	
	

}
