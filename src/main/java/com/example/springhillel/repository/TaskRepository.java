package com.example.springhillel.repository;

import com.example.springhillel.model.dto.TaskAttributeDTO;
import com.example.springhillel.model.entity.TaskAttribute;

import java.util.List;

public interface TaskRepository {

    void createTask(TaskAttributeDTO taskAttribute);
    void updateTask(TaskAttribute taskAttribute);
    List<TaskAttribute> getTaskUser(int user);
    TaskAttribute getTask(long id);
    void deleteTask(long idTask);

}
