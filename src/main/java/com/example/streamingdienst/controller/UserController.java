package com.example.streamingdienst.controller;

import com.example.streamingdienst.model.Film;
import com.example.streamingdienst.model.User;
import com.example.streamingdienst.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    //GET

    //POST
    @PostMapping("/add")
    public String add( @RequestBody User user){
        userService.SaveFilm(user);
        return "user: " + user.getUserName() + " added";
    }

    //PUT

    //DELETE

}
