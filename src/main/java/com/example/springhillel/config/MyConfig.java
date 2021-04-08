package com.example.springhillel.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.example.springhillel")
@EnableTransactionManagement
public class MyConfig {

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
