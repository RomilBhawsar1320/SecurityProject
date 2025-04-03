package com.example.SecurityProject.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Cards {

    @GetMapping("/cards")
    public String getCards(HttpSession session){
        return "cards provided "+session.getId();
    }
}
