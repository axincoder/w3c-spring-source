### Spring AOP的学习
#### 一、Spring AOP的理解

##### 1、AOP的功能（个人理解）

假定，一个应用软件系统是由N个功能函数组成的，因为软件需求的规定，这N个功能函数中都要有一个相同的功能，即被调用时要记录用户信息（如用户名，时间，Ip等），为了实现该需求，可以选择的方式有：  

方案1). 将N个功能函数中都增加“记录用户信息”的代码；  
方案2). 将“记录用户信息”封装为函数saveUserInfo，写入N个功能函数中；  

方案比较：  
1). 方案1中，将”记录用户信息“代码写入N个功能函数中，代码冗余显而易见，后面如果需要修改，则必须同时修改N个地方，失败，不可选;
2). 方案2中，将“记录用户信息”封装为saveUserInfo，写入N个功能中，因此该方案中“记录用户信息”的代码就一份，修改起来比较简单。saveUserInfo函用会被写入N个功能函数中，如果N＝100，就要修改100处逻辑代码，感觉还是不太好。

有没有更好的方案呢？要同时满足：  
1). "记录用户信息“业务逻辑代码就写一份，封装为函数saveUserInfo；  
2). 不直接修改N个业务逻辑代码；

很幸运的告诉你，AOP可以解决这个问题的。AOP适用于抽取业务逻辑中公共部分功能，通过配置的方式，动态将其注入到你指定的位置。

##### 2、概念的理解
1) Advice(通知)：就是一个“函数”。是一个从业务逻辑中剥离出来的公共功能的函数（如saveUerInfo）。
2) JoinPoint(连接点)：就是一个“位置”。这个位置表示Advice要注入的地方。   
3) PointCut(切入点)：就是“位置的集合”。因为有很多个需要注入Advice的地方，为了给“很多个位置”起一个名字，就出来这么个PointCut。
4) Aspect(切面)：“函数”和“位置的集合”打包在一起的总称，也就是Advice和PointCut打包在一起，就出现了这么个Aspect。  
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

	测试代码：com.jacky.aop.xml.bean包下


#### 三、基于AOP的@AspectJ

基于AspectJ实现AOP功能。后续将专题说明

	测试代码：com.jacky.aop.aspect.ben包下
