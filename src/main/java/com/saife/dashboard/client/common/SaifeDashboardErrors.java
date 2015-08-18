package com.saife.dashboard.client.common;

public enum SaifeDashboardErrors {

	BAD_REQUEST			 (400, "Bad Request", "Your request is just wrong."),
	UNAUTHORIZED		 (401, "Unauthorized", "Your authentication is invalid."),
	FORBIDDEN			 (403, "Forbidden","The operation you attempted is not permitted by your roles."),
	NOT_FOUND			 (404, "Not Found", "The specified method is invalid; URL error."),
	METHOD_NOT_ALLOWED	 (405, "Method Not Allowed", "You tried to access a valid URL with an invalid method."),
	NOT_ACCEPTABLE		 (406, "Not Acceptable", "You requested a format that isn’t JSON."),
	GONE				 (410, "Gone", "The object you’re operating on doesn’t exist."),
	IM_TEAPOT			 (418, "I’m A Teapot", "This URL is unable to process non-tea brewing requests."),
	TOO_MANY_REQUESTS	 (429, "Too Many Requests", "You’re overwhelming the worker bees! Slow down!"),
	INTERNAL_SERVER_ERROR(500, "Internal Server Error", "We had a problem with our server. Try again later."),
	SERVICE_UNAVAILABLE	 (503, "Service Unavailable", "We’re temporarily offline for maintenance. Please try again later.");
	
	private int code;
	private String error, description;
	
	SaifeDashboardErrors(int code, String error, String description) {
		this.code = code;
		this.error = error;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getError() {
		return error;
	}

	public String getDescription() {
		return description;
	}
	
}
