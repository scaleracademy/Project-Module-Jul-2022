package com.scaler.basicapp;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class HelloController {

    private ArrayList<String> list = new ArrayList<String>();

    @GetMapping("/hello/{id}")
    public String hello(@PathVariable String id) {
        if (list.isEmpty()) {
            return "Hello World!";
        }

        String greeting = list.get(Integer.parseInt(id));

        return greeting;
    }

    @PostMapping("/greetings")
    public void greetings(@RequestParam String greeting) {
        System.out.println("greeting submitted: " + greeting);
        list.add(greeting);
    }

}
