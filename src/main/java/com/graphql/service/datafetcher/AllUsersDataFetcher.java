package com.graphql.service.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.model.User;
import com.graphql.repository.UserRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllUsersDataFetcher implements DataFetcher<List<User>>{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> get(DataFetchingEnvironment environment) {
		return userRepository.findAll();
	}

}
