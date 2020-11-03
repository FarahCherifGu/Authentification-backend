package com.app.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.registration.model.User;
import com.app.registration.service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService service ;
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins = "http://localhost:4401")
	public User registerUser(@RequestBody User user) throws Exception {
	String tempEmailId=user.getEmailId();
	if (tempEmailId !=null && !"".equals(tempEmailId))
	{
		User userobj= service.fetchUserbyEmailId(tempEmailId);
		if (userobj !=null ) {
			
			 throw new Exception("user with this id"+tempEmailId+"is already exist");
		}
		}
	User userobj=null;
	userobj=service.saveUser(user);
	return userobj;
	}
	
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4401")
	public User loginUser(@RequestBody User user) throws Exception{
		String tempEmailId=user.getEmailId();
		String temppassword=user.getPassword();
		User userobj=null;
		if(tempEmailId!= null && temppassword!= null) {
			userobj=service.fetchUserbyEmailIDAndPassword(tempEmailId, temppassword);			
		}
		if (userobj == null) 
		{
			throw new Exception("Bad credentials");
		}
		return userobj;
	}
	

}
