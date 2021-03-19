package com.example.springhillel.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRoleClass {

    private int id;
    private User userId;
    private UserRole userRole;

    public UserRoleClass(User userId, UserRole userRole) {
        this.userId = userId;
        this.userRole = userRole;
    }
}
