package com.walmart.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // It is used to mark a class as JPA Entity
// This class is mapped to a table in the database by JPA
public class Product {
	@Id //Used to mark this field as primary key in the database
	private int id;
	private String name;
	private float price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
