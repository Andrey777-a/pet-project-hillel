package com.example.springhillel.repository;

import com.example.springhillel.model.UserRoleClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class JdbcRoleRepositoryImpl implements RoleRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void roleAssignment(UserRoleClass userRole) {
        jdbcTemplate.update("INSERT INTO user_role (user_id, role) VALUES (?, ?)",
                userRole.getUserId().getId(), userRole.getUserRole().getRole());
        log.info("user " + userRole.getUserId().getId() + " role has been updated");
    }

    @Override
    public void deleteRole(int id) {
        jdbcTemplate.update("DELETE FROM user_role WHERE id = ?", id);

        log.info("Role " + id + " deleted");
    }
}
