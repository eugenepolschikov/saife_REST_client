package com.saife.dashboard.common;

public class SaifeClientException extends SaifeException {

	private static final long serialVersionUID = 1L;

	public SaifeClientException() {
		super();
	}

	public SaifeClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public SaifeClientException(String message) {
		super(message);
	}

	public SaifeClientException(Throwable cause) {
		super(cause);
	}

}
