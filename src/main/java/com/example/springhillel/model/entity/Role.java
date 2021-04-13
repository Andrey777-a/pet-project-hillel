package com.example.springhillel.model.entity;

import com.example.springhillel.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "role")
public class Role extends AbstractEntity {


    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "role_action_point",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "action_point_id")
    )
    private List<ActionPoint> actionPoints;

    public Role(String name) {
        this.name = name;
    }

}
