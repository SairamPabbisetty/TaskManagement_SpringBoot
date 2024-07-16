package com.std.springbootmvc.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.springbootmvc.entity.Task;
import com.std.springbootmvc.entity.Users;
import com.std.springbootmvc.exception.ApiException;
import com.std.springbootmvc.exception.TaskNotFound;
import com.std.springbootmvc.exception.UserNotFound;
import com.std.springbootmvc.payload.TaskDto;
import com.std.springbootmvc.repository.TaskRepository;
import com.std.springbootmvc.repository.UserRepository;
import com.std.springbootmvc.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private ModelMapper modelMapper; 
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 
	private TaskRepository taskRepository;
	
//	@Autowired(required=true)
//	private Task task;
//	Spring is unable to autowire the Task entity. 
//	Typically, entities are not autowired as beans since they are simply representations of database tables 
//	and are managed by the JPA provider (Hibernate in this case).

	@Override
	public TaskDto saveTask(long userId, TaskDto taskDto) {
		// TODO Auto-generated method stub
		
		Users user = userRepository.findById(userId).orElseThrow(
				() -> new UserNotFound(String.format("User Id %d not found", userId))
				); 
		
		Task task = modelMapper.map(taskDto,  Task.class);
		
		task.setUser(user);
		
		System.out.println(task.toString());
		
		Task savedTask = taskRepository.save(task);
		
		return modelMapper.map(savedTask,  TaskDto.class); 
	}

	@Override
	public List<TaskDto> getAllTasks(long userId) {
		// TODO Auto-generated method stub
		
		userRepository.findById(userId).orElseThrow(
				() -> new UserNotFound(String.format("User Id %d not found", userId))
				); 
		
		List<Task> tasks = taskRepository.findAllByUserId(userId); 
		
		return tasks.stream().map(
				task -> modelMapper.map(task, TaskDto.class)
				).collect(Collectors.toList()); 
	}
	
	@Override 
	public TaskDto getTask(long userId, long taskId) {
		Users users = userRepository.findById(userId).orElseThrow(
				() -> new UserNotFound(String.format("User Id %d not found", userId))
				);
		Task task = taskRepository.findById(taskId).orElseThrow(
				() -> new TaskNotFound(String.format("Task id %d not found", taskId))
				);
		if(users.getId() != task.getUser().getId()) {
			throw new ApiException(String.format("Task Id %d doesn't belongs to User Id %d", taskId, userId));
		}
		return modelMapper.map(task, TaskDto.class); 
	}

	@Override
	public void deleteTask(long userId, long taskId) {
		// TODO Auto-generated method stub
		Users users = userRepository.findById(userId).orElseThrow(
				() -> new UserNotFound(String.format("User Id %d not found", userId))
				);
		Task task = taskRepository.findById(taskId).orElseThrow(
				() -> new TaskNotFound(String.format("Task id %d not found", taskId))
				);
		if(users.getId() != task.getUser().getId()) {
			throw new ApiException(String.format("Task Id %d doesn't belongs to User Id %d", taskId, userId));
		}
		taskRepository.deleteById(taskId); 
	}

}
