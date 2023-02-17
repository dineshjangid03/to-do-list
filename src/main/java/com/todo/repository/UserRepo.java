package com.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.model.User;

public interface UserRepo extends JpaRepository<User, Long> {
	public List<User> findByUsername(String username);
}
