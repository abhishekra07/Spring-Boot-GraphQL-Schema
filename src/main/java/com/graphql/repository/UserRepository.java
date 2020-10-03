package com.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	
}
