package com.jacky.autowire.byName.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Autowire_byName_Beans.xml");
		
		TextEditor textEditor = (TextEditor)context.getBean("textEditor");
		
		textEditor.spellCheck();

	}

}
