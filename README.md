一、项目说明
============

1、W3C网站，spring教程中示例代码的学习  
--------------------------------------
2、教程地址：https://www.w3cschool.cn/wkspring/  
------------------------------------------------

二、项目代码
==========
## 1、Spring IOC容器  
1). IOC容器模型图
	
![https://atts.w3cschool.cn/attachments/image/wk/wkspring/ioc1.jpg]

2). Spring BeanFactory容器  

	测试代码: com.jacky.beanFactory.bean包下面  

3). Spring ApplicationContext容器
	
* ApplicationContext是BeanFactory的子接口，包含了所有的BeanFactory功能
* ApplicationContext的主要实现类有：FileSystemXmlApplicationContext、ClassPathXmlApplicationContext、WebXmlApplicationContext

	测试代码：com.jacky.applicationContext.bean包下面

4). Spring Bean的定义

Bean的属性如下图：  

属性						    |			描述
------------------------	    |      -------------------------------------------------------------
class					    |	这个属性是强制性的，并且指定用来创建 bean 的 bean 类。
name						    |	这个属性指定唯一的 bean 标识符。在基于 XML 的配置元数据中，你可以使用 ID 和/或 name 属性来指定 bean 标识符。
scope					    |	这个属性指定由特定的 bean 定义创建的对象的作用域，它将会在 bean 作用域的章节中进行讨论。
constructor-arg			    |	它是用来注入依赖关系的，并会在接下来的章节中进行讨论。
properties				    |	它是用来注入依赖关系的，并会在接下来的章节中进行讨论。
autowiring mode			    |	它是用来注入依赖关系的，并会在接下来的章节中进行讨论。
lazy-initialization mode	    |	延迟初始化的 bean 告诉 IoC 容器在它第一次被请求时，而不是在启动时去创建一个 bean 实例。
initialization 方法		    |	在 bean 的所有必需的属性被容器设置之后，调用回调方法。它将会在 bean 的生命周期章节中进行讨论。
destruction 方法			    |	当包含该 bean 的容器被销毁时，使用回调方法。它将会在 bean 的生命周期章节中进行讨论。

5). Bean的作用域

作用域                  |       描述
----                   |       ----
singleton              | 在spring IoC容器仅存在一个Bean实例，Bean以单例方式存在，默认值
prototype              | 每次从容器中调用Bean时，都返回一个新的实例，即每次调用getBean()时，相当于执行newXxxBean()
request                | 每次HTTP请求都会创建一个新的Bean，该作用域仅适用于WebApplicationContext环境
session                | 同一个HTTP Session共享一个Bean，不同Session使用不同的Bean，仅适用于WebApplicationContext环境
global-session         | 一般用于Portlet应用环境，该运用域仅适用于WebApplicationContext环境

	测试代码：com.jacky.scope.bean包下


6). Bean的生命周期
* Bean的生命周期可以表达为：Bean的定义——Bean的初始化——Bean的使用——Bean的销毁 
* 为了初始化和销毁bean，我们只要声明带有 init-method 和/或 destroy-method 参数的

	测试代码：com.jakcy.lifeCycle.bean包下
	
7). Bean后置处理器
* Bean 后置处理器允许在调用初始化方法前后对 Bean 进行额外的处理。
* BeanPostProcessor接口定义了回调方法，实现再Bean初始化前后，进行额外的处理。

	测试代码：com.jacky.post.bean包下

8). Bean的继承
* 子 bean 的定义继承父定义的配置数据。子定义可以根据需要重写一些值，或者添加其他值。
* Spring Bean 定义的继承与 Java 类的继承无关，但是继承的概念是一样的。你可以定义一个父 bean 的定义作为模板和其他子 bean 就可以从父 bean 中继承所需的配置。

	测试代码：com.jacky.inheritance.bean包下
	

## 2、Spring依赖注入 
Spring框架的核心功能之一就是通过依赖注入的方式来管理Bean之间的依赖关系。

序号       |                       依赖注入类型 & 描述
--------  |                        ----
1 	      |          Constructor-based dependency injection 当容器调用带有多个参数的构造函数类时，实现基于构造函数的 DI，每个代表在其他类中的一个依赖关系。
2         |          Setter-based dependency injection 基于 setter 方法的 DI 是通过在调用无参数的构造函数或无参数的静态工厂方法实例化 bean 之后容器调用 beans 的 setter 方法来实现的。

1). 基于构造器的依赖注入
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <!-- Definition for textEditor bean -->
   <bean id="textEditor" class="com.tutorialspoint.TextEditor">
      <constructor-arg ref="spellChecker"/>
   </bean>

   <!-- Definition for spellChecker bean -->
   <bean id="spellChecker" class="com.tutorialspoint.SpellChecker">
   </bean>

</beans>
```

	测试代码:com.jacky.di.constructor.bean包下

2). 基于setter方法的依赖注入
* setter方式注入
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <!-- Definition for textEditor bean -->
   <bean id="textEditor" class="com.tutorialspoint.TextEditor">
      <property name="spellChecker" ref="spellChecker"/>
   </bean>

   <!-- Definition for spellChecker bean -->
   <bean id="spellChecker" class="com.tutorialspoint.SpellChecker">
   </bean>

</beans>
```

* p-namespace方式注入
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <bean id="john-classic" class="com.example.Person"
      p:name="John Doe"
      p:spouse-ref="jane"/>
   </bean>

   <bean name="jane" class="com.example.Person"
      p:name="John Doe"/>
   </bean>

</beans>
```

	测试代码：com.jacky.di.setter.bean包下
	
3). 注入内部Beans
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <!-- Definition for textEditor bean using inner bean -->
   <bean id="textEditor" class="com.tutorialspoint.TextEditor">
      <property name="spellChecker">
         <bean id="spellChecker" class="com.tutorialspoint.SpellChecker"/>
       </property>
   </bean>

</beans>
```
	
	测试代码：com.jacky.di.innerClass.bean包下

4). 注入集合
* 已学习：value 属性来配置基本数据类型
* 已学习：ref 属性来配置对象引用
* 本节学习：Spring 提供了四种类型的集合的配置元素（List、Set、Map 和 Properties）

元素            |	    描述
--------	-               --------
<list>          |    它有助于连线，如注入一列值，允许重复。
<set>	        |    它有助于连线一组值，但不能重复。
<map>	        |    它可以用来注入名称-值对的集合，其中名称和值可以是任何类型。
<props>	        |    它可以用来注入名称-值对的集合，其中名称和值都是字符串类型。



标题
====
标题
----

# 标题1
## 标题2
### 标题3
#### 标题4
##### 标题5
###### 标题6

*强调(斜体)*  
_强调(斜体)_  

**加重强调(粗体)**  
__加重强调(粗体)__  

***加重强调(粗斜体)***  
___加重强调(粗斜体)___  

`Hello World!(代码)`  
```
Hello World!(代码高亮)
```  

表头        |   表头        |   表头
----        |   ----        |   ----
表格内容    |   表格内容    |   表格内容
表格内容    |   表格内容    |   表格内容


图片链接  
![https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573126990921&di=9a0ab1eb009f7aad0c0e5de02cf0ab45&imgtype=0&src=http%3A%2F%2Fwww.yiidian.com%2Fuploadfile%2F2017%2F1115%2F20171115091150660.jpg]

普通链接  
[https://www.w3cschool.cn/wkspring/]

1. 项目1
2. 项目2
3. 项目3
    * 子项目1
    * 子项目2


> 第一行引用文字  
> 第二行引用文字  
