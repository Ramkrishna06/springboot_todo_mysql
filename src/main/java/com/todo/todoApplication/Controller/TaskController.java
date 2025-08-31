package com.todo.todoApplication.Controller;


import com.todo.todoApplication.models.Task;
import com.todo.todoApplication.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@Controller
@RequestMapping("/")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping()  //root url for get
    public String getTask(Model model) {
        List<Task> tasks = taskService.getAllTask();
        model.addAttribute("tasks", tasks);  // ✅ correct method
        return "sun";
         //return tasks1;//returns tasks.html or tasks.jsp from templates
    }


    @PostMapping()  //root url for post
    public String createTask(@RequestParam String title) {
        taskService.createTask(title);
        return "redirect:/";// it will redirect to the root url of application(it tells   go to root url(/) via get request
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/";
    }

}
