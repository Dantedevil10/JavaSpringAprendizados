package com.treinamento.javaspring.auth.repository;

import org.springframework.stereotype.Repository;

import com.treinamento.javaspring.auth.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByUsername(String username);
}
