package com.graphql.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graphql.service.GraphQLService;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/rest/books")
public class BookResource {
	
	@Autowired
	GraphQLService graphQLService;
	
	@PostMapping
	public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
		ExecutionResult result = graphQLService.getGraphQL().execute(query);
		return new ResponseEntity<Object>(result,HttpStatus.OK);
	}
}
