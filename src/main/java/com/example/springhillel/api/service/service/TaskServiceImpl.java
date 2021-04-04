package com.example.springhillel.api.service.service;

import com.example.springhillel.exception.NotFoundException;
import com.example.springhillel.model.dto.TaskAttributeDTO;
import com.example.springhillel.model.entity.TaskAttribute;
import com.example.springhillel.repository.TaskRepository;
import com.example.springhillel.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Qualifier("jpaTaskRepositoryImpl")
    @Autowired
    private TaskRepository jpaRepository;

    @Override
    @Transactional
    public void createTask(TaskAttributeDTO taskAttribute) {
        jpaRepository.createTask(taskAttribute);
    }

    @Override
    @Transactional
    public void updateTask(TaskAttribute taskAttribute) {

        jpaRepository.updateTask(taskAttribute);
    }

    @Override
    @Transactional
    public List<TaskAttribute> getTaskUser(int user) {
        return jpaRepository.getTaskUser(user);
    }

    @Override
    @Transactional
    public TaskAttribute getTask(long id) {

        validTask(id);

        return jpaRepository.getTask(id);

    }

    @Override
    @Transactional
    public void deleteTask(long idTask) {

        validTask(idTask);

        jpaRepository.deleteTask(idTask);
    }

    private void validTask(long idTask){
        TaskAttribute taskAttribute = jpaRepository.getTask(idTask);

        if(taskAttribute == null){
            throw new NotFoundException("Task not found");
        }
    }

}
