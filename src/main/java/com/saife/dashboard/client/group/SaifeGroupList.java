package com.saife.dashboard.client.group;

import java.util.List;

import com.saife.dashboard.client.endpoint.SaifeEndpoint;
import com.saife.dashboard.common.SaifeObjectList;

public class SaifeGroupList extends SaifeObjectList {

	private static final long serialVersionUID = 1L;

	private List<SaifeGroup>data;

	public List<SaifeGroup> getData() {
		return data;
	}

	public void setData(List<SaifeGroup> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("SaifeEndpointList [object=" + object + ", hasMore=" + hasMore + ", data=[");
		if (data != null) {
			for (SaifeGroup sg : data) {
				sb.append('\n').append(sg);
			}
		}
		sb.append("\n]]");
		return sb.toString();
	}
}
