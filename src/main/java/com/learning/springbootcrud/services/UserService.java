package com.learning.springbootcrud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springbootcrud.exceptions.ResourceNotFoundException;
import com.learning.springbootcrud.models.User;
import com.learning.springbootcrud.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repo;
	
	public User getUserById(Long id) {
		Optional<User> uop = repo.findById(id);
		if(uop.isEmpty()) {
			throw new ResourceNotFoundException("","","");
		}
		return uop.get();
	}
}
