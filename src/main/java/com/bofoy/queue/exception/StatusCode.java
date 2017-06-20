package com.bofoy.queue.exception;

public enum StatusCode {

	LOGIN_SUCCESSFUL("LOGIN_SUCCESSFUL"),
	LOGIN_FAILED("LOGIN_FAILED"),
	INCORRECT_PASSWORD("INCORRECT_PASSWORD"),
	
	SIGNUP_SUCCESSFUL("SIGNUP_SUCCESSFUL"),
	SIGNUP_FAILED("SIGNUP_FAILED"),
	
	USER_DELETE_FAILED("USER_DELETE_FAILED"),
	USER_DELETE_SUCCESS("USER_DELETE_SUCCESS"),
	USER_ALREADY_EXISTS("USER_EXISTS"),
	USER_DOES_NOT_EXIST("USER_DOES_NOT_EXIST"),
	USER_FOUND("USER_FOUND"),
	
	ROLE_DELETE_FAILED("ROLE_DELETE_FAILED"),
	ROLE_DELETE_SUCCESS("ROLE_DELETE_SUCCESS"),
	ROLE_ALREADY_EXISTS("ROLE_ALREADY_EXISTS"),
	ROLE_DOES_NOT_EXIST("ROLE_DOES_NOT_EXIST"),
	ROLE_FOUND("ROLE_FOUND"),
	
	PROFILE_FOUND("PROFILE_FOUND"),
	PROFILE_NOT_FOUND("PROFILE_NOT_FOUND"),
	
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


