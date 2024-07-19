package com.std.springbootmvc.service;

import java.util.List;

import com.std.springbootmvc.payload.UserDto;

public interface UserService {
	
	public UserDto createUser(UserDto userDto);

	public List<UserDto> getAllUsers();

	public UserDto getUser(String username);

//	public void deleteTask(String email); 
}
