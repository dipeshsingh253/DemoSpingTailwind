package com.ecommerce.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<ErrorDetails> categoryExceptionHandler(CategoryException e, WebRequest request){
		
		
		ErrorDetails details = new ErrorDetails(e.getMessage(), LocalDateTime.now(), request.getDescription(false));
		
		
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ErrorDetails> productExceptionHandler(ProductException e, WebRequest request){
		
		
		ErrorDetails details = new ErrorDetails(e.getMessage(), LocalDateTime.now(), request.getDescription(false));
		
		
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorDetails> userExceptionHandler(UserException e, WebRequest request){
		
		
		ErrorDetails details = new ErrorDetails(e.getMessage(), LocalDateTime.now(), request.getDescription(false));
		
		
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> defaultExceptionHandler(Exception e, WebRequest request){
		
		
		ErrorDetails details = new ErrorDetails(e.getMessage(), LocalDateTime.now(), request.getDescription(false));
		
		
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.BAD_REQUEST);
		
	}
	
	
}
