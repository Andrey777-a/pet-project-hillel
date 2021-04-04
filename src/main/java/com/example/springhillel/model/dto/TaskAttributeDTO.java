package com.example.springhillel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskAttributeDTO {

    private long id;

    private String name;

    private String description;

    private long assignee;

    private int status;

    private int priority;

    private double timeSpent;

    private LocalDateTime timeEstimated;

    private LocalDateTime createdOnDate;

    private int typeTask;


    public TaskAttributeDTO(String name, String description, long assignee, int status, int priority,
                         double timeSpent, LocalDateTime timeEstimated, LocalDateTime createdOnDate,
                         int typeTask) {
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
