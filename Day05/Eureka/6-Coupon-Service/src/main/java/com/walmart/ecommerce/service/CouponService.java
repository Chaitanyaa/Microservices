package com.walmart.ecommerce.service;

import com.walmart.ecommerce.entity.Coupon;

public interface CouponService {
	Coupon registerCoupon(Coupon p);
	Coupon findCouponByCode(String code);
}
