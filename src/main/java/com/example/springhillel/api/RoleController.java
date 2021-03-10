package com.example.springhillel.api;

import com.example.springhillel.model.UserRoleClass;
import com.example.springhillel.repository.AbstractRepository;
import com.example.springhillel.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/addRoleUser")
    public void addRoleUser(@RequestBody UserRoleClass userRole) {

        roleRepository.roleAssignment(userRole);

    }

    @DeleteMapping("/deleteUserRole/{id}")
    public void deleteUserRole(@PathVariable int id) {

        roleRepository.deleteRole(id);

    }
}
