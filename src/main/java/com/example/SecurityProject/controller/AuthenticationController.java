package com.example.SecurityProject.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@Slf4j
public class AuthenticationController {

    @PostMapping("/login")
    public String login(@RequestBody UserRequest user){

        log.info("user details "+user);
        return "login successful";
    }

    public record UserRequest(String username, String password){}
}
