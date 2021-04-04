package com.example.springhillel.repository;

import com.example.springhillel.model.dto.UserDTO;
import com.example.springhillel.model.entity.User;

import java.util.List;

public interface UserRepository {

    List<User> getAll();
    void create(UserDTO user);
    void deleted(int id);
    User findUserById(long userId);

}
