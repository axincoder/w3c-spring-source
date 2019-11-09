package com.jacky.inheritance.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		
		HelloWorld objA = (HelloWorld)context.getBean("helloWorld7");
		objA.getMessage1();
		objA.getMessage2();
		
		HelloIndia objB = (HelloIndia)context.getBean("helloWorld8");
		objB.getMessage1();
		objB.getMessage2();
		objB.getMessage3();

	}

}
