package com.springboot.statuscodes.model;

import org.springframework.http.HttpStatusCode;

public class errorResponseBody {
	
	private String timestamp;
	private int status;
	private HttpStatusCode error;
	private String message;
	private String path;

	public errorResponseBody(String timestamp, int status, HttpStatusCode error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public HttpStatusCode getError() {
		return error;
	}
	public void setError(HttpStatusCode error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "ErrorResponseBody [timestamp=" + timestamp + ", status=" + status + ", error=" + error + ", message="
				+ message + ", path=" + path + "]";
	}
}
