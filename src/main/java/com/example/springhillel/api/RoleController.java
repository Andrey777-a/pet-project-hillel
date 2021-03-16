package com.example.springhillel.api;

import com.example.springhillel.model.UserRoleClass;
import com.example.springhillel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/addRoleUser")
    public void addRoleUser(@RequestBody UserRoleClass userRole) {

        roleService.roleAssignment(userRole);

    }

    @DeleteMapping("/deleteUserRole/{id}")
    public void deleteUserRole(@PathVariable int id) {

        roleService.deleteRole(id);

    }
}
