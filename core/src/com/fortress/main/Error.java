package com.fortress.main;

public class Error {

	private String message;
	private SEVERITY severity;
	
	public enum SEVERITY{
		LOW,
		MEDIUM,
		HIGH
	}

	public Error(String message, SEVERITY severity) {
		this.message = message;
		this.severity = severity;
	}

	public String getMessage() {
		return message;
	}

	public SEVERITY getSeverity() {
		return severity;
	}
}
