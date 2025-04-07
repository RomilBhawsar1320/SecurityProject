package com.example.SecurityProject.service;

import com.example.SecurityProject.model.User;
import com.example.SecurityProject.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class MyUserService {

    private UserRepository userRepository;

    public MyUserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public void createUser(User user){
        userRepository.save(user);
    }


}
