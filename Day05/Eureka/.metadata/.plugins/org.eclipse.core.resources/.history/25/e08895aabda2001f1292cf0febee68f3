package com.walmart.ecommerce.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.walmart.ecommerce.entity.Email;
import com.walmart.ecommerce.service.EmailService;

@RestController
public class EmailRestController {
	
	@Autowired
	private EmailService service;
	@PostMapping("/email")
	public boolean sendEmail(@RequestBody Email e) {
		System.out.println("Sending an email to "+e.getTo());
		return service.sendEmail(e);
		
	}
	
}
