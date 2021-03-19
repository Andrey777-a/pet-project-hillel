package com.example.springhillel.service;

import com.example.springhillel.model.User;
import com.example.springhillel.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public void create(User user) {
        userRepository.create(user);
    }

    @Override
    public void deleted(int id) {

        if (userRepository.findUserById(id).getId() != 0) {
            userRepository.deleted(id);
        }
    }

}
