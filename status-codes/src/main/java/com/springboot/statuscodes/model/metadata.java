package com.springboot.statuscodes.model;

public class metadata {

	private Integer status;
	private String message;
	private String next;
	
	public metadata(Integer status, String message, String next) {
		super();
		this.status = status;
		this.message =message;
		this.next = next;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return message;
	}
	public void setMsg(String message) {
		this.message = message;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "httpMetadata [status=" + status + ", message=" + message + ", next=" + next + "]";
	}
}
