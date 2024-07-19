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

import com.std.springbootmvc.payload.UserDto;
import com.std.springbootmvc.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	// post - store the user data in DB 
	@PostMapping("/register") 
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto usersDto) {
		return new ResponseEntity<>(userService.createUser(usersDto), HttpStatus.CREATED);
	}
	
	//get all users 
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllTasks(){
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK); 
	}
	
	// get user by email 
	@GetMapping("/users/{email}")
	public ResponseEntity<UserDto> getUser(
			@PathVariable(name="email") String email
			){
		return new ResponseEntity<>(userService.getUser(email), HttpStatus.OK);
	}
	
//	// delete a user by email 
//	@DeleteMapping("/users/{email}")
//	public ResponseEntity<String> deleteTask(
//			@PathVariable(name="email") String email
//			){
//		userService.deleteTask(email);
//		return new ResponseEntity<>("Task Deleted Successfully", HttpStatus.OK); 
//	}
}
