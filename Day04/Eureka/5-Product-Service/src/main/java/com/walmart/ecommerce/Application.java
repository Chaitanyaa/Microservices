package com.walmart.ecommerce;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

import com.walmart.ecommerce.entity.Product;
import com.walmart.ecommerce.service.ProductService;
import com.walmart.ecommerce.service.impl.ProductServiceImpl;

@SpringBootApplication
@EnableFeignClients
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		ProductService service = context.getBean(ProductService.class);
		Product p = new Product();
		p.setId(1);
		p.setName("Laptop");
		p.setPrice(100);
		service.registerProduct(p);		
		
	}

}
