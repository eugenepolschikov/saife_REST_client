package com.saife.dashboard.client.common;

public class DashboardException extends Exception {

	private static final long serialVersionUID = 1L;

	public DashboardException() {
		super();
	}

	public DashboardException(String message, Throwable cause) {
		super(message, cause);
	}

	public DashboardException(String message) {
		super(message);
	}

	public DashboardException(Throwable cause) {
		super(cause);
	}
	
}
