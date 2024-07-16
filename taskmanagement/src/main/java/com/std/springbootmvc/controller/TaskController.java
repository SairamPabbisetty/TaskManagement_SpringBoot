package com.std.springbootmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
		@PathVariable(name="userid") long userid,
		@RequestBody TaskDto taskDto 
	){
		System.out.println(taskDto.getTaskname());
		return new ResponseEntity<>(taskService.saveTask(userid, taskDto), HttpStatus.CREATED); 
	}
	
	//get all tasks 
	@GetMapping("/{userid}/tasks")
	public ResponseEntity<List<TaskDto>> getAllTasks(
			@PathVariable(name="userid") long userid
			){
		return new ResponseEntity<>(taskService.getAllTasks(userid), HttpStatus.OK); 
	}
	
	// get individual task 
	@GetMapping("/{userId}/tasks/{taskId}")
	public ResponseEntity<TaskDto> getTask(
			@PathVariable(name="userId") long userId,
			@PathVariable(name="taskId") long taskId
			){
		return new ResponseEntity<>(taskService.getTask(userId, taskId), HttpStatus.OK); 
	}
	
	// delete individual task 
	@DeleteMapping("/{userId}/tasks/{taskId}")
	public ResponseEntity<String> deleteTask(
			@PathVariable(name="userId") long userId,
			@PathVariable(name="taskId") long taskId
			){
		taskService.deleteTask(userId, taskId);
		return new ResponseEntity<>("Task Deleted Successfully", HttpStatus.OK); 
	}
}
