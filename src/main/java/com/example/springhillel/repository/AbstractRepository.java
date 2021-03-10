package com.example.springhillel.repository;

import com.example.springhillel.model.TaskAttribute;
import com.example.springhillel.model.User;
import com.example.springhillel.model.UserRole;
import com.example.springhillel.model.UserRoleClass;

import java.util.List;

public interface AbstractRepository {

    List<User> getAll();
    void create(User user);
    void deleted(int id);




}
