package com.saife.dashboard.client.common;

import java.util.List;

public class SaifeObjectList <T> extends SaifeObject {

	private static final long serialVersionUID = 1L;

	private List<T>data;
	private boolean hasMore;

	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public boolean isHasMore() {
		return hasMore;
	}
	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}
	
}
