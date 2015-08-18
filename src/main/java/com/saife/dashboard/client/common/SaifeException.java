package com.saife.dashboard.client.common;

public class SaifeException extends Exception {

	private static final long serialVersionUID = 1L;

	public SaifeException() {
		super();
	}

	public SaifeException(String message, Throwable cause) {
		super(message, cause);
	}

	public SaifeException(String message) {
		super(message);
	}

	public SaifeException(Throwable cause) {
		super(cause);
	}
	
}
