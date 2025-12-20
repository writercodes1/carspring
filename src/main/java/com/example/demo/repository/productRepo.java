package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.products;

 

public interface productRepo extends JpaRepository<products,Long>{

}
