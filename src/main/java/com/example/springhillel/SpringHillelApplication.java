package com.example.springhillel;

import com.example.springhillel.beanpostprocessor.BeanPostProcessorImpl;
import com.example.springhillel.config.MyConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@Slf4j
public class SpringHillelApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHillelApplication.class, args);
		/*AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext(MyConfig.class);

		BeanPostProcessorImpl postProcessor = (BeanPostProcessorImpl) applicationContext
				.getBean("beanPostProcessorImpl");

		applicationContext.close();*/
	}

}
