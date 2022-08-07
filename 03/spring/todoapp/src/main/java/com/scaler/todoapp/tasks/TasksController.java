package com.scaler.todoapp.tasks;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashSet;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("/")
    public HashSet<TaskEntity> getAllTasks() {
        return tasksService.getAllTasks();
    }

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED, reason = "Created")
    public void createTask(@RequestBody CreateTaskRequest request) throws ParseException {

        /** // TODO: Self - implement Date formatter
         * Use JsonFormatter Annotation in CreateRequest dto
         * This also fixed the incorrect date in Response (even though
         * in tasks object it was correct).
        */

        tasksService.createTask(request.getName(), request.getDueDate());
        // TODO: respond with 201 Created - Completed
    }
}
