package com.saife.dashboard.client.common;

public class SaifeException extends DashboardException {

	private static final long serialVersionUID = 1L;

	private SaifeErrors saifeError;

	public SaifeException(SaifeErrors saifeError) {
		super();
		this.saifeError = saifeError;
	}

	public SaifeException(SaifeErrors saifeError, String message, Throwable cause) {
		super(message, cause);
		this.saifeError = saifeError;
	}

	public SaifeException(SaifeErrors saifeError, String message) {
		super(message);
		this.saifeError = saifeError;
	}

	public SaifeException(SaifeErrors saifeError, Throwable cause) {
		super(cause);
		this.saifeError = saifeError;
	}

	public SaifeErrors getSaifeError() {
		return saifeError;
	}
	
}
