package com.app.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.registration.model.User;
import com.app.registration.repository.ResgistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private ResgistrationRepository repo;
	
	public User  saveUser(User user) {
		 return repo.save(user)	;
	}
	 
	public User fetchUserbyEmailId(String email)
	{
		 return repo.findByEmailId(email);
		
	}
	public User fetchUserbyEmailIDAndPassword(String email, String password)
	{
		 return repo.findByEmailIdAndPassword(email, password);
		
	}
}
