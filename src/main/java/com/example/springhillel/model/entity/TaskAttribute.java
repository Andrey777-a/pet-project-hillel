package com.example.springhillel.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task_user")
public class TaskAttribute {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(name = "status_id")
    private int status;

    @Column(name = "priority")
    private int priority;

    @Column(name = "time_spent")
    private double timeSpent;

    @Column(name = "time_estimated")
    private LocalDateTime timeEstimated;

    @Column(name = "created_on_date")
    private LocalDateTime createdOnDate;

    @Column(name = "type_id")
    private int typeTask;


    public TaskAttribute(String name, String description, User assignee, int status, int priority,
                         double timeSpent, LocalDateTime timeEstimated, LocalDateTime createdOnDate,
                         int typeTask) {
        this.name = name;
        this.description = description;
        this.user = assignee;
        this.status = status;
        this.priority = priority;
        this.timeSpent = timeSpent;
        this.timeEstimated = timeEstimated;
        this.createdOnDate = createdOnDate;
        this.typeTask = typeTask;
    }

}
