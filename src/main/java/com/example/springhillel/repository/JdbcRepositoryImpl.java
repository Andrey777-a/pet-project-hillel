package com.example.springhillel.repository;

import com.example.springhillel.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
public class JdbcRepositoryImpl implements AbstractRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAll() {

        List<User> strLst  = jdbcTemplate.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return new User(resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email"));
            }
        });
            for(User users: strLst){
                System.out.println(users);
            }

        return strLst;
    }

    @Override
    public void create(User user) {
            jdbcTemplate.update("INSERT INTO user (first_name, last_name, email) VALUES (?, ?, ?)",
                    user.getFirstName(), user.getLastName(), user.getEmail());

            log.info("User " + user.getFirstName() + " " + user.getLastName() + " added");
    }

    @Override
    public void deleted(int id) {
        jdbcTemplate.update("DELETE FROM user WHERE id = ?", id);

        log.info("User " + id + " deleted");
    }

}
