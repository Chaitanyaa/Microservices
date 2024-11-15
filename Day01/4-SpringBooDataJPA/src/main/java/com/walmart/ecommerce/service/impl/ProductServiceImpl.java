package com.walmart.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walmart.ecommerce.entity.Product;
import com.walmart.ecommerce.repository.ProductRepository;
import com.walmart.ecommerce.service.ProductService;

@Service // Used to mark this class as spring bean 
public class ProductServiceImpl implements ProductService {
	
	@Autowired // Used to inject an object of product repository
	private ProductRepository repo;
	@Override
	public Product registerProduct(Product p) {
		
		// Call appropriate method of repository
		Product registeredProduct=this.repo.save(p);
		return registeredProduct;
	}

}
