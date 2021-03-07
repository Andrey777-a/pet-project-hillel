package com.example.springhillel.repository;

import com.example.springhillel.api.UserController;
import com.example.springhillel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DbInit {

    @Autowired
    UserController userController;

    @PostConstruct
    public void init(){
        User user = new User("Roy", "Gibson", "email1@gmail.com");
        User user2 = new User("Dima", "Smirnov", "email2@gmail.com");
        User user3 = new User("Igor", "Serov", "email3@gmail.com");

        userController.insertUser(user);
        userController.insertUser(user2);
        userController.insertUser(user3);

        userController.getAllUser();
    }


}
