package com.treinamento.javaspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.javaspring.models.Produtos;
import com.treinamento.javaspring.repository.ProdutosRepository;

@Service
public class ProdutosService {
	
	@Autowired
	private ProdutosRepository repo;
	
	
	public Produtos save(Produtos produto) {
		return repo.save(produto);
	}
	public Produtos findById(Long id) {
		return repo.findById(id).orElse(null);
	}
	public List<Produtos> findAll() {
		return repo.findAll();
	}

}
