package com.walmart.api.notification.service.impl;

import java.io.Serializable;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.walmart.api.order.rest.request.NotificationRequest;

@Service
public class NotificationServiceImpl {
	// We want this method should be automatically executed
	// whenever there is a message in the queue
	// Should accept argument same message type in the queue
	@JmsListener(destination="email_queue")
	public void processNotification(NotificationRequest msg) {
		System.out.println(msg.getId());
		System.out.println(msg.getMessage());
		System.out.println(msg.getTo());
	}
}
