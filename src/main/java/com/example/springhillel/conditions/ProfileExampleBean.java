package com.example.springhillel.conditions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
@Profile("local")
public class ProfileExampleBean {

    @PostConstruct
    public void init() {
        log.info("----------ProfileExampleBean created");
    }

}
