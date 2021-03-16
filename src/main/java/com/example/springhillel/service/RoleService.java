package com.example.springhillel.service;

import com.example.springhillel.model.UserRoleClass;

public interface RoleService {

    void roleAssignment(UserRoleClass userRole);
    void deleteRole(int id);

}
