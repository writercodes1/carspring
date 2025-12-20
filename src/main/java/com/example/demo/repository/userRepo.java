package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.model.Users;

 

public interface userRepo extends JpaRepository<Users,String>{

 
 	Users findByEmail(String email);

	  

}

