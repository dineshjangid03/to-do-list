package com.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.exception.TaskException;
import com.todo.exception.UserException;
import com.todo.model.Task;
import com.todo.model.User;
import com.todo.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo ur;

	@Override
	public User registerUser(User user) {
		return ur.save(user);
	}

	@Override
	public User getUser(Long id) throws UserException {
		Optional<User>opt=ur.findById(id);
		if(opt.isEmpty())
			throw new UserException("user not found with id : "+id);
		return opt.get();
	}

	@Override
	public List<Task> getUserTask(Long id) throws UserException, TaskException {
		Optional<User>opt=ur.findById(id);
		if(opt.isEmpty())
			throw new UserException("user not found with id : "+id);
		
		List<Task> list=opt.get().getTasks();
		
		if(list.size()==0)
			throw new TaskException("no task found for id : "+id);
			
		return list;
		
	}

}
