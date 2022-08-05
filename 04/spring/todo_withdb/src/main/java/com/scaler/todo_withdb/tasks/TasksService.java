package com.scaler.todo_withdb.tasks;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

    public List<TaskDto> getAllTasks() {
        return tasksRepository.findAll()
                .stream()
                .map(task -> modelMapper.map(task, TaskDto.class))
                .collect(Collectors.toList());
    }

    public TaskDto getTaskById(Long id) {
        var task = tasksRepository.findById(id).orElse(null);
        // TODO: handle not found exception
        return modelMapper.map(task, TaskDto.class);
    }

    public TaskDto createNewTask(TaskDto task) {
        var taskEntity = modelMapper.map(task, TaskEntity.class);
        var savedTask = tasksRepository.save(taskEntity);

        return modelMapper.map(savedTask, TaskDto.class);
    }
}
