package com.std.springbootmvc.payload;

//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter

public class UserDto {
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private long id;
	private String name;
	private String email;
	private String password; 
}
