package com.walmart.ecommerce.entity;


public class Email {
//	@Id //Used to mark this field as primary key in the database
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String to="abc@email.com";
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	private String from="xyz@email.com";
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	private String subject;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
