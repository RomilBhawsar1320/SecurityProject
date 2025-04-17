package com.example.SecurityProject.listener;

import com.example.SecurityProject.exception.DuplicateUserException;
import com.example.SecurityProject.model.User;
import com.example.SecurityProject.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class  ApplicationEventListener {
    @Autowired
    private MyUserService myUserService;

    @EventListener(ApplicationReadyEvent.class)
    public void handleEvent(ApplicationEvent event){
        System.out.println("recieved event"+ event);
        initializeUsers();
    }

    public void initializeUsers(){
        try {
            myUserService.createUser(new User("sunil","s@123"));
            myUserService.createUser(new User("romil","r@123"));
            myUserService.createUser(new User("priyanshi","p@123"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
