package com.saife.dashboard.common;

import com.google.gson.annotations.SerializedName;

public abstract class SaifeObjectList extends AbstractSaifeObject {

	private static final long serialVersionUID = 1L;

	@SerializedName("has_more")
	private boolean hasMore;

	public boolean isHasMore() {
		return hasMore;
	}
	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}

}
