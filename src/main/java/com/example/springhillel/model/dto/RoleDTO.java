package com.example.springhillel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private long id;

    private String name;

    public RoleDTO(String name) {
        this.name = name;
    }
}
