package com.example.springhillel.repository;

import com.example.springhillel.model.UserRoleClass;

public interface RoleRepository {

    void roleAssignment(UserRoleClass userRole);
    void deleteRole(int id);
}
