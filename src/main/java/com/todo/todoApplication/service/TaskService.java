package com.todo.todoApplication.service;

import com.todo.todoApplication.models.Task;
import com.todo.todoApplication.repository.Taskrepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
//@NoArgsConstructor
//@AllArgsConstructor
public class TaskService {

    //@Autowired
    private final Taskrepository taskrepository;

    public TaskService(Taskrepository taskrepository) {
        this.taskrepository = taskrepository;
    }

    public List<Task> getAllTask() {

        return taskrepository.findAll();
    }

    public void createTask(String title) {
        Task task =new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskrepository.save(task);
    }

    public void deleteTask(Long id) {
         taskrepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskrepository.findById(id).orElseThrow( () -> new IllegalArgumentException("invalid id"));
        task.setCompleted(!task.isCompleted());
        taskrepository.save(task);


    }
}
