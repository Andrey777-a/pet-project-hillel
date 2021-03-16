package com.example.springhillel.service;

import com.example.springhillel.model.TaskAttribute;
import com.example.springhillel.model.User;
import com.example.springhillel.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createTask(TaskAttribute taskAttribute) {
        taskRepository.createTask(taskAttribute);
    }

    @Override
    public void updateTask(TaskAttribute taskAttribute) {
        taskRepository.updateTask(taskAttribute);
    }

    @Override
    public List<TaskAttribute> getTaskUser(int userId) {

        if(isExitTaskUser(userId)){
            return taskRepository.getTaskUser(userId);
        }else {
//            надо написать исключение
        }

        return new ArrayList<>();
    }

    private boolean isExitTaskUser(int userId){
        boolean isExits = false;

        List<User> user =jdbcTemplate.query("select * from user where id = ?",
                preparedStatement -> preparedStatement.setInt(1, userId),
                (ResultSet resultSet, int i) -> new User(resultSet.getInt("id")));

        if (user.size()==1){
            isExits = true;
        } else {
            log.info("User is not found");
        }
        return isExits;
    }

}
