package com.graphql.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Post {
	@Id
	private String id;
	private String date;
	private String likes;
	private String comments;
	private String shared;
	
	public Post(String id, String date, String likes, String comments, String shared) {
		super();
		this.id = id;
		this.date = date;
		this.likes = likes;
		this.comments = comments;
		this.shared = shared;
	}

	public Post() {
		super();
	}
	
	
}
