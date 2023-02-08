package com.yash.wh.Controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.yash.wh.model.*;
import com.yash.wh.service.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class partscontroller 
{
	@Autowired
	partservice service;

	@PostMapping("/part")
	public parts save(@RequestBody parts p)			
	{
		 return this.service.saveparts(p);
	}
	
	@GetMapping("/part/{id}")
	public Optional<parts> show(@PathVariable(name = "id") int i)
	{
		return this.service.partesgreater(i);
	}
	
	@GetMapping(path = "/part")
	public List<parts> parts()
	{
		return this.service.servicefindall();
	}
	
	@PutMapping("/part")
	public parts partupdate(@RequestBody parts p)
	{
		return this.service.serviceupdate(p);
		
	}
	
	@DeleteMapping("/part/{number}")
	public boolean deletemethod( @PathVariable("number") int n )
	{
		return this.service.deletepartmethod(n);
	}
	
}
