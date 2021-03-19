package com.example.springhillel.service;

import com.example.springhillel.model.UserRoleClass;
import com.example.springhillel.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void roleAssignment(UserRoleClass userRole) {
        roleRepository.roleAssignment(userRole);
    }

    @Override
    public void deleteRole(int id) {
        roleRepository.deleteRole(id);
    }
}
