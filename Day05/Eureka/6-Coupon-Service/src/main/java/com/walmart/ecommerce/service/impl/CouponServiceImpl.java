package com.walmart.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.ecommerce.entity.Coupon;
import com.walmart.ecommerce.repository.CouponRepository;
import com.walmart.ecommerce.service.CouponService;

@Service // Used to mark this class as spring bean 
public class CouponServiceImpl implements CouponService {
	
	@Autowired // Used to inject an object of coupon repository
	private CouponRepository repo;
	@Override
	public Coupon registerCoupon(Coupon p) {
		
		// Call appropriate method of repository
		Coupon registeredCoupon=this.repo.save(p);
		return registeredCoupon;
	}
	
	@Override
	public Coupon findCouponByCode(String code) {
		// TODO Auto-generated method stub
		return this.repo.findByCouponCode(code);
	}

}
