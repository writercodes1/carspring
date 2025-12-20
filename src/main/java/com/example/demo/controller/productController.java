package com.example.demo.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Carts;
import com.example.demo.model.Pay;
import com.example.demo.model.products;
import com.example.demo.repository.cartRepo;
import com.example.demo.repository.payRepo;
import com.example.demo.repository.productRepo;
 

@RestController
// @RequestMapping("/api/vl")
@CrossOrigin(origins = "http://localhost:4200/")
public class productController {

	@Autowired
	productRepo prorepo;

	@Autowired
	cartRepo cartrepo;
	
	@Autowired
	payRepo payrepo;
	
	@GetMapping("/msg")
	public  String Produc() {
		 
		return " hello m";
	}

	@GetMapping("/products")
	public List<products> Product() {
		 
		return prorepo.findAll();
	}
	
	@PostMapping("addproduct")	
	public products postproAdd(@RequestBody products pro) {
		products getpro = prorepo.save(pro);	 
		return getpro;
	}
	 

	@GetMapping("/product/{id}")
	public  String deleteProduct(@PathVariable Long id){
	products getpro =prorepo.getById(id);
	prorepo.delete(getpro);
		return "deleted";
	}
	@GetMapping("/products/{id}")
	public ResponseEntity<products> getProductById(@PathVariable Long id){
		products getpro =prorepo.getById(id);
		return ResponseEntity.ok().body(getpro);
	}
	@PutMapping("/upproducts/{id}")
	public ResponseEntity<products> upProductById(@PathVariable Long id,@RequestBody products pro){
		  
		products getpro =prorepo.getById(id);
		getpro.setProduct_name(pro.getImageName());
		getpro.setImageName(pro.getImageName());
		getpro.setDescription(pro.getDescription( ));
		getpro.setPrice(pro.getPrice());
		 prorepo.save(getpro);
		
		
		return ResponseEntity.ok().body(pro);
	}
	
 

	@GetMapping("/addtocart/{id}")
	public  Carts  addtocart(@PathVariable Long id){
	products getpro =prorepo.getById(id);
	Carts cart = new Carts();
	cart.setCart_id(getpro.getProduct_id());
	cart.setCart_name(getpro.getProduct_name());
	cart.setImageName(getpro.getImageName());
	cart.setPrice(getpro.getPrice());
	cartrepo.save(cart);
		return cart;
	}
	@GetMapping("/addtopay/{id}")
	public  Pay  addtopay(@PathVariable Long id){
	products getpro =prorepo.getById(id);
	Pay cart = new Pay();
	cart.setproduct_id(getpro.getProduct_id());
	 cart.setproduct_name(getpro.getProduct_name()); 
	cart.setPrice(getpro.getPrice());
	payrepo.save(cart);
		return cart;
	}
	
}
