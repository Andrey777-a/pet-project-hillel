package com.example.springhillel.api.JdbcController;

import com.example.springhillel.model.entity.TaskAttribute;
import com.example.springhillel.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jdbc")
public class JdbcTaskController {

    @Qualifier("jdbcTaskServiceImpl")
    @Autowired
    private TaskService taskService;

    @PostMapping("/createTask")
    public void createTask(@RequestBody TaskAttribute taskAttribute) {

        taskService.createTask(taskAttribute);

    }

    @PutMapping("/updateTask")
    public void updateTask(@RequestBody TaskAttribute taskAttribute) {

        taskService.updateTask(taskAttribute);

    }

    @GetMapping("/getTaskUser/{id}")
    public List<TaskAttribute> getTaskUser(@PathVariable int id) {

        return taskService.getTaskUser(id);

    }

}
