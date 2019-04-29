package com.initgrep.compaigner.exception;

public class NotFoundException extends RuntimeException{
	private static final long serialVersionUID = -4127379902780412259L;

	private String message;

	public NotFoundException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	
}
