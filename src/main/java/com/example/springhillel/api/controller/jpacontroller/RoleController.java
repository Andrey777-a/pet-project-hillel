package com.example.springhillel.api.controller.jpacontroller;

import com.example.springhillel.model.entity.Role;
import com.example.springhillel.api.service.jpaservice.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role-not-use")
public class RoleController {

    @Qualifier("roleServiceImpl")
    @Autowired
    private RoleService roleService;

    @PostMapping
    public void createRole(@RequestBody Role role) {

        roleService.createRole(role);

    }

    @PostMapping("/{userId}/{roleId}")
    public void addRoleUser(@PathVariable int userId, @PathVariable int roleId) {

        roleService.roleAssignment(userId, roleId);

    }

    @PutMapping("/{roleId}/{actionId}")
    public void addActionPontToRole(@PathVariable int roleId, @PathVariable int actionId) {

        roleService.roleAssignment(roleId, actionId);

    }

    @DeleteMapping("/{id}")
    public void deleteUserRole(@PathVariable int id) {

        roleService.deleteRole(id);

    }

    @GetMapping
    public List<Role> getRolePoint(){
        return roleService.getActionPointRole();
    }
}
