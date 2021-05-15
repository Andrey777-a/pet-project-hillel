package com.example.springhillel.api.service.crudservice;

import com.example.springhillel.AbstractIntegrationTest;
import com.example.springhillel.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testIntegrationFindByIdUser(){
        Optional<User> userOptional = userService.findById(1);

        Assertions.assertEquals("Roy", userOptional.get().getFirstName());
    }
    @Test
    public void testIntegrationGetAllUser(){
        List<User> roleList = userService.getAll();

        Assertions.assertFalse(roleList.isEmpty());
        Assertions.assertEquals(47, userService.getAll().size());
    }
}
