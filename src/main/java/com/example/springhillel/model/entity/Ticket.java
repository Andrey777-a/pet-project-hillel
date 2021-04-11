package com.example.springhillel.model.entity;

import com.example.springhillel.model.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ticket_user")
public class Ticket extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private StatusTicket status;

    @Column(name = "priority")
    private int priority;

    @Column(name = "time_spent")
    private double timeSpent;

    @Column(name = "time_estimated")
    private LocalDateTime timeEstimated;

    @Column(name = "created_on_date")
    private LocalDateTime createdOnDate;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private TypeTicket typeTicket;


    public Ticket(String name, String description, User assignee, StatusTicket status, int priority,
                  double timeSpent, LocalDateTime timeEstimated, LocalDateTime createdOnDate,
                  TypeTicket typeTicket) {
        this.name = name;
        this.description = description;
        this.user = assignee;
        this.status = status;
        this.priority = priority;
        this.timeSpent = timeSpent;
        this.timeEstimated = timeEstimated;
        this.createdOnDate = createdOnDate;
        this.typeTicket = typeTicket;
    }

}
