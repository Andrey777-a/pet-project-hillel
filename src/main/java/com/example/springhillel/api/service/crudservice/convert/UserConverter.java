package com.example.springhillel.api.service.crudservice.convert;

import com.example.springhillel.model.dto.UserDTO;
import com.example.springhillel.model.entity.Role;
import com.example.springhillel.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class UserConverter implements AbstractConvert<User, UserDTO> {

    @Autowired
    private EntityManager entityManager;

    @Override
    public User convertToEntity(UserDTO userDTO) {

        Role role = entityManager.find(Role.class, userDTO.getRoleId());

        return new User(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getPassword(),
                userDTO.getEmail(), role);
    }

    @Override
    public UserDTO covertToDTO(User user) {
        return new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getPassword(), user.getRole().getId());
    }
}
