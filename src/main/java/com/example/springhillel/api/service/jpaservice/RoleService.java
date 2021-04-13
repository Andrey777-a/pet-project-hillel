package com.example.springhillel.api.service.jpaservice;

import com.example.springhillel.model.entity.Role;

import java.util.List;

public interface RoleService {

    void createRole(Role role);
    void roleAssignment(long userId, long roleId);
    void deleteRole(long id);
    void addActionPontToRole(int roleId, int actionId);
    List<Role> getActionPointRole();

}
