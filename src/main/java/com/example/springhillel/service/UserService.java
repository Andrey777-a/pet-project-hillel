package com.example.springhillel.service;

import com.example.springhillel.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();
    void create(User user);
    void deleted(int id);

}
