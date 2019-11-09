package com.jacky.di.constructor.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("DI_Constructor_Beans.xml");
		
		/*
		 * 基于构造器的依赖注入
		 */
		TextEditor textEditor = (TextEditor)context.getBean("textEditor");
		textEditor.spellCheck();

	}

}
