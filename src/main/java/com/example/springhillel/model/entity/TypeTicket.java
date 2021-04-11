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
@Table(name = "type_ticket")
public class TypeTicket extends AbstractEntity {

    @Column(name = "name")
    private String name;


}
