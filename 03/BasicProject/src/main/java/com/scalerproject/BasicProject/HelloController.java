package com.scalerproject.BasicProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String hello(){
        return "Hello world";
    }

    @GetMapping("/api/hello/{id}")
    public String hello(@PathVariable String id){
        return "Hello world "+id;
    }
}
