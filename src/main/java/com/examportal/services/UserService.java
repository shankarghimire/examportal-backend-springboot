package com.examportal.services;

import java.util.List;
import java.util.Set;

import com.examportal.models.User;
import com.examportal.models.UserRole;

public interface UserService {
	//Create new user
		User createUser(User user, Set<UserRole> userRoles) throws Exception;
		
		//Get All Users
		List<User>findUsers();
		//Get user by username
		User getUserName(String userName);
		
		//Get User by user Id
		User getUserById(long id);
		
		//Delete user by id
		void deleteUser(Long userId);
		
		//Update User by Id
		User updateUser(User user, long id);
}
