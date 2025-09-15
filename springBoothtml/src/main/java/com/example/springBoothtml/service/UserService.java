package com.example.springBoothtml.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springBoothtml.Model.User;
import com.example.springBoothtml.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public String save(User user) {
		 userRepo.save(user);
		return "saved";
		
	}

	public boolean getUserDetails(String username) {
		// TODO Auto-generated method stub
		System.out.println("in getUserDetails");
		Optional<User> user = userRepo.findByusername(username);
		return user.isPresent();
		
	}
	

}
