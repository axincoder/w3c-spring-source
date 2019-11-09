package com.jacky.post.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitHelloWorld implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("helloWorld6") && (0==1))
			System.out.println("BeforeInitialization : " + beanName);
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (beanName.equals("helloWorld6") && (0==1))
			System.out.println("AfterInitialization : " + beanName);
		return bean;
	}

}
