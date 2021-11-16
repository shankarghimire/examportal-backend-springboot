package com.examportal.controllers;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.models.Role;
import com.examportal.models.User;
import com.examportal.models.UserRole;
import com.examportal.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
		Set<UserRole> roles = new HashSet<>();
		Role role = new Role();
		role.setRoleName("NORMAL");
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);
		roles.add(userRole);
		return this.userService.createUser(user, roles);
	}
	
	@GetMapping("/")
	public List<User> getUsers() {
		return this.userService.findUsers();
	}
	
//	@GetMapping("/{userName}")
//	public User getUserName(@PathVariable("userName") String userName) {
//		return this.userService.getUserName(userName);
//	}
	@GetMapping("/{userId}")
	public User getUserById(@PathVariable("userId") long userId) {
		return this.userService.getUserById(userId);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") Long userId) {
		this.userService.deleteUser(userId);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("userId") long id) {
		
		return new ResponseEntity<User>(this.userService.updateUser(user, id),HttpStatus.OK);
	}
	
}
