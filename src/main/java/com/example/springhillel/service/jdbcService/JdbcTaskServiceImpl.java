package com.example.springhillel.service.jdbcService;

import com.example.springhillel.model.dto.TaskAttributeDTO;
import com.example.springhillel.model.entity.TaskAttribute;
import com.example.springhillel.model.entity.User;
import com.example.springhillel.repository.TaskRepository;
import com.example.springhillel.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class JdbcTaskServiceImpl implements TaskService {

    @Qualifier("jdbcTaskRepositoryImpl")
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void createTask(TaskAttributeDTO taskAttribute) {
        taskRepository.createTask(taskAttribute);
    }

    @Override
    @Transactional
    public void updateTask(TaskAttribute taskAttribute) {
        taskRepository.updateTask(taskAttribute);
    }

    @Override
    @Transactional
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
