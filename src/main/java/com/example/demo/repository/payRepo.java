package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
 
import com.example.demo.model.Pay;

public interface payRepo extends JpaRepository<Pay,Long> {

}
