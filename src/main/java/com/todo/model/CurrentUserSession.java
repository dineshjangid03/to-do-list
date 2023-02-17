package com.todo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class CurrentUserSession {
	
	@Id
	@Column(unique = true)
	private Long userId;
	
	private String uuid;
	
	private LocalDateTime localDateTime;

}
