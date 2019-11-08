package com.jacky.lifeCycle.bean;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		/*
		 * 为了能够演示销毁Bean，这里使用了抽象方法：AbstractApplicationContext
		 * 说明：输出日志中，你会发现，初始化方法和销毁方法分别运行了2次，因为定义了一个全局的初始化，销毁方法
		 */
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		HelloWorld obj1 = (HelloWorld)context.getBean("helloWorld5");
		obj1.getMessage();
		context.registerShutdownHook();
		
		
	}

}
