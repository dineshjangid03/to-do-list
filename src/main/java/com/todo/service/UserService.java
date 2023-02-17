package com.todo.service;

import java.util.List;

import com.todo.exception.TaskException;
import com.todo.exception.UserException;
import com.todo.model.Task;
import com.todo.model.User;

public interface UserService {
	
	public User registerUser(User user);
	
	public User getUser(Long id) throws UserException;
	
	public List<Task> getUserTask(Long id) throws UserException, TaskException;

}
