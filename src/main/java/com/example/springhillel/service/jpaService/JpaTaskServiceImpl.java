package com.example.springhillel.service.jpaService;

import com.example.springhillel.model.entity.TaskAttribute;
import com.example.springhillel.repository.TaskRepository;
import com.example.springhillel.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JpaTaskServiceImpl implements TaskService {

    @Qualifier("jpaTaskRepositoryImpl")
    @Autowired
    private TaskRepository jpaRepository;

    @Override
    @Transactional
    public void createTask(TaskAttribute taskAttribute) {
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
}
