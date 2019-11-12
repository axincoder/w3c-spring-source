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
