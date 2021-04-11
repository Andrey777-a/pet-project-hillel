package com.example.springhillel.api.service.jpaservice;

import com.example.springhillel.model.entity.ActionPoint;

public interface ActionPointService {

    void createActionPoint(ActionPoint actionPoint);
    void deleteActionPoint(long id);

}
