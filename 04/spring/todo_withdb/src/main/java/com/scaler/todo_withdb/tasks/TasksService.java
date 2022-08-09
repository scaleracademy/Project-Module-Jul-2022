package com.scaler.todo_withdb.tasks;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TasksService {
    private TasksRepository tasksRepository;
    private ModelMapper modelMapper;

    public TasksService(TasksRepository tasksRepository, ModelMapper modelMapper) {
        this.tasksRepository = tasksRepository;
        this.modelMapper = modelMapper;
    }

    public List<TaskDto> getAllTasks(){
        return tasksRepository.findAll()
                .stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
    }

    public TaskDto getTaskByID(Long id){
        var task =  tasksRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        return modelMapper.map(task, TaskDto.class);
    }

    public TaskDto createNewTask(TaskDto task){
        if (task.getDueDate() != null && task.getDueDate().before(new Date())){
            throw new TaskDataInvalidException("Due date must be in future");
        }
        var taskEntity = modelMapper.map(task, TaskEntity.class);
        var savedTask = tasksRepository.save(taskEntity);
        return modelMapper.map(savedTask, TaskDto.class);
    }

    static class TaskNotFoundException extends IllegalArgumentException{
        public TaskNotFoundException(Long id){
            super("Task with id " + id + "not found.");
        }
    }

    static class TaskAlreadyExistsException extends IllegalArgumentException{
        public TaskAlreadyExistsException(Long id){
            super("Task with id " + id + "not found.");
        }
    }

    static class TaskDataInvalidException extends IllegalArgumentException{
        public TaskDataInvalidException(String message){
            super(message);
        }
    }

}