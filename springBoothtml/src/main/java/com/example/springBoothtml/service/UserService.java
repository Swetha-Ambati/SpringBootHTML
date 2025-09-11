package com.example.springBoothtml.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springBoothtml.Model.User;
import com.example.springBoothtml.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public String save(User user) {
		User savedUser = userRepo.save(user);
		return "saved";
		
	}
	

}
