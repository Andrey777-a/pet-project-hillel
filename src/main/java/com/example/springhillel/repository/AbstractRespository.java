package com.example.springhillel.repository;

import com.example.springhillel.model.User;

import java.util.List;

public interface AbstractRespository {

    List<User> getAll();
    void create(User user);

}
