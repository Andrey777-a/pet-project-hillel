package com.example.springhillel.api.service;

import com.example.springhillel.model.dto.UserDTO;
import com.example.springhillel.model.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    void create(UserDTO user);
    void deleted(int id);
    User getUser(long id);

}
