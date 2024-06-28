package com.std.springbootmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
