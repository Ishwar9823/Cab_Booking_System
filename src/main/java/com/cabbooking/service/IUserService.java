package com.cabbooking.service;

import com.cabbooking.dto.UserDTO;
import com.cabbooking.entity.User;

public interface IUserService {

	UserDTO registerUser(User user);

	UserDTO signIn(String userName, String password);

	// use session management accordingly
	public String signOut(int userId);
}
