package com.examportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.models.User;


public interface UserRepository extends JpaRepository<User, Long>  {
	public User findByUserName(String userName);
}
