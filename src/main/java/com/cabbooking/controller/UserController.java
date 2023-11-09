package com.cabbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabbooking.dto.UserDTO;
import com.cabbooking.entity.User;
import com.cabbooking.serviceimpl.IUserServiceImpl;

@RestController
public class UserController{

	@Autowired
	IUserServiceImpl iUserServiceImpl;
	
	@PostMapping("/userregister")
	public UserDTO registerUser(@RequestBody User user) {
		return iUserServiceImpl.registerUser(user);
	}
	
	@PutMapping("/usersingin/{userName}/{password}")
	public UserDTO signIn(@PathVariable("userName") String userName,@PathVariable("password") String password) {
		return iUserServiceImpl.signIn(userName, password);
	}
	
	@GetMapping("/usersingout/{UserId}")
	public String signOut(@PathVariable("userId") int userId) {
		return iUserServiceImpl.signOut(userId);
	}
}
