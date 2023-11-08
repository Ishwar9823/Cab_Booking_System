package com.cabbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabbooking.dto.UserDTO;
import com.cabbooking.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

	UserDTO save(UserDTO regiUser);
	User findByUserName(String name);

	
}
