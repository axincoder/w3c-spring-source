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


元素             |	    描述
--------        |      --------
list            |    它有助于连线，如注入一列值，允许重复。
set	            |    它有助于连线一组值，但不能重复。
map	            |    它可以用来注入名称-值对的集合，其中名称和值可以是任何类型。
props	        |    它可以用来注入名称-值对的集合，其中名称和值都是字符串类型。

* 集合配置示例(注入基本数据类型）
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <!-- Definition for javaCollection -->
   <bean id="javaCollection" class="com.tutorialspoint.JavaCollection">

      <!-- results in a setAddressList(java.util.List) call -->
      <property name="addressList">
         <list>
            <value>INDIA</value>
            <value>Pakistan</value>
            <value>USA</value>
            <value>USA</value>
         </list>
      </property>

      <!-- results in a setAddressSet(java.util.Set) call -->
      <property name="addressSet">
         <set>
            <value>INDIA</value>
            <value>Pakistan</value>
            <value>USA</value>
            <value>USA</value>
        </set>
      </property>

      <!-- results in a setAddressMap(java.util.Map) call -->
      <property name="addressMap">
         <map>
            <entry key="1" value="INDIA"/>
            <entry key="2" value="Pakistan"/>
            <entry key="3" value="USA"/>
            <entry key="4" value="USA"/>
         </map>
      </property>

      <!-- results in a setAddressProp(java.util.Properties) call -->
      <property name="addressProp">
         <props>
            <prop key="one">INDIA</prop>
            <prop key="two">Pakistan</prop>
            <prop key="three">USA</prop>
            <prop key="four">USA</prop>
         </props>
      </property>

   </bean>

</beans>
```

* 集合配置(注入Bean）
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <!-- Bean Definition to handle references and values -->
   <bean id="..." class="...">

      <!-- Passing bean reference  for java.util.List -->
      <property name="addressList">
         <list>
            <ref bean="address1"/>
            <ref bean="address2"/>
            <value>Pakistan</value>
         </list>
      </property>

      <!-- Passing bean reference  for java.util.Set -->
      <property name="addressSet">
         <set>
            <ref bean="address1"/>
            <ref bean="address2"/>
            <value>Pakistan</value>
         </set>
      </property>

      <!-- Passing bean reference  for java.util.Map -->
      <property name="addressMap">
         <map>
            <entry key="one" value="INDIA"/>
            <entry key ="two" value-ref="address1"/>
            <entry key ="three" value-ref="address2"/>
         </map>
      </property>

   </bean>

</beans>
```

* 集合配置（注入null）
```
<bean id="..." class="exampleBean">
   <property name="email"><null/></property>
</bean>
```

* 集合配置（注入空字符串）
```
<bean id="..." class="exampleBean">
   <property name="email" value=""/>
</bean>
```

	测试代码：com.jacky.collection.bean包下
	

## 3、Spring Bean自动装配

1). 自动装配模式

模式	       |  描述
--         |  ----
no	       |   这是默认的设置，它意味着没有自动装配，你应该使用显式的bean引用来连线。你不用为了连线做特殊的事。在依赖注入章节你已经看到这个了。
byName	   |   由属性名自动装配。Spring 容器看到在 XML 配置文件中 bean 的自动装配的属性设置为 byName。然后尝试匹配，并且将它的属性与在配置文件中被定义为相同名称的 beans 的属性进行连接。
byType	   |   由属性数据类型自动装配。Spring 容器看到在 XML 配置文件中 bean 的自动装配的属性设置为 byType。然后如果它的类型匹配配置文件中的一个确切的 bean 名称，它将尝试匹配和连接属性的类型。如果存在不止一个这样的 bean，则一个致命的异常将会被抛出。
constructor |  	类似于 byType，但该类型适用于构造函数参数类型。如果在容器中没有一个构造函数参数类型的 bean，则一个致命错误将会发生。
autodetect	| Spring首先尝试通过 constructor 使用自动装配来连接，如果它不执行，Spring 尝试通过 byType 来自动装配。

2). 自动装配( byName )
* 显示的依赖注入(setter方式)
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <!-- Definition for textEditor bean -->
   <bean id="textEditor" class="com.tutorialspoint.TextEditor">
       <property name="spellChecker" ref="spellChecker" />
       <property name="name" value="Generic Text Editor" />
   </bean>

   <!-- Definition for spellChecker bean -->
   <bean id="spellChecker" class="com.tutorialspoint.SpellChecker">
   </bean>

</beans>
```

* 自动的依赖注入(byName）
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <!-- Definition for textEditor bean -->
   <bean id="textEditor" class="com.tutorialspoint.TextEditor" 
      autowire="byName">
      <property name="name" value="Generic Text Editor" />
   </bean>

   <!-- Definition for spellChecker bean -->
   <bean id="spellChecker" class="com.tutorialspoint.SpellChecker">
   </bean>

</beans>
```

	测试代码: com.jacky.autowire.byName.bean包下

3). 自动装配( byType )

	同“byName”，配置时差别为autowire="byName"修改为autowire="byType"
	
4). 由构造函数自动装配


## 3、Spring基于注解的配置

1). 开启注解功能
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-3.0.xsd">

   <context:annotation-config/>
   <!-- bean definitions go here -->

</beans>
```

2) 注解的种类


序号            |	    注解 & 解释
--------       |    ----------
1	            |   @Required  @Required 注解应用于 bean 属性的 setter 方法。
2	            |   @Autowired  @Autowired 注解可以应用到 bean 属性的 setter 方法，非 setter 方法，构造函数和属性。
3	            |   @Qualifier  通过指定确切的将被连线的 bean，@Autowired 和 @Qualifier 注解可以用来删除混乱。
4	            |   JSR-250 Annotations  Spring 支持 JSR-250 的基础的注解，其中包括了 @Resource，@PostConstruct 和 @PreDestroy 注解。



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
