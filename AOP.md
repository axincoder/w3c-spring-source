### Spring AOP的学习
#### 一、Spring AOP的理解

##### 1、概念的理解
1) Advice(通知)  
2) JoinPoint(连接点)  
3) PointCut(切入点)  
4) Aspect(切面)
5) Intruduction(引入)  
6) Target(目标） 
7) Weaving(织入)
8) Proxy(代理)

#### 二、基于AOP的XML架构  
1) 基于Maven的项目，导入AOP依赖包 
 
```
         <dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-aop</artifactId>
			<version>5.1.9.RELEASE</version>
		</dependency>

		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjrt</artifactId>
			<version>1.9.4</version>
		</dependency>

		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjweaver</artifactId>
			<version>1.9.4</version>
		</dependency>
```

2) XML配置文件中，引入AOP名字空间

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:aop="http://www.springframework.org/schema/aop"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd 
    http://www.springframework.org/schema/aop 
    http://www.springframework.org/schema/aop/spring-aop-3.0.xsd ">

</beans>
```

3) 编写Advice（其实也就是Java类）

```
package com.jacky.aop.xml.bean;

public class Logging {
	
	/*
	 * 在业务逻辑方法前执行
	 */
	public void beforeAdvice() {
		System.out.println("Going to setup student profile.");
	}
	
	/*
	 * 在业务逻辑方法后执行
	 */
	public void afterAdvice() {
		System.out.println("Student profile has been setup.");
	}
	
	/*
	 * 在业务逻辑方法Return返回时执行
	 */
	public void afterReturningAdvice(Object retVal) {
		System.out.println("Returning : " + retVal.toString());
	}
	
	/*
	 * 再业务逻辑方法抛出异常时执行
	 */
	public void afterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("There has been an exception : " + ex.toString());
	}

}
```

4) 编写业务逻辑类

```
package com.jacky.aop.xml.bean;

public class Student {
	private Integer age;
	private String name;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void printThrowException() {
		System.out.println("Exception raised.");
		throw new IllegalArgumentException();
	}

}
```


5) 基于XML，配置AOP功能

```
	<aop:config>
		<aop:aspect id="log" ref="logging">
			<aop:pointcut
				expression="execution(* com.jacky.aop.xml.bean.*.*(..))"
				id="selectAll" />
			<aop:before pointcut-ref="selectAll" method="beforeAdvice" />
			<aop:after pointcut-ref="selectAll" method="afterAdvice" />
			<aop:after-returning pointcut-ref="selectAll"
				method="afterReturningAdvice" returning="retVal" />
			<aop:after-throwing pointcut-ref="selectAll"
				method="afterThrowingAdvice" throwing="ex" />
		</aop:aspect>
	</aop:config>

	<bean id="student" class="com.jacky.aop.xml.bean.Student">
		<property name="name" value="Zara"></property>
		<property name="age" value="11"></property>
	</bean>

	<bean id="logging" class="com.jacky.aop.xml.bean.Logging"></bean>
```


5) 测试

```
package com.jacky.aop.xml.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Aop_xml.xml");
		
		Student student = (Student)context.getBean("student");
		
		student.getName();
		student.getAge();
		student.printThrowException();
	}

}
```




#### 三、基于AOP的@AspectJ
