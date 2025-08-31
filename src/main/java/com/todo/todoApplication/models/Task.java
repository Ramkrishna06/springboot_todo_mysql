package com.todo.todoApplication.models;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Data;


@Entity
@Data
//@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private boolean completed;


}
