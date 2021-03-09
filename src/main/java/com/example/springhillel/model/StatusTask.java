package com.example.springhillel.model;

import lombok.Getter;
import lombok.Setter;


public enum StatusTask {

    IN_WORK("IN_WORK"),
    DONE("DONE"),
    HOLD("HOLD"),
    ASSIGN("ASSIGN");

    @Getter
    @Setter
    private String assign;

    StatusTask(String assign) {
        this.assign = assign;
    }
}
