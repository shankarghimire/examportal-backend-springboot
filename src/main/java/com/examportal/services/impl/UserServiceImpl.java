package com.examportal.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.models.User;
import com.examportal.models.UserRole;
import com.examportal.repositories.RoleRepository;
import com.examportal.repositories.UserRepository;
import com.examportal.services.UserService;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User tempUser = this.userRepository.findByUserName(user.getUserName());
		if(tempUser != null) {
			System.out.println("User already exist!");
			throw new Exception("User already exist!");
		}
		else {
			
			for(var userRole: userRoles) {
				this.roleRepository.save(userRole.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			
			tempUser = this.userRepository.save(user);
			
		}
		return tempUser;
	}

	//Getting user by userName
	@Override
	public User getUserName(String userName) {
		return this.userRepository.findByUserName(userName);
	}

	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
		
	}

	@Override
	public User updateUser(User user, long id) {
		User existingUser;
		Optional<User> optResult = this.userRepository.findById(id);
		if(optResult.isPresent()) {
			existingUser = optResult.get();
			existingUser.setFirstName( user.getFirstName());
			existingUser.setLastName(user.getLastName());
			existingUser.setEmail(user.getEmail());
			existingUser.setPassword(user.getPassword());
			existingUser.setPhone(user.getPhone());
			existingUser.setUserRoles(user.getUserRoles());
			existingUser.setProfile(user.getProfile());
			existingUser.setEnabled(user.isEnabled());
			this.userRepository.save(existingUser);
		}
		else {
			existingUser = null;
		}
		
		return existingUser;
	}

	@Override
	public User getUserById(long id) {
		 Optional<User>	 optResult =  this.userRepository.findById(id);
		 User user;
		if(optResult.isPresent()) {
			
			 user = optResult.get();
		}
		else {
			user= null;
		}
		return user;		
	}

	@Override
	public List<User> findUsers() {
		
		return this.userRepository.findAll();
	}
}
