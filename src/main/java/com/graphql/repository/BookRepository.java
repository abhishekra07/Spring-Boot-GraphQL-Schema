package com.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.model.Book;

public interface BookRepository extends JpaRepository<Book, String>{
	Book findByIsn(String isn);
}
