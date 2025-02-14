package com.example.demo_ikon.controller.advisor;

import com.example.demo_ikon.exception.BadRequestException;
import com.example.demo_ikon.model.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
		BaseResponse<String> errorResponse = BaseResponse.<String>builder()
				.message(HttpStatus.BAD_REQUEST.name() + " - " + ex.getMessage())
				.status(HttpStatus.BAD_REQUEST.value())
				.build();
	    return ResponseEntity
	    		.status(HttpStatus.BAD_REQUEST)
	    		.body(errorResponse);
	}


}
