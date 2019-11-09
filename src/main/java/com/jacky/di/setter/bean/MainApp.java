package com.jacky.di.setter.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context =  new ClassPathXmlApplicationContext("DI_Setter_Beans.xml");
		
		TextEditor textEditor = (TextEditor)context.getBean("textEditor");
		textEditor.spellCheck();
		
		Person person = (Person)context.getBean("john-classic");
		System.out.println(person.getSpouse());

	}

}
