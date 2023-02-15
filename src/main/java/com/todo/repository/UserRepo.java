package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
