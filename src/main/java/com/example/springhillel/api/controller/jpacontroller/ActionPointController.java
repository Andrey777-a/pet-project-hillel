package com.example.springhillel.api.controller.jpacontroller;

import com.example.springhillel.model.entity.ActionPoint;
import com.example.springhillel.api.service.jpaservice.ActionPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/action-point-not-use")
public class ActionPointController {

    @Qualifier("actionPointServiceImpl")
    @Autowired
    private ActionPointService actionPointService;

    @PostMapping
    public void createActionPoint(@RequestBody ActionPoint actionPoint){
        actionPointService.createActionPoint(actionPoint);
    }

    @DeleteMapping("/{id}")
    public void deleteActionPoint(@PathVariable long id){
        actionPointService.deleteActionPoint(id);
    }

}
