package com.example.springhillel.repository.jdbcRepository;

import com.example.springhillel.model.entity.Role;
import com.example.springhillel.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class JdbcRoleRepositoryImpl implements RoleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createRole(Role role) {
        jdbcTemplate.update("INSERT INTO role (name) VALUES (?)",
                role.getName());
    }

    @Override
    public void roleAssignment(long userId, long roleId) {
        jdbcTemplate.update("UPDATE user set role_id = ? where id = ?",
                userId, roleId);
    }

    @Override
    public void addActionPontToRole(int roleId, int actionId) {
        jdbcTemplate.update("INSERT INTO role_action_point (role_id, action_point_id) VALUES (?, ?)",
                roleId, actionId);
    }

    @Override
    public void deleteRole(int id) {
        jdbcTemplate.update("DELETE FROM user_role WHERE id = ?", id);

    }

    @Override
    public List<Role> getActionPointRole() {
        return null;
    }
}
