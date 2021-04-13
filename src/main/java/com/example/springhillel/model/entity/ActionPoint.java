package com.example.springhillel.model.entity;


import com.example.springhillel.model.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Data
@Entity
@Table(name = "action_point")
public class ActionPoint extends AbstractEntity {

    @Column(name = "name")
    private String name;

    public ActionPoint(String name) {
        this.name = name;
    }
}
