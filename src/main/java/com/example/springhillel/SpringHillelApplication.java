package com.example.springhillel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Slf4j
@EnableAspectJAutoProxy
@EnableScheduling
@EnableBatchProcessing
//http://localhost:8880/bug-tracker/swagger-ui.html#
public class SpringHillelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHillelApplication.class, args);
	}

}
