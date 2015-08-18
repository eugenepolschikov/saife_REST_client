package com.saife.dashboard.client.common;

public class SaifeDashboardException extends SaifeException {

	private static final long serialVersionUID = 1L;

	private SaifeDashboardErrors saifeError;

	public SaifeDashboardException(SaifeDashboardErrors saifeError) {
		super();
		this.saifeError = saifeError;
	}

	public SaifeDashboardException(SaifeDashboardErrors saifeError, String message, Throwable cause) {
		super(message, cause);
		this.saifeError = saifeError;
	}

	public SaifeDashboardException(SaifeDashboardErrors saifeError, String message) {
		super(message);
		this.saifeError = saifeError;
	}

	public SaifeDashboardException(SaifeDashboardErrors saifeError, Throwable cause) {
		super(cause);
		this.saifeError = saifeError;
	}

	public SaifeDashboardErrors getSaifeError() {
		return saifeError;
	}
	
}
