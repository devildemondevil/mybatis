package com.jsz.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOP {

    @Pointcut("execution(* com.jsz.mapper.*Mapper.*(..))")
    private void myPointCut(){}


    @Around("myPointCut()")
    public Object time(ProceedingJoinPoint pjp) throws Throwable {


        Long start=System.currentTimeMillis();
        Object object=  pjp.proceed();


        Long end=System.currentTimeMillis();

//        Long result=start-end
        System.out.println("ºÄÊ±£º"+(end-start)+"ms");
        return object;
    }

}
