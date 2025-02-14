package com.example.demo_ikon.exception;

public class BadRequestException extends RuntimeException {

	public BadRequestException(String message) {
        super(message);
    }
	
}