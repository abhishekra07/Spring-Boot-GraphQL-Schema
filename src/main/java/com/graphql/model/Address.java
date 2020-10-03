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
public class Address {
	@Id
	private String id;
	private String address;
	private String landmark;
	private String district;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	
	public Address(String id, String address, String landmark, String district, String city, String state, String country,
			String zipCode) {
		super();
		this.id = id;
		this.address = address;
		this.landmark = landmark;
		this.district = district;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

	public Address() {
		super();
	}
	
	
	
}
