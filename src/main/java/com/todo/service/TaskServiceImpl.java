package com.todo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.exception.TaskException;
import com.todo.exception.UserException;
import com.todo.model.Task;
import com.todo.model.User;
import com.todo.repository.TaskRepo;
import com.todo.repository.UserRepo;

@Service
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskRepo tr;
	
	@Autowired
	private UserRepo ur;
	
	
	@Override
	public Task addTask(Task task, Long userId) throws UserException {
		Optional<User>opt=ur.findById(userId);
		if(opt.isEmpty())
			throw new UserException("user not found with id : "+userId);
		
		User user=opt.get();
		
		task.setUser(user);
		
		return tr.save(task);
	}

	@Override
	public Task getTask(Long taskId) throws TaskException {
		Optional<Task> opt=tr.findById(taskId);
		if(opt.isEmpty())
			throw new TaskException("task not found with id : "+taskId);
		
		return opt.get();
	}

	@Override
	public Task deleteTask(Long taskId) throws TaskException {
		Optional<Task> opt=tr.findById(taskId);
		if(opt.isEmpty())
			throw new TaskException("task not found with id : "+taskId);
		
		tr.delete(opt.get());
		
		return opt.get();
	}

	@Override
	public Task editTask(Task task) throws TaskException {
		Optional<Task> opt=tr.findById(task.getId());
		if(opt.isEmpty())
			throw new TaskException("task not found with id : "+task.getId());
		
		Task saved=opt.get();
		
		if(task.getDescription()!=null)
			saved.setDescription(task.getDescription());
		
		if(task.getDueDate()!=null)
			saved.setDueDate(task.getDueDate());
		
		if(task.getTitle()!=null)
			saved.setTitle(task.getTitle());
		
		if(task.getCompleted()!=null)
			saved.setCompleted(task.getCompleted());
		
		return tr.save(saved);
	}

	@Override
	public Task setComplanation(Long taskId, Boolean isCompleted) throws TaskException {
		
		Optional<Task> opt=tr.findById(taskId);
		if(opt.isEmpty())
			throw new TaskException("task not found with id : "+taskId);
		
		Task saved=opt.get();
		
		saved.setCompleted(isCompleted);
		
		return tr.save(saved);
		
	}

	@Override
	public List<Task> completedTask(Long userId) throws TaskException, UserException {
		Optional<User>opt=ur.findById(userId);
		if(opt.isEmpty())
			throw new UserException("user not found with id : "+userId);
		
		List<Task>list=opt.get().getTasks();
		
		List<Task> filterd=list.stream().filter(t-> t.getCompleted()).collect(Collectors.toList());
		
		if(filterd.isEmpty())
			throw new TaskException("no completed task");
		
		return filterd;
	}

	@Override
	public List<Task> unCompletedTask(Long userId) throws TaskException, UserException {
		Optional<User>opt=ur.findById(userId);
		if(opt.isEmpty())
			throw new UserException("user not found with id : "+userId);
		
		List<Task>list=opt.get().getTasks();
		
		List<Task> filterd=list.stream().filter(t-> t.getCompleted()==false).collect(Collectors.toList());
		
		if(filterd.isEmpty())
			throw new TaskException("no pending task");
		
		return filterd;
	}

}
