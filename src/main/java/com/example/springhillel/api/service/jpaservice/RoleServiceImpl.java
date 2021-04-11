package com.example.springhillel.api.service.jpaservice;

import com.example.springhillel.exception.NotFoundException;
import com.example.springhillel.model.entity.Role;
import com.example.springhillel.repository.jparepository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Qualifier("jpaRoleRepositoryImpl")
    @Autowired
    private RoleRepository jpaRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createRole(Role role) {
        jpaRepository.createRole(role);
    }

    @Override
    @Transactional
    public void roleAssignment(long userId, long roleId) {
        validRole(roleId);

        jpaRepository.roleAssignment(userId, roleId);
    }

    @Override
    @Transactional
    public void addActionPontToRole(int roleId, int actionId) {
        jpaRepository.addActionPontToRole(roleId, actionId);
    }

    @Override
    @Transactional
    public void deleteRole(long id) {

        validRole(id);

        jpaRepository.deleteRole(id);
    }

    @Override
    @Transactional
    public List<Role> getActionPointRole(){

        return jpaRepository.getActionPointRole();
    }

    private void validRole(long id){
        Role role = entityManager.find(Role.class, id);

        if(role == null){
            throw new NotFoundException("Role not found");
        }
    }

}
