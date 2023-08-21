package com.learning.springbootcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.springbootcrud.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
