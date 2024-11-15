package com.walmart.ecommerce.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.walmart.ecommerce.entity.Coupon;
import com.walmart.ecommerce.service.CouponService;

@RestController
public class CouponRestController {
	
	@Autowired
	private CouponService service;
	@PostMapping("/coupon")
	public Coupon insertProduct(@RequestBody Coupon p) {
		Coupon registerCoupon = service.registerCoupon(p);
		return registerCoupon;
		
	}
	@GetMapping("/coupon/{code}")// {id} is a variable portion in the URI
	// This variable is read by spring because of path variable annotation
	public Coupon searchCoupon(@PathVariable String code) {
		return this.service.findCouponByCode(code);
		
	}

}
