package com.example.springhillel.repository;

import com.example.springhillel.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAll();
    void create(User user);
    void deleted(int id);
    User findUserById(int userId);

}
