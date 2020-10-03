package com.graphql.service.datafetcher;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.graphql.model.Book;
import com.graphql.repository.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class BookDataFetcher implements DataFetcher<Book>{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public Book get(DataFetchingEnvironment environment) {
		String isn = environment.getArgument("id");
		return bookRepository.findByIsn(isn);
	}

}
