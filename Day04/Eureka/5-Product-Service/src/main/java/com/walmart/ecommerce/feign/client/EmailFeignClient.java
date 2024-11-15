package com.walmart.ecommerce.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.walmart.ecommerce.rest.request.EmailRequest;
import com.walmart.ecommerce.rest.response.EmailResponse;

// Hard coding of url with ip and port is a bad choice
// as it does not allow to do load balancing

//@FeignClient(url="http://localhost:8081",name="cs")
//@FeignClient(name="cs")// cs is logical name of coupon service. Registered with eureka.
@FeignClient(name="gateway")
public interface EmailFeignClient {
	@PostMapping("/es/email")// {id} is a variable portion in the URI
	// This variable is read by spring because of path variable annotation
	public EmailResponse sendEmail(@RequestBody EmailRequest email);
}
