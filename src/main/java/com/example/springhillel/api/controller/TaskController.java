package com.example.springhillel.api.controller;

import com.example.springhillel.model.dto.TaskAttributeDTO;
import com.example.springhillel.model.entity.TaskAttribute;
import com.example.springhillel.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Qualifier("taskServiceImpl")
    @Autowired
    private TaskService taskService;

    @PostMapping
    public void createTask(@RequestBody TaskAttributeDTO taskAttribute) {

        taskService.createTask(taskAttribute);

    }

    @PutMapping
    public void updateTask(@RequestBody TaskAttribute taskAttribute) {

        taskService.updateTask(taskAttribute);

    }

    @GetMapping("/get-task-user/{id}")
    public List<TaskAttribute> getTaskUser(@PathVariable int id) {

        return taskService.getTaskUser(id);

    }

    @GetMapping("/get-task/{id}")
    public TaskAttribute getTask(@PathVariable long id) {

        return taskService.getTask(id);

    }

    @PutMapping("/{idTask}")
    public void deleteTask(@PathVariable long idTask) {

        taskService.deleteTask(idTask);

    }

}
