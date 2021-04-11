package com.example.springhillel.api.service.jpaservice;

import com.example.springhillel.exception.NotFoundException;
import com.example.springhillel.model.dto.UserDTO;
import com.example.springhillel.model.entity.User;
import com.example.springhillel.repository.jparepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


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

        validUser(id);

        jpaRepository.deleted(id);
    }

    @Override
    @Transactional
    public User getUser(long id) {

        validUser(id);

        return jpaRepository.findUserById(id);
    }

    private void validUser(long id){
        User user = jpaRepository.findUserById(id);

        if(user == null){
            throw new NotFoundException("User not found");
        }
    }

}
