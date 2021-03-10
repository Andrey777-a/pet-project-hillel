package com.example.springhillel.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public enum UserRole {

    ADMIN("ADMIN"),
    DEVELOPER("DEVELOPER"),
    ANALYST("ANALYST");

    @Getter
    @Setter
    String role;

    UserRole(String role) {
        this.role = role;
    }
}
