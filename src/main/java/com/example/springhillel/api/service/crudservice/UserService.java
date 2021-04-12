package com.example.springhillel.api.service.crudservice;

import com.example.springhillel.api.service.AbstractServiceImpl;
import com.example.springhillel.model.dto.UserDTO;
import com.example.springhillel.model.entity.User;
import com.example.springhillel.repository.jpacrudrepozitory.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractServiceImpl<User, UserDTO, UserRepository> {
}
