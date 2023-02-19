package com.todo.service;

import java.util.List;

import com.todo.exception.TaskException;
import com.todo.exception.UserException;
import com.todo.model.Task;

public interface TaskService {
	
	public Task addTask(Task task, Long userId) throws UserException;
	
	public Task getTask(Long taskId) throws TaskException;
	
	public Task deleteTask(Long taskId) throws TaskException;
	
	public Task editTask(Task task)throws TaskException;
	
	public Task setComplanation(Long taskId, Boolean isCompleted)throws TaskException;
	
	public List<Task> completedTask(Long userId)throws TaskException,UserException;
	
	public List<Task> unCompletedTask(Long userId)throws TaskException,UserException;

}
