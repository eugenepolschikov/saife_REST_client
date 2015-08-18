package com.saife.dashboard.client.common;

public abstract class SaifeObjectList extends AbstractSaifeObject {

	private static final long serialVersionUID = 1L;

	private boolean hasMore;

	public boolean isHasMore() {
		return hasMore;
	}
	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}
	
}
