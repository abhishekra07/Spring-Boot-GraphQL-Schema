package com.graphql.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Book {

	
	public Book(String isn, String title, String[] authors, String publisher, String publishedDate) {
		super();
		this.isn = isn;
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
	}
	public Book() {
		super();
	}
	@Id
	private String isn;
	private String title;
	private String[] authors;
	private String publisher;
	private String publishedDate;
}
