package com.example;

import java.util.ArrayList;
import java.util.List;

public class UserForm {
	
	List<UserEntity> users = new ArrayList<UserEntity>();

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
}
