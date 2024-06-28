package com.std.springbootmvc.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.springbootmvc.entity.Task;
import com.std.springbootmvc.entity.Users;
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

	@Override
	public TaskDto saveTask(long userId, TaskDto taskDto) {
		// TODO Auto-generated method stub
		Users user = userRepository.findById(userId).get(); 
		Task task = modelMapper.map(taskDto,  Task.class);
//		task.setUsers(user);
		Task savedTask = taskRepository.save(task);
		
		return modelMapper.map(savedTask,  TaskDto.class); 
	}

	@Override
	public List<TaskDto> getAllTasks(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
