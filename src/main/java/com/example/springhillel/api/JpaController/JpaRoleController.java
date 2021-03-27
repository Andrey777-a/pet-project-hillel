package com.example.springhillel.api.JpaController;

import com.example.springhillel.model.entity.Role;
import com.example.springhillel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jpa")
public class JpaRoleController {

    @Qualifier("jpaRoleServiceImpl")
    @Autowired
    private RoleService roleService;

    @PostMapping("/createRole")
    public void createRole(@RequestBody Role role) {

        roleService.createRole(role);

    }

    @PatchMapping("/addRoleUser/{userId}/{roleId}")
    public void addRoleUser(@PathVariable int userId, @PathVariable int roleId) {

        roleService.roleAssignment(userId, roleId);

    }

    @PostMapping("/addActionPontToRole/{roleId}/{actionId}")
    public void addActionPontToRole(@PathVariable int roleId, @PathVariable int actionId) {

        roleService.roleAssignment(roleId, actionId);

    }

    @DeleteMapping("/deleteUserRole/{id}")
    public void deleteUserRole(@PathVariable int id) {

        roleService.deleteRole(id);

    }

    @GetMapping("/getRolePoint")
    public List<Role> getRolePoint(){
        return roleService.getActionPointRole();
    }
}
