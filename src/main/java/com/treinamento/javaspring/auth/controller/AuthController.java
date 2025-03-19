package com.treinamento.javaspring.auth.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.javaspring.auth.entity.User;
import com.treinamento.javaspring.auth.model.LoginCreds;
import com.treinamento.javaspring.auth.repository.UserRepository;
import com.treinamento.javaspring.auth.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Map<String, Object> registerHandler(@RequestBody User user){
        String encodedPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPass);

        // Define a role padrão como USER
        if (user.getRole() == null) {
            user.setRole("ROLE_USER");
        }

        user = userRepo.save(user);

        String token = jwtUtil.generateToken(user.getUsername());
        return Collections.singletonMap("jwt-token",token);
    }

    @PostMapping("/login")
    public Map<String,Object> loginHandler(@RequestBody LoginCreds body){
        try{
            UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(body.getUsername(), body.getPassword());
            authenticationManager.authenticate(authInputToken);

            String token = jwtUtil.generateToken(body.getUsername());
            return Collections.singletonMap("jwt-token",token);
        } catch(AuthenticationException authExc){
            throw new RuntimeException("Invalid username/password.");
        }

    }

}
