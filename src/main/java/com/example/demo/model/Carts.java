package com.example.demo.model;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "carts")
public class Carts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cart_id;
	 
	 
	@Override
	public String toString() {
		return "Carts [cart_id=" + cart_id + ", cart_name=" + cart_name + ", imageName=" + imageName + ", price="
				+ price + "]";
	}
	public Long getCart_id() {
		return cart_id;
	}
	public void setCart_id(Long cart_id) {
		this.cart_id = cart_id;
	}
	public String getCart_name() {
		return cart_name;
	}
	public void setCart_name(String cart_name) {
		this.cart_name = cart_name;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@NotBlank
	private String cart_name;
 
	private String imageName;
	@NotBlank
	private double price;

}
