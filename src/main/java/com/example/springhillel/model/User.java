package com.example.springhillel.model;

import lombok.Data;

@Data
public class User {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private UserRole userRole;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    public User(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
