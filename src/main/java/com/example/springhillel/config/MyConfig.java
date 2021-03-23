package com.example.springhillel.config;

import com.example.springhillel.model.dto.UserDTO;
import com.example.springhillel.model.entity.ActionPoint;
import com.example.springhillel.model.entity.Role;
import com.example.springhillel.repository.jpaRepository.JpaTaskRepositoryImpl;
import com.example.springhillel.service.jpaService.JpaActionPointServiceImpl;
import com.example.springhillel.service.jpaService.JpaRoleServiceImpl;
import com.example.springhillel.service.jpaService.JpaUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class MyConfig {

    @Autowired
    JpaUserServiceImpl jpaService;

    @Autowired
    JpaActionPointServiceImpl actionPointService;

    @Autowired
    JpaRoleServiceImpl roleService;

    @Autowired
    JpaTaskRepositoryImpl jpaTaskRepository;

    @PostConstruct
    public void init(){

        ActionPoint actionPoint = new ActionPoint("VIEW_TICKET");
        ActionPoint actionPoint2 = new ActionPoint("ADD_TICKET");
        ActionPoint actionPoint3 = new ActionPoint("ADD_USER");
        ActionPoint actionPoint4 = new ActionPoint("EDIT_USER");
        ActionPoint actionPoint5 = new ActionPoint("DELETE_USER");

        actionPointService.createActionPoint(actionPoint);
        actionPointService.createActionPoint(actionPoint2);
        actionPointService.createActionPoint(actionPoint3);
        actionPointService.createActionPoint(actionPoint4);
        actionPointService.createActionPoint(actionPoint5);

        Role role = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_ANALYST");
        roleService.createRole(role);
        roleService.createRole(role2);

        roleService.addActionPontToRole(1, 5);
        roleService.addActionPontToRole(1, 2);

        UserDTO user = new UserDTO("Roy", "Gibson", "pass", "email", 1);
        UserDTO user2 = new UserDTO("Dima", "Ivanov", "pass", "email2", 2);
        UserDTO user3 = new UserDTO("Ira", "Smirnova", "pass", "email3", 1);

        jpaService.create(user);
        jpaService.create(user2);
        jpaService.create(user3);



        /*TaskAttribute taskAttribute = new TaskAttribute("DeckName", "deckr", 3, 1, 2,
                5.0,LocalDateTime.now(), LocalDateTime.now(), 2);

        jpaTaskRepository.createTask(taskAttribute);*/


        jpaService.getAll();
    }

}
