package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;
 
import com.example.demo.repository.adminRepo;
@RestController

@CrossOrigin(origins = "http://localhost:4200/")
public class adminController {
	
	@Autowired
	adminRepo adminrepo;
	
	@PostMapping("/admin")	
	public  ResponseEntity<?>  adminLogin(@RequestBody  Admin  admin) {
        Admin user =  adminrepo.findByEmail(admin.getEmail());	
		if(user.getPassword().equals(admin.getPassword()))
		return  ResponseEntity.ok(user);
		
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}
}
