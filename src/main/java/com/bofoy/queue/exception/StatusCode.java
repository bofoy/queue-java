package com.bofoy.queue.exception;

public enum StatusCode {

	LOGIN_SUCCESSFUL("Login successful"),
	LOGIN_FAILED("Login failed for unknown reasons"),
	INCORRECT_PASSWORD("Incorrect password"),
	USER_DOES_NOT_EXIST("User does not exist"),
	SIGNUP_SUCCESSFUL("Signup successful"),
	ALREADY_EXISTS("Username or email already exists"),
	SIGNUP_FAILED("User signup failed"); //generic signup failed error
	
	private String message;
	
	private StatusCode(String message) {
		this.message = message;
	}
	
	public String getStatusMessage() {
		return this.message;
	}
	
}


