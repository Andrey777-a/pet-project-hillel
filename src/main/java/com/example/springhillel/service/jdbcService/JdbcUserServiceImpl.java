package com.example.springhillel.service.jdbcService;

import com.example.springhillel.model.dto.UserDTO;
import com.example.springhillel.model.entity.User;
import com.example.springhillel.repository.UserRepository;
import com.example.springhillel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JdbcUserServiceImpl implements UserService {

    @Qualifier("jdbcUserRepositoryImpl")
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    @Transactional
    public void create(UserDTO user) {
        userRepository.create(user);
    }

    @Override
    @Transactional
    public void deleted(int id) {

        if (userRepository.findUserById(id).getId() != 0) {
            userRepository.deleted(id);
        }
    }

}
