package com.example.springhillel.model;

import lombok.Data;

@Data
public class UserRoleClass {

    private int id;
    private User userId;
    private UserRole userRole;

    public UserRoleClass() {
    }

    public UserRoleClass(User userId, UserRole userRole) {
        this.userId = userId;
        this.userRole = userRole;
    }
}
