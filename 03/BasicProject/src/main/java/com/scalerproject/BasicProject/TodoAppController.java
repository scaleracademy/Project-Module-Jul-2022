package com.scalerproject.BasicProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TodoAppController {
    ArrayList<Task> tasks = new ArrayList<Task>();
    HashMap<String, TaskDetails> alltaskdetails = new HashMap<String, TaskDetails>();

    @GetMapping("/todo/tasks")
    public ArrayList<Task> getAllTask(){
        return tasks;
    }

    @GetMapping("/todo/tasks/{id}")
    public Task getTask(@PathVariable String id){

        for(int i = 0; i < tasks.size(); i++)
        {
            if(tasks.get(i).getId() == id) return tasks.get(i);
        }
        return null;
    }

    @GetMapping("/todo/tasks/{id}?notes=true")
    public TaskDetails getTaskDetail(@PathVariable String id){
        if(alltaskdetails.containsKey(id)) return alltaskdetails.get(id);
        return null;
    }

    @GetMapping("/todo/tasks/{id}/notes")
    public ArrayList<Note> getTaskNotes(@PathVariable String id){
        if(alltaskdetails.containsKey(id)) return alltaskdetails.get(id).getTaskNotes();
        return null;
    }
}
