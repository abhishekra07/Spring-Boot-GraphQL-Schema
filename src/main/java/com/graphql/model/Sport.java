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
public class Sport {
	
	public Sport() {
		super();
	}
	
	

	public Sport(String id, String name, String player) {
		super();
		this.id = id;
		this.name = name;
		this.player = player;
	}



	@Id
	private String id;
	private String name;
	private String player;
}
