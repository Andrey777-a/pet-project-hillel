package com.example.springhillel.model.entity;

import com.example.springhillel.model.AbstractEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*@NamedEntityGraph(
        name = "graph.User"//,
        *//*attributeNodes = {
                @NamedAttributeNode(value = "role")

        }*//*
)*/
/*@NamedEntityGraphs({
        @NamedEntityGraph(
                name = "graph.User",
                attributeNodes = {
                        @NamedAttributeNode(value = "firstName"*//*, subgraph = "verifierGraph"*//*)
                }*//*,
                subgraphs = {
                        @NamedSubgraph(
                                name = "verifierGraph",
                                type = User.class,
                                attributeNodes = {
                                        @NamedAttributeNode(value = "id"),
                                        @NamedAttributeNode(value = "firstName"),
                                        @NamedAttributeNode(value = "lastName")})}*//*
                                        )
})*/

/*@NamedEntityGraph(
        name = "UserRoleActionPoint", attributeNodes = @NamedAttributeNode(value = "role", subgraph = "sub.role")
        *//*,
        subgraphs = {
                @NamedSubgraph(name = "sub.role", attributeNodes = @NamedAttributeNode(value = "actionPoints"))
        }*//*
)*/


@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends AbstractEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    /*public User(long id) {
        this.id = id;
    }

    public User(long id, Role role) {
        this.id = id;
        this.role = role;
    }*/

    public User(String firstName, String lastName, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    public User(String firstName, String lastName, String password, String email, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
