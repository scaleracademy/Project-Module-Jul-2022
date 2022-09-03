package com.scaler.basicapp;
import com.scaler.basicapp.pojos.Notes;
import com.scaler.basicapp.pojos.Tasks;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class TaskController {

    private ArrayList<Tasks> tasks = new ArrayList<>();

//    private ArrayList<Notes> notes = new ArrayList<>();

    @PostMapping("/tasks")
    public Tasks createTask(@RequestBody Tasks task){
        tasks.add(task);
        return task;
    }


    @GetMapping("/tasks")
    public ArrayList<Tasks> getTasks(){
        System.out.println("The task list is :" +tasks);
        return tasks;
    }

    @GetMapping("/tasks/{id}")
    public Tasks getTask(@PathVariable("id") int id){
        return tasks.get(id);
    }

    @PostMapping("/tasks/{id}/notes")
    public Tasks createNotes(@PathVariable("id") int id, @RequestBody Notes note){
        tasks.get(id).setNotes(note);
        return tasks.get(id);
    }

    @GetMapping("/tasks/{id}/notes")
    public Notes getNotes(@PathVariable("id") int id){
        return tasks.get(id).getNotes();
    }

}
