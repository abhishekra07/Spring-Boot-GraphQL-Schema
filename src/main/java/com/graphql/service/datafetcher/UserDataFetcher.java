package com.graphql.service.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.model.User;
import com.graphql.repository.UserRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class UserDataFetcher implements DataFetcher<User>{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User get(DataFetchingEnvironment environment) {
		String id = environment.getArgument("id");
		return userRepository.findById(id).get();
	}

}
