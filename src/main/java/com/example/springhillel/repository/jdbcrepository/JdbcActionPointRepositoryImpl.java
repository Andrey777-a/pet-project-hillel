package com.example.springhillel.repository.jdbcrepository;

import com.example.springhillel.model.entity.ActionPoint;
import com.example.springhillel.repository.jparepository.ActionPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcActionPointRepositoryImpl implements ActionPointRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createActionPoint(ActionPoint actionPoint) {

        jdbcTemplate.update("INSERT INTO action_point (name) VALUES (?)",
                actionPoint.getName());

    }

    @Override
    public void deleteActionPoint(long id) {
        jdbcTemplate.update("DELETE FROM action_point WHERE id = ?", id);
    }
}
