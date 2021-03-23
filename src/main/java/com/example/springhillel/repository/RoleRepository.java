package com.example.springhillel.repository;

import com.example.springhillel.model.entity.Role;

import java.util.List;

public interface RoleRepository {

    void createRole(Role role);
    void roleAssignment(int userId, int roleId);
    void addActionPontToRole(int roleId, int actionId);
    void deleteRole(int id);
    List<Role> getActionPointRole();
}
