package com.todo.service;

import com.todo.model.User;

public interface UserService {
	
	public User loadUserByUsername(String username);

}
