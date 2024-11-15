package com.walmart.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.walmart.ecommerce.entity.Coupon;

// Responsible for interacting with the database for product entity
public interface CouponRepository extends JpaRepository<Coupon, Integer>{
	Coupon findByCouponCode(String code);
}
