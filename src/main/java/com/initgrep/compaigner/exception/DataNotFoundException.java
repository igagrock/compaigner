package com.initgrep.compaigner.exception;

public class DataNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	

	public DataNotFoundException() {
		super();
	}

	public DataNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DataNotFoundException(String message) {
		super(message, null);
	}
	
	public DataNotFoundException(String message, Throwable thrw) {
		super(message, thrw);
	}

	public DataNotFoundException(Throwable cause) {
		super(cause);
	}

	
	
	
	

}
