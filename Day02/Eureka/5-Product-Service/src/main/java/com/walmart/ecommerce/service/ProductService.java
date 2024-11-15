package com.walmart.ecommerce.service;

import com.walmart.ecommerce.entity.Product;

public interface ProductService {
	Product registerProduct(Product p);
	Product findProductById(int id);
}
