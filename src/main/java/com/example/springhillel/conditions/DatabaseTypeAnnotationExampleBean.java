package com.example.springhillel.conditions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


//mvn clean package spring-boot:run -DmySql=false
@Component
@Conditional(DatabaseTypeCondition.class)
@Slf4j
public class DatabaseTypeAnnotationExampleBean {

    @PostConstruct
    public void init() {
        log.info("----------DatabaseTypeAnnotationExampleBean created");
    }
}
