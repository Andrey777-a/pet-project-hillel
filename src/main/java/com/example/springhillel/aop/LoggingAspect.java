package com.example.springhillel.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut("within(com.example.springhillel..*)")
    private void loggingAllMethod(){}

    @Pointcut("execution(* com.example.springhillel.repository..*())")
    private void getInfo(){}

    @Pointcut("execution(* com.example.springhillel.repository..*(..))")
    private void addParamInfo(){}

    @Around("loggingAllMethod()")
    public Object info(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        log.info(methodSignature.getMethod() + " method started working.");
        long startTime = System.currentTimeMillis();

        Object object = proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();

        long duration = (endTime - startTime);

        log.info("Method " + methodSignature.getMethod() + " finished. Operating time - " + duration + " ms.");

        return object;
    }

    @AfterReturning("getInfo()||addParamInfo()")
    public void loggingParamMethodAfter(JoinPoint joinPoint){

        String args = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));

        switch (joinPoint.getSignature().getName()){
            case "findAll" :
                log.info("Method " + joinPoint.getSignature().getName() + " - Information received.");
                break;
            case "save":
                log.info("Information save. " + joinPoint + ", args=[" + args + "]");
                break;
            case "deleteById":
                log.info("Information delete. " + joinPoint + ", args=[" + args + "]");
                break;
            case "findById":
                log.info("Information search performed " + joinPoint + ", args=[" + args + "]");
                break;
        }

    }

    @AfterThrowing(pointcut = "loggingAllMethod()", throwing = "exception")
    public void infoException(Throwable exception){

        log.error(exception.toString());

    }
}
