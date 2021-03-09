package com.example.springhillel.api;

import com.example.springhillel.model.TaskAttribute;
import com.example.springhillel.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @PostMapping("/createTask")
    public void createTask(@RequestBody TaskAttribute taskAttribute) {

        taskRepository.createTask(taskAttribute);

    }

    @PutMapping("/updateTask")
    public void updateTask(@RequestBody TaskAttribute taskAttribute) {

        taskRepository.updateTask(taskAttribute);

    }

    @GetMapping("/getTaskUser/{id}")
    public void getTaskUser(@PathVariable int id) {

        taskRepository.getTaskUser(id);

    }

}
