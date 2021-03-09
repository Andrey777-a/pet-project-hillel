package com.example.springhillel.repository;

import com.example.springhillel.model.StatusTask;
import com.example.springhillel.model.TaskAttribute;
import com.example.springhillel.model.TypeTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class JdbcTaskRepositoryImpl implements TaskRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createTask(TaskAttribute taskAttribute) {
        jdbcTemplate.update("insert into task_user (name, description, assignee, status, priority, time_spent, " +
                        "time_estimated, created_on_date, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)",
                taskAttribute.getName(), taskAttribute.getDescription(), taskAttribute.getAssignee(),
                taskAttribute.getStatus().getAssign(), taskAttribute.getPriority(), taskAttribute.getTimeSpent(),
                taskAttribute.getTimeEstimated(), LocalDateTime.now(), taskAttribute.getTypeTask().getType());
    }

    @Override
    public void updateTask(TaskAttribute taskAttribute) {
        jdbcTemplate.update("UPDATE task_user SET description = ?, status = ?, priority = ?, time_spent = ? " +
                        "where id = ?", taskAttribute.getDescription(), taskAttribute.getStatus().getAssign(), taskAttribute.getPriority(),
                taskAttribute.getTimeSpent(), taskAttribute.getId());
    }

    @Override
    public List<TaskAttribute> getTaskUser(int user) {

        List<TaskAttribute> strLst  = jdbcTemplate.query("select * from task_user where assignee = " + user,
                new RowMapper<TaskAttribute>() {
                    @Override
                    public TaskAttribute mapRow(ResultSet rs, int i) throws SQLException {
                        return new TaskAttribute(rs.getString("name"), rs.getString("description"),
                                rs.getInt("assignee"), StatusTask.valueOf(rs.getString("status")), rs.getInt("priority"),
                                rs.getDouble("time_spent"),
                                LocalDateTime.of(rs.getDate("time_estimated").toLocalDate(), rs.getTime("time_estimated").toLocalTime()),
                                LocalDateTime.of(rs.getDate("created_on_date").toLocalDate(), rs.getTime("created_on_date").toLocalTime()),
                                TypeTask.valueOf(rs.getString("type")));
                    }
                });

        for(TaskAttribute taskAttribute: strLst){
            System.out.println(taskAttribute);
        }

        return strLst;
    }

}
