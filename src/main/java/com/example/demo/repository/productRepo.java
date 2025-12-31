package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.products;

 

public interface productRepo extends JpaRepository<products,Long>{
	 @Query("SELECT p FROM products p WHERE p.product_name LIKE %:keyword%")
	    List<products> searchProducts(@Param("keyword") String keyword);
}
