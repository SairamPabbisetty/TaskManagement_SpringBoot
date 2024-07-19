package com.std.springbootmvc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.std.springbootmvc.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByEmail(String name);

//	void deleteByEmail(String email); 
	
}
