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

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private StatusTask status;

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
    private TypeTask typeTask;


    public TaskAttribute(String name, String description, User assignee, StatusTask status, int priority,
                         double timeSpent, LocalDateTime timeEstimated, LocalDateTime createdOnDate,
                         TypeTask typeTask) {
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
