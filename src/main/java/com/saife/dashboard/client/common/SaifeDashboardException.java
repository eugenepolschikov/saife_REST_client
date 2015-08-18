package com.saife.dashboard.client.common;

public class SaifeDashboardException extends SaifeException {

	private static final long serialVersionUID = 1L;

	private SaifeDashboardError saifeError;

	public SaifeDashboardException(SaifeDashboardError saifeError) {
		super();
		this.saifeError = saifeError;
	}

	public SaifeDashboardException(SaifeDashboardError saifeError, String message, Throwable cause) {
		super(message, cause);
		this.saifeError = saifeError;
	}

	public SaifeDashboardException(SaifeDashboardError saifeError, String message) {
		super(message);
		this.saifeError = saifeError;
	}

	public SaifeDashboardException(SaifeDashboardError saifeError, Throwable cause) {
		super(cause);
		this.saifeError = saifeError;
	}

	public SaifeDashboardError getSaifeError() {
		return saifeError;
	}
	
}
