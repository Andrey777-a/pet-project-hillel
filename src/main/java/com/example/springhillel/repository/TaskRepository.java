package com.example.springhillel.repository;

import com.example.springhillel.model.entity.TaskAttribute;

import java.util.List;

public interface TaskRepository {

    void createTask(TaskAttribute taskAttribute);
    void updateTask(TaskAttribute taskAttribute);
    List<TaskAttribute> getTaskUser(int user);

}
