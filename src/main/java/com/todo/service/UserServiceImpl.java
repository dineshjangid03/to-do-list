package com.todo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.todo.exception.TaskException;
import com.todo.exception.UserException;
import com.todo.model.Task;
import com.todo.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public User registerUser(User user) {
		return null;
	}

	@Override
	public User getUser(Long id) throws UserException {
		return null;
	}

	@Override
	public List<Task> getUserTask(Long id) throws UserException, TaskException {
		return null;
	}

}
