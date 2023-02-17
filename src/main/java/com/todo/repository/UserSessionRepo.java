package com.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.model.CurrentUserSession;


@Repository
public interface UserSessionRepo extends JpaRepository<CurrentUserSession, Long>{
	
	public List<CurrentUserSession> findByUuid(String uuid);
	
}
