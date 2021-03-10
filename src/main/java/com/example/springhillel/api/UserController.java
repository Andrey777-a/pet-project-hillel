package com.example.springhillel.api;

import com.example.springhillel.model.TaskAttribute;
import com.example.springhillel.model.User;
import com.example.springhillel.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    AbstractRepository abstractRepository;

    @GetMapping("/getAllUser")
    public void getAllUser() {

        abstractRepository.getAll();

    }

    @PostMapping("/insertUser")
    public void insertUser(@RequestBody User user) {

        abstractRepository.create(user);

    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id) {

        abstractRepository.deleted(id);

    }
}
