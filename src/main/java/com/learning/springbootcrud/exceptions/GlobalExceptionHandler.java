package com.learning.springbootcrud.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler{
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request){
		
		ErrorDetails details = new ErrorDetails();
		details.setTimeStamp(LocalDateTime.now());
		details.setMessage(exception.getMessage());
		details.setPath(request.getDescription(false));
		details.setErrorCode("USEaaR_NOT_FOUND");
		
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest request){
		
		ErrorDetails details = new ErrorDetails();
		details.setTimeStamp(LocalDateTime.now());
		details.setMessage(exception.getMessage());
		details.setPath(request.getDescription(false));
		details.setErrorCode("Internal_Server_Errors");
		
		return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
