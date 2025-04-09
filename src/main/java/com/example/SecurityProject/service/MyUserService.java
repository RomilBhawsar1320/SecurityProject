package com.example.SecurityProject.service;

import com.example.SecurityProject.model.User;
import com.example.SecurityProject.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

    public MyUserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public void createUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }


}
