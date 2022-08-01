package com.scaler.basicapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello/{id}")
    public String hello(@PathVariable String id) {

        return "Hello World " + id + "!";
    }

}
