package com.graphql.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class User {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String gender;
	private String age;
	private String weight;
	private String height;
	private String skinColour;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Sport sport;
	private String[] hobbies;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Address address;
	private String followers;
	private String following;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Post post;
	public User(String id, String firstName, String lastName, String middleName, String gender, String age,
			String weight, String height, String skinColour, Sport favoriteSport, String[] hobbies, Address address,
			String followers, String following, Post post) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.skinColour = skinColour;
		this.sport = favoriteSport;
		this.hobbies = hobbies;
		this.address = address;
		this.followers = followers;
		this.following = following;
		this.post = post;
	}
	public User() {
		super();
	}
	
	
}
