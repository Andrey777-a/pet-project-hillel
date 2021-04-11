package com.example.springhillel.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.example.springhillel")
@EnableTransactionManagement
public class MyConfig {


}
