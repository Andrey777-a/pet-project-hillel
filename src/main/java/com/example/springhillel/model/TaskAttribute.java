package com.example.springhillel.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TaskAttribute {

    private int id;
    private String name;
    private String description;
    private int assignee;
    private StatusTask status;
    private int priority;
    private double timeSpent;
    private LocalDateTime timeEstimated;
    private LocalDateTime createdOnDate;
    private TypeTask typeTask;


    public TaskAttribute(String name, String description, int assignee, StatusTask status, int priority,
                         double timeSpent, LocalDateTime timeEstimated, LocalDateTime createdOnDate,
                         TypeTask typeTask) {
        this.name = name;
        this.description = description;
        this.assignee = assignee;
        this.status = status;
        this.priority = priority;
        this.timeSpent = timeSpent;
        this.timeEstimated = timeEstimated;
        this.createdOnDate = createdOnDate;
        this.typeTask = typeTask;
    }

    public TaskAttribute(int id, String name, String description, int assignee, StatusTask status, int priority,
                         double timeSpent, LocalDateTime timeEstimated, LocalDateTime createdOnDate,
                         TypeTask typeTask) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.assignee = assignee;
        this.status = status;
        this.priority = priority;
        this.timeSpent = timeSpent;
        this.timeEstimated = timeEstimated;
        this.createdOnDate = createdOnDate;
        this.typeTask = typeTask;
    }
}
