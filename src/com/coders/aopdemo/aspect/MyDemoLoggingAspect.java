package com.coders.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.coders.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Before("com.coders.aopdemo.aspect.AopExpressions.forDaoPackageNoGettersAndSetters()")
	public void runBeforeAddAccount(JoinPoint theJointPoint) {
		
		System.out.println("Buddy we are in the logging Aspect. runBeforeAddAccount");
		
		//display the method signature
		MethodSignature methodSig = (MethodSignature) theJointPoint.getSignature();
		System.out.println("Method: "+methodSig);
		
		//display the method arguments
		Object[] args = theJointPoint.getArgs();
		
		for (Object tempArg:args) {
			System.out.println(tempArg);
			if(tempArg instanceof Account) {
				Account theAccount = (Account)tempArg;
				System.out.println("Name: "+theAccount.getName());
				System.out.println("Level: "+theAccount.getLevel());
			}
			
		}
		
	}
		
}
