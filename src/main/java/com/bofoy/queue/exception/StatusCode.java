package com.bofoy.queue.exception;

public enum StatusCode {

	LOGIN_SUCCESSFUL("LOGIN_SUCCESSFUL"),
	LOGIN_FAILED("LOGIN_FAILED"),
	INCORRECT_PASSWORD("INCORRECT_PASSWORD"),
	SIGNUP_SUCCESSFUL("SIGNUP_SUCCESSFUL"),
	USER_DELETE_FAILED("USER_DELETE_FAILED"),
	USER_DELETE_SUCCESS("USER_DELETE_SUCCESS"),
	USER_ALREADY_EXISTS("USER_EXISTS"),
	USER_DOES_NOT_EXIST("USER_DOES_NOT_EXIST"),
	USER_FOUND("USER_FOUND"),
	SIGNUP_FAILED("SIGNUP_FAILED"),
	SUCCESS("SUCCESS"),
	FAILED("FAILED");
	
	private String message;
	
	private StatusCode(String message) {
		this.message = message;
	}
	
	public String getStatusMessage() {
		return this.message;
	}
	
}


