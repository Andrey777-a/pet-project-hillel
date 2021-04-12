package com.example.springhillel.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long id;

    private String firstName;

    private String lastName;

    private String password;

    @Email(message = "Email is not correct")
    private String email;

    private long roleId;

    public UserDTO(String firstName, String lastName, String email, String password, long roleId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
    }

}
