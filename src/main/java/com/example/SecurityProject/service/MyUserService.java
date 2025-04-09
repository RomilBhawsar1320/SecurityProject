package com.example.SecurityProject.service;

import com.example.SecurityProject.exception.DuplicateUserException;
import com.example.SecurityProject.model.User;
import com.example.SecurityProject.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MyUserService {

    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10);

    public MyUserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public void createUser(User user) throws DuplicateUserException {
        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        } catch (Exception e) {
            throw new DuplicateUserException("user"+user.getUsername()+"already exists");
        }
    }


}
