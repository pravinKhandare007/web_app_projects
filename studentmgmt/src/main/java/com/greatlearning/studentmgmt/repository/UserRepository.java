package com.greatlearning.studentmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.studentmgmt.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("Select u from User u where u.username = ?1")
	public User getUserByUsername(String username);
}
