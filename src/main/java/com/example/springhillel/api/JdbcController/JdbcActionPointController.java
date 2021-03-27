package com.example.springhillel.api.JdbcController;

import com.example.springhillel.model.entity.ActionPoint;
import com.example.springhillel.service.ActionPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jdbc")
public class JdbcActionPointController {


    @Qualifier("jdbcActionPointServiceImpl")
    @Autowired
    private ActionPointService actionPointService;

    @PostMapping("/addActionPoint")
    public void createActionPoint(@RequestBody ActionPoint actionPoint){
        actionPointService.createActionPoint(actionPoint);
    }

    @DeleteMapping("/deleteActionPont/{id}")
    public void deleteActionPoint(@PathVariable long id){
        actionPointService.deleteActionPoint(id);
    }


}
