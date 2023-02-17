package com.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.exception.TaskException;
import com.todo.exception.UserException;
import com.todo.model.Task;
import com.todo.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	
	@Autowired
	private TaskService ts;
	
	@PostMapping("/add/{userId}")
	public ResponseEntity<Task> addTask(@RequestBody Task task, @PathVariable("userId") Long userId) throws UserException{
		return new ResponseEntity<Task>(ts.addTask(task, userId),HttpStatus.OK);
	}
	
	@GetMapping("/get/{taskId}")
	public ResponseEntity<Task> getTask(@PathVariable("taskId") Long taskId) throws TaskException{
		return new ResponseEntity<Task>(ts.getTask(taskId),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{taskId}")
	public ResponseEntity<Task> deleteTask(@PathVariable("taskId") Long taskId) throws TaskException{
		return new ResponseEntity<Task>(ts.deleteTask(taskId),HttpStatus.OK);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<Task> editTask(@RequestBody Task task)throws TaskException{
		return new ResponseEntity<Task>(ts.editTask(task),HttpStatus.OK);
	}

}
