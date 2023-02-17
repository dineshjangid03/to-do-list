package com.todo.service;

import com.todo.exception.TaskException;
import com.todo.exception.UserException;
import com.todo.model.Task;

public interface TaskService {
	
	public Task addTask(Task task, Long userId) throws UserException;
	
	public Task getTask(Long taskId) throws TaskException;
	
	public Task deleteTask(Long taskId) throws TaskException;
	
	public Task editTask(Task task)throws TaskException;

}
