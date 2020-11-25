package com.kubilaycicek.todo.model;

import com.kubilaycicek.todo.enums.Status;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "TODOS")
public class Todo extends BaseEntity {
    @NotBlank(message = "Title is mandatory")
    @Column(name = "title")
    private String title;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
