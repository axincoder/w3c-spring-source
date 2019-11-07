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
---------------------------	    |      -------------------------------------------------------------
class					    |	这个属性是强制性的，并且指定用来创建 bean 的 bean 类。
name						    |	这个属性指定唯一的 bean 标识符。在基于 XML 的配置元数据中，你可以使用 ID 和/或 name 属性来指定 bean 标识符。
scope					    |	这个属性指定由特定的 bean 定义创建的对象的作用域，它将会在 bean 作用域的章节中进行讨论。
constructor-arg			    |	它是用来注入依赖关系的，并会在接下来的章节中进行讨论。
properties				    |	它是用来注入依赖关系的，并会在接下来的章节中进行讨论。
autowiring mode			    |	它是用来注入依赖关系的，并会在接下来的章节中进行讨论。
lazy-initialization mode	    |	延迟初始化的 bean 告诉 IoC 容器在它第一次被请求时，而不是在启动时去创建一个 bean 实例。
initialization 方法		    |	在 bean 的所有必需的属性被容器设置之后，调用回调方法。它将会在 bean 的生命周期章节中进行讨论。
destruction 方法			    |	当包含该 bean 的容器被销毁时，使用回调方法。它将会在 bean 的生命周期章节中进行讨论。

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
