package com.codejava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.codejava.model.UserDtls;
import com.codejava.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	
	@Override
	public UserDtls creteUser(UserDtls user) {
		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		
		return userRepo.save(user);
	}
	@Override
	public boolean checkEmail(String email) {

		return userRepo.existsByEmail(email);
	}

	
//	@Override
//	public UserDtls updateUser(UserDtls user) {
//		return userRepo.existByEmail(email);
//	}
//	@Override
//	public UserDtls deleteUser(UserDtls user) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
