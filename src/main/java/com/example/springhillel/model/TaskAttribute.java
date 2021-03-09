package com.example.springhillel.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
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

    public TaskAttribute() {
    }

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
}
