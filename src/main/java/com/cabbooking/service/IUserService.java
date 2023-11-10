package com.cabbooking.service;

import com.cabbooking.dto.UserDTO;
import com.cabbooking.entity.User;
import com.cabbooking.exception.UserBookingException;

public interface IUserService {

	UserDTO registerUser(User user);

	UserDTO signIn(String userName, String password) throws UserBookingException;

	// use session management accordingly
	String signOut(int userId) throws UserBookingException;
}
