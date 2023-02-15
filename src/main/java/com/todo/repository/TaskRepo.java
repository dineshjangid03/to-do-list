package com.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todo.model.Task;

public interface TaskRepo extends JpaRepository<Task, Integer> {

}
