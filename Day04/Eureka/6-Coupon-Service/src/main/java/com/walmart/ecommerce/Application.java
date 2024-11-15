package com.walmart.ecommerce;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import com.walmart.ecommerce.service.impl.CouponServiceImpl;

@SpringBootApplication
@EnableDiscoveryClient // Denotes that this microservice is a client to eureka.
// It is an optional annotation, not mandatory and is why we were ignoring
// In old version of Springboot, there was another annotation that was
// EnableEurekaClient
// This annotation is no longer supported in newer versions
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);	
		
	}

}
