package com.todo.service;

import org.springframework.stereotype.Service;

import com.todo.exception.TaskException;
import com.todo.exception.UserException;
import com.todo.model.Task;

@Service
public class TaskServiceImpl implements TaskService{

	@Override
	public Task addTask(Task task, Long userId) throws UserException {
		return null;
	}

	@Override
	public Task getTask(Long taskId) throws TaskException {
		return null;
	}

	@Override
	public Task deleteTask(Long taskId) throws TaskException {
		return null;
	}

	@Override
	public Task editTask(Task task) throws TaskException {
		return null;
	}

}
