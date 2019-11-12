package com.jacky.aop.aspect.bean;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*
 * 声明Aspect
 */
@Aspect
public class Logging {
	
	/*
	 * 声明PointCut
	 */
	@Pointcut("execution(* com.jacky.aop.aspect.bean.*.*(..))")
	private void selectAll() {
		
	}
	
	@Before("selectAll()")
	public void beforeAdvice() {
		System.out.println("Going to setup student profile.");
	}
	
	@After("selectAll()")
	public void afterAdvice() {
		System.out.println("Student profile has been setup.");
	}
	
	@AfterReturning(pointcut = "selectAll()", returning = "retVal")
	public void afterReturningAdvice(Object retVal) {
		System.out.println("Returning : " + retVal.toString());
	}
	
	@AfterThrowing(pointcut = "selectAll()", throwing = "ex")
	public void afterThrowingAdvice(IllegalArgumentException ex) {
		System.out.println("There has been an exception : " + ex.toString());
	}
}
