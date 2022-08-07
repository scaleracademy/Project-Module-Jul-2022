package com.scaler.todo_withdb.tasks;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {
    private TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<TaskEntity> getAllTasks(){
        return tasksRepository.findAll();
    }

}
