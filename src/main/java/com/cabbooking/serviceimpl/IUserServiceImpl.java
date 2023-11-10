package com.cabbooking.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabbooking.dto.UserDTO;
import com.cabbooking.entity.User;
import com.cabbooking.exception.UserBookingException;
import com.cabbooking.repository.UserRepo;
import com.cabbooking.service.IUserService;

@Service
public class IUserServiceImpl implements IUserService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDTO registerUser(User user){
		 userRepo.save(user);
		 return toUserDTO(user);
	}

	@Override
	public UserDTO signIn(String userName, String password) throws UserBookingException{
		User user = userRepo.findByUserName(userName);
		if(user.getPassword().equals(password)) {
			userRepo.save(user);
			return toUserDTO(user);
		}
		else {
			throw new UserBookingException("User not found");
		}
		
	}

	@Override
	public String signOut(int userId) throws UserBookingException{
		Optional<User> user = userRepo.findById(userId);
		if(user.isPresent()) {
			return "User Logged Out Successfully";
		}
		else {
			throw new UserBookingException("Invalid UserId");
		}
		
	}
	
	private UserDTO toUserDTO(User user) {
UserDTO regiUser = new UserDTO();
		
		regiUser.setUserId(user.getUserId());
		regiUser.setRoles(user.getRoles());
		regiUser.setAddress(user.getAddress());
		regiUser.setEmail(user.getEmail());
		regiUser.setUserName(user.getUserName());
		
		return regiUser;
	}

}
