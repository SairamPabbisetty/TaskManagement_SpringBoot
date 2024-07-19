package com.std.springbootmvc.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.springbootmvc.entity.Users;
import com.std.springbootmvc.exception.UserNotFound;
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
		Users user = modelMapper.map(userDto, Users.class);
		Users savedUsers = userRepository.save(user);

//		return entityToUserDto(savedUsers); 
		return modelMapper.map(savedUsers, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<Users> users = userRepository.findAll();
		
//		System.out.println(users);

		return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto getUser(String email) {
		// TODO Auto-generated method stub 
		Users user = userRepository.findByEmail(email).orElseThrow(
				() -> new UserNotFound(String.format("User with email %s not found", email))
				); 
		
		return modelMapper.map(user, UserDto.class); 
	}

//	@Override
//	@Transactional
//	public void deleteTask(String email) {
//		// TODO Auto-generated method stub
//		Users users = userRepository.findByEmail(email).orElseThrow(
//				() -> new UserNotFound(String.format("User with email %s not found", email))
//				);
//		userRepository.deleteByEmail(email);
//	}
	
	

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
