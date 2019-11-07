package com.jacky.beanFactory.bean;

public class HelloWorld {
	private String message;

	public void getMessage() {
		System.out.println("Your Message : " + this.message);
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
