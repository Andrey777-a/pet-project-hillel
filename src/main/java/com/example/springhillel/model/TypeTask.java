package com.example.springhillel.model;

import lombok.Getter;
import lombok.Setter;

public enum TypeTask {

    USER_STORY("USER_STORY"),
    EPIC("EPIC"),
    SUP_TASK("SUP_TASK");

    @Getter
    @Setter
    String type;

    TypeTask(String type) {
        this.type = type;
    }

}
