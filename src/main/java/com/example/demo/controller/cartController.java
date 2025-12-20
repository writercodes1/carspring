package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
 
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Carts;
 
import com.example.demo.repository.cartRepo;

@RestController
 
@CrossOrigin(origins = "http://localhost:4200/")
public class cartController {
	@Autowired
cartRepo carrepo;
	
	@GetMapping("/carts")
	public List<Carts> carts() {
		 
		return carrepo.findAll();
	}
	 

	@GetMapping("/deletecarts/{id}")
	public  String deletecarts(@PathVariable Long id){
	Carts getpro = carrepo.getById(id);
	 carrepo.delete(getpro);
		return "deleted";
	}
}
