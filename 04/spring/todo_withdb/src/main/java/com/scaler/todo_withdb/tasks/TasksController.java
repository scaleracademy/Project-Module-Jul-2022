package com.scaler.todo_withdb.tasks;

import com.scaler.todo_withdb.common.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

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
    void updateTaskById() {
    }

    @ExceptionHandler({
            TasksService.TaskNotFoundException.class,
            TasksService.TaskAlreadyExistsException.class,
            TasksService.TaskInvalidException.class
    })
    ResponseEntity<ErrorResponseDto> handleError(Exception e) {
        HttpStatus errorStatus;

        if (e instanceof TasksService.TaskNotFoundException) {
            errorStatus = HttpStatus.NOT_FOUND;
        } else if (e instanceof TasksService.TaskAlreadyExistsException) {
            errorStatus = HttpStatus.CONFLICT;
        } else if (e instanceof TasksService.TaskInvalidException) {
            errorStatus = HttpStatus.BAD_REQUEST;
        } else {
            errorStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity
                .status(errorStatus)
                .body(new ErrorResponseDto(e.getMessage()));
    }
}
