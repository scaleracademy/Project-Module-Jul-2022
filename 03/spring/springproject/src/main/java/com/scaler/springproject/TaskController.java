package com.scaler.springproject;

import com.scaler.springproject.pojos.Note;
import com.scaler.springproject.pojos.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController("/tasks")
@RequestMapping("/tasks")
public class TaskController {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    @PostMapping
    public Task createTask(@RequestBody Task task){
        tasks.add(task);
        return task;
    }

    @GetMapping
    public ArrayList<Task> getTasks(){
        return tasks;
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable("id") int id){
        return tasks.get(id);
    }

    @GetMapping("/{id}/notes")
    public ArrayList<Note> getNotes(@PathVariable("id") int id){
        return tasks.get(id).getNotes();
    }

    @PatchMapping("/{id}")
    public Task updateTask(@PathVariable("id") int id, @RequestBody Task newTask){
        Task task = tasks.get(id);

        if (newTask.getTitle() != null) task.setTitle(newTask.getTitle());

        if (newTask.getDeadline() != null) task.setDeadline(newTask.getDeadline());

        task.setCompleted(newTask.isCompleted()); //How to check if not sent?

        if (newTask.getDescription() != null) task.setDescription(newTask.getDescription());

        if (newTask.getNotes() != null) task.setNotes(newTask.getNotes());

        return task;
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable("id") int id){
        String deletedTaskTitle = tasks.get(id).getTitle();
        tasks.remove(id);
        return "Task '"+ deletedTaskTitle + "' was Deleted.";
    }
}
