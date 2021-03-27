package com.example.springhillel.service.jpaService;

import com.example.springhillel.model.entity.Role;
import com.example.springhillel.repository.RoleRepository;
import com.example.springhillel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JpaRoleServiceImpl implements RoleService {

    @Qualifier("jpaRoleRepositoryImpl")
    @Autowired
    private RoleRepository jpaRepository;

    @Override
    @Transactional
    public void createRole(Role role) {
        jpaRepository.createRole(role);
    }

    @Override
    @Transactional
    public void roleAssignment(long userId, long roleId) {
        jpaRepository.roleAssignment(userId, roleId);
    }

    @Override
    @Transactional
    public void addActionPontToRole(int roleId, int actionId) {
        jpaRepository.addActionPontToRole(roleId, actionId);
    }

    @Override
    @Transactional
    public void deleteRole(int id) {
        jpaRepository.deleteRole(id);
    }

    @Override
    @Transactional
    public List<Role> getActionPointRole(){
        return jpaRepository.getActionPointRole();
    }
}
