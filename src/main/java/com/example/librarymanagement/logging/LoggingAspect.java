package com.example.librarymanagement.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect  {
    
    @Before("execution(* com.example..*.*(..))")
    public void beforeMethodExecution(JoinPoint joinPoint) {
        System.out.println("Method " + joinPoint.getSignature().getName() + " is called.");
    }

    @AfterThrowing(pointcut = "execution(* com.example..*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        System.out.println("Exception in method " + joinPoint.getSignature().getName() + ": " + ex.getMessage());
    }
}
