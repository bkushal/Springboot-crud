package com.learning.springbootcrud.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.learning.springbootcrud.exceptions.ErrorDetails;
import com.learning.springbootcrud.exceptions.ResourceNotFoundException;
import com.learning.springbootcrud.models.User;
import com.learning.springbootcrud.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/users/get/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
		User user = service.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
/*	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request){
		
		ErrorDetails details = new ErrorDetails();
		details.setTimeStamp(LocalDateTime.now());
		details.setMessage(exception.getMessage());
		details.setPath(request.getDescription(false));
		details.setErrorCode("USER_NOT_FOUND");
		
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}*/
 
}
