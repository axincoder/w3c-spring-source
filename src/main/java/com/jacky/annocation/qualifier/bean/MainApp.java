package com.jacky.annocation.qualifier.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Annocation_qualifier_Beans.xml");
		
		Profile profile = (Profile)context.getBean("profile");
		
		profile.printAge();
		profile.printName();

	}

}
