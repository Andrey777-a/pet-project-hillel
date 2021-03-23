package com.example.springhillel.api.JdbcController;

import com.example.springhillel.model.dto.UserDTO;
import com.example.springhillel.model.entity.User;
import com.example.springhillel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jdbc")
public class JdbcUserController {

    @Qualifier("jdbcUserServiceImpl")
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    public List<User> getAllUser() {

        return userService.getAll();

    }

    @PostMapping("/insertUser")
    public void insertUser(@RequestBody UserDTO user) {

        userService.create(user);

    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id) {

        userService.deleted(id);

    }
}
