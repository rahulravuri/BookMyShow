package com.BookMyShow.BookMyShow.Exceptions;

public class InvalidJwtException extends Exception{
	public InvalidJwtException() {
		super();
	}
	public InvalidJwtException(String message) {
		super(message);
		
	}
	public InvalidJwtException(String message, Throwable cause) {
		super(message,cause);
	}

}
