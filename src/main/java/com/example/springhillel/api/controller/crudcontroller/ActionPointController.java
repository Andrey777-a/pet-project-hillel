package com.example.springhillel.api.controller.crudcontroller;

import com.example.springhillel.api.controller.AbstractControllerImpl;
import com.example.springhillel.api.service.crudservice.ActionPointService;
import com.example.springhillel.model.dto.ActionPointDTO;
import com.example.springhillel.model.entity.ActionPoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("actionPointControllerCrud")
@RequestMapping("/action-point")
public class ActionPointController extends AbstractControllerImpl<ActionPoint, ActionPointDTO, ActionPointService> {
}
