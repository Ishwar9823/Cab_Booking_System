package com.cabbooking.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString


public class UserDTO {
	
	private Integer userId;
	private String userName;
//	private String password;
	private String address;
//	private String mobileNumber;
	private String email;
	//Admin, Customer, Driver
	private String roles;
	
	public UserDTO() {
		
	}

	public UserDTO(Integer userId, String userName, String address,String email,
			String roles) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.email = email;
		this.roles = roles;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", address="
				+ address +  ", email=" + email + ", roles=" + roles + "]";
	}
	
}
