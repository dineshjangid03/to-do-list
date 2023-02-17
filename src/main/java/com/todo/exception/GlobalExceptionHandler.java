package com.todo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.todo.dto.ExceptionDTO;





@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TaskException.class)
	public ResponseEntity<ExceptionDTO> taskExceptionHandler(TaskException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ExceptionDTO> userExceptionHandler(TaskException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ExceptionDTO> loginExceptionHandler(LoginException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	
//	==========================================================================
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionDTO> validationExceptionHandler(MethodArgumentNotValidException e){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(e.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionDTO> nullPointerExceptionHandler(NullPointerException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionDTO> noHandlerFoundException(NoHandlerFoundException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDTO> masterExceptionHandler(Exception e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}

}
