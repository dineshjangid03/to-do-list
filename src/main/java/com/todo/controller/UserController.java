package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.dto.Login;
import com.todo.exception.LoginException;
import com.todo.exception.TaskException;
import com.todo.exception.UserException;
import com.todo.model.CurrentUserSession;
import com.todo.model.Task;
import com.todo.model.User;
import com.todo.service.UserLogin;
import com.todo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService us;
	
	@Autowired
	private UserLogin ul;
	
	@GetMapping("/hello")
	public String hello() {
		return "Welcome";
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user){
		return new ResponseEntity<User>(us.registerUser(user), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) throws UserException{
		return new ResponseEntity<User>(us.getUser(id),HttpStatus.OK);
	}
	
	@GetMapping("/getAllTask/{id}")
	public ResponseEntity<List<Task>> getUserTask(@PathVariable("id") Long id) throws UserException, TaskException{
		return new ResponseEntity<List<Task>>(us.getUserTask(id),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> logIntoAccount(@RequestBody Login dto)throws LoginException{
		return new ResponseEntity<CurrentUserSession>(ul.logIntoAccount(dto),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/logout/{key}")
	public ResponseEntity<String> logOutFromAccount(@PathVariable("key") String key)throws LoginException{
		return new ResponseEntity<String>(ul.logOutFromAccount(key),HttpStatus.OK);
	}
	
}
