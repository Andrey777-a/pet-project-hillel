package com.example.springhillel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionPointDTO {

    private long id;

    private String name;

    public ActionPointDTO(String name) {
        this.name = name;
    }
}
