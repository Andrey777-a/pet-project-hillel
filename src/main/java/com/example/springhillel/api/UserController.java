package com.example.springhillel.api;

import com.example.springhillel.model.User;
import com.example.springhillel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    public List<User> getAllUser() {

        return userService.getAll();

    }

    @PostMapping("/insertUser")
    public void insertUser(@RequestBody User user) {

        userService.create(user);

    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id) {

        userService.deleted(id);

    }
}
