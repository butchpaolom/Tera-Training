package com.models;

public class Person {
	private String firstName;
	private String lastName;
	private String middleInitial;
	private String imageURL;
	
	public Person(String firstName, String lastName, String middleInitial, String imageURL) {
		this.setFirstName(firstName);
		this.lastName = lastName;
		this.middleInitial = middleInitial;
		this.imageURL = imageURL;
	}

	private String getFirstName() {
		return firstName;
	}

	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}
