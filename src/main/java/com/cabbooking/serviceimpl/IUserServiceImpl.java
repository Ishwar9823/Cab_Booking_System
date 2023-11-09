package com.cabbooking.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabbooking.dto.UserDTO;
import com.cabbooking.entity.User;
import com.cabbooking.repository.UserRepo;
import com.cabbooking.service.IUserService;

@Service
public class IUserServiceImpl implements IUserService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDTO registerUser(User user) {
		UserDTO regiUser = new UserDTO();
		
		regiUser.setUserId(user.getUserId());
		regiUser.setRoles(user.getRoles());
		regiUser.setAddress(user.getAddress());
		regiUser.setEmail(user.getEmail());
		regiUser.setUserName(user.getUserName());
		
		 userRepo.save(user);
		 return regiUser;
	}

	@Override
	public UserDTO signIn(String userName, String password) {
		User user = userRepo.findByUserName(userName);
		if(user.getPassword().equals(password)) {
			UserDTO regiUser = new UserDTO();
			
			regiUser.setUserId(user.getUserId());
			regiUser.setRoles(user.getRoles());
			regiUser.setAddress(user.getAddress());
			regiUser.setEmail(user.getEmail());
			regiUser.setUserName(user.getUserName());
			
			userRepo.save(user);
			
			return regiUser;
		}
		else {
			return null;
		}
		
	}

	@Override
	public String signOut(int userId) {
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent()) {
//			User userSingOut = user.get();
//			userRepo.delete(userSingOut);
			return "User Logged Out Successfully";
		}
		else {
			return null;
		}
		
	}

}
