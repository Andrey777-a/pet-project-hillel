package com.example.springhillel.repository.jdbcRepository;

import com.example.springhillel.model.dto.TaskAttributeDTO;
import com.example.springhillel.model.entity.TaskAttribute;
import com.example.springhillel.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;


@Repository
public class JdbcTaskRepositoryImpl implements TaskRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TaskAttribute> getAllTask() {
        return null;
    }

    @Override
    public void createTask(TaskAttributeDTO taskAttribute) {
        jdbcTemplate.update("insert into task_user (name, description, user_id, status, priority, time_spent, " +
                        "time_estimated, created_on_date, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                taskAttribute.getName(), taskAttribute.getDescription(), taskAttribute.getAssignee(),
                taskAttribute.getStatus(), taskAttribute.getPriority(), taskAttribute.getTimeSpent(),
                taskAttribute.getTimeEstimated(), LocalDateTime.now(), taskAttribute.getTypeTask());

    }

    @Override
    public void updateTask(TaskAttribute taskAttribute) {
        jdbcTemplate.update("UPDATE task_user SET description = ?, status = ?, priority = ?, time_spent = ? " +
                        "where id = ?", taskAttribute.getDescription(), taskAttribute.getStatus(), taskAttribute.getPriority(),
                taskAttribute.getTimeSpent(), taskAttribute.getId());

    }

    @Override
    public List<TaskAttribute> getTaskUser(int user) {

        List<TaskAttribute> strLst  = jdbcTemplate.query("select * from task_user where assignee = " + user,
                new RowMapper<TaskAttribute>() {
                    @Override
                    public TaskAttribute mapRow(ResultSet rs, int i) throws SQLException {
                        return new TaskAttribute(rs.getInt("id"),rs.getString("name"),
                                rs.getString("description"), null/*rs.getInt("assignee")*/,
                                null/*rs.getInt("status")*/, rs.getInt("priority"),
                                rs.getDouble("time_spent"),
                                LocalDateTime.of(rs.getDate("time_estimated").toLocalDate(), rs.getTime("time_estimated").toLocalTime()),
                                LocalDateTime.of(rs.getDate("created_on_date").toLocalDate(), rs.getTime("created_on_date").toLocalTime()),
                                null/*rs.getInt("type")*/);
                    }
                });

        for(TaskAttribute taskAttribute: strLst){
            System.out.println(taskAttribute);
        }

        return strLst;
    }

    @Override
    public TaskAttribute getTask(long id) {
        return null;
    }

    @Override
    public void deleteTask(long idTask) {

    }

}
