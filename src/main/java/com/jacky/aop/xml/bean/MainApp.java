package com.jacky.aop.xml.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Aop_xml.xml");
		
		Student student = (Student)context.getBean("student");
		
		student.getName();
		student.getAge();
		student.printThrowException();
	}

}
