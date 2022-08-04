package com.scaler.basicapp;

import com.scaler.basicapp.pojos.Note;
import com.scaler.basicapp.pojos.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController("/tasks")
@RequestMapping("/tasks")
public class TaskController {
    private ArrayList<Task> tasks = new ArrayList<Task>();

    @PostMapping //Can skip the route, defaults to parent route
    public Task createTask(@RequestBody Task task){
        tasks.add(task);
        return task;
    }

    @GetMapping
    public ArrayList<Task> getTasks(){
        return tasks;
    }

    @GetMapping("/{task_id}")
    public Task getTask(@PathVariable("task_id") int task_id){
        if(task_id >= tasks.size() || task_id < 0){
            return null;
        }
        return tasks.get(task_id);
    }

    @GetMapping("/{task_id}/notes")
    public ArrayList<Note> getNotes(@PathVariable("task_id") int task_id){
        if(task_id >= tasks.size() || task_id < 0){
            return null;
        }
        return tasks.get(task_id).getNotes();
    }

    @GetMapping("/{task_id}/notes/{note_id}")
    public Note getNoteForTask(@PathVariable("task_id") int task_id, @PathVariable("note_id") int note_id){
        if(task_id >= tasks.size() || task_id < 0 || note_id >= tasks.get(task_id).getNotes().size() || note_id < 0){
            return null;
        }
        return tasks.get(task_id).getNotes().get(note_id);
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
