package com.std.springbootmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.std.springbootmvc.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findAllByUsersId(long userId); 
	
}
