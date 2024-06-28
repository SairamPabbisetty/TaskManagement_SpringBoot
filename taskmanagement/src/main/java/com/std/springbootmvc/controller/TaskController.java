package com.std.springbootmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.std.springbootmvc.payload.TaskDto;
import com.std.springbootmvc.service.TaskService;

@RestController 
@RequestMapping("/api")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	// save the task 
	@PostMapping("/{userid}/tasks")
	public ResponseEntity<TaskDto> saveTask(
		@PathVariable(name = "userid") long userId,
		@RequestBody TaskDto taskDto 
	){
		return new ResponseEntity<>(taskService.saveTask(userId, taskDto), HttpStatus.CREATED); 
	}
	
	//get all tasks 
	
	
	// get individual task 
	
	// delete individual task 
}
