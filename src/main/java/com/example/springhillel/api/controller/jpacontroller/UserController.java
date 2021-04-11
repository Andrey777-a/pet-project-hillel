package com.example.springhillel.api.controller.jpacontroller;

import com.example.springhillel.model.dto.UserDTO;
import com.example.springhillel.model.entity.User;
import com.example.springhillel.api.service.jpaservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-not-use")
public class UserController {

    @Qualifier("userServiceImpl")
    @Autowired
    private UserService userService;

/*
    //test graph
    @Autowired
    JpaUserRepositoryImpl jpaUserRepository;


    @GetMapping("/")
    public User getOneUser() {

        return jpaUserRepository.findOne();

    }
*/

    @GetMapping
    public List<User> getAllUser() {

        return userService.getAll();

    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id) {

        return userService.getUser(id);

    }

    @PostMapping
    public void insertUser(@RequestBody UserDTO user) {

        userService.create(user);

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {

        userService.deleted(id);

    }
}
