package com.yash.wh.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.yash.wh.model.*;


import com.yash.wh.repository.partsrepo;

@Component
public class partservice 
{
	@Autowired
	private partsrepo whr;
	

	
	public parts saveparts(parts p)
	{
		return this.whr.save(p);
	}
	
	public Optional<parts> partesgreater(int i)
	{
		return this.whr.findById(i);
	}
	
	public List<parts> servicefindall()
	{
		return this.whr.findAll();
	}
	
	public boolean servicedelete(int i)
	{
		if(whr.existsById(i))
		{
			whr.deleteById(i);
			return true;
		}
		return false;
	}
	
	public parts serviceupdate(parts p)
	{
		return this.whr.saveAndFlush(p);
	}

	public boolean deletepartmethod(int n)
	{
		this.whr.deleteById(n);
		return true;
	}
	
}
