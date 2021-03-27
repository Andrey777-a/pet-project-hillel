package com.example.springhillel.service.jpaService;

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
public class JpaUserServiceImpl implements UserService {


    @Qualifier("jpaUserRepositoryImpl")
    @Autowired
    private UserRepository jpaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return jpaRepository.getAll();
    }

    @Override
    @Transactional
    public void create(UserDTO user) {
        jpaRepository.create(user);
    }

    @Override
    @Transactional
    public void deleted(int id) {
        jpaRepository.deleted(id);
    }

}
