package com.treinamento.javaspring.auth.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Depois Trocar o IDENTITY e Long por UUID
    private Long id;

    private String email;

    private String username;

    private String password;

    private String role;

}
