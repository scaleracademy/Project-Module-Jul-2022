package com.scaler.todo_withdb.tasks;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("")
    ResponseEntity<List<TaskDto>> getAllTasks() {
        var tasks = tasksService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("")
    ResponseEntity<TaskDto> createNewTask(@RequestBody TaskDto task) {
        var savedTask = tasksService.createNewTask(task);
        return ResponseEntity.created(URI.create("/tasks/" + savedTask.getId())).body(savedTask);
    }

    @GetMapping("/{id}")
    ResponseEntity<TaskDto> getTaskById(@PathVariable Long id) {
        var task = tasksService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PatchMapping("/{id}")
    void updateTaskById() {}
}
