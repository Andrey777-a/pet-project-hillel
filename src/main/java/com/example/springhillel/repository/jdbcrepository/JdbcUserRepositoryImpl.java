package com.example.springhillel.repository.jdbcrepository;

import com.example.springhillel.model.dto.UserDTO;
import com.example.springhillel.model.entity.User;
import com.example.springhillel.repository.jparepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcUserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAll() {

        List<User> strLst  = jdbcTemplate.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return new User(resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("password"),
                        resultSet.getString("email"));
            }
        });

        return strLst;
    }

    @Override
    public void create(UserDTO user) {
            jdbcTemplate.update("INSERT INTO user (first_name, last_name, email) VALUES (?, ?, ?)",
                    user.getFirstName(), user.getLastName(), user.getEmail());

    }

    @Override
    public void deleted(int id) {

        jdbcTemplate.update("DELETE FROM user WHERE id = ?", id);


    }

    @Override
    public User findUserById(long userId){


        List<User> userList =jdbcTemplate.query("select * from user where id = ?",
                preparedStatement -> preparedStatement.setLong(1, userId),
                (ResultSet resultSet, int i) -> new User(/*resultSet.getInt("id")*/));

        if (userList.size()==1){
            return userList.get(0);
        }

        return new User();
    }

}
