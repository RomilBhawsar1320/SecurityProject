package com.example.SecurityProject.controller;

import com.example.SecurityProject.exception.DuplicateUserException;
import com.example.SecurityProject.model.User;
import com.example.SecurityProject.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> createUser(@RequestBody User user){

        try {
            myUserService.createUser(user);

            return new ResponseEntity<>("user created", HttpStatus.OK);
        } catch (DuplicateUserException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }


    }



}
