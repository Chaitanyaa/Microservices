package com.walmart.ecommerce.repository;

import com.walmart.ecommerce.entity.Product;

// Responsible for interacting with the database for product entity
public interface ProductRepository {

	Product save(Product p);
	
}
