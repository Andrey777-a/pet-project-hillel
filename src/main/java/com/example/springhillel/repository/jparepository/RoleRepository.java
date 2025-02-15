package com.example.springhillel.repository.jparepository;

import com.example.springhillel.model.entity.Role;

import java.util.List;

public interface RoleRepository {

    void createRole(Role role);
    void roleAssignment(long userId, long roleId);
    void addActionPontToRole(int roleId, int actionId);
    void deleteRole(long id);
    List<Role> getActionPointRole();
}
