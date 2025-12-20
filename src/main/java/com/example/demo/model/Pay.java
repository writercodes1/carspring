package com.example.demo.model;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "pay")
public class Pay {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long product_id;
	@Override
	public String toString() {
		return "Pay [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price + "]";
	}


	public Long getproduct_id() {
		return product_id;
	}


	public void setproduct_id(Long product_id) {
		this.product_id = product_id;
	}


	public String product_name() {
		return product_name;
	}


	public void setproduct_name(String product_name) {
		this.product_name = product_name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@NotBlank
	private String product_name;
 
	 
	@NotBlank
	private double price;
}
