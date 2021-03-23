package com.example.springhillel.service.jdbcService;

import com.example.springhillel.model.entity.Role;
import com.example.springhillel.repository.RoleRepository;
import com.example.springhillel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JdbcRoleServiceImpl implements RoleService {

    @Qualifier("jdbcRoleRepositoryImpl")
    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void createRole(Role role) {
        roleRepository.createRole(role);
    }

    @Override
    @Transactional
    public void roleAssignment(int userId, int roleId) {
        roleRepository.roleAssignment(userId, roleId);
    }

    @Override
    @Transactional
    public void deleteRole(int id) {
        roleRepository.deleteRole(id);
    }

    @Override
    public void addActionPontToRole(int roleId, int actionId) {
        roleRepository.addActionPontToRole(roleId, actionId);
    }

    @Override
    public List<Role> getActionPointRole() {
        return roleRepository.getActionPointRole();
    }
}
