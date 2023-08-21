package com.learning.springbootcrud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	private String resourceName;
	private String fieldName;
	private String fieldValue;
	
	
	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
		super("RTesource is not found for this values input");
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	
	
	
	
}
