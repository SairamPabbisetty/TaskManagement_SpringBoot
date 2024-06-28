package com.std.springbootmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.std.springbootmvc.entity.Users; 

public interface UserRepository extends JpaRepository<Users, Long> {
	
}
