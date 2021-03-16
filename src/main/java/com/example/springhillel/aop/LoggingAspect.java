package com.example.springhillel.aop;

import com.example.springhillel.model.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut("within(com.example.springhillel..*)")
    private void loggingAllMethod(){}

    @Pointcut("within(com.example.springhillel.repository..*)")
    private void loggingRepositoryMethod(){}

    @Pointcut("execution(* com.example.springhillel.repository..get*())")
    private void getInfo(){}


    @Before("loggingRepositoryMethod()")
    public void loggingParamMethod(JoinPoint joinPoint){

        Object[] arg = joinPoint.getArgs();

        for (Object obj: arg){
            log.info(obj.toString() + " - parameters method.");
        }

    }

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


    @AfterReturning(pointcut = "getInfo()",
            returning = "listUser")
    public void infoUser(List<User> listUser){

        for(User user: listUser){
            log.info(user.toString());
        }

    }

    @AfterThrowing(pointcut = "loggingAllMethod()", throwing = "exception")
    public void infoException(Throwable exception){

        log.error(exception.getMessage());

    }
}
