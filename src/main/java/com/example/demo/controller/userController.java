package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
 
import com.example.demo.repository.userRepo;

@RestController
 
@CrossOrigin(origins = "http://localhost:4200/")
public class userController {

	
	@Autowired
	userRepo userrepo;
	
	@PostMapping("/addUser")	
	public  Users  AddUser(@RequestBody  Users  user) {
		Users getpro = userrepo.save(user);	 
		return getpro;
	}
	
	@PostMapping("/userLogin")	
	public  ResponseEntity<?>  userLogin(@RequestBody  Users  userdata) {
		Users user =  userrepo.findByEmail(userdata.getEmail());	
		if(user.getPassword().equals(userdata.getPassword()))
		return  ResponseEntity.ok(user);
		
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}
	
	 
}
