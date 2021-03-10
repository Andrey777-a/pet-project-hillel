package com.example.springhillel.repository;

import com.example.springhillel.model.UserRoleClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRoleRepositoryImpl implements RoleRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void roleAssignment(UserRoleClass userRole) {
        jdbcTemplate.update("INSERT INTO user_role (user_id, role) VALUES (?, ?)",
                userRole.getUserId().getId(), userRole.getUserRole().getRole());
    }

    @Override
    public void deleteRole(int id) {
        jdbcTemplate.update("DELETE FROM user_role WHERE id = ?", id);
    }
}
