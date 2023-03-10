package com.yash.wh.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.wh.model.login;

public interface loginrepo extends JpaRepository<login, Integer> 
{
	public login findByUsername(String username);
	public login findByUsernameAndPassword(String username,String password);
}
