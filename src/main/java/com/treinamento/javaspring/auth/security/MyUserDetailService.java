package com.treinamento.javaspring.auth.security;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.treinamento.javaspring.auth.entity.User;
import com.treinamento.javaspring.auth.repository.UserRepository;

@Component
public class MyUserDetailService implements UserDetailsService{

    @Autowired private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userRes = userRepo.findByUsername(username);

        if(userRes.isEmpty())
            throw new UsernameNotFoundException("No user found with this username "+username);
        User user = userRes.get();
        return new
                org.springframework.security.core.userdetails.User(
                        username,
                        user.getPassword(),
                        Collections.singletonList(
                                new SimpleGrantedAuthority("ROLE_USER")
                        )
        );
    }
}
