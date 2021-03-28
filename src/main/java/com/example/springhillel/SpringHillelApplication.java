package com.example.springhillel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@Slf4j
public class SpringHillelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHillelApplication.class, args);
	}

}
