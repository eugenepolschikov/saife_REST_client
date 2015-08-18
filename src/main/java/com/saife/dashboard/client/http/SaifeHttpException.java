package com.saife.dashboard.client.http;

import com.saife.dashboard.client.common.SaifeDashboardError;

public class SaifeHttpException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private SaifeDashboardError saifeError;

	public SaifeHttpException(SaifeDashboardError saifeError, String message) {
		super(message);
		this.saifeError = saifeError;
	}

	public SaifeDashboardError getSaifeError() {
		return saifeError;
	}
	
}
