package com.walmart.ecommerce.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.ecommerce.entity.Product;
import com.walmart.ecommerce.feign.client.CouponFeignClient;
import com.walmart.ecommerce.rest.response.CouponResponse;
import com.walmart.ecommerce.service.ProductService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class ProductRestController {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private CouponFeignClient feignClient;
	@CircuitBreaker(name="ccb",fallbackMethod = "insertProductFallback")
	@PostMapping("/product")
	public Product insertProduct(@RequestBody Product p, @RequestParam(defaultValue = "c1") String code) {
		
		//Before registering product, Accept valid coupon code from user.
		//based on the code, fetch associated discount
		// Make REST call to coupon service to fetch discount.
		System.out.println("Making REST Call");
		CouponResponse response = this.feignClient.searchCoupon(code);
		//apply the discount to product price then save to db
		p.setPrice(p.getPrice()-response.getDiscount());
		// Save the product by applying discount
		System.out.println("Saving the product with discount");
		Product registerProduct = service.registerProduct(p);
		return registerProduct;
		
	}
	
	public Product insertProductFallback(@RequestBody Product p, @RequestParam(defaultValue = "c1") String code,Throwable t) {
	
		System.out.println("Saving the product without discount in fallback");
		Product registerProduct = service.registerProduct(p);
		return registerProduct;
	
	}
	
	@GetMapping("/product/{id}")// {id} is a variable portion in the URI
	// This variable is read by spring because of path variable annotation
	public Product searchProduct(@PathVariable int id) {
		return this.service.findProductById(id);
		
	}

}
