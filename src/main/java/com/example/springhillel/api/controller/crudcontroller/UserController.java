package com.example.springhillel.api.controller.crudcontroller;

import com.example.springhillel.api.controller.AbstractControllerImpl;
import com.example.springhillel.api.service.crudservice.UserService;
import com.example.springhillel.model.dto.UserDTO;
import com.example.springhillel.model.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("userControllerCrud")
@RequestMapping("/user")
public class UserController extends AbstractControllerImpl<User, UserDTO, UserService> {
}
