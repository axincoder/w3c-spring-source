package com.jacky.annocation.autowired.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	/*
	 * 1、Autowire模式就是在spring的声明文件里用作进行对象间的关联关系自动绑定的，就是在spring
	 * beanfactory内的一个bean对其bean的引用可以自动进行，而不一定用ref=的方式显式声明。
	 * 
	 * 2、Autowire不可以直接对Integer，String等基本数据类型进行关联
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Annocation_autowired_Beans.xml");

		/*
		 * 构造函数中使用@Autowired
		 */
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		textEditor.spellCheck();

	}

}
