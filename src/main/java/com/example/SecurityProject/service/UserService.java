package com.example.SecurityProject.service;

import com.example.SecurityProject.model.User;
import com.example.SecurityProject.model.UserPrinciple;
import com.example.SecurityProject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if(user == null){
            log.error("User not found : "+username);
            throw new UsernameNotFoundException("user"+username+"not found");
        }

        return new UserPrinciple(user);
    }
}
