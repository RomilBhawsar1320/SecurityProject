package com.example.SecurityProject.controller;

import com.example.SecurityProject.model.User;
import com.example.SecurityProject.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final MyUserService myUserService;

    @PostMapping
    public String createUser(@RequestBody User user){

        myUserService.createUser(user);

        return "user created";



    }



}
