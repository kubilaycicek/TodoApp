package com.kubilaycicek.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kubilaycicek.todo.enums.Role;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {


    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Todo.class, mappedBy = "user")
    public List<Todo> todoList = new ArrayList<>();
}
