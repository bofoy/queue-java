package com.bofoy.queue.controller;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Response {

	private long timestamp;
	
	private String status;
	
	private String message;
	
	private Object data;
	
	public Response(String status, String message) {
		this.timestamp = System.currentTimeMillis();
		this.status = status;
		this.message = message;
		this.data = JsonNodeFactory.instance.objectNode();
	}
	
	public Response(String status, String message, Object data) {
		this.timestamp = System.currentTimeMillis();
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return this.status;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public Object getData() {
		return data;
	}

	public void setData(ObjectNode data) {
		this.data = data;
	}
	
}
