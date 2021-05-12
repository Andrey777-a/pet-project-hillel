package com.example.springhillel.api.service.crudservice;

import com.example.springhillel.AbstractIntegrationTest;
import com.example.springhillel.model.entity.ActionPoint;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Slf4j
class ActionPointServiceIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private ActionPointService actionPoint;

    @Test
    public void testFindByIdIntegrationActionPoint(){
        Optional<ActionPoint> actionPointService = actionPoint.findById(1);

        Assertions.assertEquals("VIEW_TICKET", actionPointService.get().getName());

    }

    @Test
    public void testGetAllIntegrationActionPoint(){

        List<ActionPoint> actionPointService = actionPoint.getAll();

        Assertions.assertFalse(actionPointService.isEmpty());
        Assertions.assertEquals(5, actionPointService.size());
        Assertions.assertEquals("ADD_USER", actionPointService.get(1).getName());

    }

}