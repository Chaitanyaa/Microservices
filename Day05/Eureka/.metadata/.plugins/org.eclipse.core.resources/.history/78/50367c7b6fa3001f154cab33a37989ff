package com.walmart.api.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import com.walmart.api.order.rest.request.NotificationRequest;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		JmsTemplate template = applicationContext.getBean(JmsTemplate.class);
		//Sending the message to message broker
//		template.convertAndSend("email_queue","Send an email to Chaitanya");
		NotificationRequest request = new NotificationRequest();
		request.setId(1);
		request.setMessage("Order placed and will be delivered in 24 hrs");
		request.setTo("Chaitanya");
		template.convertAndSend("email_queue",request);
	}

}
