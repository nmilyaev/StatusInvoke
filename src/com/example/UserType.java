package com.example;

public enum UserType {

	NEW("NEW", "New User"),
	OLD("OLD", "Old User")
	;
	
	String name;
	String description;
	
	private UserType(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return getDescription();
	}
	
}
