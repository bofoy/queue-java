package com.bofoy.queue.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class Response {

	private int status;
	
	private long timestamp;
	
	private ObjectNode data;
	
	public Response(int status, ObjectNode data) {
		this.status = status;
		this.timestamp = System.currentTimeMillis();
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public ObjectNode getData() {
		return data;
	}

	public void setData(ObjectNode data) {
		this.data = data;
	}
	
}
