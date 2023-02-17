package com.todo.service;

import com.todo.dto.Login;
import com.todo.exception.LoginException;
import com.todo.model.CurrentUserSession;

public interface UserLogin {
	
	public CurrentUserSession logIntoAccount(Login dto)throws LoginException;

	public String logOutFromAccount(String key)throws LoginException;

}
