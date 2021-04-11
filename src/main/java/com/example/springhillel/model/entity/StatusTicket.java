package com.example.springhillel.model.entity;

import com.example.springhillel.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "status_ticket")
public class StatusTicket extends AbstractEntity {

    @Column(name = "name")
    private String name;

}
