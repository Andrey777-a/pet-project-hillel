package com.example.springhillel.api.service;

import com.example.springhillel.model.entity.ActionPoint;

public interface ActionPointService {

    void createActionPoint(ActionPoint actionPoint);
    void deleteActionPoint(long id);

}
