package com.saife.dashboard.client.apikey;

import java.util.List;

import com.saife.dashboard.common.SaifeObjectList;

public class SaifeApiKeyList extends SaifeObjectList {

	private static final long serialVersionUID = 1L;

	private List<SaifeApiKey>data;

	public List<SaifeApiKey> getData() {
		return data;
	}

	public void setData(List<SaifeApiKey> data) {
		this.data = data;
	}
}
