package com.todo.todoApplication.repository;

import com.todo.todoApplication.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface Taskrepository extends JpaRepository<Task,Long>{

}
