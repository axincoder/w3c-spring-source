package com.jacky.scope.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		/*
		 * 作用域：singleton (单例模式)
		 * 说明：Spring IoC容器中只会存在一个共享的bean实例
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld3");
		obj.setMessage("I'm Ojbect A");
		obj.getMessage();
		
		HelloWorld obj2 = (HelloWorld)context.getBean("helloWorld3");
		obj2.getMessage();
		
		/*
		 * 作用域：prototype (原型模式)
		 * 说明：每次从容器中调用Bean时，都返回一个新的实例，即每次调用getBean()时，相当于执行newXxxBean()
		 */
		HelloWorld obj3 = (HelloWorld) context.getBean("helloWorld4");
		obj3.setMessage("I'm Object B");
		obj3.getMessage();
		HelloWorld obj4 = (HelloWorld) context.getBean("helloWorld4");
		obj4.getMessage();
		
		/*
		 * 作用域：request   session   global-session
		 * 说明：这个需要再web模式运行，此处无法编写测试代码
		 * 
		 */
		

	}

}
