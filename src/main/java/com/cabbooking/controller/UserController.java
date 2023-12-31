package com.cabbooking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabbooking.dto.UserDTO;
import com.cabbooking.entity.User;
import com.cabbooking.exception.UserBookingException;
import com.cabbooking.serviceimpl.IUserServiceImpl;

@RestController
@RequestMapping("user")
public class UserController{

	@Autowired
	IUserServiceImpl iUserServiceImpl;
	
	@PostMapping("/register")
	public UserDTO registerUser(@Valid @RequestBody User user){
		return iUserServiceImpl.registerUser(user);
	}
	
	@PutMapping("/usersingin/{userName}/{password}")
	public UserDTO signIn(@PathVariable("userName") String userName,@PathVariable("password") String password) throws UserBookingException{
		return iUserServiceImpl.signIn(userName, password);
	}
	
	@GetMapping("/usersingout/{userId}")
	public String signOut(@PathVariable("userId") int userId) throws UserBookingException{
		return iUserServiceImpl.signOut(userId);
	}
}
