package com.learning.spring.rest;

public class StudentErrorResponse {

	private int status;
	private String message;
	private long timeStamp;

	public StudentErrorResponse() {

	}

	public StudentErrorResponse(int status, String message, long timrStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timrStamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timrStamp) {
		this.timeStamp = timrStamp;
	}

}
