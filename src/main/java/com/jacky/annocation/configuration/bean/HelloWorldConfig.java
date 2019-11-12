package com.jacky.annocation.configuration.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {

	/*
	 * 这里的配置相当于XML中配置如下：
	 * 
	 * <beans> 
	 * 		<bean id="helloWorld" class="com.tutorialspoint.HelloWorld" />
	 * </beans>
	 * 
	 * 方法名称helloWorld()相当于id="helloWorld",即为Bean ID
	 */

	@Bean
	public HelloWorld helloWorld() {
		return new HelloWorld();
	}
}
