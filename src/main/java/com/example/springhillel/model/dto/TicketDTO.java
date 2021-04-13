package com.example.springhillel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {

    private long id;

    private String name;

    private String description;

    private long assignee;

    private long status;

    private int priority;

    private double timeSpent;

    private LocalDateTime timeEstimated;

    private LocalDateTime createdOnDate;

    private long typeTicket;


    public TicketDTO(String name, String description, long assignee, long status, int priority,
                     double timeSpent, LocalDateTime timeEstimated, LocalDateTime createdOnDate,
                     long typeTicket) {
        this.name = name;
        this.description = description;
        this.assignee = assignee;
        this.status = status;
        this.priority = priority;
        this.timeSpent = timeSpent;
        this.timeEstimated = timeEstimated;
        this.createdOnDate = createdOnDate;
        this.typeTicket = typeTicket;
    }

}
