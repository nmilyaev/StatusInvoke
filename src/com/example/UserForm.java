package com.example;

import java.util.ArrayList;
import java.util.List;

public class UserForm {
	
	private List<UserEntity> users = new ArrayList<UserEntity>();
	private String name;

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
