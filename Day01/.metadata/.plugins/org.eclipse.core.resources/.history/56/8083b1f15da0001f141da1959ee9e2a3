package com.walmart.ecommerce.service.impl;

import com.walmart.ecommerce.entity.Product;
import com.walmart.ecommerce.repository.ProductRepository;
import com.walmart.ecommerce.service.ProductService;

public class ProductServiceImpl implements ProductService {

	private ProductRepository repo;
	@Override
	public Product registerProduct(Product p) {
		
		// Call appropriate method of repository
		Product registeredProduct=this.repo.save(p);
		return registeredProduct;
	}

}
