package com.jacky.annocation.configuration.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		/*
		 * 第一种加载容器的方法
		 */
		@SuppressWarnings("resource")
		ApplicationContext cfg = new AnnotationConfigApplicationContext(HelloWorld.class);

		HelloWorld helloWorld = (HelloWorld)cfg.getBean(HelloWorld.class);
		helloWorld.setMessage("Hello World1");
		helloWorld.getMessage();
		
		
		/*
		 * 第二种加载容器的方法
		 */
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext cfx = new AnnotationConfigApplicationContext();
		cfx.register(HelloWorldConfig.class);
		cfx.register(TextEditorConfig.class);
		
		cfx.refresh();
		
		//简单的基于Java的配置
		HelloWorld hWorld = cfx.getBean(HelloWorld.class);
		hWorld.setMessage("Hello World2");
		hWorld.getMessage();

		//对象依赖关系的Java配置
		TextEditor textEditor = (TextEditor)cfx.getBean(TextEditor.class);
		textEditor.spellCheck();
	}

}
