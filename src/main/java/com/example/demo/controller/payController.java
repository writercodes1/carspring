package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

 
import com.example.demo.model.Pay;
import com.example.demo.repository.payRepo;

@RestController

@CrossOrigin(origins = "http://localhost:4200/")
public class payController {

	
	@Autowired
	payRepo payrepo;
	@GetMapping("/pay")
	public List<Pay> carts() {
		 
		return payrepo.findAll();
	}
	 

	@GetMapping("/deletepay/{id}")
	public  String deletecarts(@PathVariable Long id){
	Pay getpro = payrepo.getById(id);
	payrepo.delete(getpro);
		return "deleted";
	}
}
