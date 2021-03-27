package com.example.springhillel.service;

import com.example.springhillel.model.dto.TaskAttributeDTO;
import com.example.springhillel.model.entity.TaskAttribute;

import java.util.List;

public interface TaskService {

    void createTask(TaskAttributeDTO taskAttribute);
    void updateTask(TaskAttribute taskAttribute);
    List<TaskAttribute> getTaskUser(int user);

}
