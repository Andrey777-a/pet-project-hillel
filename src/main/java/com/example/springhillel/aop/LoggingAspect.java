package com.example.springhillel.aop;

import com.example.springhillel.exception.NotFoundException;
import com.example.springhillel.model.entity.TaskAttribute;
import com.example.springhillel.model.entity.User;
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
    public void loggingParamMethodBefore(JoinPoint joinPoint){

        Object[] arg = joinPoint.getArgs();

        for (Object obj: arg){

            if(obj instanceof com.example.springhillel.model.entity.User) {

                if(joinPoint.getSignature().getName().equals("create")){
                    log.info("User parameter " + obj.toString());
                }

            } else if (obj instanceof TaskAttribute){
                switch (joinPoint.getSignature().getName()) {
                    case "createTask" :
                    case "updateTask":
                        log.info("Task " + ((TaskAttribute) obj).getName());
                        break;
                    case "getTaskUser":
                        log.info("Task " + obj.toString());
                        break;
                }
            }
        }

    }

    @AfterReturning("loggingRepositoryMethod()")
    public void loggingParamMethodAfter(JoinPoint joinPoint){
        Object[] arg = joinPoint.getArgs();

        for (Object obj: arg){

            if (obj instanceof Integer){
                switch (joinPoint.getSignature().getName()) {
                    case "deleted":
                        log.info("User " + ((Integer) obj).intValue() + " - deleted.");
                        break;
                    case "findUserById":
                        log.info("parameter " + ((Integer) obj).intValue() + " to search for user");
                        break;
                    case "getTaskUser":
                        log.info(((Integer) obj).intValue() + " user tasks - unloaded.");
                        break;
                }
            }

            else if(obj instanceof User) {

                if(joinPoint.getSignature().getName().equals("create")){
                    log.info("User parameter " + obj.toString() + " - added.");
                }

            } else if (obj instanceof TaskAttribute){
                switch (joinPoint.getSignature().getName()) {
                    case "createTask":
                        log.info("Task " + ((TaskAttribute) obj).getName() + " - added.");
                        break;
                    case "updateTask":
                        log.info("Task " + ((TaskAttribute) obj).getName() + " - updated.");
                        break;
                    case "getTaskUser":
                        log.info("Task " + obj.toString() + " - unloaded.");
                        break;
                }
            }
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


    @AfterReturning(pointcut = "getInfo()", returning = "listUser")
    public void infoUser(List<com.example.springhillel.model.entity.User> listUser){

        for(com.example.springhillel.model.entity.User user: listUser){
            log.info(user.toString());
        }

    }

    @AfterThrowing(pointcut = "loggingAllMethod()", throwing = "exception")
    public void infoException(Throwable exception){

        log.error(exception.toString());

    }
}
