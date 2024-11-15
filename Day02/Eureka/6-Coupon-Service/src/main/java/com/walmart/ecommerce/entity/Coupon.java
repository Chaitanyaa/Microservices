package com.walmart.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity // It is used to mark a class as JPA Entity
// This class is mapped to a table in the database by JPA
public class Coupon {
	@Id //Used to mark this field as primary key in the database
	private int id;
	@Column(unique=true)
	private String couponCode;
	private int discount;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getcouponCode() {
		return couponCode;
	}
	public void setcouponCode(String code) {
		this.couponCode = code;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
}
