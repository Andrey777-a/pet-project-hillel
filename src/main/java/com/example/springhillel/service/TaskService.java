package com.example.springhillel.service;

import com.example.springhillel.model.TaskAttribute;

import java.util.List;

public interface TaskService {

    void createTask(TaskAttribute taskAttribute);
    void updateTask(TaskAttribute taskAttribute);
    List<TaskAttribute> getTaskUser(int user);

}
