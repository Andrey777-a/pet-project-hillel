package com.example.springhillel.api.service.crudservice;

import com.example.springhillel.AbstractIntegrationTest;
import com.example.springhillel.model.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Slf4j
public class RoleServiceIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testIntegrationFindByIdRole(){
        Optional<Role> roleOptional = roleService.findById(1);

        Assertions.assertEquals("ROLE_ADMIN", roleOptional.get().getName());
    }
    @Test
    public void testIntegrationGetAllRole(){
        List<Role> roleList = roleService.getAll();

        Assertions.assertFalse(roleList.isEmpty());
        Assertions.assertEquals(2, roleService.getAll().size());
    }
}
