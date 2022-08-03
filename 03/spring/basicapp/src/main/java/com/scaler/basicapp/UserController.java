package com.scaler.basicapp;

import com.scaler.basicapp.pojos.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController("/users")
@RequestMapping("/users")
public class UserController {

    private ArrayList<User> users = new ArrayList<>();

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        users.add(user);
        return user;
    }

    @GetMapping("/")
    public ArrayList<User> getUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") int id) {
        return users.get(id);
    }


}
