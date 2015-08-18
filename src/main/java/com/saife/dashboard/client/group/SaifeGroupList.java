package com.saife.dashboard.client.group;

import java.util.List;

import com.saife.dashboard.client.common.SaifeObjectList;

public class SaifeGroupList extends SaifeObjectList {

	private static final long serialVersionUID = 1L;

	private List<SaifeGroup>data;

	public List<SaifeGroup> getData() {
		return data;
	}

	public void setData(List<SaifeGroup> data) {
		this.data = data;
	}
}
