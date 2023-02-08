package com.codejava.service;

import com.codejava.model.UserDtls;

public interface UserService {

	public UserDtls creteUser(UserDtls user);
	
	public boolean checkEmail(String email);
	
	//public UserDtls updateUser(UserDtls user);
	
	//public UserDtls deleteUser(UserDtls user);
}
