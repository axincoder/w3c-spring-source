package com.jacky.applicationContext.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld2");
		obj.getMessage();

	}

}
