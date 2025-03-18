package com.treinamento.javaspring.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.javaspring.auth.entity.User;
import com.treinamento.javaspring.auth.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/info")
    public User getUserDetails(){
        String userName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userRepo.findByUsername(userName).get();
    }

}
