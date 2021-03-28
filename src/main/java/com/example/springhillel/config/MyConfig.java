package com.example.springhillel.config;

import com.example.springhillel.beanpostprocessor.BeanPostProcessorImpl;
import com.example.springhillel.model.entity.TaskAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Configuration
@ComponentScan(basePackages = "com.example.springhillel")
@EnableTransactionManagement
public class MyConfig {

    @Bean
    public BeanPostProcessor beanPostProcessor(){
        return new BeanPostProcessorImpl();
    }

   /*

    @Autowired
    JpaTaskRepositoryImpl jpaTaskRepository;


*/
   /*

    @PostConstruct
    public void init(){

     TaskAttribute taskAttribute = new TaskAttribute("DeckName", "deckr", 3, 1, 2,
                5.0, LocalDateTime.now(), LocalDateTime.now(), 2);

        jpaTaskRepository.createTask(taskAttribute);

      jpaService.getAll();
 }*/

}
