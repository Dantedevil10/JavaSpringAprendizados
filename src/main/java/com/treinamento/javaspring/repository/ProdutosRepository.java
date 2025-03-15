package com.treinamento.javaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.javaspring.models.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

}
