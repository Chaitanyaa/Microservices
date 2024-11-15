package com.walmart.ecommerce.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloRestController {
	
	@Value("${Company}")
	private String organization;
	@Value("${coupon_type}")
	private String coupon_type;
	@Autowired
	private Environment env;
	@GetMapping("/hello/")
	String sayHello() {
		return "HelloWorld "+env.getProperty("local.server.port") + " Company is "+organization+" and coupon is "+coupon_type;
	}
	
}
