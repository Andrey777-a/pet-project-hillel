package com.example.springhillel.api;

import com.example.springhillel.model.User;
import com.example.springhillel.repository.AbstractRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    AbstractRespository abstractRespository;

    @GetMapping("/getAllUser")
    public void getAllUser() {

        abstractRespository.getAll();

    }

    @PostMapping("/insertUser")
    public void insertUser(@RequestBody User user) {

        abstractRespository.create(user);

    }

}
