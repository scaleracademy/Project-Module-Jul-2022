package com.scaler.todo_withdb.tasks;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping
    ResponseEntity<List<TaskEntity>> getAllTasks(){
        var tasks = tasksService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }


}
