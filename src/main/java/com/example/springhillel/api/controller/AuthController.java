package com.example.springhillel.api.controller;

import com.example.springhillel.api.service.crudservice.UserService;
import com.example.springhillel.model.dto.UserDTO;
import com.example.springhillel.model.entity.User;
import com.example.springhillel.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        UserDTO u = new UserDTO();
        u.setPassword(registrationRequest.getPassword());
        u.setEmail(registrationRequest.getLogin());
        userService.save(u);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getEmail());
        return new AuthResponse(token);
    }

}
