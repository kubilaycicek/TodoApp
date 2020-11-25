package com.kubilaycicek.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kubilaycicek.todo.enums.Role;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {


    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Username is mandatory")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Password is mandatory")
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Todo.class, mappedBy = "user")
    public List<Todo> todoList = new ArrayList<>();
}
