package com.walmart.ecommerce.service.impl;

import org.springframework.stereotype.Service;
import com.walmart.ecommerce.entity.Email;
import com.walmart.ecommerce.service.EmailService;

@Service // Used to mark this class as spring bean 
public class EmailServiceImpl implements EmailService {
	
	@Override
	public boolean sendEmail(Email e) {
		System.out.println("Congratulations, sent "+ e.getTo());
		return true;
	}
	
}
