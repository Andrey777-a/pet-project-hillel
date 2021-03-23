package com.example.springhillel.repository;

import com.example.springhillel.model.entity.ActionPoint;

public interface ActionPointRepository {

    void createActionPoint(ActionPoint actionPoint);
    void deleteActionPoint(long id);

}
