package com.scaler.basicapp;

import com.scaler.basicapp.pojos.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    List<Task> taskList = new ArrayList<>();

    @PostMapping("/")
    public Task createTasks(@RequestBody Task task){
        taskList.add(task);
        return task;
    }

    @GetMapping("/")
    public List<Task> getTasks(){
        return taskList;
    }

    @GetMapping("/completed")
    public List<Task> GetAllTasksCompleted(){
        List<Task> filteredList = new ArrayList<>();

        taskList.forEach(
                task -> {
                    if(task.isCompleted()){
                        filteredList.add(task);
                    }
                }
        );

        if(filteredList.isEmpty()){
            throw new RuntimeException("Completed tasks not found");
        }

        return filteredList;
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") int id){

        if(taskList.isEmpty() || taskList.size()<=id){
            throw new RuntimeException("tasklist is either empty or id doesn't exist");
        }

       return taskList.get(id);
        

    }

    @PatchMapping(path = "/{id}")
    public Task editTasks(@PathVariable("id") int id ,@RequestBody Task patch){

        if(taskList.isEmpty() || taskList.size()<=id){
            throw new RuntimeException("tasklist is either empty or id doesn't exist");
        }

        Task task = taskList.get(id);
        task.setId(patch.getId());
        task.setTitle(patch.getTitle());
        task.setDescription(patch.getDescription());
        task.setDeadline(patch.getDeadline());
        task.setNotes(patch.getNotes());
        task.setCompleted(patch.isCompleted());

        return task;

    }

    @DeleteMapping(path = "/{id}")
    public String deleteTask(@PathVariable("id") int id){
        if(taskList.isEmpty() || taskList.size()<=id){
            throw new RuntimeException("tasklist is either empty or id doesn't exist");
        }

        taskList.remove(id);

        return "task deleted";
    }
}
