package com.std.springbootmvc.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.std.springbootmvc.entity.Users;
import com.std.springbootmvc.payload.UserDto;
import com.std.springbootmvc.repository.UserRepository;
import com.std.springbootmvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	private UserRepository userRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
//		Users user = userDtoToEntity(userDto);
		Users user = modelMapper.map(userDto,  Users.class);
		Users savedUsers = userRepository.save(user);
		
//		return entityToUserDto(savedUsers); 
		return modelMapper.map(savedUsers,  UserDto.class);
	}
	
//	private Users userDtoToEntity(UserDto userDto) {
//		Users users = new Users();
//		users.setName(userDto.getName()); 
//		users.setEmail(userDto.getEmail()); 
//		users.setPassword(userDto.getPassword());  
//		
//		return users;
//	}
//	
//	private UserDto entityToUserDto(Users savedUser) {
//		UserDto userDto = new UserDto();
//		userDto.setId((savedUser.getId()));
//		userDto.setEmail((savedUser.getEmail()));
//		userDto.setPassword((savedUser.getPassword()));
//		userDto.setName((savedUser.getName()));
//		
//		return userDto; 
//	}
	
}
