package com.walmart.ecommerce.service;

import com.walmart.ecommerce.entity.Email;

public interface EmailService {
	boolean sendEmail(Email e);
}
